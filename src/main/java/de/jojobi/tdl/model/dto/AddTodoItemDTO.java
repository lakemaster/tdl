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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddTodoItemDTO that = (AddTodoItemDTO) o;

        if (listName != null ? !listName.equals(that.listName) : that.listName != null) return false;
        return todo != null ? todo.equals(that.todo) : that.todo == null;
    }

    @Override
    public int hashCode() {
        int result = listName != null ? listName.hashCode() : 0;
        result = 31 * result + (todo != null ? todo.hashCode() : 0);
        return result;
    }
}
