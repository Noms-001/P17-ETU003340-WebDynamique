@echo off
REM ===========================================
REM Build Script to compile Java Servlet with Jakarta and MySQL Connector
REM ===========================================

REM Définir les variables
set SOURCE_DIR=src\main\java
set WEBAPP_DIR=src\main\webapp           
set CLASSES_DIR=src\main\webapp\WEB-INF\classes
set LIB_DIR=lib
set WAR_FILE=build\ETU003340.war

REM Créer le dossier build s'il n'existe pas
if not exist build (
    echo Création du dossier build...
    mkdir build
)

REM 1. Supprimer les anciens fichiers compilés (.class) dans WEB-INF/classes
echo Suppression des anciens fichiers compilés...
if exist %CLASSES_DIR% (
    rd /s /q %CLASSES_DIR%
)
mkdir %CLASSES_DIR%

REM 2. Compilation des fichiers Java avec Jakarta Servlet API et MySQL Connector
echo Compilation des fichiers source Java...
javac -cp "%LIB_DIR%\jakarta.servlet-api-6.1.0.jar;%LIB_DIR%\mysql-connector-java-9.0.0.jar" -d %CLASSES_DIR% %SOURCE_DIR%\*.java

REM 3. Créer le fichier WAR dans le dossier build
echo Creation du fichier WAR...
jar -cvf %WAR_FILE% -C %WEBAPP_DIR% .

REM 4. Placer le fichier WAR dans le dossier build
echo Deplacement du fichier WAR dans le dossier build...
move %WAR_FILE% build\

echo Build termine avec succes !
pause
