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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Header Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl#getIndexStyle <em>Index Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl#isDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl#isDisplayFilter <em>Display Filter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl#isDisplayIndex <em>Display Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl#getOwnedLabelConfigurations <em>Owned Label Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractHeaderAxisConfigurationImpl#getOwnedAxisConfigurations <em>Owned Axis Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractHeaderAxisConfigurationImpl extends EModelElementImpl implements AbstractHeaderAxisConfiguration {
	/**
	 * The default value of the '{@link #getIndexStyle() <em>Index Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexStyle()
	 * @generated
	 * @ordered
	 */
	protected static final AxisIndexStyle INDEX_STYLE_EDEFAULT = AxisIndexStyle.ALPHABETIC;

	/**
	 * The cached value of the '{@link #getIndexStyle() <em>Index Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexStyle()
	 * @generated
	 * @ordered
	 */
	protected AxisIndexStyle indexStyle = INDEX_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayLabel() <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayLabel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_LABEL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayLabel() <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayLabel()
	 * @generated
	 * @ordered
	 */
	protected boolean displayLabel = DISPLAY_LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayFilter() <em>Display Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayFilter()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_FILTER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDisplayFilter() <em>Display Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayFilter()
	 * @generated
	 * @ordered
	 */
	protected boolean displayFilter = DISPLAY_FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayIndex() <em>Display Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayIndex()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_INDEX_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayIndex() <em>Display Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayIndex()
	 * @generated
	 * @ordered
	 */
	protected boolean displayIndex = DISPLAY_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedLabelConfigurations() <em>Owned Label Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLabelConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<ILabelProviderConfiguration> ownedLabelConfigurations;

	/**
	 * The cached value of the '{@link #getOwnedAxisConfigurations() <em>Owned Axis Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAxisConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<IAxisConfiguration> ownedAxisConfigurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractHeaderAxisConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisIndexStyle getIndexStyle() {
		return indexStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexStyle(AxisIndexStyle newIndexStyle) {
		AxisIndexStyle oldIndexStyle = indexStyle;
		indexStyle = newIndexStyle == null ? INDEX_STYLE_EDEFAULT : newIndexStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE, oldIndexStyle, indexStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayLabel() {
		return displayLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayLabel(boolean newDisplayLabel) {
		boolean oldDisplayLabel = displayLabel;
		displayLabel = newDisplayLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL, oldDisplayLabel, displayLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayFilter() {
		return displayFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayFilter(boolean newDisplayFilter) {
		boolean oldDisplayFilter = displayFilter;
		displayFilter = newDisplayFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER, oldDisplayFilter, displayFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayIndex() {
		return displayIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayIndex(boolean newDisplayIndex) {
		boolean oldDisplayIndex = displayIndex;
		displayIndex = newDisplayIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX, oldDisplayIndex, displayIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ILabelProviderConfiguration> getOwnedLabelConfigurations() {
		if (ownedLabelConfigurations == null) {
			ownedLabelConfigurations = new EObjectContainmentEList<ILabelProviderConfiguration>(ILabelProviderConfiguration.class, this, NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS);
		}
		return ownedLabelConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IAxisConfiguration> getOwnedAxisConfigurations() {
		if (ownedAxisConfigurations == null) {
			ownedAxisConfigurations = new EObjectContainmentEList<IAxisConfiguration>(IAxisConfiguration.class, this, NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS);
		}
		return ownedAxisConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS:
				return ((InternalEList<?>)getOwnedLabelConfigurations()).basicRemove(otherEnd, msgs);
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS:
				return ((InternalEList<?>)getOwnedAxisConfigurations()).basicRemove(otherEnd, msgs);
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
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE:
				return getIndexStyle();
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL:
				return isDisplayLabel();
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER:
				return isDisplayFilter();
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX:
				return isDisplayIndex();
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS:
				return getOwnedLabelConfigurations();
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS:
				return getOwnedAxisConfigurations();
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
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE:
				setIndexStyle((AxisIndexStyle)newValue);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL:
				setDisplayLabel((Boolean)newValue);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER:
				setDisplayFilter((Boolean)newValue);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX:
				setDisplayIndex((Boolean)newValue);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS:
				getOwnedLabelConfigurations().clear();
				getOwnedLabelConfigurations().addAll((Collection<? extends ILabelProviderConfiguration>)newValue);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS:
				getOwnedAxisConfigurations().clear();
				getOwnedAxisConfigurations().addAll((Collection<? extends IAxisConfiguration>)newValue);
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
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE:
				setIndexStyle(INDEX_STYLE_EDEFAULT);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL:
				setDisplayLabel(DISPLAY_LABEL_EDEFAULT);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER:
				setDisplayFilter(DISPLAY_FILTER_EDEFAULT);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX:
				setDisplayIndex(DISPLAY_INDEX_EDEFAULT);
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS:
				getOwnedLabelConfigurations().clear();
				return;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS:
				getOwnedAxisConfigurations().clear();
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
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__INDEX_STYLE:
				return indexStyle != INDEX_STYLE_EDEFAULT;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_LABEL:
				return displayLabel != DISPLAY_LABEL_EDEFAULT;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_FILTER:
				return displayFilter != DISPLAY_FILTER_EDEFAULT;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__DISPLAY_INDEX:
				return displayIndex != DISPLAY_INDEX_EDEFAULT;
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_LABEL_CONFIGURATIONS:
				return ownedLabelConfigurations != null && !ownedLabelConfigurations.isEmpty();
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION__OWNED_AXIS_CONFIGURATIONS:
				return ownedAxisConfigurations != null && !ownedAxisConfigurations.isEmpty();
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
		result.append(" (indexStyle: "); //$NON-NLS-1$
		result.append(indexStyle);
		result.append(", displayLabel: "); //$NON-NLS-1$
		result.append(displayLabel);
		result.append(", displayFilter: "); //$NON-NLS-1$
		result.append(displayFilter);
		result.append(", displayIndex: "); //$NON-NLS-1$
		result.append(displayIndex);
		result.append(')');
		return result.toString();
	}

} //AbstractHeaderAxisConfigurationImpl
