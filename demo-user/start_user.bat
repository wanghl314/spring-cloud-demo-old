@echo off
cd /d %~dp0
set "CURRENT_DIR=%cd%"

rem 打包
cd /d "%CURRENT_DIR%\.."
call mvn clean package -DskipTests=true -pl com.whl.demo:demo-user -am -U

if %errorlevel% == 0 goto startUserService
goto packageFailed

:packageFailed
goto end

:startUserService
rem start user service
cd /d "%CURRENT_DIR%"
start cmd /k java -jar "%CURRENT_DIR%\target\demo-user-1.0-SNAPSHOT.jar"
goto end

:end
pause
