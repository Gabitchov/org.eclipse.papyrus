/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLPaletteFactory;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

public class CustomPaletteFactory extends UMLPaletteFactory {

	private final static String CREATEOCCURRENCESPECIFICATIONCREATIONTOOL = "createOccurrenceSpecificationCreationTool"; //$NON-NLS-1$

	private final static String CREATEDESTRUCTIONOCCURRENCESPECIFICATIONCREATIONTOOL = "createDestructionOccurrenceSpecificationCreationTool"; //$NON-NLS-1$

	private final static String CREATESTATEDEFINITIONCREATIONTOOL = "createStateDefinitionCreationTool"; //$NON-NLS-1$

	private final static String CREATEMESSAGESYNCCREATIONTOOL = "createMessageSyncCreationTool"; //$NON-NLS-1$

	private final static String CREATEMESSAGEASYNCCREATIONTOOL = "createMessageAsyncCreationTool"; //$NON-NLS-1$

	private final static String CREATEMESSAGEREPLYCREATIONTOOL = "createMessageReplyCreationTool"; //$NON-NLS-1$

	private final static String CREATECREATEMESSAGECREATIONTOOL = "createCreateMessageCreationTool"; //$NON-NLS-1$

	private final static String CREATEDELETEMESSAGECREATIONTOOL = "createDeleteMessageCreationTool"; //$NON-NLS-1$

	private final static String CREATELOSTMESSAGECREATIONTOOL = "createLostMessageCreationTool"; //$NON-NLS-1$

	private final static String CREATEFOUNDMESSAGECREATIONTOOL = "createFoundMessageCreationTool"; //$NON-NLS-1$

	private final static String CREATETIMEOBSERVATIONCREATIONTOOL = "createTimeObservationCreationTool"; //$NON-NLS-1$

	private final static String CREATETIMECONSTRAINTCREATIONTOOL = "createTimeConstraintCreationTool"; //$NON-NLS-1$

	private final static String CREATEDURATIONOBSERVATIONCREATIONTOOL = "createDurationObservationCreationTool"; //$NON-NLS-1$

	private final static String CREATEDURATIONCONSTRAINTCREATIONTOOL = "createDurationConstraintCreationTool"; //$NON-NLS-1$

	private final static String CREATEGENERALORDERINGCREATIONTOOL = "createGeneralOrderingCreationTool"; //$NON-NLS-1$

	public final static String ORIGINAL_TARGET = "ORIGINAL_TARGET"; //$NON-NLS-1$

	@Override
	public Tool createTool(final String toolId) {
		if(toolId.equals(CREATEOCCURRENCESPECIFICATIONCREATIONTOOL)) {
			return createOccurrenceSpecificationCreationTool();
		} else if(toolId.equals(CREATEDESTRUCTIONOCCURRENCESPECIFICATIONCREATIONTOOL)) {
			return createDestructionOccurrenceSpecificationCreationTool();
		} else if(toolId.equals(CREATESTATEDEFINITIONCREATIONTOOL)) {
			return createStateDefinitionCreationTool();
		} else if(toolId.equals(CREATEMESSAGESYNCCREATIONTOOL)) {
			return createSyncMessageCreationTool();
		} else if(toolId.equals(CREATEMESSAGEASYNCCREATIONTOOL)) {
			return createAsyncMessageCreationTool();
		} else if(toolId.equals(CREATEMESSAGEREPLYCREATIONTOOL)) {
			return createReplyMessageCreationTool();
		} else if(toolId.equals(CREATECREATEMESSAGECREATIONTOOL)) {
			return createCreateMessageCreationTool();
		} else if(toolId.equals(CREATEDELETEMESSAGECREATIONTOOL)) {
			return createDeleteMessageCreationTool();
		} else if(toolId.equals(CREATELOSTMESSAGECREATIONTOOL)) {
			return createLostMessageCreationTool();
		} else if(toolId.equals(CREATEFOUNDMESSAGECREATIONTOOL)) {
			return createFoundMessageCreationTool();
		} else if(toolId.equals(CREATETIMEOBSERVATIONCREATIONTOOL)) {
			return createTimeObservationCreationTool();
		} else if(toolId.equals(CREATETIMECONSTRAINTCREATIONTOOL)) {
			return createTimeConstraintCreationTool();
		} else if(toolId.equals(CREATEDURATIONOBSERVATIONCREATIONTOOL)) {
			return createDurationObservationCreationTool();
		} else if(toolId.equals(CREATEDURATIONCONSTRAINTCREATIONTOOL)) {
			return createDurationConstraintCreationTool();
		} else if(toolId.equals(CREATEGENERALORDERINGCREATIONTOOL)) {
			return createNewGeneralOrderingCreationTool();
		}
		return super.createTool(toolId);
	}

