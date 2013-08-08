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
package org.eclipse.papyrus.uml.nattable.paste;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.operations.ElementOperations;


public class PapyrusElementOperations extends ElementOperations {

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

	protected static EObject applyStereotype(Element element, EClass definition) {
		return PasteUMLUtil.StereotypeApplicationHelper.INSTANCE.applyStereotype(element, definition);
	}

}
