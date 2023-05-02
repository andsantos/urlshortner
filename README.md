# urlshortner
URL Shortner


-Dspring.profiles.active=test

# Maven
mvn package -DskipTests

# Docker

docker build -t app-urlshortner-api .

docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=test" app-urlshortner-api
