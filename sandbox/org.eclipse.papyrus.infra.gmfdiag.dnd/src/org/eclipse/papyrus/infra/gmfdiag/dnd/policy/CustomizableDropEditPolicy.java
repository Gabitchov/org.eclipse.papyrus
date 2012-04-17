/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.policy;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DefaultDropStrategy;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * An EditPolicy to handle Drop in Papyrus diagrams.
 * This edit policy can be customized from an extension point. If a customization
 * is not available, it will delegate the behavior to the default Drop edit policy
 * 
 * @author Camille Letavernier
 * 
 */
public class CustomizableDropEditPolicy extends DragDropEditPolicy {

	protected EditPolicy defaultDropEditPolicy;

	protected EditPolicy defaultCreationEditPolicy;

	protected final TreeMap<Integer, List<DropStrategy>> dropStrategies;

	@Override
	public void activate() {
	}

	/**
	 * Instantiates a new CustomizableDropEditPolicy
	 * 
	 * @param defaultEditPolicy
	 *        The default editPolicy, to be called when no custom Drop strategy is available
	 */
	public CustomizableDropEditPolicy(EditPolicy defaultDropEditPolicy, EditPolicy defaultCreationEditPolicy) {
		this.defaultDropEditPolicy = defaultDropEditPolicy;
		this.defaultCreationEditPolicy = defaultCreationEditPolicy;
		dropStrategies = new TreeMap<Integer, List<DropStrategy>>();
		addStrategy(new DefaultDropStrategy(defaultDropEditPolicy, defaultCreationEditPolicy));
	}

	protected void addStrategy(DropStrategy strategy) {
		getDropStrategies(strategy.getPriority()).add(strategy);
	}

	protected List<DropStrategy> getDropStrategies(int priority) {
		if(!dropStrategies.containsKey(priority)) {
			dropStrategies.put(priority, new LinkedList<DropStrategy>());
		}
		return dropStrategies.get(priority);
	}

	@Override
	public Command getCommand(final Request request) {
		final Command command;

		if(super.understandsRequest(request)) {
			//Drag & Drop request
			command = super.getCommand(request); //Will call this.getDropObjectsCommand() eventually
		} else if(this.understands(request)) {
			//Add request
			command = getCreationCommand(request);
		} else if(defaultCreationEditPolicy != null) {
			//Creation request
			command = defaultCreationEditPolicy.getCommand(request);
		} else {
			command = null;
		}

		if(command == null) {
			return null;
		}

		return command;
	}

	@Override
	public boolean understandsRequest(Request request) {
		return this.understands(request) || (defaultCreationEditPolicy != null && defaultCreationEditPolicy.understandsRequest(request)) || (defaultDropEditPolicy != null && defaultDropEditPolicy.understandsRequest(request));
	}

	protected boolean understands(Request request) {
		return RequestConstants.REQ_ADD.equals(request.getType());
	}

	protected Command getCreationCommand(Request request) {
		return getCustomCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getDropObjectsCommand(DropObjectsRequest request) {
		return getCustomCommand(request);
	}

	protected Command getCustomCommand(Request request) {
		Map<DropStrategy, Command> matchingStrategies = findStrategies(request);

		//Only one strategy: return the associated command
		if(matchingStrategies.size() == 1) {
			return matchingStrategies.values().iterator().next();
		}

		//More than one strategy
		if(matchingStrategies.size() > 1) {
			//Ask user (Open a choice List)
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			return new ICommandProxy(new SelectAndExecuteCommand("Select drop", shell, new LinkedList<Command>(matchingStrategies.values())));
			//return matchingStrategies.values().iterator().next(); //FIXME Any strategy
		}

		//No matching strategy
		return null;
	}

	/**
	 * Returns a map of DropStrategy / Command, for each Strategy which can handle
	 * the given request. All the returned commands are executable. The map may be empty.
	 * 
	 * @param request
	 * @return
	 */
	protected Map<DropStrategy, Command> findStrategies(Request request) {
		Map<DropStrategy, Command> matchingStrategies = new LinkedHashMap<DropStrategy, Command>();

		//		DropStrategy sample = new SampleDropStrategy();
		//		matchingStrategies.put(sample, sample.getCommand(request, getHost()));

		for(List<DropStrategy> strategies : dropStrategies.values()) {
			for(DropStrategy strategy : strategies) {
				Command command = strategy.getCommand(request, getHost());
				if(command != null && command.canExecute()) {
					matchingStrategies.put(strategy, command);
				}
			}

			if(!matchingStrategies.isEmpty()) {
				break;
			}
		}

		return matchingStrategies;
	}

	/**
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if(!(getHost() instanceof DiagramEditPart)) {
			super.showTargetFeedback(request);
		}
	}
}
