/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmFactory
 * @model kind="package"
 * @generated
 */
public interface JdtmmPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jdtmm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///jdtmm.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jdtmm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JdtmmPackage eINSTANCE = org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodBodyImpl <em>JDT Method Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodBodyImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTMethodBody()
	 * @generated
	 */
	int JDT_METHOD_BODY = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD_BODY__OWNER = 0;

	/**
	 * The number of structural features of the '<em>JDT Method Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD_BODY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl <em>JDT Java Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTJavaElement()
	 * @generated
	 */
	int JDT_JAVA_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_ELEMENT__ELEMENT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_ELEMENT__ELEMENT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_ELEMENT__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_ELEMENT__GENERATED = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_ELEMENT__PARENT = 4;

	/**
	 * The number of structural features of the '<em>JDT Java Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentImpl <em>JDT Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTParent()
	 * @generated
	 */
	int JDT_PARENT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentJavaElementImpl <em>JDT Parent Java Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentJavaElementImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTParentJavaElement()
	 * @generated
	 */
	int JDT_PARENT_JAVA_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME = JDT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE = JDT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__COMMENT = JDT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__GENERATED = JDT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__PARENT = JDT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__CHILDREN = JDT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT__FLAGS = JDT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JDT Parent Java Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT = JDT_JAVA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl <em>JDT Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTMember()
	 * @generated
	 */
	int JDT_MEMBER = 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__TYPE_PARAMETERS = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__VISIBILITY = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>JDT Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_MEMBER_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeParameterImpl <em>JDT Type Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeParameterImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTTypeParameter()
	 * @generated
	 */
	int JDT_TYPE_PARAMETER = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl <em>JDT Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTField()
	 * @generated
	 */
	int JDT_FIELD = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl <em>JDT Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTType()
	 * @generated
	 */
	int JDT_TYPE = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl <em>JDT Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTMethod()
	 * @generated
	 */
	int JDT_METHOD = 1;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__ELEMENT_NAME = JDT_MEMBER__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__ELEMENT_TYPE = JDT_MEMBER__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__COMMENT = JDT_MEMBER__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__GENERATED = JDT_MEMBER__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__PARENT = JDT_MEMBER__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__CHILDREN = JDT_MEMBER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__FLAGS = JDT_MEMBER__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__TYPE_PARAMETERS = JDT_MEMBER__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__VISIBILITY = JDT_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__EXPLICIT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__OWNER = JDT_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__RETURN_TYPE = JDT_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__PARAMETERS = JDT_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__ABSTRACT = JDT_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__FINAL = JDT_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__STATIC = JDT_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Exceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__EXCEPTIONS = JDT_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__SYNCHRONIZED = JDT_MEMBER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__CONSTRUCTOR = JDT_MEMBER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD__BODIES = JDT_MEMBER_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>JDT Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_METHOD_FEATURE_COUNT = JDT_MEMBER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT__FLAGS = 1;

	/**
	 * The number of structural features of the '<em>JDT Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARENT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER__ELEMENT_NAME = JDT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER__ELEMENT_TYPE = JDT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER__COMMENT = JDT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER__GENERATED = JDT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER__PARENT = JDT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Declaring Member</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER__DECLARING_MEMBER = JDT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JDT Type Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_PARAMETER_FEATURE_COUNT = JDT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__ELEMENT_NAME = JDT_MEMBER__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__ELEMENT_TYPE = JDT_MEMBER__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__COMMENT = JDT_MEMBER__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__GENERATED = JDT_MEMBER__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__PARENT = JDT_MEMBER__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__CHILDREN = JDT_MEMBER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__FLAGS = JDT_MEMBER__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__TYPE_PARAMETERS = JDT_MEMBER__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__VISIBILITY = JDT_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__EXPLICIT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__METHODS = JDT_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__FIELDS = JDT_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__COMPILATION_UNIT = JDT_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__CLASS = JDT_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__INTERFACE = JDT_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__ENUM = JDT_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__ABSTRACT = JDT_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__FINAL = JDT_MEMBER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__STATIC = JDT_MEMBER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__TYPES = JDT_MEMBER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__OWNER = JDT_MEMBER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Super Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__SUPER_INTERFACES = JDT_MEMBER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__SUPER_CLASS = JDT_MEMBER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Super Interface Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__SUPER_INTERFACE_NAMES = JDT_MEMBER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE__SUPER_CLASS_NAME = JDT_MEMBER_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>JDT Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_FEATURE_COUNT = JDT_MEMBER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__ELEMENT_NAME = JDT_MEMBER__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__ELEMENT_TYPE = JDT_MEMBER__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__COMMENT = JDT_MEMBER__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__GENERATED = JDT_MEMBER__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__PARENT = JDT_MEMBER__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__CHILDREN = JDT_MEMBER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__FLAGS = JDT_MEMBER__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__TYPE_PARAMETERS = JDT_MEMBER__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__VISIBILITY = JDT_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__EXPLICIT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__ABSTRACT = JDT_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__FINAL = JDT_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__STATIC = JDT_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__IS_MULTI_VALUED = JDT_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__TYPE = JDT_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__VALUE = JDT_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Generate Getter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__GENERATE_GETTER = JDT_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Generate Setter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__GENERATE_SETTER = JDT_MEMBER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD__OWNER = JDT_MEMBER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>JDT Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_FIELD_FEATURE_COUNT = JDT_MEMBER_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTClassImpl <em>JDT Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTClassImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTClass()
	 * @generated
	 */
	int JDT_CLASS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTInterfaceImpl <em>JDT Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTInterfaceImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTInterface()
	 * @generated
	 */
	int JDT_INTERFACE = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTEnumImpl <em>JDT Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTEnumImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTEnum()
	 * @generated
	 */
	int JDT_ENUM = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeRootImpl <em>JDT Type Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeRootImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTTypeRoot()
	 * @generated
	 */
	int JDT_TYPE_ROOT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTCompilationUnitImpl <em>JDT Compilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTCompilationUnitImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTCompilationUnit()
	 * @generated
	 */
	int JDT_COMPILATION_UNIT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportDeclarationImpl <em>JDT Import Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportDeclarationImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTImportDeclaration()
	 * @generated
	 */
	int JDT_IMPORT_DECLARATION = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportContainerImpl <em>JDT Import Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportContainerImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTImportContainer()
	 * @generated
	 */
	int JDT_IMPORT_CONTAINER = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl <em>JDT Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTParameter()
	 * @generated
	 */
	int JDT_PARAMETER = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl <em>JDT Package Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTPackageFragment()
	 * @generated
	 */
	int JDT_PACKAGE_FRAGMENT = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl <em>JDT Package Fragment Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTPackageFragmentRoot()
	 * @generated
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl <em>JDT Java Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTJavaProject()
	 * @generated
	 */
	int JDT_JAVA_PROJECT = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaModelImpl <em>JDT Java Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaModelImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTJavaModel()
	 * @generated
	 */
	int JDT_JAVA_MODEL = 14;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The number of structural features of the '<em>JDT Type Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_TYPE_ROOT_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__ELEMENT_NAME = JDT_TYPE_ROOT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__ELEMENT_TYPE = JDT_TYPE_ROOT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__COMMENT = JDT_TYPE_ROOT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__GENERATED = JDT_TYPE_ROOT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__PARENT = JDT_TYPE_ROOT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__CHILDREN = JDT_TYPE_ROOT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__FLAGS = JDT_TYPE_ROOT__FLAGS;

	/**
	 * The feature id for the '<em><b>Package Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__PACKAGE_FRAGMENT = JDT_TYPE_ROOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT__TYPES = JDT_TYPE_ROOT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JDT Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_COMPILATION_UNIT_FEATURE_COUNT = JDT_TYPE_ROOT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The feature id for the '<em><b>Package Fragment Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Compilation Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JDT Package Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The feature id for the '<em><b>Java Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package Fragments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JDT Package Fragment Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PACKAGE_FRAGMENT_ROOT_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The feature id for the '<em><b>Java Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__JAVA_MODEL = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package Fragment Roots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JDT Java Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_PROJECT_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The feature id for the '<em><b>Java Project</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL__JAVA_PROJECT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JDT Java Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_JAVA_MODEL_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__ELEMENT_NAME = JDT_MEMBER__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__ELEMENT_TYPE = JDT_MEMBER__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__COMMENT = JDT_MEMBER__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__GENERATED = JDT_MEMBER__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__PARENT = JDT_MEMBER__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__CHILDREN = JDT_MEMBER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__FLAGS = JDT_MEMBER__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__TYPE_PARAMETERS = JDT_MEMBER__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__VISIBILITY = JDT_MEMBER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__EXPLICIT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Parameter Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__PARAMETER_OWNER = JDT_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__FINAL = JDT_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__IS_MULTI_VALUED = JDT_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__TYPE = JDT_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Return Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER__RETURN_OWNER = JDT_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>JDT Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_PARAMETER_FEATURE_COUNT = JDT_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__ELEMENT_NAME = JDT_TYPE__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__ELEMENT_TYPE = JDT_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__COMMENT = JDT_TYPE__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__GENERATED = JDT_TYPE__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__PARENT = JDT_TYPE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__CHILDREN = JDT_TYPE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__FLAGS = JDT_TYPE__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__TYPE_PARAMETERS = JDT_TYPE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__VISIBILITY = JDT_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__EXPLICIT_REQUIRED_IMPORTS = JDT_TYPE__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_TYPE__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__METHODS = JDT_TYPE__METHODS;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__FIELDS = JDT_TYPE__FIELDS;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__COMPILATION_UNIT = JDT_TYPE__COMPILATION_UNIT;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__CLASS = JDT_TYPE__CLASS;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__INTERFACE = JDT_TYPE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__ENUM = JDT_TYPE__ENUM;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__ABSTRACT = JDT_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__FINAL = JDT_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__STATIC = JDT_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__TYPES = JDT_TYPE__TYPES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__OWNER = JDT_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Super Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__SUPER_INTERFACES = JDT_TYPE__SUPER_INTERFACES;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__SUPER_CLASS = JDT_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Super Interface Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__SUPER_INTERFACE_NAMES = JDT_TYPE__SUPER_INTERFACE_NAMES;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS__SUPER_CLASS_NAME = JDT_TYPE__SUPER_CLASS_NAME;

	/**
	 * The number of structural features of the '<em>JDT Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_CLASS_FEATURE_COUNT = JDT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__ELEMENT_NAME = JDT_TYPE__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__ELEMENT_TYPE = JDT_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__COMMENT = JDT_TYPE__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__GENERATED = JDT_TYPE__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__PARENT = JDT_TYPE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__CHILDREN = JDT_TYPE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__FLAGS = JDT_TYPE__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__TYPE_PARAMETERS = JDT_TYPE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__VISIBILITY = JDT_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__EXPLICIT_REQUIRED_IMPORTS = JDT_TYPE__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_TYPE__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__METHODS = JDT_TYPE__METHODS;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__FIELDS = JDT_TYPE__FIELDS;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__COMPILATION_UNIT = JDT_TYPE__COMPILATION_UNIT;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__CLASS = JDT_TYPE__CLASS;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__INTERFACE = JDT_TYPE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__ENUM = JDT_TYPE__ENUM;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__ABSTRACT = JDT_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__FINAL = JDT_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__STATIC = JDT_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__TYPES = JDT_TYPE__TYPES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__OWNER = JDT_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Super Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__SUPER_INTERFACES = JDT_TYPE__SUPER_INTERFACES;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__SUPER_CLASS = JDT_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Super Interface Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__SUPER_INTERFACE_NAMES = JDT_TYPE__SUPER_INTERFACE_NAMES;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE__SUPER_CLASS_NAME = JDT_TYPE__SUPER_CLASS_NAME;

	/**
	 * The number of structural features of the '<em>JDT Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_INTERFACE_FEATURE_COUNT = JDT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__ELEMENT_NAME = JDT_TYPE__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__ELEMENT_TYPE = JDT_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__COMMENT = JDT_TYPE__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__GENERATED = JDT_TYPE__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__PARENT = JDT_TYPE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__CHILDREN = JDT_TYPE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__FLAGS = JDT_TYPE__FLAGS;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__TYPE_PARAMETERS = JDT_TYPE__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__VISIBILITY = JDT_TYPE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Explicit Required Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__EXPLICIT_REQUIRED_IMPORTS = JDT_TYPE__EXPLICIT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = JDT_TYPE__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__METHODS = JDT_TYPE__METHODS;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__FIELDS = JDT_TYPE__FIELDS;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__COMPILATION_UNIT = JDT_TYPE__COMPILATION_UNIT;

	/**
	 * The feature id for the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__CLASS = JDT_TYPE__CLASS;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__INTERFACE = JDT_TYPE__INTERFACE;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__ENUM = JDT_TYPE__ENUM;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__ABSTRACT = JDT_TYPE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__FINAL = JDT_TYPE__FINAL;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__STATIC = JDT_TYPE__STATIC;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__TYPES = JDT_TYPE__TYPES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__OWNER = JDT_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Super Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__SUPER_INTERFACES = JDT_TYPE__SUPER_INTERFACES;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__SUPER_CLASS = JDT_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Super Interface Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__SUPER_INTERFACE_NAMES = JDT_TYPE__SUPER_INTERFACE_NAMES;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM__SUPER_CLASS_NAME = JDT_TYPE__SUPER_CLASS_NAME;

	/**
	 * The number of structural features of the '<em>JDT Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_ENUM_FEATURE_COUNT = JDT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_DECLARATION__ELEMENT_NAME = JDT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_DECLARATION__ELEMENT_TYPE = JDT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_DECLARATION__COMMENT = JDT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_DECLARATION__GENERATED = JDT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_DECLARATION__PARENT = JDT_JAVA_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>JDT Import Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_DECLARATION_FEATURE_COUNT = JDT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__ELEMENT_NAME = JDT_PARENT_JAVA_ELEMENT__ELEMENT_NAME;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__ELEMENT_TYPE = JDT_PARENT_JAVA_ELEMENT__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__COMMENT = JDT_PARENT_JAVA_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__GENERATED = JDT_PARENT_JAVA_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__PARENT = JDT_PARENT_JAVA_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__CHILDREN = JDT_PARENT_JAVA_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER__FLAGS = JDT_PARENT_JAVA_ELEMENT__FLAGS;

	/**
	 * The number of structural features of the '<em>JDT Import Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_IMPORT_CONTAINER_FEATURE_COUNT = JDT_PARENT_JAVA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTExceptionImpl <em>JDT Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTExceptionImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTException()
	 * @generated
	 */
	int JDT_EXCEPTION = 21;

	/**
	 * The number of structural features of the '<em>JDT Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_EXCEPTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTOpaqueBodyImpl <em>JDT Opaque Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTOpaqueBodyImpl
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTOpaqueBody()
	 * @generated
	 */
	int JDT_OPAQUE_BODY = 22;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_OPAQUE_BODY__OWNER = JDT_METHOD_BODY__OWNER;

	/**
	 * The feature id for the '<em><b>body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_OPAQUE_BODY__BODY = JDT_METHOD_BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JDT Opaque Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JDT_OPAQUE_BODY_FEATURE_COUNT = JDT_METHOD_BODY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind <em>Visibility Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getVisibilityKind()
	 * @generated
	 */
	int VISIBILITY_KIND = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault <em>True False Default</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getTrueFalseDefault()
	 * @generated
	 */
	int TRUE_FALSE_DEFAULT = 24;

	/**
	 * The meta object id for the '<em>boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getboolean()
	 * @generated
	 */
	int BOOLEAN = 27;

	/**
	 * The meta object id for the '<em>int</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getint()
	 * @generated
	 */
	int INT = 26;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getString()
	 * @generated
	 */
	int STRING = 25;


	/**
	 * The meta object id for the '<em>JDT Visitor Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTVisitorException()
	 * @generated
	 */
	int JDT_VISITOR_EXCEPTION = 28;

	/**
	 * The meta object id for the '<em>Visitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getVisitor()
	 * @generated
	 */
	int VISITOR = 29;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethodBody <em>JDT Method Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Method Body</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethodBody
	 * @generated
	 */
	EClass getJDTMethodBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethodBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethodBody#getOwner()
	 * @see #getJDTMethodBody()
	 * @generated
	 */
	EReference getJDTMethodBody_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement <em>JDT Java Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Java Element</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement
	 * @generated
	 */
	EClass getJDTJavaElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent()
	 * @see #getJDTJavaElement()
	 * @generated
	 */
	EReference getJDTJavaElement_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getElementName <em>Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Name</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getElementName()
	 * @see #getJDTJavaElement()
	 * @generated
	 */
	EAttribute getJDTJavaElement_ElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Type</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getElementType()
	 * @see #getJDTJavaElement()
	 * @generated
	 */
	EAttribute getJDTJavaElement_ElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getComment()
	 * @see #getJDTJavaElement()
	 * @generated
	 */
	EAttribute getJDTJavaElement_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#isGenerated <em>Generated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generated</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#isGenerated()
	 * @see #getJDTJavaElement()
	 * @generated
	 */
	EAttribute getJDTJavaElement_Generated();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent <em>JDT Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Parent</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent
	 * @generated
	 */
	EClass getJDTParent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getFlags <em>Flags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flags</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getFlags()
	 * @see #getJDTParent()
	 * @generated
	 */
	EAttribute getJDTParent_Flags();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren()
	 * @see #getJDTParent()
	 * @generated
	 */
	EReference getJDTParent_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember <em>JDT Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Member</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember
	 * @generated
	 */
	EClass getJDTMember();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getTypeParameters()
	 * @see #getJDTMember()
	 * @generated
	 */
	EReference getJDTMember_TypeParameters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getVisibility()
	 * @see #getJDTMember()
	 * @generated
	 */
	EAttribute getJDTMember_Visibility();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getExplicitRequiredImports <em>Explicit Required Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Explicit Required Imports</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getExplicitRequiredImports()
	 * @see #getJDTMember()
	 * @generated
	 */
	EReference getJDTMember_ExplicitRequiredImports();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Explicit Plain Text Required Imports</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember#getExplicitPlainTextRequiredImports()
	 * @see #getJDTMember()
	 * @generated
	 */
	EAttribute getJDTMember_ExplicitPlainTextRequiredImports();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParentJavaElement <em>JDT Parent Java Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Parent Java Element</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParentJavaElement
	 * @generated
	 */
	EClass getJDTParentJavaElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter <em>JDT Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Type Parameter</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter
	 * @generated
	 */
	EClass getJDTTypeParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter#getDeclaringMember <em>Declaring Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Member</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter#getDeclaringMember()
	 * @see #getJDTTypeParameter()
	 * @generated
	 */
	EReference getJDTTypeParameter_DeclaringMember();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField <em>JDT Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Field</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField
	 * @generated
	 */
	EClass getJDTField();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getOwner()
	 * @see #getJDTField()
	 * @generated
	 */
	EReference getJDTField_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getType()
	 * @see #getJDTField()
	 * @generated
	 */
	EReference getJDTField_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getValue()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateGetter <em>Generate Getter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Getter</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateGetter()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_GenerateGetter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateSetter <em>Generate Setter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Setter</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#getGenerateSetter()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_GenerateSetter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isAbstract()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isFinal()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isStatic()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_Static();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isMultiValued <em>Is Multi Valued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Multi Valued</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField#isMultiValued()
	 * @see #getJDTField()
	 * @generated
	 */
	EAttribute getJDTField_IsMultiValued();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType <em>JDT Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Type</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType
	 * @generated
	 */
	EClass getJDTType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getMethods()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_Methods();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getCompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Compilation Unit</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getCompilationUnit()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_CompilationUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isClass()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isInterface()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_Interface();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enum</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isEnum()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_Enum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isAbstract()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isFinal()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#isStatic()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_Static();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getTypes()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_Types();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getOwner()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_Owner();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperInterfaces <em>Super Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Interfaces</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperInterfaces()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_SuperInterfaces();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Class</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClass()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_SuperClass();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperInterfaceNames <em>Super Interface Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Super Interface Names</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperInterfaceNames()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_SuperInterfaceNames();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClassName <em>Super Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Class Name</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getSuperClassName()
	 * @see #getJDTType()
	 * @generated
	 */
	EAttribute getJDTType_SuperClassName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType#getFields()
	 * @see #getJDTType()
	 * @generated
	 */
	EReference getJDTType_Fields();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod <em>JDT Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Method</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod
	 * @generated
	 */
	EClass getJDTMethod();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getReturnType()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EReference getJDTMethod_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getParameters()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EReference getJDTMethod_Parameters();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getExceptions <em>Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exceptions</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getExceptions()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EReference getJDTMethod_Exceptions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isSynchronized <em>Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synchronized</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isSynchronized()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EAttribute getJDTMethod_Synchronized();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constructor</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isConstructor()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EAttribute getJDTMethod_Constructor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getBodies <em>Bodies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bodies</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getBodies()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EReference getJDTMethod_Bodies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isAbstract()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EAttribute getJDTMethod_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isFinal()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EAttribute getJDTMethod_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#isStatic()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EAttribute getJDTMethod_Static();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod#getOwner()
	 * @see #getJDTMethod()
	 * @generated
	 */
	EReference getJDTMethod_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass <em>JDT Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Class</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTClass
	 * @generated
	 */
	EClass getJDTClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface <em>JDT Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Interface</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTInterface
	 * @generated
	 */
	EClass getJDTInterface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum <em>JDT Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Enum</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTEnum
	 * @generated
	 */
	EClass getJDTEnum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeRoot <em>JDT Type Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Type Root</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeRoot
	 * @generated
	 */
	EClass getJDTTypeRoot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit <em>JDT Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Compilation Unit</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit
	 * @generated
	 */
	EClass getJDTCompilationUnit();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit#getPackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package Fragment</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit#getPackageFragment()
	 * @see #getJDTCompilationUnit()
	 * @generated
	 */
	EReference getJDTCompilationUnit_PackageFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit#getTypes()
	 * @see #getJDTCompilationUnit()
	 * @generated
	 */
	EReference getJDTCompilationUnit_Types();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration <em>JDT Import Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Import Declaration</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportDeclaration
	 * @generated
	 */
	EClass getJDTImportDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer <em>JDT Import Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Import Container</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTImportContainer
	 * @generated
	 */
	EClass getJDTImportContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter <em>JDT Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Parameter</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter
	 * @generated
	 */
	EClass getJDTParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getParameterOwner <em>Parameter Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parameter Owner</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getParameterOwner()
	 * @see #getJDTParameter()
	 * @generated
	 */
	EReference getJDTParameter_ParameterOwner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isFinal()
	 * @see #getJDTParameter()
	 * @generated
	 */
	EAttribute getJDTParameter_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isMultiValued <em>Is Multi Valued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Multi Valued</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#isMultiValued()
	 * @see #getJDTParameter()
	 * @generated
	 */
	EAttribute getJDTParameter_IsMultiValued();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getType()
	 * @see #getJDTParameter()
	 * @generated
	 */
	EReference getJDTParameter_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getReturnOwner <em>Return Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Return Owner</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter#getReturnOwner()
	 * @see #getJDTParameter()
	 * @generated
	 */
	EReference getJDTParameter_ReturnOwner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException <em>JDT Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Exception</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTException
	 * @generated
	 */
	EClass getJDTException();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody <em>JDT Opaque Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Opaque Body</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody
	 * @generated
	 */
	EClass getJDTOpaqueBody();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody#get_body <em>body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>body</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody#get_body()
	 * @see #getJDTOpaqueBody()
	 * @generated
	 */
	EAttribute getJDTOpaqueBody__body();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind <em>Visibility Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility Kind</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind
	 * @generated
	 */
	EEnum getVisibilityKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault <em>True False Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>True False Default</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
	 * @generated
	 */
	EEnum getTrueFalseDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel <em>JDT Java Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Java Model</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel
	 * @generated
	 */
	EClass getJDTJavaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel#getJavaProject <em>Java Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Java Project</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel#getJavaProject()
	 * @see #getJDTJavaModel()
	 * @generated
	 */
	EReference getJDTJavaModel_JavaProject();

	/**
	 * Returns the meta object for data type '<em>boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>boolean</em>'.
	 * @model instanceClass="boolean"
	 * @generated
	 */
	EDataType getboolean();

	/**
	 * Returns the meta object for data type '<em>int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>int</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment <em>JDT Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Package Fragment</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment
	 * @generated
	 */
	EClass getJDTPackageFragment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment#getPackageFragmentRoot <em>Package Fragment Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package Fragment Root</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment#getPackageFragmentRoot()
	 * @see #getJDTPackageFragment()
	 * @generated
	 */
	EReference getJDTPackageFragment_PackageFragmentRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment#getCompilationUnits <em>Compilation Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compilation Units</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment#getCompilationUnits()
	 * @see #getJDTPackageFragment()
	 * @generated
	 */
	EReference getJDTPackageFragment_CompilationUnits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot <em>JDT Package Fragment Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Package Fragment Root</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot
	 * @generated
	 */
	EClass getJDTPackageFragmentRoot();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getJavaProject <em>Java Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Java Project</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getJavaProject()
	 * @see #getJDTPackageFragmentRoot()
	 * @generated
	 */
	EReference getJDTPackageFragmentRoot_JavaProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getPackageFragments <em>Package Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Fragments</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getPackageFragments()
	 * @see #getJDTPackageFragmentRoot()
	 * @generated
	 */
	EReference getJDTPackageFragmentRoot_PackageFragments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject <em>JDT Java Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JDT Java Project</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject
	 * @generated
	 */
	EClass getJDTJavaProject();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getJavaModel <em>Java Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Java Model</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getJavaModel()
	 * @see #getJDTJavaProject()
	 * @generated
	 */
	EReference getJDTJavaProject_JavaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getPackageFragmentRoots <em>Package Fragment Roots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Fragment Roots</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getPackageFragmentRoots()
	 * @see #getJDTJavaProject()
	 * @generated
	 */
	EReference getJDTJavaProject_PackageFragmentRoots();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException <em>JDT Visitor Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JDT Visitor Exception</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException
	 * @model instanceClass="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException"
	 * @generated
	 */
	EDataType getJDTVisitorException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Visitor</em>'.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor
	 * @model instanceClass="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor"
	 * @generated
	 */
	EDataType getVisitor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JdtmmFactory getJdtmmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodBodyImpl <em>JDT Method Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodBodyImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTMethodBody()
		 * @generated
		 */
		EClass JDT_METHOD_BODY = eINSTANCE.getJDTMethodBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_METHOD_BODY__OWNER = eINSTANCE.getJDTMethodBody_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl <em>JDT Java Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTJavaElement()
		 * @generated
		 */
		EClass JDT_JAVA_ELEMENT = eINSTANCE.getJDTJavaElement();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_JAVA_ELEMENT__PARENT = eINSTANCE.getJDTJavaElement_Parent();

		/**
		 * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_JAVA_ELEMENT__ELEMENT_NAME = eINSTANCE.getJDTJavaElement_ElementName();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_JAVA_ELEMENT__ELEMENT_TYPE = eINSTANCE.getJDTJavaElement_ElementType();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_JAVA_ELEMENT__COMMENT = eINSTANCE.getJDTJavaElement_Comment();

		/**
		 * The meta object literal for the '<em><b>Generated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_JAVA_ELEMENT__GENERATED = eINSTANCE.getJDTJavaElement_Generated();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentImpl <em>JDT Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTParent()
		 * @generated
		 */
		EClass JDT_PARENT = eINSTANCE.getJDTParent();

		/**
		 * The meta object literal for the '<em><b>Flags</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_PARENT__FLAGS = eINSTANCE.getJDTParent_Flags();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PARENT__CHILDREN = eINSTANCE.getJDTParent_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl <em>JDT Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMemberImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTMember()
		 * @generated
		 */
		EClass JDT_MEMBER = eINSTANCE.getJDTMember();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_MEMBER__TYPE_PARAMETERS = eINSTANCE.getJDTMember_TypeParameters();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_MEMBER__VISIBILITY = eINSTANCE.getJDTMember_Visibility();

		/**
		 * The meta object literal for the '<em><b>Explicit Required Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_MEMBER__EXPLICIT_REQUIRED_IMPORTS = eINSTANCE.getJDTMember_ExplicitRequiredImports();

		/**
		 * The meta object literal for the '<em><b>Explicit Plain Text Required Imports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_MEMBER__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS = eINSTANCE.getJDTMember_ExplicitPlainTextRequiredImports();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentJavaElementImpl <em>JDT Parent Java Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParentJavaElementImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTParentJavaElement()
		 * @generated
		 */
		EClass JDT_PARENT_JAVA_ELEMENT = eINSTANCE.getJDTParentJavaElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeParameterImpl <em>JDT Type Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeParameterImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTTypeParameter()
		 * @generated
		 */
		EClass JDT_TYPE_PARAMETER = eINSTANCE.getJDTTypeParameter();

		/**
		 * The meta object literal for the '<em><b>Declaring Member</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE_PARAMETER__DECLARING_MEMBER = eINSTANCE.getJDTTypeParameter_DeclaringMember();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl <em>JDT Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTField()
		 * @generated
		 */
		EClass JDT_FIELD = eINSTANCE.getJDTField();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_FIELD__OWNER = eINSTANCE.getJDTField_Owner();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_FIELD__TYPE = eINSTANCE.getJDTField_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__VALUE = eINSTANCE.getJDTField_Value();

		/**
		 * The meta object literal for the '<em><b>Generate Getter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__GENERATE_GETTER = eINSTANCE.getJDTField_GenerateGetter();

		/**
		 * The meta object literal for the '<em><b>Generate Setter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__GENERATE_SETTER = eINSTANCE.getJDTField_GenerateSetter();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__ABSTRACT = eINSTANCE.getJDTField_Abstract();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__FINAL = eINSTANCE.getJDTField_Final();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__STATIC = eINSTANCE.getJDTField_Static();

		/**
		 * The meta object literal for the '<em><b>Is Multi Valued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_FIELD__IS_MULTI_VALUED = eINSTANCE.getJDTField_IsMultiValued();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl <em>JDT Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTType()
		 * @generated
		 */
		EClass JDT_TYPE = eINSTANCE.getJDTType();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__METHODS = eINSTANCE.getJDTType_Methods();

		/**
		 * The meta object literal for the '<em><b>Compilation Unit</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__COMPILATION_UNIT = eINSTANCE.getJDTType_CompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__CLASS = eINSTANCE.getJDTType_Class();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__INTERFACE = eINSTANCE.getJDTType_Interface();

		/**
		 * The meta object literal for the '<em><b>Enum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__ENUM = eINSTANCE.getJDTType_Enum();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__ABSTRACT = eINSTANCE.getJDTType_Abstract();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__FINAL = eINSTANCE.getJDTType_Final();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__STATIC = eINSTANCE.getJDTType_Static();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__TYPES = eINSTANCE.getJDTType_Types();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__OWNER = eINSTANCE.getJDTType_Owner();

		/**
		 * The meta object literal for the '<em><b>Super Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__SUPER_INTERFACES = eINSTANCE.getJDTType_SuperInterfaces();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__SUPER_CLASS = eINSTANCE.getJDTType_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Super Interface Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__SUPER_INTERFACE_NAMES = eINSTANCE.getJDTType_SuperInterfaceNames();

		/**
		 * The meta object literal for the '<em><b>Super Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_TYPE__SUPER_CLASS_NAME = eINSTANCE.getJDTType_SuperClassName();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_TYPE__FIELDS = eINSTANCE.getJDTType_Fields();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl <em>JDT Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTMethod()
		 * @generated
		 */
		EClass JDT_METHOD = eINSTANCE.getJDTMethod();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_METHOD__RETURN_TYPE = eINSTANCE.getJDTMethod_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_METHOD__PARAMETERS = eINSTANCE.getJDTMethod_Parameters();

		/**
		 * The meta object literal for the '<em><b>Exceptions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_METHOD__EXCEPTIONS = eINSTANCE.getJDTMethod_Exceptions();

		/**
		 * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_METHOD__SYNCHRONIZED = eINSTANCE.getJDTMethod_Synchronized();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_METHOD__CONSTRUCTOR = eINSTANCE.getJDTMethod_Constructor();

		/**
		 * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_METHOD__BODIES = eINSTANCE.getJDTMethod_Bodies();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_METHOD__ABSTRACT = eINSTANCE.getJDTMethod_Abstract();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_METHOD__FINAL = eINSTANCE.getJDTMethod_Final();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_METHOD__STATIC = eINSTANCE.getJDTMethod_Static();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_METHOD__OWNER = eINSTANCE.getJDTMethod_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTClassImpl <em>JDT Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTClassImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTClass()
		 * @generated
		 */
		EClass JDT_CLASS = eINSTANCE.getJDTClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTInterfaceImpl <em>JDT Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTInterfaceImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTInterface()
		 * @generated
		 */
		EClass JDT_INTERFACE = eINSTANCE.getJDTInterface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTEnumImpl <em>JDT Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTEnumImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTEnum()
		 * @generated
		 */
		EClass JDT_ENUM = eINSTANCE.getJDTEnum();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeRootImpl <em>JDT Type Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeRootImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTTypeRoot()
		 * @generated
		 */
		EClass JDT_TYPE_ROOT = eINSTANCE.getJDTTypeRoot();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTCompilationUnitImpl <em>JDT Compilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTCompilationUnitImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTCompilationUnit()
		 * @generated
		 */
		EClass JDT_COMPILATION_UNIT = eINSTANCE.getJDTCompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Package Fragment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_COMPILATION_UNIT__PACKAGE_FRAGMENT = eINSTANCE.getJDTCompilationUnit_PackageFragment();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_COMPILATION_UNIT__TYPES = eINSTANCE.getJDTCompilationUnit_Types();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportDeclarationImpl <em>JDT Import Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportDeclarationImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTImportDeclaration()
		 * @generated
		 */
		EClass JDT_IMPORT_DECLARATION = eINSTANCE.getJDTImportDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportContainerImpl <em>JDT Import Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTImportContainerImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTImportContainer()
		 * @generated
		 */
		EClass JDT_IMPORT_CONTAINER = eINSTANCE.getJDTImportContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl <em>JDT Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTParameter()
		 * @generated
		 */
		EClass JDT_PARAMETER = eINSTANCE.getJDTParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PARAMETER__PARAMETER_OWNER = eINSTANCE.getJDTParameter_ParameterOwner();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_PARAMETER__FINAL = eINSTANCE.getJDTParameter_Final();

		/**
		 * The meta object literal for the '<em><b>Is Multi Valued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_PARAMETER__IS_MULTI_VALUED = eINSTANCE.getJDTParameter_IsMultiValued();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PARAMETER__TYPE = eINSTANCE.getJDTParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Return Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PARAMETER__RETURN_OWNER = eINSTANCE.getJDTParameter_ReturnOwner();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTExceptionImpl <em>JDT Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTExceptionImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTException()
		 * @generated
		 */
		EClass JDT_EXCEPTION = eINSTANCE.getJDTException();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTOpaqueBodyImpl <em>JDT Opaque Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTOpaqueBodyImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTOpaqueBody()
		 * @generated
		 */
		EClass JDT_OPAQUE_BODY = eINSTANCE.getJDTOpaqueBody();

		/**
		 * The meta object literal for the '<em><b>body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JDT_OPAQUE_BODY__BODY = eINSTANCE.getJDTOpaqueBody__body();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind <em>Visibility Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.VisibilityKind
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getVisibilityKind()
		 * @generated
		 */
		EEnum VISIBILITY_KIND = eINSTANCE.getVisibilityKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault <em>True False Default</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getTrueFalseDefault()
		 * @generated
		 */
		EEnum TRUE_FALSE_DEFAULT = eINSTANCE.getTrueFalseDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaModelImpl <em>JDT Java Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaModelImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTJavaModel()
		 * @generated
		 */
		EClass JDT_JAVA_MODEL = eINSTANCE.getJDTJavaModel();

		/**
		 * The meta object literal for the '<em><b>Java Project</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_JAVA_MODEL__JAVA_PROJECT = eINSTANCE.getJDTJavaModel_JavaProject();

		/**
		 * The meta object literal for the '<em>boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getboolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getboolean();

		/**
		 * The meta object literal for the '<em>int</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getint()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl <em>JDT Package Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTPackageFragment()
		 * @generated
		 */
		EClass JDT_PACKAGE_FRAGMENT = eINSTANCE.getJDTPackageFragment();

		/**
		 * The meta object literal for the '<em><b>Package Fragment Root</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PACKAGE_FRAGMENT__PACKAGE_FRAGMENT_ROOT = eINSTANCE.getJDTPackageFragment_PackageFragmentRoot();

		/**
		 * The meta object literal for the '<em><b>Compilation Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PACKAGE_FRAGMENT__COMPILATION_UNITS = eINSTANCE.getJDTPackageFragment_CompilationUnits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl <em>JDT Package Fragment Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTPackageFragmentRootImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTPackageFragmentRoot()
		 * @generated
		 */
		EClass JDT_PACKAGE_FRAGMENT_ROOT = eINSTANCE.getJDTPackageFragmentRoot();

		/**
		 * The meta object literal for the '<em><b>Java Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PACKAGE_FRAGMENT_ROOT__JAVA_PROJECT = eINSTANCE.getJDTPackageFragmentRoot_JavaProject();

		/**
		 * The meta object literal for the '<em><b>Package Fragments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_PACKAGE_FRAGMENT_ROOT__PACKAGE_FRAGMENTS = eINSTANCE.getJDTPackageFragmentRoot_PackageFragments();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl <em>JDT Java Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaProjectImpl
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTJavaProject()
		 * @generated
		 */
		EClass JDT_JAVA_PROJECT = eINSTANCE.getJDTJavaProject();

		/**
		 * The meta object literal for the '<em><b>Java Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_JAVA_PROJECT__JAVA_MODEL = eINSTANCE.getJDTJavaProject_JavaModel();

		/**
		 * The meta object literal for the '<em><b>Package Fragment Roots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JDT_JAVA_PROJECT__PACKAGE_FRAGMENT_ROOTS = eINSTANCE.getJDTJavaProject_PackageFragmentRoots();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>JDT Visitor Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getJDTVisitorException()
		 * @generated
		 */
		EDataType JDT_VISITOR_EXCEPTION = eINSTANCE.getJDTVisitorException();

		/**
		 * The meta object literal for the '<em>Visitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor
		 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmPackageImpl#getVisitor()
		 * @generated
		 */
		EDataType VISITOR = eINSTANCE.getVisitor();

	}

} //JdtmmPackage
