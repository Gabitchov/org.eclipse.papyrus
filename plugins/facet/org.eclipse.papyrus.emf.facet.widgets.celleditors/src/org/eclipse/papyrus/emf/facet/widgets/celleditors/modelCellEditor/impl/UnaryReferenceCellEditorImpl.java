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
package org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Unary Reference Cell Editor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.impl.UnaryReferenceCellEditorImpl#getUnaryReferenceCellEditorImpl
 * <em>Unary Reference Cell Editor Impl</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UnaryReferenceCellEditorImpl extends AbstractModelCellEditorImpl implements
		UnaryReferenceCellEditor {
	/**
	 * The default value of the '{@link #getUnaryReferenceCellEditorImpl()
	 * <em>Unary Reference Cell Editor Impl</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnaryReferenceCellEditorImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String UNARY_REFERENCE_CELL_EDITOR_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnaryReferenceCellEditorImpl()
	 * <em>Unary Reference Cell Editor Impl</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnaryReferenceCellEditorImpl()
	 * @generated
	 * @ordered
	 */
	protected String unaryReferenceCellEditorImpl = UnaryReferenceCellEditorImpl.UNARY_REFERENCE_CELL_EDITOR_IMPL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UnaryReferenceCellEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelCellEditorPackage.Literals.UNARY_REFERENCE_CELL_EDITOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getUnaryReferenceCellEditorImpl() {
		return this.unaryReferenceCellEditorImpl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUnaryReferenceCellEditorImpl(final String newUnaryReferenceCellEditorImpl) {
		String oldUnaryReferenceCellEditorImpl = this.unaryReferenceCellEditorImpl;
		this.unaryReferenceCellEditorImpl = newUnaryReferenceCellEditorImpl;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL,
					oldUnaryReferenceCellEditorImpl, this.unaryReferenceCellEditorImpl));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL:
			return getUnaryReferenceCellEditorImpl();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL:
			setUnaryReferenceCellEditorImpl((String) newValue);
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
		case ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL:
			setUnaryReferenceCellEditorImpl(UnaryReferenceCellEditorImpl.UNARY_REFERENCE_CELL_EDITOR_IMPL_EDEFAULT);
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
		case ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL:
			return UnaryReferenceCellEditorImpl.UNARY_REFERENCE_CELL_EDITOR_IMPL_EDEFAULT == null ? this.unaryReferenceCellEditorImpl != null
					: !UnaryReferenceCellEditorImpl.UNARY_REFERENCE_CELL_EDITOR_IMPL_EDEFAULT
							.equals(this.unaryReferenceCellEditorImpl);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (unaryReferenceCellEditorImpl: "); //$NON-NLS-1$
		result.append(this.unaryReferenceCellEditorImpl);
		result.append(')');
		return result.toString();
	}

	/** @generated NOT */
	@Override
	public String getModelCellEditorImpl() {
		return getUnaryReferenceCellEditorImpl();
	}

} // UnaryReferenceCellEditorImpl
