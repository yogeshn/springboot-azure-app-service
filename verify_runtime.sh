#!/bin/bash
set -e
JAR="target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar"
if [ ! -f "$JAR" ]; then
  echo "JAR not found, building..."
  mvn clean package -DskipTests -B --no-transfer-progress
fi

echo "Starting app on port 8080..."
java -jar "$JAR" > app.log 2>&1 &
APP_PID=$!
echo "PID: $APP_PID"
sleep 8

echo "Checking health..."
curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/ || true
echo
curl -s http://localhost:8080/ | head -c 200 || true
echo
curl -s http://localhost:8080/test || true
echo
curl -s http://localhost:8080/test2 || true
echo
curl -s -X POST -H "Content-Type: application/json" -d '{"firstName":"Kal","lastName":"Yan"}' http://localhost:8080/testpost || true
echo

echo "Stopping app..."
kill $APP_PID || true
wait $APP_PID 2>/dev/null || true
echo "Runtime verification complete. See app.log for details."