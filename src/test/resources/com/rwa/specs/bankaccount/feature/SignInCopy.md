# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities

## Rules:
- To authenticate to the system, clients must provide their registered usernames and passwords
- When client logs-in to the application, system will treat them differently based on their account types:

  - ACTIVATED BANK ACCOUNT: is an account of a user who already has a banking account -> the system routes them to home page

  - WAITING BANK ACCOUNT: is an account of a user who has not created banking account -> the on-boarding process is triggered.

- In case there are problems with sign-in, the system returns corresponding error message
  and preventing users accessing to the system.

## Scenario: User could log-in with valid credentials

## [Background](- "before")

* Given there are registered [users](- "#data=setUpSignInData()") with password [s3cret](- "#password=#TEXT")

|First Name| Last Name | Username | Account Type |
|---|---|---|---|
|<span concordion:echo="#data.waitingBankingAccount.firstName" />|<span concordion:echo="#data.waitingBankingAccount.lastName" />|<span concordion:echo="#data.waitingBankingAccount.username" />|Waiting banking account|
|<span concordion:echo="#data.activatedBankingAccount.firstName" />|<span concordion:echo="#data.activatedBankingAccount.lastName" />|<span concordion:echo="#data.activatedBankingAccount.username" />|Activated banking account|

<br/>

### [Example:](- "Users has not activated bank account") [Waiting Bank Account](- "#userAccountType=#TEXT") user
[](- "#username=#data.waitingBankingAccount.username")

Given [](- "c:echo=#data.waitingBankingAccount.firstName") [](- "c:echo=#data.waitingBankingAccount.lastName") was at the Login page

When he [signs-in](- "#result=signIn(#username,#password,#userAccountType)") into application

Then he should authenticate to system [successfully](- "c:assert-true=#result")


### [Example:](- "Users activated bank account") [Activated Bank Account](- "#userAccountType=#TEXT") user
[](- "#username=#data.activatedBankingAccount.username")

Given [](- "c:echo=#data.activatedBankingAccount.firstName") [](- "c:echo=#data.activatedBankingAccount.lastName") was at the Login page

When he [signs-in](- "#result=signIn(#username,#password,#userAccountType)") into application

Then he should authenticate to system [successfully](- "c:assert-true=#result")

## Scenario: User could not log-in with invalid credentials
