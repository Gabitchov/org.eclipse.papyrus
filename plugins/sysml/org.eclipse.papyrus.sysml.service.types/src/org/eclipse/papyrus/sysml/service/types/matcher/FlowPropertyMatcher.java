/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.portandflows.FlowProperty;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Property;

/**
 * Test if current {@link Property} is a {@link FlowProperty}
 */
public class FlowPropertyMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isFlowProperty = false;
		if(eObject instanceof Property) {

			Property element = (Property)eObject;
			if(ElementUtil.getStereotypeApplication(element, FlowProperty.class) != null) {
				isFlowProperty = true;
			}
		}
		return isFlowProperty;
	}

}
