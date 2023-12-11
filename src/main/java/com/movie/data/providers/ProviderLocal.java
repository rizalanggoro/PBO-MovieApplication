/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.data.providers;

import com.movie.core.Either;
import com.movie.core.Failure;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ProviderLocal {

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

}
