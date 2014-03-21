/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 * 
 */
package org.eclipse.papyrus.layers3.ui.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForIEvaluationContext;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers3.ui.commands.AbstractLayersCommand;
import org.eclipse.papyrus.layers3.ui.view.LayersExplorerView;
import org.eclipse.papyrus.layers3.ui.view.LayersExplorerViewUtils;
import org.eclipse.ui.IEditorPart;

/**
 * Remove the items selected in the diagram from the current Layer.
 * The current layer is the layer currently selected in the {@link LayersExplorerView}.
 * TODO Factorize methods common with {@link AttachDiagramSelectedItemsToCurrentLayer} in a parent class.
 * TODO use the {@link #preExecute(ExecutionEvent, IEvaluationContext, List)} method to get the requested selections.
 * 
 * @author cedric dumoulin
 *
 */
public class RemoveDiagramSelectedItemsFromCurrentLayer extends AbstractLayersCommand {

	/**
	 * 
	 */
	@Override
	public String getCommandName() {
		return "Attach Selected Items";
	}

	/**
	 * 
	 */
	@Override
	protected void doExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) {
		// TODO Auto-generated method stub
		
		
		List<View> diagramSelectedViews;
		Layer currentLayer;
		try {
			diagramSelectedViews = getSelectedViewsFromCurrentDiagramEditor(context);
			currentLayer = getSelectedLayerFromLayerExplorer(context);
		} catch (NotFoundException e) {
			// fail
			System.err.println("ERROR - " + this.getClass().getName() + " - " +e.getMessage());
			return;
		}
		
		System.out.println("selected views=" + diagramSelectedViews);
		System.out.println("selected layer=" + currentLayer.getName());
		
		currentLayer.getViews().removeAll(diagramSelectedViews);
	}
	
	/**
	 * Get the currently selected layer from the LayerExplorer.
	 * Throws an exception if not found.
	 * 
	 * @param context
	 * @return
	 */
	private Layer getSelectedLayerFromLayerExplorer(IEvaluationContext context) throws NotFoundException {


		LayersExplorerView layersExplorerView = LayersExplorerViewUtils.findView(context);
		ISelection selection;
		try {
			selection = layersExplorerView.getSite().getSelectionProvider().getSelection();
		} catch (NullPointerException e) {
			// Can't get a selection
			throw new NotFoundException("Can't get selection object from LayersExplorerView" + e); //$NON-NLS-1$
		}
		
		if(! (selection instanceof ITreeSelection)) {
			throw new NotFoundException("No selection in LayersExplorerView"); //$NON-NLS-1$
		}

		ITreeSelection treeSelection = (ITreeSelection)selection;

		Object firstSelection = treeSelection.getFirstElement();
		if( ! (firstSelection instanceof Layer) ) {
			throw new NotFoundException("LayersExplorerView first selection should be of type 'Layer'"); //$NON-NLS-1$			
		}
		return (Layer)firstSelection;
	}

	/**
	 * Get all selected Views in the currently active diagram.
	 * If no diagram is active, throw an exception.
	 * 
	 * @param context
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<View> getSelectedViewsFromCurrentDiagramEditor( IEvaluationContext context ) throws NotFoundException {
		// TODO Auto-generated method stub
		
		DiagramDocumentEditor diagramEditor = getNestedActiveDiagramDocumentEditor(context);
		
		ISelection selection = diagramEditor.getSite().getSelectionProvider().getSelection();
		
		if(! (selection instanceof IStructuredSelection || selection.isEmpty() )) {
			return Collections.emptyList();
		}

		IStructuredSelection structuredSelection = (IStructuredSelection)selection;

		// Get the views from the selected part
		List<View> result = new ArrayList<View>(structuredSelection.size());
//		for( Object obj : structuredSelection.toList() ) {
//			if( obj instanceof GraphicalEditPart ) {
//				GraphicalEditPart part = (GraphicalEditPart)obj;
//				View view = part.getNotationView();
//				result.add(view);
//			}
//		}
		for( Object obj : structuredSelection.toList() ) {
			// Adapt the selected object to a View.
			View view = (View)Platform.getAdapterManager().getAdapter(obj, View.class);
			if( view != null) {
				result.add(view);
			}
		}
		
		return result;
	}

	/**
	 * Get the active DiagramDocumentEditor.
	 * Throw an exception if not found.
	 * 
	 * @param context
	 * @return
	 * @throws NotFoundException 
	 */
	private DiagramDocumentEditor getNestedActiveDiagramDocumentEditor( IEvaluationContext context) throws NotFoundException {
		
		IEditorPart editor;
		try {
			editor = ServiceUtilsForIEvaluationContext.getInstance().getNestedActiveIEditorPart(context);
		} catch (ServiceException e) {
			throw new NotFoundException("Selected editor do not provides ServiceRegistry", e); //$NON-NLS-1$
		}
		
		if(!(editor instanceof DiagramDocumentEditor)) {
			throw new NotFoundException("Selected editor do not contains Diagram"); //$NON-NLS-1$
		}
		
		return (DiagramDocumentEditor)editor;
	}


}
