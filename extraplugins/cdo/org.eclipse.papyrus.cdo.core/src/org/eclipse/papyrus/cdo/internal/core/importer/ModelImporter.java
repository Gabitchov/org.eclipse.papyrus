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

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelImporter;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;

import com.google.common.collect.Sets;

/**
 * This is the ModelImporter type. Enjoy.
 */
public class ModelImporter implements IModelImporter {

	protected static final ContentType DI_CONTENT = new ContentType("DI"); //$NON-NLS-1$

	protected static final ContentType UML_CONTENT = new ContentType("UML"); //$NON-NLS-1$

	protected static final ContentType NOTATION_CONTENT = new ContentType("Notation"); //$NON-NLS-1$

	protected static final ContentType UNKNOWN_CONTENT = new ContentType("unknown"); //$NON-NLS-1$

	public ModelImporter() {
		super();
	}

	public Diagnostic importModels(final IModelImportMapping mapping) {
		BasicDiagnostic result = new BasicDiagnostic();

		add(result, mapping.getConfiguration().validate());
		add(result, mapping.validate());

		if(result.getSeverity() < Diagnostic.ERROR) {
			add(result, mapping.getConfiguration().getOperationContext().run(new IModelTransferOperation() {

				public Diagnostic run(IProgressMonitor monitor) {
					return doImport(mapping, monitor);
				}
			}));
		}

		return result;
	}

	protected Diagnostic doImport(IModelImportMapping mapping, IProgressMonitor monitor) {
		BasicDiagnostic result = new BasicDiagnostic();
		IModelTransferConfiguration configuration = mapping.getConfiguration();

		// by the time the configuration has analyzed every model to be
		// imported, all proxies have been resolved that can be. So,
		// there's no need for a further EcoreUtil.resolveAll() or such

		// 1 for transaction commit, 1 for saving affected non-imported
		// models, and 1 for clean-up
		SubMonitor sub = SubMonitor.convert(monitor, Messages.ModelImporter_4, configuration.getModelsToTransfer().size() + 3);

		IInternalPapyrusRepository repository = (IInternalPapyrusRepository)mapping.getRepository();
		ResourceSet destination = repository.createTransaction(new ResourceSetImpl());
		CDOTransaction transaction = (CDOTransaction)repository.getCDOView(destination);

		try {
			for(IModelTransferNode model : configuration.getModelsToTransfer()) {
				add(result, importModel(model, configuration.getResourceSet(), mapping.getMapping(model), transaction, sub.newChild(1)));
			}

			try {
				transaction.commit(sub.newChild(1));
			} catch (CommitException e) {
				result.add(new BasicDiagnostic(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.ModelImporter_5, new Object[]{ e }));
			}

			try {
				saveNonimportedModels(mapping, transaction, sub.newChild(1));
			} catch (Exception e) {
				result.add(new BasicDiagnostic(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.ModelImporter_6, new Object[]{ e }));
			}
		} finally {
			cleanUp(configuration.getResourceSet());
			cleanUp(destination);
			repository.close(destination);
			sub.worked(1);
		}

		sub.done();

		return result;
	}

	protected Diagnostic importModel(IModelTransferNode model, ResourceSet rset, IPath toPath, CDOTransaction transaction, IProgressMonitor monitor) {
		BasicDiagnostic result = new BasicDiagnostic();

		IPath basePath = toPath.removeFileExtension();

		SubMonitor sub = SubMonitor.convert(monitor, model.getName(), model.getResourceURIs().size());

		for(URI next : model.getResourceURIs()) {
			Resource destination = transaction.getOrCreateResource(basePath.addFileExtension(next.fileExtension()).toString());

			add(result, importResource(rset.getResource(next, true), destination));
			sub.worked(1);
		}

		sub.done();

		return result;
	}

	protected Diagnostic importResource(Resource source, Resource destination) {
		if(!destination.getContents().isEmpty()) {
			ContentType contentType = getContentType(source);
			if(contentType == DI_CONTENT) {
				mergeDIContent(source, destination);
			} else {
				// just append the additional content
				destination.getContents().addAll(source.getContents());
			}
		} else {
			destination.getContents().addAll(source.getContents());
		}

		return Diagnostic.OK_INSTANCE;
	}

