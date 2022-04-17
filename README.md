<div id="top"></div>

<br />
<div align="center">
<h2 align="center">Student Management</h2>

  <p align="center">
    Web Application based on Spring MVC, Spring Data JPA et Spring Security for managing students  
    <br />
 
  </p>
</div>

  ![App](https://user-images.githubusercontent.com/80859231/163698705-943ba496-f101-472a-825f-c8a06e6030e0.gif)
  
  

## Built With
* [Spring](https://spring.io/)
* [Thymeleaf](https://www.thymeleaf.org/)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

We will create a web application based on spring and thymleaf template engine , also we will use spring security in order to secure our app 🤙   .


### Creation of Student Entity
 [Student.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/entities/Student.java)
 <br>
![image](https://user-images.githubusercontent.com/80859231/163698964-fb8a084d-828d-45ad-86e9-653e7cbcbfea.png)

### Creation of Student Repository
 [StudentRepository.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/repositories/StudentRepository.java)
 <br>
 ![image](https://user-images.githubusercontent.com/80859231/163699015-c634456a-d8e8-4ebc-8758-2c077d8d75e6.png)
 
 
### Creation of Student Controller

this controller will handle all app requests , it has a lot of functions but the screenshot contains just some of theme otherwise you will leave from this repo 😆 <br>
 [PatientController.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/web/StudentController.java)
 <br>
![image](https://user-images.githubusercontent.com/80859231/163699104-e12f911d-97ed-47b0-a839-e0469d022fdc.png)


### Security 
in this section we will secure our app by adding users with roles , so we will create two entities one for users and one for roles.
<br>
#### User entity
* [AppUser.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/entities/AppUser.java)

![image](https://user-images.githubusercontent.com/80859231/163400259-666d35cc-6dee-4693-acf9-6cd5ca78d1ca.png)

#### Role entity
* [AppRole.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/entities/AppRole.java)

![image](https://user-images.githubusercontent.com/80859231/163400872-d5b19b0c-beab-46d5-9777-f9d9a1a98407.png)

Now we should create repositories for both entities
####  User Repository
* [AppUserRepository.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/repositories/AppUserRepository.java)

![image](https://user-images.githubusercontent.com/80859231/163401598-a5a1ea0f-f1ea-474a-b2c9-226b977dccf0.png)

####  Role Repository
* [AppRoleRepository.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/repositories/AppRoleRepository.java)

![image](https://user-images.githubusercontent.com/80859231/163402055-50fc5e93-41cc-4004-bd07-92e5f55c42fe.png)

Now we should add an interface that contains all methods we will use to handle users with their roles

### SecurityService
* [SecurityService.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/service/SecurityService.java)

![image](https://user-images.githubusercontent.com/80859231/163402966-80f58831-8ab6-4192-ada6-dd721e64b18b.png)

### Implementation of SecurityService 

* [SecurityServiceImpl.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/service/SecurityServiceImpl.java)

![image](https://user-images.githubusercontent.com/80859231/163403482-b345e4e8-4dc5-442c-939a-2f8da123ac40.png)

the image above dosen't contains all implemented methods .

### UserDetailsService 

* [UserDetailsServiceImpl.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/service/UserDetailsServiceImpl.java)


![image](https://user-images.githubusercontent.com/80859231/163404494-68ded470-8ea0-4160-a860-7ef95f59cb39.png)

### SecurityConfig
* [SecurityConfig.java](https://github.com/zakariamanssouri/Student-Management-Application/blob/master/src/main/java/ma/enset/security/SecurityConfig.java)

![image](https://user-images.githubusercontent.com/80859231/163699280-8ebdc4bb-02db-4968-862e-9b3fc0b345c1.png)
