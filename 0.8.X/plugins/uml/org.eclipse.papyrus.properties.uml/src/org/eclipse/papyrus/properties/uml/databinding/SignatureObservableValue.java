/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.umlutils.MessageUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;


public class SignatureObservableValue extends AbstractObservableValue {

	private Message source;

	private TransactionalEditingDomain domain;

	public SignatureObservableValue(EObject source, EditingDomain domain) {
		if(!(source instanceof Message)) {
			throw new IllegalArgumentException("The source EObject must be a Message"); //$NON-NLS-1$
		}
		if(!(domain instanceof TransactionalEditingDomain)) {
			throw new IllegalArgumentException("The EditingDomain must be a TransactionalEditingDomain"); //$NON-NLS-1$
		}

		this.source = (Message)source;
		this.domain = (TransactionalEditingDomain)domain;
	}

	public Object getValueType() {
		return EObject.class;
	}

	@Override
	protected Object doGetValue() {
		return source.getSignature();
	}

	@Override
	protected void doSetValue(Object value) {
		try {
			if(value instanceof Operation) {
				Operation operation = (Operation)value;
				MessageUtil.setMessageSignature(source, operation, domain);
			} else if(value instanceof Signal) {
				Signal signal = (Signal)value;
				MessageUtil.setMessageSignature(source, signal, domain);
			} else if(value == null) {
				Object currentValue = doGetValue();
				if(currentValue instanceof Operation) {
					MessageUtil.setMessageSignature(source, (Operation)null, domain);
				} else if(currentValue instanceof Signal) {
					MessageUtil.setMessageSignature(source, (Signal)null, domain);
				}
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}
}
