package com.example.personaldata.file;

import com.example.personaldata.data.PersonData;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void writeToFile(PersonData personData) throws IOException {
        String fileName = personData.getLastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(personData.getLastName() + " " + personData.getFirstName() + " " +
                    personData.getMiddleName() + " " + personData.getDateOfBirth() + " " +
                    personData.getPhoneNumber() + " " + personData.getGender() + "\n");
        }
    }
}
