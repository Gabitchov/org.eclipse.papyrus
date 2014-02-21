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
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Basic Cell Editor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.impl.BasicCellEditorImpl#getBasicCellEditorImpl
 * <em>Basic Cell Editor Impl</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BasicCellEditorImpl extends AbstractModelCellEditorImpl implements BasicCellEditor {
	/**
	 * The default value of the '{@link #getBasicCellEditorImpl()
	 * <em>Basic Cell Editor Impl</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBasicCellEditorImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String BASIC_CELL_EDITOR_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBasicCellEditorImpl()
	 * <em>Basic Cell Editor Impl</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBasicCellEditorImpl()
	 * @generated
	 * @ordered
	 */
	protected String basicCellEditorImpl = BasicCellEditorImpl.BASIC_CELL_EDITOR_IMPL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BasicCellEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelCellEditorPackage.Literals.BASIC_CELL_EDITOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBasicCellEditorImpl() {
		return this.basicCellEditorImpl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBasicCellEditorImpl(final String newBasicCellEditorImpl) {
		String oldBasicCellEditorImpl = this.basicCellEditorImpl;
		this.basicCellEditorImpl = newBasicCellEditorImpl;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelCellEditorPackage.BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL,
					oldBasicCellEditorImpl, this.basicCellEditorImpl));
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
		case ModelCellEditorPackage.BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL:
			return getBasicCellEditorImpl();
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
		case ModelCellEditorPackage.BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL:
			setBasicCellEditorImpl((String) newValue);
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
		case ModelCellEditorPackage.BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL:
			setBasicCellEditorImpl(BasicCellEditorImpl.BASIC_CELL_EDITOR_IMPL_EDEFAULT);
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
		case ModelCellEditorPackage.BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL:
			return BasicCellEditorImpl.BASIC_CELL_EDITOR_IMPL_EDEFAULT == null ? this.basicCellEditorImpl != null
					: !BasicCellEditorImpl.BASIC_CELL_EDITOR_IMPL_EDEFAULT
							.equals(this.basicCellEditorImpl);
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
		result.append(" (basicCellEditorImpl: "); //$NON-NLS-1$
		result.append(this.basicCellEditorImpl);
		result.append(')');
		return result.toString();
	}

	/** @generated NOT */
	@Override
	public String getModelCellEditorImpl() {
		return getBasicCellEditorImpl();
	}

} // BasicCellEditorImpl
