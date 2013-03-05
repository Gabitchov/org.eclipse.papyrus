/*****************************************************************************
 * Copyright (c) 2011, 2013 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;

public class ReadOnlyTester
		extends PropertyTester {

	public static final String IS_READ_ONLY = "isReadOnly"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (IS_READ_ONLY.equals(property)
			&& receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) receiver;

			Iterator<?> it = selection.iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				Object businessObject = BusinessModelResolver.getInstance()
					.getBusinessModel(obj);
				if (businessObject instanceof EObject) {
					EObject eObject = (EObject) businessObject;
					Resource resource = eObject.eResource();
					ResourceSet resourceSet = (resource == null)
						? null
						: resource.getResourceSet();
					if (resourceSet instanceof ModelSet) {
						return ((ModelSet) resourceSet).isReadOnly(eObject);
					} else if (resourceSet != null) {
						return ReadOnlyManager.isReadOnly(resource,
							WorkspaceEditingDomainFactory.INSTANCE
								.getEditingDomain(resourceSet));
					}
				}
			}
		}
		return false;
	}

}
