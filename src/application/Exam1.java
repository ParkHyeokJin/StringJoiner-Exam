package application;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Exam1 {
	String[] str = {"hello", "java", "World"};
	@Test
	public void vanillaJava() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			if(i == str.length-1) {
				sb.append(str[i]); 
				break;
			}
			sb.append(str[i]).append(" ");
		}
		assertEquals("hello java World", sb.toString());
	}
	
	@Test
	public void java8Joiner() {
		StringJoiner joiner = new StringJoiner(" ");
		for(int i = 0; i < str.length; i++) {
			joiner.add(str[i]);
		}
		new StringJoiner(" ").add("hello").add("java").add("World");
		assertEquals("hello java World", joiner.toString());
	}
	
	@Test
	public void java8StringJoin() {
		assertEquals("hello java World", String.join(" ", str));
	}
	
	@Test
	public void StreamJoin() {
		assertEquals("hello java World", Arrays.asList(str).stream().collect(Collectors.joining(" ")).toString());
	}
}


