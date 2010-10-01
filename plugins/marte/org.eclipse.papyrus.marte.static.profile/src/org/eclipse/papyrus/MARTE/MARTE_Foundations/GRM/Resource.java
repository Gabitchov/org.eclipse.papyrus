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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getResMult <em>Res Mult</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsProtected <em>Is Protected</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsActive <em>Is Active</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Classifier <em>Base Classifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Lifeline <em>Base Lifeline</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_ConnectableElement <em>Base Connectable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Res Mult</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Mult</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Mult</em>' attribute.
	 * @see #setResMult(String)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_ResMult()
	 * @model default="1" unique="false" dataType="org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.NFP_Integer" ordered="false"
	 * @generated
	 */
	String getResMult();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getResMult <em>Res Mult</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Mult</em>' attribute.
	 * @see #getResMult()
	 * @generated
	 */
	void setResMult(String value);

	/**
	 * Returns the value of the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Protected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Protected</em>' attribute.
	 * @see #setIsProtected(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_IsProtected()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsProtected();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsProtected <em>Is Protected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Protected</em>' attribute.
	 * @see #isIsProtected()
	 * @generated
	 */
	void setIsProtected(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Active</em>' attribute.
	 * @see #setIsActive(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_IsActive()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsActive();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsActive <em>Is Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Active</em>' attribute.
	 * @see #isIsActive()
	 * @generated
	 */
	void setIsActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Instance Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Instance Specification</em>' reference.
	 * @see #setBase_InstanceSpecification(InstanceSpecification)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_Base_InstanceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getBase_InstanceSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_InstanceSpecification <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Instance Specification</em>' reference.
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 */
	void setBase_InstanceSpecification(InstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Classifier</em>' reference.
	 * @see #setBase_Classifier(Classifier)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_Base_Classifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Classifier getBase_Classifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Classifier <em>Base Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Classifier</em>' reference.
	 * @see #getBase_Classifier()
	 * @generated
	 */
	void setBase_Classifier(Classifier value);

	/**
	 * Returns the value of the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Lifeline</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Lifeline</em>' reference.
	 * @see #setBase_Lifeline(Lifeline)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_Base_Lifeline()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Lifeline getBase_Lifeline();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Lifeline <em>Base Lifeline</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Lifeline</em>' reference.
	 * @see #getBase_Lifeline()
	 * @generated
	 */
	void setBase_Lifeline(Lifeline value);

	/**
	 * Returns the value of the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connectable Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connectable Element</em>' reference.
	 * @see #setBase_ConnectableElement(ConnectableElement)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage#getResource_Base_ConnectableElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConnectableElement getBase_ConnectableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_ConnectableElement <em>Base Connectable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connectable Element</em>' reference.
	 * @see #getBase_ConnectableElement()
	 * @generated
	 */
	void setBase_ConnectableElement(ConnectableElement value);

} // Resource
