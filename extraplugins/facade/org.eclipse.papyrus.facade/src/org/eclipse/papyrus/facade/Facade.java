/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facade</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.facade.Facade#getExtensionDefinitions <em>Extension Definitions</em>}</li>
 * <li>{@link org.eclipse.papyrus.facade.Facade#getVirtualmetamodel <em>Virtualmetamodel</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.facade.FacadePackage#getFacade()
 * @model
 * @generated
 */
public interface Facade extends EObject {

	/**
	 * Returns the value of the '<em><b>Extension Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getFacade <em>Facade</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Definitions</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Extension Definitions</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.FacadePackage#getFacade_ExtensionDefinitions()
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getFacade
	 * @model opposite="facade" containment="true"
	 * @generated
	 */
	EList<ExtensionDefinition> getExtensionDefinitions();

	/**
	 * Returns the value of the '<em><b>Virtualmetamodel</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getFacade <em>Facade</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtualmetamodel</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Virtualmetamodel</em>' containment reference.
	 * @see #setVirtualmetamodel(VirtualMetamodel)
	 * @see org.eclipse.papyrus.facade.FacadePackage#getFacade_Virtualmetamodel()
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getFacade
	 * @model opposite="facade" containment="true"
	 * @generated
	 */
	VirtualMetamodel getVirtualmetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.Facade#getVirtualmetamodel <em>Virtualmetamodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Virtualmetamodel</em>' containment reference.
	 * @see #getVirtualmetamodel()
	 * @generated
	 */
	void setVirtualmetamodel(VirtualMetamodel value);

} // Facade
