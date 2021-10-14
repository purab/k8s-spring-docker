Docker file add in this project and k8s deployment file is added

Some docker commands and k8s commands
1. create spring boot project (docker-spring)
2. run as -> manven build-> put "clean build"
3. jar need to create in target folder
4. create file named "Dockerfile"

create docker image with docker file
```shell
#cd d:\workspace\docker-spring
#docker build -t docker-spring:v1 .
```

push docker image to docker hub
```shell
#docker tag docker-spring purabdk/docker-spring
#docker push purabdk/docker-spring
```

remove docker images from local docker hub
```shell
#docker rmi docker-spring purabdk/docker-spring
```

docker pull image from docker hub and run it
```shell
#docker run -p 8080:8080 purabdk/docker-spring
```

check running container
```shell
#docker ps
```

stop running container
```shell
#docker stop CONTAINER_ID
```

kuberneties
```yaml
apiVersion: v1
kind: ServiceAccount
metadata:
  name: admin-user
  namespace: kubernetes-dashboard
```
D:\workspace\docker-spring\src\main\resources\k8s> kubectl apply -f .\service-account.yaml
service/docker-spring created
```yaml
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRoleBinding
metadata:
  name: admin-user
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
- kind: ServiceAccount
  name: admin-user
  namespace: kubernetes-dashboard
```
PS D:\workspace\docker-spring\src\main\resources\k8s> kubectl apply -f .\deployment.yaml
deployment.apps/docker-spring created

C:\Users\DELL>kubectl run docker-spring --image=docker-spring --port=8080 --image-pull-policy=Never
pod/docker-spring created
```shell
#kubectl get deployments
#kubectl expose deployment docker-spring --type=NodePort
#kubectl get services
#kubectl get pods
```

start dashboard
```shell
#kubectl proxy
```
https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md

kube dashboard url:
http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/workloads?namespace=default