
public class ThreadGio extends Thread {

    Data data;

    public ThreadGio(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (data) {
                data.notifyAll();
                while (data.getIndex() != 3) {
                    try {
                        data.wait();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                if (data.getFlag() == 3) {
                    count++;
                }
                data.setFlag(1);
                String temp = String.valueOf(count);
                if (count < 10) {
                    temp = "0" + temp;
                }
                data.setResult(temp + ":" + data.getResult());
                data.setText(data.getResult());
                data.setIndex(1);
            }
        }
    }

}
