#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def response = sh(returnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output '.fact'").trim()
  println "Result       : ${response}"
}
