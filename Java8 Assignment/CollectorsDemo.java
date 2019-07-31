package com.java8.Assignment;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.text.html.InlineView;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);
		
		// collect the result of a Stream into Set
		
		Set<Integer>intSet=numbers.stream().collect(Collectors.toSet());
		System.out.println("Set Data="+intSet);
		
		// collect the result of a Stream into list
		List<Integer> intlist=numbers.stream().collect(Collectors.toList());
		//intlist.forEach(System.out::println);
		System.out.println("List Data="+intlist);
		
		
		// create Map from the elements of Stream (first remove the duplicates)
	     Map<Integer,Integer> mapint=numbers.stream().distinct().collect(Collectors.toMap(s->s, s->s));
		 System.out.println("Map Without Duplicate: " +mapint);
	     
		// find summary statistics from a Stream of numbers
		IntSummaryStatistics intSummaryStatisti=numbers.stream().collect(Collectors.summarizingInt(s->s));
		System.out.println("Summary="+intSummaryStatisti);
		
		
		// partition the result of Stream in two parts i.e., odd and even
		Map<Boolean, List<Integer>> evenNumber=numbers.stream().collect(Collectors.partitioningBy(s->s%2==0));
		System.out.println("Even Odd Numbers..."+evenNumber);
		
		// create comma separated string from numbers
		
		String joinString=numbers.stream().map(s->s.toString()).collect(Collectors.joining(","));
		System.out.println("Comma Seperated String = "+joinString);
		


	}
}
