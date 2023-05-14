package org.task3_1.dataModels;

import lombok.Data;

import java.util.HashMap;

@Data
public class UserInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public UserInfo() {
    }

    public UserInfo(HashMap<String, String> userMap) {
        firstName = userMap.get("firstName");
        lastName = userMap.get("lastName");
        age = userMap.get("age");
        email = userMap.get("email");
        salary = userMap.get("salary");
        department = userMap.get("department");
    }

    public UserInfo(String[] row) {
        firstName = row[0];
        lastName = row[1];
        age = row[2];
        email = row[3];
        salary = row[4];
        department = row[5];
    }
}