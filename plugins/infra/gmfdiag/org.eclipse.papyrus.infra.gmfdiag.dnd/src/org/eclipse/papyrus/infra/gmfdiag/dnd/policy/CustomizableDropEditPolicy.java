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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DefaultActionHandler;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand;
import org.eclipse.papyrus.infra.gmfdiag.dnd.Activator;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DefaultDropStrategy;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;
import org.eclipse.swt.dnd.DND;
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

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".dropStrategy";

	protected EditPolicy defaultDropEditPolicy;

	protected EditPolicy defaultCreationEditPolicy;

	protected DropStrategy defaultDropStrategy;

	//FIXME: This comes from oep.uml.diagram.common.listener.DropTargetListener
	//This should be merged to oep.infra.gmfdiag.common, as this is not specific to UML
	public static final String EVENT_DETAIL = "EVENT_DETAIL";

	@Override
	public void activate() {
		//Nothing
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
		this.defaultDropStrategy = new DefaultDropStrategy(defaultDropEditPolicy, defaultCreationEditPolicy);
	}

	@Override
	public Command getCommand(final Request request) {
		Command command;

		if(super.understandsRequest(request)) {
			//Drag & Drop request
			try {
				command = super.getCommand(request); //Will call this.getDropObjectsCommand() eventually
			} catch (Exception ex) {
				command = getCustomCommand(request);
			}
		} else if(this.understands(request)) {
			//Add request
			command = getCreationCommand(request);
		} else if(defaultCreationEditPolicy != null) {
			//Creation request
			if(defaultCreationEditPolicy.understandsRequest(request)) {
				EditPart defaultTargetEditPart = defaultCreationEditPolicy.getTargetEditPart(request);
				EditPart myTargetEditPart = getTargetEditPart(request);
				if(defaultTargetEditPart != myTargetEditPart) {
					command = defaultTargetEditPart.getCommand(request);
				} else {
					command = defaultCreationEditPolicy.getCommand(request);
				}
			} else {
				command = null;
			}
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
		Command dropCommand = getCustomCommand(request);

		if(dropCommand != null && dropCommand.canExecute() && request.getObjects().size() > 1) {
			return layoutDroppedObjects(dropCommand);
		}

		return dropCommand;
	}

	protected Command layoutDroppedObjects(final Command dropCommand) {
		AbstractTransactionalCommand spacingCommand = new AbstractTransactionalCommand((TransactionalEditingDomain)EMFHelper.resolveEditingDomain(getHost()), "Spacing elements", Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				if(dropCommand instanceof ICommandProxy) {
					ICommand gmfCommand = ((ICommandProxy)dropCommand).getICommand();
					CommandResult previousCommandResult = gmfCommand.getCommandResult();
					if(previousCommandResult != null) {
						Object returnValue = previousCommandResult.getReturnValue();
						if(returnValue instanceof List<?>) {
							List<?> returnedElements = (List<?>)returnValue;

							int i = 0;
							for(Object returnedElement : returnedElements) {
								if(returnedElement instanceof CreateViewRequest.ViewDescriptor) {
									CreateViewRequest.ViewDescriptor newViewDescriptor = (CreateViewRequest.ViewDescriptor)returnedElement;
									Shape newShape = (Shape)newViewDescriptor.getAdapter(Shape.class);
									if(newShape != null) {
										LayoutConstraint constraint = newShape.getLayoutConstraint();
										if(constraint instanceof Bounds) {
											Bounds bounds = (Bounds)constraint;
											updateBounds(bounds, i);
											i++;
										}
									}
								}
							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}

		};

		return dropCommand.chain(new ICommandProxy(spacingCommand));
	}

	protected void updateBounds(Bounds bounds, int position) {
		int x = bounds.getX();
		int y = bounds.getY();
		bounds.setX(x + 15 * position);
		bounds.setY(y + 15 * position);
	}

	/**
	 * Returns the command from a Custom DropStrategy
	 * 
	 * @param request
	 * @return
	 */
	protected Command getCustomCommand(Request request) {
		final Map<DropStrategy, Command> matchingStrategies = findStrategies(request);

		//Only one strategy: return the associated command
		if(matchingStrategies.size() == 1) {
			return matchingStrategies.values().iterator().next();
		}

		//More than one strategy
		if(matchingStrategies.size() > 1) {
			boolean useDefault = true;

			//FIXME: What's the exact semantic of EVENT_DETAIL=DND_COPY in Papyrus?
			//Currently, DND_COPY corresponds to Ctrl + Drag/Drop
			if(request.getExtendedData().containsKey(EVENT_DETAIL)) {
				int eventDetailValue = (Integer)request.getExtendedData().get(EVENT_DETAIL);
				if((eventDetailValue & DND.DROP_COPY) != 0) {
					useDefault = false;
				}
			}

			//Search for a default strategy
			if(useDefault) {
				DropStrategy defaultStrategy = DropStrategyManager.instance.getDefaultDropStrategy(matchingStrategies.keySet());
				if(defaultStrategy != null) {
					return matchingStrategies.get(defaultStrategy);
				}
			}

			//If there is no default choice, ask user (Open a choice List)
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

			DefaultActionHandler handler = new DefaultActionHandler() {

				public void defaultActionSelected(Command defaultCommand) {
					DropStrategy defaultStrategy = findStrategy(matchingStrategies, defaultCommand);
					if(defaultStrategy != null) {
						DropStrategyManager.instance.setDefaultDropStrategy(matchingStrategies.keySet(), defaultStrategy);
					}
				}

				public String getLabel() {
					return "Change the default strategy";
				}
			};

			SelectAndExecuteCommand command = new SelectAndExecuteCommand("Select drop", shell, new LinkedList<Command>(matchingStrategies.values()), handler);
			return new ICommandProxy(command);
		}

		//No matching strategy
		return null;
	}

	private static DropStrategy findStrategy(Map<DropStrategy, Command> matchingStrategies, Command command) {
		for(Map.Entry<DropStrategy, Command> entry : matchingStrategies.entrySet()) {
			if(entry.getValue() == command) {
				return entry.getKey();
			}
		}
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

		for(DropStrategy strategy : DropStrategyManager.instance.getActiveStrategies()) {
			Command command = strategy.getCommand(request, getHost());
			if(command != null && command.canExecute()) {
				matchingStrategies.put(strategy, command);
			}
		}

		Command command = defaultDropStrategy.getCommand(request, getHost());
		if(command != null && command.canExecute()) {
			matchingStrategies.put(defaultDropStrategy, command);
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
