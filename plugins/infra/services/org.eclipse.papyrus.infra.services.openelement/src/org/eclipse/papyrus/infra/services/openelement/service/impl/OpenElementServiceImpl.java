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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.papyrus.infra.core.editor.IPapyrusPageInput;
import org.eclipse.papyrus.infra.core.editor.PapyrusPageInput;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.navigation.service.NavigationService;
import org.eclipse.papyrus.infra.services.openelement.Activator;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
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

	/**
	 * {@inheritDoc}
	 */
	public IMultiDiagramEditor openElement(EObject viewElement) throws PartInitException, ServiceException {
		URI pageURI = getPageForViewElement(viewElement);
		if(pageURI == null) {
			return null;
		}

		final IMultiDiagramEditor editor = openURI(pageURI);

		reveal(editor, viewElement);

		if(editor != null) {
			editor.getEditorSite().getPage().activate(editor);
		}
		return editor;
	}

	protected void reveal(final IMultiDiagramEditor editor, final EObject element) {
		if(editor != null) {
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					try {
						URI elementURI = EcoreUtil.getURI(element);
						ModelSet modelSet = editor.getServicesRegistry().getService(ModelSet.class);
						EObject elementToReveal = modelSet.getEObject(elementURI, false);

						if(elementToReveal == null) {
							return;
						}

						NavigationService navigationService = editor.getServicesRegistry().getService(NavigationService.class);
						if(navigationService != null) {
							navigationService.navigate(elementToReveal);
						}
					} catch (ServiceException ex) {
						Activator.log.error(ex);
					}
				}
			});

		}
	}

	/**
	 * {@inheritDoc}
	 */
	public IMultiDiagramEditor openSemanticElement(final EObject semanticElement) throws PartInitException, ServiceException {
		URI[] pages = getPagesForSemanticElement(semanticElement);
		IMultiDiagramEditor editor = openSemanticElement(semanticElement, pages);
		if(editor != null) {
			editor.getEditorSite().getPage().activate(editor);
		}
		return editor;
	}

	/**
	 * {@inheritDoc}
	 */
	public IMultiDiagramEditor openSemanticElement(EObject semanticElement, Object[] pages) throws PartInitException, ServiceException {
		URI[] pageURIs = new URI[pages.length];
		int i = 0;

		for(Object pageElement : pages) {
			URI uri = null;
			if(pageElement instanceof EObject) {
				uri = EcoreUtil.getURI((EObject)pageElement);
			}
			pageURIs[i++] = uri;
		}

		IMultiDiagramEditor editor = openSemanticElement(semanticElement, pageURIs);

		return editor;
	}

	private IMultiDiagramEditor openSemanticElement(final EObject semanticElement, URI[] pageURIs) throws ServiceException, PartInitException {
		IMultiDiagramEditor editor = getCurrentEditor();

		if(editor == null) {
			//Cannot find the IMultiDiagramEditor: try to open a new one
			URI diFile = getDiResourceURI(semanticElement);
			editor = openURIsInNewEditor(diFile, pageURIs);
		} else {
			final IPageManager pageMngr = registry.getService(IPageManager.class);
			ModelSet modelSet = registry.getService(ModelSet.class);
			final LinkedHashSet<EObject> pagesToOpen = new LinkedHashSet<EObject>();
			final LinkedHashSet<EObject> pagesToSelect = new LinkedHashSet<EObject>();

			for(URI pageURI : pageURIs) {
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

			//More than one editor can be visible (SashEditor). 
			//We need to select each page
			for(EObject page : pagesToSelect) {
				pageMngr.selectPage(page);
			}
		}

		reveal(editor, semanticElement);

		if(editor != null) {
			editor.getEditorSite().getPage().activate(editor);
		}

		return editor;
	}

	private URI[] getPagesForSemanticElement(EObject element) {
		try {
			IPageManager pageManager = registry.getService(IPageManager.class);

			Collection<EStructuralFeature.Setting> usages = EMFHelper.getUsages(element);
			List<URI> result = new LinkedList<URI>();
			for(EStructuralFeature.Setting usage : usages) {
				EObject referencer = usage.getEObject();
				do {
					if(pageManager.allPages().contains(referencer)) {
						result.add(EcoreUtil.getURI(referencer));
						break;
					}
				} while((referencer = referencer.eContainer()) != null);
			}

			return result.toArray(new URI[result.size()]);
		} catch (ServiceException ex) {
			//There is no IPageManager: return all usages' URIs
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

	private URI getPageForViewElement(EObject viewElement) {
		if(viewElement == null) {
			return null;
		}

		try {
			IPageManager pageManager = registry.getService(IPageManager.class);

			EObject currentViewElement = viewElement;
			while(currentViewElement != null) {
				if(pageManager.allPages().contains(currentViewElement)) {
					break;
				}

				currentViewElement = currentViewElement.eContainer();
			}

			if(currentViewElement != null) {
				return EcoreUtil.getURI(currentViewElement);
			}
		} catch (ServiceException ex) {
			//There is no IPageManager (The editor is not opened yet)	
			//The page is "probably" the root element of the view
			EObject rootElement = EcoreUtil.getRootContainer(viewElement);
			if(rootElement != null) {
				return EcoreUtil.getURI(rootElement);
			}
		}

		return null;
	}

	protected URI getDiResourceURI(URI uri) {
		URI fileURI = uri.trimFileExtension().trimFragment();
		fileURI = fileURI.appendFileExtension(SashModel.MODEL_FILE_EXTENSION);

		if(!exists(fileURI)) {
			Activator.log.warn("The resource doesn't exist: " + fileURI);
		} else {
			return fileURI;
		}

		return null;
	}

	protected boolean exists(URI uri) {
		try {
			ModelSet modelSet = registry.getService(ModelSet.class);
			return modelSet.getURIConverter().exists(uri, null);
		} catch (ServiceException e) {
			Activator.log.error(e);
			// no ModelSet? Must not exist, then
			return false;
		}
	}
	
	protected URI getDiResourceURI(EObject element) {
		Resource resource = element.eResource();
		URI fileURI = resource.getURI();
		return getDiResourceURI(fileURI);
	}

	private IMultiDiagramEditor getCurrentEditor() {
		try {
			IMultiDiagramEditor currentEditor = registry.getService(IMultiDiagramEditor.class);
			return currentEditor;
		} catch (ServiceException ex) {
			return null;
		}
	}

	private IMultiDiagramEditor openURI(URI pageURI) throws ServiceException, PartInitException {
		IMultiDiagramEditor editor = getCurrentEditor();
		if(editor == null) {
			//Cannot find the IMultiDiagramEditor: try to open a new one
			URI diFile = getDiResourceURI(pageURI);
			editor = openURIsInNewEditor(diFile, new URI[]{ pageURI });
		} else {
			final IPageManager pageManager = registry.getService(IPageManager.class);
			ModelSet modelSet = registry.getService(ModelSet.class);

			final EObject page = modelSet.getEObject(pageURI, true);

			if(pageManager.allPages().contains(page)) {
				if(pageManager.isOpen(page)) {
					pageManager.selectPage(page);
				} else {
					TransactionalEditingDomain editingDomain = registry.getService(TransactionalEditingDomain.class);
					RecordingCommand command = new RecordingCommand(editingDomain, "Open page") {

						@Override
						protected void doExecute() {
							pageManager.openPage(page);
						}
					};
					editingDomain.getCommandStack().execute(command);
				}
			}
		}

		return editor;
	}

	protected IMultiDiagramEditor openURIsInNewEditor(URI diResourceURI, URI[] pageURIs) throws PartInitException {
		final IEditorInput input = createPapyrusPageInput(diResourceURI, pageURIs);
		
		if (input == null) {
			return null;
		}
		
		RunnableWithResult<IMultiDiagramEditor> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IMultiDiagramEditor>() {

			public void run() {
				try {
					final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IMultiDiagramEditor openedEditor = openEditor(page, input);
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

		return runnable.getResult();
	}

	protected IPapyrusPageInput createPapyrusPageInput(URI diResourceURI, URI[] pageURIs) {
		IFile diFile = null;
		
		if((diResourceURI != null) && diResourceURI.isPlatformResource()) {
			diFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(diResourceURI.toPlatformString(true)));
		}
		
		return ((diFile == null) || !diFile.exists()) ? null : new PapyrusPageInput(diFile, pageURIs, false);
	}
	
	protected IMultiDiagramEditor openEditor(IWorkbenchPage workbenchPage, IEditorInput input) throws PartInitException {
		return (IMultiDiagramEditor)IDE.openEditor(workbenchPage, input, PAPYRUS_EDITOR_ID);
	}
	
}
