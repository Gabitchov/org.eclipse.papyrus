/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.gef;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * /** A utility for synchronizing the selection of multiple Viewers and EditPartViewers. This class performs selection synchronization by taking the
 * selection from one viewer, and mapping it to the
 * selection in another viewer. The mapping is performed by matching the models of the selected EditParts from one viewer to the EditParts with the
 * same models in another. The can be customized by
 * overriding the {@link #convertToEditPart(EditPartViewer, EditPart)} method.
 * 
 * @author dumoulin
 * 
 */
public class SelectionSynchronizer implements ISelectionChangedListener {

	/** List of gef viewers */
	private List<EditPartViewer> editPartViewers = new ArrayList<EditPartViewer>();

	/** List of other type of viewers implementing {@link ISelectionProvider} */
	private List<ISelectionProvider> viewers = new ArrayList<ISelectionProvider>();

	private boolean isDispatching = false;

	private int disabled = 0;

	private ISelectionProvider pendingSelection;

	/**
	 * Adds a viewer to the set of synchronized viewers
	 * 
	 * @param viewer
	 *        the viewer
	 */
	public void addViewer(EditPartViewer viewer) {
		viewer.addSelectionChangedListener(this);
		editPartViewers.add(viewer);
	}

	/**
	 * Adds a viewer to the set of synchronized viewers
	 * 
	 * @param viewer
	 *        the viewer
	 */
	public void addViewer(ISelectionProvider viewer) {
		viewer.addSelectionChangedListener(this);
		viewers.add(viewer);
	}

	/**
	 * Maps the given editpart from one viewer to an editpart in another viewer. It returns <code>null</code> if there is no corresponding part. This
	 * method can be overridden to provide custom
	 * mapping.
	 * 
	 * @param viewer
	 *        the viewer being mapped to
	 * @param part
	 *        a part from another viewer
	 * @return <code>null</code> or a corresponding editpart
	 */
	protected EditPart convertToEditPart(EditPartViewer viewer, EditPart part) {
		Object temp = viewer.getEditPartRegistry().get(part.getModel());
		EditPart newPart = null;
		if(temp != null) {
			newPart = (EditPart)temp;
		}
		return newPart;
	}

	/**
	 * Maps the given object from one viewer to an editpart in another viewer. It returns <code>null</code> if there is no corresponding part. This
	 * method can be overridden to provide custom mapping.
	 * 
	 * @param viewer
	 *        the viewer being mapped to
	 * @param part
	 *        a part from another viewer
	 * @return <code>null</code> or a corresponding editpart
	 */
	protected EditPart convertToEditPart(EditPartViewer viewer, Object obj) {
		Object temp = viewer.getEditPartRegistry().get(obj);
		EditPart newPart = null;
		if(temp != null) {
			newPart = (EditPart)temp;
		}
		return newPart;
	}

	/**
	 * Maps the given EditPart from one viewer to its model object.
	 * 
	 * @param part
	 *        a part from another viewer
	 * @return <code>null</code> or a corresponding editpart
	 */
	protected Object convertToModel(EditPart part) {
		return part.getModel();
	}

	/**
	 * Removes the viewer from the set of synchronized viewers
	 * 
	 * @param viewer
	 *        the viewer to remove
	 */
	public void removeViewer(EditPartViewer viewer) {
		viewer.removeSelectionChangedListener(this);
		editPartViewers.remove(viewer);
		if(pendingSelection == viewer)
			pendingSelection = null;
	}

	/**
	 * Removes the viewer from the set of synchronized viewers
	 * 
	 * @param viewer
	 *        the viewer to remove
	 */
	public void removeViewer(ISelectionProvider viewer) {
		viewer.removeSelectionChangedListener(this);
		viewers.remove(viewer);
		if(pendingSelection == viewer)
			pendingSelection = null;
	}

	/**
	 * Receives notification from one viewer, and maps selection to all other members.
	 * 
	 * @param event
	 *        the selection event
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		if(isDispatching)
			return;
		ISelectionProvider source = event.getSelectionProvider();
		if(disabled > 0) {
			pendingSelection = source;
		} else {
			ISelection selection = event.getSelection();
			if(source instanceof EditPartViewer) {
				// synchronize from EditPartViewer
				syncSelection((EditPartViewer)source, selection);
			} else {
				syncSelection(source, selection);
			}
		}
	}

	/**
	 * Synchronize from an editPartViewer
	 * 
	 * @param source
	 * @param selection
	 */
	private void syncSelection(EditPartViewer source, ISelection selection) {
		isDispatching = true;
		// sync EditPartViewers
		for(int i = 0; i < editPartViewers.size(); i++) {
			if(editPartViewers.get(i) != source) {
				EditPartViewer viewer = (EditPartViewer)editPartViewers.get(i);
				setViewerSelectionFromEditPartViewer(viewer, selection);
			}
		}
		// sync ISelectionProviders
		for(int i = 0; i < viewers.size(); i++) {
			if(viewers.get(i) != source) {
				ISelectionProvider viewer = (ISelectionProvider)viewers.get(i);
				setViewerSelectionFromEditPartViewer(viewer, selection);
			}
		}
		isDispatching = false;
	}

