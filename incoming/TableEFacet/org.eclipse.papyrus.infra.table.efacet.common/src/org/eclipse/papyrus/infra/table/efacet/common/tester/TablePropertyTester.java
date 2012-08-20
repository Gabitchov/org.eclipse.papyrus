/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.common.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor;

/**
 * 
 * This class provides tests to define the enablement of the actions
 * 
 */
public class TablePropertyTester extends PropertyTester {

	/** this property is used to know if the current editor is a PapyrusTableEditor */
	final String IS_PAPYRUS_TABLE_EFACET = "isPapyrusTableEfacet"; //$NON-NLS-1$

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
		if(this.IS_PAPYRUS_TABLE_EFACET.equals(property) && receiver instanceof CoreMultiDiagramEditor) {
			return expectedValue.equals((((CoreMultiDiagramEditor)receiver).getActiveEditor() instanceof AbstractTableEditor));
		}
		return false;
	}

}
