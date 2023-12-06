package com.meli.cerebro.scanner.sequencer.impl;

import org.springframework.stereotype.Component;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.meli.cerebro.scanner.sequencer.DnaSequencer;
import com.meli.cerebro.util.Utilities;

/**
 * 
 * @author Jusuga
 *
 */
@Component
public class DnaMajorSequencerImpl implements DnaSequencer {

	private final String NUCLEOTIDES_REGEX = "A{4}|T{4}|C{4}|G{4}";

	private Pattern pattern = Pattern.compile(NUCLEOTIDES_REGEX, Pattern.CASE_INSENSITIVE);

	@Override
	public int getSequences(String[] dna) {
		List<String> allChains = Utilities.arrayToListString(dna);
		return analyze(allChains);
	}

	private int analyze(List<String> chainsList) {

		List<Integer> secuq = chainsList.stream()
				.map(p -> evalSequenceRegex(p))
				.collect(Collectors.toList());

		IntSummaryStatistics totals = secuq.stream()
				.collect(Collectors.summarizingInt(Integer::intValue));
		return (int) totals.getSum();
	}

	private int evalSequenceRegex(String line) {
		Matcher matcher = pattern.matcher(line);
		return (matcher.find()) ? 1 : 0;
	}
}
