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
package org.eclipse.emf.facet.widgets.celleditors.modelCellEditor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage
 * @generated
 */
public interface ModelCellEditorFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ModelCellEditorFactory eINSTANCE = org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Declarations</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Declarations</em>'.
	 * @generated
	 */
	ModelCellEditorDeclarations createModelCellEditorDeclarations();

	/**
	 * Returns a new object of class '<em>Basic Cell Editor</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Basic Cell Editor</em>'.
	 * @generated
	 */
	BasicCellEditor createBasicCellEditor();

	/**
	 * Returns a new object of class '<em>Unary Reference Cell Editor</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Unary Reference Cell Editor</em>'.
	 * @generated
	 */
	UnaryReferenceCellEditor createUnaryReferenceCellEditor();

	/**
	 * Returns a new object of class '<em>Nary Feature Cell Editor</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Nary Feature Cell Editor</em>'.
	 * @generated
	 */
	NaryFeatureCellEditor createNaryFeatureCellEditor();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelCellEditorPackage getModelCellEditorPackage();

} // ModelCellEditorFactory
