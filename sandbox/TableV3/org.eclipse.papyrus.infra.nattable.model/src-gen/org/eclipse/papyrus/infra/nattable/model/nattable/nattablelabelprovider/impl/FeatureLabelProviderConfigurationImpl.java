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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Label Provider Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl#getLabelProviderContext <em>Label Provider Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl#isDisplayIcon <em>Display Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl#isDisplayIsDerived <em>Display Is Derived</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl#isDisplayType <em>Display Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl#isDisplayMultiplicity <em>Display Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureLabelProviderConfigurationImpl extends EModelElementImpl implements FeatureLabelProviderConfiguration {
	/**
	 * The default value of the '{@link #getLabelProviderContext() <em>Label Provider Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelProviderContext()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_PROVIDER_CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabelProviderContext() <em>Label Provider Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelProviderContext()
	 * @generated
	 * @ordered
	 */
	protected String labelProviderContext = LABEL_PROVIDER_CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayIcon() <em>Display Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayIcon()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_ICON_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayIcon() <em>Display Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayIcon()
	 * @generated
	 * @ordered
	 */
	protected boolean displayIcon = DISPLAY_ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayIsDerived() <em>Display Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayIsDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_IS_DERIVED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayIsDerived() <em>Display Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayIsDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean displayIsDerived = DISPLAY_IS_DERIVED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayType() <em>Display Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_TYPE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayType() <em>Display Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayType()
	 * @generated
	 * @ordered
	 */
	protected boolean displayType = DISPLAY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisplayMultiplicity() <em>Display Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISPLAY_MULTIPLICITY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisplayMultiplicity() <em>Display Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisplayMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected boolean displayMultiplicity = DISPLAY_MULTIPLICITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureLabelProviderConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NattablelabelproviderPackage.Literals.FEATURE_LABEL_PROVIDER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabelProviderContext() {
		return labelProviderContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelProviderContext(String newLabelProviderContext) {
		String oldLabelProviderContext = labelProviderContext;
		labelProviderContext = newLabelProviderContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__LABEL_PROVIDER_CONTEXT, oldLabelProviderContext, labelProviderContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayIcon() {
		return displayIcon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayIcon(boolean newDisplayIcon) {
		boolean oldDisplayIcon = displayIcon;
		displayIcon = newDisplayIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON, oldDisplayIcon, displayIcon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayIsDerived() {
		return displayIsDerived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayIsDerived(boolean newDisplayIsDerived) {
		boolean oldDisplayIsDerived = displayIsDerived;
		displayIsDerived = newDisplayIsDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED, oldDisplayIsDerived, displayIsDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayType() {
		return displayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayType(boolean newDisplayType) {
		boolean oldDisplayType = displayType;
		displayType = newDisplayType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE, oldDisplayType, displayType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisplayMultiplicity() {
		return displayMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayMultiplicity(boolean newDisplayMultiplicity) {
		boolean oldDisplayMultiplicity = displayMultiplicity;
		displayMultiplicity = newDisplayMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY, oldDisplayMultiplicity, displayMultiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__LABEL_PROVIDER_CONTEXT:
				return getLabelProviderContext();
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
				return isDisplayIcon();
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED:
				return isDisplayIsDerived();
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE:
				return isDisplayType();
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY:
				return isDisplayMultiplicity();
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
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__LABEL_PROVIDER_CONTEXT:
				setLabelProviderContext((String)newValue);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
				setDisplayIcon((Boolean)newValue);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED:
				setDisplayIsDerived((Boolean)newValue);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE:
				setDisplayType((Boolean)newValue);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY:
				setDisplayMultiplicity((Boolean)newValue);
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
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__LABEL_PROVIDER_CONTEXT:
				setLabelProviderContext(LABEL_PROVIDER_CONTEXT_EDEFAULT);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
				setDisplayIcon(DISPLAY_ICON_EDEFAULT);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED:
				setDisplayIsDerived(DISPLAY_IS_DERIVED_EDEFAULT);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE:
				setDisplayType(DISPLAY_TYPE_EDEFAULT);
				return;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY:
				setDisplayMultiplicity(DISPLAY_MULTIPLICITY_EDEFAULT);
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
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__LABEL_PROVIDER_CONTEXT:
				return LABEL_PROVIDER_CONTEXT_EDEFAULT == null ? labelProviderContext != null : !LABEL_PROVIDER_CONTEXT_EDEFAULT.equals(labelProviderContext);
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON:
				return displayIcon != DISPLAY_ICON_EDEFAULT;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED:
				return displayIsDerived != DISPLAY_IS_DERIVED_EDEFAULT;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE:
				return displayType != DISPLAY_TYPE_EDEFAULT;
			case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY:
				return displayMultiplicity != DISPLAY_MULTIPLICITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EObjectLabelProviderConfiguration.class) {
			switch (derivedFeatureID) {
				case NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON: return NattablelabelproviderPackage.EOBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EObjectLabelProviderConfiguration.class) {
			switch (baseFeatureID) {
				case NattablelabelproviderPackage.EOBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON: return NattablelabelproviderPackage.FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (labelProviderContext: "); //$NON-NLS-1$
		result.append(labelProviderContext);
		result.append(", displayIcon: "); //$NON-NLS-1$
		result.append(displayIcon);
		result.append(", displayIsDerived: "); //$NON-NLS-1$
		result.append(displayIsDerived);
		result.append(", displayType: "); //$NON-NLS-1$
		result.append(displayType);
		result.append(", displayMultiplicity: "); //$NON-NLS-1$
		result.append(displayMultiplicity);
		result.append(')');
		return result.toString();
	}

} //FeatureLabelProviderConfigurationImpl
