package model;

import java.io.Serializable;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class StringOK implements Serializable {

    static final long serialVersionUID = 3L;
    private String value;

    public StringOK() {
    }

    public StringOK(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
