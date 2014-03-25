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
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Edit-helper advice for parameters.  Advice includes:
 * <ul>
 * <li>advising create-child for value specifications to create them in the <tt>defaultValue</tt> reference instead of <tt>lowerValue</tt> or <tt>upperValue</tt>
 * from {@link MultiplicityElement}.</li>
 * </ul>
 */
public class ParameterHelperAdvice extends AbstractEditHelperAdvice {

	public ParameterHelperAdvice() {
		super();
	}


	@Override
	public void configureRequest(IEditCommandRequest request) {
		if(request instanceof CreateElementRequest) {
			configureCreateElementRequest((CreateElementRequest)request);
		} else {
			super.configureRequest(request);
		}
	}

	protected void configureCreateElementRequest(CreateElementRequest request) {
		if((request.getContainmentFeature() == null) && UMLPackage.Literals.VALUE_SPECIFICATION.isSuperTypeOf(request.getElementType().getEClass())) {
			// Prefer to create value specifications as parameter default values, not as lower/upper values for multiplicity
			request.setContainmentFeature(UMLPackage.Literals.PARAMETER__DEFAULT_VALUE);
		}
	}
	
}
