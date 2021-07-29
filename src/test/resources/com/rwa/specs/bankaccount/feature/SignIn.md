# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities


## [Rules](- "before")
- To authenticate to the system, clients must provide their registered usernames and passwords.
- In case there are problems with sign-in, the system returns corresponding error message
  and preventing users accessing to the system.
  


### [Scenario: User could log-in application with valid credentials](- "login with valid credentials"):
[](- "#data=getSignInData()")

When a registered user [](- "c:echo=#data.getFirstName()") [](- "c:echo=#data.getLastName()") logs into the app with valid credentials

   - Username: '[](- "c:echo=#data.username")'
   - password '[s3cret](- "#password=#TEXT")'

Then he should authenticate to the app [successfully](- "?=assertLoginProcessWithValidCredentials(#data.username, #password, #TEXT)")

### [Scenario: User could not log-in application with invalid credentials](- "could not login with invalid credentials"):
[](- "#data=getSignInData()")

When a registered user [](- "c:echo=#data.getFirstName()") [](- "c:echo=#data.getLastName()") logs into the app with invalid credentials accidentally, then he should not be allowed to access the application because of error [Username or password is invalid](- "?=assertLoginUnsuccessfullyWithInvalidData(#data.username, #data.getUuid(), #TEXT)")


