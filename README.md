# swarm-archetypes
Archetypes for Thorntail microservices supporting CDI + JPA + Wicket and/or Rest

The archetype also comes with a docker-compose file that will fire up the application (after you installed the docker image using maven) and a postgres database.

All three archetypes have a `web-application` maven module that can be started using the main class `org.wildfly.swarm.Swarm` from your favorite IDE.

## jaxrs-jpa-archetype
When the project created from this archetype is started, it exposes the endpoint `http://localhost:8080/hello/name` which persists a greeting for `name`.

## wicket-jaxrs-jpa-archetype
When the project created from this archetype is started, it exposes the endpoint `http://localhost:8080/hello/name` which persists a greeting for `name`. It also exposes a wicket application at `http://localhost:8080/` where the names of the persisted greetings can be viewed.

## wicket-jpa-archetype
When the project created from this archetype is started, it exposes a wicket application at `http://localhost:8080/` where you can add a greeting which will get persisted.

## docker
All created projects have an `docker` profile included that allows the generation of a docker image that will run the application.
