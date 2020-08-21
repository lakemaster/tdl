package de.jojobi.tdl.controller;

import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.model.dto.AddTodoItemDTO;
import de.jojobi.tdl.model.dto.TodoItemListDTO;
import de.jojobi.tdl.service.TodoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TodoListController.BASE_URL)
public class TodoListController {
    public static final String BASE_URL = "/api/tdl";

    private final TodoItemService todoItemService;

    public TodoListController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("{list_name}")
    @ResponseStatus(HttpStatus.OK)
    public TodoItemListDTO getTodos(@PathVariable String list_name) {
        return new TodoItemListDTO(todoItemService.getTodos(list_name));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemListDTO addNewTodo(@RequestBody AddTodoItemDTO itemDTO) {
        todoItemService.addNewItem(itemDTO);
        return getTodos(itemDTO.getListName());
    }
}
