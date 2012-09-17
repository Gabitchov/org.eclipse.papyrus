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
package org.eclipse.papyrus.infra.emf.diagram.common.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.infra.core.resource.notation.NotationUtils;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;

/**
 * Base class for create diagram Handlers.
 *  
 * @author cedric dumoulin
 * 
 */
public abstract class CreateDiagramHandler extends AbstractHandler implements IHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		TransactionalEditingDomain editingDomain = getEditingDomain();
		RecordingCommand command = new RecordingCommand(editingDomain, "Create EMF Diagram") {

			@Override
			protected void doExecute() {
				addNewDiagram();
			}

		};

		editingDomain.getCommandStack().execute(command);
		return null;
	}

	/**
	 * Subclasses should implements this method.
	 */
	protected abstract void addNewDiagram();

	/**
	 * Add a new Diagram to the graphical model.
	 * 
	 * @param diagram
	 *        The diagram to add to graphical model. This will be the diagram provided to
	 *        {@link IPluggableEditorFactory#createIPageModel(Object, org.eclipse.papyrus.infra.core.services.ServicesRegistry)}
	 */
	protected void addNewDiagram(String name, String type, EObject diagram) {

		// TODO Create a special node inside the sash model (di) instead of introducing 
		// a dependence on notation.
		// This implies to change the factory also.
		// The special node creation should be done by methods from sash
		// create di2node 
		Diagram di2Diagram = NotationFactory.eINSTANCE.createDiagram();
		di2Diagram.setVisible(true);
		di2Diagram.setType(type);
		if(name != null)
			di2Diagram.setName(name);

		// Add it to resource, so that it will be saved.
//		NotationUtils.getNotationResource().getContents().add(di2Diagram);
		NotationUtils.getNotationModel().addDiagram(di2Diagram);

		// Attach to sash in order to show it
		// Add the diagram as a page to the current sash folder
		EditorUtils.getISashWindowsContentProvider().addPage(di2Diagram);
	}

	/**
	 * Get the main editing doamin.
	 * 
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return EditorUtils.getTransactionalEditingDomain();
	}
}
