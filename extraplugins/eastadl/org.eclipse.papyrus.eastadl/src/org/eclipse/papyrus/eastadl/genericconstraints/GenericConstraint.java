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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.genericconstraints;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The GenericConstraint denotes a property, requirement, or a validation result for the identified element of the model. The kind of GenericConstraint is described as one of the GenericConstraintKind literals.
 * 
 * Example: If the attribute genericConstraintType is cableLength, the genericConstraintValue could be "5 meters" (value of a numerical datatype with unit "meters").
 * 
 * Semantics:
 * The GenericConstraint does not describe what is classically referred to as a design constraint but has the role of a property, requirement, or a validation result. It is a requirement if this GenericConstraint refines a Requirement (by the Refine relationship). The GenericConstraint is a validation result if it realizes a VVActualOutcome, it is an intended validation result if it realizes a VVIntendedOutcome, and in other cases it denotes a property.
 * 
 * 
 * 
 * Extension: Class, Constraint
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getDesignConstraintType <em>Design Constraint Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getGenericConstraintValue <em>Generic Constraint Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint()
 * @model
 * @generated
 */
public interface GenericConstraint extends TraceableSpecification {
	/**
	 * Returns the value of the '<em><b>Design Constraint Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Design Constraint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Design Constraint Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind
	 * @see #setDesignConstraintType(GenericConstraintKind)
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint_DesignConstraintType()
	 * @model default="" ordered="false"
	 * @generated
	 */
	GenericConstraintKind getDesignConstraintType();

	/**
	 * Returns the value of the '<em><b>Generic Constraint Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generic Constraint Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generic Constraint Value</em>' attribute.
	 * @see #setGenericConstraintValue(String)
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint_GenericConstraintValue()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getGenericConstraintValue();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.behavior.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint_Mode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getMode();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint_Target()
	 * @model ordered="false"
	 * @generated
	 */
	EList<NamedElement> getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getDesignConstraintType <em>Design Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Design Constraint Type</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraintKind
	 * @see #getDesignConstraintType()
	 * @generated
	 */
	void setDesignConstraintType(GenericConstraintKind value);

	/**
	 * Returns the value of the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Constraint</em>' reference.
	 * @see #setBase_Constraint(Constraint)
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint_Base_Constraint()
	 * @model ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getGenericConstraintValue <em>Generic Constraint Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generic Constraint Value</em>' attribute.
	 * @see #getGenericConstraintValue()
	 * @generated
	 */
	void setGenericConstraintValue(String value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage#getGenericConstraint_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.genericconstraints.GenericConstraint#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // GenericConstraint
