/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.storage.actions.workspace;

import static org.eclipse.papyrus.customization.properties.storage.actions.ContextStorageActionUtil.initializeCopy;
import static org.eclipse.papyrus.customization.properties.storage.actions.ContextStorageActionUtil.isRelative;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextCopyAction;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.catalog.PropertiesURIHandler;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;

/**
 * An action to build a new Property view context from an existing one.
 * 
 * @author Camille Letavernier
 */
public class WorkspaceContextCopyAction implements IContextCopyAction {

	public String getLabel() {
		return Messages.CustomizationDialog_copyToWorkspace;
	}

	public String getToolTip() {
		return Messages.CustomizationDialog_createNewCopyByCopy;
	}

	/**
	 * Copy an existing context to a new one with the given name.
	 * The new context is registered to the {@link ConfigurationManager}.
	 * To enable the edition of the context, an invisible project is created
	 * in the workspace. The files are stored in the runtime plugin's preference
	 * folder.
	 * 
	 * @param source
	 *        The source Context to copy
	 * @param targetName
	 *        The name of the new context
	 * @return
	 *         The new Context
	 * 
	 * @throws CoreException
	 *         If an error occured : the previous context cannot be read, or
	 *         the new context cannot be created
	 */
	public Context copy(Context source, String targetName, IProgressMonitor monitor) throws CoreException {
		SubMonitor sub = SubMonitor.convert(monitor, 1);

		Context result = null;

		try {
			IPath targetDirectoryPath = org.eclipse.papyrus.views.properties.Activator.getDefault().getPreferencesPath().append("/" + targetName); //$NON-NLS-1$
			final File targetDirectory = targetDirectoryPath.toFile();
			if(targetDirectory.exists()) {
				throw new IOException("A context with this name already exists"); //$NON-NLS-1$
			}
			URI targetModelUri = URI.createFileURI(targetDirectory.toString() + "/" + targetName + ".ctx"); //$NON-NLS-1$ //$NON-NLS-2$

			ResourceSet resourceSet = new ResourceSetImpl();
			Context sourceContext = (Context)EMFHelper.loadEMFModel(resourceSet, source.eResource().getURI());

			IStatus copyResult = copyAll(sourceContext, new File(targetDirectory, targetName + ".ctx"), sub.newChild(1, SubMonitor.SUPPRESS_NONE)); //$NON-NLS-1$

			if(copyResult.isOK()) {
				result = ConfigurationManager.getInstance().getContext(targetModelUri);

				result.setName(targetName);
				result.setPrototype(source);
				result.eResource().save(Collections.EMPTY_MAP);
			} else if(copyResult.getSeverity() != IStatus.CANCEL) {
				throw new CoreException(copyResult);
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
		} finally {
			sub.done();
		}

		return result;
	}

	private IStatus copyAll(Context source, File target, IProgressMonitor monitor) {
		SubMonitor sub = SubMonitor.convert(monitor, 100);

		initializeCopy(source, sub.newChild(10));

		return doCopy(source, target, sub.newChild(90));
	}

	private IStatus doCopy(Context source, File target, IProgressMonitor monitor) {
		IStatus result = Status.OK_STATUS;

		final File targetDirectory = target.getParentFile();
		final String targetName = target.getName();

		try {
			Resource sourceResource = source.eResource();
			targetDirectory.mkdirs();

			int filesToCopy = sourceResource.getResourceSet().getResources().size();
			List<Context> contexts = new LinkedList<Context>();
			for(Context context : PropertiesUtil.getDependencies(source)) {
				if(isRelative(sourceResource, context.eResource())) {
					contexts.add(context);
					for(Tab tab : context.getTabs()) {
						filesToCopy += tab.getSections().size();
					}
				}
			}

			monitor.beginTask(Messages.CopyContextAction_Copying + source.getName() + Messages.CopyContextAction_To + targetName, filesToCopy);

			//Copy of the context
			copy(sourceResource, target);
			monitor.worked(1);

			//Copy of the dependent resources which are located in the same folder
			//(or subfolders)
			for(Resource resource : source.eResource().getResourceSet().getResources()) {
				if(monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				if((resource != sourceResource) && isRelative(sourceResource, resource)) {
					copy(resource, targetDirectory, source, targetName);
				}
				monitor.worked(1);
			}

			//Copy the XWT files (they haven't been loaded in the resource set)
			for(Context context : contexts) {
				for(Tab tab : context.getTabs()) {
					for(Section section : tab.getSections()) {
						if(monitor.isCanceled()) {
							return Status.CANCEL_STATUS;
						}
						copy(section.getSectionFile(), targetDirectory, source);
						monitor.worked(1);
					}
				}
			}

			monitor.done();
		} catch (IOException ex) {
			Activator.log.error(ex);
			result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occured during the copy of " + source.getName(), ex); //$NON-NLS-1$
			monitor.done();
		}

		return result;
	}

	protected void copy(String xwtFileName, File targetDirectory, Context source) {
		File target = new File(targetDirectory, xwtFileName);
		URI sourceURI = URI.createURI(xwtFileName).resolve(source.eResource().getURI());
		PropertiesURIHandler uriHandler = new PropertiesURIHandler();
		if(uriHandler.canHandle(sourceURI)) {
			sourceURI = uriHandler.getConvertedURI(sourceURI);
		}

		try {
			// TODO: Use resource set's URIConverter to get a stream
			java.net.URL netURL = new java.net.URL(sourceURI.toString());
			InputStream is = netURL.openStream();
			copy(is, target);
		} catch (MalformedURLException ex) {
			Activator.log.error(ex);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	protected void copy(Resource resource, File target) throws IOException {
		// TODO: Use resource set's URIConverter to get a stream
		PropertiesURIHandler uriHandler = new PropertiesURIHandler();
		URI uri = resource.getURI();
		if(uriHandler.canHandle(uri)) {
			uri = uriHandler.getConvertedURI(uri);
		}
		copy(new URL(uri.toString()).openStream(), target);
	}

	private void copy(Resource resource, File directory, EObject source, String targetName) throws IOException {
		URI relativeURI = resource.getURI().deresolve(source.eResource().getURI());
		if(relativeURI.toString().equals("")) { //$NON-NLS-1$
			relativeURI = URI.createURI(targetName + ".ctx"); //$NON-NLS-1$
		}
		File target = new File(directory, relativeURI.toString());
		copy(resource, target);
	}

	//Strict copy : we read directly the file, instead of interpreting it as a Model
	private void copy(InputStream source, File target) throws IOException {
		if(!target.getParentFile().exists()) {
			target.getParentFile().mkdirs();
		}

		FileWriter out = new FileWriter(target);
		try {
			int c;

			while((c = source.read()) != -1) {
				out.write(c);
			}

		} catch (IOException ex) {
			throw ex;
		} finally {
			source.close();
			out.close();
		}
	}
}
