# car-pooling-surcharge-calculator-service
## Description

Retrieves the car price details based on the input noOfDays and FIN

```java
PriceDetails getPriceDetails(@RequestParam int noOfDays,
			@RequestParam String FIN)
```
1. Receives noOfDays and FIN as input.
2. Based on the FIN input the car is retrieved by communicating with the car details REST service.
3. surcharge percentage is retrievd based on the engine power and location received above.
4. basePrice and surcharge price per day are calculated
5. Based on noOfDays input the total price is calculated.
6. PriceDetails object is constructed and returned as output.

### Endpoints

>/car/pooling/surcharge  GET

### Request Data

#### URI: /car/pooling/surcharge GET

> **Request**

```json
	http://localhost:8083/car/pooling/surcharge?noOfDays=7&FIN=9753198
```

> **Response**

```json
	{"basePrice":450.91,"surchargePrice":103.71,"totalPrice":3882.34}
```

## Built with
* Maven
* Spring Boot

## Prerequisites
You need to have installed

 - Java 8
 - Maven
 - STS
 
## Deployment
On STS right click on project -> Run As -> Spring Boot App
