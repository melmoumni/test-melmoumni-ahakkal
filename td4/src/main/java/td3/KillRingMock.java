package td3;

import java.nio.BufferOverflowException;
import java.util.LinkedList;

public class KillRingMock {
	
	private String trace = "";
	public KillRingMock() {
        
    }

    public void addElt(String s) {
    	trace += "addElt:";

    }

    public void rotateForward() {
    	trace += "rotateFormward:";
    }

    public boolean isEmpty() {
    	trace += "isEmpty:";
        return true;
    }

    public String currentElt() {
    	trace += "currentElt:";
    	return null;
    }

    public String toString() {
    	trace += "toString:";
    	return null;

    }
    public String getTrace(){
    	return trace;
    }
}
