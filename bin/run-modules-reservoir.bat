@echo off
echo.
echo [��Ϣ] ����modules-reservoir���̡�
echo.

cd %~dp0
cd ../cf-modules/cf-reservoir/target

set JAVA_OPTS=-Xms512m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -Dfile.encoding=utf-8 -jar %JAVA_OPTS% cf-modules-reservoir.jar

cd bin
pause
