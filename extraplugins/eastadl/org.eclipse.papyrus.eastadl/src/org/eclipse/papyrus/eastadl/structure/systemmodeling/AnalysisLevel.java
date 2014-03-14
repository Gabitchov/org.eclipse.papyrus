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
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Level</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * AnalysisLevel represents the vehicle EE system in terms of its abstract functional definition. It includes the functional analysis architecture
 * (FAA) which represents the abstract functional structure.
 * 
 * Semantics:
 * AnalysisLevel represents the vehicle EE system in terms of its abstract functional definition. It defines the logical functionality and a logical
 * decomposition of functionality down to the appropriate granularity.
 * 
 * Notation:
 * The Analysis Architecture is shown as a solid-outline rectangle containing the name, with its ports or port groups on the perimeter. Contained
 * entities may be shown with its connectors (White-box view).
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getFunctionalAnalysisArchitecture <em>Functional Analysis
 * Architecture</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getAnalysisLevel()
 * @model
 * @generated
 */
public interface AnalysisLevel extends Context {

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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getAnalysisLevel_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

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
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getAnalysisLevel_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Package <em>Base Package</em>}'
	 * reference.
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
	 * Returns the value of the '<em><b>Functional Analysis Architecture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Analysis Architecture</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Functional Analysis Architecture</em>' reference.
	 * @see #setFunctionalAnalysisArchitecture(AnalysisFunctionPrototype)
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage#getAnalysisLevel_FunctionalAnalysisArchitecture()
	 * @model ordered="false"
	 * @generated
	 */
	AnalysisFunctionPrototype getFunctionalAnalysisArchitecture();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getFunctionalAnalysisArchitecture
	 * <em>Functional Analysis Architecture</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Functional Analysis Architecture</em>' reference.
	 * @see #getFunctionalAnalysisArchitecture()
	 * @generated
	 */
	void setFunctionalAnalysisArchitecture(AnalysisFunctionPrototype value);

} // AnalysisLevel
