# Sign In

As a registered user, I want to authenticate to the system by so that I could do banking activities

## Rules:
- To authenticate to the system, clients must provide their registered usernames and passwords
- When client logs-in to the application, system will treat them differently based on their account types:

  * ACTIVATED BANK ACCOUNT: is an account of a user who already has a banking account -> the system routes them to home page

  * WAITING BANK ACCOUNT: is an account of a user who has not created banking account -> the on-boarding process is triggered.

- In case there are problems with sign-in, the system returns corresponding error message
  and preventing users accessing to the system.

## Scenario: User could log-in with valid credentials

### [Background](- "before")

* Given there are registered [users](- "#data=setUpSignInData()") with password [s3cret](- "#password=#TEXT")


### [Example](- "waiting bank account"): user account status is [waiting bank account](- "#userAccountType=#TEXT")
 Given [](- "c:echo=#data.waitingBankingAccount.firstName") [](- "c:echo=#data.waitingBankingAccount.lastName") was at Login page

 When he [logs-in](- "#result=signIn(#data.waitingBankingAccount.username, #password)") into the application with valid credentials

 Then he should authenticate to the [successfully](- "c:assert-true=#result")


### [Example](- "activated bank account"): user account status is [activated Bank account](- "#userAccountType=#TEXT")

Given [](- "c:echo=#data.activatedBankingAccount.firstName") [](- "c:echo=#data.activatedBankingAccount.lastName") was at Login page

When he [logs-in](- "#result=signIn(#data.activatedBankingAccount.username, #password)") into the application with valid credentials

Then he should authenticate to the application [successfully](- "c:assert-true=#result")

## [Scenario: ](- "login with invalid credentials") User could not log-in with invalid credentials
