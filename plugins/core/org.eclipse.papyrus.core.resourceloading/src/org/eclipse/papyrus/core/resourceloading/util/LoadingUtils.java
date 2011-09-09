/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.resourceloading.Activator;
import org.eclipse.papyrus.core.resourceloading.Messages;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.sasheditor.DiModel;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * This class provides utility methods for model loading
 * 
 * @author vhemery
 */
public class LoadingUtils {

	/**
	 * Load corresponding resources in model set for all its existing models.
	 * 
	 * @param modelSet
	 *        the model set
	 * @param uriWithoutFileExtension
	 *        path of resources to load without file extension
	 */
	public static void loadResourcesInModelSet(ModelSet modelSet, URI uriWithoutFileExtension) {
		// initiate progress dialog
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		dialog.open();
		IProgressMonitor monitor = dialog.getProgressMonitor();

		IEditorPart editor = getEditor();
		if(editor instanceof CoreMultiDiagramEditor) {
			CoreMultiDiagramEditor core = (CoreMultiDiagramEditor)editor;
			try {
				DiSashModelMngr sashModelMngr = core.getServicesRegistry().getService(DiSashModelMngr.class);
				IPageMngr pageMngr = sashModelMngr.getIPageMngr();
				List<Object> allPages = pageMngr.allPages();
				// mark progress
				monitor.beginTask(Messages.LoadingUtils_RefreshPagesTask, allPages.size());
				// the uri is added after getting all the pages. If it is done before, the eobjects are resolved
				NotificationBuilder error = NotificationBuilder.createAsyncPopup(Messages.LoadingUtils_ErrorTitle, String.format(Messages.LoadingUtils_ErrorMessage, uriWithoutFileExtension.toString())).setType(Type.ERROR).setDelay(2000);
				for(Object o : allPages) {
					// refresh pages to display proxy diagrams
					if(o instanceof EObject) {
						EObject eobject = (EObject)o;
						if(eobject.eIsProxy()) {
							InternalEObject internal = (InternalEObject)eobject;
							URI uriProxy = internal.eProxyURI();
							URI trimFragment = uriProxy.trimFragment();
							if(uriWithoutFileExtension.equals(trimFragment.trimFileExtension())) {
								try {
									Resource r = modelSet.getResource(trimFragment, true);
									if(r != null) {
										EObject newEObject = r.getEObject(uriProxy.fragment());
										if(pageMngr.isOpen(newEObject)) {
											pageMngr.closePage(newEObject);
											pageMngr.openPage(newEObject);
										}
									} else {
										error.run();
									}
								} catch (Exception e) {
									error.run();
									Activator.logError(e);
								}
							}
						}
					}
					// mark progress
					monitor.worked(1);
				}
				Set<String> extensions = getExtensions(modelSet);
				// mark progress
				monitor.beginTask(Messages.LoadingUtils_LoadModelsTask, extensions.size());
				for(String s : extensions) {
					try {
						URI uriToLoad = uriWithoutFileExtension.appendFileExtension(s);
						Resource r = modelSet.getResource(uriToLoad, true);
						if(r == null) {
							error.run();
						}
					} catch (Exception re) {
						error.run();
						Activator.logError(re);
					}
					// mark progress
					monitor.worked(1);
				}
			} catch (ServiceException e) {
				Activator.logError(e);
			}
		}
		// mark progress
		monitor.done();
		dialog.close();
	}

