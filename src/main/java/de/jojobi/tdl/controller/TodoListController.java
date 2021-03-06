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
    public static final String BASE_URL = "/api";

    private final TodoItemService todoItemService;

    public TodoListController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @CrossOrigin
    @GetMapping("/{list_name}")
    @ResponseStatus(HttpStatus.OK)
    public TodoItemListDTO getTodos(@PathVariable String list_name) {
        return new TodoItemListDTO(todoItemService.getTodos(list_name));
    }

    @CrossOrigin
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemListDTO addNewTodo(@RequestBody AddTodoItemDTO itemDTO) {
        todoItemService.addNewItem(itemDTO);
        return getTodos(itemDTO.getListName());
    }

    @CrossOrigin
    @PostMapping("/{list_name}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemListDTO addNewTodo(@PathVariable("list_name") String listName, @RequestBody AddTodoItemDTO itemDTO) {
        itemDTO.setListName(listName);
        return addNewTodo(itemDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{list_name}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoItemListDTO deletesTodo(@PathVariable("list_name") String listName, @PathVariable Long id) {
        todoItemService.deleteItem(id);
        return getTodos(listName);
    }
}
