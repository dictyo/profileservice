package de.allmaennitta.profileservice.integration;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class ResponseResults {
  private final ClientHttpResponse theResponse;
  private final String body;

  ResponseResults(final ClientHttpResponse response) throws IOException {
    this.theResponse = response;
    final InputStream bodyInputStream = response.getBody();
    final StringWriter stringWriter = new StringWriter();
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    IOUtils.copy(bodyInputStream, baos);
    this.body = baos.toString("UTF-8");
  }

  ClientHttpResponse getTheResponse() {
    return theResponse;
  }

  String getBody() {
    return body;
  }
}