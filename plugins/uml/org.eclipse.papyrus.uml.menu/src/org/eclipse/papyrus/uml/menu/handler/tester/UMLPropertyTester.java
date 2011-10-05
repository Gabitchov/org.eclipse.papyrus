/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.menu.handler.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class provides test in order to
 * <ul>
 * <li>refresh action owned by menu and toolbar</li>
 * <li>avoid conflict handler</li>
 * </ul>
 * 
 * 
 * 
 */
public class UMLPropertyTester extends PropertyTester {

	/** id for the properties to test */
	public static final String IS_NAMED_ELEMENT = "isNamedElement";

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
		if(IS_NAMED_ELEMENT.equals(property) && receiver instanceof IStructuredSelection) {
			boolean currentValue = testIsNamedElement((IStructuredSelection)receiver);
			return (new Boolean(currentValue).equals(expectedValue));
		}
		return false;
	}

	/**
	 * return <code>true</code> if the selection is a NamedElement
	 * 
	 * @param selection
	 *        the selection owning the element to test
	 * @return
	 *         <code>true</code> if the selection is a NamedElement
	 */
	private boolean testIsNamedElement(IStructuredSelection selection) {
		if(!selection.isEmpty() && selection.size() == 1) {
			Object current = selection.getFirstElement();
			if(current instanceof IAdaptable) {
				current = ((IAdaptable)current).getAdapter(EObject.class);
				return current instanceof NamedElement;
			}
			return selection.getFirstElement() instanceof NamedElement;
		}
		return false;
	}

}
