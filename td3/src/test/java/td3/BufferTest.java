package td3;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.iterable.Iterables;
import net.java.quickcheck.generator.PrimitiveGenerators;
public class BufferTest {

	@Test public void testTosString(){
		Buffer buffer = new Buffer("testString");
		assertTrue(buffer.toString().equals("testString"));
	}
	
	@Test public void testInsert(){
		Buffer buffer = new Buffer("testString");
		buffer.insert("aaa", 4);
		assertThat(buffer.toString(), is(equalTo("testaaaString")));
		buffer.insert("aaa", -1);
		assertThat(buffer.toString(), is(equalTo("testaaaString")));
		buffer.insert("aaa", 100);
		assertThat(buffer.toString(), is(equalTo("testaaaString")));
	}
	
	@Test public void testDelete(){
		Buffer buffer = new Buffer("testString");
		buffer.delete(1, 4);
		assertThat(buffer.toString(), is(equalTo("String")));
		buffer.delete(-2, 100);
		assertThat(buffer.toString(), is(equalTo("")));
	}
	
	@Test public void testSubstring(){
		Buffer buffer = new Buffer("testString");
		buffer.substring(1, 4);
		assertThat(buffer.toString(), is(equalTo("String")));
	}
	
	@Test public void testInsertGenerator(){
		for(Buffer b : Iterables.toIterable(new BufferGenerator())){
			for(Integer i : Iterables.toIterable(PrimitiveGenerators.integers())){
				String current = b.toString();
				b.insert("a", i);
				assertThat(b.toString(), is(equalTo(current.substring(1, i)+"a"+current.substring(i+1, current.length()))));
			}
		}
	}
}
