package de.jojobi.tdl.model.dto;

import de.jojobi.tdl.model.TodoItem;

import java.util.List;


public class TodoItemListDTO {
    private List<TodoItem> todos;

    public TodoItemListDTO(List<TodoItem> todos) {
        this.todos = todos;
    }

    public List<TodoItem> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoItem> todos) {
        this.todos = todos;
    }
}
