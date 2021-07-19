# Bank Account

## Features:
* [Sign Up](feature/SignUp.md)
* [Sign In](feature/SignIn.md )
* [OnBoarding](feature/OnBoarding.md)


### Scenarios: Create user account
#### [Example: ](- "create user acccount by api")

Given users:

Name : [Boby Charton](- "#name")
Username: [boby.char](- "#username")
Password: [s3cret](- "#password")

Then user could create an account [succcessfully](- "c:assert-true=getResultOfCreatingUserAccount(#name,#username,#password)")