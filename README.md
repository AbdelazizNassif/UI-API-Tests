**UI and API testing project**:

Used programming language: Java 17.
Libraries and Tools used for UI testing: Selenium, TestNG, Maven 3.x.x.
Libraries and Tools used for API testing: Rest Assured.

**How to intall your machine to run the project?**
- Install Java 17 and maven on your machine
- Clone the project from Gitlab

**What is the used design patterns?**
- POM for For UI tests
- Object model for API tests

**How to install The API environment and get the categories endpoints?**
- Install the playground API environment
	- visit https://github.com/BestBuy/api-playground
	- Setup your local environment as explained in the “Getting Started” section.
		- Please note that if you are using node JS version 14 or higher this extra command "npm i sqlite3 -D" is needed following "npm install command"
		- Open your browser then access "http://localhost:3030/"
		- Visit "http://localhost:3030/docs/#/categories" to get Categories endpoints


**How to run The automated UI and API test cases?**
- Make sure the playground API server is up and running
- Run the command "**mvn test clean**"
	- this command will run the UI test cases and the API test cases

**Where to find the UI manual test case?**
- Inside the repo, You will find it in the PDF TestCases_UI.pdf inside the folder Manual-tests.
	- the test are divided to automated, should be automated, and should not be automated
		- automated are the ones which are automated
		- should be automated are the ones which should be automated but they are not automaed at the moment
		- should not be automated are the ones which should not be automated and should run manually
		
		
**What is the criteria to automate a test case or not?**

	- The decision to automate or not is taken based on 3 factors:

		1 - value:

			- importance of the feature
			- probability this feature is fixed if broken
			- The importance of the scenario
		2 - Risk:

			- How the feature will impact us if failed?
			- How frequent the feature is used?
		3 - Cost:
		
			- easiness and quickness of writing the script.
	
	based on all these factors, I decide which test case should be automated.
	
	
