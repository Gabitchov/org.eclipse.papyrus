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
package org.eclipse.papyrus.infra.services.resourceloading.util;

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
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.services.resourceloading.Activator;
import org.eclipse.papyrus.infra.services.resourceloading.Messages;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
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
				IPageManager pageMngr = core.getServicesRegistry().getService(IPageManager.class);
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
											pageMngr.selectPage(newEObject);
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
		unloadResourcesFromModelSet(modelSet, uriWithoutFileExtension, true);
	}

	/**
	 * Unload corresponding resources from model set for all its existing models.
	 * 
	 * @param modelSet
	 *        the model set
	 * @param uriWithoutFileExtension
	 *        path of resources to unload without file extension
	 * @param refreshDiagramsWithProxies
	 *        true if we must refresh necessary diagrams, false to skip it.
	 */
	public static void unloadResourcesFromModelSet(ModelSet modelSet, URI uriWithoutFileExtension, boolean refreshDiagramsWithProxies) {
		// initiate progress dialog
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		dialog.open();
		IProgressMonitor monitor = dialog.getProgressMonitor();

		IEditorPart editor = getEditor();
		if(editor instanceof IMultiDiagramEditor) {
			IMultiDiagramEditor core = (IMultiDiagramEditor)editor;
			try {
				IPageManager pageMngr = core.getServicesRegistry().getService(IPageManager.class);
				List<Object> allPages = pageMngr.allPages();
				List<URI> pagesURIToOpen = new ArrayList<URI>(allPages.size());
				List<URI> pagesURIToRefresh = new ArrayList<URI>(allPages.size());
				if(refreshDiagramsWithProxies) {
					// mark progress
					monitor.beginTask(Messages.LoadingUtils_RefreshPagesTask, allPages.size());
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
								} else if(pageMngr.isOpen(eobject)) {
									// diagram is still loaded but may display proxified elements
									pagesURIToRefresh.add(trimFragment.appendFragment(frag));
								}
							}
						}
						// mark progress
						monitor.worked(1);
					}
				}
				// mark progress
				monitor.beginTask(Messages.LoadingUtils_UnloadModelsTask, modelSet.getResources().size());

				// Use the platform string of a normalized URI for comparison below, see bug 372326
				// (registered libraries in the model set have different URIs - e.g. due to a pathmap -
				// although they point to the same location).
				// TODO: Use a single detection mechanism in ResourceUpdateService and here
				String unloadPlatformString = uriWithoutFileExtension.toPlatformString(true);
				URIConverter uriConverter = modelSet.getURIConverter();
				// unload resource
				for(Resource res : new ArrayList<Resource>(modelSet.getResources())) {
					URI normalizedURI = uriConverter.normalize(res.getURI());
					String platformString = normalizedURI.trimFileExtension().toPlatformString(true);
					if((platformString != null) && platformString.equals(unloadPlatformString)) {
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

				if(refreshDiagramsWithProxies) {
					// mark progress
					monitor.beginTask(Messages.LoadingUtils_RefreshPagesTask, allPages.size());
					// reopen pages from proxies and refresh necessary pages
					for(Object page : allPages) {
						if(page instanceof EObject) {
							EObject eobject = (EObject)page;
							if(eobject.eIsProxy()) {
								// reopen page from proxy if needed
								InternalEObject internal = (InternalEObject)eobject;
								URI uriProxy = internal.eProxyURI();
								if(pagesURIToOpen.contains(uriProxy)) {
									pageMngr.openPage(eobject);
								}
							} else if(eobject instanceof Diagram) {
								// refresh page's diagram if needed
								Diagram diag = ((Diagram)eobject);
								if(pageMngr.isOpen(diag)) {
									Object part = ((IDiagramGraphicalViewer)core.getAdapter(IDiagramGraphicalViewer.class)).getEditPartRegistry().get(diag);
									if(part instanceof GraphicalEditPart) {
										// refresh nodes
										for(Object child : EditPartUtilities.getAllChildren((GraphicalEditPart)part)) {
											if(child instanceof EditPart) {
												((EditPart)child).refresh();
											}
										}
										// refresh edges
										for(Object child : EditPartUtilities.getAllNestedConnectionEditParts((GraphicalEditPart)part)) {
											if(child instanceof EditPart) {
												((EditPart)child).refresh();
											}
										}
									}
								}
							}
						}
						// mark progress
						monitor.worked(1);
					}
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
