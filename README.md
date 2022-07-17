# NYTArticles
Technology Assessment for Android Developer Role

Description
Build a simple app to hit the NY Times Most Popular Articles API and show a list of articles,
that shows details when items on the list are tapped (a typical master/detail app).
We'll be using the most viewed section of this API.
http://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?apikey=s
ample-key
To test this API, you can use all-sections for the section path component in the URL above
and 7 for period (available period values are 1, 7 and 30, which represents how far back, in
days, the API returns results for).

http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-
sections/7.json?apikey=sample-key

Steps to Build/Run Code:
 -Clone the repo and change the build config as below:
    - Android gradle plugin version: 7.2.1
    - Gradle Verson: 7.3.3
    - Compile SDK Version: 32
 -Clean the project & build
 
 
 Run Test Case:
 Right click on the "unitTest" section and clikc on Run Tests in 'NYArticles...' as below:
 
 <img width="506" alt="image" src="https://user-images.githubusercontent.com/8206573/179419715-614300b4-3661-47e6-8979-20974f5d410d.png">

After running the test, we can see below html report at app>build>reports>testDebugUnitTest>index.html

We can use "Run Tests in 'NYArticles...' with Coverage also to see coverage report.

We can other plugins also to have code converage report for tests.

<img width="1030" alt="image" src="https://user-images.githubusercontent.com/8206573/179419462-b00b7efc-ce70-48fc-9d94-238cd03d28a7.png">

Screenshots of the Build:

![image](https://user-images.githubusercontent.com/8206573/179419983-3798e5aa-7200-43c9-987b-0f0d26f2bc12.png) 

![image](https://user-images.githubusercontent.com/8206573/179420005-eeea0011-ec77-422b-9d47-90c1777a8a6c.png)





