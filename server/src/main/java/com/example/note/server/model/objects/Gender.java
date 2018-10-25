package com.example.note.server.model.objects;

public enum Gender {
    male(0), female(1);
    private Integer num;

    Gender(Integer integer) {
        num = integer;
    }

}
