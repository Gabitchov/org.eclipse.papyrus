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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Cell elements used to store specific information which can't be stored in the edited model
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getColumnWrapper <em>Column Wrapper</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getRowWrapper <em>Row Wrapper</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getProblems <em>Problems</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage#getCell()
 * @model
 * @generated
 */
public interface Cell extends EObject, EModelElement {

	/**
	 * Returns the value of the '<em><b>Column Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The column element on which this cell must be displayed.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Column Wrapper</em>' containment reference.
	 * @see #setColumnWrapper(ICellAxisWrapper)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage#getCell_ColumnWrapper()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ICellAxisWrapper getColumnWrapper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getColumnWrapper <em>Column Wrapper</em>}'
	 * containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Column Wrapper</em>' containment reference.
	 * @see #getColumnWrapper()
	 * @generated
	 */
	void setColumnWrapper(ICellAxisWrapper value);

	/**
	 * Returns the value of the '<em><b>Row Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The row element on which this cell must be displayed.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Row Wrapper</em>' containment reference.
	 * @see #setRowWrapper(ICellAxisWrapper)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage#getCell_RowWrapper()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ICellAxisWrapper getRowWrapper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell#getRowWrapper <em>Row Wrapper</em>}'
	 * containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Row Wrapper</em>' containment reference.
	 * @see #getRowWrapper()
	 * @generated
	 */
	void setRowWrapper(ICellAxisWrapper value);

	/**
	 * Returns the value of the '<em><b>Problems</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * a list of problem founds on this cell
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Problems</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage#getCell_Problems()
	 * @model containment="true"
	 * @generated
	 */
	EList<Problem> getProblems();

} // Cell
