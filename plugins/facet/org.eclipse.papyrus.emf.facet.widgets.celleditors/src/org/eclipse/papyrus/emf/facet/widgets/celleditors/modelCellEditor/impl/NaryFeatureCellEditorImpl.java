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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Nary Feature Cell Editor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.NaryFeatureCellEditorImpl#getNaryFeatureCellEditorImpl
 * <em>Nary Feature Cell Editor Impl</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NaryFeatureCellEditorImpl extends AbstractModelCellEditorImpl implements
		NaryFeatureCellEditor {
	/**
	 * The default value of the '{@link #getNaryFeatureCellEditorImpl()
	 * <em>Nary Feature Cell Editor Impl</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNaryFeatureCellEditorImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String NARY_FEATURE_CELL_EDITOR_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNaryFeatureCellEditorImpl()
	 * <em>Nary Feature Cell Editor Impl</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNaryFeatureCellEditorImpl()
	 * @generated
	 * @ordered
	 */
	protected String naryFeatureCellEditorImpl = NaryFeatureCellEditorImpl.NARY_FEATURE_CELL_EDITOR_IMPL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NaryFeatureCellEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelCellEditorPackage.Literals.NARY_FEATURE_CELL_EDITOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getNaryFeatureCellEditorImpl() {
		return this.naryFeatureCellEditorImpl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNaryFeatureCellEditorImpl(final String newNaryFeatureCellEditorImpl) {
		String oldNaryFeatureCellEditorImpl = this.naryFeatureCellEditorImpl;
		this.naryFeatureCellEditorImpl = newNaryFeatureCellEditorImpl;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL,
					oldNaryFeatureCellEditorImpl, this.naryFeatureCellEditorImpl));
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
		case ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL:
			return getNaryFeatureCellEditorImpl();
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
		case ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL:
			setNaryFeatureCellEditorImpl((String) newValue);
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
		case ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL:
			setNaryFeatureCellEditorImpl(NaryFeatureCellEditorImpl.NARY_FEATURE_CELL_EDITOR_IMPL_EDEFAULT);
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
		case ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL:
			return NaryFeatureCellEditorImpl.NARY_FEATURE_CELL_EDITOR_IMPL_EDEFAULT == null ? this.naryFeatureCellEditorImpl != null
					: !NaryFeatureCellEditorImpl.NARY_FEATURE_CELL_EDITOR_IMPL_EDEFAULT
							.equals(this.naryFeatureCellEditorImpl);
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
		result.append(" (naryFeatureCellEditorImpl: "); //$NON-NLS-1$
		result.append(this.naryFeatureCellEditorImpl);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getModelCellEditorImpl() {
		return getNaryFeatureCellEditorImpl();
	}

} // NaryFeatureCellEditorImpl
