#!groovy
@Library('ptaq-library') _

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
            bobcat gridUrl: 'http://192.168.99.100:4444/wd/hub', browser: 'chrome'
        }
    }
}
