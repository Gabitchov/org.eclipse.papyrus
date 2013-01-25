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
package org.eclipse.papyrus.infra.nattable.common.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;


public class NattableEditorAdapterFactory implements IAdapterFactory {

	public Object getAdapter(final Object adaptableObject, final Class adapterType) {
		if(adaptableObject instanceof IMultiDiagramEditor) {
			final IEditorPart nestedEditor = ((IMultiDiagramEditor)adaptableObject).getActiveEditor();
			if(nestedEditor instanceof AbstractEMFNattableEditor) {
				System.out.println("adapted");
				return nestedEditor;
			}
		//
		//			//The nestedEditor may or may not handle these cases.
		//			if(nestedEditor != null && nestedEditor instanceof IAdaptable) {
		//				if(adapterType == IDiagramGraphicalViewer.class) {
		//					return ((IAdaptable)nestedEditor).getAdapter(IDiagramGraphicalViewer.class);
		//				}
		//
		//				if(adapterType == Diagram.class) {
		//					return ((IAdaptable)nestedEditor).getAdapter(Diagram.class);
		//				}
		//
		//				if(adapterType == DiagramEditPart.class) {
		//					return ((IAdaptable)nestedEditor).getAdapter(DiagramEditPart.class);
		//				}
		//
		//				if(adapterType == IDiagramWorkbenchPart.class) {
		//					return ((IAdaptable)nestedEditor).getAdapter(IDiagramWorkbenchPart.class);
		//				}
		//			}
		}
		System.out.println("cant be adapted");
		return null;
	}

	public Class<?>[] getAdapterList() {
		return new Class<?>[]{ IWorkbenchPart.class };
	}

}
