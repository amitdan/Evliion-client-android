# Mockup-11 Start charging page - Enhanced

**Assignee - Ghadia Sarfraz**

**Screen to be created** : Book appointment screen

#### **Background**
User was on Google map page within our EV app and select specific charging station to book an appointment with, which means station id would be available on next page. Also after login vehicle id should also be in session/local storage/secure storage so that it would be available for other pages within app.

#### **Description-task to be done**
User wants to book appointment for eV charging. Vehice id and station id would be available on this page as mentioned above. Button name should be "Proceed to Pay". 
##### Station name : Value should be fetched from previous page
##### Your vehicle : Value should be feched from previus page
##### Cost per hour to charge : Value should be feched from previus page, example INR 10
##### Expected time to charge fully : Should be fetched from below API 

On load of this page Rest API call should be made to fetch estimated charge time. Find API details below:
```javascript
Url: GET https://api.evliion.com/v1/estimated-charge-time?stationId=1234&vehicleId=5678

Success Response: 
HTTP status code : 200
Response body : 
{
 “success”: “true”,
 "stationId" : 1234,
 "vehicleId" : 5678,
 "timeToFullyCharge" : 120
}

Fail response:
HTTP status code : Other than 200
Response body : 
{
 “success”: “false”,
 "message" : "Please try again"
}
```
##### Estimated payable amount : It would be calculated using time selected in date picker and per hour cost to charge Ev battery. It should change as per time updated in time picker. Time could be 60 mins or 90 mins etc.

On click of "Proceed to pay" button, below Rest API call should be made 
```javascript
Url: POST https://api.evliion.com/v1/transaction

Request Body:
Request
{
“stationId”: 456,
“vehicleId”: 789, 
“slotDuration”:
{
“startTime”: 9.30 am,
“endTime”:10.30 am,
“totalTime”:60 mins
}
}

Success Response: 
HTTP status code : 201
Response body : 
Success response
{
“success”: “true”,
“transactionId”: 311223124,
“message”: ”Transaction created successfully”,
}

Fail response:
HTTP status code : Other than 200
Response body : 
{
“success”: “false”,
“message”: “Failed creating transaction. Please try after some time”,
}
```

# Mockup- 19 - Add Charging Station Page

**Assignee - Aishwarya**

**Screen to be created** : Add Charging station

#### **Background**: 
EV charging station owner wants to use our app, so he does try to create station in our app through this screen.

#### **Description-Task to be done**
This screen should capture - Station name, address line 1, country, state, city, zipcode, contact person name, contact number, mail address. 

**Reference page**: Please take reference of registration mockup #1.

On click of "Submit" button, below Rest API call should be made 
```javascript
Url: POST https://api.evliion.com/v1/station

Request Body:
Request
{
“station-name”: “Nageshwar pump”,
“email_address”: “test.reeee@gmail.com”,
“mobile”: 1234567890,
“address-line1”: “address line 1”,
“country”: “India”,
“state”: “Maharashtra”,
“city”: “Mumbai”,
“zipcode”: 123456,
"contact-person-name": "Test name"
}

Success Response: 
HTTP status code : 201
Response body : 
Success response
{
“success”: “true”,
“stationId”: 311223124,
“message”: ”Station created successfully”,
}

Fail response:
HTTP status code : Other than 200
Response body : 
{
“success”: “false”,
“message”: “Failed creating station. Please try after some time”,
}
```

# Java-GetChargingStationsBasedOnGeoLocation
Asignee - Kumar



