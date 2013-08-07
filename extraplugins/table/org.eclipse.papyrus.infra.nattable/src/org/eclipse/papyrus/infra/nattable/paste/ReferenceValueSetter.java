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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.paste;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A structure which is used to store values to set for a given feature and a given object
 * 
 * @author vl222926
 * 
 */
public class ReferenceValueSetter {

	/**
	 * the feature to edit
	 */
	private final EReference eReference;

	/**
	 * the edited object
	 */
	private final EObject editedObject;

	/**
	 * the new value
	 */
	private final Object value;

	/**
	 * if true, the current value will be erased
	 */
	private final boolean eraseExistingMultiValueValue;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editedObject
	 *        the edited object
	 * @param feature
	 *        the edited feature
	 * @param value
	 *        the value for this feature. If the feature is multivalued, the newValue will be added to the existing value
	 */
	public ReferenceValueSetter(final EObject editedObject, final EReference feature, final Object value) {
		this(editedObject, feature, value, false);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editedObject
	 *        the edited object
	 * @param feature
	 *        the edited feature
	 * @param tutu
	 *        the value for this feature.
	 * @param eraseExistingMultiValueValue
	 *        if <code>true</code>, in case of multivalued references, the current value will be replaced by {@code tutu} , if <code>false</code> we
	 *        will add {@code tutu} to the current value
	 *        , will be added to the current value
	 */
	public ReferenceValueSetter(final EObject editedObject, final EReference feature, final Object tutu, final boolean eraseExistingMultiValueValue) {
		this.eReference = feature;
		this.editedObject = editedObject;
		this.value = tutu;
		this.eraseExistingMultiValueValue = eraseExistingMultiValueValue;
	}

	/**
	 * set the value of the reference
	 * 
	 * @param domain
	 *        the editing domain used to do the action
	 */
	public void setReferenceValue(final EditingDomain domain) {
		if(this.eReference.isMany() && !this.eraseExistingMultiValueValue && this.value instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>)value;
			AddCommand.create(domain, editedObject, eReference, collection).execute();
		} else {
			SetCommand.create(domain, editedObject, eReference, value).execute();
		}
	}
}
