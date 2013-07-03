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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Axis Provider</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Abstract Element for the AxisProvider. This one only provides a method getAxis().
 * <!-- end-model-doc -->
 * 
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage#getAbstractAxisProvider()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAxisProvider extends EModelElement, TableNamedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method must returns the IAxis owned by the AxisProvider.
	 * Warning, in case of syncrhonized table, the list often will be empty. This method
	 * only returns the IAxis serialized in the model. Displayed elements are not necessary serialized.
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	EList<IAxis> getAxis();

} // AbstractAxisProvider
