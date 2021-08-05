package com.meli.cerebro.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.cerebro.exception.CerebroException;

@SpringBootTest
public class DnaValidationTest {

	@Autowired
	private DnaValidation dnaValidation;

	@Test
	public void validateNullDna() throws CerebroException {
		Exception e = assertThrows(CerebroException.class, () -> dnaValidation.validate(null));
		assertEquals("DNA without values", e.getMessage());
	}

	@Test
	public void validateDnaStructureFail() throws CerebroException {
		Exception e = assertThrows(CerebroException.class, () -> dnaValidation.validate(getDnaWihtStructureFail()));
		assertEquals("Invalid size DNA", e.getMessage());
	}

	@Test
	public void validateSizeSequenceDnaFail() throws CerebroException {
		Exception e = assertThrows(CerebroException.class, () -> dnaValidation.validate(getDnaWihtSizeSequenceDnaFail()));
		assertEquals("Invalid size in the DNA sequence", e.getMessage());
	}

	@Test
	public void validateFormatSequenceDnaFail() throws CerebroException {
		Exception e = assertThrows(CerebroException.class, () -> dnaValidation.validate(getDnaWihtFormatSequenceDnaFail()));
		assertEquals("Invalid nucleotides!", e.getMessage());
	}

	@Test
	public void validateStructureOK() throws CerebroException {
		DnaValidation dnaValidationMock = Mockito.mock(DnaValidation.class);
		doNothing().when(dnaValidationMock).validate(getDnaWihtStructureOK());
		dnaValidationMock.validate(getDnaWihtStructureOK());
		verify(dnaValidationMock, times(1)).validate(getDnaWihtStructureOK());

	}

	private String[] getDnaWihtStructureOK() {
		String[] dna = { "ATGCG", "CATGC", "TATGT", "AGAGG", "CCGTA" };
		return dna;
	}

	private String[] getDnaWihtStructureFail() {
		String[] dna = { "AAAAAT", "CCCT", "GTTT" };
		return dna;
	}

	private String[] getDnaWihtSizeSequenceDnaFail() {
		String[] dna = { "ATGCGA", "CGTGC", "TTAGT", "AGAAGG", "CCCTA", "TCACTG" };
		return dna;
	}

	private String[] getDnaWihtFormatSequenceDnaFail() {
		String[] dna = { "ATGCGA", "CAGTGC", "TTXTGT", "AGAXGG", "CCCCTA", "TCXCTG" };
		return dna;
	}

}
