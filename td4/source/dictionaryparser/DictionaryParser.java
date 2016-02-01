package dictionaryparser;


import dictionary.Dictionary;
import dictionary.IDictionary;

public class DictionaryParser {
	public DictionaryParser(){
	}
	
	public IDictionary loadTranslations(IBufferedReader bf){
		IDictionary d  = null;
		
		String s;
		boolean definedName= false;
		
		while((s = bf.readLine()) != null ){
			if(!s.isEmpty()){
				if(!definedName){
					d = new Dictionary(s); 
					definedName = true;
				}
				else{
					String[] res = s.split("=");
					if(res.length == 2){
						d.addTranslation(res[0], res[1]);
					}
				}
			}
		}
		
		
		
		return d;
	}
}
