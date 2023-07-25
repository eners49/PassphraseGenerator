pipeline {
        agent any

        stages {
                stage('Compile') {
                     steps {
                            withGradle {
                                    sh 'chmod u+x gradlew'
                                    sh './gradlew build'
                            }
                     }
                }
                stage('Test') {
                        steps {
                                withGradle {
                                        sh 'chmod u+x gradlew'
                                        sh './gradlew test'
                                }
                        }
                }
           stage('Build') {
                    steps {
                            withGradle {
                                   sh 'chmod u+x gradlew'
                                   sh './gradlew run'
                           }
                   }
           }
           stage('SonarQube Analysis') {
                    steps {
                            withGradle {
                                    sh 'chmod u+x gradlew'
                                    sh './gradlew build jacocoTestReport sonar'
                            }
                    }
           }
	   /*stage('Quality Gate') {
		steps {
			script {
				def qualitygate = waitForQualityGate()
				if (qualitygate.status != "OK") {
					error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
				}
			}
		}
	   }*/
				
           stage('Create Jar File') {
                    steps {
                            withGradle {
                                    sh 'chmod u+x gradlew'
                                    sh './gradlew jar'
                            }
                   }
            }
            stage ('Containerize Application') {
                    steps {
                    		sh 'ls -la'
				sh 'docker build -t mynavyl.azurecr.us/popescu/passphrasegenerator:${BUILD_NUMBER} .'
                                sh 'docker run -d -it --name passphrasegenerator_${BUILD_NUMBER} passphrasegenerator'
                                sh 'docker logs passphrasegenerator_${BUILD_NUMBER}'
                    }
            }
        }
	post {
		always {
			sh 'echo "This will always be printed."'
		}
		success {
			sh 'echo "This will only be printed if the job was successful."'
			sh 'echo "The job was successful" | mailx -s "Alert" jenkins'
		}
		failure {
			sh 'echo "This will only be printed if the job failed."'
		}
		unstable {
			sh 'echo "This will only be printed if the run was marked as unstable."'
		}
		changed {
			sh 'echo "This will only be printed if the state of the pipeline has changed."'
		}
	}
}