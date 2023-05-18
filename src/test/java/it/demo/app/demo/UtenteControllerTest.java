package it.demo.app.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.demo.app.demo.model.dto.UtenteDto;
import it.demo.app.demo.service.UtenteService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = Application.class)
@AutoConfigureMockMvc
class UtenteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private UtenteService utenteService;

	UtenteDto user1 = UtenteDto.builder()
			.nome("Riccardo")
			.cognome("Rossi")
			.email("prova@email.it").build();

	@Test
	@Order(1)
	public void getAllUsers() throws Exception {

		List<UtenteDto> records = new ArrayList<>(Arrays.asList(user1));

		Mockito.when(utenteService.list()).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders
						.get("/api/v1/get/utenti")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
