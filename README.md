# Moodle Project
[![wercker status](https://app.wercker.com/status/f137ba8fec964f8602b4b7312afe60c2/s/master "wercker status")](https://app.wercker.com/project/byKey/f137ba8fec964f8602b4b7312afe60c2)   
A project created as a project for the Federal Institute Of Sao Paulo, Campinas Campus.

## Requirements
1 -  [Maven](http://maven.apache.org/download.cgi)   
2 - [Java 8 SDK](https://tecadmin.net/install-oracle-java-8-ubuntu-via-ppa/)   
3 - [Heroku](https://devcenter.heroku.com/articles/heroku-cli#download-and-install)

## Running the Application
### Compile 
This will download dependencies, compile the applications and run tests if any   
   
### `mvn clean compile`   
### Package   
Package the application to a `.jar` file, located in the target directory.   


### `mvn package`
### Execute
Using terminal navigate to the target directory and run the following command:    
###`java -jar moodle-project-1.0-SNAPSHOT-jar-with-dependencies.jar`

## Run local instance
To run a local instance of the package type the following in your terminal
### `heroku local web`
