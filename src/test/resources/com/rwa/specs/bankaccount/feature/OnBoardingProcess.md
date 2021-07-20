# On-Boarding

As a newly created user, I want the system to walk me through the On-boarding process so that
I could link a bank profile to my user account.

## Rules:
- The on-boarding process is triggered to the newly created users. 
  It's triggered once user logs into the application, and would be stopped if user finished setting up banking account.
- User must provide your banking profile to pass the On-boarding process:

  - [ ] Bank Name is required and must contain 5 chars
  - [ ] Routing Number is required and at lease 9 digits
  - [ ] Account Number is required and at lease 9 digits
    
    
### [Scenario:](- "could on-board for new users") Newly created user could on-board successfully

[](- "#user=setUpOnBoardingData()")

Given there was a registered user

|First Name| Last Name | Username | Password|
|---|---|---|---|
|<span concordion:echo="#user.firstName"></span>|<span concordion:echo="#user.lastName"></span>|<span concordion:echo="#user.username"></span>|<span concordion:set="#password">s3cret</span>|


<div>
<p concordion:execute="#result=processOnBoardingFlow(#user.username,#password,#bankName,#routingNumber,#accountNumber)">

And he was on the On-boarding process

When he provides valid information for on-boarding form

|Bank Name | Routing Number | Account Number|
|---|---|---|
|<span concordion:set="#bankName">American Bank</span>|<span concordion:set="#routingNumber">031302997</span>|<span concordion:set="#accountNumber">000123456789</span>|

</p>
</div>


Then he could finish the process [successfully](- "c:assert-true=#result")
