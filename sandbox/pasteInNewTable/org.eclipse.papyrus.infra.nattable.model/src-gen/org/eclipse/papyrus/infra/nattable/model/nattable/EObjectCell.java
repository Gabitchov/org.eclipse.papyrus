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
package org.eclipse.papyrus.infra.nattable.model.nattable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getRowElement <em>Row Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getColumnElement <em>Column Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getEObjectCell()
 * @model
 * @generated
 */
public interface EObjectCell extends ICell {
	/**
	 * Returns the value of the '<em><b>Row Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Element</em>' reference.
	 * @see #setRowElement(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getEObjectCell_RowElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getRowElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getRowElement <em>Row Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row Element</em>' reference.
	 * @see #getRowElement()
	 * @generated
	 */
	void setRowElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Column Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Element</em>' reference.
	 * @see #setColumnElement(EObject)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getEObjectCell_ColumnElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getColumnElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell#getColumnElement <em>Column Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Element</em>' reference.
	 * @see #getColumnElement()
	 * @generated
	 */
	void setColumnElement(EObject value);

} // EObjectCell
