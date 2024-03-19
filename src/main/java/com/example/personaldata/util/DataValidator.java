package com.example.personaldata.util;
import com.example.personaldata.data.PersonData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^(\\S+) (\\S+) (\\S+) (\\d{2}\\.\\d{2}\\.\\d{4}) (\\d+) ([fm])$");

    public static void validateInput(String input) throws InputFormatException {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new InputFormatException("Неверный формат ввода данных: " + input);
        }
    }

    public static PersonData parseInput(String input) throws InputFormatException {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        if (matcher.matches()) {
            PersonData personData = new PersonData();
            personData.setLastName(matcher.group(1));
            personData.setFirstName(matcher.group(2));
            personData.setMiddleName(matcher.group(3));
            personData.setDateOfBirth(matcher.group(4));
            personData.setPhoneNumber(Long.parseLong(matcher.group(5)));
            personData.setGender(matcher.group(6).charAt(0));
            return personData;
        } else {
            throw new InputFormatException("Неверный формат ввода данных: " + input);
        }
    }
}
