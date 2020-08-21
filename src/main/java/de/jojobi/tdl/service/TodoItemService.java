package de.jojobi.tdl.service;

import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.model.dto.AddTodoItemDTO;

import java.util.List;

public interface TodoItemService {
    List<TodoItem> getTodos(String listName);

    void addNewItem(AddTodoItemDTO itemDTO);
}
