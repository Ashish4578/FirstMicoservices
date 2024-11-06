Implemented a microservices. 
Below is Services and thier work and dependencies used

1. ServiceRegistry: It has all services register.
  Dependencies : Eureka Server

2. ConfigServer: It has all necessary configuration to all services.
  Dependencies : ConfigServer and Eureka Discovery Client

3. UserService : It has user data along with its seperate database.
  Dependencies : Actuator, Data-Jpa, Spring Web, MySqlConnector, OpenFeign , lombok and Eureka Discovery Client

4. HotelService : It has data regarding hotel with seperate database.
  Dependencies : Actuator, Data-Jpa, Spring Web, MySqlConnector, OpenFeign , lombok and Eureka Discovery Client

5. RatingService  : It has data regarding rating with seperate database.
  Dependencies : Actuator, Data-Jpa, Spring Web, MySqlConnector, OpenFeign , lombok and Eureka Discovery Client

6. Api Gateway : It combines users, rating & hotel services and run like monolithic application
  Dependencies Spring Gateway, Eureka Discovery Client, LoadBalancer, Spring Reactive Web, Spring Config
