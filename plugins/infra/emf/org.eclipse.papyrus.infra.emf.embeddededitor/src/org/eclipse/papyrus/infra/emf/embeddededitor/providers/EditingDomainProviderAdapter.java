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
package org.eclipse.papyrus.infra.emf.embeddededitor.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;


public class EditingDomainProviderAdapter implements IEditingDomainProvider, Adapter {

	private EditingDomain domain;

	public EditingDomainProviderAdapter(EditingDomain domain) {
		this.domain = domain;
	}

	public void notifyChanged(Notification notification) {
		//Nothing
	}

	public Notifier getTarget() {
		return null; //Nothing
	}

	public void setTarget(Notifier newTarget) {
		//Nothing
	}

	public boolean isAdapterForType(Object type) {
		return type == IEditingDomainProvider.class;
	}

	public EditingDomain getEditingDomain() {
		return domain;
	}

}
