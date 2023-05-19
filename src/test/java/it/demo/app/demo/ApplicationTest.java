package it.demo.app.demo;

import it.demo.app.demo.config.BeansConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ContextConfiguration(classes = BeansConfig.class)
class ApplicationTest {

	@Test
	void test() {
		assertTrue(true);
	}

}
