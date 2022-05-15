package com.pontusasp.game.core;

import java.util.ArrayList;

/**
 * Created by Pontus on 2018-04-29.
 */
public class Updater implements Dynamic {

    private Loop loop;

    private ArrayList<Dynamic> queue = new ArrayList<>();

    public Updater() {
        loop = new Loop();
    }

    public void start() {
        (new Thread(loop)).start();
    }

    public void stop() {
        loop.running = false;
    }

    public void addToQueue(Dynamic dynamic) {
        queue.add(dynamic);
    }

    public void removeFromQueue(Dynamic dynamic) {
        queue.remove(dynamic);
    }

    public void removeFromQueue(int index) {
        queue.remove(index);
    }

    @Override
    public void update(float delta) {
        for (Dynamic item : queue) {
            item.update(delta);
        }
    }

    class Loop implements Runnable {
        boolean running;

        @Override
        public void run() {
            running = true;
            float delta = 0;
            long startTime, endTime;
            try {
                while (running) {
                    startTime = System.nanoTime();
                    if (delta < 0.0000001f) {
                        Thread.sleep(0, 100);
                    }
                    Updater.this.update(delta);
                    endTime = System.nanoTime();
                    delta = (endTime - startTime) / 1000000000f;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
