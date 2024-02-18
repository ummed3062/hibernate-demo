package com.nxtwave.service;

import java.util.List;

import com.nxtwave.entities.Todo;

public interface TodoService {

	Todo createTodo(Todo todo);
	
	Todo getTodo(Integer todoId);
	
	List<Todo> getAllTodoList();
	
	Todo updateTodo(Todo todo, Integer id);
	
	void deleteTodo(Integer id);
}
