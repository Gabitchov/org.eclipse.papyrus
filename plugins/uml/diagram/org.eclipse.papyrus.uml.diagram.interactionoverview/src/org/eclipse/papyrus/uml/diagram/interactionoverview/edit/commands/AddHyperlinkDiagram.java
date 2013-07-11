/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.hyperlink.helper.EditorHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;

public class AddHyperlinkDiagram extends AbstractTransactionalCommand {

	protected ICommand commandToGetView;
	
	protected ICommand commandToGetDiagram;
	
	public AddHyperlinkDiagram(final ICommand commandToGetView, final ICommand commandToGetDiagram) {
		super(((AbstractEMFOperation)commandToGetView).getEditingDomain(), Messages.AddHyperlinkDiagram_addHyperlinkCommand, null);
		this.commandToGetView = commandToGetView;
		this.commandToGetDiagram = commandToGetDiagram;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		View callBehaviorView = getViewFromViewCommand();
		Diagram diagram = (Diagram)commandToGetDiagram.getCommandResult().getReturnValue();
		
		//hyperlink management
		HyperLinkEditor hyperLinkEditor = new HyperLinkEditor();
		hyperLinkEditor.setObject(diagram);
		hyperLinkEditor.setIsDefault(true);
		hyperLinkEditor.setTooltipText(diagram.getName());
		
		EditorHyperLinkHelper helper = new EditorHyperLinkHelper();
		RecordingCommand command = helper.getAddHyperLinkCommand(getEditingDomain(), callBehaviorView, hyperLinkEditor);
		command.execute();
		return CommandResult.newOKCommandResult(hyperLinkEditor);
	}
	
	protected View getViewFromViewCommand(){
		if(commandToGetView != null){
			Object resultAsObject = commandToGetView.getCommandResult().getReturnValue();
			if(resultAsObject instanceof ViewDescriptor){
				final ViewDescriptor viewDescriptor = (ViewDescriptor)resultAsObject;
				return (View)viewDescriptor.getAdapter(View.class);
			}else if(resultAsObject instanceof View){
				return (View)resultAsObject;
			}
		}
		return null;
	}
}
