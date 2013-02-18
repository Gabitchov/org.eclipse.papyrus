/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.openelement.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.PapyrusPageInput;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.openelement.Activator;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class OpenElementServiceImpl implements OpenElementService {

	private ServicesRegistry registry;

	//FIXME: This constant should be defined in the papyrus core plugin
	private static final String PAPYRUS_EDITOR_ID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.registry = servicesRegistry;
	}

	/**
	 * {@inheritDoc}
	 */
	public void startService() throws ServiceException {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeService() throws ServiceException {
		registry = null;
	}

	public IMultiDiagramEditor openElement(final EObject element) throws PartInitException, ServiceException {
		IMultiDiagramEditor editor = getCurrentEditor();

		URI[] pages = getPages(element);

		if(editor == null) {
			//Cannot find the IMultiDiagramEditor: try to open a new one

			IFile diFile = getDiFile(element);

			final IEditorInput input = new PapyrusPageInput(diFile, pages, false);

			RunnableWithResult<IMultiDiagramEditor> runnable;
			Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl() {

				public void run() {
					try {
						final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						IMultiDiagramEditor openedEditor = (IMultiDiagramEditor)IDE.openEditor(page, input, PAPYRUS_EDITOR_ID);
						setResult(openedEditor);
						setStatus(Status.OK_STATUS);
					} catch (PartInitException ex) {
						setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex));
					}
				}
			});

			if(runnable.getStatus().getSeverity() == IStatus.ERROR) {
				throw (PartInitException)runnable.getStatus().getException();
			}

			editor = runnable.getResult();
		} else {
			final IPageManager pageMngr = registry.getService(IPageManager.class);
			ModelSet modelSet = registry.getService(ModelSet.class);
			final List<EObject> pagesToOpen = new LinkedList<EObject>();
			final List<EObject> pagesToSelect = new LinkedList<EObject>();

			for(URI pageURI : pages) {
				final EObject page = modelSet.getEObject(pageURI, true);

				if(pageMngr.allPages().contains(page)) {
					if(pageMngr.isOpen(page)) {
						pagesToSelect.add(page);
					} else {
						pagesToOpen.add(page);
					}
				}
			}

			if(!pagesToOpen.isEmpty()) {
				TransactionalEditingDomain editingDomain = registry.getService(TransactionalEditingDomain.class);
				RecordingCommand command = new RecordingCommand(editingDomain, "Open pages") {

					@Override
					protected void doExecute() {
						for(EObject page : pagesToOpen) {
							pageMngr.openPage(page);
						}
					}
				};
				editingDomain.getCommandStack().execute(command);
			}

			for(EObject page : pagesToSelect) {
				pageMngr.selectPage(page);
			}
		}

		if(editor.getActiveEditor() instanceof IRevealSemanticElement) {
			final IRevealSemanticElement revealElement = (IRevealSemanticElement)editor.getActiveEditor();
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					revealElement.revealSemanticElement(Collections.singletonList(element));
				}
			});

		}

		return editor;
	}

	private URI[] getPages(EObject element) {
		try {
			IPageManager pageMngr = registry.getService(IPageManager.class);

			Collection<EStructuralFeature.Setting> usages = EMFHelper.getUsages(element);
			List<URI> result = new LinkedList<URI>();
			for(EStructuralFeature.Setting usage : usages) {
				EObject referencer = usage.getEObject();
				do {
					if(pageMngr.allPages().contains(referencer)) {
						result.add(EcoreUtil.getURI(referencer));
						break;
					}
				} while((referencer = referencer.eContainer()) != null);
			}

			return result.toArray(new URI[result.size()]);
		} catch (ServiceException ex) {
			//There is not IPageMngr: return all usages' URIs
			Set<URI> result = new HashSet<URI>();
			Collection<EStructuralFeature.Setting> usages = EMFHelper.getUsages(element);
			for(EStructuralFeature.Setting usage : usages) {
				EObject referencer = usage.getEObject();
				do {
					if(!result.add(EcoreUtil.getURI(referencer))) {
						break; //The result and its parents have already been added to the set
					}
				} while((referencer = referencer.eContainer()) != null);
			}

			return result.toArray(new URI[result.size()]);
		}
	}

	private IFile getDiFile(EObject element) {
		Resource resource = element.eResource();
		URI fileURI = resource.getURI();
		fileURI = fileURI.trimFileExtension();
		fileURI = fileURI.appendFileExtension(SashModel.MODEL_FILE_EXTENSION);

		if(fileURI.isPlatformResource()) {
			if(fileURI.segmentCount() > 1) {
				String projectName = fileURI.segment(1);
				URI baseURI = URI.createPlatformResourceURI(projectName + "/", true);
				URI relativeFileURI = fileURI.deresolve(baseURI);

				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IProject project = workspace.getRoot().getProject(projectName);
				IFile result = project.getFile(relativeFileURI.toString());
				if(result.exists()) {
					return result;
				} else {
					Activator.log.warn("The resource doesn't exist: " + fileURI);
				}
			}
		} else {
			Activator.log.warn("The element is not a platform resource. Cannot convert it to an IFile: " + fileURI);
		}

		return null;
	}

	private IMultiDiagramEditor getCurrentEditor() {
		try {
			IMultiDiagramEditor currentEditor = registry.getService(IMultiDiagramEditor.class);
			return currentEditor;
		} catch (ServiceException ex) {
			return null;
		}
	}

}
