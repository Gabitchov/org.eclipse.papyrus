/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign.handlers;

import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.marte.table.assign.Activator;
import org.eclipse.papyrus.marte.table.assign.editor.AssignTableEditor;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Comment;

import com.google.common.collect.Iterables;


/**
 * Handles the "delete" command when in the assign table.
 * @author omelois
 *
 */
public class RemoveAssignHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Set<EObject> selection = this.getSelection();
		if(selection != null && !selection.isEmpty()){
			//Getting one item of the selection to reach the editing domain.
			EObject eObject = Iterables.getLast(selection);
			TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(eObject);

			//Compound command used to destroy all the selected comments.
			CompoundCommand deleteAssignsCompoundCommand = new CompoundCommand("Delete selected comments");
			//Adding delete commands to the compound.
			for(EObject selectedObject : selection) {
				if(selectedObject instanceof Comment) {
					Comment comment = (Comment)selectedObject;
					//Creating a destroy request for the context.
					DestroyElementRequest destroyElementRequest = new DestroyElementRequest(comment, false);
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(comment);
					if(provider != null) {
						ICommand GMFDeleteCommand = provider.getEditCommand(destroyElementRequest);
						if (GMFDeleteCommand != null){
							Command EMFDeleteCommand = new GMFtoEMFCommandWrapper(GMFDeleteCommand);
							deleteAssignsCompoundCommand.append(EMFDeleteCommand);
						}
					}
				}
			}
			editingDomain.getCommandStack().execute(deleteAssignsCompoundCommand);
		}
		return null;
	}

	/**
	 * Checks whether there are selected cells.
	 */
	@Override
	public boolean isEnabled() {
		Set<EObject> selection = this.getSelection();
		return (selection != null && !selection.isEmpty());
	}

	/**
	 * Get the model elements out of the selected rows from the assign table.
	 * @return
	 */
	public Set<EObject> getSelection(){
		IEditorPart activeEditor = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(activeEditor instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor multiDiagramEditor = (PapyrusMultiDiagramEditor)activeEditor;
			IEditorPart activeSubEditor = multiDiagramEditor.getActiveEditor();
			if(activeSubEditor instanceof AssignTableEditor) {
				AssignTableEditor assignTableEditor = (AssignTableEditor)activeSubEditor;
				return assignTableEditor.getModelElementsFromSelectedRow();
			}
		}
		return null;
	}
}
