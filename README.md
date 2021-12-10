# welcome to urlHashingSystem

########################### Architecture #################################

#Objective: 
Main function of this URL hashing System is to convert long url to short url which helps marketing team to manages url's in effetive way. It has expiary date feature where generated url will be valid upto 7 days, after this url will be deleted.

#Overview:
I have built this URL Hashing System using Java8 as server side language. used Spring boot framework for development of REST API.
Spring boot is java-based MVC framework which provides an easier and faster way to develop standalone application. It is built on top of Spring Framework.

I have used MySQL database for storing data of URLs.

for Testing of Api I have used Postman.

#Illustration

Client(PostMan) <---- HTTPS Requsts ---> Controller  <---->   Service Layer  <------>  Repository Layer(Model) -------> Database
