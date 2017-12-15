
node {
  stage('Build') {
	echo '## Build!'
  }
  stage('SonarQube analysis') {

	// requires SonarQube Scanner 2.8+
        def scannerHome = tool 'sonar-scanner';
        withSonarQubeEnv('SonarCloud') {
		//echo "${scannerHome}" //..
                //sh "sonar-scanner -X -Dsonar.java.binaries=build/core/** -Dsonar.branch.name=topic_branchscan"
                //sh "sonar-scanner -X -Dsonar.java.binaries=build/core/**"
		sh "${scannerHome}/bin/sonar-scanner -Dsonar.java.binaries=build/core/**"
	}

  }
}
