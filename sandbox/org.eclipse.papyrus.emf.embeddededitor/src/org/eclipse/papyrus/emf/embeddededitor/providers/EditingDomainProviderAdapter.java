package org.eclipse.papyrus.emf.embeddededitor.providers;

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
