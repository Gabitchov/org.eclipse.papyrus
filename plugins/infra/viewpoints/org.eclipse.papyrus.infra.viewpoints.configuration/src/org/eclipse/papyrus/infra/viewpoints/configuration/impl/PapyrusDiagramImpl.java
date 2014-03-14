/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.ElementImport;
import org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl#getCustomPalette <em>Custom Palette</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl#getCustomStyle <em>Custom Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl#getChildRules <em>Child Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl#getPaletteRules <em>Palette Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.impl.PapyrusDiagramImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusDiagramImpl extends PapyrusViewImpl implements PapyrusDiagram {
	/**
	 * The default value of the '{@link #getCustomPalette() <em>Custom Palette</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomPalette()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_PALETTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomPalette() <em>Custom Palette</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomPalette()
	 * @generated
	 * @ordered
	 */
	protected String customPalette = CUSTOM_PALETTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCustomStyle() <em>Custom Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String CUSTOM_STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCustomStyle() <em>Custom Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomStyle()
	 * @generated
	 * @ordered
	 */
	protected String customStyle = CUSTOM_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildRules() <em>Child Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildRules()
	 * @generated
	 * @ordered
	 */
	protected EList<ChildRule> childRules;

	/**
	 * The cached value of the '{@link #getPaletteRules() <em>Palette Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaletteRules()
	 * @generated
	 * @ordered
	 */
	protected EList<PaletteRule> paletteRules;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementImport> imports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PAPYRUS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomPalette() {
		return customPalette;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomPalette(String newCustomPalette) {
		String oldCustomPalette = customPalette;
		customPalette = newCustomPalette;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_PALETTE, oldCustomPalette, customPalette));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCustomStyle() {
		return customStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomStyle(String newCustomStyle) {
		String oldCustomStyle = customStyle;
		customStyle = newCustomStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE, oldCustomStyle, customStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChildRule> getChildRules() {
		if (childRules == null) {
			childRules = new EObjectContainmentEList<ChildRule>(ChildRule.class, this, ConfigurationPackage.PAPYRUS_DIAGRAM__CHILD_RULES);
		}
		return childRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PaletteRule> getPaletteRules() {
		if (paletteRules == null) {
			paletteRules = new EObjectContainmentEList<PaletteRule>(PaletteRule.class, this, ConfigurationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES);
		}
		return paletteRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementImport> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ElementImport>(ElementImport.class, this, ConfigurationPackage.PAPYRUS_DIAGRAM__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				return ((InternalEList<?>)getChildRules()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				return ((InternalEList<?>)getPaletteRules()).basicRemove(otherEnd, msgs);
			case ConfigurationPackage.PAPYRUS_DIAGRAM__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_PALETTE:
				return getCustomPalette();
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				return getCustomStyle();
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				return getChildRules();
			case ConfigurationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				return getPaletteRules();
			case ConfigurationPackage.PAPYRUS_DIAGRAM__IMPORTS:
				return getImports();
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
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_PALETTE:
				setCustomPalette((String)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				setCustomStyle((String)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				getChildRules().clear();
				getChildRules().addAll((Collection<? extends ChildRule>)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				getPaletteRules().clear();
				getPaletteRules().addAll((Collection<? extends PaletteRule>)newValue);
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends ElementImport>)newValue);
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
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_PALETTE:
				setCustomPalette(CUSTOM_PALETTE_EDEFAULT);
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				setCustomStyle(CUSTOM_STYLE_EDEFAULT);
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				getChildRules().clear();
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				getPaletteRules().clear();
				return;
			case ConfigurationPackage.PAPYRUS_DIAGRAM__IMPORTS:
				getImports().clear();
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
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_PALETTE:
				return CUSTOM_PALETTE_EDEFAULT == null ? customPalette != null : !CUSTOM_PALETTE_EDEFAULT.equals(customPalette);
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CUSTOM_STYLE:
				return CUSTOM_STYLE_EDEFAULT == null ? customStyle != null : !CUSTOM_STYLE_EDEFAULT.equals(customStyle);
			case ConfigurationPackage.PAPYRUS_DIAGRAM__CHILD_RULES:
				return childRules != null && !childRules.isEmpty();
			case ConfigurationPackage.PAPYRUS_DIAGRAM__PALETTE_RULES:
				return paletteRules != null && !paletteRules.isEmpty();
			case ConfigurationPackage.PAPYRUS_DIAGRAM__IMPORTS:
				return imports != null && !imports.isEmpty();
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
		result.append(" (customPalette: ");
		result.append(customPalette);
		result.append(", customStyle: ");
		result.append(customStyle);
		result.append(')');
		return result.toString();
	}

} //PapyrusDiagramImpl
