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
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for the Object Flow to know whether it is decision input flow of a Decision
 * Node. This parser refreshes the text displayed by the Object Flow.
 */
public class DecisionInputFlowParser extends MessageFormatParser implements ISemanticParser {

	private static final String DECISION_INPUT_FLOW_LABEL = "<<decisionInputFlow>>";

	public DecisionInputFlowParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public DecisionInputFlowParser(EAttribute[] features) {
		super(features);
	}

	public DecisionInputFlowParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getActivity_IsSingleExecution() });
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse
	 * .core.runtime.IAdaptable, int)
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);

		if(obj instanceof ObjectFlow) {
			ActivityNode target = ((ObjectFlow)obj).getTarget();
			if(target instanceof DecisionNode) {
				ObjectFlow decisionInputFlow = ((DecisionNode)target).getDecisionInputFlow();
				if(obj.equals(decisionInputFlow)) {
					return DECISION_INPUT_FLOW_LABEL;
				}
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
		if(element instanceof ObjectFlow) {
			ObjectFlow flow = (ObjectFlow)element;
			semanticElementsBeingParsed.add(flow);
			if(flow.getTarget() instanceof DecisionNode) {
				DecisionNode decision = (DecisionNode)flow.getTarget();
				semanticElementsBeingParsed.add(decision);
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
		return UMLPackage.eINSTANCE.getActivityEdge_Target().equals(feature) || UMLPackage.eINSTANCE.getDecisionNode_DecisionInputFlow().equals(feature);
	}

}
