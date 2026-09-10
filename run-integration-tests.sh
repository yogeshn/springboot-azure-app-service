#!/bin/bash
set -euo pipefail

JAR="target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar"
PORT=9093
PID_FILE="/tmp/app-int.pid"

echo "Starting app for integration tests on port $PORT..."
java -jar "$JAR" > /tmp/app-int.log 2>&1 &
APP_PID=$!
echo $APP_PID > "$PID_FILE"

# Wait for startup
for i in {1..40}; do
  if curl -sSf "http://localhost:$PORT/test" >/dev/null 2>&1; then
    echo "App is up"
    break
  fi
  sleep 1
  if ! kill -0 $APP_PID 2>/dev/null; then
    echo "App died. Log:"
    cat /tmp/app-int.log || true
    exit 1
  fi
done

echo "=== Integration tests ==="
set +e
FAIL=0

echo "1) GET /test"
OUT=$(curl -s "http://localhost:$PORT/test")
echo "$OUT"
if [[ "$OUT" != *"Hello Kalyan. This is version 2"* ]]; then
  echo "FAIL: unexpected /test response"
  FAIL=1
fi

echo "2) GET /test2"
OUT2=$(curl -s "http://localhost:$PORT/test2")
echo "$OUT2"
if [[ "$OUT2" != *"Hello Kalyan2"* ]]; then
  echo "FAIL: unexpected /test2 response"
  FAIL=1
fi

echo "3) POST /testpost"
OUT3=$(curl -s -X POST -H "Content-Type: application/json" -d '{"firstName":"A","lastName":"B"}' "http://localhost:$PORT/testpost")
echo "$OUT3"
if [[ "$OUT3" != *'"firstName":"A"'* || "$OUT3" != *'"lastName":"B"'* ]]; then
  echo "FAIL: unexpected /testpost response"
  FAIL=1
fi

echo "4) GET / (home template)"
STATUS=$(curl -sI "http://localhost:$PORT/" | head -1 | tr -d '\r')
echo "$STATUS"
if [[ "$STATUS" != *"200"* && "$STATUS" != *"HTTP/1.1 200"* ]]; then
  echo "WARN: home may return non-200 if no template, but should not 5xx"
fi

if [ $FAIL -eq 0 ]; then
  echo "All integration checks passed."
else
  echo "Some integration checks failed."
fi

echo "Stopping app..."
kill $APP_PID || true
wait $APP_PID 2>/dev/null || true
rm -f "$PID_FILE"

exit $FAIL
