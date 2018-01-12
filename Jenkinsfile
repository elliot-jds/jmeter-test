
node {
  stage('SCM') {
    git 'https://elliot_jds@bitbucket.org/elliot_jds/jmeter-test.git'
  }
  stage('Build') {
	withAnt(installation: 'ant-installation') {
	//sh "ant download_jars"
        //sh "ant clean install"
	//sh "ant -v"
	sh "## ECS: ant invocation commented out because absence of JavaFX lib causing build error"
    }
  }
  stage('SonarQube analysis') {

	// requires SonarQube Scanner 2.8+
        def scannerHome = tool 'sonar-scanner';
        withSonarQubeEnv('SonarCloud') {
		//echo "${scannerHome}" //..
                //sh "sonar-scanner -X -Dsonar.java.binaries=build/core/** -Dsonar.branch.name=topic_branchscan"
                //sh "sonar-scanner -X -Dsonar.java.binaries=build/core/**"
		sh "${scannerHome}/bin/sonar-scanner -Dsonar.java.binaries=build/core/** -Dsonar.projectKey=jmeter-test-2 -Dsonar.projectName=jmeter-test-2 -Dsonar.projectVersion=3.3.1 -Dsonar.sources=. -Dsonar.organization=elliot_jds-bitbucket"
	}

  }
}
