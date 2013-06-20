/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotML;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Plan</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getMainInstance <em>Main Instance</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDeploymentPlan()
 * @model
 * @generated
 */
public interface DeploymentPlan extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDeploymentPlan_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

	/**
	 * Returns the value of the '<em><b>Main Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Instance</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Main Instance</em>' reference.
	 * @see #setMainInstance(InstanceSpecification)
	 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDeploymentPlan_MainInstance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getMainInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getMainInstance <em>Main Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Main Instance</em>' reference.
	 * @see #getMainInstance()
	 * @generated
	 */
	void setMainInstance(InstanceSpecification value);

} // DeploymentPlan
