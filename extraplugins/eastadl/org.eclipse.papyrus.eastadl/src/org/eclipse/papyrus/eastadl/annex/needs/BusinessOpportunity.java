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
package org.eclipse.papyrus.eastadl.annex.needs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Opportunity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The business opportunity represents a brief description of the business opportunity being met by developing the EE-System which establishes traceability from artifacts created later, for example to provide rationales to design decisions or trade-off analysis.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getProblemStatement <em>Problem Statement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getProductPositioning <em>Product Positioning</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBusinessOpportunity <em>Business Opportunity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getBusinessOpportunity()
 * @model
 * @generated
 */
public interface BusinessOpportunity extends TraceableSpecification {
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
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getBusinessOpportunity_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Business Opportunity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Opportunity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Opportunity</em>' attribute.
	 * @see #setBusinessOpportunity(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getBusinessOpportunity_BusinessOpportunity()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getBusinessOpportunity();

	/**
	 * Returns the value of the '<em><b>Problem Statement</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.ProblemStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem Statement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem Statement</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getBusinessOpportunity_ProblemStatement()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ProblemStatement> getProblemStatement();

	/**
	 * Returns the value of the '<em><b>Product Positioning</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Positioning</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Positioning</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getBusinessOpportunity_ProductPositioning()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ProductPositioning> getProductPositioning();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.BusinessOpportunity#getBusinessOpportunity <em>Business Opportunity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Business Opportunity</em>' attribute.
	 * @see #getBusinessOpportunity()
	 * @generated
	 */
	void setBusinessOpportunity(String value);

} // BusinessOpportunity
