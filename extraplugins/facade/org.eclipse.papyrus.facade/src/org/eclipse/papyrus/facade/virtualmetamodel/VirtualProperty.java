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
package org.eclipse.papyrus.facade.virtualmetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getVirtualMetaclass <em>Virtual Metaclass</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualProperty()
 * @model
 * @generated
 */
public interface VirtualProperty extends VirtualTypedElement {
	/**
	 * Returns the value of the '<em><b>Virtual Metaclass</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Metaclass</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Metaclass</em>' container reference.
	 * @see #setVirtualMetaclass(VirtualMetaclass)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualProperty_VirtualMetaclass()
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getProperties
	 * @model opposite="properties" required="true" transient="false"
	 * @generated
	 */
	VirtualMetaclass getVirtualMetaclass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getVirtualMetaclass <em>Virtual Metaclass</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual Metaclass</em>' container reference.
	 * @see #getVirtualMetaclass()
	 * @generated
	 */
	void setVirtualMetaclass(VirtualMetaclass value);

} // VirtualProperty
