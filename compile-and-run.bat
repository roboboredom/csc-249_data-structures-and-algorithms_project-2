@echo off

echo Compiling project...
javac -d .\bin .\src\com\github\roboboredom\*.java

echo Running project...
java -cp .\bin com.github.roboboredom.Graph