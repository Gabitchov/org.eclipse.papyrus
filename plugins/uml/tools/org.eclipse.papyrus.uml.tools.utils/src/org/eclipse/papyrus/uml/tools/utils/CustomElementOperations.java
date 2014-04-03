/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * Adapted code from UML
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.operations.ElementOperations;


public class CustomElementOperations extends ElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Applies the specified stereotype to this element.
	 * 
	 * @param element
	 *        The receiving '<em><b>Element</b></em>' model object.
	 * @param stereotype
	 *        The stereotype to apply.
	 *        <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static EObject applyStereotype(final Package nearestPackageAttachedToTheModel, Element element, Stereotype stereotype) {
		EClass definition = getDefinition(nearestPackageAttachedToTheModel, stereotype);

		if(definition == null || getExtension(element, stereotype) == null || element.getStereotypeApplication(stereotype) != null) {

			throw new IllegalArgumentException(String.valueOf(stereotype));
		}

		return applyStereotype(element, definition);
	}

	/**
	 * 
	 * @param parentElement
	 *        the parent of the element (required because the element is probably to yet attached to its parent
	 * @param element
	 *        the element on which we want apply a stereotype
	 * @param stereotype
	 *        the stereotype to apply
	 * @return
	 *         <code>true</code> if the stereotype can be applied on this element
	 */
	public static boolean isStereotypeApplicable(final Element parentElement, Element element, Stereotype stereotype) {
		return getDefinition(parentElement, stereotype) != null && getExtension(element, stereotype) != null;

	}

	/**
	 * 
	 * @param element
	 * @param stereotype
	 * @return
	 */
	protected static EClass getDefinition(Element element, Stereotype stereotype) {

		if(stereotype != null) {
			Profile profile = stereotype.getProfile();

			if(profile != null) {
				org.eclipse.uml2.uml.Package package_ = element.getNearestPackage();

				if(package_ != null) {
					ProfileApplication profileApplication = package_.getProfileApplication(profile, true);

					if(profileApplication != null) {
						ENamedElement appliedDefinition = profileApplication.getAppliedDefinition(stereotype);

						if(appliedDefinition instanceof EClass) {
							EClass eClass = (EClass)appliedDefinition;

							if(!eClass.isAbstract()) {
								return eClass;
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * 
	 * @param element
	 * @param definition
	 * @return
	 */
	protected static EObject applyStereotype(Element element, EClass definition) {
		return CustomUMLUtil.StereotypeApplicationHelper.INSTANCE.applyStereotype(element, definition);
	}

	/**
	 * Duplicated and adapted from UML ElementOperations
	 * 
	 * @param element
	 * @param package_
	 * @return
	 */
	public static EList<Stereotype> getApplicableStereotypes(Element element, final Package package_) {
		//		org.eclipse.uml2.uml.Package package_ = element.getNearestPackage();

		if(package_ != null) {
			EList<Stereotype> applicableStereotypes = new UniqueEList.FastCompare<Stereotype>();

			for(ProfileApplication profileApplication : package_.getAllProfileApplications()) {

				Profile appliedProfile = profileApplication.getAppliedProfile();

				if(appliedProfile != null) {

					for(Stereotype stereotype : appliedProfile.allApplicableStereotypes()) {

						ENamedElement appliedDefinition = profileApplication.getAppliedDefinition(stereotype);

						if(appliedDefinition instanceof EClass && !((EClass)appliedDefinition).isAbstract() && getExtension(element, stereotype) != null) {

							applicableStereotypes.add(stereotype);
						}
					}
				}
			}

			return ECollections.unmodifiableEList(applicableStereotypes);
		}

		return ECollections.emptyEList();
	}

}
