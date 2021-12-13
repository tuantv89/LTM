package model;

import java.io.Serializable;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class ObjectOK implements Serializable {

    static final long serialVersionUID = 2L;
    private Object value;

    public ObjectOK() {
    }

    public ObjectOK(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
