/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
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
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Iterator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;

import com.google.common.base.Objects;

public class ReadOnlyTester extends PropertyTester {

	public static final String IS_READ_ONLY = "isReadOnly"; //$NON-NLS-1$

	public static final String CAN_MAKE_WRITABLE = "canMakeWritable"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(receiver instanceof IStructuredSelection) {
			Iterator<?> objects = ((IStructuredSelection)receiver).iterator();

			if(IS_READ_ONLY.equals(property)) {
				return testIsReadOnly(objects, asBoolean(expectedValue));
			} else if(CAN_MAKE_WRITABLE.equals(property)) {
				return canMakeWritable(objects, asBoolean(expectedValue));
			}
		}

		return false;
	}

	protected Boolean asBoolean(Object expectedValue) {
		// true is the implied expected value for booleans
		return (expectedValue instanceof Boolean) ? (Boolean)expectedValue : true;
	}

	protected boolean testIsReadOnly(Iterator<?> objects, Boolean expectedValue) {
		while(objects.hasNext()) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(objects.next());

			if(businessObject instanceof EObject) {
				EObject eObject = (EObject)businessObject;
				Resource resource = eObject.eResource();
				if((resource != null) && (resource.getResourceSet() != null)) {
					return Objects.equal(ReadOnlyManager.getReadOnlyHandler(WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(resource.getResourceSet())).isReadOnly(eObject).get(), expectedValue);
				}
			}
		}

		return false;
	}

	protected boolean canMakeWritable(Iterator<?> objects, Boolean expectedValue) {
		while(objects.hasNext()) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(objects.next());

			if(businessObject instanceof EObject) {
				EObject eObject = (EObject)businessObject;
				Resource resource = eObject.eResource();
				if((resource != null) && (resource.getResourceSet() != null)) {
					IReadOnlyHandler handler = ReadOnlyManager.getReadOnlyHandler(WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(resource.getResourceSet()));
					boolean isAlreadyOrCanMakeWritable = !handler.isReadOnly(eObject).or(false) //
						|| ((handler instanceof IReadOnlyHandler2) && ((IReadOnlyHandler2)handler).canMakeWritable(eObject).or(false));
					return Objects.equal(isAlreadyOrCanMakeWritable, expectedValue);
				}
			}
		}

		return false;
	}
}
