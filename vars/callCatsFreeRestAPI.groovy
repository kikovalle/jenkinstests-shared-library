#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def srvResponse = sh(resturnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output '.' ")
  println "Response before processing it: ${srvResponse}"
  def response = sh(returnStdout: true, script: "echo ${srvResponse} | jq --raw-output '.fact'").trim()
  println "Processed response: ${response}"
  if (response && response.length() > 300) {
    println "Result       : ${response}"
  } else {
    unstable("Result length is not long enough (300 characters minimun)!!!")
  }
}
