package com.bartekdobo.web.approximatematching;

import java.util.List;

public abstract class ApproximateMatcher {
	
	public abstract List<String> verify(String fullname, List<String> listOfNames);
}
