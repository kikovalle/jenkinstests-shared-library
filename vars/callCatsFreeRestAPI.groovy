#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def response = sh(returnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output '.fact'").trim()
  if (response && response.length() > 150) {
    println "Result       : ${response}"
  } else {
    println "Result       : ${response} is shorter than 150 characters, so this build will be marked as unstable"
    error "Response is shorter than 150 characters"
  }
}
