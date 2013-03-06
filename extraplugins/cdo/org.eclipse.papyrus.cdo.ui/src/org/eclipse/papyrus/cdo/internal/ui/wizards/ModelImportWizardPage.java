/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.cdo.internal.ui.Activator;

import com.google.common.eventbus.EventBus;

/**
 * This is the ModelImportWizardPage type. Enjoy.
 */
abstract class ModelImportWizardPage
		extends WizardPage {

	private final EventBus bus;

	private String message;

	public ModelImportWizardPage(String name, String title,
			ImageDescriptor image, EventBus bus, String message) {
		super(name, title, image);

		this.bus = bus;
		this.message = message;

		bus.register(this);
		setMessage(message);
	}

	void validatePage() {
		setMessage(mostSevere(doValidatePage()));
	}

	protected Diagnostic doValidatePage() {
		return Diagnostic.OK_INSTANCE;
	}

	protected Diagnostic report(int severity, String message) {
		return new BasicDiagnostic(severity, Activator.PLUGIN_ID, 0, message,
			null);
	}

	Diagnostic mostSevere(Diagnostic diagnostic) {
		Diagnostic result = diagnostic;

		for (Diagnostic next : diagnostic.getChildren()) {
			if (next.getSeverity() == result.getSeverity()) {
				result = next;
				break;
			}
		}

		return result;
	}

	void setMessage(Diagnostic diagnostic) {
		int messageType;
		String message;

		switch (diagnostic.getSeverity()) {
			case Diagnostic.OK :
				messageType = IMessageProvider.NONE;
				message = this.message;
				break;
			case Diagnostic.INFO :
				messageType = IMessageProvider.INFORMATION;
				message = diagnostic.getMessage();
				break;
			case Diagnostic.WARNING :
				messageType = IMessageProvider.WARNING;
				message = diagnostic.getMessage();
				break;
			case Diagnostic.CANCEL :
				// an OK condition, but we can't finish the page even so
				messageType = IMessageProvider.INFORMATION;
				message = diagnostic.getMessage();
				break;
			default :
				messageType = IMessageProvider.ERROR;
				message = diagnostic.getMessage();
				break;
		}

		// OK_INSTANCE and CANCEL_INSTANCE have useless messages
		if ((diagnostic == Diagnostic.OK_INSTANCE)
			|| (diagnostic == Diagnostic.CANCEL_INSTANCE)) {

			message = this.message;
		}

		setMessage(message, messageType);
		setPageComplete(diagnostic.getSeverity() < Diagnostic.ERROR);
	}

	protected void post(Object event) {
		bus.post(event);
	}
	
	protected EventBus getEventBus() {
		return bus;
	}
}
