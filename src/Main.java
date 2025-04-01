// Import the necessary packages
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

class Car {
    // CarId, CarModel, BasePrice, isAvailable
    private int carId;
    private String carModel;
    private double baseprice;
    private boolean isAvailable;

    // Constructor
    Car(int carId, String carModel, double baseprice, boolean isAvailable) {
        this.carId = carId;
        this.carModel = carModel;
        this.baseprice = baseprice;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getCarid() {
        return carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getBasePrice() {
        return baseprice;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setBasePrice(double baseprice) {
        this.baseprice = baseprice;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Method to display the details of the car
    public void displayCarDetails() {
        System.out.println("Car ID: " + carId);
        System.out.println("Car Model: " + carModel);
        System.out.println("Base Price: " + baseprice);
        System.out.println("Is Available: " + isAvailable);
    }

    // Method to calculate price
    public double calculatePrice(int days) {
        return this.baseprice * days;
    }

    // Method to check availability
    public boolean checkAvailability() {
        return this.isAvailable;
    }

    // Method to book the car
    public void bookCar() {
        if (isAvailable) {
            this.isAvailable = false;
            System.out.println("Car booked successfully.");
        } else {
            System.out.println("Car is not available for booking.");
        }
    }

    // Method to return the car
    public void returnCar() {
        this.isAvailable = true;
        System.out.println("Car returned successfully.");
    }

    // Method to cancel the booking
    public void cancelBooking() {
        this.isAvailable = true;
        System.out.println("Booking cancelled successfully.");
    }
}

class Customer {
    // CustomerId, CustomerName, CustomerPhone, CustomerEmail
    private int customerId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;

    // Constructor
    Customer(int customerId, String customerName, String customerPhone, String customerEmail) throws IllegalArgumentException {
        if(customerId<=0){
            throw new IllegalArgumentException("Customer ID must be positive.");
        }
        if(customerName==null || customerName.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        if(customerPhone==null || customerPhone.isEmpty()){
            throw new IllegalArgumentException("Customer phone cannot be null or empty.");
        }
        if(customerEmail==null || customerEmail.isEmpty()){
            throw new IllegalArgumentException("Customer email cannot be null or empty.");
        }
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Phone: " + customerPhone);
        System.out.println("Customer Email: " + customerEmail);
    }
    public void displayCustomerDetailsNow(List<Customer> customers) {
        System.out.println("Customer Details:");
        for (Customer customer : customers) {
            customer.displayCustomerDetails();
        }
    }
}

class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double calculateTotalPrice() {
        return car.calculatePrice(days);
    }

    public void displayRentalDetails() {
        System.out.println("Car Details:");
        car.displayCarDetails();
        System.out.println("Customer Details:");
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Phone: " + customer.getCustomerPhone());
        System.out.println("Customer Email: " + customer.getCustomerEmail());
        System.out.println("Days Rented: " + days);
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    public void bookCar() {
        this.car.bookCar();
    }

    public void returnCar() {
        this.car.returnCar();
    }

    public void cancelBooking() {
        this.car.cancelBooking();
    }

    public boolean checkAvailability() {
        return this.car.checkAvailability();
    }

    public void displayAvailableCars(List<Car> cars) {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.getIsAvailable()) {
                car.displayCarDetails();
            }
        }
    }
}

class CarRentalSystem {
    private List<Car> cars; // list of car object
    private List<Customer> customers; // list of customer object
    private List<Rental> rentals; // list of rental object

    // Constructor
    CarRentalSystem() {
        cars = new ArrayList<Car>();
        customers = new ArrayList<Customer>();
        rentals = new ArrayList<Rental>();
    }

    // Method to add car
    public void addCar(int carId, String carModel, double baseprice, boolean isAvailable) {
        Car car = new Car(carId, carModel, baseprice, isAvailable);
        cars.add(car);
        }

    // Method to add customer
    public void addCustomer(int customerId, String customerName, String customerPhone, String customerEmail) {
        Customer customer = new Customer(customerId, customerName, customerPhone, customerEmail);
        customers.add(customer);
    }

    // Method to rent a car
    public void rentCar(int carId, int customerId, int days) {
        Car car = null;
        Customer customer = null;
        for (Car c : this.cars) {
            if (c.getCarid() == carId) {
                car = c;
                break;
            }
        }
        for (Customer c : this.customers) {
            if (c.getCustomerId() == customerId) {
                customer = c;
                break;
            }
        }
        if (car != null && customer != null && car.checkAvailability()) {
            Rental rental = new Rental(car, customer, days);
            this.rentals.add(rental);
            rental.bookCar();
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    // method to return car
    public void returnCar(Car car) {
        for (Rental r : rentals) {
            if (r.getCar().getCarid() == car.getCarid()) {
                r.returnCar();
                rentals.remove(r);
                car.setIsAvailable(true);
                System.out.println("Car returned successfully.");
                return;
            }
        }
    }

    // Method to cancel booking
    public void cancelBooking(Car car) {
        for (Rental r : rentals) {
            if (r.getCar().getCarid() == car.getCarid()) {
                r.cancelBooking();
                rentals.remove(r);
                car.setIsAvailable(true);
                System.out.println("Booking cancelled successfully.");
                return;
            }
        }
    }

    // Method to display all cars
    public void displayAllCars() {
        System.out.println("All Cars:");
        for (Car car : cars) {
            car.displayCarDetails();
        }
    }
 // Method to display all customers
 public void displayAllCustomers() {
    System.out.println("All Customers:");
    for (Customer customer : customers) {
        customer.displayCustomerDetails();
      
}
}
   


    // Method to display all rentals
    public void displayAllRentals() {
        System.out.println("All Rentals:");
        for (Rental rental : rentals) {
            rental.displayRentalDetails();
        }
    }

    // Method to display available cars
    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.getIsAvailable()) {
                car.displayCarDetails();
            }
        }
    }

    // Method to display rented cars
    public void displayRentedCars() {
        System.out.println("Rented Cars:");
        for (Rental rental : rentals) {
            rental.getCar().displayCarDetails();
        }
    }

    // Method to check availability
    public boolean checkAvailability(int carId) {
        for (Car car : this.cars) {
            if (car.getCarid() == carId) {
                return car.getIsAvailable();
            }
        }
        return false; // Car not found
    }

    // Method to get rentals
    public List<Rental> getRentals() {
        return rentals;
    }

    // Method to check customer
    public boolean checkCustomer(int customerId) {
        for (Customer customer : this.customers) {
            if (customer.getCustomerId() == customerId) {
                return true;
            }
        }
        return false; // Customer not found
    }
}

class Main {
    public static void main(String[] args) {
        CarRentalSystem crs = new CarRentalSystem();
        Scanner sc = new Scanner(System.in);
        // Adding cars
        String path = "C:\\projects\\Java_Oops\\OOps\\src\\cars.txt";
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int carId = Integer.parseInt(parts[0]);
                String carModel = parts[1];
                double basePrice = Double.parseDouble(parts[2]);
                boolean isAvailable = Boolean.parseBoolean(parts[3]);
                crs.addCar(carId, carModel, basePrice, isAvailable);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        // Adding customers
        String path1 = "C:/projects/Java_Oops/OOps/src/customers.txt";
        try (Scanner scanner = new Scanner(new File(path1))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("Invalid customer data: " + line);
                    continue; // Skip this line and move to the next one
                }
                int customerId = Integer.parseInt(parts[0]);
                String customerName = parts[1];
                String customerPhone = parts[2];
                String customerEmail = parts[3];
                crs.addCustomer(customerId, customerName, customerPhone, customerEmail);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        // Menu
        while (true) {
            System.out.println("Car Rental System Menu:");
            System.out.println("Select an option:");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Display All Cars");
            System.out.println("7. Display All Customers");
            System.out.println("8. Display All Rentals");
            System.out.println("9. Display Available Cars");
            System.out.println("10. Display Rented Cars");
            System.out.println("11. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Car ID:");
                    int carId = sc.nextInt();
                    System.out.println("Enter Car Model:");
                    String carModel = sc.next();
                    System.out.println("Enter Base Price:");
                    double basePrice = sc.nextDouble();
                    System.out.println("Is the car available? (true/false):");
                    boolean isAvailable = sc.nextBoolean();
                    crs.addCar(carId, carModel, basePrice, isAvailable);
                    break;
                case 2:
                    System.out.println("Enter Customer ID:");
                    int customerId = sc.nextInt();
                    System.out.println("Enter Customer Name:");
                    String customerName = sc.next();
                    System.out.println("Enter Customer Phone:");
                    String customerPhone = sc.next();
                    System.out.println("Enter Customer Email:");
                    String customerEmail = sc.next();
                    crs.addCustomer(customerId, customerName, customerPhone, customerEmail);
                    break;
                case 3:
                    // Rent car
                    System.out.println("Enter Car ID:");
                    int rentCarId = sc.nextInt();
                    System.out.println("Enter Customer ID:");
                    int rentCustomerId = sc.nextInt();
                    // Check if car is available and customer is valid
                    if (crs.checkAvailability(rentCarId) && crs.checkCustomer(rentCustomerId)) {
                        System.out.println("Enter number of days:");
                        int days = sc.nextInt();
                        crs.rentCar(rentCarId, rentCustomerId, days);
                    } else {
                        System.out.println("Car is not available for rent or customer is invalid.");
                    }
                    break;
                case 4:
                    // Return car
                    System.out.println("Enter Car ID:");
                    int returnCarId = sc.nextInt();
                    System.out.println("Enter Customer ID:");
                    int returnCustomerId = sc.nextInt();
                    // Check if car is rented and customer is valid
                    for (Rental rental : crs.getRentals()) {
                        if (rental.getCar().getCarid() == returnCarId && rental.getCustomer().getCustomerId() == returnCustomerId) {
                            rental.returnCar();
                            System.out.println("Car returned successfully.");
                            return;
                        } else {
                            System.out.println("Car is not rented by this customer.");
                        }
                    }
                    break;
                case 5:
                    // Cancel booking
                    System.out.println("Enter Car ID:");
                    int cancelCarId = sc.nextInt();
                    System.out.println("Enter Customer ID:");
                    int cancelCustomerId = sc.nextInt();
                    // Check if car is rented and customer is valid
                    for (Rental rental : crs.getRentals()) {
                        if (rental.getCar().getCarid() == cancelCarId && rental.getCustomer().getCustomerId() == cancelCustomerId) {
                            rental.cancelBooking();
                            System.out.println("Booking cancelled successfully.");
                            return;
                        } else {
                            System.out.println("Car is not rented by this customer.");
                        }
                    }
                    break;
                case 6:
                    crs.displayAllCars();
                    break;
                case 7:
                    crs.displayAllCustomers();
                    break;
                case 8:
                    crs.displayAllRentals();
                    break;
                case 9:
                    crs.displayAvailableCars();
                    break;
                case 10:
                    crs.displayRentedCars();
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
