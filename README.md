Scalatra Sandbox [![travis-badge][]][travis]
=======

[travis]:                https://travis-ci.org/mycaule/scalatra-sandbox
[travis-badge]:          https://travis-ci.org/mycaule/scalatra-sandbox.svg?branch=master

This repository is for tests and learning the framework.

### Usage

```sh
# Compile sources and test files
$ sbt compile
$ sbt test:compile

# Run server locally with restart on changes
$ sbt ~jetty:start

# Deploy on Heroku
$ heroku login
$ heroku create
$ git push heroku master
```

### Getting started
| Route  |  Sources |  Description  |
|--------|----------|---------------|
| [/teams](https://afternoon-wildwood-38058.herokuapp.com/teams)  | [TeamsController.scala](src/main/scala/com/sandbox/teams/TeamsController.scala)  | List of all teams |
| [/api-docs/swagger.json](https://afternoon-wildwood-38058.herokuapp.com/api-docs/swagger.json) | [FootballSwagger.scala](src/main/scala/com/sandbox/FootballSwagger.scala) | Swagger v2 JSON specification, see [Swagger UI](http://petstore.swagger.io/?url=https://afternoon-wildwood-38058.herokuapp.com/api-docs/swagger.json) |
| [/status](https://afternoon-wildwood-38058.herokuapp.com/status) | [StatusController.scala](src/main/scala/com/sandbox/status/StatusController.scala) | Healthcheck  |

### Roadmap

- [ ] [JSON](https://github.com/scalatra/scalatra-website/blob/master/content/guides/2.6/formats/json.md)
- [ ] [Deployment](https://github.com/scalatra/scalatra-website/tree/master/content/guides/2.6/deployment)
- [ ] Monitoring:
  - https://github.com/scalatra/scalatra-website/blob/master/content/guides/2.6/monitoring/logging.md
  - https://github.com/scalatra/scalatra-website/blob/master/content/guides/2.6/monitoring/metrics.md
  - http://kamon.io/teamblog/2015/08/08/twenty-minutes-in-the-playground-monitoring-scalatra-with-kamon/
- [ ] [Persistence](https://github.com/scalatra/scalatra-website/tree/master/content/guides/2.6/persistence)
- [ ] [Using scalatest](https://scalatra.org/guides/2.6/testing/scalatest.html)

### References

- [Scalatra guides](https://scalatra.org/guides/2.6/)
- [Scalatra Website examples](https://github.com/scalatra/scalatra-website-examples)
- [Scalatra in Action examples](https://github.com/scalatra/scalatra-in-action)

### Testing tools
- [Swagger Editor](https://editor.swagger.io/)
- [Swagger UI](https://swagger.io/swagger-ui/)
- [Dredd](https://github.com/apiaryio/dredd)
- Mock servers: [SwaggerHub](https://swagger.io/tools/swaggerhub/), [Postman](https://www.getpostman.com)
