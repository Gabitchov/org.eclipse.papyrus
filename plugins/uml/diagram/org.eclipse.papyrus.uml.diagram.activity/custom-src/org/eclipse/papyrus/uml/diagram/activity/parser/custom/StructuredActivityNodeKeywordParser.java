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
package org.eclipse.papyrus.uml.diagram.activity.parser.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.preferences.IActivityPreferenceConstants;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for displaying the keyword label of a
 * StructuredActivityNode. This parser refreshes the text displayed for the
 * StructuredActivityNode.
 */
public class StructuredActivityNodeKeywordParser extends MessageFormatParser implements ISemanticParser {

	/** The String format for displaying the keyword */
	private static final String KEYWORD_FORMAT = "<<%s>>";

	/** Keyword structured */
	private static final Object STRUCTURED_KEYWORD = "structured";

	/** Specific loop ode Keyword */
	private static final Object LOOP_NODE_KEYWORD = "loop node";

	/** Specific conditional node Keyword */
	private static final Object CONDITIONAL_NODE_KEYWORD = "conditional";

	/** Specific sequence node Keyword */
	private static final Object SEQUENCE_NODE_KEYWORD = "sequence";

	/**
	 * the preference store
	 */
	private final IPreferenceStore preferenceStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();

	public StructuredActivityNodeKeywordParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public StructuredActivityNodeKeywordParser(EAttribute[] features) {
		super(features);
	}

	public StructuredActivityNodeKeywordParser() {
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
	 * org.eclipse.papyrus.uml.diagram.sequence.parsers.AbstractParser#isAffectingEvent
	 * (java.lang.Object , int)
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isValidFeature(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser#
	 * getPrintString(org.eclipse .core.runtime.IAdaptable, int)
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof StructuredActivityNode) {
			if(obj instanceof ExpansionRegion) {
				ExpansionRegion region = (ExpansionRegion)obj;
				return String.format(KEYWORD_FORMAT, region.getMode().getName());
			} else if(obj instanceof LoopNode) {
				boolean displayNameName = preferenceStore.getBoolean(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_LOOP_NODE);
				if(displayNameName) {
					return String.format(KEYWORD_FORMAT, LOOP_NODE_KEYWORD);
				}
			} else if(obj instanceof ConditionalNode) {
				boolean displayNameName = preferenceStore.getBoolean(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_CONDITIONAL_NODE);
				if(displayNameName) {
					return String.format(KEYWORD_FORMAT, CONDITIONAL_NODE_KEYWORD);
				}
			} else if(obj instanceof SequenceNode) {
				boolean displayNameName = preferenceStore.getBoolean(IActivityPreferenceConstants.PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_SEQUENCE_NODE);
				if(displayNameName) {
					return String.format(KEYWORD_FORMAT, SEQUENCE_NODE_KEYWORD);
				}
			}
			return String.format(KEYWORD_FORMAT, STRUCTURED_KEYWORD);
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#
	 * areSemanticElementsAffected (org.eclipse.emf.ecore.EObject,
	 * java.lang.Object)
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		EStructuralFeature feature = getEStructuralFeature(notification);
		return isValidFeature(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#
	 * getSemanticElementsBeingParsed (org.eclipse.emf.ecore.EObject)
	 */
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof StructuredActivityNode) {
			StructuredActivityNode node = (StructuredActivityNode)element;
			semanticElementsBeingParsed.add(node);
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * Determines if the given feature has to be taken into account in this
	 * parser
	 * 
	 * @param feature
	 *        the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getExpansionRegion_Mode().equals(feature);
	}
}
