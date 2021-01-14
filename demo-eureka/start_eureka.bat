@echo off
cd /d %~dp0
set "CURRENT_DIR=%cd%"

rem 打包
cd /d "%CURRENT_DIR%\.."
call mvn clean package -DskipTests=true -pl com.whl.demo:demo-eureka -am -U

if %errorlevel% == 0 goto startEurekaService
goto packageFailed

:packageFailed
goto end

:startEurekaService
rem start eureka service
cd /d "%CURRENT_DIR%"
start cmd /k java -jar "%CURRENT_DIR%\target\demo-eureka-1.0-SNAPSHOT.jar"
goto end

:end
pause
