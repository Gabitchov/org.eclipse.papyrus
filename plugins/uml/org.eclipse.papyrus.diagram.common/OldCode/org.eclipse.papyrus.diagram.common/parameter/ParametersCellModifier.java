/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parameter;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.papyrus.diagram.common.parameter.EditPropertyParametersDialog.SetValueToSpecification;
import org.eclipse.papyrus.diagram.common.parameter.EditPropertyParametersDialog.ValueSpecificationToStringConverter;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

class ParametersCellModifier implements ICellModifier {

	public boolean canModify(Object element, String property) {
		return true;
	}

	public Object getValue(Object element, String property) {
		Parameter parameter = (Parameter) element;
		if (EditParametersTableConstants.NAME.equals(property)) {
			return parameter.getName();
		}
		if (EditParametersTableConstants.TYPES.equals(property)) {
			return parameter.getType();
		}
		if (EditParametersTableConstants.DIRECTION.equals(property)) {
			return parameter.getDirection();
		}
		if (EditParametersTableConstants.MULTIPLICITY.equals(property)) {
			return parameter.getUpper();
		}
		if (EditParametersTableConstants.DEFAULT_VALUE.equals(property)) {
			ValueSpecification defValue = parameter.getDefaultValue();
			if (defValue == null) {
				return "";
			}
			return new ValueSpecificationToStringConverter().doSwitch(defValue);
		}
		if (EditParametersTableConstants.IS_ORDERED.equals(property)) {
			return parameter.isOrdered();
		}
		if (EditParametersTableConstants.IS_UNIQUE.equals(property)) {
			return parameter.isUnique();
		}
		return null;
	}

	public void modify(Object element, String property, Object value) {
		Parameter parameter = (Parameter) ((TableItem) element).getData();
		if (EditParametersTableConstants.NAME.equals(property)) {
			parameter.setName((String) value);
		} else if (EditParametersTableConstants.TYPES.equals(property)) {
			setType(parameter, value);
		} else if (EditParametersTableConstants.DIRECTION.equals(property)) {
			parameter.setDirection((ParameterDirectionKind) value);
		} else if (EditParametersTableConstants.MULTIPLICITY.equals(property)) {
			parameter.setUpper((Integer) value);
		} else if (EditParametersTableConstants.DEFAULT_VALUE.equals(property)) {
			setDefaultValue(parameter, value);
		} else if (EditParametersTableConstants.IS_UNIQUE.equals(property)) {
			parameter.setIsUnique((Boolean) value);
		} else if (EditParametersTableConstants.IS_ORDERED.equals(property)) {
			parameter.setIsOrdered((Boolean) value);
		}
		boolean modified = true;
		if (modified) {
			updateViewer(parameter, property);
		}
	}

	public void updateViewer(Parameter parameter, String property) {

	}

	private void setDefaultValue(Parameter parameter, Object value) {
		ValueSpecification defValue = parameter.getDefaultValue();
		if (defValue == null) {
			parameter.createDefaultValue(null, null, UMLPackage.eINSTANCE.getLiteralString());
		}
		new SetValueToSpecification((String) value).doSwitch(defValue);
	}

	private void setType(Parameter parameter, Object value) {
		if (EditPropertyParametersDialog.NULL_TYPE.equals(value)) {
			value = null;
		}
		parameter.setType((Type) value);
	}

}