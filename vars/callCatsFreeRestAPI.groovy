#!/usr/bin/env groovy

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
