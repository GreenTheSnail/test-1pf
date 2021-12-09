
# Exchanging rates
Project to show exchanging rates from database and actualization them using special link (exam for 1pf.cz).




## Tech Stack

**Operation system:** any 

**Backend:** Java 11, Spring

**Application server:** Tomcat(Spring framework)

**Frontend:** HTML(using Thymeleaf)

**Database:** MySQL


## Deployment

To deploy this project run

```bash
  mvn spring-boot:run
```


## API Reference

#### Get all rates

```http
  GET /rates
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `useDb` | `boolean` | **Required**. Desides if data will be from DB or will be from link|



## Authors

- [@vladislav_soshko](https://github.com/GreenTheSnail)

