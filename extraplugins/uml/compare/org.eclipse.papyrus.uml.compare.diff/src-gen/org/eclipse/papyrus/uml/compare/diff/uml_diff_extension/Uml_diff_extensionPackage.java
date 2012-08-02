/**
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.compare.diff.uml_diff_extension;

import org.eclipse.emf.compare.diff.metamodel.DiffPackage;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionFactory
 * @model kind="package"
 * @generated
 */
public interface Uml_diff_extensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uml_diff_extension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/uml/compare/diff_ext/0.9";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uml_diff_extension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Uml_diff_extensionPackage eINSTANCE = org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.UMLDiffExtensionImpl <em>UML Diff Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.UMLDiffExtensionImpl
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl#getUMLDiffExtension()
	 * @generated
	 */
	int UML_DIFF_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DIFF_EXTENSION__HIDE_ELEMENTS = DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DIFF_EXTENSION__IS_COLLAPSED = DiffPackage.ABSTRACT_DIFF_EXTENSION__IS_COLLAPSED;

	/**
	 * The number of structural features of the '<em>UML Diff Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DIFF_EXTENSION_FEATURE_COUNT = DiffPackage.ABSTRACT_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl <em>Generalization Target Changed Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl#getGeneralizationTargetChangedExtension()
	 * @generated
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__HIDE_ELEMENTS = UML_DIFF_EXTENSION__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_COLLAPSED = UML_DIFF_EXTENSION__IS_COLLAPSED;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY = UML_DIFF_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__CONFLICTING = UML_DIFF_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__KIND = UML_DIFF_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE = UML_DIFF_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES = UML_DIFF_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY = UML_DIFF_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE = UML_DIFF_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT = UML_DIFF_EXTENSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT = UML_DIFF_EXTENSION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Left Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET = UML_DIFF_EXTENSION_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Right Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET = UML_DIFF_EXTENSION_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Generalization Target Changed Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_TARGET_CHANGED_EXTENSION_FEATURE_COUNT = UML_DIFF_EXTENSION_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationSourceChangedExtensionImpl <em>Generalization Source Changed Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationSourceChangedExtensionImpl
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl#getGeneralizationSourceChangedExtension()
	 * @generated
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__HIDE_ELEMENTS = UML_DIFF_EXTENSION__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__IS_COLLAPSED = UML_DIFF_EXTENSION__IS_COLLAPSED;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__IS_HIDDEN_BY = UML_DIFF_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__CONFLICTING = UML_DIFF_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__KIND = UML_DIFF_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__REMOTE = UML_DIFF_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__REQUIRES = UML_DIFF_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__REQUIRED_BY = UML_DIFF_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__RIGHT_ELEMENT = UML_DIFF_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__LEFT_ELEMENT = UML_DIFF_EXTENSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Left Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__LEFT_TARGET = UML_DIFF_EXTENSION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Right Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION__RIGHT_TARGET = UML_DIFF_EXTENSION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Generalization Source Changed Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SOURCE_CHANGED_EXTENSION_FEATURE_COUNT = UML_DIFF_EXTENSION_FEATURE_COUNT + 11;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension <em>Generalization Target Changed Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization Target Changed Extension</em>'.
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension
	 * @generated
	 */
	EClass getGeneralizationTargetChangedExtension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationSourceChangedExtension <em>Generalization Source Changed Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization Source Changed Extension</em>'.
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationSourceChangedExtension
	 * @generated
	 */
	EClass getGeneralizationSourceChangedExtension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.UMLDiffExtension <em>UML Diff Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Diff Extension</em>'.
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.UMLDiffExtension
	 * @generated
	 */
	EClass getUMLDiffExtension();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Uml_diff_extensionFactory getUml_diff_extensionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl <em>Generalization Target Changed Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl
		 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl#getGeneralizationTargetChangedExtension()
		 * @generated
		 */
		EClass GENERALIZATION_TARGET_CHANGED_EXTENSION = eINSTANCE.getGeneralizationTargetChangedExtension();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationSourceChangedExtensionImpl <em>Generalization Source Changed Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationSourceChangedExtensionImpl
		 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl#getGeneralizationSourceChangedExtension()
		 * @generated
		 */
		EClass GENERALIZATION_SOURCE_CHANGED_EXTENSION = eINSTANCE.getGeneralizationSourceChangedExtension();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.UMLDiffExtensionImpl <em>UML Diff Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.UMLDiffExtensionImpl
		 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.Uml_diff_extensionPackageImpl#getUMLDiffExtension()
		 * @generated
		 */
		EClass UML_DIFF_EXTENSION = eINSTANCE.getUMLDiffExtension();

	}

} //Uml_diff_extensionPackage
