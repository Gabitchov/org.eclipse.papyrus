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
package org.eclipse.papyrus.customization.properties.ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.catalog.PropertiesURIHandler;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;
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

	/**
	 * Lightweight method for loading a resource set
	 * This method ignores the *.xwt files, which do not contain any useful
	 * cross-reference (As they can only reference Environment files), and are
	 * really expensive to load.
	 */
	private void resolveAllResources(Context source) {
		resolveAllResources(source, new HashSet<EObject>());
	}

	/**
	 * Lightweight method for loading a resource set
	 * This method ignores the *.xwt files, which do not contain any useful
	 * cross-reference (As they can only reference Environment files), and are
	 * really expensive to load.
	 */
	private void resolveAllResources(EObject source, Set<EObject> visitedEObjects) {
		if(!visitedEObjects.add(source)) {
			return;
		}

		for(EReference reference : source.eClass().getEAllReferences()) {
			//Do not load *.xwt resources
			//These files do not contain any useful cross-reference, and are really expensive to load
			if(reference == ContextsPackage.eINSTANCE.getSection_Widget()) {
				continue;
			}

			Object value = source.eGet(reference);
			if(value instanceof EList) {
				for(Object object : (EList<?>)value) {
					if(object instanceof EObject) {
						resolveAllResources((EObject)object, visitedEObjects);
					}
				}
			} else if(value instanceof EObject) {
				resolveAllResources((EObject)value, visitedEObjects);
			}
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
					//EcoreUtil.resolveAll(source); //This method is too expensive
					resolveAllResources(source); //Ignores the *.xwt files. We will copy them manually.
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

							int filesToCopy = source.eResource().getResourceSet().getResources().size();
							List<Context> contexts = new LinkedList<Context>();
							for(Context context : PropertiesUtil.getDependencies(source)) {
								if(isRelative(source, context.eResource())) {
									contexts.add(context);
									for(Tab tab : context.getTabs()) {
										filesToCopy += tab.getSections().size();
									}
								}
							}

							monitor.beginTask(Messages.CopyContextAction_Copying + source.getName() + Messages.CopyContextAction_To + targetName, filesToCopy);

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

							//Copy the XWT files (they haven't been loaded in the resource set)
							for(Context context : contexts) {
								for(Tab tab : context.getTabs()) {
									for(Section section : tab.getSections()) {
										if(monitor.isCanceled()) {
											return;
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

	protected void copy(String xwtFileName, File targetDirectory, Context source) {
		File target = new File(targetDirectory, xwtFileName);
		URI sourceURI = URI.createURI(xwtFileName).resolve(source.eResource().getURI());
		PropertiesURIHandler uriHandler = new PropertiesURIHandler();
		if(uriHandler.canHandle(sourceURI)) {
			sourceURI = uriHandler.getConvertedURI(sourceURI);
		}

		try {
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
