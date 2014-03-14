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
package org.eclipse.papyrus.eastadl.interchange;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>RIF Area</b></em>'. <!--
 * end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * An extra allocated part of the EAST-ADL2 System Model that contains Requirement Specific Data (Container, Reqs etc...) from RIF Import resp. RIF
 * Export.
 * 
 * Especially for the context of requirement engineering and considering the possibility to import/export requirement related data via RIF, the
 * feature uuid will be used to check that two elements are semantically the same and thus should stay together in reference via a Multi-Level
 * reference link.
 * 
 * Since requirement data to be imported/exported will be put into RIFArea, requirement data elements which are not inside RIFArea and have
 * semantically equal element in the RIFAreas (such elements have the same uuid value) will be connected with the appropriate elements in the RIFArea
 * using Multi-Level reference links.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getRootRequirementContainer <em>Root Requirement Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getInterchangeReqSpecObject <em>Interchange Req Spec Object</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.interchange.InterchangePackage#getRIFArea()
 * @model abstract="true"
 * @generated
 */
public interface RIFArea extends Context {

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
	 * @see org.eclipse.papyrus.eastadl.interchange.InterchangePackage#getRIFArea_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Returns the value of the '<em><b>Interchange Req Spec Object</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interchange Req Spec Object</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interchange Req Spec Object</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.interchange.InterchangePackage#getRIFArea_InterchangeReqSpecObject()
	 * @model ordered="false"
	 * @generated
	 */
	EList<RequirementSpecificationObject> getInterchangeReqSpecObject();

	/**
	 * Returns the value of the '<em><b>Root Requirement Container</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Requirement Container</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Root Requirement Container</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.interchange.InterchangePackage#getRIFArea_RootRequirementContainer()
	 * @model
	 * @generated
	 */
	EList<RequirementsContainer> getRootRequirementContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // RIFArea
