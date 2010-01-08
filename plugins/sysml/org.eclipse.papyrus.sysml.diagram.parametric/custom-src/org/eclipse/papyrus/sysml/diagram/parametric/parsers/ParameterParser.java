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
package org.eclipse.papyrus.sysml.diagram.parametric.parsers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser for displaying an Activity's Parameter. This parser refreshes the text
 * displayed for the Parameter.
 */
public class ParameterParser extends MessageFormatParser implements ISemanticParser {

	/** The String format for displaying a parameter with its type */
	private static final String TYPED_PARAMETER_FORMAT = "%s: %s";

	/** The String format for displaying a parameter with no type */
	private static final String UNTYPED_PARAMETER_FORMAT = "%s";

	public ParameterParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public ParameterParser(EAttribute[] features) {
		super(features);
	}

	public ParameterParser() {
		super(new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() });
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

		Property property = null;
		// TODO another custom parser will be needed to manage equation in ConstraintProperty
		if (obj instanceof ConstraintProperty) {
			property = ((ConstraintProperty) obj).getBase_Property();
		} else if (obj instanceof Property) {
			property = (Property) obj;
		}

		if (property != null) {
			String name = property.getName();
			if (name == null) {
				name = " ";
			}
			if (property.getType() != null) {
				String type = property.getType().getName();
				if (type == null) {
					type = "";
				}
				return String.format(TYPED_PARAMETER_FORMAT, name, type);
			} else {
				return String.format(UNTYPED_PARAMETER_FORMAT, name);
			}
		}
		return " ";
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
		Property property = null;
		if (element instanceof ConstraintProperty) {
			property = ((ConstraintProperty) element).getBase_Property();
		} else if (element instanceof Property) {
			property = (Property) element;
		}
		if (property != null) {
			semanticElementsBeingParsed.add(property);
			if (property.getType() != null) {
				semanticElementsBeingParsed.add(property.getType());
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * Determines if the given feature has to be taken into account in this parser
	 * 
	 * @param feature
	 *            the feature to test
	 * @return true if is valid, false otherwise
	 */
	private boolean isValidFeature(EStructuralFeature feature) {
		return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature)
				|| UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature);
	}

}
