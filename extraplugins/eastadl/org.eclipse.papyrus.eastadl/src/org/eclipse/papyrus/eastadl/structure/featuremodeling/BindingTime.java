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
package org.eclipse.papyrus.eastadl.structure.featuremodeling;


import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Binding Time</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The motivation for attributing features and variable elements with binding times is that binding times encapsulate important information about the variability under view:
 * 
 * Variability that must be bound (determined, decided) very early in the system development may not be visible in one single feature model but only in comparison with different feature models in the context of multi-level feature trees; late bound variability is variability providing the driver with choices for current equipment configuration.
 * 
 * Binding times are important because they describe if the variability must be decided during system development or if the variability is determined by a customer or if the variability itself is part of the product features that are sold to the customer. Possible binding times are:
 * 
 * -	SystemDesignTime
 * -	CodeGenerationTime
 * -	PreCompileTime
 * -	LinkTime
 * -	PostBuild
 * -	Runtime
 * 
 * Note that a binding time is never a particular point in time such as April 2nd, 2011, but always a certain stage in the overall development, production and shipment process as represented by the above values.
 * 
 * Each feature must have a binding time (association requiredBindingTime) and may have one further binding time (association actualBindingTime).
 * 
 * The required binding time describes the binding time that the feature is intended to have. But due to technical conditions it may occur that the actually realized binding time of the feature differs from the originally intended binding time. In this case one has to provide information about the actual binding time. In the rationale it must be described by what the required binding time is motivated and what the reasons are for a (different) actual binding time.
 * 
 * Extension:
 * Class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getBindingTime()
 * @model
 * @generated
 */
public interface BindingTime extends EAElement {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute. The default value is
	 * <code>"DEVELOPMENT"</code>. The literals are from the enumeration
	 * {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind}. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The kind of the binding
	 * time, see enumeration of binding times. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind
	 * @see #setKind(BindingTimeKind)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getBindingTime_Kind()
	 * @model default="DEVELOPMENT" required="true" ordered="false"
	 * @generated
	 */
	BindingTimeKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(BindingTimeKind value);

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
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getBindingTime_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // BindingTime
