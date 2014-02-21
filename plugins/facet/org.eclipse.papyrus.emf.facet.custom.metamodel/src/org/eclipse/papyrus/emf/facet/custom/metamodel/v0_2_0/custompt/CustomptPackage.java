/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *  
 *  
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.CustomptFactory
 * @model kind="package"
 * @generated
 */
public interface CustomptPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "custompt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/facet/custom/0.2.incubation/custom_primitive_types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "custompt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomptPackage eINSTANCE = org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow <em>Shadow</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getShadow()
	 * @generated
	 */
	int SHADOW = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment <em>Alignment</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getAlignment()
	 * @generated
	 */
	int ALIGNMENT = 1;

	/**
	 * The meta object id for the '<em>Image</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 2;

	/**
	 * The meta object id for the '<em>Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 3;

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow <em>Shadow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Shadow</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow
	 * @generated
	 */
	EEnum getShadow();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Alignment</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment
	 * @generated
	 */
	EEnum getAlignment();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage
	 * @model instanceClass="org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage"
	 * @generated
	 */
	EDataType getImage();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Color</em>'.
	 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor
	 * @model instanceClass="org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor"
	 * @generated
	 */
	EDataType getColor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CustomptFactory getCustomptFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow <em>Shadow</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getShadow()
		 * @generated
		 */
		EEnum SHADOW = eINSTANCE.getShadow();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment <em>Alignment</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getAlignment()
		 * @generated
		 */
		EEnum ALIGNMENT = eINSTANCE.getAlignment();

		/**
		 * The meta object literal for the '<em>Image</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getImage()
		 * @generated
		 */
		EDataType IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em>Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor
		 * @see org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custompt.impl.CustomptPackageImpl#getColor()
		 * @generated
		 */
		EDataType COLOR = eINSTANCE.getColor();

	}

} //CustomptPackage
