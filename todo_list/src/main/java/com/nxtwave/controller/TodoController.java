package com.nxtwave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxtwave.entities.Todo;
import com.nxtwave.paylods.ApiResponse;
import com.nxtwave.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
		Todo savedTodo = this.todoService.createTodo(todo);
		
		return new ResponseEntity<Todo>(savedTodo, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable Integer id){
		Todo todo = this.todoService.getTodo(id);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodoList(){
		 List<Todo> allTodoList = this.todoService.getAllTodoList();
		
		return new ResponseEntity<List<Todo>>(allTodoList, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable Integer id){
		Todo updatedTodo = this.todoService.updateTodo(todo, id);
		
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteTodo(@PathVariable Integer id){
		this.todoService.deleteTodo(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Todo list deleted successfully", true), HttpStatus.OK);
		
	}
	
	
}
