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

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * Semantic Parser for {@link Property} used as {@link Association} end.
 */
public class AssociationEndLabelParser extends PropertyLabelParser {

	/** The String format for displaying a {@link Property} label with modifiers */
	protected static final String ALT_MODIFIER_FORMAT = "{%s}%s";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {

		if(flags == 0) {
			return MaskedLabel;
		}

		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if((eObject != null) && (eObject instanceof Property)) {

			Property property = (Property)eObject;

			// manage visibility
			if((flags & ILabelPreferenceConstants.DISP_VISIBILITY) == ILabelPreferenceConstants.DISP_VISIBILITY) {
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
			if(((flags & ILabelPreferenceConstants.DISP_DERIVE) == ILabelPreferenceConstants.DISP_DERIVE) && (property.isDerived())) {
				result = String.format(DERIVED_FORMAT, result);
			}

			// manage name
			if(((flags & ILabelPreferenceConstants.DISP_NAME) == ILabelPreferenceConstants.DISP_NAME) && (property.isSetName())) {
				String name = property.getName();

				// If property is owned by Association (non navigable) only show the name when explicitly asked.

				if(((flags & ILabelPreferenceConstants.DISP_NON_NAVIGABLE_ROLE) == ILabelPreferenceConstants.DISP_NON_NAVIGABLE_ROLE) || !((property.getOwningAssociation() != null) && (property.getOwningAssociation().getOwnedEnds().contains(property)))) {

					result = String.format(NAME_FORMAT, result, name);
				}
			}

			// manage type
			if(((flags & ILabelPreferenceConstants.DISP_TYPE) == ILabelPreferenceConstants.DISP_TYPE)) {
				String type = "<Undefined>";
				if(property.getType() != null) {
					type = property.getType().getName();
				}

				// If type is undefined only show "<Undefined>" when explicitly asked.

				if(((flags & ILabelPreferenceConstants.DISP_UNDEFINED_TYPE) == ILabelPreferenceConstants.DISP_UNDEFINED_TYPE) || (!"<Undefined>".equals(type))) {

					result = String.format(TYPE_FORMAT, result, type);
				}
			}

			// manage multiplicity
			if(((flags & ILabelPreferenceConstants.DISP_MULTIPLICITY) == ILabelPreferenceConstants.DISP_MULTIPLICITY)) {

				// If multiplicity is [1] (SysML default), only show when explicitly asked.
				String lower = (property.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(property.getLowerValue()) : "1";
				String upper = (property.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(property.getUpperValue()) : "1";
				if(((flags & ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY) == ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY) || !("1".equals(lower) && "1".equals(upper))) {

					if(lower.equals(upper)) {
						result = String.format(MULTIPLICITY_FORMAT_ALT, result, lower, upper);
					} else {
						result = String.format(MULTIPLICITY_FORMAT, result, lower, upper);
					}
				}
			}

			// manage default value
			if(((flags & ILabelPreferenceConstants.DISP_DEFAULTVALUE) == ILabelPreferenceConstants.DISP_DEFAULTVALUE) && ((property.getDefaultValue() != null))) {
				ValueSpecification valueSpecification = property.getDefaultValue();
				if((valueSpecification instanceof InstanceValue && property.getType().equals(valueSpecification.getType())) || !(valueSpecification instanceof InstanceValue)) {
					result = String.format(DEFAULT_VALUE_FORMAT, result, ValueSpecificationUtil.getSpecificationValue(valueSpecification));
				}
			}

			// manage modifier
			if((flags & ILabelPreferenceConstants.DISP_MODIFIERS) == ILabelPreferenceConstants.DISP_MODIFIERS) {
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
					result = String.format(ALT_MODIFIER_FORMAT, sb.toString(), result);
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Integer, String> getMasks() {
		return Collections.emptyMap();
	}
}
