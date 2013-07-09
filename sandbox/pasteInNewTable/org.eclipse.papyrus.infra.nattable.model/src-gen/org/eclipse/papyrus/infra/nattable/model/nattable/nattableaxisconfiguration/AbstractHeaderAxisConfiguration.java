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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Header Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract Class for the HeaderAxisConfiguration. This class provides : 
 * <ul><li>informations on the appearance of the header</li>
 * <li> a list of label configuration which can be used by the header</li>
 * <li> a list of axisConfiguration. These axis configuration are used to provide the contents of the axis</li>
 * </ul>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getIndexStyle <em>Index Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayFilter <em>Display Filter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayIndex <em>Display Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getOwnedLabelConfigurations <em>Owned Label Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getOwnedAxisConfigurations <em>Owned Axis Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='oneObjectLabelConfigurationTypes oneFeatureLabelConfigurationTypes'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot oneObjectLabelConfigurationTypes='ownedLabelConfigurations->collect(ilc : nattable::nattablelabelprovider::ILabelProviderConfiguration | ilc.oclAsType(nattable::nattablelabelprovider::ObjectLabelProviderConfiguration))->size() <= 1' oneFeatureLabelConfigurationTypes='ownedLabelConfigurations->collect(ilc : nattable::nattablelabelprovider::ILabelProviderConfiguration | ilc.oclAsType(nattable::nattablelabelprovider::FeatureLabelProviderConfiguration))->size() <= 1'"
 * @generated
 */
public interface AbstractHeaderAxisConfiguration extends EObject, EModelElement {

	/**
	 * Returns the value of the '<em><b>Index Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This value can't be null. Indicates how to display the index of the Axis : using letter or using number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Index Style</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @see #setIndexStyle(AxisIndexStyle)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration_IndexStyle()
	 * @model required="true"
	 * @generated
	 */
	AxisIndexStyle getIndexStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#getIndexStyle <em>Index Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Style</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @see #getIndexStyle()
	 * @generated
	 */
	void setIndexStyle(AxisIndexStyle value);

	/**
	 * Returns the value of the '<em><b>Display Label</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, the label header will be displayed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Label</em>' attribute.
	 * @see #setDisplayLabel(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration_DisplayLabel()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayLabel <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Label</em>' attribute.
	 * @see #isDisplayLabel()
	 * @generated
	 */
	void setDisplayLabel(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Filter</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true AND if the axisConfiguration is used as column, the row filter will be displayed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Filter</em>' attribute.
	 * @see #setDisplayFilter(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration_DisplayFilter()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDisplayFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayFilter <em>Display Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Filter</em>' attribute.
	 * @see #isDisplayFilter()
	 * @generated
	 */
	void setDisplayFilter(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Index</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If true, the index header will be displayed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Index</em>' attribute.
	 * @see #setDisplayIndex(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration_DisplayIndex()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration#isDisplayIndex <em>Display Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Index</em>' attribute.
	 * @see #isDisplayIndex()
	 * @generated
	 */
	void setDisplayIndex(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Label Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of the possible label configuration, referenced by the axis configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Label Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration_OwnedLabelConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ILabelProviderConfiguration> getOwnedLabelConfigurations();

	/**
	 * Returns the value of the '<em><b>Owned Axis Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of the owned axis configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Axis Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getAbstractHeaderAxisConfiguration_OwnedAxisConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<IAxisConfiguration> getOwnedAxisConfigurations();

} // AbstractHeaderAxisConfiguration
