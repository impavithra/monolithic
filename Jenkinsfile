pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh '''
                    export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
                    export PATH=$JAVA_HOME/bin:$PATH

                    java -version
                    mvn -version
                    mvn clean test
                '''
            }
        }
    }
}
