@echo off
cd /d %~dp0
set "CURRENT_DIR=%cd%"

rem 打包
call mvn clean package -DskipTests=true -pl com.whl.demo:demo-eureka,com.whl.demo:demo-feign,com.whl.demo:demo-log,com.whl.demo:demo-user,com.whl.demo:demo-compound -am -U

if %errorlevel% == 0 goto startAllMicroServices
goto packageFailed

:packageFailed
goto end

:startAllMicroServices
echo start eureka service
cd /d "%CURRENT_DIR%\demo-eureka"
start cmd /k java -jar target\demo-eureka-1.0-SNAPSHOT.jar

echo start log service
cd /d "%CURRENT_DIR%\demo-log"
start cmd /k java -jar target\demo-log-1.0-SNAPSHOT.jar"

echo start user service
cd /d "%CURRENT_DIR%\demo-user"
start cmd /k java -jar target\demo-user-1.0-SNAPSHOT.jar"

echo start compound service
cd /d "%CURRENT_DIR%\demo-compound"
start cmd /k java -jar target\demo-compound-1.0-SNAPSHOT.jar"

echo start feign service
cd /d "%CURRENT_DIR%\demo-feign"
start cmd /k java -jar target\demo-feign-1.0-SNAPSHOT.jar"

cd /d "%CURRENT_DIR%"
goto end

:end
pause
