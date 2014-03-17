/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 429242
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.importer.IModelImporter;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
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
public class ModelImportWizard extends Wizard implements IWorkbenchWizard {

	private ModelReferencesPage referencesPage;

	private RepositorySelectionPage repositoryPage;

	private ModelMappingsPage mappingsPage;

	private IStructuredSelection selection;

	private IModelTransferConfiguration importConfig;

	private IPapyrusRepository repository;

	public ModelImportWizard() {
		super();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;

		setWindowTitle(Messages.ModelImportWizard_0);
		setNeedsProgressMonitor(true);
		setHelpAvailable(false);
	}

	/**
	 * Set the initial selection of the repository to import into.
	 */
	public void setRepository(IPapyrusRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addPages() {
		importConfig = IModelTransferConfiguration.Factory.IMPORT.create(new WizardOperationContext(getShell().getDisplay(), this), null);

		final EventBus bus = new EventBus("importWizard"); //$NON-NLS-1$

		referencesPage = new ModelReferencesPage(bus, true);
		addPage(referencesPage);

		repositoryPage = new RepositorySelectionPage(bus);
		addPage(repositoryPage);

		mappingsPage = new ModelMappingsPage(bus);
		addPage(mappingsPage);

		// start analyzing the selected models's dependencies after the wizard
		// has been presented
		Display.getCurrent().asyncExec(new Runnable() {

			@Override
			public void run() {
				for(IPapyrusFile next : getSelection()) {
					importConfig.addModelToTransfer(URI.createPlatformResourceURI(next.getMainFile().getFullPath().toString(), true));
				}

				bus.post(importConfig);

				if(repository != null) {
					bus.post(repository);
				}
			}
		});
	}

	Iterable<IPapyrusFile> getSelection() {
		List<IPapyrusFile> result = Lists.newArrayList();

		if(selection != null) {
			for(Object next : selection.toList()) {
				IPapyrusFile file = null;

				if(next instanceof IPapyrusFile) {
					file = (IPapyrusFile)next;
				} else if(next instanceof IAdaptable) {
					file = (IPapyrusFile)((IAdaptable)next).getAdapter(IPapyrusFile.class);
				}

				if(file != null) {
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
		Diagnostic problems = importer.importModels(mappingsPage.getSelectedMapping());

		if(problems.getSeverity() > Diagnostic.INFO) {
			StatusManager.getManager().handle(BasicDiagnostic.toIStatus(problems), StatusManager.BLOCK);
		}

		return result;
	}

	@Override
	public void dispose() {
		if(importConfig != null) {
			// it actually takes a while to dispose this, unloading all of the
			// resources potentially covering all of the Papyrus models in the
			// workspace in order to clean up the UML CacheAdapter
			final IModelTransferConfiguration configuration = importConfig;
			new Job(Messages.ModelImportWizard_2) {

				{
					setSystem(true);
				}

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					configuration.dispose();
					return Status.OK_STATUS;
				}
			}.schedule();
			importConfig = null;
		}

		super.dispose();
	}

}
