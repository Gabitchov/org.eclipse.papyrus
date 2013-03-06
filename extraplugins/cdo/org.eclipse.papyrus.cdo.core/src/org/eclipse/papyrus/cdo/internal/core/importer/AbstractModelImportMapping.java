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
package org.eclipse.papyrus.cdo.internal.core.importer;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.importer.IModelImportConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelImportListener;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMappingListener;
import org.eclipse.papyrus.cdo.core.importer.IModelImportNode;
import org.eclipse.papyrus.cdo.core.importer.ModelImportListenerAdapter;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;

/**
 * This is the AbstractModelImportMapping type. Enjoy.
 */
abstract class AbstractModelImportMapping
		implements IModelImportMapping {

	private final IModelImportConfiguration config;

	private IPapyrusRepository repository;

	private final CopyOnWriteArrayList<IModelImportMappingListener> listeners = new CopyOnWriteArrayList<IModelImportMappingListener>();

	public AbstractModelImportMapping(IModelImportConfiguration config) {
		super();

		this.config = config;

		config.addModelImportListener(createConfigurationListener());
	}

	public IModelImportConfiguration getConfiguration() {
		return config;
	}

	public IPapyrusRepository getRepository() {
		return repository;
	}

	public void setRepository(IPapyrusRepository repository) {
		if (repository != this.repository) {
			this.repository = repository;

			fireRepositoryChanged();
		}
	}

	public Diagnostic validate() {
		BasicDiagnostic result = new BasicDiagnostic();

		if (validateRepository(result)) {
			for (IModelImportNode node : getConfiguration().getModelsToImport()) {
				validateMapping(node, result);
			}
		}

		fireProblemsEvent(result);

		return result;
	}

	protected boolean validateRepository(DiagnosticChain diagnostics) {
		boolean result = true;

		if (getRepository() == null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
				Activator.PLUGIN_ID, 0, "No repository specified for import.",
				null));
			result = false;
		} else if (!getRepository().isConnected()) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
				Activator.PLUGIN_ID, 0, NLS.bind(
					"Repository \"{0}\" is not connected.",
					repository.getName()), new Object[]{repository}));
			result = false;
		}

		return result;
	}

	protected boolean validateMapping(IModelImportNode node,
			DiagnosticChain diagnostics) {

		boolean result = true;

		IPath mapping = getMapping(node);
		if (mapping == null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
				Activator.PLUGIN_ID, 0, NLS.bind(
					"No mapping specified for {0}", node.getName()),
				new Object[]{node}));
			result = false;
		} else {
			for (URI next : node.getResourceURIs()) {
				String resourcePath = mapping.removeFileExtension()
					.addFileExtension(next.fileExtension()).toString();
				
				if (getView().hasResource(resourcePath)) {
					diagnostics
						.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							Activator.PLUGIN_ID,
							0,
							NLS.bind(
								"Resource already exists at mapping \"{0}\" for {1}",
								mapping, node.getName()), new Object[]{node}));
					result = false;
					break;
				}
			}
		}

		return result;
	}

	public void addModelImportMappingListener(
			IModelImportMappingListener listener) {

		listeners.addIfAbsent(listener);
	}

	public void removeModelImportMappingListener(
			IModelImportMappingListener listener) {

		listeners.remove(listener);
	}

	protected CDOView getView() {
		IInternalPapyrusRepository repo = (IInternalPapyrusRepository) getRepository();

		return (repo == null)
			? null
			: repo.getMasterView();
	}

	protected void fireRepositoryChanged() {
		for (IModelImportMappingListener next : listeners) {
			try {
				next.modelImportRepositoryChanged(this);
			} catch (Exception e) {
				Activator.log.error(
					"Uncaught exception in model import mapping listener.", e);
			}
		}
	}

	protected void fireProblemsEvent(Diagnostic problems) {
		if (problems.getSeverity() > Diagnostic.OK) {
			for (IModelImportMappingListener next : listeners) {
				try {
					next.modelImportMappingProblemsOccurred(problems);
				} catch (Exception e) {
					Activator.log.error(
						"Uncaught exception in model import mapping listener.",
						e);
				}
			}
		}
	}

	protected void fireMappingChanged(IModelImportNode node) {
		for (IModelImportMappingListener next : listeners) {
			try {
				next.modelImportMappingChanged(node);
			} catch (Exception e) {
				Activator.log.error(
					"Uncaught exception in model import mapping listener.", e);
			}
		}
	}

	private IModelImportListener createConfigurationListener() {
		return new ModelImportListenerAdapter() {

			@Override
			public void modelsToImportChanged(
					IModelImportConfiguration configuration) {

				computeDefaultMappings(configuration);
			}
		};
	}

	protected void computeDefaultMappings(
			IModelImportConfiguration configuration) {

		for (IModelImportNode next : configuration.getModelsToImport()) {
			if (getMapping(next) == null) {
				mapTo(next, new Path(next.getName()));
			}
		}
	}
}
