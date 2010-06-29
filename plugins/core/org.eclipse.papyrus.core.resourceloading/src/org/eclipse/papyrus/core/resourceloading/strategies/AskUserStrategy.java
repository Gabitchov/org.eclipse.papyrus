/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.strategies;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.resourceloading.ILoadingStrategy;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class AskUserStrategy implements ILoadingStrategy {

	private Set<URI> alreadyValidated = new HashSet<URI>();

	private Set<URI> alreadyGuessed = new HashSet<URI>();

	private URI initialURI;

	public boolean loadResource(ModelSet modelSet, URI uri) {
		URI lastInitialURI = SashModelUtils.getInitialURI(modelSet).trimFileExtension();
		if(!lastInitialURI.equals(initialURI)) {
			clear();
			initialURI = lastInitialURI;
		}
		URI uritrimFragment = uri.trimFragment().trimFileExtension();
		boolean result = lastInitialURI.equals(uritrimFragment);
		if(!result) {
			result = alreadyValidated.contains(uritrimFragment);
			if(!result) {
				if(!alreadyGuessed.contains(uritrimFragment)) {
					String message = new StringBuffer("<form><p>Your model is linked to an external resource (").append(uritrimFragment.toString()).append(").</p><p>Do you want to load it ?</p></form>").toString();
					NotificationBuilder builder = getNotification(message, uritrimFragment, modelSet);
					builder.run();
					alreadyGuessed.add(uritrimFragment);
					// notification
				}
			}
		}
		return result;
	}

	protected void clear() {
		alreadyValidated.clear();
		alreadyGuessed.clear();
	}

	protected NotificationBuilder getNotification(String message, final URI uri, final ModelSet modelSet) {
		Runnable yes = new Runnable() {

			private DiSashModelMngr sashModelMngr;

			private IPageMngr pageMngr;

			public void run() {
				IEditorPart editor = getEditor();
				if(editor instanceof CoreMultiDiagramEditor) {
					CoreMultiDiagramEditor core = (CoreMultiDiagramEditor)editor;
					try {
						sashModelMngr = core.getServicesRegistry().getService(DiSashModelMngr.class);
						pageMngr = sashModelMngr.getIPageMngr();
						List<Object> allPages = pageMngr.allPages();
						// the uri is added after getting all the pages. If it is done before, the eobjects are resolved
						alreadyValidated.add(uri);
						for(Object o : allPages) {
							if(o instanceof EObject) {
								EObject eobject = (EObject)o;
								if(eobject.eIsProxy()) {
									InternalEObject internal = (InternalEObject)eobject;
									URI uriProxy = internal.eProxyURI();
									if(uri.equals(uriProxy.trimFragment().trimFileExtension())) {
										Resource r = modelSet.getResource(uriProxy.trimFragment(), true);
										if(r != null) {
											EObject eObject = r.getEObject(uriProxy.fragment());
											pageMngr.closePage(eObject);
											pageMngr.openPage(eObject);
										}
									}
								}
							}
						}
					} catch (ServiceException e) {
					}
				}
			}
		};
		Runnable no = new Runnable() {

			public void run() {
			}

		};
		return NotificationBuilder.createYesNo(message, yes, no).setHTML(true).setAsynchronous(true).setTitle("Load resource");
	}

	protected IEditorPart getEditor() {
		IEditorPart editor = null;
		IWorkbenchWindow activeWorkbenchWindow = getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null) {
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if(activePage != null) {
				editor = activePage.getActiveEditor();
			}
		}
		return editor;
	}

	protected IWorkbenchWindow getActiveWorkbenchWindow() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			return workbench.getActiveWorkbenchWindow();
		}
		return null;
	}

	protected IWorkbenchPage getActivePage() {
		IWorkbenchWindow activeWorkbenchWindow = getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null) {
			return activeWorkbenchWindow.getActivePage();
		}
		return null;
	}
}
