package de.jojobi.tdl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.jojobi.tdl.model.TodoItem;
import de.jojobi.tdl.model.dto.AddTodoItemDTO;
import de.jojobi.tdl.service.TodoItemService;
import de.jojobi.tdl.service.impl.ToDoItemServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TodoListControllerTest {

    MockMvc mockMvc;

    TodoListController todoListController;
    TodoItemService toDoItemService;

    // test data
    private TodoItem todo1;
    private TodoItem todo2;
    private TodoItem todo3;
    private List<TodoItem> todoList;


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        toDoItemService = Mockito.mock(ToDoItemServiceImpl.class);
        todoListController = new TodoListController(toDoItemService);
        mockMvc = MockMvcBuilders.standaloneSetup(todoListController).build();

        initTestData();
        Mockito.when(toDoItemService.getTodos(ArgumentMatchers.anyString())).thenReturn(todoList);
    }

    @Test
    void getTodos() throws Exception {
        mockMvc.perform(
                get(TodoListController.BASE_URL + "/private")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.todos", hasSize(3)));
    }

    @Test
    void addNewTodo() throws Exception {
        AddTodoItemDTO addTodoItemDTO = new AddTodoItemDTO();
        addTodoItemDTO.setListName("business");
        addTodoItemDTO.setTodo("Clean the house");

        mockMvc.perform(
                post(TodoListController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(addTodoItemDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.todos", hasSize(3)));

        Mockito.verify(toDoItemService).addNewItem(eq(addTodoItemDTO));
    }

    @Test
    void addNewTodoWithListName() throws Exception {
        AddTodoItemDTO addTodoItemDTO = new AddTodoItemDTO();
        addTodoItemDTO.setListName("business");
        addTodoItemDTO.setTodo("Clean the house");

        mockMvc.perform(
                post(TodoListController.BASE_URL + "/private")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(addTodoItemDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.todos", hasSize(3)));

        addTodoItemDTO.setListName("private");
        Mockito.verify(toDoItemService).addNewItem(eq(addTodoItemDTO));
    }

    @Test
    void deletesTodo() throws Exception {
        mockMvc.perform(
                delete(TodoListController.BASE_URL + "/private/2")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.todos", hasSize(3)));

        Mockito.verify(toDoItemService).deleteItem(eq(2L));
    }



    private void initTestData() {
        todo1 = new TodoItem();
        todo1.setId(1L);
        todo1.setListName("public");
        todo1.setText("Wash the car");
        todo1.setEntryDate(LocalDate.now());
        todo1.setSequence(1L);
        todo1.setDone(false);

        todo2 = new TodoItem();
        todo2.setId(2L);
        todo2.setListName("public");
        todo2.setText("Mow the lawn");
        todo2.setEntryDate(LocalDate.now());
        todo2.setSequence(2L);
        todo2.setDone(true);

        todo3 = new TodoItem();
        todo3.setId(3L);
        todo3.setListName("public");
        todo3.setText("Repair the bike");
        todo3.setEntryDate(LocalDate.now());
        todo3.setSequence(3L);
        todo3.setDone(false);

        todoList = Arrays.asList(todo1, todo2, todo3);
    }
}