package com.example.note.server.model.repository.custom;

import com.example.note.server.model.objects.Role;

public interface UserRepositoryCustom {
    String getPasswordByEmail(String email);

    Role getRoleByEmail(String email);
}
