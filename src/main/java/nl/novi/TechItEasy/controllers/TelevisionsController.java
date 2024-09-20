package nl.novi.TechItEasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionsController {
    List<String> TelevisionDataBase = new ArrayList<String>();

    @GetMapping("/televisions")
    public ResponseEntity<List<String>> getAllTelevisions() {
        return ResponseEntity.ok(TelevisionDataBase);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable("id") int id) {
        return ResponseEntity.ok(TelevisionDataBase.get(id));
    }

    @PostMapping("/televisions")
    public ResponseEntity<String> addTelevision(@RequestBody String television) {
        return ResponseEntity.created(null).body(television);
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String television) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        return ResponseEntity.noContent().build();
    }

}
