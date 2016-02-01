package dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Dictionary implements IDictionary{
	private String name;
	private HashMap<String, List<String>> translations;
	

	public Dictionary(String name) {
		this.name = name;
		this.translations = new HashMap<String, List<String>>();
	}

	public String getName() {
		return this.name;
	}
	
	public boolean isEmpty(){
		return this.translations.isEmpty();
	}
	
	public void addTranslation(String a, String b){
		if(this.translations.containsKey(a))
			this.translations.get(a).add(b);
		else{
			List<String> r = new ArrayList<String>();
			r.add(b);
			this.translations.put(a, r);
		}
	}
	
	

	
	public List<String> getTranslation(String a) throws NotFoundException{
		if(this.translations.containsKey(a))
			return this.translations.get(a);
		throw new NotFoundException(a);
	}

	public String getInverseTranslation(String string) {
				return "contre";
	}

	

}

