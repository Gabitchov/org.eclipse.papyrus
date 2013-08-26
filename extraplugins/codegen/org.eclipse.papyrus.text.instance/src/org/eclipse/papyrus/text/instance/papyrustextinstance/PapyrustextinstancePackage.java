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
 */
package org.eclipse.papyrus.text.instance.papyrustextinstance;

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
 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstanceFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrustextinstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrustextinstance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/Example/0.9.0/papyrustextinstance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "papyrustextinstance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustextinstancePackage eINSTANCE = org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrustextinstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl <em>Papyrus Text Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrustextinstancePackageImpl#getPapyrusTextInstance()
	 * @generated
	 */
	int PAPYRUS_TEXT_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TEXT_INSTANCE__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Edited Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TEXT_INSTANCE__TYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TEXT_INSTANCE__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Papyrus Text Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TEXT_INSTANCE_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance <em>Papyrus Text Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Text Instance</em>'.
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance
	 * @generated
	 */
	EClass getPapyrusTextInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance#getEditedObject <em>Edited Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edited Object</em>'.
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance#getEditedObject()
	 * @see #getPapyrusTextInstance()
	 * @generated
	 */
	EReference getPapyrusTextInstance_EditedObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance#getType()
	 * @see #getPapyrusTextInstance()
	 * @generated
	 */
	EAttribute getPapyrusTextInstance_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance#getName()
	 * @see #getPapyrusTextInstance()
	 * @generated
	 */
	EAttribute getPapyrusTextInstance_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrustextinstanceFactory getPapyrustextinstanceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl <em>Papyrus Text Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl
		 * @see org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrustextinstancePackageImpl#getPapyrusTextInstance()
		 * @generated
		 */
		EClass PAPYRUS_TEXT_INSTANCE = eINSTANCE.getPapyrusTextInstance();

		/**
		 * The meta object literal for the '<em><b>Edited Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT = eINSTANCE.getPapyrusTextInstance_EditedObject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TEXT_INSTANCE__TYPE = eINSTANCE.getPapyrusTextInstance_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TEXT_INSTANCE__NAME = eINSTANCE.getPapyrusTextInstance_Name();

	}

} //PapyrustextinstancePackage
