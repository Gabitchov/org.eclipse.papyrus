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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;


public class CustomStringStyleObservableValue extends AbstractCustomStyleObservableValue {

	public CustomStringStyleObservableValue(View source, EditingDomain domain, String styleName) {
		super(source, domain, styleName, NotationPackage.eINSTANCE.getStringValueStyle(), NotationPackage.eINSTANCE.getStringValueStyle_StringValue());
	}

	public Object getValueType() {
		return String.class;
	}

	/**
	 * Gets the default value when this style is not set.
	 * Subclasses may override
	 * 
	 * @return The default value for this StringStyleValue
	 */
	@Override
	protected String getDefaultValue() {
		return ""; //$NON-NLS-1$
	}

	@Override
	public Command getCommand(Object value) {
		if(value instanceof String) {
			return super.getCommand(value);
		}
		throw new IllegalArgumentException("The value " + value + " is not a valid String Value");
	}
}
