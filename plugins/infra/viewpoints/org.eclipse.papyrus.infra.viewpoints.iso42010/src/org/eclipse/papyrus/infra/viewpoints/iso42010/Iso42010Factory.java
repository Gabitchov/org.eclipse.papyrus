/**
 * Copyright (c) 2013 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.viewpoints.iso42010;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.viewpoints.iso42010.Iso42010Package
 * @generated
 */
public interface Iso42010Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Iso42010Factory eINSTANCE = org.eclipse.papyrus.infra.viewpoints.iso42010.impl.Iso42010FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Architecture Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Description</em>'.
	 * @generated
	 */
	ArchitectureDescription createArchitectureDescription();

	/**
	 * Returns a new object of class '<em>Stakeholder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stakeholder</em>'.
	 * @generated
	 */
	Stakeholder createStakeholder();

	/**
	 * Returns a new object of class '<em>Architecture Viewpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Viewpoint</em>'.
	 * @generated
	 */
	ArchitectureViewpoint createArchitectureViewpoint();

	/**
	 * Returns a new object of class '<em>Model Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Kind</em>'.
	 * @generated
	 */
	ModelKind createModelKind();

	/**
	 * Returns a new object of class '<em>Architecture Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Model</em>'.
	 * @generated
	 */
	ArchitectureModel createArchitectureModel();

	/**
	 * Returns a new object of class '<em>Architecture View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture View</em>'.
	 * @generated
	 */
	ArchitectureView createArchitectureView();

	/**
	 * Returns a new object of class '<em>Concern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concern</em>'.
	 * @generated
	 */
	Concern createConcern();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture</em>'.
	 * @generated
	 */
	Architecture createArchitecture();

	/**
	 * Returns a new object of class '<em>Architecture Rationale</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Rationale</em>'.
	 * @generated
	 */
	ArchitectureRationale createArchitectureRationale();

	/**
	 * Returns a new object of class '<em>Correspondence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correspondence</em>'.
	 * @generated
	 */
	Correspondence createCorrespondence();

	/**
	 * Returns a new object of class '<em>Correspondence Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correspondence Rule</em>'.
	 * @generated
	 */
	CorrespondenceRule createCorrespondenceRule();

	/**
	 * Returns a new object of class '<em>Architecture Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Decision</em>'.
	 * @generated
	 */
	ArchitectureDecision createArchitectureDecision();

	/**
	 * Returns a new object of class '<em>Architecture Framework</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architecture Framework</em>'.
	 * @generated
	 */
	ArchitectureFramework createArchitectureFramework();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Iso42010Package getIso42010Package();

} //Iso42010Factory
