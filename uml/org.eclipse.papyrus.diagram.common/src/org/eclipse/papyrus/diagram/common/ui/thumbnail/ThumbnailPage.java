/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.thumbnail;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.sasheditor.gef.SelectionSynchronizer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.Page;

/**
 * A thumbnail page implementation controlling directly the thumbnail.
 * 
 * @author dumoulin
 */
public class ThumbnailPage extends Page implements org.eclipse.ui.views.contentoutline.IContentOutlinePage {

	/**
	 * debug channel.
	 */
	protected static final int channel = 19;

	/**
	 * 
	 */
	private ScrollableThumbnail thumbnail;

	/**
	 * 
	 */
	private LightweightSystem lightweightSystem;

	/**
	 * 
	 */
	private Control control;

	/**
	 * 
	 */
	private EditPartViewer graphicalViewer;

	/** Selection Synchronizer for the thumbnail page */
	private SelectionSynchronizer selectionSynchronizer;

	/**
	 * Constructs a ContentOutlinePage for the given viewer.
	 * 
	 * @param viewer
	 *            the viewer for which a thumbnail should be created.
	 * @param selectionSynchronizer
	 */
	public ThumbnailPage(EditPartViewer viewer, SelectionSynchronizer selectionSynchronizer) {
		assert (viewer != null);
		this.graphicalViewer = viewer;
		this.selectionSynchronizer = selectionSynchronizer;
	}

	/**
	 * Do nothing, because this object doesn't fire selectionChange.
	 * 
	 * @param listener
	 * 
	 * @see ISelectionProvider#addSelectionChangedListener(ISelectionChangedListener)
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		// getViewer().addSelectionChangedListener(listener);
		// throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * Forwards the createControl request to the editpartviewer.
	 * 
	 * @param parent
	 * 
	 * @see org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {

		// An swt canvas drawing the figure.
		Canvas canvas = new Canvas(parent, SWT.NONE);
		// A draw2d object linkink swt and draw2d
		lightweightSystem = new LightweightSystem(canvas);

		RootEditPart rep = getGraphicalViewer().getRootEditPart();
		if (rep instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart root = (ScalableFreeformRootEditPart) rep;
			thumbnail = new ScrollableThumbnail((Viewport) root.getFigure());
			thumbnail.setBorder(new MarginBorder(3));
			thumbnail.setSource(root.getLayer(LayerConstants.PRINTABLE_LAYERS));
			lightweightSystem.setContents(thumbnail);
		}

		control = canvas;
		// hook to selection synchronizer
		if (getSelectionSynchronizer() != null) {
			getSelectionSynchronizer().addViewer(this);
		}

	}

	/**
	 * Dispose underlying objects.
	 */
	@Override
	public void dispose() {
		// deactivate the thumbnail
		// remove listeners or link to other elements
		if (getSelectionSynchronizer() != null) {
			getSelectionSynchronizer().removeViewer(this);
		}

		thumbnail.deactivate();
		thumbnail = null;
		super.dispose();

	}

	/**
	 * 
	 * 
	 * @return
	 */
	private EditPartViewer getGraphicalViewer() {
		return graphicalViewer;
	}

	/**
	 * 
	 * 
	 * @param viewer
	 */
	public void changeGraphicalViewer(EditPartViewer viewer) {
		graphicalViewer = viewer;

		RootEditPart rep = viewer.getRootEditPart();
		if (rep instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart root = (ScalableFreeformRootEditPart) rep;
			// To force revalidation
			thumbnail.setDirty(true);
			// set new figure and viewport
			thumbnail.setViewport((Viewport) root.getFigure());
			thumbnail.setSource(root.getLayer(LayerConstants.PRINTABLE_LAYERS));
		}
	}

	/**
	 * 
	 * 
	 * @param editor
	 */
	public void changeGraphicalEditor(GraphicalEditor editor) {

		GraphicalViewer viewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class);
		changeGraphicalViewer(viewer);
	}

	/**
	 * 
	 * 
	 * @return
	 * 
	 * @see org.eclipse.ui.part.IPage#getControl()
	 */
	@Override
	public Control getControl() {
		return control;
	}

	/**
	 * Forwards selection request to the viewer.
	 * 
	 * @return
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	public ISelection getSelection() {
		// $TODO when could this even happen?
		// if (getViewer() == null)
		return StructuredSelection.EMPTY;
		// return getViewer().getSelection();
	}

	/**
	 * 
	 * 
	 * @param listener
	 * 
	 * @see ISelectionProvider#removeSelectionChangedListener(ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		// getViewer().removeSelectionChangedListener(listener);
	}

	/**
	 * Sets focus to a part in the page.
	 */
	@Override
	public void setFocus() {
		if (getControl() != null) {
			getControl().setFocus();
		}
	}

	/**
	 * @param selection
	 * 
	 * @see ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) selection;
			Object editor = sel.getFirstElement();
			if (editor instanceof GraphicalEditor) {
				changeGraphicalEditor((GraphicalEditor) editor);
			}

		}
	}

	/**
	 * @return
	 */
	public SelectionSynchronizer getSelectionSynchronizer() {
		return selectionSynchronizer;
	}

}
