/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * Basic whitespace detector for the scanner.<BR>
 * It defines the class by which WhitespaceRule determines whether a given character is to be
 * considered whitespace in the current context.
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.rules.IWhitespaceDetector
 */
public class WhitespaceDetector implements IWhitespaceDetector {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.IWhitespaceDetector#isWhitespace(char)
	 */
	/**
	 * 
	 * 
	 * @param character
	 * 
	 * @return
	 */
	public boolean isWhitespace(char character) {
		return Character.isWhitespace(character);
	}
}