package com.example.note.server.model.entity.converter;

import com.example.note.server.model.objects.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoleConverter implements AttributeConverter<Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Role attribute) {
        return attribute.getRoleNumber();
    }

    @Override
    public Role convertToEntityAttribute(Integer dbData) {
        return Role.fromRoleNumber(dbData);
    }
}
