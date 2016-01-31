package td3;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class TestEditor {
	
	@Test public void testKillRingSave(){
		Editor e = new Editor();
		e.setCursor(0);
		e.setMark(10);
		e.killRingSave();
		System.out.println(e.buffer.getTrace());
		assertTrue(e.buffer.getTrace().equals("maxPosition:maxPosition:maxPosition:substring:"));
		assertTrue(e.killring.getTrace().equals("addElt:"));
	}
}
