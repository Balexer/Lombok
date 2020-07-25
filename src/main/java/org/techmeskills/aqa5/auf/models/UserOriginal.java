package org.techmeskills.aqa5.auf.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//НА занятии делали

@Data
@Getter
@Setter
@Builder

public class UserOriginal {
    private String name;
    private String surname;
    private String email;
    private boolean isActive;
    private int age;
    private int id;
    private String username;
    private String password;
    private String address;


}
