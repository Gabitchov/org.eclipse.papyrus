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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLPackage;

public class CallBehaviorActionToInteractionDropStrategy extends
		TransactionalDropStrategy {

	private static final EStructuralFeature feature = UMLPackage.eINSTANCE.getActivity_Node();
	
	public String getLabel() {
		return "CallBehaviorAction drop into Interaction with snapshot";
	}

	public String getDescription() {
		return "CallBehaviorAction drop into Interaction with snapshot";
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".callBehaviorActionDrop";
	}

	public int getPriority() {
		return 0;
	}

	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		if( request instanceof CreateAspectUnspecifiedTypeConnectionRequest){
			return null;
		}
		CompositeCommand cc = new CompositeCommand(getLabel());

		EObject semanticElement = getTargetSemanticElement(targetEditPart);
		List<EObject> sourceElements = getSourceEObjects(request);
		List<CallBehaviorAction> valuesToAdd = new ArrayList<CallBehaviorAction>(sourceElements.size());
		for(EObject sourceElement : sourceElements) {
			if(!(sourceElement instanceof CallBehaviorAction)) {
				return null;
			}
			valuesToAdd.add((CallBehaviorAction)sourceElement);
		}

		if(!(semanticElement instanceof Activity)) {
			return null;
		}
		for (CallBehaviorAction callBehaviorAction : valuesToAdd) {
			cc.add(new CommandProxy(new RefreshCommandForUndo((GraphicalEditPart)targetEditPart)));
			ICommand dropCommand = new DropInteractionWithSnapshotCommand(getTransactionalEditingDomain(targetEditPart), (IGraphicalEditPart)targetEditPart, callBehaviorAction, "Drop CallBehaviorAction as Interaction");
			cc.add(dropCommand);
			CreateSnapshotForInteractionFromViewDescriptorCommand snapshotCommand = new CreateSnapshotForInteractionFromViewDescriptorCommand(getTransactionalEditingDomain(targetEditPart), dropCommand, (GraphicalEditPart)targetEditPart); 
			cc.add(snapshotCommand);
			cc.add(new AddHyperlinkDiagram(dropCommand, snapshotCommand));
			cc.add(new CommandProxy(new RefreshCommandForDo((GraphicalEditPart)targetEditPart)));
		}

		return cc.canExecute() ? new ICommandProxy(cc.reduce()) : null;
	}

}
