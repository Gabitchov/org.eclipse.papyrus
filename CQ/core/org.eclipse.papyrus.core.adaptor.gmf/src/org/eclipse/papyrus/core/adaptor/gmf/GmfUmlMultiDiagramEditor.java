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
package org.eclipse.papyrus.core.adaptor.gmf;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.views.palette.PalettePage;
import org.eclipse.gmf.runtime.common.ui.action.ActionManager;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.papyrus.sasheditor.extension.EditorFactoryRegistry;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.util.Util;
import org.eclipse.ui.part.IShowInTargetList;


/**
 * Multidiagram editors for GMF-UML generated diagrams.
 * @author dumoulin
 *
 */
public class GmfUmlMultiDiagramEditor extends GmfMultiDiagramEditor implements IDiagramWorkbenchPart {

	/**
	 * From generated UML diagram.
	 * Used by Utils.
	 */
	public static final String ID = "papyrus.multidiagram.gmf.uml.GmfUmlMultiDiagramEditor"; //$NON-NLS-1$

	/**
	 * Constructor.
	 *
	 */
	public GmfUmlMultiDiagramEditor()
	{
		super();
		System.out.println("Create GmfUmlMultiDiagramEditor");
//		setEditDomain(new DefaultEditDomain(this));
	}
	
	/**
	 * Create an instance of the ModelManagerEditor which will be used to manage the models.
	 * @return
	 */
	 protected ModelManagerEditor createModelManagerEditor()
	{
		return new UMLModelManagerEditor();
	}

		/**
		 * Return the EditorRegistry loading the extension points accepted by this editor.
		 * Should set the namespace.
		 */
		protected EditorFactoryRegistry createEditorRegistry() {
	      return new EditorFactoryRegistry(Activator.ID);
	    }
		

	/** 
	 * Returns the adapter for the specified key.
	 * 
	 * <P><EM>IMPORTANT</EM> certain requests, such as the property sheet, may be made before
	 * or after {@link #createPartControl(Composite)} is called. The order is unspecified by
	 * the Workbench.
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */

	public Object getAdapter(Class type) {
		
		// check if we need to retrieve adapter from the current editor.
		if (Display.getCurrent()!=null &&
				(type == IShowInTargetList.class 
				|| PalettePage.class == type
				|| PaletteViewer.class == type
				|| (ActionManager.class == type)
				|| (IDiagramEditDomain.class == type)
	            || (type == ZoomManager.class)
	            || (type == IUndoContext.class)
	            || (type == IOperationHistory.class) ) )
		{
			IEditorPart innerEditor = getActiveEditor();
			// see bug 138823 - prevent some subclasses from causing
			// an infinite loop
			if (innerEditor != null && innerEditor != this) {
				return Util.getAdapter(innerEditor, type);
			}
		}
		// Check if we require the documentProvider
		if(type == IEditingDomainProvider.class) 
		{
			return ((GmfMultiDiagramSharedObjects)getSharedObjects()).getDocumentProvider();
		}
		
//		Object res = loadedEditor.getAdapter(type);
//		if(res!=null)
//			return res;
//		if (type == IContentOutlinePage.class)
//		{
////			showStack();
//			return new TreeOutlinePage(new TreeViewer(), getEditDomain(), getActionRegistry(), getSelectionSynchronizer(), getModel());
//		}
//		if (type == IDiagramOverviewPage.class)
//		{
//			System.err.println("getAdapter(" + type+ ")");
////			showStack();
////			return new DiagramOverviewPage(new TreeViewer(), getEditDomain(), getActionRegistry(), getSelectionSynchronizer(), getModel());
//		}
		return super.getAdapter(type);
	}
	
}
