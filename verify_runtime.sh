#!/bin/bash
set -euo pipefail

JAR="target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar"
PORT=8080
PID_FILE=/tmp/app.pid
LOG_FILE=/tmp/app.log

if [ ! -f "$JAR" ]; then
  echo "JAR not found: $JAR"
  exit 1
fi

echo "Starting app on port $PORT..."
nohup java -jar "$JAR" --server.port=$PORT > "$LOG_FILE" 2>&1 &
echo $! > "$PID_FILE"
APP_PID=$(cat "$PID_FILE")

echo "App PID: $APP_PID"
echo "Waiting for app to be ready..."

for i in {1..60}; do
  if curl -sSf "http://localhost:$PORT/test" >/dev/null 2>&1; then
    echo "App is ready (responded to /test)"
    break
  fi
  sleep 1
  if ! kill -0 $APP_PID 2>/dev/null; then
    echo "App process died. Logs:"
    cat "$LOG_FILE" || true
    exit 1
  fi
  if [ $i -eq 60 ]; then
    echo "Timeout waiting for app. Logs tail:"
    tail -100 "$LOG_FILE" || true
    kill $APP_PID 2>/dev/null || true
    exit 1
  fi
done

echo "=== Smoke tests ==="
echo "GET /test:"
curl -s "http://localhost:$PORT/test" && echo
echo "GET /test2:"
curl -s "http://localhost:$PORT/test2" && echo
echo "GET / (home):"
curl -sI "http://localhost:$PORT/" | head -5
echo "POST /testpost:"
curl -s -X POST -H "Content-Type: application/json" -d '{"firstName":"Kal","lastName":"Yan"}' "http://localhost:$PORT/testpost" && echo

echo "=== Verification complete ==="

kill $APP_PID 2>/dev/null || true
wait $APP_PID 2>/dev/null || true
echo "App stopped."
rm -f "$PID_FILE" "$LOG_FILE" 2>/dev/null || true
exit 0
