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
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.cdo.core.importer.IModelImportConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelImportOperation;
import org.eclipse.papyrus.cdo.core.importer.IModelImporter;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.statushandlers.StatusManager;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * This is the ModelImportWizard type. Enjoy.
 */
public class ModelImportWizard
		extends Wizard
		implements IWorkbenchWizard {

	private ModelReferencesPage referencesPage;

	private RepositorySelectionPage repositoryPage;

	private ModelMappingsPage mappingsPage;

	private IStructuredSelection selection;

	private IModelImportConfiguration importConfig;

	public ModelImportWizard() {
		super();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;

		setWindowTitle("Import Models into Repository");
		setNeedsProgressMonitor(true);
		setHelpAvailable(false);
	}

	@Override
	public void addPages() {
		importConfig = IModelImportConfiguration.Factory.DEFAULT
			.create(new WizardOperationContext());

		final EventBus bus = new EventBus("importWizard");

		referencesPage = new ModelReferencesPage(bus);
		addPage(referencesPage);

		repositoryPage = new RepositorySelectionPage(bus);
		addPage(repositoryPage);

		mappingsPage = new ModelMappingsPage(bus);
		addPage(mappingsPage);

		// start analyzing the selected models's dependencies after the wizard
		// has been presented
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				for (IPapyrusFile next : getSelection()) {
					importConfig.addModelToImport(URI
						.createPlatformResourceURI(next.getMainFile()
							.getFullPath().toString(), true));
				}

				bus.post(importConfig);
			}
		});
	}

	Iterable<IPapyrusFile> getSelection() {
		List<IPapyrusFile> result = Lists.newArrayList();

		if (selection != null) {
			for (Object next : selection.toList()) {
				IPapyrusFile file = null;

				if (next instanceof IPapyrusFile) {
					file = (IPapyrusFile) next;
				} else if (next instanceof IAdaptable) {
					file = (IPapyrusFile) ((IAdaptable) next)
						.getAdapter(IPapyrusFile.class);
				}

				if (file != null) {
					result.add(file);
				}
			}
		}

		return result;
	}

	@Override
	public boolean performFinish() {
		boolean result = true;

		IModelImporter importer = IModelImporter.Factory.DEFAULT.create();
		Diagnostic problems = importer.importModels(mappingsPage
			.getSelectedMapping());

		if (problems.getSeverity() > Diagnostic.INFO) {
			StatusManager.getManager().handle(
				BasicDiagnostic.toIStatus(problems), StatusManager.SHOW);
		}

		return result;
	}

	@Override
	public void dispose() {
		if (importConfig != null) {
			// it actually takes a while to dispose this, unloading all of the
			// resources potentially covering all of the Papyrus models in the
			// workspace in order to clean up the UML CacheAdapter
			final IModelImportConfiguration configuration = importConfig;
			new Job("Clean up model import configuration") {

				{
					setSystem(true);
				}

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					configuration.dispose();
					return Status.OK_STATUS;
				}
			};
			importConfig = null;
		}

		super.dispose();
	}

	//
	// Nested types
	//

	private class WizardOperationContext
			implements IModelImportOperation.Context {

		public Diagnostic run(final IModelImportOperation operation) {
			final Diagnostic[] result = {Diagnostic.OK_INSTANCE};

			try {
				getContainer().run(true, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {

						result[0] = operation.run(new UISafeProgressMonitor(
							monitor));
					}
				});
			} catch (Exception e) {
				result[0] = new BasicDiagnostic(Diagnostic.ERROR,
					Activator.PLUGIN_ID, 0,
					"Model import operation execution failed.", new Object[]{e});
				StatusManager.getManager().handle(
					BasicDiagnostic.toIStatus(result[0]), StatusManager.SHOW);
			}

			return result[0];
		}
	}

	private static class UISafeProgressMonitor
			implements IProgressMonitor {

		private final Display display = Display.getDefault();

		private final IProgressMonitor delegate;

		UISafeProgressMonitor(IProgressMonitor delegate) {
			this.delegate = delegate;
		}

		private void exec(Runnable runnable) {
			if (Display.getCurrent() == display) {
				runnable.run();
			} else {
				display.syncExec(runnable);
			}
		}

		public void beginTask(final String name, final int totalWork) {
			exec(new Runnable() {

				public void run() {
					delegate.beginTask(name, totalWork);
				}
			});
		}

		public void internalWorked(final double work) {
			exec(new Runnable() {

				public void run() {
					delegate.internalWorked(work);
				}
			});
		}

		public boolean isCanceled() {
			final boolean[] result = {false};

			exec(new Runnable() {

				public void run() {
					result[0] = delegate.isCanceled();
				}
			});

			return result[0];
		}

		public void setCanceled(final boolean value) {
			exec(new Runnable() {

				public void run() {
					delegate.setCanceled(value);
				}
			});
		}

		public void setTaskName(final String name) {
			exec(new Runnable() {

				public void run() {
					delegate.setTaskName(name);
				}
			});
		}

		public void subTask(final String name) {
			exec(new Runnable() {

				public void run() {
					delegate.subTask(name);
				}
			});
		}

		public void worked(final int work) {
			exec(new Runnable() {

				public void run() {
					delegate.worked(work);
				}
			});
		}

		public void done() {
			exec(new Runnable() {

				public void run() {
					done();
				}
			});
		}
	}
}
