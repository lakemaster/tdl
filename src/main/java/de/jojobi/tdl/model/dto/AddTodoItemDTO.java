package de.jojobi.tdl.model.dto;

import java.time.LocalDate;

public class AddTodoItemDTO {

    private String listName;
    private String todo;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
