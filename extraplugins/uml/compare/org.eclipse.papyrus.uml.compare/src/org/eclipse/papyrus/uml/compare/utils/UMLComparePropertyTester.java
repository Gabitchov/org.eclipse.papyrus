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
package org.eclipse.papyrus.uml.compare.utils;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;


/*
 * 
 *
 *TODO : should be replace by the correct test on the plugin.xml, when it will work (see bug 385744)
 * the correct test in the plugin.xml : 
 *   activeWhen
 *      with selection
 *         iterate
 *           adapt to EObject
 */
public class UMLComparePropertyTester extends PropertyTester {

	/**
	 * The property to test
	 */
	private static final String IS_CORRECT_SELECTION = "isCorrectSelection"; //$NON-NLS-1$

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
		if(IS_CORRECT_SELECTION.equals(property) && receiver instanceof IStructuredSelection && expectedValue instanceof Boolean) {
			return testCurrentSelection((IStructuredSelection)receiver).equals(expectedValue);
		}
		return false;
	}

	/**
	 * Test the type of the diagram
	 * 
	 * @param iEditor
	 *        the current editor
	 * @param expectedValue
	 *        the expected value : the wanted diagram type
	 * @return <code>true</code> if the current diagram has the wanted type
	 */
	protected Boolean testCurrentSelection(final IStructuredSelection selection) {
		final Iterator<?> iterator = ((IStructuredSelection)selection).iterator();
		boolean answer = selection.size() == 2;
		while(iterator.hasNext() && answer) {
			Object current = iterator.next();
			if(current instanceof IAdaptable) {
				final Object eObject = ((IAdaptable)current).getAdapter(EObject.class);
				if(eObject == null) {
					answer = false;
				}
			} else {
				answer = false;
			}
		}
		return answer;
	}
}
