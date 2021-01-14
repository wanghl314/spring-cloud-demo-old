@echo off
cd /d %~dp0
set "CURRENT_DIR=%cd%"

rem 打包
cd /d "%CURRENT_DIR%\.."
call mvn clean package -DskipTests=true -P allInOne -pl com.whl.demo:demo-boot -am -U

if %errorlevel% == 0 goto startBootService
goto packageFailed

:packageFailed
goto end

:startBootService
rem start boot service
cd /d "%CURRENT_DIR%"
start cmd /k java -jar target\demo-boot-1.0-SNAPSHOT.jar
goto end

:end
pause
