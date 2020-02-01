package com.example.jug.service;

import com.example.jug.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupService extends JpaRepository<Group, Long> {
    @Query("SELECT g FROM Group g WHERE g.name = :name")
    Group findByName(@Param("name") String name);
}