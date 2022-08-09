String hybridtestframework = 'dipjyotimetia/hybridtestframework:2.0'
pipeline {
    agent {
      docker {
          image "${hybridtestframework}"
        }
     }
    stages {
          stage('Build') {
            steps {
                sh 'gradle clean'
            }
          }

          stage('End to End Test'){
            steps {
                sh 'gradle task web'
            }
          }
    }

    post {
      always {
           //sh 'gradle allureReport'
           //   script {
           //       allure([
           //           includeProperties: false,
           //          jdk: '',
           //          properties: [],
           //          reportBuildPolicy: 'ALWAYS',
           //        results: [[path: 'build/allure-results']]
           //   ])
           //}
                publishHTML target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: false,
                    reportDir: 'build/reports/tests/web',
                    reportFiles: 'index.html',
                    reportName: 'Gradle Report'
                ]

      }
    }
}