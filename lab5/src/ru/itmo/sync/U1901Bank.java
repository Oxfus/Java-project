package ru.itmo.sync;

public class U1901Bank {
    int intTo;
    int intFrom;

    public synchronized void calc(int intTransaction, long lngTimeout) throws InterruptedException {
        System.out.println("before : " + intTo + " from: " + intFrom + " - thread: " + Thread.currentThread().getName());
        intFrom -= intTransaction;

        Thread.sleep(lngTimeout);

        intTo += intTransaction;

        System.out.println("After : " + intTo + " from: " + intFrom + " - thread: " + Thread.currentThread().getName());
    }
}
