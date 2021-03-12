pipeline {
    environment {
        JAVA_TOOL_OPTIONS = "-Duser.home=/home/jenkins"
    }
    agent {
        dockerfile {
            label "master"
            args "-v /tmp/maven:/home/jenkins/.m2 -e MAVEN_CONFIG=/home/jenkins/.m2"
        }
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn -version'
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}