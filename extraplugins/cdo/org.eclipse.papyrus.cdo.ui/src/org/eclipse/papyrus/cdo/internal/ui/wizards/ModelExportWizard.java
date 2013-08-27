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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.exporter.IModelExporter;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.statushandlers.StatusManager;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;

/**
 * This is the ModelExportWizard type. Enjoy.
 */
public class ModelExportWizard extends Wizard implements IWorkbenchWizard {

	private final LocalRepositoryView localView = new LocalRepositoryView();

	private ModelReferencesPage referencesPage;

	private ModelExportMappingsPage mappingsPage;

	private IStructuredSelection selection;

	private IModelTransferConfiguration exportConfig;

	private IPapyrusRepository repository;

	private IContainer initialDestination;

	public ModelExportWizard() {
		super();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = localView.translate(selection);

		setWindowTitle(Messages.ModelExportWizard_0);
		setNeedsProgressMonitor(true);
		setHelpAvailable(false);
	}

	public void setInitialDestination(IContainer container) {
		this.initialDestination = container;
	}

	@Override
	public void addPages() {
		exportConfig = IModelTransferConfiguration.Factory.EXPORT.create(new WizardOperationContext(getShell().getDisplay(), this), getResourceSet(selection));

		final EventBus bus = new EventBus("exportWizard"); //$NON-NLS-1$

		referencesPage = new ModelReferencesPage(bus, false);
		addPage(referencesPage);

		mappingsPage = new ModelExportMappingsPage(bus);
		addPage(mappingsPage);

		if(initialDestination != null) {
			mappingsPage.setInitialDestination(initialDestination);
		}

		// start analyzing the selected models' dependencies after the wizard
		// has been presented
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				for(DIModel next : getSelection()) {
					exportConfig.addModelToTransfer(next.getResource().getURI());
				}

				bus.post(exportConfig);
				bus.post(repository);
			}
		});
	}

	Iterable<DIModel> getSelection() {
		Multimap<IPapyrusRepository, DIModel> result = ArrayListMultimap.create();

		if(selection != null) {
			for(Object next : selection.toList()) {
				DIModel model = CDOUtils.adapt(next, DIModel.class);

				if(model != null) {
					URI uri = model.getResource().getURI();
					IPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(uri);
					if(repository == null) {
						repository = repo;
					}

					if(repo != null) {
						result.put(repo, model);
					}
				}
			}
		}

		if(result.keySet().size() > 1) {
			MessageDialog.openInformation(getShell(), Messages.ModelExportWizard_2, NLS.bind(Messages.ModelExportWizard_3, repository.getName()));
		}

		return result.get(repository);
	}

	@Override
	public boolean performFinish() {
		boolean result = true;

		IModelExporter exporter = IModelExporter.Factory.DEFAULT.create();
		Diagnostic problems = exporter.exportModels(mappingsPage.getMapping());

		if(problems.getSeverity() > Diagnostic.INFO) {
			StatusManager.getManager().handle(BasicDiagnostic.toIStatus(problems), StatusManager.SHOW);
		}

		return result;
	}

	@Override
	public void dispose() {
		if(exportConfig != null) {
			// it actually takes a while to dispose this, unloading all of the
			// resources potentially covering all of the Papyrus models in the
			// workspace in order to clean up the UML CacheAdapter
			final IModelTransferConfiguration configuration = exportConfig;
			new Job(Messages.ModelExportWizard_4) {

				{
					setSystem(true);
				}

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					try {
						configuration.dispose();
					} finally {
						localView.dispose();
					}
					return Status.OK_STATUS;
				}
			}.schedule();
			exportConfig = null;
		}

		super.dispose();
	}

	ResourceSet getResourceSet(IStructuredSelection selection) {
		ResourceSet result = null;

		for(Object next : selection.toList()) {
			CDOResource resource = CDOUtils.adapt(next, CDOResource.class);
			if(resource != null) {
				result = resource.getResourceSet();
				break;
			}
		}

		return result;
	}
}
