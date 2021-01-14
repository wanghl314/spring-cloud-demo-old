#!/bin/bash

PRG="$0"
while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done
PRGDIR=`dirname "$PRG"`
CURRENT_DIR=`cd "$PRGDIR">/dev/null; pwd`

# 打包
mvn clean package -DskipTests=true -pl com.whl.demo:demo-eureka,com.whl.demo:demo-feign,com.whl.demo:demo-log,com.whl.demo:demo-user,com.whl.demo:demo-compound -am -U

SUCCESS=$?

if [ "${SUCCESS}"x != "0"x ]; then
    exit 1
fi

echo "start eureka service"
cd "${CURRENT_DIR}/demo-eureka"
nohup java -jar target/demo-eureka-1.0-SNAPSHOT.jar > nohup.out 2>&1 &

echo "start log service"
cd "${CURRENT_DIR}/demo-log"
nohup java -jar target/demo-log-1.0-SNAPSHOT.jar > nohup.out 2>&1 &

echo "start user service"
cd "${CURRENT_DIR}/demo-user"
nohup java -jar target/demo-user-1.0-SNAPSHOT.jar > nohup.out 2>&1 &

echo "start compound service"
cd "${CURRENT_DIR}/demo-compound"
nohup java -jar target/demo-compound-1.0-SNAPSHOT.jar > nohup.out 2>&1 &

echo "start feign service"
cd "${CURRENT_DIR}/demo-feign"
nohup java -jar target/demo-feign-1.0-SNAPSHOT.jar > nohup.out 2>&1 &

exit 0
