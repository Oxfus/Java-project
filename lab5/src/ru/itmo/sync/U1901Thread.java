package ru.itmo.sync;

public class U1901Thread extends Thread {
    int intTrans;
    long lngSleep;
    U1901Bank bankWork;

    U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.lngSleep = lngSleep;
        this.intTrans = intTrans;
        this.bankWork = bankWork;
    }

    public void run() {
        try {
            bankWork.calc(intTrans, lngSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
