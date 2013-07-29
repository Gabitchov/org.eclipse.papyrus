/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 ****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.PropertyUtil;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A parser to handle the displayed role of an association end
 * 
 * @author tlandre
 */
public class AssociationEndParser extends AbstractAssociationEndParser {

	/**
	 * 
	 * @param index
	 */
	public AssociationEndParser(int memberEndIndex) {
		super(memberEndIndex);
	}

	/**
	 * Test if the model changed on one of the following property's attributes :
	 * <ul>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#NAMED_ELEMENT__NAME <em>Name </em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__REDEFINED_PROPERTY
	 * <em>Redefined Property</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__SUBSETTED_PROPERTY
	 * <em>Ordered Property </em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_DERIVED <em>is Derived</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_DERIVED_UNION
	 * <em>is Derived Union </em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_ORDERED <em>is Ordered</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_UNIQUE <em>is Unique</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#NAMED_ELEMENT__VISIBILITY <em> Visibility</em>}</li>
	 * <li>
	 * {@link org.eclipse.uml2.uml.UMLPackage#STRUCTURAL_FEATURE__IS_READ_ONLY
	 * <em>is ReadOnly </em>}</li>
	 * </ul> {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);

		boolean isAffectingEvent = false;
		if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getProperty_RedefinedProperty().equals(feature) || UMLPackage.eINSTANCE.getProperty_SubsettedProperty().equals(feature) || UMLPackage.eINSTANCE.getProperty_IsDerived().equals(feature) || UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(feature) || UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(feature) || UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().equals(feature)) {
			isAffectingEvent = true;
		}
		return isAffectingEvent;

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Property property = doAdapt(element);
		StringBuffer displayedString = new StringBuffer();
		if(property != null) {
			// Visibility of the property
			displayedString.append(NamedElementUtil.getVisibilityAsSign(property));
			// isDerived
			displayedString.append(PropertyUtil.getDerived(property));
			// name
			if(property.getName() != null) {
				displayedString.append(property.getName());
			}

			// modifiers
			displayedString.append(PropertyUtil.getModifiersAsString(property, false));
		}
		return displayedString.toString();
	}

}
