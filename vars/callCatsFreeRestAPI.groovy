#!/usr/bin/env groovy
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )

import groovyx.net.http.RESTClient

def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja"
  RESTClient client = new RESTClient(srvUrl)
  def response
  try {
      response = client.get(path: "/fact")
      echo "Response OK"
      echo "${response}"
  } catch (RESTClientException e) {
      echo "Response KO"
  }
}
