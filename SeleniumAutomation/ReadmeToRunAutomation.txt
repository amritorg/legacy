Instructions on how to run the automation via command line

On Windows

1. Make sure you have java 1.7.x jdk in PATH system variable
2. Open a cmd window and run below command to check
3. java -version
4. Unzip the attached file named as "automation.zip" inside a system drive say C:\
5. Make sure there is folder like "C:\automation" and this folder contain all jars file
6. Navigate to "C:\automation\data" folder
7. Open "global.properties" file
8. Check environment inputs , there shouldn't be any need to change these inputs. If necessary "ApplicationUrl" input can be modified as per the need
9. Now open "DataTestScheduleWebinar.properties" file
10.Provide valid username and password info to login to GoToWebinar application
11. You can also change "x_days_from_now" input however right now it will only work if target date(day) is within current month. 

12. Now navigate to C:\automation folder
13. Run below command with all dependencies in class path

   c:\automation>java -cp schedule_webinar.jar;junit-4.10.jar;selenium-server-stand
alone-2.47.0.jar;commons-exec-1.3.jar toolkit.TestRunner

14. Above command should open chrome and run the "schedule webinar" test


----  Thank you for your time, I hope above worked -------
