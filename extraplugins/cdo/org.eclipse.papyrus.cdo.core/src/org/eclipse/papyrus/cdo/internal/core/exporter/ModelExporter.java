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
package org.eclipse.papyrus.cdo.internal.core.exporter;

import java.util.Iterator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.exporter.IModelExportMapping;
import org.eclipse.papyrus.cdo.core.exporter.IModelExporter;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.CDOProxyResolvingResourceSet;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;

/**
 * This is the ModelExporter type. Enjoy.
 */
public class ModelExporter implements IModelExporter {

	public ModelExporter() {
		super();
	}

	public Diagnostic exportModels(final IModelExportMapping mapping) {
		BasicDiagnostic result = new BasicDiagnostic();

		add(result, mapping.getConfiguration().validate());
		add(result, mapping.validate());

		if(result.getSeverity() < Diagnostic.ERROR) {
			add(result, mapping.getConfiguration().getOperationContext().run(new IModelTransferOperation() {

				public Diagnostic run(IProgressMonitor monitor) {
					return doExport(mapping, monitor);
				}
			}));
		}

		return result;
	}

	protected Diagnostic doExport(IModelExportMapping mapping, IProgressMonitor monitor) {
		BasicDiagnostic result = new BasicDiagnostic();
		IModelTransferConfiguration configuration = mapping.getConfiguration();

		// 1/resource for loading, 1/resource for exporting,
		// 1 for proxy resolution, 1 for resource saving, and 1 for clean-up
		SubMonitor sub = SubMonitor.convert(monitor, Messages.ModelExporter_0, 2 * configuration.getModelsToTransfer().size() + 3);

		IInternalPapyrusRepository repository = (IInternalPapyrusRepository)mapping.getRepository();
		ResourceSet destination = new ResourceSetImpl();
		ResourceSet source = repository.createTransaction(new CDOProxyResolvingResourceSet());
		CDOView view = repository.getCDOView(source);

		try {
			// load all models to be exported and resolve their cross-references so that CDO-style
			// cross-resource proxies will be resolved
			for(IModelTransferNode model : configuration.getModelsToTransfer()) {
				add(result, loadModel(model, view, sub.newChild(1)));
			}
			EcoreUtil.resolveAll(source);
			sub.worked(1);

			for(IModelTransferNode model : configuration.getModelsToTransfer()) {
				add(result, exportModel(model, view, mapping.getMapping(model), destination, sub.newChild(1)));
			}

			for(IModelTransferNode model : configuration.getModelsToTransfer()) {
				add(result, saveModel(model, view, mapping.getMapping(model), destination));
			}
			sub.worked(1);
		} finally {
			// don't clean up the configuration's resource set because it is not owned by the configuration
			cleanUp(destination);
			repository.close(source);
			cleanUp(source);
			sub.worked(1);
		}

		sub.done();

		return result;
	}

	protected Diagnostic loadModel(IModelTransferNode model, CDOView view, IProgressMonitor monitor) {
		BasicDiagnostic result = new BasicDiagnostic();

		SubMonitor sub = SubMonitor.convert(monitor, model.getName(), model.getResourceURIs().size());

		for(URI next : model.getResourceURIs()) {
			Resource source = view.getResourceSet().getResource(next, true);
			for(Iterator<?> iter = source.getContents().iterator(); iter.hasNext(); iter.next()) {
				// just iterate them to load the contents; we will walk over the content trees later to resolve proxies
			}
			sub.worked(1);
		}

		sub.done();

		return result;
	}

	protected Diagnostic exportModel(IModelTransferNode model, CDOView view, IPath toPath, ResourceSet rset, IProgressMonitor monitor) {
		BasicDiagnostic result = new BasicDiagnostic();

		IPath basePath = toPath.removeFileExtension();

		SubMonitor sub = SubMonitor.convert(monitor, model.getName(), model.getResourceURIs().size());

		for(URI next : model.getResourceURIs()) {
			Resource source = view.getResourceSet().getResource(next, true);
			Resource destination = rset.createResource(URI.createPlatformResourceURI(basePath.addFileExtension(next.fileExtension()).toString(), true));
			add(result, exportResource(source, destination));
			sub.worked(1);
		}

		sub.done();

		return result;
	}

	protected Diagnostic exportResource(Resource source, Resource destination) {
		destination.getContents().addAll(source.getContents());

		return Diagnostic.OK_INSTANCE;
	}

	protected Diagnostic saveModel(IModelTransferNode model, CDOView view, IPath toPath, ResourceSet rset) {
		BasicDiagnostic result = new BasicDiagnostic();

		IPath basePath = toPath.removeFileExtension();

		for(URI next : model.getResourceURIs()) {
			Resource destination = rset.getResource(URI.createPlatformResourceURI(basePath.addFileExtension(next.fileExtension()).toString(), true), false);
			try {
				destination.save(null);
			} catch (Exception e) {
				add(result, new BasicDiagnostic(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.ModelExporter_1, new Object[]{ e }));
			}
		}

		return result;
	}

	private void cleanUp(ResourceSet resourceSet) {
		for(Resource next : resourceSet.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
		resourceSet.getResources().clear();
	}

	private static void add(DiagnosticChain diagnostics, Diagnostic diagnostic) {
		if(diagnostic.getSeverity() > Diagnostic.OK) {
			diagnostics.merge(diagnostic);
		}
	}
}
