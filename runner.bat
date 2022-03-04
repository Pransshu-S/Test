@echo off
cls
echo Exporting your data....
cd D:\SPEG\AzureDevOps-UI
call mvn test -Dtest=ExportData
echo Press anything to exit.
pause >nul