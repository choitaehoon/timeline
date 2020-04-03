package com.timeline.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timeline.api.LoginController;
import com.timeline.domain.Account;
import com.timeline.domain.AccountRole;
import com.timeline.dto.request.RequestAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountSignUpTest {

    private MockMvc mockMvc;

    @Autowired
    private LoginController loginController;

    private ObjectMapper objectMapper;

    private RequestAccount account;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.standaloneSetup(loginController)
                .build();
    }

    @Test
    public void signUp_password_exist_valid_success_expect() throws Exception {
        account = RequestAccount.builder()
                .userId("test")
                .password("1234")
                .accountRole(AccountRole.USER)
                .build();

        mockMvc.perform(post("/account")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

}