	/**
	 * Determines the content-type of a resource for the purpose of combining
	 * content.
	 * 
	 * @param resource
	 *        a resource to be combined with existing content
	 * 
	 * @return the content type
	 */
	protected ContentType getContentType(Resource resource) {
		ContentType result = UNKNOWN_CONTENT;

		for(EObject next : resource.getContents()) {
			EPackage ePackage = next.eClass().getEPackage();
			if(ePackage == DiPackage.eINSTANCE) {
				result = DI_CONTENT;
				break;
			}
			if(ePackage.getName().equalsIgnoreCase("uml")) { //$NON-NLS-1$
				result = UML_CONTENT;
				break;
			}
			if(ePackage.getName().equalsIgnoreCase("notation")) { //$NON-NLS-1$
				result = NOTATION_CONTENT;
				break;
			}
		}

		return result;
	}

	protected void mergeDIContent(Resource source, Resource destination) {
		// snip out the source window manager and get its counterpart
		SashWindowsMngr srcMngr = (SashWindowsMngr)EcoreUtil.getObjectByType(source.getContents(), DiPackage.Literals.SASH_WINDOWS_MNGR);
		EcoreUtil.remove(srcMngr);
		SashWindowsMngr dstMngr = (SashWindowsMngr)EcoreUtil.getObjectByType(destination.getContents(), DiPackage.Literals.SASH_WINDOWS_MNGR);

		// merge the window manager contents
		if(dstMngr == null) {
			destination.getContents().add(0, srcMngr);
		} else {
			SashModel dstModel = dstMngr.getSashModel();
			SashModel srcModel = srcMngr.getSashModel();

			if(dstModel == null) {
				dstMngr.setSashModel(srcModel);
			} else {
				dstModel.getWindows().addAll(srcModel.getWindows());
				if(dstModel.getCurrentSelection() == null) {
					dstModel.setCurrentSelection(srcModel.getCurrentSelection());
				}
			}

			PageList dstPages = dstMngr.getPageList();
			PageList srcPages = srcMngr.getPageList();

			if(dstPages == null) {
				dstMngr.setPageList(srcPages);
			} else {
				dstPages.getAvailablePage().addAll(srcPages.getAvailablePage());
			}
		}

		// and add all of the tables and other content
		destination.getContents().addAll(source.getContents());
	}

	protected Diagnostic saveNonimportedModels(IModelImportMapping mapping, CDOTransaction transaction, IProgressMonitor monitor) {
		IModelTransferConfiguration configuration = mapping.getConfiguration();

		BasicDiagnostic result = new BasicDiagnostic();

		Collection<IModelTransferNode> imported = configuration.getModelsToTransfer();
		Set<IModelTransferNode> nonImported = Sets.newHashSet();

		for(IModelTransferNode next : configuration.getModelsToTransfer()) {
			for(IModelTransferNode dependent : next.getDependents()) {
				if(!imported.contains(dependent)) {
					nonImported.add(dependent);
				}
			}
		}

		if(!nonImported.isEmpty()) {
			SubMonitor sub = SubMonitor.convert(monitor, Messages.ModelImporter_9, nonImported.size());

			ResourceSet rset = configuration.getResourceSet();

			try {
				for(IModelTransferNode next : nonImported) {
					for(URI uri : next.getResourceURIs()) {
						Resource resource = rset.getResource(uri, false);

						// if the resource is modified, then we imported it, so
						// don't save
						if((resource != null) && !resource.isModified()) {
							try {
								resource.save(null);
							} catch (Exception e) {
								add(result, new BasicDiagnostic(IStatus.ERROR, Activator.PLUGIN_ID, 0, Messages.ModelImporter_10, new Object[]{ e }));
							}
						}
					}

					sub.worked(1);
				}
			} finally {
				sub.done();
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

	//
	// Nested types
	//

	protected static class ContentType {

		private final String name;

		protected ContentType(String name) {
			this.name = name;
		}

		public final String getName() {
			return name;
		}

		@Override
		public int hashCode() {
			return getName().hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof ContentType) && ((ContentType)obj).getName().equals(getName());
		}

		@Override
		public String toString() {
			return getName() + " content"; //$NON-NLS-1$
		}
	}
}
