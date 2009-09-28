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
package org.eclipse.papyrus.core.adaptor.emf;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory;
import org.eclipse.papyrus.core.multidiagram.SashDiagramModelUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * @author dumoulin
 * 
 */
public abstract class CreateDiagramHandler extends AbstractHandler implements IHandler {

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

	protected abstract void addNewDiagram();

	/**
	 * Add a new Diagram to the graphical model.
	 * 
	 * @param diagram
	 *            The diagram to add to graphical model. This will be the diagram provided to {@link IEditorFactory#createEditorFor(org.eclipse.papyrus.backbone.IEditorContext, Object)}
	 */
	protected void addNewDiagram(String name, String type, EObject diagram) {
		// create di2node 
		Diagram di2Diagram = NotationFactory.eINSTANCE.createDiagram();
		di2Diagram.setVisible(true);
		di2Diagram.setType(type);
		if (name != null)
			di2Diagram.setName(name);

		// Add it to resource, so that it will be saved.
		getDiResource().getContents().add(di2Diagram);

		// Attach to sash in order to show it
		SashDiagramModelUtil.openDiagramInCurrentFolder(getDiResource(), di2Diagram);
	}

	/**
	 * Get the current MultiDiagramEditor.
	 * 
	 * @return
	 */
	protected IMultiDiagramEditor getMultiDiagramEditor() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		return (IMultiDiagramEditor) editorPart;
	}

	/**
	 * Get the shared object.
	 * 
	 * @return
	 */
	protected BackboneContext getDefaultContext() {
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		return (BackboneContext) editor.getDefaultContext();
	}

	/**
	 * Get the di resource.
	 * 
	 * @return
	 */
	private Resource getDiResource() {
		return getDefaultContext().getResourceSet().getDiResource();
	}

	/**
	 * Get the main editing doamin.
	 * 
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return getDefaultContext().getTransactionalEditingDomain();
	}
}
