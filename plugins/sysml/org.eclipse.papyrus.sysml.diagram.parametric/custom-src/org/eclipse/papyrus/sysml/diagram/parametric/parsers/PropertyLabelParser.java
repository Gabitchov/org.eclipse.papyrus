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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.parsers;

import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A specific parser for displaying an property. This parser refreshes the text
 * displayed for the Property.
 */
public class PropertyLabelParser extends MessageFormatParser implements ISemanticParser {

	/** The String format for displaying a ConstraintProperty with no type */
	private static final String UNTYPED_PARAMETER_FORMAT = "%s";

	/** The String format for displaying a ConstraintProperty with its type */
	private static final String TYPED_PARAMETER_FORMAT = "%s: %s";

	/** The String format for displaying a ConstraintProperty with multiplicity */
	private static final String MULTIPLICITY_PARAMETER_FORMAT = "%s[%s..%s]";

	/** The String format for displaying a ConstraintProperty with default value */
	private static final String DEFAULT_VALUE_PARAMETER_FORMAT = "%s= %s";

	/** The String format for displaying a ConstraintProperty with attribute */
	private static final String MODIFIER_PARAMETER_FORMAT = "%s{%s}";

	public PropertyLabelParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public PropertyLabelParser(EAttribute[] features) {
		super(features);
	}

	public PropertyLabelParser() {
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
		String result = "";
		Property property = null;
		Object adapter = element.getAdapter(EObject.class);
		if (adapter instanceof Property) {
			property = (Property) adapter;
			String name = property.isDerived() ? "/ " + property.getName() : property.getName();
			if (property.getType() != null) {
				String type = property.getType().getName();
				result = String.format(TYPED_PARAMETER_FORMAT, name, type);
				// manage multiplicity
				if (property.getLower() != 1 || property.getUpper() != 1) {
					result = String.format(MULTIPLICITY_PARAMETER_FORMAT, result, ValueSpecificationUtil
							.getSpecificationValue(property.getLowerValue()), ValueSpecificationUtil
							.getSpecificationValue(property.getUpperValue()));
				}
				// manage initial values
				if (property.getDefaultValue() != null) {
					ValueSpecification valueSpecification = property.getDefaultValue();
					String specificationValue = ValueSpecificationUtil.getSpecificationValue(valueSpecification);
					if (specificationValue != null && specificationValue.length() > 0) {
						result = String.format(DEFAULT_VALUE_PARAMETER_FORMAT, result, ValueSpecificationUtil.getSpecificationValue(valueSpecification));				
					}
				}
			} else {
				result = String.format(UNTYPED_PARAMETER_FORMAT, name);
			}
			// manage modifier
			StringBuffer sb = new StringBuffer();
			if (property.isReadOnly()) {
				sb.append(sb.length() == 0 ? "readOnly" : ", readOnly");
			}
			if (property.isOrdered()) {
				sb.append(sb.length() == 0 ? "ordered" : ", ordered");
			}
			if (property.isUnique()) {
				sb.append(sb.length() == 0 ? "unique" : ", unique");
			}
			if (property.isDerivedUnion()) {
				sb.append(sb.length() == 0 ? "union" : ", union");
			}
			EList<Property> redefinedProperties = property.getRedefinedProperties();
			if (redefinedProperties != null && !redefinedProperties.isEmpty()) {
				for (Property p : redefinedProperties) {
					sb.append(sb.length() == 0 ? p.getName() : ", redefines " + p.getName());
				}
			}
			if (sb.length() != 0) {
				result = String.format(MODIFIER_PARAMETER_FORMAT, result, sb.toString());
			}
		}
		return result;
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
	public List<?> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		Property property = null;
		if (element instanceof Property) {
			property = (Property) element;
			semanticElementsBeingParsed.add(property);
			if (property.getType() != null) {
				semanticElementsBeingParsed.add(property.getType());
				int lower = property.getLower();
				int upper = property.getUpper();
				if (lower != 1 || upper != 1) {
					semanticElementsBeingParsed.add(property.getLowerValue());
					semanticElementsBeingParsed.add(property.getUpperValue());
				}
				if (property.getDefaultValue() != null) {
					semanticElementsBeingParsed.add(property.getDefaultValue());
				}
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
				|| UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature) || UMLPackage.eINSTANCE.getConnector_Type().equals(feature)
				|| UMLPackage.eINSTANCE.getInstanceValue_Instance().equals(feature)
				|| UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(feature)
				|| UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(feature)
				|| UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(feature)
				|| UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(feature)
				|| UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().equals(feature)
				|| UMLPackage.eINSTANCE.getFeature_IsStatic().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_IsDerived().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_RedefinedProperty().equals(feature);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditString(IAdaptable adapter, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		return getEditorProcessor().format(getEditableValues(element), new StringBuffer(), new FieldPosition(0))
				.toString();
	}
	
}
