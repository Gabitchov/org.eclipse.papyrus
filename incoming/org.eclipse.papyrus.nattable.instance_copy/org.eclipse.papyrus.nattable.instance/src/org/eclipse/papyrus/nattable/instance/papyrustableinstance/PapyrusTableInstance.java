/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.nattable.instance.papyrustableinstance;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Table Instance</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized <em>Is Synchronized</em>}</li>
 * <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getFillingJavaQueriesClassName <em>Filling Java Queries
 * Class Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance()
 * @model
 * @generated
 */
public interface PapyrusTableInstance extends EObject {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getName <em>Name</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the table
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getType <em>Type</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Is Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates if the table is synchronized with its context or not. Synchronization is done with the filling queries.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Is Synchronized</em>' attribute.
	 * @see #setIsSynchronized(boolean)
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_IsSynchronized()
	 * @model
	 * @generated
	 */
	boolean isIsSynchronized();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized
	 * <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Synchronized</em>' attribute.
	 * @see #isIsSynchronized()
	 * @generated
	 */
	void setIsSynchronized(boolean value);

	/**
	 * Returns the value of the '<em><b>Filling Java Queries Class Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This array contains the java class name of the filling queries. These queries are used to fill the table.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Filling Java Queries Class Name</em>' attribute list.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_FillingJavaQueriesClassName()
	 * @model
	 * @generated
	 */
	EList<String> getFillingJavaQueriesClassName();

	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TableInstance
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(TableInstance)
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_Table()
	 * @model
	 * @generated
	 */
	TableInstance getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getTable <em>Table</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(TableInstance value);

} // PapyrusTableInstance
