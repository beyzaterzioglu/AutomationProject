pipeline {
  agent any

  tools {
    jdk 'temurin-17'
    maven 'maven-3.9'
  }

  options {
    timestamps()
    buildDiscarder(logRotator(numToKeepStr: '20'))
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build & Test') {
      steps {
        // Windows ajanı -> bat
        bat 'mvn -B clean test'
        // Maven Wrapper kullanıyorsan:
        // bat '.\\mvnw.cmd -B clean test'
      }
    }

    stage('Publish Reports') {
      steps {
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: 'target/**/*.log, target/screenshots/**/*.*', allowEmptyArchive: true
    }
  }
}
