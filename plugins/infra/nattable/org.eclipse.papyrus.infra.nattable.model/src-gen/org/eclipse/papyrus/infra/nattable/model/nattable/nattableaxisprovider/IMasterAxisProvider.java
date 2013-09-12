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
 * <!-- begin-model-doc -->
 * Interface used to distinghuish master axis provider from slave axis provider.
 * The master are able to disconnect the slave.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider#isDisconnectSlave <em>Disconnect Slave</em>}</li>
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * if true, the slave won't be updated when the elements owned by the master will be changed.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Disconnect Slave</em>' attribute.
	 * @see #setDisconnectSlave(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage#getIMasterAxisProvider_DisconnectSlave()
	 * @model
	 * @generated
	 */
	boolean isDisconnectSlave();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider#isDisconnectSlave
	 * <em>Disconnect Slave</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Disconnect Slave</em>' attribute.
	 * @see #isDisconnectSlave()
	 * @generated
	 */
	void setDisconnectSlave(boolean value);

} // IMasterAxisProvider
