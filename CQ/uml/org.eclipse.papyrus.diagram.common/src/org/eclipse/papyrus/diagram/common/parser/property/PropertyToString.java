/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser.property;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.details.DetailLevelParserOptions;
import org.eclipse.papyrus.diagram.common.parser.AbstractToString;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class PropertyToString extends AbstractToString {

	private static final Property DEFAULT_VALUES_PROTOTYPE = UMLFactory.eINSTANCE.createProperty();

	public static class EDIT extends PropertyToString {

		public String getToString(EObject object, int flags) {
			Property property = asProperty(object);
			StringBuffer result = new StringBuffer();
			appendVisibility(result, property);
			appendIsDerived(result, property);
			appendName(result, property);
			appendType(result, property);
			appendMultiplicity(result, property);
			appendDefault(result, property);
			appendPropertyModifiers(result, property);
			return result.toString();
		}

		public boolean isAffectingFeature(EStructuralFeature feature) {
			throw new UnsupportedOperationException("I am edit toString, I am not expected to be asked"); //$NON-NLS-1$
		}

	}

	public static class VIEW extends PropertyToString implements WithReferences {

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getNamedElement_Visibility(), UMLPackage.eINSTANCE.getProperty_IsDerived(),
				UMLPackage.eINSTANCE.getProperty_DefaultValue(), UMLPackage.eINSTANCE.getNamedElement_Name(), UMLPackage.eINSTANCE.getTypedElement_Type(),
				UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue(), UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue(), UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value(),
				UMLPackage.eINSTANCE.getLiteralInteger_Value(), UMLPackage.eINSTANCE.getLiteralString_Value(), });

		public String getToString(EObject object, int flags) {
			Property property = asProperty(object);
			StringBuffer result = new StringBuffer();
			switch (flags) {
			case DetailLevelParserOptions.LEVEL_ANALYSIS:
				appendName(result, property);
				appendType(result, property);
				break;
			default:
				appendVisibility(result, property);
				appendIsDerived(result, property);
				appendName(result, property);
				appendType(result, property);
				appendMultiplicity(result, property);
				appendDefault(result, property);
			}
			return result.toString();
		}

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}

		public List getAdditionalReferencedElements(EObject object) {
			Property property = asProperty(object);
			List result = new LinkedList();
			result.add(property);
			ValueSpecification upper = property.getUpperValue();
			if (upper != null) {
				result.add(upper);
			}
			ValueSpecification lower = property.getLowerValue();
			if (lower != null) {
				result.add(lower);
			}
			if (property.getType() != null) {
				result.add(property.getType());
			}
			return result;
		}

	}

	protected Property asProperty(EObject object) {
		if (false == object instanceof Property) {
			throw new IllegalStateException("I can not provide toString for: " + object); //$NON-NLS-1$
		}
		return (Property) object;
	}

	protected void appendPropertyModifiers(StringBuffer result, Property property) {
		ModifiersBuilder builder = new ModifiersBuilder();
		if (property.isReadOnly()) {
			builder.appendModifier("readOnly"); //$NON-NLS-1$
		}
		if (property.isDerivedUnion()) {
			builder.appendModifier("union"); //$NON-NLS-1$
		}
		if (property.isOrdered()) {
			builder.appendModifier("ordered"); //$NON-NLS-1$
		}
		if (property.isUnique() != DEFAULT_VALUES_PROTOTYPE.isUnique()) {
			builder.appendModifier(property.isUnique() ? "unique" : "nonunique"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		for (Iterator subsets = property.getSubsettedProperties().iterator(); subsets.hasNext();) {
			Property next = (Property) subsets.next();
			String nextName = next.getName();
			if (!isEmpty(nextName)) {
				builder.appendModifier("subsets " + nextName); //$NON-NLS-1$
			}
		}
		for (Iterator redefines = property.getRedefinedProperties().iterator(); redefines.hasNext();) {
			Property next = (Property) redefines.next();
			String nextName = next.getName();
			if (!isEmpty(nextName)) {
				builder.appendModifier("redefines " + nextName); //$NON-NLS-1$
			}
		}
		builder.writeInto(result);
	}

	protected void appendDefault(StringBuffer result, Property property) {
		String def = property.getDefault();
		if (isEmpty(def)) {
			return;
		}
		result.append(" = "); //$NON-NLS-1$
		result.append(def);
	}

	protected void appendVisibility(StringBuffer result, Property property) {
		result.append(getVisibility(property));
	}

	protected void appendIsDerived(StringBuffer result, Property property) {
		result.append(property.isDerived() ? "/" : ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
