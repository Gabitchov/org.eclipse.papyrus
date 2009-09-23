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
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.UMLPackage;

public class LifelineCustomParsers extends MessageFormatParser {

	public LifelineCustomParsers(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
		// TODO Auto-generated constructor stub
	}

	public LifelineCustomParsers(EAttribute[] features) {
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
		if (UMLPackage.eINSTANCE.getLifeline_Represents().equals(feature)
				|| UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature)
				|| UMLPackage.eINSTANCE.getNamedElement_NameExpression().equals(feature)
				|| UMLPackage.eINSTANCE.getLifeline_Selector().equals(feature)) {
			isAffectingEvent = true;
		}
		return isAffectingEvent;

	}

	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		StringBuffer sb = new StringBuffer();
		if (obj instanceof Lifeline) {
			Lifeline lifeline = (Lifeline) obj;

			if (lifeline.getName() != null) {
				sb.append(lifeline.getName());
			}
			if (lifeline.getRepresents() != null) {

				if (lifeline.getRepresents().getType() != null) {
					if (lifeline.getRepresents().getType().getName() != null
							&& lifeline.getRepresents().getType().getName().length() > 0) {
						sb.append(" : ");
						sb.append(lifeline.getRepresents().getType().getName());
					}

				}
			}

			if (lifeline.getSelector() != null) {

				if (lifeline.getSelector() instanceof LiteralUnlimitedNatural) {
					sb.append(" [ ");
					sb.append(((LiteralUnlimitedNatural) lifeline.getSelector()).getValue());
					sb.append(" ] ");
				}

				if (lifeline.getSelector() instanceof LiteralInteger) {
					sb.append(" [ ");
					sb.append(((LiteralInteger) lifeline.getSelector()).getValue());
					sb.append(" ] ");
				}

			}
		}
		return sb.toString();
	}

}
