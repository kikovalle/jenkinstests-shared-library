package com.github.kikovalle.jenkins

class HelmDeployer {
  
  static def deploy(script, appNameAndFolder, releaseNamespace) {
    script.sh "echo 'Launching helm to upgrade ${appNameAndFolder} in ${releaseNamespace}!'"
    script.sh "./helm upgrade --install --wait ${appNameAndFolder} ./${appNameAndFolder} -n ${releaseNamespace}"
  }

}
