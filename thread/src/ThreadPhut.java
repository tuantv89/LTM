
public class ThreadPhut extends Thread {

    Data data;

    public ThreadPhut(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (data) {
                data.notifyAll();
                while (data.getIndex() != 2) {
                    try {
                        data.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                if (data.getFlag() == 2) {
                    count++;
                }
                data.setFlag(1);
                if (count == 60) {
                    count = 0;
                    data.setFlag(3);
                }
                String temp = String.valueOf(count);
                if (count < 10) {
                    temp = "0" + temp;
                }
                data.setResult(temp + data.getResult());
                data.setIndex(3);
            }
        }
    }

}
