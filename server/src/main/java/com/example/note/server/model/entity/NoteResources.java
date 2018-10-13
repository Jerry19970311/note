package com.example.note.server.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class NoteResources {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer noteId;
}
