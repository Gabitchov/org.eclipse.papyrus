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
package org.eclipse.papyrus.infra.table.menu.providers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This tester provides action in order to active handlers
 * 
 * 
 * 
 */
public class TableTester extends PropertyTester {

	/**
	 * the properties to tests
	 */
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
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_TABLE.equals(property) && expectedValue instanceof Boolean) {
			boolean answer = isTable();
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}

	/**
	 * Tests if the current editor is a table
	 * 
	 * @return
	 *         <code>true</code> if the current editor is a table
	 */
	protected boolean isTable() {
		IWorkbench wb = PlatformUI.getWorkbench();
		if (wb != null) {
			IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
			if (window != null) {
				IWorkbenchPage page = window.getActivePage();
				if (page != null) {
					IEditorPart editor = page.getActiveEditor();
					if(editor != null) {
						Object provider = editor.getAdapter(INatTableWidgetProvider.class);
						return provider != null;
					}
				}
			}
		}
		return false;
	}

}
