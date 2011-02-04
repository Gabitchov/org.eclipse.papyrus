/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension;

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
 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory
 * @model kind="package"
 * @generated
 */
public interface UMLDiffPackage extends EPackage {
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
	String eNS_URI = "http://www.eclipse.org/uml/compare/diff_ext/1.0";

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
	UMLDiffPackage eINSTANCE = org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffExtensionImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getUMLDiffExtension()
	 * @generated
	 */
	int UML_DIFF_EXTENSION = 0;

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
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_DIFF_EXTENSION_FEATURE_COUNT = DiffPackage.ABSTRACT_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.StereotypeChangeImpl <em>Stereotype Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.StereotypeChangeImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getStereotypeChange()
	 * @generated
	 */
	int STEREOTYPE_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CHANGE__HIDE_ELEMENTS = UML_DIFF_EXTENSION__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CHANGE__IS_COLLAPSED = UML_DIFF_EXTENSION__IS_COLLAPSED;

	/**
	 * The number of structural features of the '<em>Stereotype Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_CHANGE_FEATURE_COUNT = UML_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl <em>Tagged Value Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueChange()
	 * @generated
	 */
	int TAGGED_VALUE_CHANGE = 2;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS = DiffPackage.ATTRIBUTE_CHANGE__SUB_DIFF_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__IS_HIDDEN_BY = DiffPackage.ATTRIBUTE_CHANGE__IS_HIDDEN_BY;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__CONFLICTING = DiffPackage.ATTRIBUTE_CHANGE__CONFLICTING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__KIND = DiffPackage.ATTRIBUTE_CHANGE__KIND;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__REMOTE = DiffPackage.ATTRIBUTE_CHANGE__REMOTE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__ATTRIBUTE = DiffPackage.ATTRIBUTE_CHANGE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__LEFT_ELEMENT = DiffPackage.ATTRIBUTE_CHANGE__LEFT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__RIGHT_ELEMENT = DiffPackage.ATTRIBUTE_CHANGE__RIGHT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__HIDE_ELEMENTS = DiffPackage.ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE__IS_COLLAPSED = DiffPackage.ATTRIBUTE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tagged Value Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_FEATURE_COUNT = DiffPackage.ATTRIBUTE_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeLeftTargetImpl <em>Tagged Value Change Left Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeLeftTargetImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueChangeLeftTarget()
	 * @generated
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET = 3;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__SUB_DIFF_ELEMENTS = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__SUB_DIFF_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__IS_HIDDEN_BY = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__IS_HIDDEN_BY;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__CONFLICTING = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__CONFLICTING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__KIND = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__KIND;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__REMOTE = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__REMOTE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__ATTRIBUTE = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__LEFT_ELEMENT = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__LEFT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__RIGHT_ELEMENT = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__RIGHT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Left Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__LEFT_TARGET = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET__LEFT_TARGET;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__HIDE_ELEMENTS = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET__IS_COLLAPSED = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tagged Value Change Left Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_LEFT_TARGET_FEATURE_COUNT = DiffPackage.ATTRIBUTE_CHANGE_LEFT_TARGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeRightTargetImpl <em>Tagged Value Change Right Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeRightTargetImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueChangeRightTarget()
	 * @generated
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET = 4;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__SUB_DIFF_ELEMENTS = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__SUB_DIFF_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__IS_HIDDEN_BY = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__IS_HIDDEN_BY;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__CONFLICTING = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__CONFLICTING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__KIND = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__KIND;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__REMOTE = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__REMOTE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__ATTRIBUTE = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__LEFT_ELEMENT = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__LEFT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_ELEMENT = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__RIGHT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Right Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__RIGHT_TARGET;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__HIDE_ELEMENTS = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET__IS_COLLAPSED = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tagged Value Change Right Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_CHANGE_RIGHT_TARGET_FEATURE_COUNT = DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UpdateTaggedValueImpl <em>Update Tagged Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UpdateTaggedValueImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getUpdateTaggedValue()
	 * @generated
	 */
	int UPDATE_TAGGED_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__SUB_DIFF_ELEMENTS = DiffPackage.UPDATE_ATTRIBUTE__SUB_DIFF_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__IS_HIDDEN_BY = DiffPackage.UPDATE_ATTRIBUTE__IS_HIDDEN_BY;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__CONFLICTING = DiffPackage.UPDATE_ATTRIBUTE__CONFLICTING;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__KIND = DiffPackage.UPDATE_ATTRIBUTE__KIND;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__REMOTE = DiffPackage.UPDATE_ATTRIBUTE__REMOTE;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__ATTRIBUTE = DiffPackage.UPDATE_ATTRIBUTE__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__LEFT_ELEMENT = DiffPackage.UPDATE_ATTRIBUTE__LEFT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__RIGHT_ELEMENT = DiffPackage.UPDATE_ATTRIBUTE__RIGHT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__HIDE_ELEMENTS = DiffPackage.UPDATE_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE__IS_COLLAPSED = DiffPackage.UPDATE_ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Update Tagged Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_TAGGED_VALUE_FEATURE_COUNT = DiffPackage.UPDATE_ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl <em>Add Stereotype Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getAddStereotypeApplication()
	 * @generated
	 */
	int ADD_STEREOTYPE_APPLICATION = 6;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__HIDE_ELEMENTS = STEREOTYPE_CHANGE__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__IS_COLLAPSED = STEREOTYPE_CHANGE__IS_COLLAPSED;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS = STEREOTYPE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY = STEREOTYPE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__CONFLICTING = STEREOTYPE_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__KIND = STEREOTYPE_CHANGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__REMOTE = STEREOTYPE_CHANGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Left Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__LEFT_PARENT = STEREOTYPE_CHANGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT = STEREOTYPE_CHANGE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Add Stereotype Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STEREOTYPE_APPLICATION_FEATURE_COUNT = STEREOTYPE_CHANGE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.RemoveStereotypeApplicationImpl <em>Remove Stereotype Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.RemoveStereotypeApplicationImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getRemoveStereotypeApplication()
	 * @generated
	 */
	int REMOVE_STEREOTYPE_APPLICATION = 7;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__HIDE_ELEMENTS = STEREOTYPE_CHANGE__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__IS_COLLAPSED = STEREOTYPE_CHANGE__IS_COLLAPSED;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS = STEREOTYPE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__IS_HIDDEN_BY = STEREOTYPE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__CONFLICTING = STEREOTYPE_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__KIND = STEREOTYPE_CHANGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__REMOTE = STEREOTYPE_CHANGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Right Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__RIGHT_PARENT = STEREOTYPE_CHANGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION__LEFT_ELEMENT = STEREOTYPE_CHANGE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Remove Stereotype Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_STEREOTYPE_APPLICATION_FEATURE_COUNT = STEREOTYPE_CHANGE_FEATURE_COUNT + 7;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl <em>Tagged Value Reference Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueReferenceChange()
	 * @generated
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE = 8;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__HIDE_ELEMENTS = UML_DIFF_EXTENSION__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__IS_COLLAPSED = UML_DIFF_EXTENSION__IS_COLLAPSED;

