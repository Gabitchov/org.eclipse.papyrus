/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.adapter;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;


public class GMFMultiDiagramAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adaptableObject instanceof IMultiDiagramEditor) {
			IEditorPart nestedEditor = ((IMultiDiagramEditor)adaptableObject).getActiveEditor();

			//The nestedEditor may or may not handle these cases.
			if(nestedEditor != null && nestedEditor instanceof IAdaptable) {
				if(adapterType == IDiagramGraphicalViewer.class) {
					return ((IAdaptable)nestedEditor).getAdapter(IDiagramGraphicalViewer.class);
				}

				if(adapterType == Diagram.class) {
					return ((IAdaptable)nestedEditor).getAdapter(Diagram.class);
				}

				if(adapterType == DiagramEditPart.class) {
					return ((IAdaptable)nestedEditor).getAdapter(DiagramEditPart.class);
				}

				if(adapterType == IDiagramWorkbenchPart.class) {
					return ((IAdaptable)nestedEditor).getAdapter(IDiagramWorkbenchPart.class);
				}
			}
		}

		return null;
	}

	public Class<?>[] getAdapterList() {
		return new Class<?>[]{ IMultiDiagramEditor.class };
	}

}
