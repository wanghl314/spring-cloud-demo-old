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
cd "${CURRENT_DIR}/.."
mvn clean package -DskipTests=true -pl com.whl.demo:demo-compound -am -U

SUCCESS=$?

if [ "${SUCCESS}"x != "0"x ]; then
    exit 1
fi

# start compound service
cd "${CURRENT_DIR}"
nohup java -jar target/demo-compound-1.0-SNAPSHOT.jar > nohup.out 2>&1 &

exit 0
