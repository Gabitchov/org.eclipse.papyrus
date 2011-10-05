/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - EditorPropertyTester Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.ui.IWorkbenchPart;

/**
 * The Class EditorPropertyTester.
 */
public class EditorPropertyTester extends PropertyTester {

	/**
	 * Instantiates a new editor property tester.
	 */
	public EditorPropertyTester() {
	}

	/**
	 * Test if the current editor is a registered editor.
	 * 
	 * @param receiver
	 *        the receiver
	 * @param property
	 *        the property
	 * @param args
	 *        the args
	 * @param expectedValue
	 *        the expected value
	 * 
	 * @return true, if test
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(receiver instanceof IWorkbenchPart && "isCorrectEditor".equals(property)) {
			IWorkbenchPart part = (IWorkbenchPart)receiver;
			return LayoutToolExtensionPointManager.getInstance().getSubEditor(part) != null;
		}
		return false;
	}

}
