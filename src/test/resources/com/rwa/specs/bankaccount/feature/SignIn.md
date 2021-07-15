# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities

## Rules:
- To authenticate to the system, clients must provide their registered usernames and passwords 
- When client logs-in to the application, system will treat them differently based on their account types:

  - ACTIVATED BANK ACCOUNT: is an account of a user who already has a banking account -> the system routes them to home page
    
  - WAITING BANK ACCOUNT: is an account of a user who has not created banking account -> the on-boarding process is triggered.

- In case there are problems with sign-in, the system returns corresponding error message 
and preventing users accessing to the system.
  
### Background
Given there were registered users

|Username|Password|account type|
|---|---|---|
|loki.galaxy|loki@123|activated bank account|
|becky.vic|becky@s3cret|waiting bank account|

#### Scenario: client logs into the application with valid credential

When they log into the application with valid credentials

Then they could access to the application

#### Scenario: client logs into the app with invalid credential

When they log into the application with invalid credentials

Then they could not access to the application