/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.util;


/**
 * 
 * The goal of this class is to allows to have two different strings with the same content in a hashmap.
 * To do this, the string need to have different hashcode. The hashcode calculus for string is based on the contents of the string, so
 * it's not correct for own application. This class corrects this default.
 * 
 * 
 * <ul>
 * <li>String str1="Hello";</li>
 * <li>String str2="Hello";</li>
 * </ul>
 * <ul>
 * <li>str1==str1 returns false</li>
 * <li>str1.equals(str2) returns true</li>
 * <li>str1.hashcode()==str2.hashcode() return true</li>
 * </ul>
 * 
 * with this class,
 * <ul>
 * <li>SuperString sStr1 = new SuperString("Hello");</li>
 * <li>SuperString sStr2 = new SuperString("Hello");</li>
 * </ul>
 * gives
 * <ul>
 * <li>sStr1==sStr1 returns false</li>
 * <li>sStr1.equals(sStr2) returns true</li>
 * <li>sStr1.hashcode()==sStr2.hashcode() return false</li>
 * </ul>
 */
public class SuperString {

	private String string = null;

	public SuperString(String string) {
		this.string = string;

	}

	/**
	 * 
	 * @see java.lang.Object#hashCode()
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		return System.identityHashCode(string);
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return string;
	}

	/**
	 * 
	 * @param superString
	 * @return
	 */
	public boolean equals(SuperString superString) {
		return this.string.equals(superString.getString());
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public boolean equals(String string) {
		return this.string.equals(string);
	}

	/**
	 * 
	 * @return the string
	 */
	public String getString() {
		return string;
	}




}
