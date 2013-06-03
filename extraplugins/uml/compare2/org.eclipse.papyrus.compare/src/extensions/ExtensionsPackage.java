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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package extensions;

import org.eclipse.emf.compare.ComparePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see extensions.ExtensionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExtensionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extensions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/compare/papyrus";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "papyruscompare";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensionsPackage eINSTANCE = extensions.impl.ExtensionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link extensions.impl.PapyrusDiffImpl <em>Papyrus Diff</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see extensions.impl.PapyrusDiffImpl
	 * @see extensions.impl.ExtensionsPackageImpl#getPapyrusDiff()
	 * @generated
	 */
	int PAPYRUS_DIFF = 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__MATCH = ComparePackage.DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__REQUIRES = ComparePackage.DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__REQUIRED_BY = ComparePackage.DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__REFINES = ComparePackage.DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__REFINED_BY = ComparePackage.DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__KIND = ComparePackage.DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__SOURCE = ComparePackage.DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__STATE = ComparePackage.DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__EQUIVALENCE = ComparePackage.DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF__CONFLICT = ComparePackage.DIFF__CONFLICT;

	/**
	 * The number of structural features of the '<em>Papyrus Diff</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_DIFF_FEATURE_COUNT = ComparePackage.DIFF_FEATURE_COUNT + 0;


//	/**
//	 * The operation id for the '<em>Copy Right To Left</em>' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_DIFF___COPY_RIGHT_TO_LEFT = ComparePackage.DIFF___COPY_RIGHT_TO_LEFT;
//
//	/**
//	 * The operation id for the '<em>Copy Left To Right</em>' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_DIFF___COPY_LEFT_TO_RIGHT = ComparePackage.DIFF___COPY_LEFT_TO_RIGHT;
//
//	/**
//	 * The operation id for the '<em>Discard</em>' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_DIFF___DISCARD = ComparePackage.DIFF___DISCARD;
//
//	/**
//	 * The number of operations of the '<em>Papyrus Diff</em>' class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_DIFF_OPERATION_COUNT = ComparePackage.DIFF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link extensions.impl.PapyrusGeneralizationChangeImpl <em>Papyrus Generalization Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see extensions.impl.PapyrusGeneralizationChangeImpl
	 * @see extensions.impl.ExtensionsPackageImpl#getPapyrusGeneralizationChange()
	 * @generated
	 */
	int PAPYRUS_GENERALIZATION_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Match</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__MATCH = PAPYRUS_DIFF__MATCH;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__REQUIRES = PAPYRUS_DIFF__REQUIRES;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__REQUIRED_BY = PAPYRUS_DIFF__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__REFINES = PAPYRUS_DIFF__REFINES;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__REFINED_BY = PAPYRUS_DIFF__REFINED_BY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__KIND = PAPYRUS_DIFF__KIND;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__SOURCE = PAPYRUS_DIFF__SOURCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__STATE = PAPYRUS_DIFF__STATE;

	/**
	 * The feature id for the '<em><b>Equivalence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__EQUIVALENCE = PAPYRUS_DIFF__EQUIVALENCE;

	/**
	 * The feature id for the '<em><b>Conflict</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__CONFLICT = PAPYRUS_DIFF__CONFLICT;

	/**
	 * The feature id for the '<em><b>Generalization Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE = PAPYRUS_DIFF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Feature Node Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE = PAPYRUS_DIFF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Papyrus Generalization Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_GENERALIZATION_CHANGE_FEATURE_COUNT = PAPYRUS_DIFF_FEATURE_COUNT + 2;

//	/**
//	 * The operation id for the '<em>Copy Right To Left</em>' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_GENERALIZATION_CHANGE___COPY_RIGHT_TO_LEFT = PAPYRUS_DIFF___COPY_RIGHT_TO_LEFT;
//
//	/**
//	 * The operation id for the '<em>Copy Left To Right</em>' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_GENERALIZATION_CHANGE___COPY_LEFT_TO_RIGHT = PAPYRUS_DIFF___COPY_LEFT_TO_RIGHT;
//
//	/**
//	 * The operation id for the '<em>Discard</em>' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_GENERALIZATION_CHANGE___DISCARD = PAPYRUS_DIFF___DISCARD;
//
//	/**
//	 * The number of operations of the '<em>Papyrus Generalization Change</em>' class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 * @ordered
//	 */
//	int PAPYRUS_GENERALIZATION_CHANGE_OPERATION_COUNT = PAPYRUS_DIFF_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link extensions.PapyrusDiff <em>Papyrus Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Diff</em>'.
	 * @see extensions.PapyrusDiff
	 * @generated
	 */
	EClass getPapyrusDiff();

	/**
	 * Returns the meta object for class '{@link extensions.PapyrusGeneralizationChange <em>Papyrus Generalization Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Generalization Change</em>'.
	 * @see extensions.PapyrusGeneralizationChange
	 * @generated
	 */
	EClass getPapyrusGeneralizationChange();

	/**
	 * Returns the meta object for the reference '{@link extensions.PapyrusGeneralizationChange#getGeneralizationChange <em>Generalization Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generalization Change</em>'.
	 * @see extensions.PapyrusGeneralizationChange#getGeneralizationChange()
	 * @see #getPapyrusGeneralizationChange()
	 * @generated
	 */
	EReference getPapyrusGeneralizationChange_GeneralizationChange();

	/**
	 * Returns the meta object for the reference '{@link extensions.PapyrusGeneralizationChange#getInheritedFeatureNodeChange <em>Inherited Feature Node Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inherited Feature Node Change</em>'.
	 * @see extensions.PapyrusGeneralizationChange#getInheritedFeatureNodeChange()
	 * @see #getPapyrusGeneralizationChange()
	 * @generated
	 */
	EReference getPapyrusGeneralizationChange_InheritedFeatureNodeChange();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtensionsFactory getExtensionsFactory();

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
		 * The meta object literal for the '{@link extensions.impl.PapyrusDiffImpl <em>Papyrus Diff</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see extensions.impl.PapyrusDiffImpl
		 * @see extensions.impl.ExtensionsPackageImpl#getPapyrusDiff()
		 * @generated
		 */
		EClass PAPYRUS_DIFF = eINSTANCE.getPapyrusDiff();
		/**
		 * The meta object literal for the '{@link extensions.impl.PapyrusGeneralizationChangeImpl <em>Papyrus Generalization Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see extensions.impl.PapyrusGeneralizationChangeImpl
		 * @see extensions.impl.ExtensionsPackageImpl#getPapyrusGeneralizationChange()
		 * @generated
		 */
		EClass PAPYRUS_GENERALIZATION_CHANGE = eINSTANCE.getPapyrusGeneralizationChange();
		/**
		 * The meta object literal for the '<em><b>Generalization Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE = eINSTANCE.getPapyrusGeneralizationChange_GeneralizationChange();
		/**
		 * The meta object literal for the '<em><b>Inherited Feature Node Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE = eINSTANCE.getPapyrusGeneralizationChange_InheritedFeatureNodeChange();

	}

} //ExtensionsPackage
