/**
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Model Cell Editor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellType
 * <em>Cell Type</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellId
 * <em>Cell Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getAbstractModelCellEditor()
 * @model abstract="true"
 * @generated
 */
public interface AbstractModelCellEditor extends EObject {
	/**
	 * Returns the value of the '<em><b>Cell Type</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Type</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cell Type</em>' reference.
	 * @see #setCellType(EClassifier)
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getAbstractModelCellEditor_CellType()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getCellType();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellType
	 * <em>Cell Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Cell Type</em>' reference.
	 * @see #getCellType()
	 * @generated
	 */
	void setCellType(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Cell Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Id</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cell Id</em>' attribute.
	 * @see #setCellId(String)
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getAbstractModelCellEditor_CellId()
	 * @model required="true"
	 * @generated
	 */
	String getCellId();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellId
	 * <em>Cell Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Cell Id</em>' attribute.
	 * @see #getCellId()
	 * @generated
	 */
	void setCellId(String value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getModelCellEditorImpl();

} // AbstractModelCellEditor
