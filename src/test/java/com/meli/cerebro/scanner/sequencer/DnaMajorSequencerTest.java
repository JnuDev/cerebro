package com.meli.cerebro.scanner.sequencer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.cerebro.dataset.Dataset;
import com.meli.cerebro.exception.CerebroException;

@SpringBootTest
public class DnaMajorSequencerTest {

	@Autowired
	private DnaSequencer dnaSequencer;

	@Test
	public void getSequencesHorizontalMutant() throws CerebroException {

		String[] dna = Dataset.MUTANT_OK;
		int result = dnaSequencer.getSequences(dna);
		assertEquals(2, result);
	}

}
