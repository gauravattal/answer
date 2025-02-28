pipeline
{
agent any
environment{
APP_NAME = 'answer'
Registry = 'image-registry.openshift-image-registry.svc:5000/gauravattal100-dev'
}
stages
{
stage('Build JAR')
{
steps
{
sh 'mvn clean package  -DSkipTests'
}
}

stage('Build Docker Image')
{
steps
{
sh "docker build -t ${APP_NAME}:${BUILD_NUMBER}"
}
}

stage('push docker image to registry')
{
steps
{
sh "docker tag ${APP_NAME}:${BUILD_NUMBER} {REGISTRY}/${APP_NAME}:${BUILD_NUMBER}"
sh "docker push {REGISTRY}/${APP_NAME}:${BUILD_NUMBER}"
}
}
stage('Deploy to OpenShift')
{
Steps
{
sh "oc set image deployment/${APP_NAME} ${APP_NAME}={REGISTRY}/${APP_NAME}:${BUILD_NUMBER} -n gauravattal100-dev"
}
}
}


}