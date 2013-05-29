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
package org.eclipse.papyrus.eastadl.requirements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.behavior.Mode;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Requirement represents a capability or condition that must (or should) be satisfied. A Requirement can also specify an informal constraint, e.g. "The development of the component X must be according to the standard Y", or "The realization of this function as a software component must adhere to the scope and external interface as specified by this function". It will be used to unite the common properties of specific requirement types. A Requirement may either be directly associated to a Context (by inheriting from TraceableSpecification or it may be included in a RequirementContainer, which represents a larger unit or module of specification information.
 * 
 * The traceability between Requirement entities, and other specification or design entities, will be ensured by the relationship dependencies described in the Infrastructure part of this specification.
 * 
 * Semantics:
 * The Requirement metaclass applies to the EAElement that is associated to the Requirement through the Satisfy relation.
 * 
 * Notation:
 * Requirement is shown as a solid rectangle with Req top right and its name.
 * 
 * Changes:
 * Renamed from Requirement, name clash with SysML
 * ToDo:
 * Check the attributes specified in EAST.
 * 
 * Extension:
 * To specialize SysML::Requirement, which extends Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getFormalism <em>Formalism</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends org.eclipse.papyrus.sysml.requirements.Requirement, RequirementSpecificationObject {
	/**
	 * Returns the value of the '<em><b>Formalism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the language used for the requirement statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Formalism</em>' attribute.
	 * @see #setFormalism(String)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirement_Formalism()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getFormalism();

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
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirement_Mode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Mode> getMode();

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to possible external file containing the requirement statement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirement_Url()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getFormalism <em>Formalism</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formalism</em>' attribute.
	 * @see #getFormalism()
	 * @generated
	 */
	void setFormalism(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.Requirement#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

} // Requirement
