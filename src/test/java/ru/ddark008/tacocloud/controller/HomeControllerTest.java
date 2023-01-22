package ru.ddark008.tacocloud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void home() throws Exception {
        mockMvc.perform(get("/"))     // Выполнить запрос GET /
                .andExpect(status().isOk())     // Ожидается код ответа HTTP 200
                .andExpect(view().name("home")) // Ожидается имя представления home
                .andExpect(content().string(containsString("Welcome to..."))); // Ожидается наличие строки «Welcome to...»
    }
}