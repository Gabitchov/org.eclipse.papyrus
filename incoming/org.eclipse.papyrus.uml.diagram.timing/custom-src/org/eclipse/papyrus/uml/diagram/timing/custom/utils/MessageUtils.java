/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageReplyEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public final class MessageUtils {

	private static final String MESSAGE_CONNECTOR_LOCATION = "messageConnectorLocation"; //$NON-NLS-1$
	private static final String START_LOCATION = "startLocation"; //$NON-NLS-1$
	private static final String X = "x"; //$NON-NLS-1$
	private static final String Y = "y"; //$NON-NLS-1$

	/** Used for feedback when drawing a MessageFound */
	public static Point lastStartLocation = new Point();

	private MessageUtils() {
		// utility class
	}

	public static boolean isMessage(final IElementType requestElementType) {
		return requestElementType == UMLElementTypes.Message_3 || requestElementType == UMLElementTypes.Message_4
				|| requestElementType == UMLElementTypes.Message_41 || requestElementType == UMLElementTypes.Message_44
				|| requestElementType == UMLElementTypes.Message_47 || requestElementType == UMLElementTypes.Message_50
				|| requestElementType == UMLElementTypes.Message_53;
	}

	public static boolean isMessage(final int visualID) {
		return visualID == MessageSyncEditPart.VISUAL_ID || visualID == MessageAsyncEditPart.VISUAL_ID || visualID == MessageReplyEditPart.VISUAL_ID
				|| visualID == MessageCreateEditPart.VISUAL_ID || visualID == MessageDeleteEditPart.VISUAL_ID || visualID == MessageFoundEditPart.VISUAL_ID
				|| visualID == MessageLostEditPart.VISUAL_ID;
	}

	public static MessageKind getMessageKind(final IElementType requestElementType) {
		if (requestElementType == UMLElementTypes.Message_3 || requestElementType == UMLElementTypes.Message_4
				|| requestElementType == UMLElementTypes.Message_41 || requestElementType == UMLElementTypes.Message_44
				|| requestElementType == UMLElementTypes.Message_47) {
			return MessageKind.UNKNOWN_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_50) {
			return MessageKind.LOST_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_53) {
			return MessageKind.FOUND_LITERAL;
		}
		return null;
	}

	public static MessageSort getMessageSort(final IElementType requestElementType) {
		if (requestElementType == UMLElementTypes.Message_3) {
			return MessageSort.SYNCH_CALL_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_4) {
			return MessageSort.ASYNCH_CALL_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_41) {
			return MessageSort.REPLY_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_44) {
			return MessageSort.CREATE_MESSAGE_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_47) {
			return MessageSort.DELETE_MESSAGE_LITERAL;
		}
		if (requestElementType == UMLElementTypes.Message_50 || requestElementType == UMLElementTypes.Message_53) {
			// lost or found message
			return MessageSort.SYNCH_CALL_LITERAL;
		}
		return null;
	}

	public static IElementType getElementType(final Message message) {
		switch (message.getMessageKind()) {
		case LOST_LITERAL:
			return UMLElementTypes.Message_50;
		case FOUND_LITERAL:
			return UMLElementTypes.Message_53;
		default:
		}

		switch (message.getMessageSort()) {
		case SYNCH_CALL_LITERAL:
			return UMLElementTypes.Message_3;
		case ASYNCH_CALL_LITERAL:
			return UMLElementTypes.Message_4;
		case REPLY_LITERAL:
			return UMLElementTypes.Message_41;
		case CREATE_MESSAGE_LITERAL:
			return UMLElementTypes.Message_44;
		case DELETE_MESSAGE_LITERAL:
			return UMLElementTypes.Message_47;
		default:
			throw new IllegalArgumentException("Unknown message type"); //$NON-NLS-1$
		}
	}

	/**
	 * Create a command to move a FloatingMessageAnchor, by changing the EAnnotation stored on the Connector.
	 * 
	 * @param request
	 *            the request that contains the new Location
	 * @param connectionEditPart
	 *            the EditPart for the connector
	 * @param referenceFigure
	 *            the figure to which the anchor is relative
	 * @param commandName
	 *            a name for the command
	 * @param editingDomain
	 *            the editing domain
	 * @return the command to move the anchor
	 */
	public static Command createMoveMessageAnchorCommand(final LocationRequest request, final ConnectionEditPart connectionEditPart,
			final IFigure referenceFigure, final String commandName, final TransactionalEditingDomain editingDomain) {
		final Connector connector = (Connector) connectionEditPart.getModel();
		final Point location = request.getLocation();
		final Point figureLocation = new Point(referenceFigure.getBounds().getCenter());
		referenceFigure.getParent().translateToAbsolute(figureLocation);
		final double scale = FigureUtils.getScale(connectionEditPart.getFigure());
		final Point anchorLocation = new Point(location.x - figureLocation.x, location.y - figureLocation.y).scale(1.0 / scale);

		final CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.add(new RefreshCommandForUndo(connectionEditPart));
		compoundCommand.add(new ICommandProxy(new AbstractTransactionalCommand(editingDomain, commandName, null) {
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				setMessageConnectorLocation(connector, anchorLocation);
				return CommandResult.newOKCommandResult();
			}
		}));
		compoundCommand.add(new RefreshCommandForDo(connectionEditPart));
		return compoundCommand;
	}

	public static void setMessageConnectorLocation(final Connector connector, final Point location) {
		EAnnotation eAnnotation = connector.getEAnnotation(MESSAGE_CONNECTOR_LOCATION);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(MESSAGE_CONNECTOR_LOCATION);
			connector.getEAnnotations().add(eAnnotation);
		}
		eAnnotation.getDetails().put(X, Integer.toString(location.x));
		eAnnotation.getDetails().put(Y, Integer.toString(location.y));
	}

	public static Point getMessageConnectorLocation(final ConnectionEditPart connectionEditPart) {
		final double scale = FigureUtils.getScale(connectionEditPart.getFigure());
		final Connector connector = (Connector) connectionEditPart.getModel();
		final EAnnotation eAnnotation = connector.getEAnnotation(MESSAGE_CONNECTOR_LOCATION);
		if (eAnnotation != null) {
			return new Point(Integer.parseInt(eAnnotation.getDetails().get(X)), Integer.parseInt(eAnnotation.getDetails().get(Y))).scale(scale);
		}
		return null;
	}

	public static void saveRequestStartLocation(final CreateRequest request) {
		@SuppressWarnings("unchecked")
		final Map<Object, Object> extendedData = request.getExtendedData();
		final Point location = request.getLocation();
		extendedData.put(START_LOCATION, location);
		lastStartLocation = new Point(location);
	}

	public static Point retrieveRequestStartLocation(final CreateRequest request) {
		@SuppressWarnings("unchecked")
		final Map<Object, Object> extendedData = request.getExtendedData();
		return (Point) extendedData.get(START_LOCATION);
	}

	public static Point getLastStartLocation() {
		return lastStartLocation;
	}

	/**
	 * Find {@link Message}s linked to the given element.
	 * 
	 * @param element
	 *            the element for which related {@link Message}s must be found
	 * @param hideOnly
	 *            whether to only return Views
	 * @param expectedParentView
	 *            if not <code>null</code>, then only return Views under this parent View
	 * @return the list of linked {@link Message}s to remove
	 */
	public static Collection<? extends EObject> getReferencingMessagesToRemove(final EObject element, final boolean hideOnly, final View expectedParentView) {
		final EReference[] references = new EReference[] { UMLPackage.eINSTANCE.getMessage_ReceiveEvent(), UMLPackage.eINSTANCE.getMessage_SendEvent() };
		final Class<?>[] expectedClasses = new Class<?>[] { Message.class };
		return Utils.getReferencingElementsToRemove(element, references, hideOnly, expectedParentView, expectedClasses);
	}

	/**
	 * Convert the given element to a MessageOccurrenceSpecification (or its subtype DestructionOccurrenceSpecification
	 * if <code>destruction</code> is <code>true</code>)
	 * 
	 * @return the converted element, or <code>null</code> if the element is not an {@link OccurrenceSpecification}
	 */
	public static MessageEnd convertToMessageOccurrenceSpecification(final EObject element, final boolean destruction) {
		// destruction => DestructionOccurrenceSpecification
		if (element instanceof MessageEnd && !destruction || element instanceof DestructionOccurrenceSpecification) {
			return (MessageEnd) element;
		}

		if (element instanceof OccurrenceSpecification) {
			// convert OccurrenceSpecification to MessageOccurrenceSpecification (or its subtype
			// DestructionOccurrenceSpecification if destruction is true)
			final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) element;
			final boolean autogeneratedName = OccurrenceSpecificationUtils.isAutogeneratedName(occurrenceSpecification);
			final Set<View> views = CrossReferencerUtil.getCrossReferencingViews(occurrenceSpecification, TimingDiagramEditPart.MODEL_ID);

			final MessageOccurrenceSpecification messageOccurrenceSpecification = destruction ? UMLFactory.eINSTANCE.createDestructionOccurrenceSpecification()
					: UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();
			// "autogenerated" EAnnotation is transferred on "do", but is lost on "redo" unless we set it explicitly
			OccurrenceSpecificationUtils.setAutogeneratedName(messageOccurrenceSpecification, autogeneratedName);
			EcoreUtils.replaceEObjectInstance(occurrenceSpecification, messageOccurrenceSpecification);

			// update the type of each View (the element has already been updated at this point)
			for (final View view : views) {
				final int type = UMLVisualIDRegistry.getVisualID(view);
				if (!OccurrenceSpecificationUtils.isOccurrenceSpecificationEditPart(type)) {
					continue;
				}

				view.setType(Integer.toString(destruction ? DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID
						: MessageOccurrenceSpecificationEditPartCN.VISUAL_ID));
				/*
				 * The element must be updated manually here, because since BasicDecorationNodeImpl#getElement changes
				 * the element without changing the "set" flag, the UsageCrossReferencer used above doesn't consider the
				 * element reference (see Bug 394270 - BasicDecorationNodeImpl#getElement updates the element without
				 * marking it as set), and so doesn't find the child View
				 */
				@SuppressWarnings("unchecked")
				final List<View> children = new ArrayList<View>(view.getChildren());
				for (final View childView : children) {
					final int childType = UMLVisualIDRegistry.getVisualID(childView);
					if (OccurrenceSpecificationLabelEditPart.VISUAL_ID == childType || MessageOccurrenceSpecificationLabelEditPart.VISUAL_ID == childType) {
						childView.setElement(messageOccurrenceSpecification);
						childView.setType(Integer.toString(destruction ? DestructionOccurrenceSpecificationLabelEditPart.VISUAL_ID
								: MessageOccurrenceSpecificationLabelEditPart.VISUAL_ID));
					}
				}
			}
			return messageOccurrenceSpecification;
		}
		return null;
	}

	/**
	 * Whether the given element is a {@link MessageEnd} ({@link MessageOccurrenceSpecification},
	 * {@link DestructionOccurrenceSpecification} or {@link Gate}), or can be converted to one (
	 * {@link OccurrenceSpecification}).
	 */
	public static boolean isPotentialMessageEnd(final EObject element) {
		return element instanceof MessageEnd || element instanceof OccurrenceSpecification;
	}

	public static Collection<EClass> getAllowedMessageTargets() {
		return Arrays.asList(UMLPackage.eINSTANCE.getOccurrenceSpecification(), UMLPackage.eINSTANCE.getGate());
	}

	public static boolean isValidMessage(final MessageSort messageSort, final MessageKind messageKind, final EObject source, final EObject target) {
		// found message <=> source == null
		if (source == null != (messageKind == MessageKind.FOUND_LITERAL)) {
			return false;
		}
		// lost message <=> target == null
		if (target == null != (messageKind == MessageKind.LOST_LITERAL)) {
			return false;
		}

		if ((messageSort == MessageSort.DELETE_MESSAGE_LITERAL || messageSort == MessageSort.CREATE_MESSAGE_LITERAL) && target instanceof Gate) {
			return false;
		}
		if (messageSort == MessageSort.CREATE_MESSAGE_LITERAL && target instanceof DestructionOccurrenceSpecification) {
			return false;
		}
		return true;
	}
}
