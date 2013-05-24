/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IMaster Axis Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider#isDisconnectSlave <em>Disconnect Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage#getIMasterAxisProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IMasterAxisProvider extends AxisProvider {
	/**
	 * Returns the value of the '<em><b>Disconnect Slave</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disconnect Slave</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disconnect Slave</em>' attribute.
	 * @see #setDisconnectSlave(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage#getIMasterAxisProvider_DisconnectSlave()
	 * @model
	 * @generated
	 */
	boolean isDisconnectSlave();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider#isDisconnectSlave <em>Disconnect Slave</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disconnect Slave</em>' attribute.
	 * @see #isDisconnectSlave()
	 * @generated
	 */
	void setDisconnectSlave(boolean value);

} // IMasterAxisProvider
