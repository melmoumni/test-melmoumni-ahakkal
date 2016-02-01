package dictionary;

import java.util.List;

public interface IDictionary {
	void addTranslation(String a, String b);
	List<String> getTranslation(String b) throws NotFoundException;
	boolean isEmpty();
	String getName();
}
