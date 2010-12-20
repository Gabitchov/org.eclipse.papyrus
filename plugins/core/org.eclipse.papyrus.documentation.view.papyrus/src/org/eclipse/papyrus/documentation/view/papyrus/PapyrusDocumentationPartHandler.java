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

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.documentation.DocumentationManager;
import org.eclipse.papyrus.documentation.IDocumentationManager;
import org.eclipse.papyrus.documentation.view.IDocumentationPartHandler;
import org.eclipse.papyrus.documentation.view.SelectResourceDialog;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;


public class PapyrusDocumentationPartHandler implements IDocumentationPartHandler {

	public boolean canHandlePart(IWorkbenchPart part) {
		return part instanceof PapyrusMultiDiagramEditor || part instanceof MultiViewPageBookView;
	}

	public IDocumentationManager getDocumentationManager() {
		return DocumentationManager.getInstance();
	}

	public void executeCommand(IWorkbenchPart part, Command cmd) {
		try {
			OperationHistoryFactory.getOperationHistory().execute(new TransactionalUncheckedCommandProxy(EditorUtils.getTransactionalEditingDomain(), cmd), null, null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public EObject getAssociatedDiagram(IWorkbenchPart part, EObject eObject) {
		if(eObject instanceof Diagram) {
			return null;
		}
		return getFirstDiagramAssociatedToElement(eObject);
	}

	public void openElement(IWorkbenchPart part, URI elementUri) {
		try {
			EditingDomain ed = EditorUtils.getTransactionalEditingDomain();
			if(ed != null) {
				EObject eObject = ed.getResourceSet().getEObject(elementUri, false);
				Diagram diagram = null;
				if(eObject instanceof Diagram) {
					diagram = (Diagram)eObject;
				} else {
					diagram = getFirstDiagramAssociatedToElement(eObject);
				}
				if(diagram != null) {
					IPageMngr pageMngr = EditorUtils.getIPageMngr();
					if(pageMngr.isOpen(diagram)) {
						pageMngr.closePage(diagram);
					}
					pageMngr.openPage(diagram);
				}
			}
		} catch (Exception e) {
		}
	}

	public EObject openElementSelectionDialog(IWorkbenchPart part) {
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

		return adapt(SelectResourceDialog.openElementSelection(EditorUtils.getServiceRegistry(), new MoDiscoLabelProvider(), new MoDiscoContentProvider(), validator, null, true));
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

	private static Diagram getFirstDiagramAssociatedToElement(EObject element) {
		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(element);
		if(crossReferencer != null) {
			Collection<Setting> settings = crossReferencer.getNonNavigableInverseReferences(element);
			for(Setting setting : settings) {
				if(setting.getEObject() instanceof View) {
					View view = (View)setting.getEObject();
					return view.getDiagram();
				}
			}
		}
		return null;
	}
}
