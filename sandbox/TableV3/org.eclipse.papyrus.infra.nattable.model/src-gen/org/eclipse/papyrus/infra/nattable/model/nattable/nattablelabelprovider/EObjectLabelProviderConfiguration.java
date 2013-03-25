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
 * A representation of the model object '<em><b>EObject Label Provider Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration#isDisplayIcon <em>Display Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration#isDisplayText <em>Display Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getEObjectLabelProviderConfiguration()
 * @model
 * @generated
 */
public interface EObjectLabelProviderConfiguration extends ILabelConfiguration {
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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getEObjectLabelProviderConfiguration_DisplayIcon()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration#isDisplayIcon <em>Display Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Icon</em>' attribute.
	 * @see #isDisplayIcon()
	 * @generated
	 */
	void setDisplayIcon(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Text</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Text</em>' attribute.
	 * @see #setDisplayText(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#getEObjectLabelProviderConfiguration_DisplayText()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayText();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration#isDisplayText <em>Display Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Text</em>' attribute.
	 * @see #isDisplayText()
	 * @generated
	 */
	void setDisplayText(boolean value);

} // EObjectLabelProviderConfiguration
