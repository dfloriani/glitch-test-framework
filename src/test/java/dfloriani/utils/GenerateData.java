package dfloriani.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomAlphaNumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateStringWithAllowedSplChars(int length, String allowedSplChrs){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                allowedSplChrs;
        return RandomStringUtils.random(length, allowedChars);
    }

    public String generateEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                "_-";   //special characters
        String email = "test";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length()-9) + "@test.org";
        return email;
    }

}
