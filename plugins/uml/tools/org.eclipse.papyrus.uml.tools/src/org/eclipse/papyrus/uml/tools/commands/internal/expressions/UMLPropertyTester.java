/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.tools.commands.internal.expressions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;


/**
 * This is the UMLPropertyTester type. Enjoy.
 */
public class UMLPropertyTester extends PropertyTester {

	public static final String IS_ROOT = "isRoot";

	public UMLPropertyTester() {
		super();
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_ROOT.equals(property)) {
			return Boolean.valueOf(isRoot(receiver)).equals(asBoolean(expectedValue));
		}
		return false;
	}

	protected Boolean asBoolean(Object value) {
		// the implicit expected-value for boolean properties is true
		return (value == null) ? Boolean.TRUE : (value instanceof Boolean) ? (Boolean)value : Boolean.FALSE;
	}

	protected boolean isRoot(Object object) {
		boolean result = false;

		EObject eObject = EMFHelper.getEObject(object);
		if(eObject != null) {
			try {
				ModelSet modelSet = ServiceUtilsForEObject.getInstance().getModelSet(eObject);
				UmlModel uml = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);

				try {
					result = (uml != null) && (uml.lookupRoot() == eObject);
				} catch (NotFoundException e) {
					// obviously, then, this isn't the root
					result = false;
				}
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}

		return result;
	}
}
