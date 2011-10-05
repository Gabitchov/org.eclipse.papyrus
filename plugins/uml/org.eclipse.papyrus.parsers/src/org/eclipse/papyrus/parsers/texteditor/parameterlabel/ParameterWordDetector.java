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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * Basic word detector for the scanner.<BR>
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.rules.IWordDetector
 */
public class ParameterWordDetector implements IWordDetector {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordPart(char)
	 */
	/**
	 * 
	 * 
	 * @param character
	 * 
	 * @return
	 */
	public boolean isWordPart(char character) {
		Character ch = Character.valueOf(character);

		if(ch.compareTo('+') == 0) {
			return true;
		} else if(ch.compareTo('-') == 0) {
			return true;
		} else if(ch.compareTo('#') == 0) {
			return true;
		} else if(ch.compareTo('~') == 0) {
			return true;
		} else if(ch.compareTo('/') == 0) {
			return true;
		} else if(ch.compareTo(':') == 0) {
			return true;
		}

		return Character.isLetter(character);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordStart(char)
	 */
	/**
	 * 
	 * 
	 * @param character
	 * 
	 * @return
	 */
	public boolean isWordStart(char character) {
		Character ch = Character.valueOf(character);

		if(ch.compareTo('+') == 0) {
			return true;
		} else if(ch.compareTo('-') == 0) {
			return true;
		} else if(ch.compareTo('#') == 0) {
			return true;
		} else if(ch.compareTo('~') == 0) {
			return true;
		} else if(ch.compareTo('/') == 0) {
			return true;
		} else if(ch.compareTo(':') == 0) {
			return true;
		}
		return Character.isLetter(character);
	}
}
