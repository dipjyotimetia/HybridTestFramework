pipeline {
    agent  { label 'win-local' }
    stages {
          stage('Build') {
            steps {
                bat 'gradle clean'
            }
          }

          stage('SonarQube analysis') {
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                 bat 'gradle sonarqube'
              }
            }
          }

          stage('End to End Test'){
            steps {
                bat 'gradle E2E -Pdownload=NO -Pcloud=YES'
            }
          }
    }

    post {
      always {
           bat 'gradle allureReport'
              script {
                  allure([
                      includeProperties: false,
                      jdk: '',
                      properties: [],
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'build/allure-results']]
                  ])
              }
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: false,
                    reportDir: 'build/reports/tests/E2E',
                    reportFiles: 'index.html',
                    reportName: 'Gradle Report'
                ]

      }
    }
}