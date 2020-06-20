# Docker-Basic_Structure
Basic skeleton for using docker to initialize a Selenium-hub with 3 nodes (that use Chrome, Firefox and Opera). After that, 4 extra Chrome nodes are created and, then, the tests are executed. Finally, the nodes and the hub are shut down automatically. The tests are very simple since the main purpose of this repository is to provide the basic structure for Docker. Refer to my other repositories for more elaborated test scenarios.

## Requirements
- Maven.
- Docker.

## How to Run
On pom.xml file's dir, enter "mvn test". 

ps: the hub is set to run on port 4444. That can be changed on file 'docker-compose.yaml'.