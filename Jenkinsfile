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

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube-Connection') {
                    sh '''
                        mvn sonar:sonar \
                          -Dsonar.projectKey=snowman-ci-cd \
                          -Dsonar.projectName=snowman-ci-cd
                    '''
                }
            }
        }
    }
}
