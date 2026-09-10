#!/bin/bash
set -euo pipefail

JAR="target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar"
PORT=9093
PID_FILE="/tmp/app.pid"

echo "Starting app on port $PORT..."
java -jar "$JAR" > /tmp/app.log 2>&1 &
APP_PID=$!
echo $APP_PID > "$PID_FILE"
echo "App PID: $APP_PID"

# Wait for startup
for i in {1..30}; do
  if curl -sSf "http://localhost:$PORT/test" >/dev/null 2>&1; then
    echo "App is up (responded to /test)"
    break
  fi
  sleep 1
  if ! kill -0 $APP_PID 2>/dev/null; then
    echo "App process died. Log:"
    cat /tmp/app.log || true
    exit 1
  fi
done

echo "=== Smoke tests ==="
echo "GET /test:"
curl -s "http://localhost:$PORT/test" || true
echo
echo "GET /test2:"
curl -s "http://localhost:$PORT/test2" || true
echo
echo "GET / (home):"
curl -sI "http://localhost:$PORT/" || true
echo

echo "Stopping app..."
kill $APP_PID || true
wait $APP_PID 2>/dev/null || true
rm -f "$PID_FILE"
echo "Done. Log tail:"
tail -20 /tmp/app.log || true
