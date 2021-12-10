# Deployment

I have deployed this application on Heroku. It is a Platform as a service provider. It hosts backend application.

I have used Heroku to deploy my application because It makes hosting of application very easy. I had my source code on github. so It provides direct connectivity to github.

# Process to deploy the application to heroku

1) go to https://dashboard.heroku.com/ url and use your login credential.

2) click on new tab and choose "create new app" option and create app.

3) from there connect to your github account and choose your repository.

4) deploy your source code which will lead to generation of custom url.



# How to Use this application
# there are multiple ways to use this application:
1) If you want to use this existing application. you have follow below rules:
    i. Since It provides the url hashing service as rest api. So you have to use PostMan to run this application.
    ii. Hit this "http://localhost:5000" url, it provides to APIs

endPoint (GET /{hash_key}) -> http://localhost:5000/o1t6qn
Internal working: It takes hashKey from the client and check that the database contains a record with this unique hashKey
if it contains, the backend API response with the Original URL to the client.

Response {
    HTTP.STATUS = OK 200
    "https://www.googlehhj.com/add"
}

endPoint (POST /add-url) -> http://localhost:5000/add-url
Internal Working: It takes Long Url from the client and store it in the database with calculated HashKey. HashKey is generated using alphanumerical characters which results to 35^6 hashKey.

RequestBody {
    "url" : "https://www.googlehhj.com/add"
}

Response {
    HTTP.STATUS = CREATED 200
    "http://localhost:5000/o1t6qn"
}

2) If you want to do changes in this application then you have clone this repository in your local system.
cloning: git clone https://github.com/pankaj3108/urlHashingSystem/

Now to set up this application you have to do some changes:
i. go to urlhashing/src/main/resources/application.properties

server.port=5000 # put custom port as per your convienece
# database configuration 
#i. datasource url 
#ii. database Name
#iii. datasource username
#iv datasource password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/urlinfo
spring.datasource.username = root
spring.datasource.password = *****