	/**
	 * The feature id for the '<em><b>Sub Diff Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Hidden By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY = UML_DIFF_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__CONFLICTING = UML_DIFF_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__KIND = UML_DIFF_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Remote</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__REMOTE = UML_DIFF_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE = UML_DIFF_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Right Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT = UML_DIFF_EXTENSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Left Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT = UML_DIFF_EXTENSION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Tagged Value Reference Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAGGED_VALUE_REFERENCE_CHANGE_FEATURE_COUNT = UML_DIFF_EXTENSION_FEATURE_COUNT + 8;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl <em>Compare Two Elements Diff Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getCompareTwoElementsDiffModel()
	 * @generated
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL = 9;

	/**
	 * The feature id for the '<em><b>Hide Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL__HIDE_ELEMENTS = UML_DIFF_EXTENSION__HIDE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Is Collapsed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL__IS_COLLAPSED = UML_DIFF_EXTENSION__IS_COLLAPSED;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Roots</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Roots</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ancestor Roots</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS = UML_DIFF_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Compare Two Elements Diff Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_TWO_ELEMENTS_DIFF_MODEL_FEATURE_COUNT = UML_DIFF_EXTENSION_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension
	 * @generated
	 */
	EClass getUMLDiffExtension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.StereotypeChange <em>Stereotype Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotype Change</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.StereotypeChange
	 * @generated
	 */
	EClass getStereotypeChange();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange <em>Tagged Value Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Value Change</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange
	 * @generated
	 */
	EClass getTaggedValueChange();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeLeftTarget <em>Tagged Value Change Left Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Value Change Left Target</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeLeftTarget
	 * @generated
	 */
	EClass getTaggedValueChangeLeftTarget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget <em>Tagged Value Change Right Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Value Change Right Target</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget
	 * @generated
	 */
	EClass getTaggedValueChangeRightTarget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue <em>Update Tagged Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Tagged Value</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue
	 * @generated
	 */
	EClass getUpdateTaggedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication <em>Add Stereotype Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Stereotype Application</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication
	 * @generated
	 */
	EClass getAddStereotypeApplication();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.RemoveStereotypeApplication <em>Remove Stereotype Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Stereotype Application</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.RemoveStereotypeApplication
	 * @generated
	 */
	EClass getRemoveStereotypeApplication();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange <em>Tagged Value Reference Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Value Reference Change</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange
	 * @generated
	 */
	EClass getTaggedValueReferenceChange();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel <em>Compare Two Elements Diff Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Two Elements Diff Model</em>'.
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel
	 * @generated
	 */
	EClass getCompareTwoElementsDiffModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UMLDiffFactory getUMLDiffFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffExtensionImpl <em>Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffExtensionImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getUMLDiffExtension()
		 * @generated
		 */
		EClass UML_DIFF_EXTENSION = eINSTANCE.getUMLDiffExtension();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.StereotypeChangeImpl <em>Stereotype Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.StereotypeChangeImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getStereotypeChange()
		 * @generated
		 */
		EClass STEREOTYPE_CHANGE = eINSTANCE.getStereotypeChange();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl <em>Tagged Value Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueChange()
		 * @generated
		 */
		EClass TAGGED_VALUE_CHANGE = eINSTANCE.getTaggedValueChange();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeLeftTargetImpl <em>Tagged Value Change Left Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeLeftTargetImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueChangeLeftTarget()
		 * @generated
		 */
		EClass TAGGED_VALUE_CHANGE_LEFT_TARGET = eINSTANCE.getTaggedValueChangeLeftTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeRightTargetImpl <em>Tagged Value Change Right Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeRightTargetImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueChangeRightTarget()
		 * @generated
		 */
		EClass TAGGED_VALUE_CHANGE_RIGHT_TARGET = eINSTANCE.getTaggedValueChangeRightTarget();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UpdateTaggedValueImpl <em>Update Tagged Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UpdateTaggedValueImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getUpdateTaggedValue()
		 * @generated
		 */
		EClass UPDATE_TAGGED_VALUE = eINSTANCE.getUpdateTaggedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl <em>Add Stereotype Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getAddStereotypeApplication()
		 * @generated
		 */
		EClass ADD_STEREOTYPE_APPLICATION = eINSTANCE.getAddStereotypeApplication();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.RemoveStereotypeApplicationImpl <em>Remove Stereotype Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.RemoveStereotypeApplicationImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getRemoveStereotypeApplication()
		 * @generated
		 */
		EClass REMOVE_STEREOTYPE_APPLICATION = eINSTANCE.getRemoveStereotypeApplication();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl <em>Tagged Value Reference Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getTaggedValueReferenceChange()
		 * @generated
		 */
		EClass TAGGED_VALUE_REFERENCE_CHANGE = eINSTANCE.getTaggedValueReferenceChange();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl <em>Compare Two Elements Diff Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl
		 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.UMLDiffPackageImpl#getCompareTwoElementsDiffModel()
		 * @generated
		 */
		EClass COMPARE_TWO_ELEMENTS_DIFF_MODEL = eINSTANCE.getCompareTwoElementsDiffModel();

	}

} //UMLDiffPackage
