#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )

import groovyx.net.http.RESTClient

def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja"
  
  def response
  try {
    def client = new RESTClient(srvUrl)
    response = client.get(path: "/fact")
    println "Full response: ${response}"
    println "Status       : ${response.status}"
    println "Body         : ${response.data.text}"
    echo "Response OK"
    echo "${response}"
  } catch (Exception e) {
    println "Error      : ${e.statusCode}"
    println "Message    : ${e.response.data}"
  }
}