	private static Tool createTimeObservationCreationTool() {
		return createNewTimeTool(UMLElementTypes.TimeObservation_16);
	}

	private static Tool createTimeConstraintCreationTool() {
		return createNewTimeTool(UMLElementTypes.TimeConstraint_15);
	}

	private static Tool createDurationObservationCreationTool() {
		return createNewDurationTool(UMLElementTypes.DurationObservation_17);
	}

	private static Tool createDurationConstraintCreationTool() {
		return createNewDurationTool(UMLElementTypes.DurationConstraint_18);
	}

	private static Tool createNewTimeTool(final IElementType elementType) {
		return new AspectUnspecifiedTypeCreationTool(Collections.singletonList(elementType)) {

			/**
			 * Redirect the creation request to the parent (Lifeline compartment), but keep the original target in the
			 * extended data for the creation command.
			 */
			@Override
			protected Command getCommand() {
				EditPart target = getTargetEditPart();
				final Request request = getTargetRequest();
				if(target != null && EditPartUtils.isEditPartFor(target, UMLPackage.eINSTANCE.getOccurrenceSpecification(), UMLPackage.eINSTANCE.getStateInvariant())) {
					@SuppressWarnings("unchecked")
					final Map<Object, Object> extendedData = request.getExtendedData();
					extendedData.put(ORIGINAL_TARGET, target);
					target = target.getParent();
					return target.getCommand(request);
				}
				return UnexecutableCommand.INSTANCE;
			}
		};
	}

	private static Tool createNewDurationTool(final IElementType elementType) {
		return new DurationCreationTool(elementType);
	}

	private static Tool createOccurrenceSpecificationCreationTool() {
		return new OccurrenceSpecificationCreationTool();
	}

	private static Tool createDestructionOccurrenceSpecificationCreationTool() {
		return new DestructionOccurrenceSpecificationCreationTool();
	}

	private static Tool createNewGeneralOrderingCreationTool() {
		return new GeneralOrderingCreationTool();
	}

	/** Overloaded to only let StateDefinitions be created in the StateDefinition compartment. */
	private static Tool createStateDefinitionCreationTool() {
		final List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Node_9);

