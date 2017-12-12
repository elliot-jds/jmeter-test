pipeline {
        agent any

        stages {

                // may need to run 'sudo ant download_jars' in a new step?

		stage('Build') {
                        steps {
                                //echo '## Build!!1'
				sh 'sudo ant'
                        }
                }
		stage('Scan with SonarScanner')
		{
			steps {
				sh 'sudo ant sonar -v'
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
