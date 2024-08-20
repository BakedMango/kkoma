#!/usr/bin/env bash

REPOSITORY=/home/ubuntu/kkoma
cd $REPOSITORY

APP_NAME=kkoma
JAR_NAME=$(ls $REPOSITORY/backend/build/libs/ | grep 'SNAPSHOT.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/backend/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할 애플리케이션이 없습니다."
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> Deploy - $JAR_PATH "
nohup java -jar -Dspring.profiles.active=production $JAR_PATH --spring.config.additional-location=file:application-env.properties > /home/ubuntu/log/nohup_log.out 2>&1 &