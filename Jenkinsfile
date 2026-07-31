pipeline {
    agent any
    environment {
        // Binds the global credential named 'secret' to the environment variable STRIPE_KEY
        STRIPE_KEY = credentials('a23179de-0ac6-41a5-96e1-307dd5f19a07')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                // Add your build commands here (e.g., sh 'mvn clean package')
                checkout scmGit(
                    branches: [[name: '*/dev']], 
                    extensions: [], 
                    userRemoteConfigs: [[url: 'https://github.com/vijayuj/stripeAPIAutomation.git']]
                )

            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test commands here (e.g., sh 'mvn test')
                bat 'mvn clean test -DsecretKey=%STRIPE_KEY%'
            }
            
        }
        stage('Test2'){
            steps {
                echo 'Running tests...'
                withCredentials([string(credentialsId: 'a23179de-0ac6-41a5-96e1-307dd5f19a07', variable: 'STRIPE_KEY')]) {
                    bat 'mvn clean test -DsecretKey=%STRIPE_KEY%'
                }
            } // Closed steps block properly
        }
    }
}

