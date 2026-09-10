#!/bin/bash
set -euo pipefail

JAR="target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar"
PORT=8081
PID_FILE=/tmp/app_it.pid
LOG_FILE=/tmp/app_it.log

if [ ! -f "$JAR" ]; then
  echo "JAR not found: $JAR"
  exit 1
fi

echo "Starting app for integration tests on port $PORT..."
nohup java -jar "$JAR" --server.port=$PORT > "$LOG_FILE" 2>&1 &
echo $! > "$PID_FILE"
APP_PID=$(cat "$PID_FILE")

echo "App PID: $APP_PID"
echo "Waiting for app to be ready..."

for i in {1..60}; do
  if curl -sSf "http://localhost:$PORT/test" >/dev/null 2>&1; then
    echo "App is ready"
    break
  fi
  sleep 1
  if ! kill -0 $APP_PID 2>/dev/null; then
    echo "App died. Logs:"
    cat "$LOG_FILE" || true
    exit 1
  fi
  if [ $i -eq 60 ]; then
    echo "Timeout. Logs tail:"
    tail -100 "$LOG_FILE" || true
    kill $APP_PID 2>/dev/null || true
    exit 1
  fi
done

echo "=== Running integration tests ==="

echo "1. GET /test"
RESP=$(curl -s "http://localhost:$PORT/test")
echo "$RESP"
[[ "$RESP" == *"Hello Kalyan. This is version 2"* ]] || { echo "FAIL /test"; exit 1; }

echo "2. GET /test2"
RESP=$(curl -s "http://localhost:$PORT/test2")
echo "$RESP"
[[ "$RESP" == *"Hello Kalyan2"* ]] || { echo "FAIL /test2"; exit 1; }

echo "3. POST /testpost"
RESP=$(curl -s -X POST -H "Content-Type: application/json" -d '{"firstName":"A","lastName":"B"}' "http://localhost:$PORT/testpost")
echo "$RESP"
[[ "$RESP" == *'"firstName":"A"'* && "$RESP" == *'"lastName":"B"'* ]] || { echo "FAIL /testpost"; exit 1; }

echo "4. GET / (home returns 200)"
STATUS=$(curl -s -o /dev/null -w "%{http_code}" "http://localhost:$PORT/")
echo "Home status: $STATUS"
[[ "$STATUS" == "200" ]] || { echo "FAIL home"; exit 1; }

echo "=== All integration tests PASSED ==="

kill $APP_PID 2>/dev/null || true
wait $APP_PID 2>/dev/null || true
rm -f "$PID_FILE" "$LOG_FILE" 2>/dev/null || true
exit 0
