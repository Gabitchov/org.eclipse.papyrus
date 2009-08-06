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
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.parser.custom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A parser to handle the displayed role of an association end
 * 
 * @author tlandre
 */
public class AssociationEndParser implements IParser {

	private final int memberEndIndex;

	/**
	 * 
	 * @param index
	 */
	public AssociationEndParser(int memberEndIndex) {
		this.memberEndIndex = memberEndIndex;
	}

	/**
	 * Test if the model changed on one of the following property's attributes :
	 * <ul>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#NAMED_ELEMENT__NAME <em>Name</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__REDEFINED_PROPERTY <em>Redefined
	 * Property</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__SUBSETTED_PROPERTY <em>Ordered Property
	 * </em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_DERIVED <em>is Derived</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_DERIVED_UNION <em>is Derived Union
	 * </em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_ORDERED <em>is Ordered</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#PROPERTY__IS_UNIQUE <em>is Unique</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#NAMED_ELEMENT__VISIBILITY <em>Visibility</em>}</li>
	 * <li>{@link org.eclipse.uml2.uml.UMLPackage#STRUCTURAL_FEATURE__IS_READ_ONLY <em>is ReadOnly
	 * </em>}</li>
	 * </ul>
	 * 
	 * @param feature
	 *            the feature to test
	 * @return false if it is not a feature
	 */
	private boolean isModelChanged(EStructuralFeature feature) {
		boolean isModelChanged = false;
		if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_RedefinedProperty().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_SubsettedProperty().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_IsDerived().equals(feature)
				|| UMLPackage.eINSTANCE.getProperty_IsDerivedUnion().equals(feature)
				|| UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(feature)
				|| UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(feature)
				|| UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(feature)
				|| UMLPackage.eINSTANCE.getStructuralFeature_IsReadOnly().equals(feature)) {
			isModelChanged = true;
		}
		return isModelChanged;
	}

	/**
	 * Get the EStructuralFeature of the given notification
	 * 
	 * @param notification
	 *            the notification
	 * @return the EStructuralFeature
	 */
	private EStructuralFeature getEStructuralFeature(Object notification) {
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
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Property property = doAdapt(element);
		StringBuffer displayedString = new StringBuffer();
		if (property != null) {
			// Visibility of the property
			displayedString.append(NamedElementUtil.getVisibilityAsSign(property));
			// isDerived
			displayedString.append(PropertyUtil.getDerived(property));
			// name
			displayedString.append(property.getName());

			// modifiers
			displayedString.append(PropertyUtil.getModifiersAsString(property, false));
		}
		return displayedString.toString();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		EStructuralFeature feature = getEStructuralFeature(event);
		return isModelChanged(feature);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get the property associated with the given IAdaptable and the memberEndIndex .
	 * 
	 * @param element
	 *            the given IAdaptable
	 * @return the property associated or null if it can't be found.
	 */
	private Property doAdapt(IAdaptable element) {
		Object obj = element.getAdapter(EObject.class);
		Property property = null;
		if (obj instanceof Association) {
			Association association = (Association) obj;
			if (association.getMemberEnds() != null && association.getMemberEnds().size() > memberEndIndex)
				property = association.getMemberEnds().get(memberEndIndex);
		}
		return property;
	}
}
