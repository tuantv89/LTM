package controller;

import java.io.*;
import java.util.*;

/**
 *
 * @author Thiều Văn Tuấn
 */
public class IOFile {

    public static <T> List<T> read(String file) {
        List<T> list = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            list = (List<T>) in.readObject();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return list;
    }

    public static <T> void write(String file, List<T> list) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(list);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
