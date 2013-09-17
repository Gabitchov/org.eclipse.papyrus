/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.commands;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForIEvaluationContext;
import org.eclipse.papyrus.layers.runtime.NotationDiagramHelper;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.ui.IEditorPart;

/**
 * Base class for Commands on Layers.
 * This class provide utility methods to find the current Layer, LayerStack, ...
 * @author cedric dumoulin
 *
 */
public abstract class AbstractLayerStackCommand extends AbstractHandler {

	/**
	 * Constructor.
	 *
	 */
	public AbstractLayerStackCommand() {
		super();
	}

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
		final NotationDiagramHelper notationDiagramHelper;
		TransactionalEditingDomain editingDomain;
		try {
			IEvaluationContext context = getIEvaluationContext(event);
			notationDiagramHelper = lookupNotationDiagramHelperChecked(context);
			editingDomain = lookupTransactionalEditingDomain(context);
		} catch (NotFoundException e) {
			// silently fails
			return;
		} catch (ServiceException e) {
			// silently fails
			return;
		}


		Command cmd = new RecordingCommand(editingDomain, getCommandName()) {

			@Override
			protected void doExecute() {
				AbstractLayerStackCommand.this.doExecute(notationDiagramHelper);
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
	public abstract String getCommandName();

	/**
	 * Do the execution of the command.
	 * Subclass should implements this method.
	 * 
	 * @param notationDiagramHelper
	 */
	protected abstract void doExecute(NotationDiagramHelper notationDiagramHelper);

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

	
	protected IEvaluationContext getIEvaluationContext(ExecutionEvent event) throws NotFoundException {
		try {
			return (IEvaluationContext)event.getApplicationContext();
		} catch (ClassCastException e) {
			throw new NotFoundException("IEvaluationContext can't be found.");
		}
		
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
			System.out.println(getCommandName() + ".setEnabled(" + isEnabled() + ") - no context");
			return;
		}
		
		IEvaluationContext context = (IEvaluationContext)evaluationContext;
		
		try {
			NotationDiagramHelper diagramHelper = lookupNotationDiagramHelperChecked(context);

			// Ask the subclass
			setBaseEnabled(isEnabled(diagramHelper));
			
		} catch (ServiceException e) {
			// Can't find ServiceRegistry: disable
			setBaseEnabled( false);
		} catch (NotFoundException e) {
			// Can't find ServiceRegistry: disable
			setBaseEnabled( false);
		}
		
		
		System.out.println(getCommandName() + ".setEnabled(" + isEnabled() + ")");
	}
	
	/**
	 * Return true if the action is enabled, false otherwise.
	 * Subclasses should implements this method. The default implementation return true.
	 * @param notationDiagramHelper
	 * @return
	 */
	public boolean isEnabled(NotationDiagramHelper notationDiagramHelper) {
		return true;
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
		protected NotationDiagramHelper lookupNotationDiagramHelperChecked(IEvaluationContext context) throws NotFoundException, ServiceException {
			
			
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
			
			// Lookup the Layer model
			LayersModel layersModel = (LayersModel)ServiceUtilsForIEvaluationContext.getInstance().getModelSet(context).getModel(LayersModel.MODEL_ID);
			// Return a new instance of the Helper
			return new NotationDiagramHelper(layersModel, diagram);
		}

}
