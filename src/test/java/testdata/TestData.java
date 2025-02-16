package testdata;

import models.User;

public class TestData {

    public static final User DEFAULT_USER = User.builder()
            .username("username")
            .firstName("firstname")
            .lastName("lastname")
            .email("build@gmail.com")
            .phone("12345689")
            .password("password")
            .id(1231231)
            .userStatus(0)
            .build();

    public static final User INVALID_USER = User.builder().build();
}
