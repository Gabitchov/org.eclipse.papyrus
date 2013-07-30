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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific parser to manage association end multiplicity.
 * 
 * @author tlandre
 */
public class AssociationMultiplicityParser extends AbstractAssociationEndParser {

	/**
	 * Constructor
	 * 
	 * @param memberEndIndex
	 *        the position of the attribute end.
	 */
	public AssociationMultiplicityParser(int memberEndIndex) {
		super(memberEndIndex);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Property property = doAdapt(element);
		StringBuffer displayedString = new StringBuffer();
		if(property != null) {
			if(property.getLower() == property.getUpper()) {
				displayedString.append(property.getLower());
			} else {
				displayedString.append(validValue(property.getLower()));
				displayedString.append("...");
				displayedString.append(validValue(property.getUpper()));
			}
		}
		return displayedString.toString();
	}

	/**
	 * Convert the int to a valid String to display. If the value is -1, then it
	 * is converted to *
	 * 
	 * @param val
	 *        the int to convert to String
	 * @return the valid string
	 */
	private String validValue(int val) {
		return val == -1 ? "*" : String.valueOf(val);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {

		boolean isAffectingEvent = false;

		EStructuralFeature feature = getEStructuralFeature(event);

		if(UMLPackage.eINSTANCE.getMultiplicityElement_Lower().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_Lower().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(feature) || UMLPackage.eINSTANCE.getLiteralInteger_Value().equals(feature) || UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value().equals(feature)) {
			isAffectingEvent = true;
		}
		return isAffectingEvent;
	}

}
