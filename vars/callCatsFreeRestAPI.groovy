#!/usr/bin/env groovy
def call(String name = "unknown") {
  def srvUrl = "https://catfact.ninja/fact"
  sh "curl -X GET -H 'content-type: application/json' ${srvUrl}"
}
