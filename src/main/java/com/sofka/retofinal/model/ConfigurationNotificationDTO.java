package com.sofka.retofinal.model;

public class ConfigurationNotificationDTO {

    private String userId;
    private Boolean oKRFinishScreen;
    private Boolean kRFinishScreen;
    private Boolean kRLateScreen;
    private Boolean oKREditScreen;

    public ConfigurationNotificationDTO(){}

    public ConfigurationNotificationDTO(String userId, Boolean oKRFinishScreen, Boolean kRFinishScreen, Boolean kRLateScreen, Boolean oKREditScreen) {
        this.userId = userId;
        this.oKRFinishScreen = oKRFinishScreen;
        this.kRFinishScreen = kRFinishScreen;
        this.kRLateScreen = kRLateScreen;
        this.oKREditScreen = oKREditScreen;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getoKRFinishScreen() {
        return oKRFinishScreen;
    }

    public void setoKRFinishScreen(Boolean oKRFinishScreen) {
        this.oKRFinishScreen = oKRFinishScreen;
    }

    public Boolean getkRFinishScreen() {
        return kRFinishScreen;
    }

    public void setkRFinishScreen(Boolean kRFinishScreen) {
        this.kRFinishScreen = kRFinishScreen;
    }

    public Boolean getkRLateScreen() {
        return kRLateScreen;
    }

    public void setkRLateScreen(Boolean kRLateScreen) {
        this.kRLateScreen = kRLateScreen;
    }

    public Boolean getoKREditScreen() {
        return oKREditScreen;
    }

    public void setoKREditScreen(Boolean oKREditScreen) {
        this.oKREditScreen = oKREditScreen;
    }
}
