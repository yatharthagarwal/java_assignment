package com.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest/*")
public class Application extends ResourceConfig {

	public Application() {
      super();
      System.out.println("print");
      packages("com.example.demo");
  }
}