/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.file.tester;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * 
 * A property tester for UMLCompareFile
 * 
 */
public class CompareUMLFileTester extends PropertyTester {

	/** property to test if the selected element are uml files */
	public static final String IS_SELECTION_FOR_UML_COMPARE_FILE = "isSelectionForUMLCompareFile"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * 
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		boolean returnValue = true;
		if(IS_SELECTION_FOR_UML_COMPARE_FILE.equals(property) && receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)receiver;
			if(selection.size() == 2) {
				Iterator<?> iter = selection.iterator();
				while(iter.hasNext() && returnValue) {
					Object current = iter.next();
					if(!(current instanceof IFile)) {
						returnValue = false;
					} else {
						final IFile file = (IFile)current;
						returnValue = file.getFileExtension().equals("uml");
					}
				}
			} else {
				returnValue = false;
			}
		} else {
			returnValue = false;
		}
		return returnValue;
	}
}
