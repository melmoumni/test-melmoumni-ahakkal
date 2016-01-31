package td3;

public class BufferMock {

	   
		private String trace = "";
	    public BufferMock(String s) {
	        
	    }

	    public void insert(String s, int position) {
	        trace += "insert:";
	    }

	    public void delete(int from, int to) {
	    	trace += "delete:";
	    }

	    public String substring(int from, int to) {
	    	trace += "substring:";
	    	return null;
	    }

	    public String toString() {
	    	trace += "toString:";
	        return null;
	    }

	    public int maxPosition() {
	    	trace += "maxPosition:";
	    	return 1;
	    }

	    private int restrictValue(int v) {
	       return 0;
	    }
	    
	    public String getTrace(){
	    	return trace;
	    }
}
