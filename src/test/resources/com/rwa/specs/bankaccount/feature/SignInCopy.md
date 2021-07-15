# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities

## Rules:
- To authenticate to the system, clients must provide their registered usernames and passwords 
- When client logs-in to the application, system will treat them differently based on their account types:

  - ACTIVATED BANK ACCOUNT: is an account of a user who already has a banking account -> the system routes them to home page
    
  - WAITING BANK ACCOUNT: is an account of a user who has not created banking account -> the on-boarding process is triggered.

- In case there are problems with sign-in, the system returns corresponding error message 
and preventing users accessing to the system.
  
#### [Background](- "setUp")
Given there were registered users

- Username: [patrick.eva](- "#username=setScopeUserName(#TEXT)")
- Password: [s3cret](- "#username=setScopeUserName(#TEXT)")

|[][setUpFruit][Id][id]|[Fruit][fruitName]|
|---|---|
|1|mango|
|4|lemon|

[id]: - "#id"
[fruitName]: - "#fruitName"
[setUpFruit]: - "#data=setUpFruit(#id, #fruitName)"






Echo map: [](- "printJsonToConsole(#map)")
#### [Scenario1](-): client logs into the application with valid credential


When he provides username: [](- "c:echo=getScopedUsername()")

#### [Scenario2](-): client logs into the app with invalid credential

When he provides username: [](- "c:echo=getScopedUsername()")