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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Declarations</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations#getModelCellEditors
 * <em>Model Cell Editors</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getModelCellEditorDeclarations()
 * @model
 * @generated
 */
public interface ModelCellEditorDeclarations extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Cell Editors</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Cell Editors</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Cell Editors</em>' containment
	 *         reference list.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#getModelCellEditorDeclarations_ModelCellEditors()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractModelCellEditor> getModelCellEditors();

} // ModelCellEditorDeclarations
