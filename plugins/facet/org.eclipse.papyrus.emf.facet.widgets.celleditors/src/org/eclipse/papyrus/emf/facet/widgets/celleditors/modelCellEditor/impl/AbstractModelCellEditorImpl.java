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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Model Cell Editor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.AbstractModelCellEditorImpl#getCellType
 * <em>Cell Type</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.AbstractModelCellEditorImpl#getCellId
 * <em>Cell Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AbstractModelCellEditorImpl extends EObjectImpl implements
		AbstractModelCellEditor {
	/**
	 * The cached value of the '{@link #getCellType() <em>Cell Type</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCellType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier cellType;

	/**
	 * The default value of the '{@link #getCellId() <em>Cell Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCellId()
	 * @generated
	 * @ordered
	 */
	protected static final String CELL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCellId() <em>Cell Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCellId()
	 * @generated
	 * @ordered
	 */
	protected String cellId = AbstractModelCellEditorImpl.CELL_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractModelCellEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelCellEditorPackage.Literals.ABSTRACT_MODEL_CELL_EDITOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClassifier getCellType() {
		if (this.cellType != null && this.cellType.eIsProxy()) {
			InternalEObject oldCellType = (InternalEObject) this.cellType;
			this.cellType = (EClassifier) eResolveProxy(oldCellType);
			if (this.cellType != oldCellType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE,
							oldCellType, this.cellType));
				}
			}
		}
		return this.cellType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClassifier basicGetCellType() {
		return this.cellType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCellType(final EClassifier newCellType) {
		EClassifier oldCellType = this.cellType;
		this.cellType = newCellType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE, oldCellType,
					this.cellType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCellId() {
		return this.cellId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCellId(final String newCellId) {
		String oldCellId = this.cellId;
		this.cellId = newCellId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID, oldCellId,
					this.cellId));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getModelCellEditorImpl() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE:
			if (resolve) {
				return getCellType();
			}
			return basicGetCellType();
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID:
			return getCellId();
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
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE:
			setCellType((EClassifier) newValue);
			return;
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID:
			setCellId((String) newValue);
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
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE:
			setCellType((EClassifier) null);
			return;
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID:
			setCellId(AbstractModelCellEditorImpl.CELL_ID_EDEFAULT);
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
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE:
			return this.cellType != null;
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID:
			return AbstractModelCellEditorImpl.CELL_ID_EDEFAULT == null ? this.cellId != null
					: !AbstractModelCellEditorImpl.CELL_ID_EDEFAULT.equals(this.cellId);
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
		result.append(" (cellId: "); //$NON-NLS-1$
		result.append(this.cellId);
		result.append(')');
		return result.toString();
	}

} // AbstractModelCellEditorImpl
