# Car Rental System using Java OOPS

## Objective
To implement Object-Oriented Programming (OOP) concepts in a real-time application. This project utilizes all four pillars of OOP: **Abstraction, Inheritance, Polymorphism, and Encapsulation**.

## Problem Statement
Create and simulate a simple **Car Rental System** using Java OOP principles.

## Overview
The system consists of various class files that store data in corresponding objects. Using these objects, we can efficiently retrieve information related to a particular entity.

## Classes in the System
1. **Car** - Stores complete details about a car, allowing retrieval and modification of specific information through methods.
2. **Customer** - Stores full information about a customer and provides methods to access relevant details.
3. **Rental** - Encapsulates all rental-related information, such as the customer renting a car, the rented car details, and the rental period.
4. **CarRentalSystem** - Acts as the core system that integrates all the classes and manages the rental process.

## Class Details
### **1. Car Class**
#### Members:
- `private String carId;`
- `private String carModel;`
- `private double basePrice;`
- `private boolean isAvailable;`

#### Encapsulation:
To prevent unauthorized access and modification of variables, **Encapsulation** is used. All member variables are declared **private** and can be accessed only through **getter and setter methods**. This approach enhances data protection, security, and flexibility in Java programming.

---

### **2. Customer Class**
#### Members:
- `private String customerId;`
- `private String customerName;`
- `private String customerPhone;`
- `private String customerEmail;`

---

### **3. Rental Class**
#### Members:
- `private Car car;`
- `private Customer customer;`
- `private int days;`

---

### **4. Car Rental System Class**
#### Members:
- `private List<Car> carList;`
- `private List<Customer> customerList;`
- `private List<Rental> rentalList;`

#### Process Flow:
1. Create a **List** to store available cars.
2. Create a **List** to store registered customers.
3. Create a **List** to store rental records.
4. Populate the `carList` with available car objects.
5. Populate the `customerList` with available customer objects.
6. Populate the `rentalList` with existing rental transactions.
7. Add a new rental by calling the `addRental(carId, customerId, days)` method in the **CarRentalSystem** class.
   - Find the matching **Car** and **Customer** objects using their respective IDs.
   - Create a **Rental** object with the retrieved car, customer, and rental period.
   - Add the newly created rental object to the `rentalList`.

## Conclusion
This **Car Rental System** effectively demonstrates the implementation of **Abstraction, Encapsulation, Inheritance, and Polymorphism** in Java. The use of lists to manage cars, customers, and rentals ensures efficient data storage and retrieval. Encapsulation enhances data security, while polymorphism and abstraction provide flexible and scalable system architecture.
