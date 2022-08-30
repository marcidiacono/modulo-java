package com.esolutions.java.api;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class TodoServiceMapImpl implements ITodoService {

    private HashMap<Integer, Todo> todoMap;

    public TodoServiceMapImpl() {
        todoMap = new HashMap<Integer, Todo>();
        Todo[] todos = Source.getTodos();
        for(Todo todo : todos) {
            todoMap.put(todo.getId(), todo);
        }
    }

    @Override
    public Collection<Todo> getTodos() throws TodoException {
        return todoMap.values();
    }

    @Override
    public Todo getTodo(int id) throws TodoException {
        Todo todo = todoMap.get(id);
        if(todo == null) {
            throw new TodoException("Id " + id + " not found.");
        }
        return todo;
    }

    @Override
    public Todo addTodo(Todo todo) throws TodoException {
        todoMap.put(new Date().hashCode(), todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) throws TodoException {
        Todo todoAnt = todoMap.get(id);
        if (todo == null) {
            throw new TodoException("Id " + id + " not found.");
        }
        if(todo.getTitle() != null && !todo.getTitle().equals("")) {
            todoAnt.setTitle(todo.getTitle());
        }
        todoAnt.setCompleted(todo.getCompleted());
        todoMap.put(id, todoAnt);
        return todoAnt;
    }

    @Override
    public boolean deleteTodo(int id) throws TodoException {
        Todo todo = todoMap.remove(id);
        if (todo == null) {
            return false;
        } else {
            return true;
        }
    }
    
}