		final Tool tool = new AspectUnspecifiedTypeCreationTool(types) {

			@Override
			protected Command getCommand() {
				if(!(getTargetEditPart() instanceof FullLifelineStateDefinitionCompartmentEditPartCN)) {
					return UnexecutableCommand.INSTANCE;
				}
				return super.getCommand();
			}
		};
		return tool;
	}

	private static Tool createSyncMessageCreationTool() {
		return new SpecificTypeCreationTool(UMLElementTypes.Message_3, MessageUtils.getAllowedMessageTargets(), MessageUtils.getAllowedMessageTargets());
	}

	private static Tool createAsyncMessageCreationTool() {
		return new SpecificTypeCreationTool(UMLElementTypes.Message_4, MessageUtils.getAllowedMessageTargets(), MessageUtils.getAllowedMessageTargets());
	}

	private static Tool createReplyMessageCreationTool() {
		return new SpecificTypeCreationTool(UMLElementTypes.Message_41, MessageUtils.getAllowedMessageTargets(), MessageUtils.getAllowedMessageTargets());
	}

	private static Tool createCreateMessageCreationTool() {
		return new SpecificTypeCreationTool(UMLElementTypes.Message_44, MessageUtils.getAllowedMessageTargets(), MessageUtils.getAllowedMessageTargets());
	}

	private static Tool createDeleteMessageCreationTool() {
		return new SpecificTypeCreationTool(UMLElementTypes.Message_47, MessageUtils.getAllowedMessageTargets(), MessageUtils.getAllowedMessageTargets());
	}

	private static Tool createLostMessageCreationTool() {
		return new AspectUnspecifiedTypeConnectionTool(Collections.singletonList(UMLElementTypes.Message_50)) {

			@Override
			protected Command getCommand() {
				final Object type = getTargetRequest().getType();
				if(RequestConstants.REQ_CONNECTION_END == type) {
					final CreateAspectUnspecifiedTypeConnectionRequest request = (CreateAspectUnspecifiedTypeConnectionRequest)getTargetRequest();
					final EditPart sourceEditPart = request.getSourceEditPart();

					// Note: the bounds must be computed before executing the command because the source may be an
					// OccurrenceSpecification that will get swapped to a MessageOccurrenceSpecification, thereby
					// changing the Figure and EditPart.
					final IFigure figure = ((GraphicalEditPart)sourceEditPart).getFigure();
					final Point figureLocation = new Point(figure.getBounds().getCenter());
					figure.getParent().translateToAbsolute(figureLocation);
					final Point location = request.getLocation();
					final double scale = FigureUtils.getScale(figure);
					final Point anchorLocation = new Point(location.x - figureLocation.x, location.y - figureLocation.y).scale(1.0 / scale);

					final Command superCommand = super.getCommand();
					final CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.add(superCommand);
					final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(sourceEditPart.getModel());

					// add a command that sets the initial anchor position using an EAnnotation
					compoundCommand.add(new ICommandProxy(new AbstractTransactionalCommand(editingDomain, Messages.CustomPaletteFactory_SetLostMessageOrigin, null) {

						@Override
						protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
							final Connector connector = findCreatedConnector(superCommand);
							MessageUtils.setMessageConnectorLocation(connector, anchorLocation);
							return CommandResult.newOKCommandResult();
						}
					}));
					return compoundCommand;
				}
				return super.getCommand();
			}
		};
	}

	private static Tool createFoundMessageCreationTool() {
		return new AspectUnspecifiedTypeConnectionTool(Collections.singletonList(UMLElementTypes.Message_53)) {

			@Override
			protected Command getCommand() {
				final CreateAspectUnspecifiedTypeConnectionRequest request = (CreateAspectUnspecifiedTypeConnectionRequest)getTargetRequest();
				final EditPart targetEditPart = request.getTargetEditPart();

				final Object type = getTargetRequest().getType();
				if(RequestConstants.REQ_CONNECTION_START == type) {
					MessageUtils.saveRequestStartLocation(request);
				}

				if(RequestConstants.REQ_CONNECTION_END == type) {
					final Point startLocation = MessageUtils.retrieveRequestStartLocation(request);

					// Note: the bounds must be computed before executing the command because the source may be an
					// OccurrenceSpecification that will get swapped to a MessageOccurrenceSpecification, thereby
					// changing the Figure and EditPart.
					final IFigure figure = ((GraphicalEditPart)targetEditPart).getFigure();
					final Point figureLocation = new Point(figure.getBounds().getCenter());
					figure.getParent().translateToAbsolute(figureLocation);
					final double scale = FigureUtils.getScale(figure);
					final Point anchorLocation = new Point(startLocation.x - figureLocation.x, startLocation.y - figureLocation.y).scale(1.0 / scale);

					final Command superCommand = super.getCommand();
					final CompoundCommand compoundCommand = new CompoundCommand();
					compoundCommand.add(superCommand);
					final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(targetEditPart.getModel());

					// add a command that sets the initial anchor position using an EAnnotation
					compoundCommand.add(new ICommandProxy(new AbstractTransactionalCommand(editingDomain, Messages.CustomPaletteFactory_SetFoundMessageTarget, null) {

						@Override
						protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
							final Connector connector = findCreatedConnector(superCommand);
							MessageUtils.setMessageConnectorLocation(connector, anchorLocation);
							return CommandResult.newOKCommandResult();
						}
					}));
					return compoundCommand;
				}
				return super.getCommand();
			}
		};
	}

	/** Find the Connector in the haystack (buried deep in a CommandResult within the command). */
	protected static Connector findCreatedConnector(final Command command) {
		if(command instanceof ICommandProxy) {
			final ICommandProxy commandProxy = (ICommandProxy)command;
			final ICommand iCommand = commandProxy.getICommand();
			final CommandResult commandResult = iCommand.getCommandResult();
			final Object returnValue = commandResult.getReturnValue();
			if(returnValue instanceof List<?>) {
				final List<?> resultList = (List<?>)returnValue;
				for(final Object resultElement : resultList) {
					if(resultElement instanceof ConnectionViewAndElementDescriptor) {
						final ConnectionViewAndElementDescriptor connectionViewAndElementDescriptor = (ConnectionViewAndElementDescriptor)resultElement;
						final View view = (View)connectionViewAndElementDescriptor.getAdapter(View.class);
						if(view instanceof Connector) {
							final Connector connector = (Connector)view;
							return connector;
						}
					}
				}
			}
		}
		throw new IllegalStateException("connector not found"); //$NON-NLS-1$
	}
}
