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
package org.eclipse.papyrus.infra.table.modelexplorer.providers;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;

/**
 * This class provides test called by the plugin.xml in order to know if handlers should be active or not.
 * 
 * Sometimes these test can be done directly in the plugin.xml in the activeWhen (with instanceof, adapt, ...),
 * but in this case, Eclipse doesn't refresh correctly the status of the command in the menu Edit or in other menu.
 * 
 * 
 * FIXME : i think this class is not yet used
 */
public class TablePropertyTester extends PropertyTester {


	/** property to test if the selected elements is a table */
	public static final String IS_TABLE = "isTable"; //$NON-NLS-1$


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
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if(IS_TABLE.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isTable((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}



	/**
	 * Tests the selection in order to know if it contains only {@link TableInstance}
	 * 
	 * @param selection
	 * @return
	 *         <code>true</code> if the selection is composed by {@link TableInstance}
	 */
	private boolean isTable(final IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				/**
				 * Set to use the IAdaptable mechanism
				 * Used for example for facet elements
				 */
				final Object next = iter.next();
				EObject table = EMFHelper.getEObject(next);
				if(!(table instanceof PapyrusTableInstance)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
