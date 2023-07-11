# Hotel Portal Application

The Hotel Portal Application is a web-based system developed using Spring Boot framework. It provides functionalities for managing hotels, bookings, ratings, and reviews.

## Features

- User Registration and Authentication: Users can create an account and authenticate themselves to access the application.
- Hotel Management: Hotel owners or administrators can add, update, and delete hotels along with their details such as name, description, star rating, and address.
- Booking Management: Users can search for available hotels, make bookings, and view their booking history.
- Rating and Review System: Users can rate hotels and provide reviews based on their experiences.
- Role-based Access Control: The application implements role-based access control to restrict certain functionalities based on user roles (e.g., guest, employee, administrator).
- RESTful APIs: The application exposes RESTful APIs to allow integration with other systems or third-party applications.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- MySQL (or any other preferred database)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Maven
- MySQL or any other preferred database server

### Installation

1. Clone the repository:

```
https://github.com/iyasu7/HotelMgt.git
```

2. Configure the database connection in the `application.properties` file:

```
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_mgt
spring.datasource.username=root
spring.datasource.password=your-password
```

3. Build the application using Maven:

```
cd hotel-portal
mvn clean package
```

4. Run the application:

```
java -jar target/hotel-portal.jar
```

5. Open a web browser and access the application at `http://localhost:8080`.

## Documentation

For more detailed information about the application's architecture, API endpoints, and usage, please refer to the [Documentation](docs/README.md) folder.

## Contributing

Contributions to the Hotel Portal Application are welcome. If you encounter any issues or have suggestions for improvements, please open an issue or submit a pull request.


## Authors

<td align="center"><a href="https://github.com/iyasu7" target="_black"><img src="https://avatars.githubusercontent.com/u/107022433?s=400&u=48c31a65a7f69723cc3fa0c341884a300f2349ae&v=4" width="150px;" alt="abdallah hemdan"/><br /><sub align="center" ><b> Iyasu Nibret</b></sub></a><a href="https://github.com/iyasu7/HotelMgt/commits/master?author=iyasu7" title="Code">💻</a> <br /></td>


## Acknowledgements

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/)

Feel free to modify and customize this README file according to your specific project requirements.
