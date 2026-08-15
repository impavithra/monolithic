pipeline {
    agent any

    tools {
        jdk 'Java8'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh '''
                    java -version
                    mvn -version
                    mvn clean test
                '''
            }
        }
    }
}
