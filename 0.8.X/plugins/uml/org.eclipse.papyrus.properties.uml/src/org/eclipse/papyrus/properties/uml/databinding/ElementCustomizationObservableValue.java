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
package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.papyrus.umlutils.ui.command.SetNameLabelIconCommand;
import org.eclipse.papyrus.umlutils.ui.command.SetQualifiedNameDepthCommand;
import org.eclipse.papyrus.umlutils.ui.command.SetShadowFigureCommand;
import org.eclipse.papyrus.umlutils.ui.helper.NameLabelIconHelper;
import org.eclipse.papyrus.umlutils.ui.helper.QualifiedNameHelper;
import org.eclipse.papyrus.umlutils.ui.helper.ShadowFigureHelper;
import org.eclipse.uml2.uml.Element;


public class ElementCustomizationObservableValue extends AbstractObservableValue {

	private EditPart sourceElement;

	private Property property;

	private TransactionalEditingDomain domain;

	private View notationElement;

	private Element semanticElement;

	public ElementCustomizationObservableValue(EditPart sourceElement, Property property) {
		this.sourceElement = sourceElement;
		this.property = property;
		semanticElement = UMLUtil.resolveUMLElement(sourceElement);
		notationElement = (View)sourceElement.getModel();
		domain = (TransactionalEditingDomain)UMLUtil.resolveEditingDomain(semanticElement);
	}

	//TODO : The value is not correctly refreshed when someone else edits it
	//Some listeners need to be added
	public Object getValueType() {
		switch(property) {
		case LABEL_CUSTOMIZATION:
		case QUALIFIED_NAME:
			return Integer.class;
		case ELEMENT_ICON:
		case SHADOW:
			return Boolean.class;
		}

		return Object.class;
	}

	@Override
	protected Object doGetValue() {
		switch(property) {
		case LABEL_CUSTOMIZATION:
			return getEditPolicy().getCurrentDisplayValue();
		case ELEMENT_ICON:
			return NameLabelIconHelper.showLabelIcon(notationElement);
		case SHADOW:
			return ShadowFigureHelper.getShadowFigureValue(notationElement);
		case QUALIFIED_NAME:
			return QualifiedNameHelper.getQualifiedNameDepth(notationElement);
		}

		return null;
	}

	protected IMaskManagedLabelEditPolicy getEditPolicy() {
		return (IMaskManagedLabelEditPolicy)sourceElement.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
	}

	@Override
	protected void doSetValue(Object value) {
		switch(property) {
		case LABEL_CUSTOMIZATION:
			if(value instanceof Integer) {
				getEditPolicy().updateDisplayValue((Integer)value);
			} else {
				Activator.log.warn(value + " is not a valid value for LabelCustomization ; need an Integer"); //$NON-NLS-1$
			}
			break;
		case ELEMENT_ICON:
			if(value instanceof Boolean) {
				domain.getCommandStack().execute(new SetNameLabelIconCommand(domain, notationElement, (Boolean)value));
			} else {
				Activator.log.warn(value + " is not a valid value for ElementIcon ; need a Boolean"); //$NON-NLS-1$
			}
			break;
		case SHADOW:
			if(value instanceof Boolean) {
				domain.getCommandStack().execute(new SetShadowFigureCommand(domain, notationElement, (Boolean)value));
			} else {
				Activator.log.warn(value + " is not a valid value for Shadow ; need a Boolean"); //$NON-NLS-1$
			}
			break;
		case QUALIFIED_NAME:
			if(value instanceof Integer) {
				domain.getCommandStack().execute(new SetQualifiedNameDepthCommand(domain, notationElement, (Integer)value));
			} else {
				Activator.log.warn(value + " is not a valid value for QualifiedNameDepth ; need an Integer"); //$NON-NLS-1$
			}
			break;
		}
	}

	public enum Property {
		LABEL_CUSTOMIZATION, ELEMENT_ICON, SHADOW, QUALIFIED_NAME
	}

}
