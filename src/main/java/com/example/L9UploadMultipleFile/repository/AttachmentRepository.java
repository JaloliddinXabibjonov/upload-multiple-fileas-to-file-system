package com.example.L9UploadMultipleFile.repository;

import com.example.L9UploadMultipleFile.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    public Attachment findByName(String name);
}
