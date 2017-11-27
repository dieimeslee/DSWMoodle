# Moodle Project
[![wercker status](https://app.wercker.com/status/f137ba8fec964f8602b4b7312afe60c2/s/master "wercker status")](https://app.wercker.com/project/byKey/f137ba8fec964f8602b4b7312afe60c2)   
A project created as a project for the Federal Institute Of Sao Paulo, Campinas Campus.
## Requirements
1 -  [Maven](http://maven.apache.org/download.cgi)   
2 - [Java 8 SDK](https://tecadmin.net/install-oracle-java-8-ubuntu-via-ppa/)   
3 - [Heroku](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)   
### Other technologies used
- [Feign](https://github.com/OpenFeign/feign)   
- [JUnit5](http://junit.org/junit5/)   
## Running the Application
### Compile 
This will download dependencies and compile the application
### `mvn clean compile`   

### Test 
This will run all unit tests
### `mvn test` 

### Package   
Package the application to a `.jar` file, located in the target directory.   
### `mvn package`

### Execute
OBS: Do not try to run the main class directly, it will **NOT** work
#### Run local instance through jar directly
Using terminal navigate to the target directory and run the following command:    
#### `java -jar moodle-project-1.0-SNAPSHOT-jar-with-dependencies.jar`

#### Run local instance through Heroku
To run a local instance of the package type the following in your terminal
#### `heroku local web`
