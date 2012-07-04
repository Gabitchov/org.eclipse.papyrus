/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Element;


public class PropertyViewExtensionFactory extends FileBasedExtensionFactory {

	protected IStatus result;

	public PropertyViewExtensionFactory() {
		super(Messages.PropertyViewExtensionFactory_PropertyView, "org.eclipse.papyrus.views.properties.context", "contextModel", "context", true); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void addElement(CustomizableElement element, PluginEditor editor) {
		super.addElement(element, editor);

		editor.getManifestEditor().addDependency("org.eclipse.papyrus.views.properties"); //$NON-NLS-1$
	}

	@Override
	protected Element createExtension(FileBasedCustomizableElement element, PluginEditor editor) {
		Element extension = super.createExtension(element, editor);
		//extension.setAttribute("loadDefault", ((PropertyView)element).isLoadDefault() ? "true" : "false");
		return extension;
	}

	@Override
	protected void copyFile(FileBasedCustomizableElement element, PluginEditor editor) {
		String path = element.getFile();
		File sourceFile = FileUtil.getFile(path);
		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());

		File targetFile = FileUtil.getWorkspaceFile("/" + editor.getProject().getName() + "/" + getTargetPath(element)); //$NON-NLS-1$ //$NON-NLS-2$
		if(!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			EObject propertyViewModel = EMFHelper.loadEMFModel(resourceSet, uri);
			copyAll((Context)propertyViewModel, targetFile);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		//		try {
		//			copy(new FileInputStream(sourceFile), targetFile);
		//		} catch (IOException ex) {
		//			Activator.log.error(ex);
		//		}
		//
		editor.getBuildEditor().addToBuild("propertyView/");
	}

	private void copyAll(final Context source, final File target) {
		final File targetDirectory = target.getParentFile();
		final String targetName = target.getName();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		try {
			dialog.run(true, false, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {
					monitor.beginTask(Messages.PropertyViewExtensionFactory_InitializingCopy + source.getName() + Messages.PropertyViewExtensionFactory_WaitMessage, IProgressMonitor.UNKNOWN);
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

							monitor.beginTask(Messages.PropertyViewExtensionFactory_Copying + source.getName() + Messages.PropertyViewExtensionFactory_To + targetName, source.eResource().getResourceSet().getResources().size());

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

	protected void copy(Resource resource, File directory, EObject source, String targetName) throws IOException {
		URI relativeURI = resource.getURI().deresolve(source.eResource().getURI());
		if(relativeURI.toString().equals("")) { //$NON-NLS-1$
			relativeURI = URI.createURI(targetName + ".ctx"); //$NON-NLS-1$
		}
		File target = new File(directory, relativeURI.toString());
		copy(resource, target);
	}

	protected void copy(Resource resource, File target) throws IOException {
		copy(new URL(resource.getURI().toString()).openStream(), target);
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		String fileName = getFileName(element);
		String simpleName = fileName.substring(0, fileName.lastIndexOf(".")); //$NON-NLS-1$
		return "/propertyView/" + simpleName + "/" + fileName; //$NON-NLS-1$ //$NON-NLS-2$
		//TODO : Copy the whole directory (.xwt files + model dependencies)
	}

	public EClass getCustomizableElementClass() {
		return CustomizationPluginPackage.eINSTANCE.getPropertyView();
	}

}
