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
package org.eclipse.papyrus.eastadl.variability;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Decision Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ConfigurationDecisionFolder represents a grouping for ConfigurationDecisions.
 * 
 * 
 * Semantics:
 * ConfigurationDecisionFolder is a grouping entity for ConfigurationDecisions.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder#getChildEntry <em>Child Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecisionFolder()
 * @model
 * @generated
 */
public interface ConfigurationDecisionFolder extends ConfigurationDecisionModelEntry {
	/**
	 * Returns the value of the '<em><b>Child Entry</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Entry</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecisionFolder_ChildEntry()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ConfigurationDecisionModelEntry> getChildEntry();

} // ConfigurationDecisionFolder
