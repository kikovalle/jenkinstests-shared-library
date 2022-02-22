#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def response = sh(returnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output '.fact'").trim()
  if (response && response.length() > 300) {
    println "Result       : ${response}"
  } else {
    println "Result       : ${response} is shorter than 300 characters, so this build will be marked as unstable"
    error "Response is shorter than 300 characters"
  }
}
