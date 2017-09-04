package revision.sort;

import java.util.*;

public class PartitionAndMerge {
	

	public List<Student> rearrange(List<Student> studentList) {

		Map<Integer,Integer> ageToCountMap = new HashMap<>();
		Map<Integer,Integer> ageToOffsetMap = new HashMap<>();
		for (Student s: studentList) {
			if (ageToCountMap.containsKey(s.age)) {
				ageToCountMap.put(s.age,ageToCountMap.get(s.age)+1);
			} else {
				ageToCountMap.put(s.age,1);
			}
		}
		int offset = 0;
		for (Map.Entry<Integer,Integer> e:ageToCountMap.entrySet()) {
			ageToOffsetMap.put(e.getKey(),offset);
			offset+=e.getValue();
		}

		while (!ageToOffsetMap.isEmpty()) {

			Map.Entry<Integer,Integer> from = ageToOffsetMap.entrySet().iterator().next();
			Integer toAge = studentList.get(from.getValue()).age;
			Integer toValue = ageToOffsetMap.get(toAge);
			Collections.swap(studentList,from.getValue(),toValue);
			Integer count = ageToCountMap.get(toAge)-1;
			ageToCountMap.put(toAge,count);
			if (count > 0) {
				ageToOffsetMap.put(toAge,ageToOffsetMap.get(toAge)+1);
			} else {
				ageToOffsetMap.remove(toAge);
			}
		}

		return studentList;

	}


public List<Student> rearrangeSort(List<Student> studentList) {

		Map<Integer,Integer> ageToCountMap = new HashMap<>();
		SortedMap<Integer,Integer> ageToOffsetMap = new TreeMap<>();
		for (Student s: studentList) {
			if (ageToCountMap.containsKey(s.age)) {
				ageToCountMap.put(s.age,ageToCountMap.get(s.age)+1);
			} else {
				ageToCountMap.put(s.age,1);
			}
		}
		int offset = 0;
		for (Map.Entry<Integer,Integer> e:ageToCountMap.entrySet()) {
			ageToOffsetMap.put(e.getKey(),offset);
			offset+=e.getValue();
		}

		while (!ageToOffsetMap.isEmpty()) {

			Map.Entry<Integer,Integer> from = ageToOffsetMap.entrySet().iterator().next();
			Integer toAge = studentList.get(from.getValue()).age;
			Integer toValue = ageToOffsetMap.get(toAge);
			Collections.swap(studentList,from.getValue(),toValue);
			Integer count = ageToCountMap.get(toAge)-1;
			ageToCountMap.put(toAge,count);
			if (count > 0) {
				ageToOffsetMap.put(toAge,ageToOffsetMap.get(toAge)+1);
			} else {
				ageToOffsetMap.remove(toAge);
			}
		}

		return studentList;

	}


	public static void main(String[] argv) {
		PartitionAndMerge pam = new PartitionAndMerge();
		List<Student> inputList = new ArrayList<>();
		inputList.add(new Student("Greg",14));
		inputList.add(new Student("John",12));
		inputList.add(new Student("Andy",11));
		inputList.add(new Student("Jim",13));
		inputList.add(new Student("Phil",12));
		inputList.add(new Student("Bob",13));
		inputList.add(new Student("Chip",13));
		inputList.add(new Student("Tim",14));

		pam.rearrange(inputList);
		for (Student st:inputList) {
			System.out.println(st.name+"::"+st.age);
		}

		System.out.println("**************************************");
		inputList = new ArrayList<>();
		inputList.add(new Student("Greg",14));
		inputList.add(new Student("John",12));
		inputList.add(new Student("Andy",11));
		inputList.add(new Student("Jim",13));
		inputList.add(new Student("Phil",12));
		inputList.add(new Student("Bob",13));
		inputList.add(new Student("Chip",13));
		inputList.add(new Student("Tim",14));


		pam.rearrangeSort(inputList);
		for (Student st:inputList) {
			System.out.println(st.name+"::"+st.age);
		}


	}



}

class Student {
	
	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}