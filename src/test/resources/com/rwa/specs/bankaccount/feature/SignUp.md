# Sign Up

As a new client, I want to create an account by myself so that I could access application.

## Rules:

To create an account, client must satisfy the conditions:

- First/Last Name, Username, Password and Confirm Password must be provided.
- Password and Confirm Password must be the same as, and at least contain 4 chars.

### Scenario: Client could register an account with valid information.
#### [Example:](- "Could sign up")
<div>
    <p concordion:execute="#data=registerAccount(#firstName,#lastName,#username,#password,#confirmPassword)">

Given [Luke](- "#firstName") [Shaw](- "#lastName") doesn't have online banking account

When he registers an account with <span concordion:assert-true="isRegistrationDataValid()">valid and essential information</span>

|First Name|Last Name| Username | Password | Confirm Password|
|---|---|---|---|---|
|<span concordion:echo="#firstName" />|<span concordion:echo="#lastName" />|<span concordion:set="#username">luke.shaw</span>|<span concordion:set="#password">s3cret</span>|<span concordion:set="#confirmPassword">s3cret</span>|

Then his account should be created [successfully](- "c:assert-true=#data.signUpResult")

</p>
</div>

<br/>

### Scenario: Client could not register an account with invalid information.
#### [Example:](- "Could not sign up")
|[][registerAccount][Case](- "c:example")|[First Name][]|[Last Name][]|[Username][]|[Password][]|[Confirm Password][]|[Error Message][match]|
|---|---|---|---|---|---|---|
|Missing first Name|<p/>|Becka|john.becka|s3cret|s3cret|First Name is required|
|Missing last Name|Loly|<p/>|loly_Popp|s3cret|s3cret|Last Name is required|
|Missing username|Odin|Josh|<p/>|s3cret|s3cret|Username is required|
|Password not match|Robert|Liam|robert.liam|s3cret|secret|Password does not match|
|Password length|Robert|Liam|robert.liam|s3c|s3c|Password must contain at least 4 characters|

[First Name]: - "#firstName"
[Last Name]: - "#lastName"
[Username]:- "#username"
[Password]:- "#password"
[Confirm Password]: - "#confirmPassword"
[registerAccount]: - "#data=registerAccount(#firstName,#lastName,#username,#password,#confirmPassword)"
[match]:- "?=#data.errorMessage"