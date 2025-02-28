pipeline {
    agent {
        label 'maven' // Use a Maven-capable agent in OpenShift (has Maven and Docker)
    }
    environment {
        APP_NAME = 'answer'
        registry = 'image-registry.openshift-image-registry.svc:5000/gauravattal100-dev'
        BUILD_NUMBER = "${env.BUILD_NUMBER}" // Ensure BUILD_NUMBER is available
    }
    stages {
        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests' // Corrected -DskipTests (lowercase 's')
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${APP_NAME}:${BUILD_NUMBER} ." // Added '.' for build context
            }
        }
        stage('Push Docker Image to Registry') {
            steps {
                sh "docker tag ${APP_NAME}:${BUILD_NUMBER} ${registry}/${APP_NAME}:${BUILD_NUMBER}" // Fixed ${registry}
                sh "docker push ${registry}/${APP_NAME}:${BUILD_NUMBER}" // Fixed ${registry}
            }
        }
        stage('Deploy to OpenShift') {
            steps { // Fixed 'Steps' to 'steps'
                sh "oc set image deployment/${APP_NAME} ${APP_NAME}=${registry}/${APP_NAME}:${BUILD_NUMBER} -n gauravattal100-dev"
            }
        }
    }
}