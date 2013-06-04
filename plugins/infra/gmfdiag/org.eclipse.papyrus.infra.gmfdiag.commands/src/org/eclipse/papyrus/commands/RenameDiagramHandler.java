/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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
package org.eclipse.papyrus.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForIEvaluationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;

/**
 * This handler allows to rename a gmf diagram.
 * The handler is activated when the current selection denote a gmf diagram.
 * 
 * <br>
 * There is another RenameHandler in Papyrus (for modelexplorer): /org.eclipse.papyrus.infra.gmfdiag.modelexplorer/src/org/eclipse/papyrus/infra/gmfdiag/modelexplorer/handlers/RenameDiagramHandler.java
 * @author cedric dumoulin
 *
 */
public class RenameDiagramHandler extends AbstractHandler {

	public static String RenameDiagramHandler_NewName = "New name:";

	public static String RenameDiagramHandler_RenameAnExistingDiagram = "Rename an existing diagram";


	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @param event
	 * @return
	 * @throws ExecutionException
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		executeTransaction(event);
	
		return null;
	}

	/**
	 * Execute as transaction
	 * @param event 
	 */
	private void executeTransaction(ExecutionEvent event) {
	
		// Get requested objects
		final Diagram notationDiagramHelper;
		TransactionalEditingDomain editingDomain;
		try {
			IEvaluationContext context = getIEvaluationContext(event);
			notationDiagramHelper = lookupNotationDiagramChecked(context);
			editingDomain = lookupTransactionalEditingDomain(context);
		} catch (NotFoundException e) {
			// silently fails
			return;
		} catch (ServiceException e) {
			// silently fails
			return;
		}
	
		// Open the dialog to ask the new name
		String currentName = notationDiagramHelper.getName();
		String newName = null;
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), RenameDiagramHandler_RenameAnExistingDiagram, RenameDiagramHandler_NewName, currentName, null);
		if(dialog.open() == Window.OK) {
			newName = dialog.getValue();
			if(newName == null || newName.length() <= 0) {
				return;
			}
		}	
		else {
			// cancelled
			return;
		}
	
		final String name = newName;	
		Command cmd = new RecordingCommand(editingDomain, getCommandName()) {
	
			@Override
			protected void doExecute() {
				// Rename the diagram !
				notationDiagramHelper.setName(name);
			}
	
			
		};
	
		editingDomain.getCommandStack().execute(cmd);
	
	}

	/**
	 * Get the name used in the {@link RecordingCommand}. This name will be visible in 
	 * undo/redo.
	 * 
	 * @return The command name to show.
	 */
	public String getCommandName() {
		return "Rename Diagram";
	}

		protected IEvaluationContext getIEvaluationContext(ExecutionEvent event) throws NotFoundException {
			try {
				return (IEvaluationContext)event.getApplicationContext();
			} catch (ClassCastException e) {
				throw new NotFoundException("IEvaluationContext can't be found.");
			}
			
		}

	//	/**
	//	 * 
	//	 * @return
	//	 * @throws NotFoundException
	//	 */
	//	protected LayerStackMngr lookupLayerStackMngrChecked() throws NotFoundException {
	//		
	//		return lookupLayersViewChecked().getLayerStackMngrChecked();
	//		
	//	}
	
		/**
		 * Get the notation diagram helper.
		 * This method can be used from {@link #execute(ExecutionEvent)} or {@link #setEnabled(Object)}.
		 * 
		 * @return The 
		 * @throws NotFoundException
		 * @throws ServiceException 
		 */
		protected Diagram lookupNotationDiagramChecked(IEvaluationContext context) throws NotFoundException, ServiceException {
			
			
			// Get page from the event !
	//	    IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
			
			IEditorPart editor = ServiceUtilsForIEvaluationContext.getInstance().getNestedActiveIEditorPart(context);
	
			if( ! (editor instanceof DiagramDocumentEditor) ) {
				throw new NotFoundException("Selected editor do not contains Diagram");
			}
			DiagramDocumentEditor diagramEditor = (DiagramDocumentEditor)editor;
			
			Diagram diagram = diagramEditor.getDiagram();
			if(diagram == null) {
				throw new NotFoundException("Selected editor do not contains Diagram");			
			}
			
			// Return a new instance of the Helper
			return diagram;
		}

	/**
		 * Try to lookup the TransactionalEditingDomain.
		 * @return
		 * @throws ServiceException If the Editing domain can't be found.
		 */
		protected TransactionalEditingDomain lookupTransactionalEditingDomain(IEvaluationContext context) throws ServiceException {
	
			// Get page from the event !
	//	    IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
			
		    return ServiceUtilsForIEvaluationContext.getInstance().getTransactionalEditingDomain(context);
		}

	/**
	 * Called by framework. Need to set the enabled flag.
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		
		if( ! (evaluationContext instanceof IEvaluationContext)) {
			setBaseEnabled(false);
			return;
		}
		
		IEvaluationContext context = (IEvaluationContext)evaluationContext;
		
		try {
			// Try to get the diagram
			lookupNotationDiagramChecked(context);
	
			// ok, we got it.
			setBaseEnabled(true);
			
		} catch (ServiceException e) {
			// Can't find ServiceRegistry: disable
			setBaseEnabled( false);
		} catch (NotFoundException e) {
			// Can't find ServiceRegistry: disable
			setBaseEnabled( false);
		}
		
	}
}
