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
package org.eclipse.papyrus.diagram.sequence.parser.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.UMLPackage;

public class InteractionUseCustomParsers extends MessageFormatParser {

	public InteractionUseCustomParsers(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
		// TODO Auto-generated constructor stub
	}

	public InteractionUseCustomParsers(EAttribute[] features) {
		super(features);
	}

	protected EStructuralFeature getEStructuralFeature(Object notification) {
		EStructuralFeature featureImpl = null;
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			if (feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature) feature;

			}
		}

		return featureImpl;

	}

	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		boolean isAffectingEvent = super.isAffectingEvent(event, flags);
		if (UMLPackage.eINSTANCE.getInteractionFragment_Covered().equals(feature)
				|| UMLPackage.eINSTANCE.getInteractionUse_RefersTo().equals(feature)) {
			isAffectingEvent = true;
		}
		return isAffectingEvent;

	}

	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		StringBuffer sb = new StringBuffer();
		if (obj instanceof InteractionUse) {
			InteractionUse interactionUse = (InteractionUse) obj;

			if (interactionUse.getRefersTo() != null)

			{
				if (interactionUse.getRefersTo().getName() != null
						&& interactionUse.getRefersTo().getName().length() > 0) {

					if (!interactionUse.getEnclosingInteraction().getName().equals(
							interactionUse.getRefersTo().getName()))

					{
						sb.append("  ");
						sb.append(interactionUse.getRefersTo().getName());

					}
				}
			}

		}
		return sb.toString();
	}

}