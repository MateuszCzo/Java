package mc.project.multithreading;

import java.util.Vector;

public class Main {
    static class ThreadTask extends Thread {
        private int threadNum;
        ThreadTask(int threadNum) {
            this.threadNum = threadNum;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadTask: " + this.threadNum + " value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    static class RunnableTask implements Runnable {
        private int threadNum;
        RunnableTask(int threadNum) {
            this.threadNum = threadNum;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("RunnableTask: " + this.threadNum + " value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++) {
//            (new ThreadTask(i)).start();
//        }
//        for (int i = 0; i < 4; i++) {
//            (new Thread(new RunnableTask(i))).start();
//        }

        Thread[] tasks = new Thread[3];
        for (int i = 0; i < 3; i++) {
            tasks[i] = new Thread(new RunnableTask(i));
            tasks[i].start();
        }
        System.out.println(tasks[0].isAlive() ? "alive" : "dead");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println(tasks[0].isAlive() ? "alive" : "dead");

        for (int i = 0; i < 3; i++) {
            try {
                tasks[i].join();
            } catch (InterruptedException e) {

            }
        }
        System.out.println("end");
    }
}
