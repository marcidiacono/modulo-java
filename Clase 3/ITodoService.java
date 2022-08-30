package com.esolutions.java.api;

import java.util.Collection;

public interface ITodoService {
    
    public Collection<Todo> getTodos() throws TodoException;
    public Todo getTodo(int id) throws TodoException;
    public Todo addTodo(Todo todo) throws TodoException;
    public Todo updateTodo(int id, Todo todo) throws TodoException;
    public boolean deleteTodo(int id) throws TodoException;

}
