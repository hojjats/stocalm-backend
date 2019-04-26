# stocalm-backend

## Requirements

### Nodejs & npm
* Download https://nodejs.org/en/
* For npm, see https://www.npmjs.com/get-npm

### MongoDB 
* To install: https://docs.mongodb.com/v3.2/administration/install-community/
* For Windows, check system environment variables: https://stackoverflow.com/a/41507803

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
