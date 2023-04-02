# urlshortner
URL Shortner


-Dspring.profiles.active=test

# Docker

Exemplo:
docker build -t andsantos/urlshorer:0.0.1 .

docker run -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=test" andsantos/urlshortner:0.0.1