
public class ThreadGiay extends Thread {

    Data data;

    public ThreadGiay(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (data) {
                if (count == 60) {
                    count = 0;
                    data.setFlag(2);
                }
                data.setResult("");
                String temp = String.valueOf(count);
                if (count < 10) {
                    temp = "0" + temp;
                }
                data.setResult(":" + temp);
                count++;
                data.setIndex(2);
                data.notifyAll();
                while (data.getIndex() != 1) {
                    try {
                        data.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
                System.out.println();
            }
        }
    }

}
