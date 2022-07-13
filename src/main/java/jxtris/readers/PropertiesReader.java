package jxtris.readers;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader extends Properties {
    private static final String propertiesDir = "/properties/";
    private final String path;

    public PropertiesReader(String fileName) throws IOException {
        this.path = Objects.requireNonNull(this.getClass().getResource(propertiesDir + fileName)).getPath();
        this.load(new FileReader(path));
    }
    public void store(String comments) throws IOException {
        super.store(new FileWriter(path), comments);
    }
}
