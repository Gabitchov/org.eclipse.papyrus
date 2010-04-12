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
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Specific Parser for the DurationObservation.
 */
public class DurationObservationParser extends MessageFormatParser implements ISemanticParser {

	/** The String for displaying a line break */
	private static final String LINE_BREAK = System.getProperty("line.separator");

	public DurationObservationParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	public DurationObservationParser(EAttribute[] features) {
		super(features);
	}

	public DurationObservationParser(EAttribute[] features, EAttribute[] editableFeatures) {
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
		StringBuffer result = new StringBuffer();
		Object adapter = element.getAdapter(EObject.class);
		if(adapter instanceof Message) {
			Message message = (Message)adapter;
			MessageEnd event1 = message.getSendEvent();
			MessageEnd event2 = message.getReceiveEvent();
			List<DurationObservation> observations = DurationObservationHelper.getDurationObservationsBetween(event1, event2);
			for(DurationObservation observation : observations) {
				if(result.length() > 0) {
					result.append(LINE_BREAK);
				}
				result.append(DurationObservationHelper.getLabelString(observation));
			}
		}
		return result.toString();
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
		if(element instanceof Message) {
			Message message = (Message)element;
			semanticElementsBeingParsed.add(message);
			MessageEnd event1 = message.getSendEvent();
			semanticElementsBeingParsed.add(event1);
			MessageEnd event2 = message.getReceiveEvent();
			semanticElementsBeingParsed.add(event2);
			List<DurationObservation> observations = DurationObservationHelper.getDurationObservationsBetween(event1, event2);
			for(DurationObservation observation : observations) {
				semanticElementsBeingParsed.add(observation);
				// owner for listening DurationObservation deletion
				semanticElementsBeingParsed.add(observation.getOwner());
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
		// detect DurationObservation deletion
		if(feature instanceof EReference && ((EReference)feature).isContainment()) {
			return true;
		}
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getMessage_SendEvent().equals(feature) || UMLPackage.eINSTANCE.getMessage_ReceiveEvent().equals(feature) || UMLPackage.eINSTANCE.getDurationObservation_Event().equals(feature);
	}

}
