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


## Verify docker-compose.yml file structure

```
  docker build -f Dockerfile -t telecomm-mysql-image:latest .
```
If everything is fine then, it will print the content of the file otherwise it will throw error

## Executing Docker Compose
For starting the services use the below commands:

```
  docker-compose up -d
```
This command will create the given docker network and then create the docker instances. Once all containers are created, this will start them.

To stop all your services, use the below command:

```
  docker-compose down
```
Use the below command to see the running containers

```
  docker ps -a
```

## Appendix
Infytel-config server and Infytel-discovery-server are no longer supported in this project. Registration and discovery of microservices are now being handled by Consul. The Configuration of consul server is done in yaml based configuration file in local repository.