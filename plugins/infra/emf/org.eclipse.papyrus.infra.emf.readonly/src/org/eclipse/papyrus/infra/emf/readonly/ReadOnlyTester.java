/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;

public class ReadOnlyTester extends PropertyTester {

	public static final String IS_READ_ONLY = "isReadOnly"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_READ_ONLY.equals(property) && receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)receiver;

			Iterator<?> it = selection.iterator();
			while(it.hasNext()) {
				Object obj = it.next();
				Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(obj);
				if(businessObject instanceof EObject) {
					Resource resource = ((EObject)businessObject).eResource();
					if(resource != null && resource.getResourceSet() != null) {
						return ReadOnlyManager.isReadOnly(resource, WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(resource.getResourceSet()));
					}
				}
			}
		}
		return false;
	}

}
