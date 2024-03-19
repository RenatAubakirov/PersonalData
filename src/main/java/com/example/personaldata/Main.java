package com.example.personaldata;

import com.example.personaldata.data.PersonData;
import com.example.personaldata.file.FileHandler;
import com.example.personaldata.util.DataValidator;
import com.example.personaldata.util.InputFormatException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        System.out.println("Пример ввода: Иванов Иван Иванович 01.01.2000 89122322222 m");
        String input = scanner.nextLine();
        scanner.close();

        try {
            DataValidator.validateInput(input);
            PersonData personData = DataValidator.parseInput(input);
            FileHandler.writeToFile(personData);
            System.out.println("Данные успешно записаны в файл.");
        } catch (InputFormatException | IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
