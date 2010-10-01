package org.eclipse.papyrus.MARTE.utils;

import java.util.StringTokenizer;

public class MarteUtils {
	
	public static String getValueFromTuple(String tupleValue, String propertyName) {
		StringTokenizer tupleTokenizer = new StringTokenizer(tupleValue.substring(1,tupleValue.length()-1), ",");
		while(tupleTokenizer.hasMoreTokens()) {
			String currentToken = tupleTokenizer.nextToken();
			StringTokenizer propertyTokenizer = new StringTokenizer(currentToken, "=");
			String nextToken = propertyTokenizer.nextToken().trim();
			if(nextToken.equals(propertyName))
				if(propertyTokenizer.hasMoreTokens())
					return propertyTokenizer.nextToken().trim();
		}
		return null;
	}
	
}
