
node {
  stage('Build') {
	echo '## Build!'
  }
  stage('SonarQube analysis') {

	// requires SonarQube Scanner 2.8+
        def scannerHome = tool 'SonarQube Scanner 2.8'; //'sonar-scanner';
        withSonarQubeEnv('SonarCloud') {
		echo "${scannerHome}"
                //sh "sonar-scanner -X -Dsonar.java.binaries=build/core/** -Dsonar.branch.name=topic_branchscan"
                //sh "sonar-scanner -X -Dsonar.java.binaries=build/core/**"
	}

  }
}
