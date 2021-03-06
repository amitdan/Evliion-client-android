## Full Stack Evliion app to find near by EV charging stations and/or battery swapping stations

## API calls
## 1 Register
```bash
POST http://evcharge-dev.us-east-1.elasticbeanstalk.com/api/auth/signup
HTTP Header : Content-Type -> application/json
Request Body:
{
 "name":"Tesr",
 "username":"tda",
 "email":"tesrr@gmail.com",
 "password":"Tstgg@123"
}


Response:
Success:
HTTP Status code - 201

{
    "success": true,
    "message": "User registered successfully"
}


Fail:
HTTP Status code - 400

{
    "success": false,
    "message": "Email Address already in use!"
}
```
## Built with 

1. **Spring Boot**
2. **Spring Security**
3. **JWT**
4. **React and**
5. **Ant Design**

## 1 Register

![Screenshot](https://evliion.s3.amazonaws.com/1-Register.jpg)

## 2 Verify OTP screen 1

![App Screenshot](https://evliion.s3.amazonaws.com/2-Verify-OTP-screen-1.jpg)

## 3 Verify OTP screen 2

![App Screenshot](https://evliion.s3.amazonaws.com/3-Verify-OTP-screen-2.jpg)

## 4 Login

![App Screenshot](https://evliion.s3.amazonaws.com/4-Login.jpg)

## 5 Add vehicle four wheeler

![App Screenshot](https://evliion.s3.amazonaws.com/5-Add-vehicle-four-wheeler.jpg)

## 6 Add vehicle two wheeler

![App Screenshot](https://evliion.s3.amazonaws.com/6-Add-vehicle-two-wheeler.jpg)

## 7 Charging station map view

![App Screenshot](https://evliion.s3.amazonaws.com/7-Charging-station-map-view.jpg)

## 8 Charging station map with pop up 1

![App Screenshot](https://evliion.s3.amazonaws.com/8-Charging-station-map-with-pop-up-1.jpg)

## 9 Charging station map with pop up 2

![App Screenshot](https://evliion.s3.amazonaws.com/9-Charging-station-map-with-pop-up-2.jpg)

## 10 Charging station map with pop up 3

![App Screenshot](https://evliion.s3.amazonaws.com/10-Charging-station-map-with-pop-up-3.jpg)

## 11 Start charging page

![App Screenshot](https://evliion.s3.amazonaws.com/11-Start-charging-page.jpg)

## 11 Start charging page - Enhanced

![App Screenshot](https://evliion.s3.amazonaws.com/11-Start-charging-page-New.jpg)

## 12 Scan QR code

![App Screenshot](https://evliion.s3.amazonaws.com/12-Scan-QR-code.jpg)

## 13 Charging in progress

![App Screenshot](https://evliion.s3.amazonaws.com/13-Charging-in-progress.jpg)

## 14 Profile page

![App Screenshot](https://evliion.s3.amazonaws.com/14-Profile-page.jpg)

## 15 View vehicle details

![App Screenshot](https://evliion.s3.amazonaws.com/15-View-vehicle-details.jpg)

## 16 Transaction history

![App Screenshot](https://evliion.s3.amazonaws.com/16-Transaction-history.jpg)

## 17 Payment options

![App Screenshot](https://evliion.s3.amazonaws.com/17-Payment-options.jpg)

## 18 Payment page

![App Screenshot](https://evliion.s3.amazonaws.com/18-Payment-page.png)


## Steps to Setup the Spring Boot Back end app (evliion-app-server)

1. **Clone the application**

	```bash
	git clone https://github.com/amitdan/evliion.git
	cd evliion-app-server
	```

2. **Create MySQL database**

	```bash
	create database evliion_app
	```

3. **Change MySQL username and password as per your MySQL installation**

	+ open `src/main/resources/application.properties` file.

	+ change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

4. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8080.

	You can also package the application in the form of a `jar` file and then run it like so -

	```bash
	mvn package
	java -jar target/ev-0.0.1-SNAPSHOT.jar
	```
5. **Default Roles**
	
	The spring boot app uses role based authorization powered by spring security. To add the default roles in the database, I have added the following sql queries in `src/main/resources/data.sql` file. Spring boot will automatically execute this script on startup -

	```sql
	INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
	INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');
	```

	Any new user who signs up to the app is assigned the `ROLE_USER` by default.

## Steps to Setup the React Front end app (evliion-app-client)

First go to the `evliion-app-client` folder -

```bash
cd evliion-app-client
```

Then type the following command to install the dependencies and start the application -

```bash
npm install && npm start
```

The front-end server will start on port `3000`.
