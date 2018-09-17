# swarm-archetypes
Archetypes for Thorntail microservices supporting CDI + JPA + Wicket and/or Rest

Its attempts to connect to a localhost PostgresDB with user and password `postgres`. It will drop and create the database on startup. This can be configured in the `project-defaults.yml` file in the created project.

All three archetypes have a `web-application` maven module that can be started using the main class `org.wildfly.swarm.Swarm`.

## jaxrs-jpa-archetype
When the project created from this archetype is started, it exposes the endpoint `http://localhost:8080/hello/name` which persists a greeting for `name`.

## wicket-jaxrs-jpa-archetype
When the project created from this archetype is started, it exposes the endpoint `http://localhost:8080/hello/name` which persists a greeting for `name`. It also exposes a wicket application at `http://localhost:8080/` where the names of the persisted greetings can be viewed.

## wicket-jpa-archetype
When the project created from this archetype is started, it exposes a wicket application at `http://localhost:8080/` where you can add a greeting which will get persisted.

## docker
All created projects have an `docker` profile included that allows the generation of a docker image that will run the application. Its up to you to expose the port, name it and link it to a db.
docker run --name myapp --link postgres:postgres -p 8080:8080 wicket-only:latest
