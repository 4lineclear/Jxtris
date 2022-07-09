package jxtris.readers;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader extends Properties {
    private static final String propertiesDir = "/properties/";
    private final FileWriter writer;

    public PropertiesReader(String fileName) throws IOException {
        String path = Objects.requireNonNull(this.getClass().getResource(propertiesDir + fileName)).getPath();
        this.writer = new FileWriter(path);
        this.load(new FileReader(path));
    }
    public void store(String comments) throws IOException {
        super.store(writer, comments);
    }
}
