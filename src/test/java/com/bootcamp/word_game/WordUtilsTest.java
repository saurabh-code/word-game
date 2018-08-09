package com.bootcamp.word_game;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class WordUtilsTest {

	@Test
	public void testCountSimilarity() {
		assertThat(WordUtils.countSimilarity("A", "A"), is(1));
		assertThat(WordUtils.countSimilarity("B", "A"), is(0));
		assertThat(WordUtils.countSimilarity("AB", "AB"), is(2));
		assertThat(WordUtils.countSimilarity("ABC", "CAZ"), is(2));
		assertThat(WordUtils.countSimilarity("AABC", "ABC"), is(3));
		assertThat(WordUtils.countSimilarity("BAC", "DZA"), is(1));
	}
	
	@Test
	public void testCountForInvalid() {
		assertThat(WordUtils.countOfInvalidWordsToBeRemoved(
				Arrays.asList("BBB"), 
				"AAA", 
				3), 
				is(1));
		
		assertThat(WordUtils.countOfInvalidWordsToBeRemoved(
				Arrays.asList("BBB", "AAC"), 
				"AAA", 
				3), 
				is(2));
		
		assertThat(WordUtils.countOfInvalidWordsToBeRemoved(
				Arrays.asList("BBB", "AAC", "BBB"), 
				"AAA", 
				2), 
				is(2));
		
		assertThat(WordUtils.countOfInvalidWordsToBeRemoved(
				Arrays.asList("AAA", "AAC", "BBB"), 
				"AAA", 
				3), 
				is(2));
	}
	
	@Test
	public void testRemoveInvalid() {
		assertThat(WordUtils.removeInvalidWords(
				Arrays.asList("BBB"),
				"AAA", 
				3),
				is(Collections.emptyList()));
		
		assertThat(WordUtils.removeInvalidWords(
				Arrays.asList("BBB", "AAC"), 
				"AAA", 
				3), 
				is(Collections.emptyList()));
		
		assertThat(WordUtils.removeInvalidWords(
				Arrays.asList("BBB", "AAC", "BBB"), 
				"AAA", 
				2), 
				is(Arrays.asList("AAC")));
		
		assertThat(WordUtils.removeInvalidWords(
				Arrays.asList("AAA", "AAC", "BBB"), 
				"AAA", 
				3), 
				is(Arrays.asList("AAA")));
	}
	
	
	
	
}