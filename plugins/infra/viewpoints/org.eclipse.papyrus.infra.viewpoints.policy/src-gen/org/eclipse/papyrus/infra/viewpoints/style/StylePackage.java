/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.style;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.viewpoints.style.StyleFactory
 * @model kind="package"
 * @generated
 */
public interface StylePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "style";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/viewpoints/policy/style";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "style";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StylePackage eINSTANCE = org.eclipse.papyrus.infra.viewpoints.style.impl.StylePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.viewpoints.style.impl.PapyrusViewStyleImpl <em>Papyrus View Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.viewpoints.style.impl.PapyrusViewStyleImpl
	 * @see org.eclipse.papyrus.infra.viewpoints.style.impl.StylePackageImpl#getPapyrusViewStyle()
	 * @generated
	 */
	int PAPYRUS_VIEW_STYLE = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW_STYLE__OWNER = NotationPackage.STYLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW_STYLE__CONFIGURATION = NotationPackage.STYLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Papyrus View Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Papyrus View Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_VIEW_STYLE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle <em>Papyrus View Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus View Style</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle
	 * @generated
	 */
	EClass getPapyrusViewStyle();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle#getOwner()
	 * @see #getPapyrusViewStyle()
	 * @generated
	 */
	EReference getPapyrusViewStyle_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle#getConfiguration()
	 * @see #getPapyrusViewStyle()
	 * @generated
	 */
	EReference getPapyrusViewStyle_Configuration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StyleFactory getStyleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.viewpoints.style.impl.PapyrusViewStyleImpl <em>Papyrus View Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.viewpoints.style.impl.PapyrusViewStyleImpl
		 * @see org.eclipse.papyrus.infra.viewpoints.style.impl.StylePackageImpl#getPapyrusViewStyle()
		 * @generated
		 */
		EClass PAPYRUS_VIEW_STYLE = eINSTANCE.getPapyrusViewStyle();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW_STYLE__OWNER = eINSTANCE.getPapyrusViewStyle_Owner();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_VIEW_STYLE__CONFIGURATION = eINSTANCE.getPapyrusViewStyle_Configuration();

	}

} //StylePackage
