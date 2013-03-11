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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.util.UISafeProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;

public class WizardOperationContext implements IModelTransferOperation.Context {

	private final Display display;

	private final Wizard wizard;

	public WizardOperationContext(Display display, Wizard wizard) {
		super();

		this.display = display;
		this.wizard = wizard;
	}

	public Diagnostic run(final IModelTransferOperation operation) {
		final Diagnostic[] result = { Diagnostic.OK_INSTANCE };

		try {
			getContainer().run(true, false, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					result[0] = operation.run(new UISafeProgressMonitor(monitor, display));
				}
			});
		} catch (Exception e) {
			result[0] = new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, Messages.WizardOperationContext_0, new Object[]{ e });
			StatusManager.getManager().handle(BasicDiagnostic.toIStatus(result[0]), StatusManager.SHOW);
		}

		return result[0];
	}

	protected IWizardContainer getContainer() {
		return wizard.getContainer();
	}
}
