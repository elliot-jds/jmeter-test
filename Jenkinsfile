
node {
  stage('SCM') {
    git 'https://elliot_jds@bitbucket.org/elliot_jds/jmeter-test.git'
  }
  stage('Build') {
	//withAnt(installation: 'ant-installation') {
	sh "## ant invocation commented out because absence of JavaFX lib causing build error"
	//}
  }
  stage('SonarQube analysis') {
	// Requires SonarQube Scanner 2.8+
        def scannerHome = tool 'sonar-scanner';
	withSonarQubeEnv('SonarCloud') {
		sh "${scannerHome}/bin/sonar-scanner -Dsonar.java.binaries=build/core/** -Dsonar.projectKey=jmeter-test-2 -Dsonar.projectName=jmeter-test-2 -Dsonar.projectVersion=3.3.1 -Dsonar.sources=. -Dsonar.organization=elliot_jds-bitbucket"
		}
	}
}
