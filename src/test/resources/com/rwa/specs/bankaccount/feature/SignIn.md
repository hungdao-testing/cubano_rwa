# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities

## Rules:
- To authenticate to the system, clients must provide their registered usernames and passwords.
- In case there are problems with sign-in, the system returns corresponding error message
  and preventing users accessing to the system.

## Scenario: User could log-in with valid credentials

### [Example:](- "login with valid credentials"):
[](- "#data=getSignInData()")
 Given [](- "c:echo=#data.firstName") [](- "c:echo=#data.lastName") registered an account with username '[](- "c:echo=#data.username")' and password '[s3cret](- "#password=#TEXT")'

 When he [logs in](- "logInWorkFlow(#data.username, #password)") with valid credentials

 Then he should authenticate to the app [successfully](- "c:assert-true=verifyLogInSuccessfully()")


## Scenario: User could not log-in with incorrect data

### [Example:](- "Could not login")

|[signIn][][Case](- "c:example")|[Username][]|[Password][]|[Error Message][match]|
|---|---|---|---|
|Missing input Username|<p/>|s3cret|Username is required|
|Incorrect credential: password|may.flower|secret|Username or password is invalid|
|Incorrect credential: username|may.flowe|s3cret|Username or password is invalid|
|Password length|may.flower|sec|Password must contain at least 4 characters|

[Username]: - "#username"
[Password]: - "#password"
[signIn]: - "logInWorkFlow(#username, #password)"
[match]: - "?=getErrorMessage()"

