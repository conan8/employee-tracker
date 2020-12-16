package com.bartekdobo.web.approximatematching;

public class ApproximateMatcherFactory {
	
	public static ApproximateMatcher getApproximateMatcher(String type) {
				
		if("Levenshtein".equalsIgnoreCase(type)) return new LevenshteinMatcher();
		
		return null;
	}

}
