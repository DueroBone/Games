import java.util.ArrayList;

public class ThreadManager {
  private ArrayList<Thread> threads = new ArrayList<>();
  int maxThreads = 0;
  private SuperThread superThread;
  public int completedThreads = 0;

  public void setMaxThreads(int maxThreads) {
    this.maxThreads = maxThreads;
  }

  public void addThread(Thread thread) {
    threads.add(thread);
  }

  public void addThreads(ArrayList<Thread> threads) {
    this.threads.addAll(threads);
  }

  public void addThreads(Thread[] threads) {
    for (Thread thread : threads) {
      this.threads.add(thread);
    }
  }

  public Thread[] getThreads() {
    return threads.toArray(new Thread[threads.size()]);
  }

  public void startAll() {
    superThread = new SuperThread();
    superThread.start();
  }

  public void joinAll() {
    joinAll(false);
  }

  public void joinAll(boolean progressBar) {
    try {
      // finish starting all threads
      while (superThread.getState() != Thread.State.TERMINATED) {
        if (progressBar) {
          double progress = (double) completedThreads / (double) threads.size();
          int barLength = 50;
          System.out.print("\r|");
          for (int i = 0; i < barLength; i++) {
            if (i < progress * barLength) {
              System.out.print("-");
            } else {
              System.out.print(" ");
            }
          }
          System.out.print("| " + (int) (progress * 100) + "% started" + " (" + completedThreads + "/" + threads.size()
              + ")" + " " + threads.size() + " threads");
        }
        Thread.yield();
        Thread.sleep(10);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (Thread thread : threads) {
      try {
        // finish all threads
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private class SuperThread extends Thread {
    @Override
    public void run() {
      setPriority(6);
      while (true) {
        int running = 0;
        for (Thread thread : threads) {
          // System.out.println(thread.getName() + ": " + thread.getState()+  " running: " + running);
          if (thread.getState() == State.TERMINATED) {
            // threads.remove(thread);
          } else if (thread.getState() == State.NEW && running < maxThreads) {
            running++;
            thread.start();
          } else if (running >= maxThreads) {
            try {
              sleep(10);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          } else {
            // System.out.println("===========");
          }
        }
        int counter = 0;
        for (Thread thread : threads) {
          if (thread.getState() == State.TERMINATED) {
            counter++;
          }
        }
        completedThreads = counter;
        if (threads.size() == counter) {
          break;
        }
      }
    }
  }
}