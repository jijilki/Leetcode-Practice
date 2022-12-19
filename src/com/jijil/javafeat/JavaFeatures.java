package com.jijil.javafeat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JavaFeatures {

    static Path filePath = Paths.get("C:/", "Jijil","t1.txt");
    public static void main(String[] args) throws IOException {
        // Java 11 ReadString , Write String

        Files.writeString(filePath , "Hello World" , StandardOpenOption.APPEND);
        Files.writeString(filePath , " Amigos" , StandardOpenOption.APPEND);
        String fileContent = Files.readString(filePath);

        System.out.println(fileContent);

    }
}
