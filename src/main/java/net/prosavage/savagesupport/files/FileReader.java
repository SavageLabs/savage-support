package net.prosavage.savagesupport.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {


    private String path;

    public FileReader(String path) {
        this.path = path;
    }


    public String getFileContents() {
        String str = null;
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            str = new String(data, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return str;

    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
