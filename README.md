# forum-spring-rest-api
A simple REST API with Spring Framework

[x] End-points, HTTP methods

[x] Spring Data JPA

[x] Bean Validation

[x] Cache

[x] API security

[x] Monitoring

[x] Profiles

[x] Tests

[x] Deploy (via Docker and Heroku)


### Demo

#### Authorization

At first, you have to input your email and password to receive your token, so you can make some priviliged requests!!
![authorization](https://i.snipboard.io/JRuHfs.jpg)

An example of a privileged request:
![authorization-example](https://i.snipboard.io/z2SXnc.jpg)

In case you don't have a privileged access, you'll see the following message: 

![status-403-forbidden](https://i.snipboard.io/cAUKH0.jpg)

#### Topics

The forum topics have pagination and cache settings
![forum-topics](https://i.snipboard.io/qhEXCu.jpg)

#### List a specific topic

![specific-topic](https://i.snipboard.io/g2APzJ.jpg)

#### Insert topic

![insert-topic](https://i.snipboard.io/izwTFM.jpg)

#### Update topic

![update-topic](https://i.snipboard.io/RVjXk4.jpg)

#### Remove topic

![remove-topic](https://i.snipboard.io/nuOAY2.jpg)

### How to run the project (Docker)


#### Clone the project

```console
$ git clone https://github.com/ev1illyn/forum-spring-rest-api.git
```

#### *Make sure you have Maven installed* and run the following command at the project directory:

```console
/forum-spring-rest-api$ mvn -DskipTests=true clean package
```

#### Run the docker command to build a image from the Dockerfile inside the project:

```console
/forum-spring-rest-api$ sudo docker build -t img-alura/forum .
```

#### Check if the "img-alura/forum" image was created:

```console
/forum-spring-rest-api$ sudo docker images
```

#### Run the following docker command to start the project:

```console
/forum-spring-rest-api$ sudo docker run -d -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod -e FORUM_DATABASE_URL=jdbc:h2:mem:alura-forum -e FORUM_DATABASE_USERNAME=sa -e FORUM_DATABASE_PASSWORD= -e FORUM_JWT_SECRET=123456 img-alura/forum
```

#### Access the following url:

[http://localhost:8080/topicos](http://localhost:8080/topicos)


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

