/*****************************************************************************
 * Copyright (c) 2009 CEA
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
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralSpecification;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A specific parser for the Lifeline header. This parser of refreshing the text displayed by the
 * lifeline.
 */
public class LifelineCustomParsers extends MessageFormatParser implements ISemanticParser {

	public LifelineCustomParsers(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public LifelineCustomParsers(EAttribute[] features) {
		super(features);
	}

	public LifelineCustomParsers() {
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

	@Override
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);
	}

	/**
	 * Information identifying the lifeline displayed inside the rectangle
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse.core.runtime.IAdaptable, int)
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		StringBuffer sb = new StringBuffer();

		if(obj instanceof Lifeline) {
			Lifeline lifeline = (Lifeline)obj;
			ConnectableElement connectableElement = lifeline.getRepresents();
			ValueSpecification selector = lifeline.getSelector();

			if(connectableElement != null) {
				// Add ConnectableElement Name
				String connectableElementName = connectableElement.getName();
				if(connectableElementName != null) {
					sb.append(connectableElementName);
				}

				// Add the selector if it is a LiteralSpecification
				if(selector instanceof LiteralSpecification) {
					sb.append("[").append(ValueSpecificationUtil.getSpecificationValue(selector)).append("]");
				}

				// Add the type name
				Type type = connectableElement.getType();
				if(type != null && type.getName() != null && type.getName().length() > 0) {
					sb.append(" : ").append(type.getName());
				}
			}

			// Add the selector if it is an Expression
			if(selector instanceof Expression || selector instanceof OpaqueExpression || selector instanceof TimeExpression) {
				String specificationValue = ValueSpecificationUtil.getSpecificationValue(selector);
				if(specificationValue != null && specificationValue.length() > 0) {
					sb.append("\n").append(specificationValue);
				}
			}

			// Add the decomposition
			PartDecomposition partDecomposition = lifeline.getDecomposedAs();
			if(partDecomposition != null) {
				Interaction refersTo = partDecomposition.getRefersTo();
				if(refersTo != null) {
					sb.append("\nref ").append(refersTo.getName());
				}
			}

			// LifelineIndent cannot be empty so if the stringBuffer is empty we add the name of the
			// lifeline
			// This case occurs when creating the lifeline for example
			if(sb.length() == 0) {
				sb.append(lifeline.getName());
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
		if(element instanceof Lifeline) {
			Lifeline lifeline = (Lifeline)element;

			// Add the lifeline
			semanticElementsBeingParsed.add(lifeline);
			// Add the selector
			if(lifeline.getSelector() != null) {
				semanticElementsBeingParsed.add(lifeline.getSelector());
			}

			// Add the partDecomposition
			PartDecomposition partDecomposition = lifeline.getDecomposedAs();
			if(partDecomposition != null) {
				semanticElementsBeingParsed.add(partDecomposition);
				// Add the Interaction refered by the partDecomposition
				if(partDecomposition.getRefersTo() != null) {
					semanticElementsBeingParsed.add(partDecomposition.getRefersTo());
				}
			}

			// Add the connectableElement and its type if it has any
			ConnectableElement connectableElement = lifeline.getRepresents();
			if(connectableElement != null) {
				semanticElementsBeingParsed.add(connectableElement);
				if(connectableElement.getType() != null) {
					semanticElementsBeingParsed.add(connectableElement.getType());
				}
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
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature) || UMLPackage.eINSTANCE.getLiteralInteger_Value().equals(feature) || UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value().equals(feature) || UMLPackage.eINSTANCE.getLiteralBoolean_Value().equals(feature) || UMLPackage.eINSTANCE.getLiteralString_Value().equals(feature) || UMLPackage.eINSTANCE.getOpaqueExpression_Body().equals(feature) || UMLPackage.eINSTANCE.getLifeline_Selector().equals(feature) || UMLPackage.eINSTANCE.getLifeline_DecomposedAs().equals(feature) || UMLPackage.eINSTANCE.getLifeline_Represents().equals(feature) || UMLPackage.eINSTANCE.getInteractionUse_RefersTo().equals(feature);
	}
}
