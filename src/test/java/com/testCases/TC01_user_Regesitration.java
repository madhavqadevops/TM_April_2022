package com.testCases;

import com.pageBheviours.homePage;
import org.testng.annotations.Test;

public class TC01_user_Regesitration {
    @Test
    public void registeruser(){
        homePage homePage=new homePage();
        homePage.signin();
    }
}
