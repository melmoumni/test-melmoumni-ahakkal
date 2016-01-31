package td3;
import java.nio.BufferOverflowException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class KillringTest {
	KillRing killRing = new KillRing();
	@Before public void initialize(){
		for(int i = 0; i<killRing.TAILLE_MAX; i++){
			killRing.addElt("a");
		}
	}
	
	
	@Test(expected= BufferOverflowException.class) public void testAddElt(){
		killRing.addElt("a");
	}
	
	@Test public void testIsEmpty(){
		KillRing ring = new KillRing();
		assertThat(ring.isEmpty(), is(equalTo(true)));
		ring.addElt("a");
		assertThat(ring.isEmpty(), is(equalTo(false)));
	}
	
	@Test public void testCurrentElt(){
		KillRing ring = new KillRing();
		ring.addElt("a");
		assertThat(ring.currentElt(), is(equalTo("a")));
	}
	
	@Test public void testRotateForward(){
		KillRing ring = new KillRing();
		ring.addElt("a");
		ring.rotateForward();
		assertThat(ring.currentElt(), is(equalTo("a")));
	}
}
