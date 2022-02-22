#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  def result = sh "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output '.fact'"
  println "Result       : ${result}"
}
