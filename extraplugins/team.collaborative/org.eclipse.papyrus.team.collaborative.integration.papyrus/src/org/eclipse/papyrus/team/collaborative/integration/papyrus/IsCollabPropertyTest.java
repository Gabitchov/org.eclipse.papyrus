/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.team.collaborative.utils.CollabUtils;


/**
 * Tester to check if the selection belong to a collaborative model.
 * 
 * @author adaussy
 */
public class IsCollabPropertyTest extends PropertyTester {

	/** The Constant IS_COLLAB_PROPERTY. */
	private static final String IS_COLLAB_PROPERTY = "isCollab";

	/**
	 * Instantiates a new checks if is collab property test.
	 */
	public IsCollabPropertyTest() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_COLLAB_PROPERTY.equals(property)) {
			if(receiver instanceof ISelection) {
				ISelection selection = (ISelection)receiver;
				if(selection instanceof IStructuredSelection) {
					IStructuredSelection structurSelection = (IStructuredSelection)selection;
					Object first = structurSelection.getFirstElement();
					EObject eObject = EMFHelper.getEObject(first);
					if(eObject != null) {
						return CollabUtils.isCollab(eObject);
					}
				}
			}
		}
		return false;
	}


}
