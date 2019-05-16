# stocalm-backend

## Requirements

### Nodejs & npm
* Download https://nodejs.org/en/
* For npm, see https://www.npmjs.com/get-npm

### MongoDB 
* To install: https://docs.mongodb.com/v3.2/administration/install-community/
* For Windows, check system environment variables: https://stackoverflow.com/a/41507803

### Setting up your own test MongoDB
* Register a MongoDB user https://www.mongodb.com/download-center
* Follow the onboarding process to create a cluster (choose all free tier)

* Then do the following:
1. Go to Project -> Clusters
1. In the cluster you created during the onboarding process, click Connect
1. Whitelist your connection IP-adress
1. Create a user (remember username and password, as this will be used in the backend)
1. Choose Connect your application
1. For this project, choose Java as Driver and newest version
1. Copy the string for Connection String Only
1. Close the Connect to cluster window
1. In the cluster view, click Collections
1. Add a new collection/database, with the database "Stocalm"
1. Collection name as "sensors"

* In your IDE:
1. Fetch the newest version of stocalm-backend
1. Create your new branch
1. In resources -> applications.properties
1. Change the string for spring.data.mongodb.uri to the string from Connect, in above steps, and change "test" to "Stocalm", it should look like the following: `mongodb+srv://Username:<Password>@cluster0-nrory.mongodb.net/Stocalm?retryWrites=true`
1. Run StocalmApplication 

**To post objects to your database through Postman** INTE FÄRDIG
* Download and install Postman https://www.getpostman.com/
* To post to your test MongoDB:
1. In the dropdown menu, choose POST
1. Set the URL to ´localhost:8080/readingsApi/sensor/post´
1. Go to the tab Body, check Raw
1. Click the Text-dropdown and choose JSON (application/json)
1. 



### Ionic 
* To install: https://ionicframework.com/getting-started#cli

## To run
1. Starta mongoDB genom att i terminalen skriva ​`mongod`
1. Öppna backend-delen i din IDE 
1. Kör (Run) programmet från klassen StocalmApplication 
_(Om det inte går att köra program/run i intelliJ, dubbelkolla så att java-mappen (src -> main -> java) är inställd som Sources root, annars högerklicka Java-mappen och Mark directory as... -> Sources root.)_
1. Öppna frontend-delen i din IDE
1. I terminalen, gå till mappen för projektet.(IntelliJ har en inbyggd terminal. Du kan klicka upp den genom att längst ner klicka på “Terminal”. Sen räckerdet att man klickar på plusset för att få upp en ny terminal med start från mappen).
1. Kör kommandot `ionic serve`
1. Testa att det fungerar genom att gå till ​http://localhost:8100 
1. Klart.
