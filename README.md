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

    Step 1: Clone this repo:
            git clone git@github.com:vinrt/FitnessAPI.git

    Step 2: Start the minikube and evaluate:

            // To start minikube -> minikube start
            // To evaluate docker from minikube -> eval $(minikube docker-env)

    Step 3: Build the image using Dockerfile ( Use your choice name but do change in deployment file )
            $PATH_TO_PROJECT/ docker build -t fitness-api-image .

    Step 4: Apply all deployments inside .k8s folder.

            kubectl apply -R -f ${Path_To_K8s_Folder}/.k8s

    Step 5: Verify the deployments applied successfully

            // To verify all
            kubectl get all -n fitness-api

            //To verify ingress
            kubectl get ingress -n fitness-api

    Step 6: To set/forward your localhost using service host.
            Type the command below (May need sudo access):

            vim /etc/hosts
            #Add this for ingress host -> fitness-api-ingress
            127.0.0.1 vinrt.fitness.com

            -OR-

            cat <<  EOF  >> /etc/hosts
            #Add this for ingress host -> fitness-api-ingress
            127.0.0.1 vinrt.fitness.com
            EOF

    Step 7: Add and save file. Verify using cat /etc/hosts

    Step 8: Open new terminal and type this command : 'minikube tunnel'

    Step 9: Verify api url : http://vinrt.fitness.com/swagger-ui.html

 

API URL: http://vinrt.fitness.com/swagger-ui.html




