package org.example;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }




    public String checkNameToEmboss() {
        if (name.length() >= 3 && name.length() <= 19 && !name.startsWith(" ") && !name.endsWith(" ") && name.contains(" ")) {
            return "Имя и фамилия подходят для тиснения";
        } else {
            return "Имя и фамилия не подходят для тиснения";
        }
    }
}



