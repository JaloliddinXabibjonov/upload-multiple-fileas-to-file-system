package com.example.L9UploadMultipleFile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fileOriginalName;

    private long size;

    private String contentType;
    private  String name;

    public Attachment(String fileOriginalName, long size, String contentType, String name) {
        this.fileOriginalName = fileOriginalName;
        this.size = size;
        this.contentType = contentType;
        this.name = name;
    }
}


