package com.nxtwave.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtwave.entities.Todo;
import com.nxtwave.exception.ResourceNotFoundException;
import com.nxtwave.repositories.TodoRepository;
import com.nxtwave.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	
	
	@Override
	public Todo createTodo(Todo todo) {
		
		Todo saveTodo = this.todoRepository.save(todo);
		return saveTodo;
	}

	@Override
	public Todo getTodo(Integer id) {
		// TODO Auto-generated method stub
		Todo todo = this.todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("TodoList", "Id", id));
		
		return todo;
	}

	@Override
	public List<Todo> getAllTodoList() {
		Iterable<Todo> all = this.todoRepository.findAll();
		return (List<Todo>) all;
	}

	@Override
	public Todo updateTodo(Todo todo, Integer id) {
		Todo todo1 = this.todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "Id", id));
		todo1.setTodo(todo.getTodo());
		todo1.setStatus(todo.getStatus());
		todo1.setPriority(todo.getPriority());
		
		Todo updatedTodo = this.todoRepository.save(todo1);
		return updatedTodo;
	}

	@Override
	public void deleteTodo(Integer id) {
		Todo todo = this.todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo list", "Id", id));
		this.todoRepository.delete(todo);
		
	}

}
