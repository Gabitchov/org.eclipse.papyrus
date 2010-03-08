/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.parser.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for displaying a behavior which is associated to an element. This parser refreshes the text
 * displayed for the behavior.
 */
public abstract class AssociatedBehaviorParser extends MessageFormatParser implements ISemanticParser {

	public AssociatedBehaviorParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public AssociatedBehaviorParser(EAttribute[] features) {
		super(features);
	}

	public AssociatedBehaviorParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	protected EStructuralFeature getEStructuralFeature(Object notification) {
		EStructuralFeature featureImpl = null;
		if(notification instanceof Notification) {
			Object feature = ((Notification)notification).getFeature();
			if(feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature)feature;
			}
		}
		return featureImpl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.AbstractParser#isAffectingEvent(java.lang.Object
	 * , int)
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);

	}

	@Override
	public String getEditString(IAdaptable adapter, int flags) {
		String value = getValueString(adapter, flags);
		if(value != null) {
			return value;
		}
		return "";
	}

	@Override
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		Object obj = adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(obj);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(getReferenceFeature().getContainerClass().isInstance(obj)) {
			Object behavior = ((EObject)obj).eGet(getReferenceFeature());
			if(behavior instanceof Behavior) {
				return getModificationCommand((EObject)behavior, UMLPackage.eINSTANCE.getNamedElement_Name(), newString);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse
	 * .core.runtime.IAdaptable, int)
	 */
	public String getPrintString(IAdaptable element, int flags) {
		String label = getValueString(element, flags);
		if(label == null || label.length() == 0) {
			label = "";
		} else {
			label = String.format(getFormatString(), label);
		}
		return label;
	}

	/**
	 * Get the string format for formatting the text value. This String must contain a single "%s" occurrence where to place the value.
	 * 
	 * @return the format string
	 */
	protected abstract String getFormatString();

	/**
	 * Get the unformatted registered string value which shall be displayed
	 */
	private String getValueString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		if(getReferenceFeature().getContainerClass().isInstance(obj)) {
			Object behavior = ((EObject)obj).eGet(getReferenceFeature());
			if(behavior instanceof Behavior) {
				return ((Behavior)behavior).getName();
			}
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#areSemanticElementsAffected
	 * (org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		EStructuralFeature feature = getEStructuralFeature(notification);
		return isValidFeature(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#getSemanticElementsBeingParsed
	 * (org.eclipse.emf.ecore.EObject)
	 */
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(getReferenceFeature().getContainerClass().isInstance(element)) {
			semanticElementsBeingParsed.add((Element)element);
			Object behavior = element.eGet(getReferenceFeature());
			if(behavior instanceof Behavior) {
				semanticElementsBeingParsed.add((Element)behavior);
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * Determines if the given feature has to be taken into account in this parser
	 * 
	 * @param feature
	 *        the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		return getReferenceFeature().equals(feature) || UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
	}

	/**
	 * Get the feature by which the property behavior is linked.
	 * This method must be implemented by subclasses and the returned feature must reference a Behavior.
	 * 
	 * @return reference feature
	 */
	protected abstract EStructuralFeature getReferenceFeature();
}
