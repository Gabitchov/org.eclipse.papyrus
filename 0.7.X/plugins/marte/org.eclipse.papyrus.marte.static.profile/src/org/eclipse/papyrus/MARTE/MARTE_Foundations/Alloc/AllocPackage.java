/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocFactory
 * @model kind="package"
 * @generated
 */
public interface AllocPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Alloc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/Alloc/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Alloc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AllocPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl <em>Allocated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocated()
	 * @generated
	 */
	int ALLOCATED = 0;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__BASE_NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Allocated To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__ALLOCATED_TO = 1;

	/**
	 * The feature id for the '<em><b>Allocated From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__ALLOCATED_FROM = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__KIND = 3;

	/**
	 * The number of structural features of the '<em>Allocated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATED_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateActivityGroupImpl <em>Allocate Activity Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateActivityGroupImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocateActivityGroup()
	 * @generated
	 */
	int ALLOCATE_ACTIVITY_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_ACTIVITY_GROUP__IS_UNIQUE = 0;

	/**
	 * The feature id for the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_ACTIVITY_GROUP__BASE_ACTIVITY_PARTITION = 1;

	/**
	 * The number of structural features of the '<em>Allocate Activity Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_ACTIVITY_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.NfpRefineImpl <em>Nfp Refine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.NfpRefineImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getNfpRefine()
	 * @generated
	 */
	int NFP_REFINE = 2;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_REFINE__BASE_DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_REFINE__CONSTRAINT = 1;

	/**
	 * The number of structural features of the '<em>Nfp Refine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFP_REFINE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl <em>Assign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAssign()
	 * @generated
	 */
	int ASSIGN = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__KIND = 0;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__NATURE = 1;

	/**
	 * The feature id for the '<em><b>Implied Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__IMPLIED_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__FROM = 3;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__TO = 4;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN__BASE_COMMENT = 5;

	/**
	 * The number of structural features of the '<em>Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl <em>Allocate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocate()
	 * @generated
	 */
	int ALLOCATE = 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__KIND = 0;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__NATURE = 1;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__BASE_ABSTRACTION = 2;

	/**
	 * The feature id for the '<em><b>Implied Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__IMPLIED_CONSTRAINT = 3;

	/**
	 * The number of structural features of the '<em>Allocate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind <em>Allocation End Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocationEndKind()
	 * @generated
	 */
	int ALLOCATION_END_KIND = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature <em>Allocation Nature</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocationNature()
	 * @generated
	 */
	int ALLOCATION_NATURE = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind <em>Allocation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocationKind()
	 * @generated
	 */
	int ALLOCATION_KIND = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind <em>Assignment Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAssignmentKind()
	 * @generated
	 */
	int ASSIGNMENT_KIND = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature <em>Assignment Nature</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAssignmentNature()
	 * @generated
	 */
	int ASSIGNMENT_NATURE = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated <em>Allocated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocated</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated
	 * @generated
	 */
	EClass getAllocated();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getBase_NamedElement()
	 * @see #getAllocated()
	 * @generated
	 */
	EReference getAllocated_Base_NamedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Allocated To</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getAllocatedTo()
	 * @see #getAllocated()
	 * @generated
	 */
	EReference getAllocated_AllocatedTo();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getAllocatedFrom <em>Allocated From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Allocated From</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getAllocatedFrom()
	 * @see #getAllocated()
	 * @generated
	 */
	EReference getAllocated_AllocatedFrom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocated#getKind()
	 * @see #getAllocated()
	 * @generated
	 */
	EAttribute getAllocated_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocateActivityGroup <em>Allocate Activity Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocate Activity Group</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocateActivityGroup
	 * @generated
	 */
	EClass getAllocateActivityGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocateActivityGroup#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocateActivityGroup#isIsUnique()
	 * @see #getAllocateActivityGroup()
	 * @generated
	 */
	EAttribute getAllocateActivityGroup_IsUnique();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocateActivityGroup#getBase_ActivityPartition <em>Base Activity Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Partition</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocateActivityGroup#getBase_ActivityPartition()
	 * @see #getAllocateActivityGroup()
	 * @generated
	 */
	EReference getAllocateActivityGroup_Base_ActivityPartition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine <em>Nfp Refine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nfp Refine</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine
	 * @generated
	 */
	EClass getNfpRefine();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getBase_Dependency()
	 * @see #getNfpRefine()
	 * @generated
	 */
	EReference getNfpRefine_Base_Dependency();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getConstraint()
	 * @see #getNfpRefine()
	 * @generated
	 */
	EReference getNfpRefine_Constraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign
	 * @generated
	 */
	EClass getAssign();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getKind()
	 * @see #getAssign()
	 * @generated
	 */
	EAttribute getAssign_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getNature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getNature()
	 * @see #getAssign()
	 * @generated
	 */
	EAttribute getAssign_Nature();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getImpliedConstraint <em>Implied Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implied Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getImpliedConstraint()
	 * @see #getAssign()
	 * @generated
	 */
	EReference getAssign_ImpliedConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getFrom()
	 * @see #getAssign()
	 * @generated
	 */
	EReference getAssign_From();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>To</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getTo()
	 * @see #getAssign()
	 * @generated
	 */
	EReference getAssign_To();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign#getBase_Comment()
	 * @see #getAssign()
	 * @generated
	 */
	EReference getAssign_Base_Comment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate <em>Allocate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocate</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate
	 * @generated
	 */
	EClass getAllocate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getKind()
	 * @see #getAllocate()
	 * @generated
	 */
	EAttribute getAllocate_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getNature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getNature()
	 * @see #getAllocate()
	 * @generated
	 */
	EAttribute getAllocate_Nature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getBase_Abstraction()
	 * @see #getAllocate()
	 * @generated
	 */
	EReference getAllocate_Base_Abstraction();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getImpliedConstraint <em>Implied Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implied Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getImpliedConstraint()
	 * @see #getAllocate()
	 * @generated
	 */
	EReference getAllocate_ImpliedConstraint();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind <em>Allocation End Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Allocation End Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind
	 * @generated
	 */
	EEnum getAllocationEndKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature <em>Allocation Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Allocation Nature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature
	 * @generated
	 */
	EEnum getAllocationNature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind <em>Allocation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Allocation Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind
	 * @generated
	 */
	EEnum getAllocationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind <em>Assignment Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assignment Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind
	 * @generated
	 */
	EEnum getAssignmentKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature <em>Assignment Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assignment Nature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature
	 * @generated
	 */
	EEnum getAssignmentNature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AllocFactory getAllocFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl <em>Allocated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocatedImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocated()
		 * @generated
		 */
		EClass ALLOCATED = eINSTANCE.getAllocated();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATED__BASE_NAMED_ELEMENT = eINSTANCE.getAllocated_Base_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Allocated To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATED__ALLOCATED_TO = eINSTANCE.getAllocated_AllocatedTo();

		/**
		 * The meta object literal for the '<em><b>Allocated From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATED__ALLOCATED_FROM = eINSTANCE.getAllocated_AllocatedFrom();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATED__KIND = eINSTANCE.getAllocated_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateActivityGroupImpl <em>Allocate Activity Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateActivityGroupImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocateActivityGroup()
		 * @generated
		 */
		EClass ALLOCATE_ACTIVITY_GROUP = eINSTANCE.getAllocateActivityGroup();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATE_ACTIVITY_GROUP__IS_UNIQUE = eINSTANCE.getAllocateActivityGroup_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Base Activity Partition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE_ACTIVITY_GROUP__BASE_ACTIVITY_PARTITION = eINSTANCE.getAllocateActivityGroup_Base_ActivityPartition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.NfpRefineImpl <em>Nfp Refine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.NfpRefineImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getNfpRefine()
		 * @generated
		 */
		EClass NFP_REFINE = eINSTANCE.getNfpRefine();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_REFINE__BASE_DEPENDENCY = eINSTANCE.getNfpRefine_Base_Dependency();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NFP_REFINE__CONSTRAINT = eINSTANCE.getNfpRefine_Constraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl <em>Assign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AssignImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAssign()
		 * @generated
		 */
		EClass ASSIGN = eINSTANCE.getAssign();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN__KIND = eINSTANCE.getAssign_Kind();

		/**
		 * The meta object literal for the '<em><b>Nature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN__NATURE = eINSTANCE.getAssign_Nature();

		/**
		 * The meta object literal for the '<em><b>Implied Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__IMPLIED_CONSTRAINT = eINSTANCE.getAssign_ImpliedConstraint();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__FROM = eINSTANCE.getAssign_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__TO = eINSTANCE.getAssign_To();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN__BASE_COMMENT = eINSTANCE.getAssign_Base_Comment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl <em>Allocate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocate()
		 * @generated
		 */
		EClass ALLOCATE = eINSTANCE.getAllocate();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATE__KIND = eINSTANCE.getAllocate_Kind();

		/**
		 * The meta object literal for the '<em><b>Nature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOCATE__NATURE = eINSTANCE.getAllocate_Nature();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE__BASE_ABSTRACTION = eINSTANCE.getAllocate_Base_Abstraction();

		/**
		 * The meta object literal for the '<em><b>Implied Constraint</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE__IMPLIED_CONSTRAINT = eINSTANCE.getAllocate_ImpliedConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind <em>Allocation End Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationEndKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocationEndKind()
		 * @generated
		 */
		EEnum ALLOCATION_END_KIND = eINSTANCE.getAllocationEndKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature <em>Allocation Nature</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocationNature()
		 * @generated
		 */
		EEnum ALLOCATION_NATURE = eINSTANCE.getAllocationNature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind <em>Allocation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAllocationKind()
		 * @generated
		 */
		EEnum ALLOCATION_KIND = eINSTANCE.getAllocationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind <em>Assignment Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAssignmentKind()
		 * @generated
		 */
		EEnum ASSIGNMENT_KIND = eINSTANCE.getAssignmentKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature <em>Assignment Nature</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AssignmentNature
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl#getAssignmentNature()
		 * @generated
		 */
		EEnum ASSIGNMENT_NATURE = eINSTANCE.getAssignmentNature();

	}

} //AllocPackage
