package dictionary;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;

import dictionary.Dictionary;
import dictionary.NotFoundException;

import static org.junit.Assert.*;


import org.junit.Before;

public class DictionaryTest {
	private Dictionary dict;

	@Before
	public void initialize() {
		this.dict = new Dictionary("Example");
	}

	@Test
	public void testDictionaryName() {
		assertThat(dict.getName(), is(equalTo("Example")));
	}

	@Test
	public void testDictionaryIsEmpty() {
		assertThat(dict.isEmpty(), is(true));
	}

	@Test
	public void testMultipleTranslations() throws NotFoundException {
		
		dict.addTranslation("contre", "against");
		dict.addTranslation("contre", "Second");

		assertThat(dict.getTranslation("contre"), containsInAnyOrder("Second", "against"));
	}

	@Test
	public void testOneTranslation() throws NotFoundException {
	
		dict.addTranslation("contre", "against");
		assertThat(dict.getTranslation("contre"), containsInAnyOrder("against"));
		dict.addTranslation("read", "lire");
		assertThat(dict.getTranslation("read"), containsInAnyOrder("lire"));

	}
	
	@Test
	public void testInverseTranslation() throws NotFoundException{
		dict.addTranslation("contre", "against");
		assertThat(dict.getTranslation("contre"), containsInAnyOrder("against"));
		assertThat(dict.getInverseTranslation("against"), is(equalTo("contre")));
		
	}

}
