package org.techmeskills.aqa5.auf.uiLombok;

import org.techmeskills.aqa5.auf.models.UserOriginal;
import org.testng.annotations.Test;
//НА занятии делали

public class SmokeTestLombok {
    @Test
    public void login() {
        UserOriginal user = UserOriginal.builder()
                .name("Alex")
                .email("Bacurin")
                .build();
        System.out.println(user.toString());




    }
}
