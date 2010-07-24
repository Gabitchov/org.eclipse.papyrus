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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Specific Parser for the TimeConstraint and DurationConstraint.
 */
public class TimeConstraintParser extends MessageFormatParser implements ISemanticParser {

	/** The String for displaying a line break */
	private static final String LINE_BREAK = System.getProperty("line.separator");

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
		} else if(adapter instanceof DurationConstraint) {
			DurationConstraint constraint = (DurationConstraint)adapter;
			ValueSpecification spec = constraint.getSpecification();
			return String.format(FORMAT, ValueSpecificationUtil.getSpecificationValue(spec));
		} else if(adapter instanceof Message) {
			StringBuffer result = new StringBuffer();
			Message message = (Message)adapter;
			MessageEnd event1 = message.getSendEvent();
			MessageEnd event2 = message.getReceiveEvent();
			List<DurationConstraint> constraints = DurationConstraintHelper.getDurationConstraintsBetween(event1, event2);
			for(DurationConstraint constraint : constraints) {
				if(result.length() > 0) {
					result.append(LINE_BREAK);
				}
				ValueSpecification spec = constraint.getSpecification();
				result.append(String.format(FORMAT, ValueSpecificationUtil.getSpecificationValue(spec)));
			}
			return result.toString();
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
		} else if(element instanceof DurationConstraint) {
			DurationConstraint constraint = (DurationConstraint)element;
			semanticElementsBeingParsed.add(constraint);
		} else if(element instanceof Message) {
			Message message = (Message)element;
			semanticElementsBeingParsed.add(message);
			MessageEnd event1 = message.getSendEvent();
			semanticElementsBeingParsed.add(event1);
			MessageEnd event2 = message.getReceiveEvent();
			semanticElementsBeingParsed.add(event2);
			List<DurationConstraint> constraints = DurationConstraintHelper.getDurationConstraintsBetween(event1, event2);
			for(DurationConstraint constraint : constraints) {
				semanticElementsBeingParsed.add(constraint);
				// owner for listening DurationConstraint deletion
				semanticElementsBeingParsed.add(constraint.getOwner());
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
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature) || ValueSpecification.class.isAssignableFrom(feature.getContainerClass());
	}

}
