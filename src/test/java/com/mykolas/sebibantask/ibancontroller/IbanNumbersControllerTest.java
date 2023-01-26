package com.mykolas.sebibantask.ibancontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mykolas.sebibantask.ibanservice.IbanValidationService;
import com.mykolas.sebibantask.model.ListOfIbans;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = IbanNumbersController.class)
@Import(IbanNumbersController.class)
class IbanNumbersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IbanValidationService ibanValidationService;

    @Test
    void should_return_2xx_status_code_after_passing_single_iban() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/iban/single/").contentType(MediaType.TEXT_PLAIN).content("GB33BUKB20201555555555"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void should_return_2xx_status_code_after_passing_json_with_ibans() throws Exception{

        List<String> ibanNumberList = new ArrayList<>();
        ibanNumberList.add("GB33BUKB20201555555555");
        ibanNumberList.add("DE75512108001245126199");

        ListOfIbans listOfIbans = new ListOfIbans(ibanNumberList);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(listOfIbans);

        mockMvc.perform(MockMvcRequestBuilders.post("/iban/multiple/").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().is2xxSuccessful());
    }
}
