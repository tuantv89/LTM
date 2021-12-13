
public class Data {

    private int flag, index;
    private Clock output;
    private String result = "";

    public Data(int flag, int index, Clock c) {
        this.flag = flag;
        this.index = index;
        output = c;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setText(String s) {
        output.show(s);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
