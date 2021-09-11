# ebay UI Web Automation Framework

## Introduction
This project is a demonstration of UI test automation framework for ebay.com.au application using Selenium framework. 
Java is chosen as a preffered language with Git as source control.

## Pre-requisites/Tools 
1. IDE - IntelliJ or Eclipse 2020 versions. 
2. Java 11 or higher should be installed. JUnit 5 is used as test framework.
3. All package dependencies are handled through pom.xml.

## Test configuration and data
1. Test data configuration is driven through devConfig.properties or uatConfig.properties files under the config directory. 
2. Browser drivers are located under the drivers directory

## Assumptions
1. Tests are assumed to be executed in CI/CD. This solution supports overriding the local config settings from CI server's environment variables.

## Test execution
The test framework is configured to use these default values:

    Environment = DEV
    Browser = Chrome 

Tests can be executed using JUnit test runner in IntelliJ IDE. 
Alternatively, the following command can execute the tests via cli using the default environment and browser. 

`mvn test`

Use the below command to override the default values (especially for test exeuction in CI) 

`mvn test -Denvironment=UAT -Dbrowser=edge`


After the test execution use the below command to generate default html report using surefire plugin. The location of the reports is "target/site/surefire-report.html"

`mvn surefire-report:report-only`