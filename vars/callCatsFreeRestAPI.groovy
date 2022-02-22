#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def preResponse = sh(returnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output -c '.' ")
  println "Processed response: ${preResponse}"
  def response = sh(returnStdout: true, script: "echo '${preResponse}' | jq --raw-output -c '.fact' ")
  println "Processed response: ${response}"
  if (response && response.length() > 300) {
    println "Result       : ${response}"
  } else {
    unstable("Result length is not long enough (300 characters minimun)!!!")
  }
}
