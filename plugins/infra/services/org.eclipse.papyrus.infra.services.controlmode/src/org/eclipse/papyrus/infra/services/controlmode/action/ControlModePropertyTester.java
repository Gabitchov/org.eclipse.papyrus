/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.action;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.controlmode.util.ControlModeUtil;

/**
 * A Property tester to determine whether the Control/Uncontrol actions
 * are enabled
 * 
 * @author Camille Letavernier
 * 
 */
public class ControlModePropertyTester extends PropertyTester {

	private static final String CONTROl_PROPERTY = "control";

	private static final String UNCONTROL_PROPERTY = "uncontrol";

	/**
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(receiver instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)receiver;
			if(selection.size() != 1) {
				return false;
			}

			Object selectedElement = selection.getFirstElement();
			EObject eObject = EMFHelper.getEObject(selectedElement);

			if(eObject == null) {
				return false;
			}

			if(CONTROl_PROPERTY.equals(property)) {
				return ControlModeUtil.canControl(eObject);
			} else if(UNCONTROL_PROPERTY.equals(property)) {
				return ControlModeUtil.canUncontrol(eObject);
			}
		}

		return false;
	}


}
