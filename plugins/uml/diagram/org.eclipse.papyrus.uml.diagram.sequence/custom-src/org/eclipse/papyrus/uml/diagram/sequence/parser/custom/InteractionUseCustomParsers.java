/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.sequence.parser.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for the InteractionUse. This parser of refreshing the text displayed by the
 * InteractionUse.
 */
public class InteractionUseCustomParsers extends MessageFormatParser implements ISemanticParser {

	public InteractionUseCustomParsers(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public InteractionUseCustomParsers(EAttribute[] features) {
		super(features);
	}

	public InteractionUseCustomParsers() {
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
	 * org.eclipse.papyrus.uml.diagram.sequence.parsers.AbstractParser#isAffectingEvent(java.lang.Object
	 * , int)
	 */
	@Override
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse
	 * .core.runtime.IAdaptable, int)
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		StringBuffer sb = new StringBuffer();
		if(obj instanceof InteractionUse) {
			InteractionUse interactionUse = (InteractionUse)obj;
			Interaction interaction = interactionUse.getRefersTo();
			if(interaction != null) {
				String interactionName = interaction.getName();
				if(interactionName != null) {
					sb.append(interaction.getName());
				}
			}
		}
		return sb.toString();
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
	public List getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof InteractionUse) {
			InteractionUse interactionUse = (InteractionUse)element;
			semanticElementsBeingParsed.add(interactionUse);
			Interaction interaction = interactionUse.getRefersTo();
			if(interaction != null) {
				// Add the interaction refered.
				semanticElementsBeingParsed.add(interaction);
				// TODO : Collaboration and interactionUse
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
		return UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature) || UMLPackage.eINSTANCE.getInteractionUse_RefersTo().equals(feature);
	}
}
