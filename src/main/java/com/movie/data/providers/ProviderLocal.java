/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.data.providers;

import com.movie.core.Either;
import com.movie.core.Failure;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ProviderLocal {

    public boolean isFileExists(String filepath) {
        File file = new File(filepath);
        return file.exists();
    }

    public Either<Failure, String> read(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            scanner.close();
            return Either.right(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            return Either.left(new Failure(e.getMessage()));
        }
    }

    public Either<Failure, Boolean> create(String filepath, String data) {
        try {
            File file = new File(filepath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();

            return Either.right(true);
        } catch (IOException e) {
            return Either.left(new Failure(e.getMessage()));
        }
    }

    public boolean delete(String filepath) {
        File file = new File(filepath);
        return file.delete();
    }

}
