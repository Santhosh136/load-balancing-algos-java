package main;

class Server {
  String ipAddress;
  String name;

  Server(String ipAddress, String name) {
    this.ipAddress = ipAddress;
    this.name = name;
  }

  public void serve(Request request) {
    System.out.println("Server :" + this.name + " => Serving request: " + request);
  }
}

