package com.artemnizhnyk.question1;

public class VisitCounter {
    public static void main(String[] args) {
        WebPage webPage = new WebPage();

        int numberOfThreads = 10;
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    webPage.incrementVisitCount();
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total visit count: " + webPage.getVisitCount());
    }
}
//----------
