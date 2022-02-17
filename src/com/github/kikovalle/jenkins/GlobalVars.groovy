package com.girhub.kikovalle.jenkins

class GlobalVars {

  static String defaultDeveloper = "Kiko Valle González"
  static String githubUrl = "https://github.com/kikovalle/jenkinstests-shared-library"

  static def mvn(script, args) {
    script.sh "${script.tool 'maven'}/bin/mvn -s ${script.env.HOME}/jenkins.xml -o ${args}"
  }
  
}
