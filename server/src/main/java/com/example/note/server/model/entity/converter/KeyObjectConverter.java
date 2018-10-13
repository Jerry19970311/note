package com.example.note.server.model.entity.converter;

import com.example.note.server.model.objects.KeyObject;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
@Component
public class KeyObjectConverter implements AttributeConverter<KeyObject, String> {

    @Override
    public String convertToDatabaseColumn(KeyObject attribute) {
        return Base64Utils.encodeToString(attribute.getContent());
    }

    @Override
    public KeyObject convertToEntityAttribute(String dbData) {
        var key = new KeyObject();
        key.setContent(Base64Utils.decodeFromString(dbData));
        return key;
    }
}
