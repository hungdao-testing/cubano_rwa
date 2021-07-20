# On-Boarding

As a newly created user, I want the system to walk me through the On-boarding process so that
I could link a bank profile to my user account.

### Rules: OnBoarding process behavior
- The on-boarding process is triggered to the newly created users. 
  It's triggered once user logs into the application, and would be stopped if user finished setting up banking account.
   
#### [Scenario:](- "could on-board for new users") Newly created user could on-board successfully

Given there was a newly registered user

|[][data][Full Name][]| [Username][] | [Password][]|
|---|---|---|
|Bob Lee|bob.lee|s3cret|

[Full Name]: - "#fullName"
[Username]: - "#username"
[Password]: - "#password"
[data]: - "setUpOnBoardingData(#fullName, #username, #password)"

And he was on the [On-boarding process](- "triggerOnBoardingProcessForUser(#username, #password)")

<div>

<p concordion:execute="#process=processOnBoardingFlow(#bankName,#routingNumber,#accountNumber)">

When he provides valid banking information

|Bank Name|Routing Number|Account Number|
|---|---|---|
|<span concordion:set="#bankName">American Bank</span>|<span concordion:set="#routingNumber">031302997</span>|<span concordion:set="#accountNumber">000123456789</span>|

</p>

</div>


Then he could finish the process [successfully](- "c:assert-true=#process.result")

### Rules: Data validation
User must provide your banking profile to pass the On-boarding process:

- [ ] Bank Name is required and must contain 5 chars
- [ ] Routing Number is required and at lease 9 digits
- [ ] Account Number is required and at lease 9 digits

#### [Scenario:](- "data format validation") Data Format Validation

Given there was a newly registered user

|[][data][Full Name][]| [Username][] | [Password][]|
|---|---|---|
|Josh Lee|josh.lee|s3cret|

[Full Name]: - "#fullName"
[Username]: - "#username"
[Password]: - "#password"
[data]: - "setUpOnBoardingData(#fullName, #username, #password)"

And he was on the [On-boarding process](- "triggerOnBoardingProcessForUser(#username, #password)")

When he provides __unacceptable banking information__

Then he should see the error message

|[][process]Unacceptable banking information|[Bank Name]|[Routing Number]|[Account Number]|[Error Message][match]|
|---|---|---|---|---|
|Missing Bank Name|<p/>|031302997|000123456789|Enter a bank name|
|Missing Routing Number|Bank Of America|<p/>|000123456789|Enter a valid bank routing number|
|Missing Account Number|Bank Of America|031302997|<p/>|Enter a valid bank account number|
|Bank Name length|Bank|031302997|000123456789|Must contain at least 5 characters|
|Routing Number length|Bank Of America|031|000123456789|Must contain a valid routing number|
|Account Number length|Bank Of America|031302997|00|Must contain at least 9 digits|


[Bank Name]: - "#bankName"
[Routing Number]: - "#routingNumber"
[Account Number]: - "#accountNumber"
[process]: - "#process=processOnBoardingFlow(#bankName,#routingNumber,#accountNumber)"
[match]: - "?=#process.errorMsg[0]"

