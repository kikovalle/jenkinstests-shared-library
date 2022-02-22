#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def response = sh(resturnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq -c '.fact' ")
  println "Processed response: ${response}"
  if (response && response.length() > 300) {
    println "Result       : ${response}"
  } else {
    unstable("Result length is not long enough (300 characters minimun)!!!")
  }
}
