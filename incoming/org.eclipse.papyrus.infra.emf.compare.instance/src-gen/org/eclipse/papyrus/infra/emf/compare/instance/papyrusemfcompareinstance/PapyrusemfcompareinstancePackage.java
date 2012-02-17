/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusemfcompareinstanceFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusemfcompareinstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrusemfcompareinstance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/EMFCompare/0.9.0/papyrusemfcompareinstance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "papyrusemfcompareinstance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusemfcompareinstancePackage eINSTANCE = org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusemfcompareinstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusEMFCompareInstanceImpl <em>Papyrus EMF Compare Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusEMFCompareInstanceImpl
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusemfcompareinstancePackageImpl#getPapyrusEMFCompareInstance()
	 * @generated
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE__LEFT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE__RIGHT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE__TYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Papyrus EMF Compare Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EMF_COMPARE_INSTANCE_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance <em>Papyrus EMF Compare Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus EMF Compare Instance</em>'.
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance
	 * @generated
	 */
	EClass getPapyrusEMFCompareInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getLeft()
	 * @see #getPapyrusEMFCompareInstance()
	 * @generated
	 */
	EReference getPapyrusEMFCompareInstance_Left();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getRight()
	 * @see #getPapyrusEMFCompareInstance()
	 * @generated
	 */
	EReference getPapyrusEMFCompareInstance_Right();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getType()
	 * @see #getPapyrusEMFCompareInstance()
	 * @generated
	 */
	EAttribute getPapyrusEMFCompareInstance_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance#getName()
	 * @see #getPapyrusEMFCompareInstance()
	 * @generated
	 */
	EAttribute getPapyrusEMFCompareInstance_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrusemfcompareinstanceFactory getPapyrusemfcompareinstanceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusEMFCompareInstanceImpl <em>Papyrus EMF Compare Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusEMFCompareInstanceImpl
		 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusemfcompareinstancePackageImpl#getPapyrusEMFCompareInstance()
		 * @generated
		 */
		EClass PAPYRUS_EMF_COMPARE_INSTANCE = eINSTANCE.getPapyrusEMFCompareInstance();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_EMF_COMPARE_INSTANCE__LEFT = eINSTANCE.getPapyrusEMFCompareInstance_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_EMF_COMPARE_INSTANCE__RIGHT = eINSTANCE.getPapyrusEMFCompareInstance_Right();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_EMF_COMPARE_INSTANCE__TYPE = eINSTANCE.getPapyrusEMFCompareInstance_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_EMF_COMPARE_INSTANCE__NAME = eINSTANCE.getPapyrusEMFCompareInstance_Name();

	}

} //PapyrusemfcompareinstancePackage
