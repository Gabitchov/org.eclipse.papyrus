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
package org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Declarations</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorDeclarationsImpl#getModelCellEditors
 * <em>Model Cell Editors</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelCellEditorDeclarationsImpl extends EObjectImpl implements
		ModelCellEditorDeclarations {
	/**
	 * The cached value of the '{@link #getModelCellEditors()
	 * <em>Model Cell Editors</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelCellEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractModelCellEditor> modelCellEditors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelCellEditorDeclarationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelCellEditorPackage.Literals.MODEL_CELL_EDITOR_DECLARATIONS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractModelCellEditor> getModelCellEditors() {
		if (this.modelCellEditors == null) {
			this.modelCellEditors = new EObjectContainmentEList<AbstractModelCellEditor>(
					AbstractModelCellEditor.class, this,
					ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS);
		}
		return this.modelCellEditors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
			final NotificationChain msgs) {
		switch (featureID) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS:
			return ((InternalEList<?>) getModelCellEditors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS:
			return getModelCellEditors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS:
			getModelCellEditors().clear();
			getModelCellEditors().addAll((Collection<? extends AbstractModelCellEditor>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(final int featureID) {
		switch (featureID) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS:
			getModelCellEditors().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS:
			return this.modelCellEditors != null && !this.modelCellEditors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ModelCellEditorDeclarationsImpl
