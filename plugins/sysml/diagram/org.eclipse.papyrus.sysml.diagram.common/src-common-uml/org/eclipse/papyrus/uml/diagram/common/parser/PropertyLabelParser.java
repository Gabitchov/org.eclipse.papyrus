/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * Semantic Parser for {@link Property}
 */
public class PropertyLabelParser extends NamedElementLabelParser {

	/** The String format for displaying a {@link Property} with visibility */
	protected static final String VISIBILITY_FORMAT = "%s %s";

	/** The String format for displaying a {@link Property} label with derived modifier */
	protected static final String DERIVED_FORMAT = "%s/";

	/** The String format for displaying a {@link Property} label with its name */
	protected static final String NAME_FORMAT = "%s%s";

	/** The String format for displaying a {@link Property} label with its type */
	protected static final String TYPE_FORMAT = "%s: %s";

	/** The String format for displaying a {@link Property} label with multiplicity */
	protected static final String MULTIPLICITY_FORMAT = "%s [%s..%s]";

	/** The String format for displaying a {@link Property} label with multiplicity */
	protected static final String MULTIPLICITY_FORMAT_ALT = "%s [%s]";

	/** The String format for displaying a {@link Property} label with default value */
	protected static final String DEFAULT_VALUE_FORMAT = "%s= %s";

	/** The String format for displaying a {@link Property} label with modifiers */
	protected static final String MODIFIER_FORMAT = "%s{%s}";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {

		Collection<String> maskValues = getMaskValues(element);

		if(maskValues.isEmpty()) {
			return MaskedLabel;
		}

		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if((eObject != null) && (eObject instanceof Property)) {

			Property property = (Property)eObject;

			// manage visibility
			if(maskValues.contains(ILabelPreferenceConstants.DISP_VISIBILITY)) {
				String visibility;
				switch(property.getVisibility().getValue()) {
				case VisibilityKind.PACKAGE:
					visibility = "~";
					break;
				case VisibilityKind.PUBLIC:
					visibility = "+";
					break;
				case VisibilityKind.PROTECTED:
					visibility = "#";
					break;
				case VisibilityKind.PRIVATE:
					visibility = "-";
					break;
				default:
					visibility = "+";
					break;
				}
				result = String.format(VISIBILITY_FORMAT, visibility, result);
			}

			// manage derived modifier
			if(maskValues.contains(ILabelPreferenceConstants.DISP_DERIVE) && (property.isDerived())) {
				result = String.format(DERIVED_FORMAT, result);
			}

			// manage name
			if(maskValues.contains(ILabelPreferenceConstants.DISP_NAME) && (property.isSetName())) {
				String name = property.getName();
				result = String.format(NAME_FORMAT, result, name);
			}

			// manage type
			if(maskValues.contains(ILabelPreferenceConstants.DISP_TYPE)) {
				String type = "<Undefined>";
				if(property.getType() != null) {
					type = property.getType().getName();
				}

				// If type is undefined only show "<Undefined>" when explicitly asked.
				if(maskValues.contains(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE) || (!"<Undefined>".equals(type))) {
					result = String.format(TYPE_FORMAT, result, type);
				}
			}

			// manage multiplicity
			if(maskValues.contains(ILabelPreferenceConstants.DISP_MULTIPLICITY)) {

				// If multiplicity is [1] (SysML default), only show when explicitly asked.
				// TODO : add a case for default with multiplicity not set.
				String lower = (property.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(property.getLowerValue()) : "1";
				String upper = (property.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(property.getUpperValue()) : "1";
				if(maskValues.contains(ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY) || !("1".equals(lower) && "1".equals(upper))) {

					if(lower.equals(upper)) {
						result = String.format(MULTIPLICITY_FORMAT_ALT, result, lower, upper);
					} else {
						result = String.format(MULTIPLICITY_FORMAT, result, lower, upper);
					}
				}
			}

			// manage default value
			if(maskValues.contains(ILabelPreferenceConstants.DISP_DEFAULT_VALUE) && property.getDefaultValue() != null) {
				ValueSpecification valueSpecification = property.getDefaultValue();
				if((valueSpecification instanceof InstanceValue && property.getType().equals(valueSpecification.getType())) || !(valueSpecification instanceof InstanceValue)) {
					result = String.format(DEFAULT_VALUE_FORMAT, result, ValueSpecificationUtil.getSpecificationValue(valueSpecification));
				}
			}

			// manage modifier
			if(maskValues.contains(ILabelPreferenceConstants.DISP_MODIFIERS)) {
				StringBuffer sb = new StringBuffer();
				if(property.isReadOnly()) {
					sb.append(sb.length() == 0 ? "readOnly" : ", readOnly");
				}
				if(property.isOrdered()) {
					sb.append(sb.length() == 0 ? "ordered" : ", ordered");
				}
				if(property.isUnique()) {
					sb.append(sb.length() == 0 ? "unique" : ", unique");
				}
				if(property.isDerivedUnion()) {
					sb.append(sb.length() == 0 ? "union" : ", union");
				}
				EList<Property> redefinedProperties = property.getRedefinedProperties();
				if(redefinedProperties != null && !redefinedProperties.isEmpty()) {
					for(Property p : redefinedProperties) {
						sb.append(sb.length() == 0 ? p.getName() : ", redefines " + p.getName());
					}
				}
				if(sb.length() != 0) {
					result = String.format(MODIFIER_FORMAT, result, sb.toString());
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAffectingEvent(Object event, int flags) {

		if(event instanceof Notification) {
			Object feature = ((Notification)event).getFeature();

			if(feature instanceof EStructuralFeature) { // UMLPackage.eINSTANCE.getLiteralString_Value().equals(feature) ||
				return UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature) || UMLPackage.eINSTANCE.getInstanceValue_Instance().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(feature) || UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().equals(feature) || UMLPackage.eINSTANCE.getFeature_IsStatic().equals(feature) || UMLPackage.eINSTANCE.getProperty_IsDerived().equals(feature) || UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().equals(feature) || UMLPackage.eINSTANCE.getProperty_RedefinedProperty().equals(feature) || super.isAffectingEvent(event, flags);
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();

		if((element != null) && (element instanceof Property)) {
			Property semElement = (Property)element;

			semanticElementsBeingParsed.add(semElement);
			if(semElement.getType() != null) {
				semanticElementsBeingParsed.add(semElement.getType());
			}
			if(semElement.getLowerValue() != null) {
				semanticElementsBeingParsed.add(semElement.getLowerValue());
			}
			if(semElement.getUpperValue() != null) {
				semanticElementsBeingParsed.add(semElement.getUpperValue());
			}
			if(semElement.getDefaultValue() != null) {
				semanticElementsBeingParsed.add(semElement.getDefaultValue());
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>();
		masks.put(ILabelPreferenceConstants.DISP_VISIBILITY, "Visibility");
		masks.put(ILabelPreferenceConstants.DISP_DERIVE, "Is Derived");
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_TYPE, "Type");
		masks.put(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE, "Show <Undefined> type");
		masks.put(ILabelPreferenceConstants.DISP_MULTIPLICITY, "Multiplicity");
		masks.put(ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY, "Show default multiplicity");
		masks.put(ILabelPreferenceConstants.DISP_DEFAULT_VALUE, "Default Value");
		masks.put(ILabelPreferenceConstants.DISP_MODIFIERS, "Modifiers");
		return masks;
	}
}
