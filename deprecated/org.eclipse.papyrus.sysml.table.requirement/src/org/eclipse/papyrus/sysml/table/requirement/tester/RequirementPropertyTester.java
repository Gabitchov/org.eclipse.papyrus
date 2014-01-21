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
package org.eclipse.papyrus.sysml.table.requirement.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.sysml.table.requirement.CreateRequirementTableCommand;


public class RequirementPropertyTester extends PropertyTester {

	/**
	 * the property to test
	 */
	public static final String IS_APPLIED_REQUIREMENTS = "isAppliedRequirements"; //$NON-NLS-1$

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
		if(IS_APPLIED_REQUIREMENTS.equals(property) && receiver instanceof IStructuredSelection) {
			boolean currentValue = testIsAppliedRequirements((IStructuredSelection)receiver);
			return (new Boolean(currentValue).equals(expectedValue));
		}
		return false;
	}

	/**
	 * returns <code>true</code> if the first selected element is inside a package where the profile SysML::Allocations is applied
	 * 
	 * @param selection
	 * @return
	 */
	private boolean testIsAppliedRequirements(IStructuredSelection selection) {
		CreateRequirementTableCommand handler = new CreateRequirementTableCommand();
		return handler.isEnabled();
	}
}
