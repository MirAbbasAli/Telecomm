# Telecomm

A spring boot application based on microservices, it has functionalities related to telcommunication.

#### The functionalities retained in different microservices are:


| Microservice | Functionalities             |
| :----------- | :-------------------------- |
| CustomerMS | View Profile of the customer |
| CallDetailsMS | View Call details |
| PlanMS | View all plans, view specification |
| FriendFamilyMS | Add friend, get all friends for a number |

## Telecomm Microservice Architecture Diagram

![App Screenshot](https://github.com/MirAbbasAli/Telecomm/blob/master/telecomm-design-lb.png)

## API Reference

#### Fetches call details of a specific customer

```
  GET /customers/{phoneNo}/calldetails
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `phoneNo` | `long` | **Required**. phoneNo |

#### Login the customer

```
  POST /login
```


#### Create a new customer

```
  POST /customers
```

#### Fetches full profile of a specific customer

```
  POST /customers/{phoneNo}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `phoneNo` | `long` | **Required**. phoneNo |

#### Create a Friend Family

```
  POST /customers/{phoneNo}/friends
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `phoneNo` | `long` | **Required**. phoneNo |

#### Fetches friend and family numbers of a given customer phoneNo

```
  GET /customers/{phoneNo}/friends
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `phoneNo` | `long` | **Required**. phoneNo |

#### Fetches all plan details

```
  GET /plans
```
#### Fetches Plan for a given planId

```
  GET /plans/{planId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `planId` | `Integer` | **Required**. planId |


## Appendix
Infytel-config server and Infytel-discovery-server are no longer supported in this project. Registration and discovery of microservices are now being handled by Consul. The Configuration of consul server is done in yaml based configuration file in local repository.
