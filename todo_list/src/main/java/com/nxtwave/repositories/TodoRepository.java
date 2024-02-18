package com.nxtwave.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nxtwave.entities.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer>{

}
