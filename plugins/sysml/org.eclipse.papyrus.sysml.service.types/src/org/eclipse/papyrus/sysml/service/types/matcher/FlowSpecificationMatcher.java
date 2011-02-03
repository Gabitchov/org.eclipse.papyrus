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
import org.eclipse.papyrus.sysml.portandflows.FlowSpecification;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Interface;

/**
 * Test if current {@link Interface} is a {@link FlowSpecification}
 */
public class FlowSpecificationMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isFlowSpec = false;
		if(eObject instanceof Interface) {

			Interface element = (Interface)eObject;
			if(ElementUtil.getStereotypeApplication(element, FlowSpecification.class) != null) {
				isFlowSpec = true;
			}
		}
		return isFlowSpec;
	}

}
