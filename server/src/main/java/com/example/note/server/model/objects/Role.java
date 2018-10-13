package com.example.note.server.model.objects;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN(0), USER(1);
    private final Integer roleNumber;

    Role(Integer integer) {
        this.roleNumber = integer;
    }

    public static Role fromRoleNumber(Integer roleNumber) {
        switch (roleNumber) {
            case 0:
                return ADMIN;
            case 1:
                return USER;
            default:
                throw new UnsupportedOperationException("Unexpected roleNumber: " + roleNumber);
        }
    }
}
