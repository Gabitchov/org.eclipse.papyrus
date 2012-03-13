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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.resourceloading.Messages;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
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
	 * Load a resource and its associated resources according to the registered extensions
	 * and the preferences
	 * 
	 * TODO : implements the refresh.
	 * Some code can be find in the svn history of this file but it was unstable.
	 * 
	 * @param mainURI
	 * @param modelSet
	 * @param refresh if true the views (diagrams) will be refreshed to display correctly resolved elements
	 * @param monitor
	 */
	public static void loadWithAssociatedResources(URI mainURI, ModelSet modelSet, boolean refresh, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask(Messages.LoadingUtils_LoadModelsTask, 1);
		try {
			// the loading of associated resources is done in getResource
			// by the OnDemandLoadingModelSet according to the registered extensions
			// and the preferences
			modelSet.getResource(mainURI, true);
		} catch (Exception e) {
			new NotificationBuilder().setAsynchronous(true).setTemporary(true).setDelay(5000).setMessage(e.getMessage()).setType(Type.ERROR).run();
		}
		monitor.worked(1);
	}

	/**
	 * Unload a resource and its associated resources by matching the file name of the resource.
	 * 
	 * TODO : implements the refresh.
	 * Some code can be find in the svn history of this file but it was unstable.
	 * 
	 * @param mainURI
	 * @param modelSet
	 * @param refreshProxies if true the views (diagrams) will be refreshed to display correctly unresolved elements
	 * @param monitor
	 */
	public static void unloadWithAssociatedResources(URI mainURI, ModelSet modelSet, boolean refresh, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		URI uriWithoutFileExtension = mainURI.trimFileExtension();

		monitor.beginTask(Messages.LoadingUtils_UnloadModelsTask, modelSet.getResources().size());
		Iterator<Resource> resIt = modelSet.getResources().iterator();
		while (resIt.hasNext()) {
			Resource res = resIt.next();
			if (res.getURI() != null && res.getURI().trimFileExtension().equals(uriWithoutFileExtension)) {

				// unload this resource
				res.unload();
				resIt.remove();
				res.eAdapters().clear();
			}
			monitor.worked(1);
		}

		EcoreUtil.resolveAll(modelSet);

		CoreMultiDiagramEditor editor = getCoreMultiDiagramEditor();

		if (editor != null) {
			IPageMngr pageMngr;
			try {
				pageMngr = editor.getServicesRegistry().getService(IPageMngr.class);
				if (pageMngr != null) {
					List<Object> allPages = pageMngr.allPages();
					monitor.beginTask(Messages.LoadingUtils_RefreshPagesTask, allPages.size());
					for(Object page : allPages) {
						if(page instanceof EObject) {
							EObject eobject = (EObject)page;
							if(eobject.eIsProxy()) {
								pageMngr.closePage(page);
							} else if (eobject instanceof Diagram) {
								Diagram diag = (Diagram) eobject;
								if (diag.getElement() != null && diag.getElement().eIsProxy()) {
									pageMngr.closePage(page);
								}
							}
						}
						monitor.worked(1);
					}
				}
			} catch (ServiceException e) {}
		}
	}

	/**
	 * Get currently opened editor
	 * 
	 * @return editor
	 */
	public static CoreMultiDiagramEditor getCoreMultiDiagramEditor() {
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
		if (editor instanceof CoreMultiDiagramEditor) {
			return (CoreMultiDiagramEditor)editor;
		}
		return null;
	}
}
