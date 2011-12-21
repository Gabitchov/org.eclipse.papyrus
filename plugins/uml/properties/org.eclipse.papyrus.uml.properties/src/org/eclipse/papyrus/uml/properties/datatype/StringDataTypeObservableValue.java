/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.datatype;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;


public class StringDataTypeObservableValue extends PapyrusObservableValue implements DataTypeObservableValue {

	protected EDataType type;

	public StringDataTypeObservableValue() {
		super(null, null, null);
	}

	@Override
	public Object getValueType() {
		return type.getInstanceClass();
	}

	public void setOwner(EObject owner, EStructuralFeature feature, EditingDomain domain, EDataType type) {
		this.eObject = owner;
		this.eStructuralFeature = feature;
		this.domain = domain;
		this.type = type;
	}

	@Override
	public String toString() {
		return getValue() == null ? "" : getValue().toString();
	}
}
