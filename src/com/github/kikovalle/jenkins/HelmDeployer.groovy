package com.github.kikovalle.jenkins

class HelmDeployer implements Serializable {
  
  static def deploy(script, releaseName, appNameAndFolder, releaseNamespace) {
    script.sh "echo 'Launching helm to upgrade ${appNameAndFolder} in ${releaseNamespace}!'"
    script.sh "helm package  ./${appNameAndFolder} -u"
    script.sh "helm upgrade --install --wait  ${releaseName} ./${appNameAndFolder} -n ${releaseNamespace}"
  }

}
