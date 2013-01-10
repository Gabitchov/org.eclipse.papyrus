/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.Messages;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLNavigatorActionProvider extends CommonActionProvider {

	/**
	 * @generated
	 */
	private boolean myContribute;

	/**
	 * @generated
	 */
	private OpenDiagramAction myOpenDiagramAction;

	/**
	 * @generated
	 */
	@Override
	public void init(final ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if(aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			this.myContribute = true;
			makeActions((ICommonViewerWorkbenchSite)aSite.getViewSite());
		} else {
			this.myContribute = false;
		}
	}

	/**
	 * @generated
	 */
	private void makeActions(final ICommonViewerWorkbenchSite viewerSite) {
		this.myOpenDiagramAction = new OpenDiagramAction(viewerSite);
	}

	/**
	 * @generated
	 */
	@Override
	public void fillActionBars(final IActionBars actionBars) {
		if(!this.myContribute) {
			return;
		}
		final IStructuredSelection selection = (IStructuredSelection)getContext().getSelection();
		this.myOpenDiagramAction.selectionChanged(selection);
		if(this.myOpenDiagramAction.isEnabled()) {
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, this.myOpenDiagramAction);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public void fillContextMenu(final IMenuManager menu) {
	}

	/**
	 * @generated
	 */
	private static class OpenDiagramAction extends Action {

		/**
		 * @generated
		 */
		private Diagram myDiagram;

		/**
		 * @generated
		 */
		private final ICommonViewerWorkbenchSite myViewerSite;

		/**
		 * @generated
		 */
		public OpenDiagramAction(final ICommonViewerWorkbenchSite viewerSite) {
			super(Messages.NavigatorActionProvider_OpenDiagramActionName);
			this.myViewerSite = viewerSite;
		}

		/**
		 * @generated
		 */
		public final void selectionChanged(final IStructuredSelection selection) {
			this.myDiagram = null;
			if(selection.size() == 1) {
				Object selectedElement = selection.getFirstElement();
				if(selectedElement instanceof UMLNavigatorItem) {
					selectedElement = ((UMLNavigatorItem)selectedElement).getView();
				} else if(selectedElement instanceof IAdaptable) {
					selectedElement = ((IAdaptable)selectedElement).getAdapter(View.class);
				}
				if(selectedElement instanceof Diagram) {
					final Diagram diagram = (Diagram)selectedElement;
					if(TimingDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(diagram))) {
						this.myDiagram = diagram;
					}
				}
			}
			setEnabled(this.myDiagram != null);
		}

		/**
		 * @generated
		 */
		@Override
		public void run() {
			if(this.myDiagram == null || this.myDiagram.eResource() == null) {
				return;
			}

			final IEditorInput editorInput = getEditorInput(this.myDiagram);
			final IWorkbenchPage page = this.myViewerSite.getPage();
			try {
				page.openEditor(editorInput, UMLDiagramEditor.ID);
			} catch (final PartInitException e) {
				UMLDiagramEditorPlugin.getInstance().logError("Exception while openning diagram", e); //$NON-NLS-1$
			}
		}

		/**
		 * @generated
		 */
		private static IEditorInput getEditorInput(final Diagram diagram) {
			final Resource diagramResource = diagram.eResource();
			for(final EObject nextEObject : diagramResource.getContents()) {
				if(nextEObject == diagram) {
					return new FileEditorInput(WorkspaceSynchronizer.getFile(diagramResource));
				}
				if(nextEObject instanceof Diagram) {
					break;
				}
			}
			final URI uri = EcoreUtil.getURI(diagram);
			final String editorName = uri.lastSegment() + '#' + diagram.eResource().getContents().indexOf(diagram);
			final IEditorInput editorInput = new URIEditorInput(uri, editorName);
			return editorInput;
		}

	}

}
