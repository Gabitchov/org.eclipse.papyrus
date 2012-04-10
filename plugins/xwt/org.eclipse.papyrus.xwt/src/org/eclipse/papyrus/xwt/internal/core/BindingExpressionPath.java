/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.core;

import java.util.ArrayList;
import java.util.Stack;

import org.eclipse.papyrus.xwt.XWTException;
import org.eclipse.papyrus.xwt.metadata.ModelUtils;

public class BindingExpressionPath {

	protected String fullPath;

	protected String stripedPath;

	protected String[] segments;

	public BindingExpressionPath(String value) {
		if(value == null) {
			return;
		}
		this.fullPath = value;
		this.stripedPath = null;

		int level = 0;
		Stack<Character> separators = new Stack<Character>();
		ArrayList<String> collector = new ArrayList<String>();
		int start = 0;
		int stripStart = 0;
		int stripEnd = 0;
		char[] array = value.toCharArray();
		for(int i = 0; i < array.length; i++) {
			switch(array[i]) {
			case '}':
			{
				Character character = separators.pop();
				if(character.charValue() != '{') {
					throw new XWTException("Syntax error is binding expression " + value + " at " + i);
				}
			}
				level--;
				break;
			case ']':
			{
				Character character = separators.pop();
				if(character.charValue() != '[') {
					throw new XWTException("Syntax error is binding expression " + value + " at " + i);
				}
			}
				level--;
				break;
			case ')':
			{
				Character character = separators.pop();
				if(character.charValue() != '(') {
					throw new XWTException("Syntax error is binding expression " + value + " at " + i);
				}
			}
				level--;
				if(level == 0) {
					stripEnd = i - 1;
				}
				break;
			case '(':
				if(level == 0) {
					stripStart = i + 1;
				}
				separators.push(array[i]);
				level++;
				break;
			case '{':
			case '[':
				separators.push(array[i]);
				level++;
				break;
			case '.':
				if(level == 0) {
					String element = value.substring(start, i);
					element = ModelUtils.normalizePropertyName(element);
					collector.add(element);
					updateStripped(value, stripStart, stripEnd, element);
					start = i + 1;
				}
				break;
			}
		}
		if(level == 0) {
			String element = value.substring(start, array.length);
			element = ModelUtils.normalizePropertyName(element);
			collector.add(element);

			updateStripped(value, stripStart, stripEnd, element);
		}

		segments = collector.toArray(new String[collector.size()]);
	}

	private void updateStripped(String value, int stripStart, int stripEnd, String element) {
		if(stripStart != 0) {
			element = value.substring(stripStart, stripEnd + 1);
			int index = element.lastIndexOf('.');
			if(index != -1) {
				element = element.substring(index + 1);
			}
			element = ModelUtils.normalizePropertyName(element);
		}

		if(this.stripedPath == null) {
			this.stripedPath = element;
		} else {
			this.stripedPath += "." + element;
		}
	}

	public String getFullPath() {
		return fullPath;
	}

	public String getStripedPath() {
		return stripedPath;
	}

	public String[] getSegments() {
		return segments;
	}

	public boolean isEmptyPath() {
		return isEmptyPath(getFullPath());
	}

	public static boolean isEmptyPath(String value) {
		return value == null || value.trim().length() == 0 || ".".equals(value.trim());
	}

	public static int lastIndexOf(String value) {
		int level = 0;
		Stack<Character> separators = new Stack<Character>();
		char[] array = value.toCharArray();
		for(int i = array.length - 1; i >= 0; i--) {
			switch(array[i]) {
			case '{':
			{
				Character character = separators.pop();
				if(character.charValue() != '}') {
					throw new XWTException("Syntax error is binding expression " + value + " at " + i);
				}
			}
				level--;
				break;
			case '[':
			{
				Character character = separators.pop();
				if(character.charValue() != '}') {
					throw new XWTException("Syntax error is binding expression " + value + " at " + i);
				}
			}
				level--;
				break;
			case '(':
			{
				Character character = separators.pop();
				if(character.charValue() != ')') {
					throw new XWTException("Syntax error is binding expression " + value + " at " + i);
				}
			}
				level--;
				break;
			case '}':
			case ']':
			case ')':
				separators.push(array[i]);
				level++;
				break;
			case '.':
				if(level == 0) {
					return i;
				}
				break;
			}

			if(array[i] == '.') {
			}
		}
		return -1;
	}


}
