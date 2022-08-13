package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.mvc);
    }

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        when(this.calculator.sum(2.3, 3.2)).thenReturn(5.5);

        RequestBuilder request = get("/calculator/addNumbers")
                .param("number1", "2.3")
                .param("number2", "3.2");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5.5", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        when(this.calculator.sub(21.0, 11.0)).thenReturn(10.0);

        RequestBuilder request = get("/calculator/subNumbers")
                .param("number1", "21.0")
                .param("number2", "11.0");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("10.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        when(this.calculator.divide(25.0, 5.0)).thenReturn(5.0);

        RequestBuilder request = get("/calculator/divideNumbers")
                .param("number1", "25.0")
                .param("number2", "5.0");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("5.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        when(this.calculator.factorial(6)).thenReturn(720);

        RequestBuilder request = get("/calculator/factorial")
                .param("factorial", "6");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("720", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        LocalDate localDate1 = LocalDate.of(2020, 3, 15);
        LocalDate localDate2 = LocalDate.of(2020, 3, 29);

        when(this.calculator.calculateDayBetweenDate(localDate1, localDate2)).thenReturn(14);

        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
                .param("localDate1", localDate1.toString())
                .param("localDate2", localDate2.toString());

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("14", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        when(this.calculator.integerToBinary(7)).thenReturn(111);

        RequestBuilder request = get("/calculator/integerToBinary")
                .param("number1", "7");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("111", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        when(this.calculator.integerToHexadecimal(10)).thenReturn("a");

        RequestBuilder request = get("/calculator/integerToHexadecimal")
                .param("number1", "10");

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("a", result.getResponse().getContentAsString());
    }
}