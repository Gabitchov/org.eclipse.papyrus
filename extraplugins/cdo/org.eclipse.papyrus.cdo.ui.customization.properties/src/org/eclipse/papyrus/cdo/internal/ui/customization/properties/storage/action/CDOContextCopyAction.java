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
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.action;

import static org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.CDOContextStorageProvider.CONTEXTS_PATH;
import static org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.CDOContextStorageProvider.CONTEXT_EXTENSION;
import static org.eclipse.papyrus.customization.properties.storage.actions.ContextStorageActionUtil.isRelative;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.common.lob.CDOClob;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOTextResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.Activator;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.messages.Messages;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.CDOTextURIHandler;
import org.eclipse.papyrus.cdo.internal.ui.dialogs.RepositorySelectionDialog;
import org.eclipse.papyrus.customization.properties.storage.actions.ContextStorageActionUtil;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextCopyAction;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.catalog.PropertiesURIHandler;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Supplier;
import com.google.common.io.Closeables;

/**
 * This is the CDOContextCopyAction type. Enjoy.
 */
public class CDOContextCopyAction extends AbstractCDOContextAction implements IContextCopyAction {

	public String getLabel() {
		return Messages.CDOContextCopyAction_0;
	}

	public String getToolTip() {
		return Messages.CDOContextCopyAction_1;
	}

	public Context copy(Context source, String targetName, IProgressMonitor monitor) throws CoreException {
		IInternalPapyrusRepository repository = selectRepository(source);
		if(repository == null) {
			// user cancelled
			return null;
		}

		CDOTransaction transaction = (CDOTransaction)repository.getCDOView(repository.createTransaction(new ResourceSetImpl()));

		SubMonitor sub = SubMonitor.convert(monitor);

		Context result = null;

		try {
			CDOResourceFolder contextsFolder = transaction.getOrCreateResourceFolder(CONTEXTS_PATH);
			String folderPath = new Path(contextsFolder.getPath()).append(targetName).toString();
			String resourcePath = new Path(folderPath).append(targetName).addFileExtension(CONTEXT_EXTENSION).toString();

			if(transaction.hasResource(folderPath)) { // actually checks for any kind of resource node at that path
				throw new IOException(Messages.CDOContextCopyAction_2);
			}

			transaction.createResourceFolder(folderPath);
			CDOTextResource targetResource = transaction.createTextResource(resourcePath);

			// create a custom URI scheme that delegates XMI resource content to a CDOTextResource's CLOB content
			URI targetModelURI = CDOTextURIHandler.createURI(targetResource.getURI());

			ResourceSet resourceSet = transaction.getResourceSet();

			// add the URI handler to load the context resource
			CDOTextURIHandler.install(resourceSet);

			// re-load the source context in the new resource set to scope the copy operation
			Context sourceContext = (Context)EMFHelper.loadEMFModel(resourceSet, source.eResource().getURI());
			IStatus copyResult = copyAll(sourceContext, targetResource, sub); //$NON-NLS-1$

			if(copyResult.isOK()) {
				Context resultContext = (Context)EMFHelper.loadEMFModel(resourceSet, targetModelURI);
				resultContext.setName(targetName);
				resultContext.setPrototype(sourceContext);
				resultContext.eResource().save(null);

				long commitTime = System.currentTimeMillis();
				transaction.commit();

				ResourceSet mainResourceSet = source.eResource().getResourceSet();
				repository.getCDOView(mainResourceSet).waitForUpdate(commitTime, 30000L);

				// load the new instance in the shared resource set
				result = (Context)EMFHelper.loadEMFModel(mainResourceSet, targetModelURI);
			} else if(copyResult.getSeverity() != IStatus.CANCEL) {
				throw new CoreException(copyResult);
			}
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
		} finally {
			transaction.close();
			sub.done();
		}

		return result;
	}

