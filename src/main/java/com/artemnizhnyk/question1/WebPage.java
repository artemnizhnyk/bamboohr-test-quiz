package com.artemnizhnyk.question1;

public class WebPage {
    private int visitCount;

    public synchronized void incrementVisitCount() {
        visitCount++;
    }

    public int getVisitCount() {
        return visitCount;
    }
}
