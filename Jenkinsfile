pipeline {
        agent any

        stages {
                stage('Build') {
                        steps {
                                echo '## Build!!1'
                        }
                }
		stage('Scan with SonarScanner')
		{
			steps {
				sh 'ant sonar -v'
			}
		}
		//stage('SonarQube analysis') {
		//	steps {
		//		script {
		//			// requires SonarQube Scanner 2.8+
		//			def scannerHome = tool 'sonar-scanner';
		//			withSonarQubeEnv('SonarCloud') {
		//				sh "${scannerHome}/sonar-scanner"
		//			}	
		//		}
		//	}	
		//}
        }
}
