package model;

import java.io.Serializable;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class IntOK implements Serializable {

    static final long serialVersionUID = 1L;
    private int value;

    public IntOK() {
    }

    public IntOK(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
