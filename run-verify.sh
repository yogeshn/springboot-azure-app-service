#!/bin/bash
set -e
echo "JAVA_HOME=$JAVA_HOME"
java -version 2>&1 || true
mvn -version 2>&1 | head -3 || true
echo "Building jar..."
mvn clean package -DskipTests -B --no-transfer-progress -q
JAR=$(ls target/*.jar | head -1)
echo "JAR=$JAR"
if [ -z "$JAR" ]; then echo "no jar"; exit 1; fi
echo "Starting app in background..."
java -jar "$JAR" --server.port=0 > /tmp/app.log 2>&1 &
PID=$!
echo "PID=$PID"
sleep 8
PORT=$(grep -o 'Tomcat started on port.*' /tmp/app.log | grep -o '[0-9]*' | tail -1 || echo "")
if [ -z "$PORT" ]; then
  # try to find any port
  PORT=$(grep -oE 'port [0-9]+' /tmp/app.log | head -1 | awk '{print $2}' || echo "8080")
fi
echo "PORT=$PORT"
curl -s -o /tmp/out.txt -w "%{http_code}" "http://localhost:${PORT}/" || echo "curl / failed"
curl -s "http://localhost:${PORT}/test" || echo "curl /test failed"
curl -s "http://localhost:${PORT}/test2" || echo "curl /test2 failed"
curl -s -X POST -H "Content-Type: application/json" -d '{"firstName":"Kalyan","lastName":"Test"}' "http://localhost:${PORT}/testpost" || echo "curl post failed"
kill $PID 2>/dev/null || true
echo "=== APP LOG (tail) ==="
tail -30 /tmp/app.log || true
echo "Done"