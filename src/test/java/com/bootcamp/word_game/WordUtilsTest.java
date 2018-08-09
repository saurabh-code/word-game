package com.bootcamp.word_game;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class WordUtilsTest {

	@Test
	public void testSimple() {
		assertThat(WordUtils.countSimilarity("A", "A"), is(1));
		assertThat(WordUtils.countSimilarity("B", "A"), is(0));
		assertThat(WordUtils.countSimilarity("AB", "AB"), is(2));
		assertThat(WordUtils.countSimilarity("ABC", "CAZ"), is(2));
		assertThat(WordUtils.countSimilarity("AABC", "ABC"), is(3));
		assertThat(WordUtils.countSimilarity("BAC", "DZA"), is(1));
	}

}