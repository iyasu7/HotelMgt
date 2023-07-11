# Hotel Portal Application

The Hotel Portal Application is a web-based platform that allows guests to browse and explore various hotels to find their preferred accommodations. Built using Spring Boot framework, this application provides an intuitive and user-friendly API for guests to search and view detailed information about hotels.

## Features

Hotel Search: Guests can search for hotels based on different criteria such as location, star rating, amenities, etc.
Hotel Listings: The application displays a list of hotels with essential details like name, address, star rating, and a brief description.
Hotel Details: Guests can click on a specific hotel to view more detailed information, including room types, prices, available services, and customer reviews.
User Registration: Guests can create an account to access additional features like booking a room, submitting reviews, and managing their preferences.
Booking: Registered users can book a room in their preferred hotel, select check-in and check-out dates, and make payment securely.
Reviews and Ratings: Users can read and submit reviews for hotels they have visited, providing valuable feedback to other guests.
User Profile: Registered users have a personalized profile where they can manage their bookings, view past stays, update preferences, and track their activities.
Role-based Access Control: The application implements role-based access control to restrict certain functionalities based on user roles (e.g., guest, employee, administrator).
RESTful APIs: The application exposes RESTful APIs to allow integration with other systems or third-party applications.

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
