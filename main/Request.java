package main;

public class Request {
  private String method;
  private String path;

  Request(String method, String path) {
    this.method = method;
    this.path = path;
  }

  public String toString() {
    return "Request : " + this.method + " "+ this.path;
  }
}
