package main;

import java.util.List;
import java.util.Random;

enum ALGORITHMS {
  RANDOM,
  ROUND_ROBIN,
  WEIGHTED_ROUND_ROBIN
}

public class LoadBalancer {

  private List<Server> servers;
  private ALGORITHMS algorithm = ALGORITHMS.RANDOM;

  private int roundRobinTracker = 0;

  LoadBalancer(List<Server> servers, ALGORITHMS algorithm) {
    this.servers = servers;
    this.algorithm = algorithm;
  }

  private void random(Request request) {
    this.servers.get(new Random().nextInt(servers.size())).serve(request);;
  }

  private void roundRobin(Request request) {
    this.servers.get(roundRobinTracker).serve(request);
    roundRobinTracker = (roundRobinTracker + 1) % servers.size();
  }

  public void assign(Request request) {
    switch (this.algorithm) {
      case ROUND_ROBIN:
        roundRobin(request);
        break;
      case RANDOM:
        random(request);
        break;
      default:
        System.out.println("No algo specified");
        break;
    }
  }
}
