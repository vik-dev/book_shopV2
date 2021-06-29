package com.example.bookshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Permission {
    READ("permission-read"), WRITE("permission-write");

    @Getter
    private String permission;
}
