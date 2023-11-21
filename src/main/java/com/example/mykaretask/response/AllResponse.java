package com.example.mykaretask.response;

public class AllResponse {//It is used to give messages after logged in and deleted the user
    private String message;
    private Boolean status;

    public AllResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public AllResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
