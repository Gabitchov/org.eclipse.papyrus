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
package org.eclipse.papyrus.layers3.ui.commands;



import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForIEvaluationContext;
import org.eclipse.papyrus.layers.runtime.NotationDiagramHelper;
import org.eclipse.papyrus.layers.runtime.model.LayersModel;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.ui.IEditorPart;

/**
 * Base class for Commands on Layers.
 * This class provide utility methods to find the current Layer, LayerStack, ...
 * @author cedric dumoulin
 *
 */
public abstract class AbstractLayersCommand extends AbstractHandler {

	/**
	 * Constructor.
	 *
	 */
	public AbstractLayersCommand() {
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
		
		// Get requested objects
		IEvaluationContext context;
		List<Object> selections;
		try {
			context = getIEvaluationContext(event);
			selections = getSelections(context);
		} catch (NotFoundException e) {
			// silently fails
			return null;
		}


		// Execute the command in 3 phases
		if (!preExecute(event, context, selections) ) {
			return null;
		}
		executeTransaction(event, context, selections);
		postExecute(event, context, selections);

		return null;
	}

	/**
	 * Method call prior to doExecute
	 * This method should be overloaded by subclass wishing to initialize the command
	 * outside of the transaction.
	 * 
	 * @param event
	 * @param selections 
	 * @param context 
	 * @return true if the doExecute() should be called, false if the command should stop
	 */
	protected boolean preExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) throws ExecutionException {
		return true;
	}

	/**
	 * Method call after {@link #doExecute(ExecutionEvent, IEvaluationContext, List)}
	 * This method should be overloaded by subclass wishing to do some post-processing
	 * outside of the transaction.
	 * 
	 * @param event
	 * @param selections 
	 * @param context 
	 */
	protected void postExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections) throws ExecutionException {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Execute as transaction
	 * @param event 
	 * @param selections 
	 * @param context 
	 */
	private void executeTransaction(ExecutionEvent event, final IEvaluationContext context, final List<Object> selections) {

		// Get requested objects
		final TransactionalEditingDomain editingDomain;
		final ExecutionEvent finalEvent = event;
		try {
			editingDomain = lookupTransactionalEditingDomain(context);
		} catch (ServiceException e) {
			// silently fails
			return;
		}


		Command cmd = new RecordingCommand(editingDomain, getCommandName()) {

			@Override
			protected void doExecute() {
				AbstractLayersCommand.this.doExecute(finalEvent, context, selections);
			}

			
		};

		editingDomain.getCommandStack().execute(cmd);

	}

	/**
	 * get the selected objects from the context.
	 * @param context
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<Object> getSelections(IEvaluationContext context) {
		Object sel = context.getVariable("selection");
		if(! (sel instanceof IStructuredSelection)) {
			return Collections.emptyList();
		}

		IStructuredSelection structuredSelection = (IStructuredSelection)sel;

		return structuredSelection.toList();
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
	protected abstract void doExecute(ExecutionEvent event, IEvaluationContext context, List<Object> selections);

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

		List<Object> selections = getSelections(context);
		// Ask the subclass
		setBaseEnabled(isEnabled(context, selections));
		
		
		System.out.println(getCommandName() + ".setEnabled(" + isEnabled() + ")");
	}
	
	/**
	 * Return true if the action is enabled, false otherwise.
	 * Subclasses should implements this method. The default implementation return true.
	 * @param context
	 * @return
	 */
	public boolean isEnabled(IEvaluationContext context, List<Object> selections) {
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
	 * lookup the notation diagram helper.
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

	/**
	 * lookup the LayerStack application object from context..
	 * This method can be used from {@link #execute(ExecutionEvent)} or {@link #setEnabled(Object)}.
	 * 
	 * @return The 
	 * @throws NotFoundException
	 * @throws ServiceException 
	 * @throws org.eclipse.papyrus.infra.core.resource.NotFoundException 
	 */
	protected LayersStackApplication lookupLayersStackApplicationChecked(IEvaluationContext context) throws NotFoundException, ServiceException, org.eclipse.papyrus.infra.core.resource.NotFoundException {
		
		ModelSet modelSet = ServiceUtilsForIEvaluationContext.getInstance().getModelSet(context);
		LayersModel model = (LayersModel)modelSet.getModelChecked(LayersModel.MODEL_ID);

		return model.lookupLayerStackApplication();
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
		
			IEditorPart editor = ServiceUtilsForIEvaluationContext.getInstance().getNestedActiveIEditorPart(context);
		
			if(!(editor instanceof DiagramDocumentEditor)) {
				throw new NotFoundException("Selected editor do not contains Diagram"); //$NON-NLS-1$
			}
			DiagramDocumentEditor diagramEditor = (DiagramDocumentEditor)editor;
		
			Diagram diagram = diagramEditor.getDiagram();
			if(diagram == null) {
				throw new NotFoundException("Selected editor do not contains Diagram"); //$NON-NLS-1$
			}
		
			// Return a new instance of the Helper
			return diagram;
		}

		/**
		 * Return true if the first element of the selection is instance of the specified type.
		 */
		protected boolean selectionFirstElementInstanceOf(List<Object> selections, Class<?> type) {
	        if( selections.size() != 1) {
	        	return false;
	        }
	        Object first = selections.get(0);
			return type.isInstance(first);
		}

}