	/**
	 * Synchronize from an classic viewer implementing ISelectionProvider
	 * 
	 * @param source
	 * @param selection
	 */
	private void syncSelection(ISelectionProvider source, ISelection selection) {
		isDispatching = true;
		// sync EditPartViewers
		for(int i = 0; i < editPartViewers.size(); i++) {
			if(editPartViewers.get(i) != source) {
				EditPartViewer viewer = (EditPartViewer)editPartViewers.get(i);
				setViewerSelectionFromISelectionProvider(viewer, selection);
			}
		}
		// sync ISelectionProviders
		for(int i = 0; i < viewers.size(); i++) {
			if(viewers.get(i) != source) {
				ISelectionProvider viewer = (ISelectionProvider)viewers.get(i);
				setViewerSelectionFromISelectionProvider(viewer, selection);
			}
		}
		isDispatching = false;
	}

	/**
	 * Enables or disabled synchronization between viewers.
	 * 
	 * @since 3.1
	 * @param value
	 *        <code>true</code> if synchronization should occur
	 */
	public void setEnabled(boolean value) {
		if(!value)
			disabled++;
		else if(--disabled == 0 && pendingSelection != null) {

			if(pendingSelection instanceof EditPartViewer) {
				// synchronize from EditPartViewer
				syncSelection((EditPartViewer)pendingSelection, pendingSelection.getSelection());
			} else {
				syncSelection(pendingSelection, pendingSelection.getSelection());
			}
			pendingSelection = null;
		}
	}

	/**
	 * Set the selection from an EditPartViewer to an EditPartViewer.
	 * 
	 * @param viewer
	 * @param selection
	 */
	private void setViewerSelectionFromEditPartViewer(EditPartViewer viewer, ISelection selection) {

		// Construct a list of model elements from EditParts
		List<EditPart> result = new ArrayList<EditPart>();
		Iterator<EditPart> iter = ((IStructuredSelection)selection).iterator();
		while(iter.hasNext()) {
			EditPart part = convertToEditPart(viewer, (EditPart)iter.next());
			if(part != null)
				result.add(part);
		}
		// Set the list of model elements
		viewer.setSelection(new StructuredSelection(result));
		// Expose the last selected element.
		if(result.size() > 0)
			viewer.reveal((EditPart)result.get(result.size() - 1));
	}

	/**
	 * Set the selection from an EditPartViewer to an ISelectionProvider.
	 * 
	 * @param viewer
	 * @param selection
	 */
	private void setViewerSelectionFromEditPartViewer(ISelectionProvider viewer, ISelection selection) {

		// Construct a list of model elements from EditParts
		List<Object> result = new ArrayList<Object>();
		Iterator<EditPart> iter = ((IStructuredSelection)selection).iterator();
		while(iter.hasNext()) {
			Object model = convertToModel(iter.next());
			if(model != null)
				result.add(model);
		}
		// Set the list of model elements
		viewer.setSelection(new StructuredSelection(result));
	}

	/**
	 * Set the selection from an ISelectionProvider to a EditPartViewer.
	 * 
	 * @param viewer
	 * @param selection
	 */
	private void setViewerSelectionFromISelectionProvider(EditPartViewer viewer, ISelection selection) {
		List<EditPart> result = new ArrayList<EditPart>();
		Iterator<Object> iter = ((IStructuredSelection)selection).iterator();
		while(iter.hasNext()) {
			EditPart part = convertToEditPart(viewer, (Object)iter.next());
			if(part != null)
				result.add(part);
		}
		viewer.setSelection(new StructuredSelection(result));
		if(result.size() > 0)
			viewer.reveal((EditPart)result.get(result.size() - 1));
	}

	/**
	 * Set the selection from an ISelectionProvider to an ISelectionProvider.
	 * 
	 * @param viewer
	 * @param selection
	 */
	private void setViewerSelectionFromISelectionProvider(ISelectionProvider viewer, ISelection selection) {

		// Set the list of model elements
		viewer.setSelection(selection);
	}

}
