package revision.hashtable;

import java.util.*;

public class ISBNCache {
	
	int capacity;
	Map<Integer,Integer> isbnCache;

	public ISBNCache(int capacity) {
		this.capacity = capacity;
		isbnCache = new LinkedHasMap<>(c,1.0f, Boolean.TRUE) {
			public boolean removeEldestEntry(Map.Entry<Integer,Integer> e) {
				return this.size() > capacity;
			}
		}
	}

	public Integer lookup(Integer key) {
		if (isbnCache.containsKey(key)) {
			return isbnCache.get(key);
		}
		return null;
	}

	public Integer insert(Integer key,Integer value) {
		Integer currValue = isbnCache.get(key);
		if (currValue == null) {
			isbnCache.put(key,value);
			return currValue;
		} else
			return null;
	}

	public Integer erase(Integer key) {
		Integer currValue = isbnCache.get(key);
		isbnCache.remove(key);
		return currValue;
	}
}