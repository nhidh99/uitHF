package com.example.jug.controller;

import com.example.jug.model.Group;
import com.example.jug.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public Collection<Group> findAllGroups() {
        return groupService.findAll();
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?> getGroup(@PathVariable Long id) {
        log.info("Request to get group: {}", id);
        Optional<Group> group = groupService.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    public ResponseEntity<?> createGroup(@Valid @RequestBody Group group) throws URISyntaxException {
        log.info("Request to create group: {}", group);
        Group result = groupService.save(group);
        URI uri = new URI("/api/group/" + result.getId());
        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<?> updateGroup(@Valid @RequestBody Group group) {
        log.info("Request to update group: {}", group);
        Group result = groupService.save(group);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        groupService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}