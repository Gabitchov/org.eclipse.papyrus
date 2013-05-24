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
 * A representation of the model object '<em><b>Object Label Provider Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayIcon <em>Display Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayLabel <em>Display Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getObjectLabelProviderConfiguration()
 * @model
 * @generated
 */
public interface ObjectLabelProviderConfiguration extends ILabelProviderConfiguration {
	/**
	 * Returns the value of the '<em><b>Display Icon</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Icon</em>' attribute.
	 * @see #setDisplayIcon(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getObjectLabelProviderConfiguration_DisplayIcon()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayIcon <em>Display Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Icon</em>' attribute.
	 * @see #isDisplayIcon()
	 * @generated
	 */
	void setDisplayIcon(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Label</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Label</em>' attribute.
	 * @see #setDisplayLabel(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getObjectLabelProviderConfiguration_DisplayLabel()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayLabel <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Label</em>' attribute.
	 * @see #isDisplayLabel()
	 * @generated
	 */
	void setDisplayLabel(boolean value);

} // ObjectLabelProviderConfiguration
