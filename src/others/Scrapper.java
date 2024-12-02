package others;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Scrapper {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 15; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        ScrapService.Instance.scrape();
                    }
                });
                
            }
        }
        }
    }

    enum ScrapService {
        Instance;

        private Semaphore semaphore = new Semaphore(2);

        public void scrape() {
            try {
                semaphore.acquire();
                invokeScrapeBot();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }

        }

        private void invokeScrapeBot() {
            try {
                System.out.println("Scraping data...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
