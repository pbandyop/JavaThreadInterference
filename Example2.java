//Source: https://github.com/gomson/java-creed-examples/tree/master/concurrency
// Edited: Payel Bandyopadhyay Dated: April 24, 2017

import java.util.ArrayList;
import java.util.List;

public class Example2 {

  static int x;

  public static void main(final String[] args) throws Exception {
    for (int run = 0, numberOfThreads = 100; run < 1000; run++) {
      System.out.printf("Run %05d.....", run + 1);
      final Data data = new Data();

      final List<Thread> threads = new ArrayList<>(numberOfThreads);
      for (int i = 0; i < numberOfThreads; i++) {
        final Thread thread = new Thread(new Runnable() {
          @Override
          public void run() {
            final int value = data.getValue();
            final int tainted = data.setValue(value + 1);
            x = tainted;
          }
        });
        thread.start();
        threads.add(thread);
      }

      for (final Thread thread : threads) {
        thread.join();
      }

      if (data.getValue() == numberOfThreads) {
        System.out.println("Passed");
      } else {
        System.out.printf("Failed with value %d instead of %d%n", data.getValue(), numberOfThreads);
        break;
      }
    }
  }

}
