package dictionary;

import static org.hamcrest.Matchers.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.Sequence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;

import dictionaryparser.DictionaryParser;
import dictionaryparser.IBufferedReader;

import static org.junit.Assert.assertThat;

import java.io.IOException;


public class DictionaryParserTest {
	private IBufferedReader File;
	private Mockery context;
	
	@Before 
	public void initialize() throws IOException{
		context = new Mockery();
		
		File = context.mock(IBufferedReader.class);
					
	}
	
	@Test
	public void testEmptyFile() throws IOException {
		final Sequence emptyFileSequence = context.sequence("emptyFileSequence");
		context.checking(new Expectations (){{
			oneOf (File).readLine();  will(returnValue("")); inSequence(emptyFileSequence); 
			oneOf (File).readLine();  will(returnValue(null)); inSequence(emptyFileSequence); 
		
		}});
		
		DictionaryParser p = new DictionaryParser();
			assertThat(p.loadTranslations(File) ,is(nullValue()));
			context.assertIsSatisfied();
	}
	
	@Test public void testFileWithDictionaryNameOnly(){
		
		final Sequence dictionaryWithOnlyNameSequence = context.sequence("DictionaryWithOnlyNameSequence");
		
		context.checking(new Expectations (){{
			oneOf (File).readLine();  will(returnValue("Example")); inSequence(dictionaryWithOnlyNameSequence); 
			oneOf (File).readLine();  will(returnValue(null)); inSequence(dictionaryWithOnlyNameSequence); 
		
		}});
		DictionaryParser p = new DictionaryParser();
		assertThat(p.loadTranslations(File).getName() , is(equalTo("Example")));
	}
	
	@Test 
	public void testFileTraductions() throws NotFoundException{
		
		final Sequence fileWithTraductionsSequence = context.sequence("FileWithTraductionSequence");
		
		context.checking(new Expectations (){{
			oneOf (File).readLine();  will(returnValue("Example")); inSequence(fileWithTraductionsSequence); 
			oneOf (File).readLine();  will(returnValue("contre = against")); inSequence(fileWithTraductionsSequence); 
			oneOf (File).readLine();  will(returnValue("oui = yes")); inSequence(fileWithTraductionsSequence); 
			oneOf (File).readLine();  will(returnValue("nom = no")); inSequence(fileWithTraductionsSequence); 
			
			oneOf (File).readLine();  will(returnValue(null)); inSequence(fileWithTraductionsSequence); 
		
		}});
		
		DictionaryParser p = new DictionaryParser();
		assertThat(p.loadTranslations(File).getTranslation("contre ") , contains(" against"));
		
	}
	
	

	@Test 
	public void testFileWithWrongTraductions() throws NotFoundException{
		
		final Sequence fileWithWrongTraductionsSequence = context.sequence("FileWithWrongTraductionSequence");
		
		context.checking(new Expectations (){{
			oneOf (File).readLine();  will(returnValue("Example")); inSequence(fileWithWrongTraductionsSequence); 
			oneOf (File).readLine();  will(returnValue("contre = against")); inSequence(fileWithWrongTraductionsSequence);
			oneOf (File).readLine();  will(returnValue("az")); inSequence(fileWithWrongTraductionsSequence); 
			oneOf (File).readLine();  will(returnValue("oAZfa ")); inSequence(fileWithWrongTraductionsSequence); 
			oneOf (File).readLine();  will(returnValue("nazkja ")); inSequence(fileWithWrongTraductionsSequence); 
			
			oneOf (File).readLine();  will(returnValue(null)); inSequence(fileWithWrongTraductionsSequence); 
		
		}});
		
		DictionaryParser p = new DictionaryParser();
		assertThat(p.loadTranslations(File).getTranslation("contre ") , contains(" against"));
		
	}
	
	
	
	@After
	public void close(){
		context.assertIsSatisfied();
	}

}
