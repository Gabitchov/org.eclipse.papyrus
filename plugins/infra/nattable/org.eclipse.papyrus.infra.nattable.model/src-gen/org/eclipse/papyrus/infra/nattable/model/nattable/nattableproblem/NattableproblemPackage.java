/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemFactory
 * @model kind="package"
 * @generated
 */
public interface NattableproblemPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "nattableproblem"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattableproblem"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "nattableproblem"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	NattableproblemPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.ProblemImpl <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.ProblemImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBLEM__EANNOTATIONS = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBLEM__DESCRIPTION = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBLEM__NAME = NattableconfigurationPackage.TABLE_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBLEM___GET_EANNOTATION__STRING = NattableconfigurationPackage.TABLE_NAMED_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBLEM_OPERATION_COUNT = NattableconfigurationPackage.TABLE_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.StringResolutionProblemImpl
	 * <em>String Resolution Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.StringResolutionProblemImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl#getStringResolutionProblem()
	 * @generated
	 */
	int STRING_RESOLUTION_PROBLEM = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM__EANNOTATIONS = PROBLEM__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM__DESCRIPTION = PROBLEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM__NAME = PROBLEM__NAME;

	/**
	 * The feature id for the '<em><b>Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING = PROBLEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unresolved String</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING = PROBLEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>String Resolution Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM_FEATURE_COUNT = PROBLEM_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM___GET_EANNOTATION__STRING = PROBLEM___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>String Resolution Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_RESOLUTION_PROBLEM_OPERATION_COUNT = PROBLEM_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem
	 * <em>String Resolution Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String Resolution Problem</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem
	 * @generated
	 */
	EClass getStringResolutionProblem();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getValueAsString <em>Value As String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value As String</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getValueAsString()
	 * @see #getStringResolutionProblem()
	 * @generated
	 */
	EAttribute getStringResolutionProblem_ValueAsString();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getUnresolvedString
	 * <em>Unresolved String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Unresolved String</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getUnresolvedString()
	 * @see #getStringResolutionProblem()
	 * @generated
	 */
	EAttribute getStringResolutionProblem_UnresolvedString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableproblemFactory getNattableproblemFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.ProblemImpl
		 * <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.ProblemImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.StringResolutionProblemImpl
		 * <em>String Resolution Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.StringResolutionProblemImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl#getStringResolutionProblem()
		 * @generated
		 */
		EClass STRING_RESOLUTION_PROBLEM = eINSTANCE.getStringResolutionProblem();

		/**
		 * The meta object literal for the '<em><b>Value As String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_RESOLUTION_PROBLEM__VALUE_AS_STRING = eINSTANCE.getStringResolutionProblem_ValueAsString();

		/**
		 * The meta object literal for the '<em><b>Unresolved String</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_RESOLUTION_PROBLEM__UNRESOLVED_STRING = eINSTANCE.getStringResolutionProblem_UnresolvedString();

	}

} //NattableproblemPackage
