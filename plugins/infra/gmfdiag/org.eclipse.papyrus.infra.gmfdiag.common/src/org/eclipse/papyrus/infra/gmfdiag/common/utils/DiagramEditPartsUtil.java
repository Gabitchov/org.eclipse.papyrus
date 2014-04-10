/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Different utility methods to manage and manipulate edit parts in diagrams.
 */
public class DiagramEditPartsUtil {

	private DiagramEditPartsUtil() {
		//to prevent instanciation
	}

	/**
	 * Returns the edit part that controls the given view.
	 * 
	 * @param view
	 *        the view for which the edit part should be found. This should not be <code>null</code>
	 * @param anyEditPart
	 *        any edit part from which to get the edit part registry
	 * 
	 * @return the edit part that controls the given view or <code>null</code> if none was found
	 */
	public static EditPart getEditPartFromView(View view, EditPart anyEditPart) {
		if(view != null && anyEditPart != null) {
			return (EditPart)anyEditPart.getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * Gets the diagram edit part.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the diagram edit part
	 */
	public static DiagramEditPart getDiagramEditPart(EditPart editPart) {
		if(editPart == null) {
			return null;
		}

		if(editPart instanceof IGraphicalEditPart) {
			IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)editPart;
			View view = graphicalEditPart.getNotationView();
			Diagram diagram = view.getDiagram();
			Object object = graphicalEditPart.getViewer().getEditPartRegistry().get(diagram);
			if(object instanceof DiagramEditPart) {
				return (DiagramEditPart)object;
			}
		}

		if(editPart instanceof DiagramEditPart) {
			return (DiagramEditPart)editPart;
		}

		EditPart actual = editPart;
		EditPart parent = null;
		while((parent = actual.getParent()) != null) {
			if(parent instanceof DiagramEditPart) {
				return (DiagramEditPart)parent;
			} else {
				actual = parent;
			}
		}

		return null;
	}

	/**
	 * 
	 * @param ep
	 *        an edit part
	 * @return
	 *         all children edit part which are "top" semantic edit part
	 */
	public static Collection<EditPart> getAllTopSemanticEditPart(final EditPart ep) {
		final Collection<EditPart> editparts = new HashSet<EditPart>();
		for(final Object current : ep.getChildren()) {
			if(current instanceof EditPart) {
				editparts.addAll(getAllTopSemanticEditPart((EditPart)current));
				final EditPart topEP = getTopSemanticEditPart((EditPart)current);
				if(topEP != null) {
					editparts.add(topEP);
				}
			}
		}
		return editparts;
	}

	/**
	 * 
	 * @param ep
	 *        an editpart
	 * @return
	 *         the top edit part representing the same eobject or <code>null</code> if ep doesn't represent an editpart
	 */
	public static final EditPart getTopSemanticEditPart(final EditPart ep) {
		final EObject currentEObject = (EObject)ep.getAdapter(EObject.class);
		if(currentEObject != null) {
			EditPart previousParent = ep;
			EditPart parent = ep;
			while(parent != null) {
				if(parent.getAdapter(EObject.class) != currentEObject || parent instanceof DiagramEditPart) {
					return previousParent;
				}
				previousParent = parent;
				parent = parent.getParent();
			}
			return previousParent;
		}
		return null;
	}


	/**
	 * A utility method to return the active <code>DiagramEditPart</code> if
	 * the current part implements <code>IDiagramWorkbenchPart</code>
	 * 
	 * @return The current diagram if the parts implements <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	public static final IDiagramGraphicalViewer getActiveDiagramGraphicalViewer() {
		IDiagramWorkbenchPart part = getActiveDiagramWorkbenchPart();
		return part != null ? part.getDiagramGraphicalViewer() : null;
	}

	/**
	 * A utility method to return the active part if it implements
	 * or adapts to the <code>IDiagramWorkbenchPart</code> interface
	 * 
	 * @return The current part if it implements or adapts to <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	public static final IDiagramWorkbenchPart getActiveDiagramWorkbenchPart() {
		IDiagramWorkbenchPart diagramPart = null;

		IWorkbenchPart part = EditorHelper.getActivePart();

		if(part instanceof IDiagramWorkbenchPart) {
			diagramPart = (IDiagramWorkbenchPart)part;

		} else if(part != null) {
			diagramPart = (IDiagramWorkbenchPart)part.getAdapter(IDiagramWorkbenchPart.class);
		}

		return diagramPart;
	}

	/**
	 * 
	 * @param anEditPart
	 *        an edit part
	 * @return
	 *         the preference store for the diagram owning this edit part or <code>null</code> if not found
	 * 
	 */
	public static final IPreferenceStore getDiagramWorkspacePreferenceStore(final EditPart anEditPart) {
		final EditPartViewer viewer = anEditPart.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			return ((DiagramGraphicalViewer)viewer).getWorkspaceViewerPreferenceStore();
		}
		return null;
	}

	/**
	 * 
	 * @param anEditPart
	 *        an edit part
	 * @return
	 *         <code>true</code> if snap to grid is activated for the diagram owning the editpart
	 * 
	 */
	public static final boolean isSnapToGridActive(final EditPart anEditPart) {
		boolean result = false;
		final IPreferenceStore store = getDiagramWorkspacePreferenceStore(anEditPart);
		if(store != null) {
			result = store.getBoolean(PreferencesConstantsHelper.SNAP_TO_GRID_CONSTANT);
		}
		return result;
	}

	/**
	 * 
	 * @param anEditPart
	 *        an edit part
	 * @return
	 *         the value of the grid spacing or -1 if not found
	 */
	public static final double getDiagramGridSpacing(final EditPart anEditPart) {
		final RootEditPart rootEP = anEditPart.getRoot();
		if(rootEP instanceof DiagramRootEditPart) {
			return ((DiagramRootEditPart)rootEP).getGridSpacing();
		}
		return -1.0;
	}
}
