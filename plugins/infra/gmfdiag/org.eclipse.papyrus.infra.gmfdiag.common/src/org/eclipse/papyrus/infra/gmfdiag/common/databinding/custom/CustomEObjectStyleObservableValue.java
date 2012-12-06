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
package org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;


public class CustomEObjectStyleObservableValue extends AbstractCustomStyleObservableValue {

	public CustomEObjectStyleObservableValue(View source, EditingDomain domain, String styleName) {
		super(source, domain, styleName, NotationPackage.eINSTANCE.getEObjectValueStyle(), NotationPackage.eINSTANCE.getEObjectValueStyle_EObjectValue());
	}

	public Object getValueType() {
		return EObject.class;
	}

	/**
	 * Gets the default value when this style is not set.
	 * Subclasses may override
	 * 
	 * @return The default value for this EObjectStyleValue
	 */
	@Override
	protected EObject getDefaultValue() {
		return null;
	}

	@Override
	public Command getCommand(Object value) {
		if(value instanceof EObject) {
			return super.getCommand(value);
		}
		throw new IllegalArgumentException("The value " + value + " is not a valid EObject Value");
	}
}
