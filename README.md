# FitnessAPI
This is PoC application using docker with K8s deployment
## Author
[Vinay Tiwari ](https://github.com/vinrt)

### Installation:
    Java
    Minikube
    Docker


### Tech stack:
    IntelliJ
    SpringBoot 2.2.11
    Java 11
    Swagger
    Docker
    K8s


### Project setup instructions
To start using this project use the following commands:

    Step 1: git clone git@github.com:vinrt/FitnessAPI.git
    
    Step 2: eval $(minikube docker-env)
    
    Step 3: $PATH_TO_PROJECT/ docker build -t image_name .
    
    Step 4: kubectl apply -R -f ${Path_To_K8s_Folder}/.k8s

    Step 5: kubectl get all -n fitness-api

    Step 6: vim /etc/hosts //( use sudo command in case)

    Step 7: Add -> 127.0.0.1 vinrt.fitness.com and save file, verify using cat /etc/hosts

    Step 8: In terminal type this command : 'minikube tunnel'

    Step 9: Verify api url : http://vinrt.fitness.com/swagger-ui.html

 

API URL: http://vinrt.fitness.com/swagger-ui.html




