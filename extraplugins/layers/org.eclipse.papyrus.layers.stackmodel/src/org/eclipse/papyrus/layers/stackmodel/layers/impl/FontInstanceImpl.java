/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.layers.stackmodel.layers.FontInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#getFontName <em>Font Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#getFontHeigh <em>Font Heigh</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.impl.FontInstanceImpl#isBold <em>Bold</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FontInstanceImpl extends TypeInstanceImpl implements FontInstance {
	/**
	 * The default value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_COLOR_EDEFAULT = 15053796;

	/**
	 * The cached value of the '{@link #getFontColor() <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected int fontColor = FONT_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontName() <em>Font Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontName()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_NAME_EDEFAULT = "Segoe UI";

	/**
	 * The cached value of the '{@link #getFontName() <em>Font Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontName()
	 * @generated
	 * @ordered
	 */
	protected String fontName = FONT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontHeigh() <em>Font Heigh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontHeigh()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_HEIGH_EDEFAULT = 9;

	/**
	 * The cached value of the '{@link #getFontHeigh() <em>Font Heigh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontHeigh()
	 * @generated
	 * @ordered
	 */
	protected int fontHeigh = FONT_HEIGH_EDEFAULT;

	/**
	 * The default value of the '{@link #isBold() <em>Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBold()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOLD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isBold() <em>Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBold()
	 * @generated
	 * @ordered
	 */
	protected boolean bold = BOLD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayersPackage.Literals.FONT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFontColor() {
		return fontColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontColor(int newFontColor) {
		int oldFontColor = fontColor;
		fontColor = newFontColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.FONT_INSTANCE__FONT_COLOR, oldFontColor, fontColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFontName() {
		return fontName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontName(String newFontName) {
		String oldFontName = fontName;
		fontName = newFontName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.FONT_INSTANCE__FONT_NAME, oldFontName, fontName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFontHeigh() {
		return fontHeigh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontHeigh(int newFontHeigh) {
		int oldFontHeigh = fontHeigh;
		fontHeigh = newFontHeigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.FONT_INSTANCE__FONT_HEIGH, oldFontHeigh, fontHeigh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBold() {
		return bold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBold(boolean newBold) {
		boolean oldBold = bold;
		bold = newBold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayersPackage.FONT_INSTANCE__BOLD, oldBold, bold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LayersPackage.FONT_INSTANCE__FONT_COLOR:
				return getFontColor();
			case LayersPackage.FONT_INSTANCE__FONT_NAME:
				return getFontName();
			case LayersPackage.FONT_INSTANCE__FONT_HEIGH:
				return getFontHeigh();
			case LayersPackage.FONT_INSTANCE__BOLD:
				return isBold();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LayersPackage.FONT_INSTANCE__FONT_COLOR:
				setFontColor((Integer)newValue);
				return;
			case LayersPackage.FONT_INSTANCE__FONT_NAME:
				setFontName((String)newValue);
				return;
			case LayersPackage.FONT_INSTANCE__FONT_HEIGH:
				setFontHeigh((Integer)newValue);
				return;
			case LayersPackage.FONT_INSTANCE__BOLD:
				setBold((Boolean)newValue);
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
			case LayersPackage.FONT_INSTANCE__FONT_COLOR:
				setFontColor(FONT_COLOR_EDEFAULT);
				return;
			case LayersPackage.FONT_INSTANCE__FONT_NAME:
				setFontName(FONT_NAME_EDEFAULT);
				return;
			case LayersPackage.FONT_INSTANCE__FONT_HEIGH:
				setFontHeigh(FONT_HEIGH_EDEFAULT);
				return;
			case LayersPackage.FONT_INSTANCE__BOLD:
				setBold(BOLD_EDEFAULT);
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
			case LayersPackage.FONT_INSTANCE__FONT_COLOR:
				return fontColor != FONT_COLOR_EDEFAULT;
			case LayersPackage.FONT_INSTANCE__FONT_NAME:
				return FONT_NAME_EDEFAULT == null ? fontName != null : !FONT_NAME_EDEFAULT.equals(fontName);
			case LayersPackage.FONT_INSTANCE__FONT_HEIGH:
				return fontHeigh != FONT_HEIGH_EDEFAULT;
			case LayersPackage.FONT_INSTANCE__BOLD:
				return bold != BOLD_EDEFAULT;
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
		result.append(" (fontColor: ");
		result.append(fontColor);
		result.append(", fontName: ");
		result.append(fontName);
		result.append(", fontHeigh: ");
		result.append(fontHeigh);
		result.append(", bold: ");
		result.append(bold);
		result.append(')');
		return result.toString();
	}

} //FontInstanceImpl
