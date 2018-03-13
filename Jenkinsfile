#!groovy

def modules = ['Module 1', 'Module 2', 'Module 3', 'Module 4']

node('master') {

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        def steps = [:]

        modules.each {
            steps[it] = {
                echo "Building our app: $it!"
            }
        }

        parallel steps
    }
    
    stage('Deploy') {
        echo 'Deploying our app!'
    }
    
    stage('Test') {
        dir('bobcat') {
            withMaven(maven: 'maven') {
                sh 'mvn clean test -Dwebdriver.type=remote -Dwebdriver.url=http://192.168.99.100:4444/wd/hub -Dwebdriver.cap.browserName=chrome'
            }
            junit testResults: 'target/*.xml'
            archiveArtifacts 'target/**'
        }
    }
}