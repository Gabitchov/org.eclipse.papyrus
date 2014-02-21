/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomFactoryImpl extends EFactoryImpl implements CustomFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CustomFactory init() {
		try {
			CustomFactory theCustomFactory = (CustomFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/facet/custom/0.2.incubation/custom"); 
			if (theCustomFactory != null) {
				return theCustomFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CustomFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CustomPackage.CUSTOMIZATION: return createCustomization();
			case CustomPackage.ECLASS_CUSTOMIZATION: return createEClassCustomization();
			case CustomPackage.FACET_CUSTOMIZATION: return createFacetCustomization();
			case CustomPackage.ETYPED_ELEMENT_SWITCH_QUERY: return createETypedElementSwitchQuery();
			case CustomPackage.ETYPED_ELEMENT_CASE: return createETypedElementCase();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customization createCustomization() {
		CustomizationImpl customization = new CustomizationImpl();
		return customization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassCustomization createEClassCustomization() {
		EClassCustomizationImpl eClassCustomization = new EClassCustomizationImpl();
		return eClassCustomization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetCustomization createFacetCustomization() {
		FacetCustomizationImpl facetCustomization = new FacetCustomizationImpl();
		return facetCustomization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypedElementSwitchQuery createETypedElementSwitchQuery() {
		ETypedElementSwitchQueryImpl eTypedElementSwitchQuery = new ETypedElementSwitchQueryImpl();
		return eTypedElementSwitchQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypedElementCase createETypedElementCase() {
		ETypedElementCaseImpl eTypedElementCase = new ETypedElementCaseImpl();
		return eTypedElementCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPackage getCustomPackage() {
		return (CustomPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CustomPackage getPackage() {
		return CustomPackage.eINSTANCE;
	}

} //CustomFactoryImpl
