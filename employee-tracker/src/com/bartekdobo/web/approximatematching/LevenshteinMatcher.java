package com.bartekdobo.web.approximatematching;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class LevenshteinMatcher extends ApproximateMatcher {
	
	private static final int THRESHOLD = 2;
	
	private final List<String> matches = new ArrayList<String>();
	private final List<String> candidates = new ArrayList<String>();
	private String pattern;
	
	private LevenshteinDistance dist = new LevenshteinDistance();

	@Override
	public List<String> verify(String fullname, List<String> listOfNames) {
				
		pattern = fullname;
		matches.clear();
		candidates.clear();

		if(pattern.length() == 0 ) {
			return null;
		}

		for(String candidate : listOfNames) {		
			if(dist.apply(pattern, candidate) <= THRESHOLD) {
				candidates.add(candidate);
			}
		}		

		if(!candidates.isEmpty()) {
			matches.addAll(candidates);
			return matches;
		}
		return null;
	}

}
