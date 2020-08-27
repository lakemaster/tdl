package de.jojobi.tdl.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class AddTodoItemDTO {

    @ApiModelProperty(value = "Name of the Todolist", required = true)
    @JsonProperty("list_name")
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
