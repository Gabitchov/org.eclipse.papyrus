/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.providers;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;


public class DiagramPropertyTester extends PropertyTester {

	/** property to test if the selected element are open in the editor */
	public static final String IS_DIAGRAM = "isDiagram"; //$NON-NLS-1$

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_DIAGRAM.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isDiagram((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}

	/**
	 * Tests the selection in order to know if it contains only {@link Diagram}
	 * 
	 * @param selection
	 * @return
	 *         <code>true</code> if the selection is composed by {@link Diagram}
	 */
	private boolean isDiagram(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				if(!(iter.next() instanceof Diagram)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
