# SMS FullStack

## Steps to build the app

- Make sure you have docker and docker-compose install

   - `Docker version 19.03.11, build dd360c7`
   - `docker-compose version 1.25.5`

- In project root directory `docker-compose.yml` is present which will buid the docker images and will also spin up the necessary services.

  - `docker-compose up -d`

Thats it your app shoud be up and running.

## Easy Way - Directly run the app

- Docker images are already push to docker hub required for the project.

- To use them execute the below commands
  - create a docker-compose.yml file in a directory of your choice (find docker-compose.yml file in resources folder)
  - docker pull ajinkyadhote/sms-fs_frontend:v1
  - docker pull ajinkyadhote/sms-fs_sms-backend:v1
  - docker-compose up -d


 Thats it your app shoud be up and running.

## AWS Instance - Direct Acces  - Skip installation
- You skip the installation/buil and can directly access the app
- An Aws Instance is already spin up and is actively running
- To access the Aws Instance, go the the url
 - http://13.232.101.49/#/
