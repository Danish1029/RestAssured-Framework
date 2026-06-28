package models;

import lombok.Data;

@Data
public class UserResponse {

    private String id;

    private String name;

    private String job;

    private String createdAt;

}