package com.example.mykaretask.dto;

import lombok.Data;

@Data

public class DeleteDto {//Dto for delete we only need to pass email for that
    private String email;
}