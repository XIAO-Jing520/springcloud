GET http://localhost:3344/actuator/health
Accept: application/vnd.spring-boot.actuator.v3+json

###

POST http://localhost:3344/encrypt

###

POST http://localhost:3344/actuator/bus-refresh

###

#POST http://localhost:3344/actuator/bus-refresh/{destination}    定点发送
POST http://localhost:3344/actuator/bus-refresh/config-client:3366

###

