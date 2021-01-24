# Sky Betting and Gaming Test Assessment

## Project Description:

This project is built in Datadriven framework with TestNG and Rest Assured in Java. Eclipse 2020-09 (4.17.0) is used as IDE. 

Framework: Data Driven Framework with TestNG

Language: Java 15.0.1

Automation: Rest Assured  

IDE: Eclipse 2020-09 (4.17.0)

## Instructions

1. Download Java from https://www.oracle.com/java/technologies/javase-downloads.html and install and set up environmental variables path 

2. Download eclipse from https://www.eclipse.org/downloads/ and install

3. For TestNG installation, follow instructions from https://www.lambdatest.com/blog/how-to-install-testng-in-eclipse-step-by-step-guide/

4. Download Maven from https://maven.apache.org/download.cgi and set the maven home path in the System variables to recognize maven. Add bin path of Maven to the 'Path' System Variable

5. Follow the instructions in the link to set up the Mock API Server - https://github.com/skybet/trading-tribe-technical-test-assessment

6. Clone the repository to your local host. 

7. Open eclipse editor and import cloned repository as a project - File->Import->Existing Projects into Workspace->Select directory->Finish

8. Each test cases can be run separately in the editor or all test cases can be run together from command window using mvn test

Design Description:All tasks are in the testcases package. "util" package holds payload and utilities.

To run all the tests together run the testng.xml file as TestNG Suite (/SBG_Assesment/testng.xml)

Individual tests can be run by right click -> run as TestNG Test

## Task 1: Retrieve all fixtures.

Path -> /SBG_Assesment/src/test/java/testcases/GetFixtures.java

1. All fixtures are retrieved

2. Assertions in TestNg is used to assert the number of fixtures and that each of the fixtures have fixtureId value. 

## Task 2: Store a new fixture in the database

Path -> /SBG_Assesment/src/test/java/testcases/StoreFixture.java

1. Data provider is used to load parameters of new fixture

2. As soon as the new fixture is available, it is retrieved and asserted using TestNg Assertions.

## Task 3: Update a fixture within the database

1. Data provider is used to update the parameters of a fixture in the database

2. Assertions in TestNG is used to assert that the relevant attributes in the fixture have changed.

Path -> /SBG_Assesment/src/test/java/testcases/UpdateFixture.java

## Task 4: Delete a fixture 

Path -> /SBG_Assesment/src/test/java/testcases/DeleteFixture.java

1. A fixture stored in the database is deleted

2. All fixtures are retrieved and asserted that the new fixture is deleted.


Any questions, feel free to mail me at vidhyamenons@gmail.com

Thanks,

Vidhya S Menon
