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
package org.eclipse.papyrus.documentation.view.papyrus;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
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
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.documentation.DocumentationManager;
import org.eclipse.papyrus.documentation.IDocumentationManager;
import org.eclipse.papyrus.documentation.view.IDocumentationPartHandler;
import org.eclipse.papyrus.documentation.view.SelectResourceDialog;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
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
		try {
			CoreMultiDiagramEditor editor = getPapyrusEditor(part);
			if(editor != null && cmd != null) {
				OperationHistoryFactory.getOperationHistory().execute(new TransactionalUncheckedCommandProxy((TransactionalEditingDomain)editor.getEditingDomain(), cmd), null, null);
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
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
			CoreMultiDiagramEditor editor = getPapyrusEditor(part);
			if(editor != null) {
				EditingDomain ed = editor.getEditingDomain();
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
						IPageMngr pageMngr = (IPageMngr)editor.getAdapter(IPageMngr.class);
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
		CoreMultiDiagramEditor editor = getPapyrusEditor(part);
		if(editor != null) {
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
			selectedElement = SelectResourceDialog.openElementSelection(editor.getServicesRegistry(), new MoDiscoLabelProvider(), new MoDiscoContentProvider(), validator, null, true);
		}
		return adapt(selectedElement);
	}

	public boolean isReadOnly(IWorkbenchPart part, EObject eObject) {
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

	private static CoreMultiDiagramEditor getPapyrusEditor(IWorkbenchPart part) {
		if(part instanceof CoreMultiDiagramEditor) {
			return (CoreMultiDiagramEditor)part;
		}
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(activeEditor instanceof CoreMultiDiagramEditor) {
			return (CoreMultiDiagramEditor)activeEditor;
		}
		return null;
	}
}
