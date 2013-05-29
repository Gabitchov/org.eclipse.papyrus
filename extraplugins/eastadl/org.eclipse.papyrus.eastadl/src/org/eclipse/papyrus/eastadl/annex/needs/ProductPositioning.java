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

import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Positioning</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The problem positioning represents an overall brief statement summarizing, at the highest level, the unique position the product intends to fill in the marketplace which gives the opportunity to establish traceability from artifacts created later, for example to provide rationales to design decisions or trade-off analysis.
 * 
 * Positioning is assumed to belong to a particular context, typically a system, but also for a smaller part of a system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getDrivingNeeds <em>Driving Needs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getKeyCapabilities <em>Key Capabilities</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryCompetitiveAlternative <em>Primary Competitive Alternative</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryDifferentiation <em>Primary Differentiation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getTargetCustomers <em>Target Customers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning()
 * @model
 * @generated
 */
public interface ProductPositioning extends TraceableSpecification {
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
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Driving Needs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driving Needs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driving Needs</em>' attribute.
	 * @see #setDrivingNeeds(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning_DrivingNeeds()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getDrivingNeeds();

	/**
	 * Returns the value of the '<em><b>Key Capabilities</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Capabilities</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Capabilities</em>' attribute.
	 * @see #setKeyCapabilities(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning_KeyCapabilities()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getKeyCapabilities();

	/**
	 * Returns the value of the '<em><b>Primary Competitive Alternative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Competitive Alternative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Competitive Alternative</em>' attribute.
	 * @see #setPrimaryCompetitiveAlternative(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning_PrimaryCompetitiveAlternative()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getPrimaryCompetitiveAlternative();

	/**
	 * Returns the value of the '<em><b>Primary Differentiation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Differentiation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Differentiation</em>' attribute.
	 * @see #setPrimaryDifferentiation(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning_PrimaryDifferentiation()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getPrimaryDifferentiation();

	/**
	 * Returns the value of the '<em><b>Target Customers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Customers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Customers</em>' attribute.
	 * @see #setTargetCustomers(String)
	 * @see org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage#getProductPositioning_TargetCustomers()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getTargetCustomers();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getDrivingNeeds <em>Driving Needs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driving Needs</em>' attribute.
	 * @see #getDrivingNeeds()
	 * @generated
	 */
	void setDrivingNeeds(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getKeyCapabilities <em>Key Capabilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Capabilities</em>' attribute.
	 * @see #getKeyCapabilities()
	 * @generated
	 */
	void setKeyCapabilities(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryCompetitiveAlternative <em>Primary Competitive Alternative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Competitive Alternative</em>' attribute.
	 * @see #getPrimaryCompetitiveAlternative()
	 * @generated
	 */
	void setPrimaryCompetitiveAlternative(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getPrimaryDifferentiation <em>Primary Differentiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Differentiation</em>' attribute.
	 * @see #getPrimaryDifferentiation()
	 * @generated
	 */
	void setPrimaryDifferentiation(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning#getTargetCustomers <em>Target Customers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Customers</em>' attribute.
	 * @see #getTargetCustomers()
	 * @generated
	 */
	void setTargetCustomers(String value);

} // ProductPositioning
