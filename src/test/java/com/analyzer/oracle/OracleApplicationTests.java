package com.analyzer.oracle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OracleApplication.class)
class OracleApplicationTests {


	@Autowired
	private OracleConnector oracleConnector;
	
	@Test
	void contextLoads() {
	}


	@Test
	void shouldReturnTableNames() {

		var tblList = oracleConnector.tableList(List.of("JAMES"));

		assertEquals(1, tblList.size());

	}


	@Test
	void shouldReturnViewNames() {

		var viewList = oracleConnector.viewList(List.of("JAMES"));

		assertEquals(1, viewList.size());

	}

	
	@Test
	void shouldReturnTriggers() {

		var triggers = oracleConnector.viewTriggers(List.of("JAMES"));

		assertEquals(1, triggers.size());

	}

	
	@Test
	void shouldReturnReferences() {

		var references = oracleConnector.viewReferences(List.of("JAMES"));

		assertEquals(1, references.size());

	}

}
