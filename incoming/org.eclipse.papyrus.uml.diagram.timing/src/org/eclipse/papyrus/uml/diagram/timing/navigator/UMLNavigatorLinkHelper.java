/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLNavigatorLinkHelper implements ILinkHelper {

	/**
	 * @generated
	 */
	private static IEditorInput getEditorInput(final Diagram diagram) {
		final Resource diagramResource = diagram.eResource();
		for (final EObject nextEObject : diagramResource.getContents()) {
			if (nextEObject == diagram) {
				return new FileEditorInput(WorkspaceSynchronizer.getFile(diagramResource));
			}
			if (nextEObject instanceof Diagram) {
				break;
			}
		}
		final URI uri = EcoreUtil.getURI(diagram);
		final String editorName = uri.lastSegment() + '#' + diagram.eResource().getContents().indexOf(diagram);
		final IEditorInput editorInput = new URIEditorInput(uri, editorName);
		return editorInput;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection findSelection(final IEditorInput anInput) {
		final IDiagramDocument document = UMLDiagramEditorPlugin.getInstance().getDocumentProvider().getDiagramDocument(anInput);
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated
	 */
	public void activateEditor(final IWorkbenchPage aPage, final IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		if (false == aSelection.getFirstElement() instanceof UMLAbstractNavigatorItem) {
			return;
		}

		final UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem) aSelection.getFirstElement();
		View navigatorView = null;
		if (abstractNavigatorItem instanceof UMLNavigatorItem) {
			navigatorView = ((UMLNavigatorItem) abstractNavigatorItem).getView();
		} else if (abstractNavigatorItem instanceof UMLNavigatorGroup) {
			final UMLNavigatorGroup navigatorGroup = (UMLNavigatorGroup) abstractNavigatorItem;
			if (navigatorGroup.getParent() instanceof UMLNavigatorItem) {
				navigatorView = ((UMLNavigatorItem) navigatorGroup.getParent()).getView();
			}
		}
		if (navigatorView == null) {
			return;
		}
		final IEditorInput editorInput = getEditorInput(navigatorView.getDiagram());
		final IEditorPart editor = aPage.findEditor(editorInput);
		if (editor == null) {
			return;
		}
		aPage.bringToTop(editor);
		if (editor instanceof DiagramEditor) {
			final DiagramEditor diagramEditor = (DiagramEditor) editor;
			final ResourceSet diagramEditorResourceSet = diagramEditor.getEditingDomain().getResourceSet();
			final EObject selectedView = diagramEditorResourceSet.getEObject(EcoreUtil.getURI(navigatorView), true);
			if (selectedView == null) {
				return;
			}
			final GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor.getAdapter(GraphicalViewer.class);
			final EditPart selectedEditPart = (EditPart) graphicalViewer.getEditPartRegistry().get(selectedView);
			if (selectedEditPart != null) {
				graphicalViewer.select(selectedEditPart);
			}
		}
	}

}
