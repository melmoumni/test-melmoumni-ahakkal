package dictionary;

public class NotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String word;
	
	public NotFoundException(String w){
		this.word = w;
	}
	
	@Override 
	public String toString(){
		return "The word " + this.word + " is not found "; 
	}
	
	
	
}
