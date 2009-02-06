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

package org.eclipse.papyrus.diagram.common.parser.association.end;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.papyrus.diagram.common.parser.ExternalToString;
import org.eclipse.papyrus.diagram.common.parser.property.PropertyToString;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class AssociationEndToString extends PropertyToString {

	private final boolean mySourceNotTarget;

	public AssociationEndToString(boolean sourceNotTarget) {
		mySourceNotTarget = sourceNotTarget;
	}

	@Override
	protected Property asProperty(EObject object) {
		return asProperty(object, mySourceNotTarget);
	}

	protected static Property asProperty(EObject object, boolean sourceNotTarget) {
		if (object instanceof Property) {
			return (Property) object;
		}
		if (false == object instanceof Association) {
			throw new IllegalStateException("I can not provide toString for:" + object);
		}
		Association association = (Association) object;
		if (!association.isBinary()) {
			throw new IllegalStateException("I can not provide toString for not binary association:" + object);
		}
		return AssociationEndConvention.getMemberEnd(association, sourceNotTarget);
	}

	/**
	 * NOTE: it DOES NOT extends enclosing AssociationEndToString
	 */
	public static class EDIT extends PropertyToString.EDIT {

		private final boolean myIsSource;

		public EDIT(boolean isSource) {
			myIsSource = isSource;
		}

		@Override
		protected void appendType(StringBuffer result, TypedElement typedElement) {
			// no types for association ends
			// thus, do nothing
		}

		@Override
		protected void appendDefault(StringBuffer result, Property property) {
			// no defaults for association ends
			// again, do nothing
		}

		@Override
		protected Property asProperty(EObject object) {
			return AssociationEndToString.asProperty(object, myIsSource);
		}
	}

	public static class ROLE_VIEW extends AssociationEndToString implements ExternalToString.WithReferences {

		public ROLE_VIEW(boolean sourceNotTarget) {
			super(sourceNotTarget);
		}

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getNamedElement_Visibility(), UMLPackage.eINSTANCE.getProperty_IsDerived(),
				UMLPackage.eINSTANCE.getNamedElement_Name(), });

		public String getToString(EObject object, int flags) {
			Property property = asProperty(object);
			StringBuffer result = new StringBuffer();
			appendVisibility(result, property);
			appendIsDerived(result, property);
			appendName(result, property);
			return result.toString();
		}

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}

		public List getAdditionalReferencedElements(EObject object) {
			Property property = asProperty(object);
			List result = new LinkedList();
			result.add(property);
			return result;
		}
	}

	public static class MULTIPLICITY_VIEW extends AssociationEndToString implements ExternalToString.WithReferences {

		public MULTIPLICITY_VIEW(boolean sourceNotTarget) {
			super(sourceNotTarget);
		}

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue(),
				UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue(), UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value(), UMLPackage.eINSTANCE.getLiteralInteger_Value(),
				UMLPackage.eINSTANCE.getLiteralString_Value(), });

		public String getToString(EObject object, int flags) {
			Property property = asProperty(object);
			StringBuffer result = new StringBuffer();
			appendMultiplicity(result, property);
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
			return result;
		}
	}

	public static class MODIFIERS_VIEW extends AssociationEndToString implements ExternalToString.WithReferences {

		public MODIFIERS_VIEW(boolean sourceNotTarget) {
			super(sourceNotTarget);
		}

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(),
				UMLPackage.eINSTANCE.getProperty_IsDerivedUnion(), UMLPackage.eINSTANCE.getProperty_SubsettedProperty(), UMLPackage.eINSTANCE.getRedefinableElement_RedefinedElement(),
				UMLPackage.eINSTANCE.getNamedElement_Name(), });

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}

		public String getToString(EObject object, int flags) {
			Property property = asProperty(object);
			StringBuffer result = new StringBuffer();
			appendPropertyModifiers(result, property);
			return result.toString();
		}

		public List getAdditionalReferencedElements(EObject object) {
			Property property = asProperty(object);
			List result = new LinkedList();
			result.add(property);
			result.addAll(property.getSubsettedProperties());
			result.addAll(property.getRedefinedElements());
			return result;
		}

	}
}