	protected IInternalPapyrusRepository selectRepository(Context context) {
		final IPapyrusRepositoryManager mgr = PapyrusRepositoryManager.INSTANCE;
		IPapyrusRepository result = null;

		// default selection is the repository containing the context to be copied,
		// if it is in a repository
		IPapyrusRepository initialSelection = null;
		URI uri = context.eResource().getURI();
		if(CDOUtils.isCDOURI(uri)) {
			initialSelection = mgr.getRepositoryForURI(uri);
		}

		// otherwise, look for the first open repository
		if(initialSelection == null) {
			for(IPapyrusRepository next : mgr.getRepositories()) {
				if(next.isConnected()) {
					initialSelection = next;
					break;
				}
			}
		}

		result = initialSelection;

		if(mgr.getRepositories().size() > 1) {
			final IPapyrusRepository[] innerResult = { initialSelection };
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					Shell active = Display.getDefault().getActiveShell();
					RepositorySelectionDialog dlg = new RepositorySelectionDialog(active, mgr, innerResult[0], new Supplier<IRunnableContext>() {

						public IRunnableContext get() {
							return new ProgressMonitorDialog(Display.getDefault().getActiveShell());
						}
					});

					if(dlg.open() == Window.OK) {
						innerResult[0] = dlg.getSelectedRepository();
					} else {
						innerResult[0] = null;
					}
				}
			});

			result = innerResult[0];
		}

		return (IInternalPapyrusRepository)result;
	}

	private IStatus copyAll(Context source, CDOTextResource target, IProgressMonitor monitor) {
		SubMonitor sub = SubMonitor.convert(monitor, 100);

		ContextStorageActionUtil.initializeCopy(source, sub.newChild(10));

		return doCopy(source, target, sub.newChild(90));
	}

	private IStatus doCopy(Context source, CDOTextResource target, IProgressMonitor monitor) {
		IStatus result = Status.OK_STATUS;

		final CDOResourceFolder targetFolder = target.getFolder();
		final String targetName = target.getName();

		try {
			Resource sourceResource = source.eResource();
			int resourcesToCopy = sourceResource.getResourceSet().getResources().size();
			List<Context> contexts = new LinkedList<Context>();
			for(Context context : PropertiesUtil.getDependencies(source)) {
				if(isRelative(sourceResource, context.eResource())) {
					contexts.add(context);
					for(Tab tab : context.getTabs()) {
						resourcesToCopy += tab.getSections().size();
					}
				}
			}

			monitor.beginTask(NLS.bind(Messages.CDOContextCopyAction_3, source.getName(), target.getName()), resourcesToCopy);

			// copy the primary context
			copy(sourceResource.getResourceSet(), sourceResource.getURI(), target);
			monitor.worked(1);

			// copy the dependent resources which are located in the same folder or in subfolders
			for(Resource resource : sourceResource.getResourceSet().getResources()) {
				if(monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				if((resource != sourceResource) && isRelative(sourceResource, resource)) {
					copy(resource, targetFolder, sourceResource, targetName);
				}
				monitor.worked(1);
			}

			// copy the XWT files (they haven't been loaded in the resource set)
			for(Context context : contexts) {
				for(Tab tab : context.getTabs()) {
					for(Section section : tab.getSections()) {
						if(monitor.isCanceled()) {
							return Status.CANCEL_STATUS;
						}
						copy(section.getSectionFile(), targetFolder, sourceResource);
						monitor.worked(1);
					}
				}
			}

			monitor.done();
		} catch (IOException ex) {
			Activator.log.error(ex);
			result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occurred during the copy of " + source.getName(), ex); //$NON-NLS-1$
			monitor.done();
		}

		return result;
	}

	protected void copy(String xwtFileName, CDOResourceFolder targetFolder, Resource sourceResource) throws IOException {
		CDOTextResource target = ((CDOTransaction)targetFolder.cdoView()).createTextResource(new Path(targetFolder.getPath()).append(xwtFileName).toString());
		URI sourceURI = URI.createURI(xwtFileName).resolve(sourceResource.getURI());
		copy(sourceResource.getResourceSet(), sourceURI, target);
	}

	protected void copy(ResourceSet sourceResourceSet, URI sourceURI, CDOTextResource target) throws IOException {
		PropertiesURIHandler uriHandler = new PropertiesURIHandler();
		if(uriHandler.canHandle(sourceURI)) {
			sourceURI = uriHandler.getConvertedURI(sourceURI);
		}

		InputStream input = null;

		try {
			input = sourceResourceSet.getURIConverter().createInputStream(sourceURI);
			String encoding = (input instanceof URIConverter.Readable) ? ((URIConverter.Readable)input).getEncoding() : "UTF-8"; //$NON-NLS-1$
			Reader contents = new InputStreamReader(input, encoding);
			target.setContents(new CDOClob(contents));
		} catch (IOException ex) {
			Activator.log.error(ex);
		} finally {
			if(input != null) {
				Closeables.closeQuietly(input);
			}
		}
	}

	private void copy(Resource resource, CDOResourceFolder folder, Resource base, String targetName) throws IOException {
		URI relativeURI = resource.getURI().deresolve(base.getURI());
		if(relativeURI.toString().equals("")) { //$NON-NLS-1$
			relativeURI = URI.createURI(targetName + ".ctx"); //$NON-NLS-1$
		}

		// append a dummy segment to ensure correct resolution (otherwise we will
		// miss the last segment of the folder path)
		URI uri = relativeURI.resolve(folder.getURI().appendSegment("dummy.ctx")); //$NON-NLS-1$
		CDOTextResource target = ((CDOTransaction)folder.cdoView()).createTextResource(CDOURIUtil.extractResourcePath(uri));
		copy(resource.getResourceSet(), resource.getURI(), target);
	}
}
