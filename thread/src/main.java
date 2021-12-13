
public class main {

    public static void main(String[] args) {
        Clock c = new Clock();
        Data data = new Data(1, 1, c);
        c.setTitle("Bộ đếm thời gian");
        c.setVisible(true);
        ThreadGiay t1 = new ThreadGiay(data);
        ThreadPhut t2 = new ThreadPhut(data);
        ThreadGio t3 = new ThreadGio(data);
        t1.start();
        t2.start();
        t3.start();
    }
}
