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

![App Screenshot](https://github.com/MirAbbasAli/Telecomm/blob/master/telecomm-design.png)


## Appendix
Infytel-config server and Infytel-discovery-server are no longer supported in this project. Registration and discovery of microservices are now being handled by Consul. The Configuration of consul server is done in yaml based configuration file in local repository.
