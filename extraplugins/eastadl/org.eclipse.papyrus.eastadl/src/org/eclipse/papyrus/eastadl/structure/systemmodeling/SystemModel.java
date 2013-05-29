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
package org.eclipse.papyrus.eastadl.structure.systemmodeling;

import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SystemModel is used to organize models/architectures according to their abstraction level; it can also hold with relationships between the different levels.
 * 
 * Semantics:
 * The SystemModel represents the EE system of the vehicle, and concepts related to the various abstraction levels.
 * 
 * Notation:
 * The default notation for a SystemModel is a solid-outline rectangle containing the SystemModel's name, and with compartments separating by horizontal lines containing features or other members of the SystemModel. Contained entities may also be shown with its connectors (White-box view).
 * 
 * Changes: New class in EAST-ADL2
 * 
 * Extension: Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getImplementationLevel <em>Implementation Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getAnalysisLevel <em>Analysis Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getDesignLevel <em>Design Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getVehicleLevel <em>Vehicle Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel()
 * @model
 * @generated
 */
public interface SystemModel extends Context {
	/**
	 * Returns the value of the '<em><b>Analysis Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The AnalysisArchitecture contained in the SystemModel and connected to the EnvironmentModel through ports-connectors
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Analysis Level</em>' reference.
	 * @see #setAnalysisLevel(AnalysisLevel)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel_AnalysisLevel()
	 * @model ordered="false"
	 * @generated
	 */
	AnalysisLevel getAnalysisLevel();

	/**
	 * Returns the value of the '<em><b>Design Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The designArchitecture contained in the SystemModel and connected to the EnvironmentModel through ports-connectors
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Design Level</em>' reference.
	 * @see #setDesignLevel(DesignLevel)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel_DesignLevel()
	 * @model ordered="false"
	 * @generated
	 */
	DesignLevel getDesignLevel();

	/**
	 * Returns the value of the '<em><b>Implementation Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Implementation Architecture abstraction level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implementation Level</em>' reference.
	 * @see #setImplementationLevel(ImplementationLevel)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel_ImplementationLevel()
	 * @model ordered="false"
	 * @generated
	 */
	ImplementationLevel getImplementationLevel();

	/**
	 * Returns the value of the '<em><b>Vehicle Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Vehicle Feature Model contained in the SystemModel.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vehicle Level</em>' reference.
	 * @see #setVehicleLevel(VehicleLevel)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel_VehicleLevel()
	 * @model ordered="false"
	 * @generated
	 */
	VehicleLevel getVehicleLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getAnalysisLevel <em>Analysis Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Level</em>' reference.
	 * @see #getAnalysisLevel()
	 * @generated
	 */
	void setAnalysisLevel(AnalysisLevel value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getDesignLevel <em>Design Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Design Level</em>' reference.
	 * @see #getDesignLevel()
	 * @generated
	 */
	void setDesignLevel(DesignLevel value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getImplementationLevel <em>Implementation Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Level</em>' reference.
	 * @see #getImplementationLevel()
	 * @generated
	 */
	void setImplementationLevel(ImplementationLevel value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getVehicleLevel <em>Vehicle Level</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle Level</em>' reference.
	 * @see #getVehicleLevel()
	 * @generated
	 */
	void setVehicleLevel(VehicleLevel value);

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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getSystemModel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // SystemModel
