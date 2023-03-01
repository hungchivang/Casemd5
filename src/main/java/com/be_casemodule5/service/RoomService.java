package com.be_casemodule5.service;

import com.be_casemodule5.model.Room;
import com.be_casemodule5.repo.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    IRoomRepo iRoomRepo;
    public List<Room> showAll() {
        return (List<Room>) iRoomRepo.findAll();
    }
    public void save(Room room) {
        iRoomRepo.save(room);
    }
    public void delete(int id) {
        iRoomRepo.deleteById(id);
    }

    public Room findById(int id) {
        return iRoomRepo.findById(id).get();
    }

}
