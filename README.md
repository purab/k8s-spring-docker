Docker file add in this project and k8s deployment file is added

Some docker commands and k8s commands
1. create spring boot project (docker-spring)
2. run as -> manven build-> put "clean build"
3. jar need to create in target folder
4. create file named "Dockerfile"

create docker image with docker file
#cd d:\workspace\docker-spring
#docker build -t docker-spring:v1 .

push docker image to docker hub
#docker tag docker-spring purabdk/docker-spring
#docker push purabdk/docker-spring

remove docker images from local docker hub
#docker rmi docker-spring purabdk/docker-spring

docker pull image from docker hub and run it
#docker run -p 8080:8080 purabdk/docker-spring

check running container
#docker ps

stop running container
#docker stop CONTAINER_ID

kuberneties
S D:\workspace\docker-spring\src\main\resources\k8s> kubectl apply -f .\service-account.yaml
service/docker-spring created
PS D:\workspace\docker-spring\src\main\resources\k8s> kubectl apply -f .\deployment.yaml
deployment.apps/docker-spring created

C:\Users\DELL>kubectl run docker-spring --image=docker-spring --port=8080 --image-pull-policy=Never
pod/docker-spring created
#kubectl get deployments
#kubectl expose deployment docker-spring --type=NodePort
#kubectl get services
#kubectl get pods