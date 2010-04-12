/*****************************************************************************
 * Copyright (c) 2010 CEA
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Specific Parser for the TimeConstraint.
 */
public class TimeConstraintParser extends MessageFormatParser implements ISemanticParser {

	/** The format for displaying time constraint text */
	private static final String FORMAT = "{%s}";

	public TimeConstraintParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	public TimeConstraintParser(EAttribute[] features) {
		super(features);
	}

	public TimeConstraintParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	/**
	 * Gets the e structural feature.
	 * 
	 * @param notification
	 * @return the structural feature
	 */
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

	/**
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Object adapter = element.getAdapter(EObject.class);
		if(adapter instanceof TimeConstraint) {
			TimeConstraint constraint = (TimeConstraint)adapter;
			ValueSpecification spec = constraint.getSpecification();
			return String.format(FORMAT, ValueSpecificationUtil.getSpecificationValue(spec));
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		EStructuralFeature feature = getEStructuralFeature(notification);
		return isValidFeature(feature);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof TimeConstraint) {
			TimeConstraint constraint = (TimeConstraint)element;
			semanticElementsBeingParsed.add(constraint);
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
		// detect DurationObservation deletion
		if(feature instanceof EReference && ((EReference)feature).isContainment()) {
			return true;
		}
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature) || ValueSpecification.class.isAssignableFrom(feature.getContainerClass());
	}

}
