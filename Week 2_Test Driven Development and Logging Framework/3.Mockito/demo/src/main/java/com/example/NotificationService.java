package com.example;

public class NotificationService {
    private final UserApi userApi;

    public NotificationService(UserApi userApi) {
        this.userApi = userApi;
    }

    public void notifyUser(String email) {
        userApi.sendEmail(email, "Welcome!");
    }
}
