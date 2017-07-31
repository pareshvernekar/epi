package sample.epi.hashtable.episolution;

import java.util.*;

public class ISBNCache {
	
	Map<Integer,Double> isbnToPriceCache;

	public ISBNCache(int capacity) {

		isbnToPriceCache = new LinkedHashMap<Integer,Double>(capacity, 0.75f, Boolean.TRUE) {

			public boolean removeEldestEntry(Map.Entry<Integer,Double> e) {
				return size() > capacity;
			}
		};

	}

	public Double lookUp(Integer key) {
		if (isbnToPriceCache.containsKey(key)) {
			return isbnToPriceCache.get(key);
		}
		return null;
	}

	public Double insert(Integer key,Double price) {
		Double value = isbnToPriceCache.get(key);
		if (!isbnToPriceCache.containsKey(key)) {
			isbnToPriceCache.put(key,price);
			return value;
		} else
			return null;
	}
	public Double erase(Integer key) {
		return isbnToPriceCache.remove(key);
	}

}