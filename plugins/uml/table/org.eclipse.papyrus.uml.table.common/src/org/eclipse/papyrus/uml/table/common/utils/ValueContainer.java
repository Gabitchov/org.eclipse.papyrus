/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.table.common.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.internal.CommonCoreStatusCodes;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.papyrus.uml.table.common.Activator;
import org.eclipse.papyrus.uml.table.common.status.AbstractWarningPasteResultStatus;

/**
 * 
 * This class allows to store the value created for a pasted String AND a result status associated to this pasted String
 * 
 * @param <T>
 */
public class ValueContainer<T> {

	/**
	 * this field is used when the pasted value is monobalued
	 */
	private final T value;

	/**
	 * the resulting status of the parsing
	 */
	private final IStatus status;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param realValue
	 *        a monovalued Value (can be <code>null</code>)
	 * @param realListValue
	 *        a collection value (can be <code>null</code>)
	 * @param status
	 *        a status (can be <code>null</code>)
	 */
	public ValueContainer(final T realValue, final IStatus status) {
		this.value = realValue;
		if(status == null) {
			this.status = new Status(IStatus.OK, Activator.PLUGIN_ID, CommonCoreStatusCodes.OK, StringStatics.BLANK, null);
		} else {
			this.status = status;
		}
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param realValue
	 *        the value (can be <code>null</code>)
	 */
	public ValueContainer(final T realValue) {
		this(realValue, null);
	}


	/**
	 * This method
	 * 
	 * @param element
	 *        the element for which we are looking for its status (CAN'T BE <code>null</code>).
	 *        This argument is used to do {@link AbstractWarningPasteResultStatus#setElement(EObject)} to the referenced
	 *        {@link AbstractWarningPasteResultStatus}
	 * @return
	 *         the status resulting of the parsing of the pasted string
	 */
	public IStatus getStatus(final EObject element) {
		if(this.status instanceof AbstractWarningPasteResultStatus) {
			((AbstractWarningPasteResultStatus)this.status).setElement(element);
		}
		return this.status;
	}

	/**
	 * 
	 * @return
	 *         the value
	 */
	public Object getValue() {
		return this.value;
	}
}