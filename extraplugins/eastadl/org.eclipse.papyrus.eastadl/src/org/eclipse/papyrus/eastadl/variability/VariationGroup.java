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
package org.eclipse.papyrus.eastadl.variability;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variation Group</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * A VariationGroup defines a relation between an arbitrary number of VariableElements. It is primarily intended for defining how these
 * VariableElements may be combined (e.g. one requires the other, alternative, etc.).
 * 
 * 
 * Semantics:
 * Defines a dependency or constraint between the variable elements denoted by association variableElement. The actual constraint is specified by
 * attribute kind.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getConstraint <em>Constraint</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getKind <em>Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getVariableElement <em>Variable Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariationGroup()
 * @model
 * @generated
 */
public interface VariationGroup extends EAElement {

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint</em>' attribute.
	 * @see #setConstraint(String)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariationGroup_Constraint()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getConstraint();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute. The default value is <code>"exclude"</code>. The literals are from the enumeration
	 * {@link com.cea.papyrus.uml4eastadl.eastadl.variability.VariationGroupKind}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Type of constraint involved. Default is
	 * EXCLUDE <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.cea.papyrus.uml4eastadl.eastadl.variability.VariationGroupKind
	 * @see #setKind(VariationGroupKind)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariationGroup_Kind()
	 * @model default="exclude" unique="false" required="true" ordered="false"
	 * @generated
	 */
	VariabilityDependencyKind getKind();

	/**
	 * Returns the value of the '<em><b>Variable Element</b></em>' reference list. The list contents
	 * are of type {@link com.cea.papyrus.uml4eastadl.eastadl.variability.ADLVariableElement}. It is
	 * bidirectional and its opposite is ' {@link com.cea.papyrus.uml4eastadl.eastadl.variability.ADLVariableElement#getVariationGroup
	 * <em>Variation Group</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Element</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Associated variable elements <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Variable Element</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariationGroup_VariableElement()
	 * @see com.cea.papyrus.uml4eastadl.eastadl.variability.ADLVariableElement#getVariationGroup
	 * @model opposite="variationGroup" required="true"
	 * @generated
	 */
	EList<VariableElement> getVariableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getConstraint <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Constraint</em>' attribute.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(VariabilityDependencyKind value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getVariationGroup_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.VariationGroup#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // VariationGroup
