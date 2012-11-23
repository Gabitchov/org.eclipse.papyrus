/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view.papyrus;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.providers.MoDiscoContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.DiagramsUtil;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.views.documentation.DocumentationManager;
import org.eclipse.papyrus.views.documentation.IDocumentationManager;
import org.eclipse.papyrus.views.documentation.view.IDocumentationPartHandler;
import org.eclipse.papyrus.views.documentation.view.SelectResourceDialog;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;


public class PapyrusDocumentationPartHandler implements IDocumentationPartHandler {

	public boolean canHandlePart(IWorkbenchPart part) {
		return part instanceof CoreMultiDiagramEditor || part instanceof ModelExplorerPageBookView;
	}

	public IDocumentationManager getDocumentationManager() {
		return DocumentationManager.getInstance();
	}

	public void executeCommand(IWorkbenchPart part, Command cmd) {
		ServicesRegistry registry = getServicesRegistry(part);
		if(registry != null && cmd != null) {
			try {
				TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
				domain.getCommandStack().execute(cmd);
			} catch (ServiceException ex) {
				ex.printStackTrace(System.err);
			}
		}
	}

	public EObject getAssociatedDiagram(IWorkbenchPart part, EObject eObject) {
		if(eObject instanceof Diagram) {
			return null;
		}

		if(eObject != null) {
			if(part instanceof IDiagramWorkbenchPart) {
				Diagram currentDiagram = ((IDiagramWorkbenchPart)part).getDiagram();
				if(currentDiagram != null && eObject.equals(currentDiagram.getElement())) {
					return currentDiagram;
				}
			}
		}

		return null;
	}

	public void openElement(IWorkbenchPart part, URI elementUri) {
		try {
			ServicesRegistry registry = getServicesRegistry(part);
			if(registry != null) {
				EditingDomain ed = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
				if(ed != null) {
					EObject eObject = ed.getResourceSet().getEObject(elementUri, false);
					Diagram diagram = null;
					if(eObject instanceof Diagram) {
						diagram = (Diagram)eObject;
					} else {
						List<Diagram> diagrams = DiagramsUtil.getAssociatedDiagrams(eObject, null);
						if(!diagrams.isEmpty()) {
							diagram = diagrams.get(0);
						}
					}
					if(diagram != null) {
						IPageMngr pageMngr = ServiceUtils.getInstance().getIPageMngr(registry);
						if(pageMngr != null) {
							if(pageMngr.isOpen(diagram)) {
								pageMngr.closePage(diagram);
							}
							pageMngr.openPage(diagram);
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}

	public EObject openElementSelectionDialog(IWorkbenchPart part) {
		Object selectedElement = null;
		ServicesRegistry registry = getServicesRegistry(part);
		if(registry != null) {
			ISelectionStatusValidator validator = new ISelectionStatusValidator() {

				public IStatus validate(Object[] selectedElements) {
					boolean enableOK = false;
					if(selectedElements.length == 1) {
						Object selectedElement = selectedElements[0];
						if(adapt(selectedElement) != null) {
							enableOK = true;
						}
					}

					String msg = "";
					if(enableOK == false) {
						msg = "Only one EObject can be selected";
					}
					return enableOK ? new Status(IStatus.OK, "org.eclipse.emf.common.ui", 0, msg, null) : new Status(IStatus.ERROR, "org.eclipse.emf.common.ui", 0, msg, null);
				}
			};

			ILabelProvider labelProvider;
			try {
				labelProvider = registry.getService(LabelProviderService.class).getLabelProvider();
			} catch (ServiceException ex) {
				ex.printStackTrace(System.out);
				labelProvider = new LabelProvider();
			}

			selectedElement = SelectResourceDialog.openElementSelection(registry, labelProvider, new MoDiscoContentProvider(), validator, null, true);
		}
		return adapt(selectedElement);
	}

	public boolean isReadOnly(IWorkbenchPart part, EObject eObject) {
		ServicesRegistry registry = getServicesRegistry(part);
		if(registry != null && eObject != null) {
			try {
				TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
				return domain.isReadOnly(eObject.eResource());
			} catch (ServiceException ex) {
				ex.printStackTrace(System.out);
			}
		}
		return false;
	}

	private static EObject adapt(Object obj) {
		if(obj instanceof EObject) {
			return (EObject)obj;
		} else if(obj instanceof IAdaptable) {
			EObject adapted = (EObject)((IAdaptable)obj).getAdapter(EObject.class);
			return adapted;
		}
		return null;
	}

	private static ServicesRegistry getServicesRegistry(IWorkbenchPart part) {
		if(part instanceof IMultiDiagramEditor) {
			return ((IMultiDiagramEditor)part).getServicesRegistry();
		}
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(activeEditor instanceof IMultiDiagramEditor) {
			return ((IMultiDiagramEditor)activeEditor).getServicesRegistry();
		}
		return null;
	}
}