	/**
	 * Unload corresponding resources from model set for all its existing models.
	 * 
	 * @param modelSet
	 *        the model set
	 * @param uriWithoutFileExtension
	 *        path of resources to unload without file extension
	 */
	public static void unloadResourcesFromModelSet(ModelSet modelSet, URI uriWithoutFileExtension) {
		// initiate progress dialog
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		dialog.open();
		IProgressMonitor monitor = dialog.getProgressMonitor();

		IEditorPart editor = getEditor();
		if(editor instanceof CoreMultiDiagramEditor) {
			CoreMultiDiagramEditor core = (CoreMultiDiagramEditor)editor;
			try {
				DiSashModelMngr sashModelMngr = core.getServicesRegistry().getService(DiSashModelMngr.class);
				IPageMngr pageMngr = sashModelMngr.getIPageMngr();
				List<Object> allPages = pageMngr.allPages();
				// mark progress
				monitor.beginTask(Messages.LoadingUtils_RefreshPagesTask, allPages.size());
				List<URI> pagesURIToOpen = new ArrayList<URI>(allPages.size());
				for(Object o : allPages) {
					// refresh pages to cancel display of proxified elements
					if(o instanceof EObject) {
						EObject eobject = (EObject)o;
						if(!eobject.eIsProxy()) {
							URI trimFragment = eobject.eResource().getURI();
							String frag = eobject.eResource().getURIFragment(eobject);
							if(uriWithoutFileExtension.equals(trimFragment.trimFileExtension())) {
								// diagram was in unloaded resource. Refresh it.
								if(pageMngr.isOpen(eobject)) {
									pageMngr.closePage(eobject);
									pagesURIToOpen.add(trimFragment.appendFragment(frag));
								}
							}
						}
					}
					// mark progress
					monitor.worked(1);
				}
				// mark progress
				monitor.beginTask(Messages.LoadingUtils_UnloadModelsTask, modelSet.getResources().size());
				// unload resource
				for(Resource res : new ArrayList<Resource>(modelSet.getResources())) {
					if(res.getURI().trimFileExtension().equals(uriWithoutFileExtension)) {
						// unload this resource
						modelSet.getResources().remove(res);
						res.unload();
						res.eAdapters().clear();
					}
					// mark progress
					monitor.worked(1);
				}
				//				// mark progress
				//				monitor.beginTask("Resolve", 1);
				//				EcoreUtil.resolveAll(modelSet);
				//				monitor.worked(1);

				// mark progress
				monitor.beginTask(Messages.LoadingUtils_RefreshPagesTask, allPages.size());
				// reopen pages from proxies
				for(Object page : allPages) {
					if(page instanceof EObject) {
						EObject eobject = (EObject)page;
						if(eobject.eIsProxy()) {
							InternalEObject internal = (InternalEObject)eobject;
							URI uriProxy = internal.eProxyURI();
							if(pagesURIToOpen.contains(uriProxy)) {
								pageMngr.openPage(eobject);
							}
						}
					}
					// mark progress
					monitor.worked(1);
				}
			} catch (ServiceException e) {
				Activator.logError(e);
			}
		}
		// mark progress
		monitor.done();
		dialog.close();
	}

	/**
	 * Common extensions
	 * TODO get rid of listing all model's extensions and find a way to deduce them from model set. Then, delete this attribute.
	 * 
	 * @see #getExtensions(ModelSet)
	 */
	private static final Set<String> COMMON_EXTENSIONS = new HashSet<String>();
	static {
		COMMON_EXTENSIONS.add(UmlModel.UML_FILE_EXTENSION);
		COMMON_EXTENSIONS.add(NotationModel.NOTATION_FILE_EXTENSION);
		COMMON_EXTENSIONS.add(DiModel.DI_FILE_EXTENSION);
	}

	/**
	 * Get list of file extensions existing for this model set
	 * 
	 * @param modelSet
	 *        model set to find common extensions for
	 * @return extensions list to explore
	 */
	private static Set<String> getExtensions(ModelSet modelSet) {
		return COMMON_EXTENSIONS;
	}

	/**
	 * Get currently opened editor
	 * 
	 * @return editor
	 */
	public static IEditorPart getEditor() {
		IEditorPart editor = null;
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
			if(activeWorkbenchWindow != null) {
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				if(activePage != null) {
					editor = activePage.getActiveEditor();
				}
			}
		}
		return editor;
	}

	/**
	 * Get File from a URI
	 * 
	 * @param uri
	 *        the URI to transform
	 * @return the corresponding file
	 */
	public static IFile getFile(URI uri) {
		IPath path = getPath(uri);
		if(path != null) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
		return null;
	}

	/**
	 * Get Path from a URI
	 * 
	 * @param uri
	 *        the URI to transform
	 * @return the corresponding path
	 */
	public static IPath getPath(URI uri) {
		String scheme = uri.scheme();
		IPath path = null;
		if("platform".equals(scheme)) { //$NON-NLS-1$
			path = Path.fromPortableString(uri.toPlatformString(true));
		} else if("file".equals(scheme)) { //$NON-NLS-1$
			path = Path.fromPortableString(uri.toFileString());
		}
		return path;
	}
}
