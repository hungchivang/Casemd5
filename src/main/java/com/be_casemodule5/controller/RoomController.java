package com.be_casemodule5.controller;

import com.be_casemodule5.model.Room;
import com.be_casemodule5.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Room>> findAll(){
        return new ResponseEntity<>(roomService.showAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Room> save(@RequestBody Room room){
        roomService.save(room);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable int id){
        return new ResponseEntity<>(roomService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> edit(@RequestBody Room room){
        roomService.save(room);
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
}
