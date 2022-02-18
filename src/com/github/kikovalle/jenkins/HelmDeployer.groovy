package com.github.kikovalle.jenkins

class HelmDeployer {
  
  static def deploy(script, appNameAndFolder, releaseNamespace) {
    script.sh "echo 'Example to test deployment with helm from a pipeline using a global shared library for app ${appNameAndFolder} and release ${releaseNamespace}'"
    script.sh "curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl"
    script.sh "chmod +x ./kubectl"
    script.sh "mv ./kubectl /usr/local/bin/kubectl"
    
    script.sh "echo 'Going to install helm tool in this step!'"
    script.sh "wget https://get.helm.sh/helm-v3.2.4-linux-amd64.tar.gz"
    script.sh "tar zxfv helm-v3.2.4-linux-amd64.tar.gz"
    script.sh "cp linux-amd64/helm ."
    
    script.sh "echo 'Launching helm to upgrade ${appNameAndFolder} in ${releaseNamespace}!'"
    script.sh "./helm upgrade --install --wait ${appNameAndFolder} ./${appNameAndFolder} -n ${releaseNamespace}"
  }

}
