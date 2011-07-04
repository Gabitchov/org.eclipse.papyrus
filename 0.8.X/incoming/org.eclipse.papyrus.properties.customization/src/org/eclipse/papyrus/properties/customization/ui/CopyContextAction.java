/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.catalog.PropertiesURIHandler;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.customization.messages.Messages;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.swt.widgets.Display;

/**
 * An action to build a new Property view context from an existing one.
 * 
 * @author Camille Letavernier
 */
public class CopyContextAction {

	private IStatus result;

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
	 * @param activate
	 *        If true, the new context will be activated and available immediately,
	 *        while the previous one will be disabled to avoid conflicts
	 * @return
	 *         The new Context
	 * 
	 * @throws IOException
	 *         If an error occured : the previous context cannot be read, or
	 *         the new context cannot be created
	 */
	public Context copy(Context source, String targetName, boolean activate) throws IOException {
		IPath targetDirectoryPath = Activator.getDefault().getPreferencesPath().append("/" + targetName); //$NON-NLS-1$
		final File targetDirectory = targetDirectoryPath.toFile();
		if(targetDirectory.exists()) {
			throw new IOException("A context with this name already exists"); //$NON-NLS-1$
		}
		URI targetModelUri = URI.createFileURI(targetDirectory.toString() + "/" + targetName + ".ctx"); //$NON-NLS-1$ //$NON-NLS-2$

		ResourceSet resourceSet = new ResourceSetImpl();
		Context sourceContext = (Context)EMFHelper.loadEMFModel(resourceSet, source.eResource().getURI());

		copyAll(sourceContext, new File(targetDirectory, targetName + ".ctx")); //$NON-NLS-1$

		if(result.getCode() == IStatus.OK) {
			Context targetContext = ConfigurationManager.instance.getContext(targetModelUri);

			targetContext.setName(targetName);
			targetContext.eResource().save(Collections.EMPTY_MAP);
			ConfigurationManager.instance.addContext(targetContext, activate);
			if(activate) {
				ConfigurationManager.instance.disableContext(source, true);
			}
			return targetContext;
		} else {
			return null;
		}
	}

	private void copyAll(final Context source, final File target) {
		final File targetDirectory = target.getParentFile();
		final String targetName = target.getName();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		try {
			dialog.run(true, false, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {
					monitor.beginTask(Messages.CopyContextAction_InitializingTheCopyOf + source.getName() + Messages.CopyContextAction_ThisMayTakeSomeTime, IProgressMonitor.UNKNOWN);
					EcoreUtil.resolveAll(source);
					monitor.done();
					result = Status.OK_STATUS;
				}
			});

			dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());

			if(result.getCode() == IStatus.OK) {

				dialog.run(true, true, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						try {
							targetDirectory.mkdirs();

							monitor.beginTask(Messages.CopyContextAction_Copying + source.getName() + Messages.CopyContextAction_To + targetName, source.eResource().getResourceSet().getResources().size());

							//Copy of the context
							copy(source.eResource(), target);
							monitor.worked(1);

							//Copy of the dependent resources which are located in the same folder
							//(or subfolders)
							for(Resource resource : source.eResource().getResourceSet().getResources()) {
								if(monitor.isCanceled()) {
									return;
								}
								if(source.eResource() != resource && isRelative(source, resource)) {
									copy(resource, targetDirectory, source, targetName);
								}
								monitor.worked(1);
							}

							monitor.done();
						} catch (IOException ex) {
							Activator.log.error(ex);
							result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occured during the copy of " + source.getName(), ex); //$NON-NLS-1$
							return;
						}
						result = Status.OK_STATUS;
					}
				});
			}
		} catch (InvocationTargetException ex) {
			Activator.log.error(ex);
		} catch (InterruptedException ex) {
			Activator.log.error(ex);
		}
	}

	protected void copy(Resource resource, File target) throws IOException {
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

	private boolean isRelative(EObject source, Resource resource) {
		URI baseURI = source.eResource().getURI();
		URI resourceURI = resource.getURI();
		URI uri = resourceURI.deresolve(baseURI);
		if(uri.isRelative()) {
			if(!(uri.toString().startsWith("..") || uri.toString().startsWith("/"))) { //$NON-NLS-1$ //$NON-NLS-2$
				return true;
			}
		}
		return false;
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
