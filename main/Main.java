package main;

import java.util.ArrayList;
import java.util.List;


public class Main {
  public static void main(String[] args) {
    System.out.println("Main app :-)");

    List<Server> servers = new ArrayList<>();

    Server server1 = new Server("192.32.2.1", "s1");
    Server server2 = new Server("192.32.2.2", "s2");
    Server server3 = new Server("192.32.2.3", "s3");
    Server server4 = new Server("192.32.2.4", "s4");

    servers.add(server1);
    servers.add(server2);
    servers.add(server3);
    servers.add(server4);

    LoadBalancer loadBalancer = new LoadBalancer(servers, ALGORITHMS.ROUND_ROBIN);

    for(int i=0; i<20; i++) {
      loadBalancer.assign(new Request("GET", "/hello"));
    }
  }
}
