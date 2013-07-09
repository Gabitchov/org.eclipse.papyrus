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
package org.eclipse.papyrus.infra.nattable.model.nattable.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.TableNamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paste Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.PasteProblemImpl#getPastedText <em>Pasted Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.PasteProblemImpl#getUnresolvedText <em>Unresolved Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PasteProblemImpl extends TableNamedElementImpl implements PasteProblem {
	/**
	 * The default value of the '{@link #getPastedText() <em>Pasted Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedText()
	 * @generated
	 * @ordered
	 */
	protected static final String PASTED_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPastedText() <em>Pasted Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPastedText()
	 * @generated
	 * @ordered
	 */
	protected String pastedText = PASTED_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnresolvedText() <em>Unresolved Text</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedText()
	 * @generated
	 * @ordered
	 */
	protected EList<String> unresolvedText;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PasteProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablePackage.Literals.PASTE_PROBLEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPastedText() {
		return pastedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPastedText(String newPastedText) {
		String oldPastedText = pastedText;
		pastedText = newPastedText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablePackage.PASTE_PROBLEM__PASTED_TEXT, oldPastedText, pastedText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUnresolvedText() {
		if (unresolvedText == null) {
			unresolvedText = new EDataTypeUniqueEList<String>(String.class, this, NattablePackage.PASTE_PROBLEM__UNRESOLVED_TEXT);
		}
		return unresolvedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattablePackage.PASTE_PROBLEM__PASTED_TEXT:
				return getPastedText();
			case NattablePackage.PASTE_PROBLEM__UNRESOLVED_TEXT:
				return getUnresolvedText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NattablePackage.PASTE_PROBLEM__PASTED_TEXT:
				setPastedText((String)newValue);
				return;
			case NattablePackage.PASTE_PROBLEM__UNRESOLVED_TEXT:
				getUnresolvedText().clear();
				getUnresolvedText().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NattablePackage.PASTE_PROBLEM__PASTED_TEXT:
				setPastedText(PASTED_TEXT_EDEFAULT);
				return;
			case NattablePackage.PASTE_PROBLEM__UNRESOLVED_TEXT:
				getUnresolvedText().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NattablePackage.PASTE_PROBLEM__PASTED_TEXT:
				return PASTED_TEXT_EDEFAULT == null ? pastedText != null : !PASTED_TEXT_EDEFAULT.equals(pastedText);
			case NattablePackage.PASTE_PROBLEM__UNRESOLVED_TEXT:
				return unresolvedText != null && !unresolvedText.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (pastedText: "); //$NON-NLS-1$
		result.append(pastedText);
		result.append(", unresolvedText: "); //$NON-NLS-1$
		result.append(unresolvedText);
		result.append(')');
		return result.toString();
	}

} //PasteProblemImpl
