#!/usr/bin/env groovy

def call(String name = "unknown") {
  def minLength = 200
  def srvUrl = "https://catfact.ninja/fact"
  def preResponse = sh(returnStdout: true, script: "curl -X GET -H 'content-type: application/json' ${srvUrl} | jq --raw-output '.' ")
  println "Processed response: ${preResponse}"
  def fact = sh(returnStdout: true, script: "echo '${preResponse}' | jq --raw-output '.fact' ").trim()
  def length  = sh(returnStdout: true, script: "echo '${preResponse}' | jq --raw-output '.length' ").trim()
  println "Fact in response       : ${fact}"
  println "Length of fact text    : ${length}"
  if (Integer.parseInt(length) > minLength) {
    println "Result       : ${fact}"
  } else {
    unstable("Result length ${length} is not long enough ${minLength} characters minimun)!!!")
  }
}
