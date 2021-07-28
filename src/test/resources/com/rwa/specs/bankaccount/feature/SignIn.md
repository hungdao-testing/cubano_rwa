# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities


## [Rules](- "before")
- To authenticate to the system, clients must provide their registered usernames and passwords.
- In case there are problems with sign-in, the system returns corresponding error message
  and preventing users accessing to the system.
  
[](- "#data=getSignInData()")

### [Scenario: User could log-in with valid credentials](- "login with valid credentials"):

When a registered user logs into the app with valid credentials

   - Username: '[](- "c:echo=#data.username")'
   - password '[s3cret](- "#password=#TEXT")'

Then he should authenticate to the app [successfully](- "?=loginToSystemSuccessfully(#data.username, #password, #TEXT)")


### [Scenario: User could not log-in with incorrect data format](- "Could not login with incorrect format")

When user [](- "c:echo=#data.getFirstName()") [](- "c:echo=#data.getLastName()") accidentally input incorrect data format, he could not log into the application

|[signIn][][Case](- "c:example")|[Username][]|[Password][]|[Error Message][]|
|---|---|---|---|
|Missing input Username|<p/>|s3cret|Username is required|
|Password length|may.flower|sec|Password must contain at least 4 characters|

[Username]: - "#username"
[Password]: - "#password"
[Error Message]: - "#condition=#TEXT"
[signIn]: - "loginToSystemWithIncorrectDataFormat(#username, #password,#condition)"


### [Scenario: User could not log-in with missing input for required fields](- "Could not login with missing input")


When user [](- "c:echo=#data.getFirstName()") [](- "c:echo=#data.getLastName()") accidentally missing input required fields, he could not log into the application

|[signIn](- "#res=loginToSystemWithIncorrectCredentials(#username, #password)")[Case](- "c:example")|[Username][]|[Password][]|[Error Message][match]|
|---|---|---|---|
|Incorrect password|may.flower|secret|Username or password is invalid|
|Incorrect username|may.flowe|s3cret|Username or password is invalid|

[Username]: - "#username"
[Password]: - "#password"
[match]: - "?=#res"