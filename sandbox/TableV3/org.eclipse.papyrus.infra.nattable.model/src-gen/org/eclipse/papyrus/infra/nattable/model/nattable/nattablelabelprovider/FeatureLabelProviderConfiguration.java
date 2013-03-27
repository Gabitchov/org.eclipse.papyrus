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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Label Provider Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayIsDerived <em>Display Is Derived</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayType <em>Display Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayMultiplicity <em>Display Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayName <em>Display Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getFeatureLabelProviderConfiguration()
 * @model
 * @generated
 */
public interface FeatureLabelProviderConfiguration extends EObjectLabelProviderConfiguration {
	/**
	 * Returns the value of the '<em><b>Display Is Derived</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Is Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Is Derived</em>' attribute.
	 * @see #setDisplayIsDerived(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getFeatureLabelProviderConfiguration_DisplayIsDerived()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayIsDerived();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayIsDerived <em>Display Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Is Derived</em>' attribute.
	 * @see #isDisplayIsDerived()
	 * @generated
	 */
	void setDisplayIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Type</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Type</em>' attribute.
	 * @see #setDisplayType(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getFeatureLabelProviderConfiguration_DisplayType()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayType <em>Display Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Type</em>' attribute.
	 * @see #isDisplayType()
	 * @generated
	 */
	void setDisplayType(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Multiplicity</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Multiplicity</em>' attribute.
	 * @see #setDisplayMultiplicity(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getFeatureLabelProviderConfiguration_DisplayMultiplicity()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayMultiplicity <em>Display Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Multiplicity</em>' attribute.
	 * @see #isDisplayMultiplicity()
	 * @generated
	 */
	void setDisplayMultiplicity(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getFeatureLabelProviderConfiguration_DisplayName()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #isDisplayName()
	 * @generated
	 */
	void setDisplayName(boolean value);

} // FeatureLabelProviderConfiguration
