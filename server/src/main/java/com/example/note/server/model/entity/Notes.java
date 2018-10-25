package com.example.note.server.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Notes implements Serializable, Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer noteId;
    private Date createDate;
    private Date modifyDate;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String noteContent;
    @ManyToMany
    @JoinTable(name = "NoteTagsList",
            joinColumns = {@JoinColumn(name = "tagId")})
    private List<NoteTags> noteTagsList;
}
