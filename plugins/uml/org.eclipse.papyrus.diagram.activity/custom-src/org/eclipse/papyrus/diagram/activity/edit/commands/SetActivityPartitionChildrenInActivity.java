/*******************************************************************************
 * Copyright (c) 2007-2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
 * implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class SetActivityPartitionChildrenInActivity.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class SetActivityPartitionChildrenInActivity extends Command {

	/** The parent activity. */
	Activity parentActivity = null;

	/** The actual command. */
	CompoundCommand actualCommand = new CompoundCommand();

	/**
	 * Instantiates a new sets the activity partition children in activity.
	 * 
	 * @param activityPartition
	 *            the activity partition
	 * @param activity
	 *            the activity
	 */
	public SetActivityPartitionChildrenInActivity(ActivityPartition activityPartition, Activity activity) {
		parentActivity = activity;

		addChildCommands(activityPartition, actualCommand);
	}

	/**
	 * Adds the child commands.
	 * 
	 * @param activityPartition
	 *            the activity partition
	 * @param cc
	 *            the cc
	 */
	private void addChildCommands(ActivityPartition activityPartition, CompoundCommand cc) {
		List<EObject> children = new ArrayList();
		children.addAll(activityPartition.getNodes());
		children.addAll(activityPartition.getSubpartitions());

		for (EObject eo : children) {
			addEObjectCommand(eo, cc);
		}
	}

	/**
	 * Adds the e object command.
	 * 
	 * @param object
	 *            the object
	 * @param cc
	 *            the cc
	 */
	private void addEObjectCommand(EObject object, CompoundCommand cc) {
		EReference reference = null;

		if (object instanceof ActivityNode) {
			reference = UMLPackage.eINSTANCE.getActivityNode_Activity();
			SetRequest request = new SetRequest(object, reference, parentActivity);
			cc.add(new ICommandProxy(new SetValueCommand(request)));
			return;
		}
		if (object instanceof ActivityPartition) {
			addChildCommands((ActivityPartition) object, cc);
			reference = UMLPackage.eINSTANCE.getActivityGroup_InActivity();
			SetRequest request = new SetRequest(object, reference, parentActivity);
			cc.add(new ICommandProxy(new SetValueCommand(request)));
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {

		if (actualCommand.size() <= 0)
			return true;

		return actualCommand.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		if (actualCommand.size() <= 0)
			return true;

		return actualCommand.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#chain(org.eclipse.gef.commands.Command)
	 */
	@Override
	public Command chain(Command command) {
		return actualCommand.chain(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		actualCommand.dispose();
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {

		if (actualCommand.size() <= 0)
			return;

		actualCommand.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getDebugLabel()
	 */
	@Override
	public String getDebugLabel() {
		return actualCommand.getDebugLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getLabel()
	 */
	@Override
	public String getLabel() {
		return actualCommand.getLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {

		if (actualCommand.size() <= 0)
			return;

		actualCommand.redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#setDebugLabel(java.lang.String)
	 */
	@Override
	public void setDebugLabel(String label) {
		actualCommand.setDebugLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		actualCommand.setLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {

		if (actualCommand.size() <= 0)
			return;

		actualCommand.undo();
	}

}
