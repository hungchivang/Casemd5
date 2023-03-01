package com.be_casemodule5.repo;

import com.be_casemodule5.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface IRoomRepo extends CrudRepository<Room,Integer> {
}
