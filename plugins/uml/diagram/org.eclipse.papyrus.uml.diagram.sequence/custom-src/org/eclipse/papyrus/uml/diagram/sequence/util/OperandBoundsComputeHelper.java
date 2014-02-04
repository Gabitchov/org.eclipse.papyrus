package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

public class OperandBoundsComputeHelper {

	/**
	 * Default height of Interaction Operand
	 */
	public static final int DEFAULT_INTERACTION_OPERAND_HEIGHT = 61;

	public static final int MIN_INTERACTION_OPERAND_HEIGHT = 10;

	/**
	 * Default width of Interaction Operand
	 */
	public static final int DEFAULT_INTERACTION_OPERAND_WIDTH = 210;

	/**
	 * Border width of CombinedFragmentFigure
	 */
	public static final int COMBINED_FRAGMENT_FIGURE_BORDER = 1;

	private static final int EXECUTION_VERTICAL_MARGIN = 3;

	/**
	 * Find first Interaction Operand EditpPart of CombinedFragmentCombinedFragmentCompartmentEditPart
	 * 
	 * @param compartEP
	 * @return InteractionOperandEditPart
	 */
	public static InteractionOperandEditPart findFirstIOEP(CombinedFragmentCombinedFragmentCompartmentEditPart compartEP) {
		InteractionOperandEditPart firstIOEP = null;
		List children = compartEP.getChildren();
		for(int i = 0; i < children.size(); i++) {
			if(children.get(i) instanceof InteractionOperandEditPart) {
				firstIOEP = (InteractionOperandEditPart)children.get(i);
				break;
			}
		}
		return firstIOEP;
	}

	/**
	 * Find Last Interaction Operand EditpPart of CombinedFragmentCombinedFragmentCompartmentEditPart
	 * 
	 * @param compartEP
	 * @return InteractionOperandEditPart
	 */
	public static InteractionOperandEditPart findLastIOEP(CombinedFragmentCombinedFragmentCompartmentEditPart compartEP) {
		InteractionOperandEditPart lastIOEP = null;
		List children = compartEP.getChildren();
		for(int i = children.size() - 1; i >= 0; i--) {
			if(children.get(i) instanceof InteractionOperandEditPart) {
				lastIOEP = (InteractionOperandEditPart)children.get(i);
				break;
			}
		}
		return lastIOEP;
	}

	/**
	 * Find Previous Interaction Operand EditpPart of current given InteractionOperandEditPart
	 * 
	 * @param compartEP
	 * @param currentIOEP
	 * @return InteractionOperandEditPart
	 */
	public static InteractionOperandEditPart findPreviousIOEP(CombinedFragmentCombinedFragmentCompartmentEditPart compartEP, InteractionOperandEditPart currentIOEP) {
		InteractionOperandEditPart previousIOEP = null;
		List children = compartEP.getChildren();
		for(int i = 0; i < children.size() - 1; i++) {
			if(children.get(i) instanceof InteractionOperandEditPart) {
				if(children.get(i) == currentIOEP) {
					break;
				} else {
					previousIOEP = (InteractionOperandEditPart)children.get(i);
				}
			}
		}
		return previousIOEP;
	}

	/**
	 * Find Latter Interaction Operand EditpPart of current given InteractionOperandEditPart
	 * 
	 * @param compartEP
	 * @param currentIOEP
	 * @return InteractionOperandEditPart
	 */
	public static InteractionOperandEditPart findLatterIOEP(CombinedFragmentCombinedFragmentCompartmentEditPart compartEP, InteractionOperandEditPart currentIOEP) {
		InteractionOperandEditPart latterIOEP = null;
		List children = compartEP.getChildren();
		for(int i = children.size() - 1; i > 0; i--) {
			if(children.get(i) instanceof InteractionOperandEditPart) {
				if(children.get(i) == currentIOEP) {
					break;
				} else {
					latterIOEP = (InteractionOperandEditPart)children.get(i);
				}
			}
		}
		return latterIOEP;
	}

	/**
	 * Update EditPart bounds using new rect
	 * 
	 * @param parent
	 * @param rect
	 */
	public static void updateEditPartBounds(GraphicalEditPart editpart, final Rectangle rect) {
		if(editpart.getModel() instanceof Node) {
			Node node = (Node)editpart.getModel();
			if(node.getLayoutConstraint() instanceof Bounds) {
				Bounds bounds = (Bounds)node.getLayoutConstraint();
				updateBounds(bounds, rect, editpart.getEditingDomain());
			}
		}
	}

	/**
	 * Update EditPart bounds using new rect
	 * 
	 * @param parent
	 * @param rect
	 */
	public static ICommand createUpdateEditPartBoundsCommand(final GraphicalEditPart editpart, final Rectangle rect) {
		ICommand cmd = new AbstractTransactionalCommand(editpart.getEditingDomain(), "Update Operand Bounds", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if(editpart.getModel() instanceof Node) {
					Node node = (Node)editpart.getModel();
					if(node.getLayoutConstraint() instanceof Bounds) {
						Bounds bounds = (Bounds)node.getLayoutConstraint();
						fillBounds(bounds, rect);
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		return cmd;
	}

	/**
	 * Create command for updating Interaction Operand EditpPart bounds after the CombinedFragment to be created.
	 * 
	 * @param editPart
	 * @param request
	 * @return ICommand
	 */
	public static ICommand createUpdateCFAndIOBoundsForCFCreationCommand(final EditPart editPart, final CreateViewRequest request) {
		if(!(editPart instanceof GraphicalEditPart)) {
			return null;
		}
		GraphicalEditPart graphicalEditPart = (GraphicalEditPart)editPart;
		ICommand cmd = new AbstractTransactionalCommand(graphicalEditPart.getEditingDomain(), "Create update operand bounds command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				OperandBoundsComputeHelper.updateCFAndIOBoundsForCFCreation((GraphicalEditPart)editPart, request);
				return CommandResult.newOKCommandResult();
			}
		};
		return cmd;
	}

	/**
	 * Update Interaction Operand EditpPart bounds after the CombinedFragment to be created.
	 * 
	 * @param parent
	 * @param request
	 * @param selectionRect
	 */
	private static void updateCFAndIOBoundsForCFCreation(GraphicalEditPart parent, CreateViewRequest request) {
		Object subEditPart = null;
		if(parent instanceof InteractionInteractionCompartmentEditPart) {
			InteractionInteractionCompartmentEditPart interactionInteractionCompartmentEditPart = (InteractionInteractionCompartmentEditPart)parent;
			subEditPart = interactionInteractionCompartmentEditPart.getChildren().get(interactionInteractionCompartmentEditPart.getChildren().size() - 1);
		} else if(parent instanceof InteractionOperandEditPart) {
			InteractionOperandEditPart interactionOperandEditPart = (InteractionOperandEditPart)parent;
			subEditPart = interactionOperandEditPart.getChildren().get(interactionOperandEditPart.getChildren().size() - 1);
		}
		if(subEditPart != null && subEditPart instanceof CombinedFragmentEditPart) {
			CombinedFragmentEditPart combinedFragmentEditPart = (CombinedFragmentEditPart)subEditPart;
			// set bounds for CombinedFragmentEditPart
			Rectangle cfEPAbsoluteRect = null;
			int labelContainerHeight = computeCombinedFragementHeaderHeight(combinedFragmentEditPart);
			Shape cfEPShape = (Shape)combinedFragmentEditPart.getModel();
			if(cfEPShape.getLayoutConstraint() instanceof Bounds) {
				if(request.getSize() == null) {
					Dimension cfEPDefaultSize = new Dimension();
					cfEPDefaultSize.setWidth(DEFAULT_INTERACTION_OPERAND_WIDTH + COMBINED_FRAGMENT_FIGURE_BORDER * 2);
					cfEPDefaultSize.setHeight(DEFAULT_INTERACTION_OPERAND_HEIGHT + labelContainerHeight + COMBINED_FRAGMENT_FIGURE_BORDER * 2);
					cfEPAbsoluteRect = new Rectangle(request.getLocation(), cfEPDefaultSize);
				} else {
					cfEPAbsoluteRect = new Rectangle(request.getLocation(), request.getSize());
				}
				Rectangle cfEPRelativeRect = cfEPAbsoluteRect.getCopy();
				combinedFragmentEditPart.getFigure().translateToRelative(cfEPRelativeRect);
				Bounds cfEPBounds = (Bounds)cfEPShape.getLayoutConstraint();
				fillBounds(cfEPBounds, cfEPRelativeRect);
			}
			// set bounds for new added Operand
			InteractionOperandEditPart lastOperand = OperandBoundsComputeHelper.findLastIOEP((CombinedFragmentCombinedFragmentCompartmentEditPart)combinedFragmentEditPart.getChildBySemanticHint(UMLVisualIDRegistry.getType(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID)));
			Shape shape = (Shape)lastOperand.getModel();
			if(shape.getLayoutConstraint() instanceof Bounds) {
				Bounds bounds = (Bounds)shape.getLayoutConstraint();
				Rectangle rect = new Rectangle(bounds.getX(), bounds.getY(), cfEPAbsoluteRect.width() - COMBINED_FRAGMENT_FIGURE_BORDER * 2, cfEPAbsoluteRect.height() - labelContainerHeight - COMBINED_FRAGMENT_FIGURE_BORDER * 2);
				fillBounds(bounds, rect);
			}
		}
	}

	/**
	 * Create command for updating Interaction Operand EditpPart bounds after CombinedFragment to be resized.
	 * 
	 * @param compoundCmd
	 * @param request
	 * @param combinedFragmentEditPart
	 * @return Command
	 */
	public static Command createUpdateIOBoundsForCFResizeCommand(CompoundCommand compoundCmd, final ChangeBoundsRequest request, CombinedFragmentEditPart combinedFragmentEditPart) {
		if(combinedFragmentEditPart.getChildren().size() > 0 && combinedFragmentEditPart.getChildren().get(0) instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
			CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)combinedFragmentEditPart.getChildren().get(0);
			CombinedFragment cf = (CombinedFragment)combinedFragmentEditPart.resolveSemanticElement();
			InteractionOperandEditPart targetIOEP = null;
			if((request.getResizeDirection() & PositionConstants.NORTH) != 0) {
				targetIOEP = findFirstIOEP(compartment);
			} else if((request.getResizeDirection() & PositionConstants.SOUTH) != 0) {
				targetIOEP = findLastIOEP(compartment);
			}
			updateIOBoundsForCFResize(request, compoundCmd, compartment.getChildren(), cf, targetIOEP != null ? (InteractionOperand)targetIOEP.resolveSemanticElement() : null, request.getSizeDelta(), request.getResizeDirection());
			if(targetIOEP != null && request.getSizeDelta().height != 0) {
				int heightDelta = request.getSizeDelta().height;
				int movedY = heightDelta;
				Bounds bounds = getInteractionOperandEPBounds(targetIOEP);
				Rectangle currentIOEPRect = OperandBoundsComputeHelper.fillRectangle(bounds);
				if((request.getResizeDirection() & PositionConstants.NORTH) != 0) {
					movedY = -heightDelta;
					currentIOEPRect.setY(currentIOEPRect.y() - heightDelta);
				} else if((request.getResizeDirection() & PositionConstants.SOUTH) != 0) {
				}
				currentIOEPRect.setHeight(bounds.getHeight() + heightDelta);
				int minHeight = getMinimumHeightFor(targetIOEP);
				if(currentIOEPRect.height < minHeight) {
					compoundCmd.add(UnexecutableCommand.INSTANCE);
					return UnexecutableCommand.INSTANCE;
				} else {
					Command shiftEnclosedExecutions = getShiftEnclosedFragmentsCommand(targetIOEP, currentIOEPRect, movedY);
					if(shiftEnclosedExecutions != null) {
						compoundCmd.add(shiftEnclosedExecutions);
					}
				}
			}
		}
		//Append command for expand covered Lifelines when moving CombinedFragment.
		Point moveDelta = request.getMoveDelta();
		//Update also happens with resize.
		Dimension sizeDelta = request.getSizeDelta();
		if(moveDelta.y > 0 || sizeDelta.height > 0) {
			if(combinedFragmentEditPart.getModel() instanceof Node) {
				Node node = (Node)combinedFragmentEditPart.getModel();
				if(node.getLayoutConstraint() instanceof Bounds) {
					Bounds containerBounds = (Bounds)node.getLayoutConstraint();
					Dimension preferredSize = combinedFragmentEditPart.getFigure().getPreferredSize();
					int width = containerBounds.getWidth() != -1 ? containerBounds.getWidth() : preferredSize.width();
					int height = containerBounds.getHeight() != -1 ? containerBounds.getHeight() : preferredSize.height();
					int x = containerBounds.getX();
					int y = containerBounds.getY();
					if(moveDelta.y > 0) {
						y += moveDelta.y;
					}
					if(sizeDelta.height > 0) {
						height += sizeDelta.height;
					}
					Rectangle newBounds = new Rectangle(x, y, width, height);
					ICommand command = getExpandCoveredsCommand(combinedFragmentEditPart, newBounds);
					if(command != null && command.canExecute()) {
						compoundCmd.add(new ICommandProxy(command));
					}
				}
			}
		}
		return compoundCmd;
	}

	/**
	 * Update Interaction Operand EditpPart bounds after CombinedFragment to be resized.
	 * 
	 * @param request
	 * @param compoundCmd
	 * @param combinedFragmentChildrenEditParts
	 * @param cf
	 * @param targetOperand
	 * @param sizeDelta
	 * @param direction
	 */
	private static void updateIOBoundsForCFResize(final ChangeBoundsRequest request, CompoundCommand compoundCmd, List<EditPart> combinedFragmentChildrenEditParts, CombinedFragment cf, InteractionOperand targetOperand, final Dimension sizeDelta, int direction) {
		InteractionOperandEditPart targetOperandEditPart = findTargetOperandEditPart(cf, targetOperand, combinedFragmentChildrenEditParts);
		for(EditPart ep : combinedFragmentChildrenEditParts) {
			if(ep instanceof InteractionOperandEditPart) {
				InteractionOperandEditPart ioEP = (InteractionOperandEditPart)ep;
				Object ioEPModel = ioEP.getModel();
				if(ioEPModel instanceof Shape) {
					Shape ioEPShape = (Shape)ioEPModel;
					if(ioEPShape.getLayoutConstraint() instanceof Bounds) {
						final Bounds ioEPOriginalBounds = (Bounds)ioEPShape.getLayoutConstraint();
						ICommand cmd = new UpdateIOBoundsForCFResizeCommand(ioEP.getEditingDomain(), "Update operand bounds interaction command", ioEPOriginalBounds, request, sizeDelta, ioEP == targetOperandEditPart, direction);
						compoundCmd.add(new ICommandProxy(cmd));
					}
				}
			}
		}
	}

	/**
	 * Update bounds using new rect
	 * 
	 * @param bounds
	 * @param rect
	 * @param transactionalEditingDomain
	 */
	public static void updateBounds(final Bounds bounds, final Rectangle rect, TransactionalEditingDomain transactionalEditingDomain) {
		if(bounds != null) {
			final Rectangle originalBounds = new Rectangle();
			originalBounds.setX(bounds.getX());
			originalBounds.setY(bounds.getY());
			originalBounds.setWidth(bounds.getWidth());
			originalBounds.setHeight(bounds.getHeight());
			AbstractCommand cmd = new AbstractCommand() {

				@Override
				public boolean canExecute() {
					return true;
				}

				public void execute() {
					exec(rect);
				}

				public void redo() {
					execute();
				}

				@Override
				public void undo() {
					exec(originalBounds);
				}

				public void exec(Rectangle rect) {
					fillBounds(bounds, rect);
				}

				@Override
				public boolean canUndo() {
					return true;
				}
			};
			CommandHelper.executeCommandWithoutHistory(transactionalEditingDomain, cmd, true);
		}
	}

	/**
	 * Get InteractionOperandEditPart from its model object InteractionOperand.
	 * 
	 * @param cf
	 * @param targetOperand
	 * @param combinedFragmentChildrenEditParts
	 * @return InteractionOperandEditPart
	 */
	public static InteractionOperandEditPart findTargetOperandEditPart(CombinedFragment cf, InteractionOperand targetOperand, List<EditPart> combinedFragmentChildrenEditParts) {
		if(targetOperand == null) {
			return null;
		}
		for(EditPart ep : combinedFragmentChildrenEditParts) {
			if(ep instanceof InteractionOperandEditPart) {
				InteractionOperandEditPart ioEP = (InteractionOperandEditPart)ep;
				EObject io = ioEP.resolveSemanticElement();
				if(cf.getOperands().contains(io)) {
					if(targetOperand.equals(io)) {
						return ioEP;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get graphical edit part bounds
	 * 
	 * @param editPart
	 * @return
	 */
	public static Bounds getEditPartBounds(GraphicalEditPart editPart) {
		if(editPart.getModel() instanceof Node) {
			Node node = (Node)editPart.getModel();
			if(node.getLayoutConstraint() instanceof Bounds) {
				Bounds bounds = (Bounds)node.getLayoutConstraint();
				return bounds;
			}
		}
		return null;
	}

	/**
	 * Fill data from Bounds to Rectangle
	 * 
	 * @param source
	 * @return Rectangle
	 */
	public static Rectangle fillRectangle(Bounds source) {
		if(source == null) {
			return null;
		}
		Rectangle target = new Rectangle();
		target.setX(source.getX());
		target.setY(source.getY());
		target.setWidth(source.getWidth());
		target.setHeight(source.getHeight());
		return target;
	}

	/**
	 * Fill data from Rectangle to Bounds
	 * 
	 * @param bounds
	 * @param source
	 * @return Bounds
	 */
	public static Bounds fillBounds(Bounds bounds, Rectangle source) {
		if(bounds == null || source == null) {
			return null;
		}
		bounds.setX(source.x());
		bounds.setY(source.y());
		bounds.setWidth(source.width());
		bounds.setHeight(source.height());
		return bounds;
	}

	/**
	 * Get interaction operand bounds
	 * 
	 * @param operandEP
	 * @return Bounds
	 */
	public static Bounds getInteractionOperandEPBounds(GraphicalEditPart operandEP) {
		Object lastChildModel = operandEP.getModel();
		if(lastChildModel instanceof Shape) {
			Shape lastOperandShape = (Shape)lastChildModel;
			if(lastOperandShape.getLayoutConstraint() instanceof Bounds) {
				return (Bounds)lastOperandShape.getLayoutConstraint();
			}
		}
		return null;
	}

	/**
	 * Create interaction operand resize command
	 * 
	 * @param currentIOEP
	 * @param heightDelta
	 * @param compartEP
	 * @param direction
	 * @return
	 */
	public static Command createIOEPResizeCommand(InteractionOperandEditPart currentIOEP, int heightDelta, CombinedFragmentCombinedFragmentCompartmentEditPart compartEP, int direction) {
		Bounds currentIOEPBounds = OperandBoundsComputeHelper.getEditPartBounds(currentIOEP);
		if(currentIOEPBounds == null) {
			return null;
		}
		InteractionOperandEditPart targetIOEP = null;
		if((direction & PositionConstants.NORTH) != 0) {
			targetIOEP = OperandBoundsComputeHelper.findPreviousIOEP(compartEP, currentIOEP);
		} else if((direction & PositionConstants.SOUTH) != 0) {
			targetIOEP = OperandBoundsComputeHelper.findLatterIOEP(compartEP, currentIOEP);
		}
		CompositeCommand compositeCommand = new CompositeCommand("Resize Operand");
		// if last operand
		if(targetIOEP == null) {
			if(heightDelta < 0) {
				if(currentIOEPBounds.getHeight() - Math.abs(heightDelta) < OperandBoundsComputeHelper.MIN_INTERACTION_OPERAND_HEIGHT) {
					return null;
				}
			}
			Rectangle currentIOEPRect = OperandBoundsComputeHelper.fillRectangle(currentIOEPBounds);
			currentIOEPRect.setHeight(currentIOEPBounds.getHeight() + heightDelta);
			int minHeight = getMinimumHeightFor(currentIOEP);
			if(currentIOEPRect.height < minHeight) {
				return UnexecutableCommand.INSTANCE;
			}
			ICommand currentIOEPCommand = OperandBoundsComputeHelper.createUpdateEditPartBoundsCommand(currentIOEP, currentIOEPRect);
			compositeCommand.add(currentIOEPCommand);
			Command shiftPreviousExecutions = getShiftEnclosedFragmentsCommand(currentIOEP, currentIOEPRect, heightDelta);
			if(shiftPreviousExecutions != null) {
				compositeCommand.add(new EMFtoGMFCommandWrapper(new GEFtoEMFCommandWrapper(shiftPreviousExecutions)));
			}
			// auto update CombinedFragmentEditPart bounds after resize the last operand
			if(compartEP.getParent() instanceof CombinedFragmentEditPart) {
				CombinedFragmentEditPart parent = (CombinedFragmentEditPart)compartEP.getParent();
				if(parent.getModel() instanceof Node) {
					Node node = (Node)parent.getModel();
					if(node.getLayoutConstraint() instanceof Bounds) {
						Bounds containerBounds = (Bounds)node.getLayoutConstraint();
						Dimension preferredSize = parent.getFigure().getPreferredSize();
						int width = containerBounds.getWidth() != -1 ? containerBounds.getWidth() : preferredSize.width();
						int height = containerBounds.getHeight() != -1 ? containerBounds.getHeight() : preferredSize.height();
						height = height + heightDelta;
						Rectangle containerRect = new Rectangle(containerBounds.getX(), containerBounds.getY(), width, height);
						compositeCommand.add(OperandBoundsComputeHelper.createUpdateEditPartBoundsCommand(parent, containerRect));
						//Preserve Message anchors.
						ICommand preserveMessageAnchorsCommand = MessageAnchorRepairer.createPreserveMessageAnchorsCommand(parent, heightDelta);
						if(preserveMessageAnchorsCommand != null && preserveMessageAnchorsCommand.canExecute()) {
							compositeCommand.add(preserveMessageAnchorsCommand);
						}
						ICommand expandCoveredsCommand = getExpandCoveredsCommand((CombinedFragmentEditPart)compartEP.getParent(), containerRect);
						if(expandCoveredsCommand != null) {
							compositeCommand.add(expandCoveredsCommand);
						}
					}
				}
			}
		} else {
			Bounds targetIOEPBounds = OperandBoundsComputeHelper.getEditPartBounds(targetIOEP);
			if(targetIOEPBounds == null) {
				return null;
			}
			if(heightDelta > 0) {
				if(targetIOEPBounds.getHeight() - heightDelta < OperandBoundsComputeHelper.MIN_INTERACTION_OPERAND_HEIGHT) {
					return null;
				}
			} else {
				if(currentIOEPBounds.getHeight() - Math.abs(heightDelta) < OperandBoundsComputeHelper.MIN_INTERACTION_OPERAND_HEIGHT) {
					return null;
				}
			}
			Rectangle targetIOEPRect = OperandBoundsComputeHelper.fillRectangle(targetIOEPBounds);
			Rectangle currentIOEPRect = OperandBoundsComputeHelper.fillRectangle(currentIOEPBounds);
			targetIOEPRect.setHeight(targetIOEPBounds.getHeight() - heightDelta);
			currentIOEPRect.setHeight(currentIOEPBounds.getHeight() + heightDelta);
			int shiftY = 0;
			if((direction & PositionConstants.NORTH) != 0) {
				currentIOEPRect.setY(currentIOEPRect.y() - heightDelta);
				shiftY = -heightDelta;
			} else if((direction & PositionConstants.SOUTH) != 0) {
				targetIOEPRect.setY(targetIOEPRect.y() + heightDelta);
				shiftY = heightDelta;
			}
			int minHeightOfTargetOperand = getMinimumHeightFor(targetIOEP);
			if(targetIOEPRect.height < minHeightOfTargetOperand) {
				return null;
			}
			ICommand previousIOEPCommand = OperandBoundsComputeHelper.createUpdateEditPartBoundsCommand(targetIOEP, targetIOEPRect);
			compositeCommand.add(previousIOEPCommand);
			if((shiftY < 0 && targetIOEPRect.y < currentIOEPRect.y) || shiftY > 0 && (targetIOEPRect.y > currentIOEPRect.y)) {
				Command shiftPreviousExecutions = getShiftEnclosedFragmentsCommand(targetIOEP, targetIOEPRect, shiftY);
				if(shiftPreviousExecutions != null) {
					compositeCommand.add(new EMFtoGMFCommandWrapper(new GEFtoEMFCommandWrapper(shiftPreviousExecutions)));
				}
			}
			int minHeughtOfCurrentOperand = getMinimumHeightFor(currentIOEP);
			if(currentIOEPRect.height < minHeughtOfCurrentOperand) {
				return null;
			}
			ICommand currentIOEPCommand = OperandBoundsComputeHelper.createUpdateEditPartBoundsCommand(currentIOEP, currentIOEPRect);
			compositeCommand.add(currentIOEPCommand);
			if((shiftY < 0 && currentIOEPRect.y < targetIOEPRect.y) || (shiftY > 0 && currentIOEPRect.y > targetIOEPRect.y)) {
				Command shiftCurrentExecutions = getShiftEnclosedFragmentsCommand(currentIOEP, currentIOEPRect, shiftY);
				if(shiftCurrentExecutions != null) {
					compositeCommand.add(new EMFtoGMFCommandWrapper(new GEFtoEMFCommandWrapper(shiftCurrentExecutions)));
				}
			}
		}
		return new ICommandProxy(compositeCommand);
	}

	private static int getMinimumHeightFor(InteractionOperandEditPart operand) {
		if(operand == null) {
			return MIN_INTERACTION_OPERAND_HEIGHT;
		}
		List<OperandBlock> operandBlocks = getOperandBlocks(operand);
		if(!operandBlocks.isEmpty()) {
			//1. Sort with y location.
			Collections.sort(operandBlocks, new Comparator<OperandBlock>() {

				public int compare(OperandBlock o1, OperandBlock o2) {
					Rectangle r1 = o1.getBounds();
					Rectangle r2 = o2.getBounds();
					if(r1.y < r2.y) {
						return -1;
					} else if(r1.y > r2.y) {
						return 1;
					}
					return 0;
				}
			});
			//2. Compute max area of all blocks, make sure all blocks will be contained in this area.
			Rectangle maxArea = null;
			for(OperandBlock blk : operandBlocks) {
				Rectangle r = blk.getBounds();
				if(maxArea == null) {
					maxArea = r;
				} else {
					maxArea.union(r);
				}
			}
			//3. Compute min area for all blocks, this will remove all margins.
			Map<OperandBlock, Rectangle> constraints = new HashMap<OperandBoundsComputeHelper.OperandBlock, Rectangle>();
			OperandBlock topBlock = operandBlocks.get(0);
			Rectangle minArea = new Rectangle(topBlock.getBounds());
			minArea.height += EXECUTION_VERTICAL_MARGIN;//margin
			for(int i = 1; i < operandBlocks.size(); i++) {
				OperandBlock nextBlock = operandBlocks.get(i);
				Rectangle r = nextBlock.getBounds();
				if(!minArea.touches(r) && r.y > maxArea.y) {
					for(int y = r.y; y >= maxArea.y; y--) {
						Rectangle movedRect = new Rectangle(r).setY(y);
						if(minArea.touches(movedRect)) {
							break;
						} else {
							constraints.put(nextBlock, movedRect);
						}
					}
				}
				Rectangle newBounds = constraints.get(nextBlock);
				if(newBounds == null) {
					newBounds = r;
				}
				minArea.union(newBounds);
				minArea.height += EXECUTION_VERTICAL_MARGIN;//margin
			}
			return minArea.height;
		}
		return MIN_INTERACTION_OPERAND_HEIGHT;
	}

	/**
	 * Once there are messages between two execution of a Operand, consider them as a group.
	 * 
	 * @param currentExecutionPart
	 * @param toCheckExecutions
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static Rectangle getExecutionGroupBounds(IGraphicalEditPart currentExecutionPart, List<ExecutionSpecification> toCheckExecutions) {
		Rectangle groupRect = SequenceUtil.getAbsoluteBounds(currentExecutionPart);
		if(toCheckExecutions.isEmpty()) {
			return groupRect;
		}
		List connections = new ArrayList();
		connections.addAll(currentExecutionPart.getSourceConnections());
		connections.addAll(currentExecutionPart.getTargetConnections());
		for(Object object : connections) {
			IGraphicalEditPart source = (IGraphicalEditPart)object;
			View model = (View)source.getModel();
			EObject element = model.getElement();
			if(toCheckExecutions.contains(element)) {
				List<ExecutionSpecification> myCheckingList = new ArrayList<ExecutionSpecification>(toCheckExecutions);
				myCheckingList.remove(element);
				Rectangle rect = getExecutionGroupBounds(source, myCheckingList);
				groupRect.union(rect);
			}
		}
		List<ShapeNodeEditPart> affixedExecutionSpecificationEditParts = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts((ShapeNodeEditPart)currentExecutionPart);
		for(ShapeNodeEditPart shapeNodeEditPart : affixedExecutionSpecificationEditParts) {
			List<ExecutionSpecification> myCheckingList = new ArrayList<ExecutionSpecification>(toCheckExecutions);
			myCheckingList.remove(shapeNodeEditPart);
			Rectangle rect = getExecutionGroupBounds(shapeNodeEditPart, myCheckingList);
			groupRect.union(rect);
		}
		return groupRect;
	}

	public static Command getShiftEnclosedFragmentsCommand(InteractionOperandEditPart editPart, Rectangle newBounds, int movedY) {
		if(editPart == null || newBounds == null || movedY == 0) {
			return null;
		}
		List<OperandBlock> operandBlocks = getOperandBlocks(editPart);
		if(operandBlocks.isEmpty()) {
			return null;
		}
		OperandBlockLayout layout = new OperandBlockLayout(operandBlocks);
		IFigure figure = editPart.getFigure();
		Rectangle newArea = newBounds.getCopy();
		figure.getParent().translateToAbsolute(newArea);
		newArea.translate(figure.getParent().getBounds().getLocation());
		layout.layout(newArea, movedY > 0 ? true : false);

		final Map<OperandBlock, Integer> blockToMove = new HashMap<OperandBoundsComputeHelper.OperandBlock, Integer>();
		for(OperandBlock blk : operandBlocks) {
			int moveDelta = layout.getMoveDelta(blk);
			if(moveDelta == 0) {
				continue;
			}
			blockToMove.put(blk, moveDelta);
		}
		if(blockToMove.isEmpty()) {
			return null;
		}
		return new ICommandProxy(new MoveOperandBlockCommand(editPart.getEditingDomain(), blockToMove));
	}

	private static ICommand getMoveAnchorCommand(int yDelta, Rectangle figureBounds, IdentityAnchor gmfAnchor) {
		String oldTerminal = gmfAnchor.getId();
		PrecisionPoint pp = BaseSlidableAnchor.parseTerminalString(oldTerminal);
		int yPos = (int)Math.round(figureBounds.height * pp.preciseY);
		yPos += yDelta;
		pp.preciseY = (double)yPos / figureBounds.height;
		if(pp.preciseY > 1.0) {
			pp.preciseY = 1.0;
		} else if(pp.preciseY < 0.0) {
			pp.preciseY = 0.0;
		}
		String newTerminal = (new BaseSlidableAnchor(null, pp)).getTerminal();
		return new SetValueCommand(new SetRequest(gmfAnchor, NotationPackage.Literals.IDENTITY_ANCHOR__ID, newTerminal));
	}

	/**
	 * Compute CombinedFragement's header height
	 * 
	 * @param combinedFragmentEditPart
	 * @return int
	 */
	public static int computeCombinedFragementHeaderHeight(CombinedFragmentEditPart combinedFragmentEditPart) {
		int headerHeight = 0;
		IFigure labelContainer = combinedFragmentEditPart.getPrimaryShape().getHeaderContainer();
		if(labelContainer != null) {
			headerHeight = labelContainer.getPreferredSize().height();
		}
		return headerHeight;
	}

	/**
	 * Check if operation resizing on CombinedFragment is allowed
	 * 
	 * @param request
	 * @param child
	 * @return boolean
	 */
	public static boolean checkRedistrictOnCFResize(ChangeBoundsRequest request, EditPart child) {
		if(child instanceof CombinedFragmentEditPart) {
			if((request.getResizeDirection() & PositionConstants.NORTH_SOUTH) != 0) {
				CombinedFragmentEditPart combinedFragmentEditPart = (CombinedFragmentEditPart)child;
				if(combinedFragmentEditPart.getChildren().size() > 0 && combinedFragmentEditPart.getChildren().get(0) instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
					CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)combinedFragmentEditPart.getChildren().get(0);
					List<EditPart> combinedFragmentChildrenEditParts = compartment.getChildren();
					CombinedFragment cf = (CombinedFragment)combinedFragmentEditPart.resolveSemanticElement();
					InteractionOperand targetOperand = null;
					if((request.getResizeDirection() & PositionConstants.NORTH) != 0) {
						targetOperand = cf.getOperands().get(0);
					} else if((request.getResizeDirection() & PositionConstants.SOUTH) != 0) {
						targetOperand = cf.getOperands().get(cf.getOperands().size() - 1);
					}
					InteractionOperandEditPart targetOperandEditPart = OperandBoundsComputeHelper.findTargetOperandEditPart(cf, targetOperand, combinedFragmentChildrenEditParts);
					int heightDelta = request.getSizeDelta().height();
					if(targetOperandEditPart != null && heightDelta < 0) {
						int height = targetOperandEditPart.getFigure().getBounds().height();
						if(height - Math.abs(heightDelta) < OperandBoundsComputeHelper.MIN_INTERACTION_OPERAND_HEIGHT) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * Add command for updating adjacent interaction operand bounds after deleting a interaction operand
	 * 
	 * @param editPart
	 * @param cmd
	 */
	public static void addUpdateBoundsCommandForOperandDelelete(EditPart editPart, ICompositeCommand cmd) {
		if(editPart instanceof InteractionOperandEditPart) {
			if(editPart.getParent() instanceof CombinedFragmentCombinedFragmentCompartmentEditPart) {
				CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)editPart.getParent();
				if(compartment.getParent() instanceof CombinedFragmentEditPart) {
					List<EditPart> combinedFragmentChildrenEditParts = compartment.getChildren();
					InteractionOperandEditPart previousIOEP = null;
					InteractionOperandEditPart latterIOEP = null;
					boolean isFirstOperand = false;
					InteractionOperandEditPart currentioEP = (InteractionOperandEditPart)editPart;
					final Rectangle currentioEPBounds = currentioEP.getFigure().getBounds();
					for(int i = 0; i < combinedFragmentChildrenEditParts.size(); i++) {
						EditPart ep = combinedFragmentChildrenEditParts.get(i);
						if(ep instanceof InteractionOperandEditPart) {
							InteractionOperandEditPart ioEP = (InteractionOperandEditPart)ep;
							if(currentioEP == ioEP) {
								if(previousIOEP != null) {
									Object previousIOEPModel = previousIOEP.getModel();
									if(previousIOEPModel instanceof Shape) {
										Shape previousIOEPShape = (Shape)previousIOEPModel;
										if(previousIOEPShape.getLayoutConstraint() instanceof Bounds) {
											final Bounds previousIOEPOriginalBounds = (Bounds)previousIOEPShape.getLayoutConstraint();
											ICommand command = new AbstractTransactionalCommand(previousIOEP.getEditingDomain(), "Merge operand bounds command", null) {

												@Override
												protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
													previousIOEPOriginalBounds.setHeight(previousIOEPOriginalBounds.getHeight() + currentioEPBounds.height());
													return CommandResult.newOKCommandResult();
												}
											};
											cmd.add(command);
										}
									}
									break;
								} else {
									isFirstOperand = true;
									continue;
								}
							} else {
								previousIOEP = ioEP;
							}
							if(isFirstOperand) {
								latterIOEP = ioEP;
								break;
							}
						}
					}
					if(isFirstOperand && latterIOEP != null) {
						Object latterIOEPModel = latterIOEP.getModel();
						if(latterIOEPModel instanceof Shape) {
							Shape latterIOEPShape = (Shape)latterIOEPModel;
							if(latterIOEPShape.getLayoutConstraint() instanceof Bounds) {
								final Bounds latterIOEPOriginalBounds = (Bounds)latterIOEPShape.getLayoutConstraint();
								ICommand command = new AbstractTransactionalCommand(previousIOEP.getEditingDomain(), "Merge operand bounds command", null) {

									@Override
									protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
										latterIOEPOriginalBounds.setY(0);
										latterIOEPOriginalBounds.setHeight(latterIOEPOriginalBounds.getHeight() + currentioEPBounds.height());
										return CommandResult.newOKCommandResult();
									}
								};
								cmd.add(command);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Add update InteractionOperand bounds command after IO is created
	 * 
	 * @param compartment
	 * @param request
	 * @param command
	 */
	public static void addUpdateBoundsForIOCreationCommand(CombinedFragmentCombinedFragmentCompartmentEditPart compartment, ViewDescriptor viewDescriptor, CompositeCommand command) {
		List children = compartment.getChildren();
		if(children != null && children.size() > 0) {
			InteractionOperandEditPart lastOperandEP = OperandBoundsComputeHelper.findLastIOEP(compartment);
			// update bounds
			if(lastOperandEP != null) {
				Bounds lastOperandBounds = OperandBoundsComputeHelper.getInteractionOperandEPBounds(lastOperandEP);
				if(lastOperandBounds != null) {
					Rectangle rect = new Rectangle(lastOperandBounds.getX(), lastOperandBounds.getY() + lastOperandBounds.getHeight(), lastOperandBounds.getWidth(), OperandBoundsComputeHelper.DEFAULT_INTERACTION_OPERAND_HEIGHT);
					// auto update CombinedFragmentEditPart bounds after added new operand
					if(compartment.getParent() instanceof CombinedFragmentEditPart) {
						CombinedFragmentEditPart parent = (CombinedFragmentEditPart)compartment.getParent();
						if(parent.getModel() instanceof Node) {
							Node node = (Node)parent.getModel();
							if(node.getLayoutConstraint() instanceof Bounds) {
								Bounds containerBounds = (Bounds)node.getLayoutConstraint();
								Dimension preferredSize = parent.getFigure().getPreferredSize();
								int width = containerBounds.getWidth() != -1 ? containerBounds.getWidth() : preferredSize.width();
								int height = containerBounds.getHeight() != -1 ? containerBounds.getHeight() : preferredSize.height();
								height = height + OperandBoundsComputeHelper.DEFAULT_INTERACTION_OPERAND_HEIGHT;
								View shapeView = (View)parent.getModel();
								Rectangle newBounds = new Rectangle(containerBounds.getX(), containerBounds.getY(), width, height);
								ICommand setParentBoundsCmd = new SetBoundsCommand(compartment.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(shapeView), newBounds);
								command.add(setParentBoundsCmd);
								//Preserve Message anchors.
								ICommand preserveMessageAnchorsCommand = MessageAnchorRepairer.createPreserveMessageAnchorsCommand(parent, OperandBoundsComputeHelper.DEFAULT_INTERACTION_OPERAND_HEIGHT);
								if(preserveMessageAnchorsCommand != null && preserveMessageAnchorsCommand.canExecute()) {
									command.add(preserveMessageAnchorsCommand);
								}
								CombinedFragment combinedFragment = (CombinedFragment)parent.resolveSemanticElement();
								if(!combinedFragment.getCovereds().isEmpty()) {
									ICommand cmd = getExpandCoveredsCommand(parent, newBounds);
									if(cmd != null) {
										command.add(cmd);
									}
								}
							}
						}
					}
					command.add(new SetBoundsCommand(compartment.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, rect));
				}
			}
		} else { // first add operand
			if(compartment.getParent() instanceof CombinedFragmentEditPart) {
				CombinedFragmentEditPart parent = (CombinedFragmentEditPart)compartment.getParent();
				if(parent.getModel() instanceof Node) {
					Node node = (Node)parent.getModel();
					if(node.getLayoutConstraint() instanceof Bounds) {
						Bounds containerBounds = (Bounds)node.getLayoutConstraint();
						Dimension preferredSize = parent.getFigure().getPreferredSize();
						int width = containerBounds.getWidth() != -1 ? containerBounds.getWidth() : preferredSize.width();
						int height = containerBounds.getHeight() != -1 ? containerBounds.getHeight() : preferredSize.height();
						height = height - computeCombinedFragementHeaderHeight(parent);
						command.add(new SetBoundsCommand(compartment.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, new Rectangle(0, 0, width - COMBINED_FRAGMENT_FIGURE_BORDER * 2, height - COMBINED_FRAGMENT_FIGURE_BORDER * 2)));
					}
				}
			}
		}
	}

	/**
	 * Expand Lifelines to new Bounds when adding InteractionOperands.
	 * 
	 * @param parent
	 * @param newBounds
	 * @return
	 */
	private static ICommand getExpandCoveredsCommand(CombinedFragmentEditPart parent, Rectangle newBounds) {
		CombinedFragment combinedFragment = (CombinedFragment)parent.resolveSemanticElement();
		CompositeCommand command = new CompositeCommand("Expand covered Lifeline by CombinedFragment");
		EList<Lifeline> covereds = combinedFragment.getCovereds();
		for(Lifeline lifeline : covereds) {
			Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(lifeline);
			for(Setting ref : settings) {
				if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					View view = (View)ref.getEObject();
					EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, parent);
					if(view instanceof Node && part instanceof LifelineEditPart) {
						Bounds bounds = (Bounds)((Node)view).getLayoutConstraint();
						Rectangle rect = new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
						int height = newBounds.bottom() - rect.y;
						if(rect.height == -1) {
							rect.height = ((LifelineEditPart)part).getFigure().getPreferredSize().height;
						}
						if(height > rect.height) {
							int heightDelta = height - rect.height;
							rect.height = height;
							command.add(new SetBoundsCommand(parent.getEditingDomain(), "Expand covered Lifeline by CombinedFragment", new EObjectAdapter(view), rect));
							command.add(MessageAnchorRepairer.createPreserveMessageAnchorsCommand((LifelineEditPart)part, heightDelta));
						}
						break;
					}
				}
			}
		}
		return command.isEmpty() ? null : command;
	}

	/**
	 * Check if it is a combined fragment.
	 * 
	 * @param hint
	 *        the semantic hint
	 * @return
	 */
	public static boolean isDerivedCombinedFragment(String hint) {
		if(((IHintedType)UMLElementTypes.CombinedFragment_3004).getSemanticHint().equals(hint)) {
			return true;
		}
		if(((IHintedType)UMLElementTypes.ConsiderIgnoreFragment_3007).getSemanticHint().equals(hint)) {
			return true;
		}
		return false;
	}

	/**
	 * Command class for updating Interaction Operand EditpPart bounds after CombinedFragment to be resized.
	 * 
	 */
	private static final class UpdateIOBoundsForCFResizeCommand extends AbstractTransactionalCommand {

		private final Bounds ioEPOriginalBounds;

		private final ChangeBoundsRequest request;

		private final Dimension sizeDelta;

		private boolean updateHeight = false;

		private int direction;

		private UpdateIOBoundsForCFResizeCommand(TransactionalEditingDomain domain, String label, Bounds ioEPOriginalBounds, ChangeBoundsRequest request, Dimension sizeDelta, boolean updateHeight, int direction) {
			super(domain, label, null);
			this.ioEPOriginalBounds = ioEPOriginalBounds;
			this.request = request;
			this.sizeDelta = sizeDelta;
			this.updateHeight = updateHeight;
			this.direction = direction;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if(updateHeight) {
				ioEPOriginalBounds.setHeight(ioEPOriginalBounds.getHeight() + sizeDelta.height());
			} else if((direction & PositionConstants.NORTH) != 0) {
				ioEPOriginalBounds.setY(ioEPOriginalBounds.getY() + sizeDelta.height());
			}
			if((request.getResizeDirection() & PositionConstants.EAST_WEST) != 0) {
				ioEPOriginalBounds.setWidth(ioEPOriginalBounds.getWidth() + sizeDelta.width());
			}
			return CommandResult.newOKCommandResult();
		}
	}

	private static List<OperandBlock> getOperandBlocks(InteractionOperandEditPart editPart) {
		List<OperandBlock> blocks = new ArrayList<OperandBoundsComputeHelper.OperandBlock>();
		if(editPart != null) {
			InteractionOperand interactionOperand = (InteractionOperand)editPart.resolveSemanticElement();
			Set<ExecutionSpecification> executions = new HashSet<ExecutionSpecification>();
			Set<Message> messages = new HashSet<Message>();
			EList<InteractionFragment> fragments = interactionOperand.getFragments();
			for(InteractionFragment fragment : fragments) {
				if(fragment instanceof ExecutionSpecification) {
					executions.add((ExecutionSpecification)fragment);
				} else if(fragment instanceof ExecutionOccurrenceSpecification) {
					ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)fragment).getExecution();
					if(execution != null) {
						executions.add(execution);
					}
				} else if(fragment instanceof MessageOccurrenceSpecification) {
					Message message = ((MessageOccurrenceSpecification)fragment).getMessage();
					if(message != null) {
						messages.add(message);
					}
				}
			}
			final EditPartViewer viewer = editPart.getViewer();
			if(!executions.isEmpty()) {
				for(ExecutionSpecification execution : executions) {
					List<View> existingViews = DiagramEditPartsUtil.findViews(execution, viewer);
					if(existingViews.isEmpty()) {
						continue;
					} else {
						for(View view : existingViews) {
							Object object = viewer.getEditPartRegistry().get(view);
							if(object instanceof ShapeNodeEditPart) {
								ShapeNodeEditPart child = (ShapeNodeEditPart)object;
								boolean visited = false;
								for(OperandBlock blk : blocks) {
									if(blk.contains(child)) {
										visited = true;
										break;
									}
								}
								if(visited) {
									break;
								} else {
									OperandBlock newBlock = new ExecutionOperandBlock(child, executions);
									blocks.add(newBlock);
								}
							}
						}
					}
				}
			}
			if(!messages.isEmpty()) {
				for(Message msg : messages) {
					List<View> existingViews = DiagramEditPartsUtil.findViews(msg, viewer);
					if(existingViews.isEmpty()) {
						continue;
					} else {
						for(View view : existingViews) {
							Object object = viewer.getEditPartRegistry().get(view);
							if(object instanceof ConnectionNodeEditPart) {
								ConnectionNodeEditPart child = (ConnectionNodeEditPart)object;
								EditPart source = child.getSource();
								if(source instanceof AbstractExecutionSpecificationEditPart && executions.contains(((AbstractExecutionSpecificationEditPart)source).resolveSemanticElement())) {
									continue;
								}
								EditPart target = child.getTarget();
								if(target instanceof AbstractExecutionSpecificationEditPart && executions.contains(((AbstractExecutionSpecificationEditPart)target).resolveSemanticElement())) {
									continue;
								}
								boolean visited = false;
								for(OperandBlock blk : blocks) {
									if(blk.contains(child)) {
										visited = true;
										break;
									}
								}
								if(visited) {
									break;
								} else {
									OperandBlock newBlock = new MessageOperandBlock(child);
									blocks.add(newBlock);
								}
							}
						}
					}
				}
			}
		}
		return blocks;
	}

	/**
	 * OperandBlock means the a group with ExecutionSpecifications contained in a InteractionOperand.
	 * 
	 * 1. All children of an execution should be contained.
	 * 2. The parent of an execution should be contained.
	 * 3. All ends of connected links which contained in the operand should be contained.
	 * 
	 * 4. All children would be moved together.
	 * 
	 * @author Jin Liu (jin.liu@soyatec.com)
	 */
	private static class ExecutionOperandBlock extends OperandBlock {


		public ExecutionOperandBlock(ShapeNodeEditPart child, Set<ExecutionSpecification> executions) {
			fillWith(child, executions);
		}

		private void fillWith(ShapeNodeEditPart child, Set<ExecutionSpecification> executions) {
			if(children.contains(child) || child == null || executions == null || executions.isEmpty()) {
				return;
			}
			children.add(child);
			List<ExecutionSpecification> toCheckExecutions = new ArrayList<ExecutionSpecification>(executions);
			toCheckExecutions.remove(child.resolveSemanticElement());
			Set<ShapeNodeEditPart> executionGroups = getExecutionGroups(child, toCheckExecutions);
			if(executionGroups != null && !executionGroups.isEmpty()) {
				for(ShapeNodeEditPart group : executionGroups) {
					fillWith(group, executions);
				}
			}
			LifelineEditPart parent = (LifelineEditPart)child.getParent();
			//1. parent bar
			List<ShapeNodeEditPart> childShapeNodeEditPart = LifelineEditPartUtil.getChildShapeNodeEditPart(parent);
			childShapeNodeEditPart.remove(child);
			ShapeNodeEditPart parentNode = LifelineXYLayoutEditPolicy.getParent(parent, child.getFigure().getBounds().getCopy(), childShapeNodeEditPart);
			if(parentNode != null) {
				fillWith(parentNode, executions);
			}
			//2. children
			List<ShapeNodeEditPart> affixedEditParts = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts(child);
			for(ShapeNodeEditPart affixedChild : affixedEditParts) {
				if(executions.contains(affixedChild.resolveSemanticElement())) {
					fillWith(affixedChild, executions);
				}
			}
		}

		protected Rectangle computeBounds() {
			Rectangle bounds = null;
			for(EditPart child : children) {
				Rectangle rect = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)child);
				if(bounds == null) {
					bounds = rect;
				} else {
					bounds.union(rect);
				}
			}
			return bounds;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private Set<ShapeNodeEditPart> getExecutionGroups(ShapeNodeEditPart executionEditPart, List<ExecutionSpecification> toCheckExecutions) {
			if(toCheckExecutions == null || toCheckExecutions.isEmpty()) {
				return null;
			}
			Set<ShapeNodeEditPart> executionGroups = new HashSet<ShapeNodeEditPart>();
			List connections = new ArrayList();
			connections.addAll(executionEditPart.getSourceConnections());
			connections.addAll(executionEditPart.getTargetConnections());
			for(Object object : connections) {
				org.eclipse.gef.ConnectionEditPart conn = (org.eclipse.gef.ConnectionEditPart)object;
				IGraphicalEditPart source = (IGraphicalEditPart)conn.getSource();
				if(executionEditPart == conn.getSource()) {
					source = (IGraphicalEditPart)conn.getTarget();
				}
				View model = (View)source.getModel();
				EObject element = model.getElement();
				if(toCheckExecutions.contains(element)) {
					executionGroups.add((ShapeNodeEditPart)source);
					List<ExecutionSpecification> myCheckingList = new ArrayList<ExecutionSpecification>(toCheckExecutions);
					myCheckingList.remove(element);
					Set<ShapeNodeEditPart> myGroups = getExecutionGroups((ShapeNodeEditPart)source, myCheckingList);
					if(myGroups != null) {
						executionGroups.addAll(myGroups);
					}
				}
			}
			return executionGroups;
		}

		public List<ShapeNodeEditPart> getShapeNodeChildren() {
			List<ShapeNodeEditPart> shapes = new ArrayList<ShapeNodeEditPart>();
			List<EditPart> children = getChildren();
			for(EditPart editPart : children) {
				if(editPart instanceof ShapeNodeEditPart) {
					shapes.add((ShapeNodeEditPart)editPart);
				}
			}
			return shapes;
		}
	}

	private static class MessageOperandBlock extends OperandBlock {


		/**
		 * Constructor.
		 * 
		 * @param child
		 * @param messages
		 */
		public MessageOperandBlock(ConnectionNodeEditPart child) {
			children.add(child);
		}

		@Override
		protected Rectangle computeBounds() {
			ConnectionNodeEditPart message = getMessageChild();
			if(message == null) {
				return null;
			}
			Point start = SequenceUtil.getAbsoluteEdgeExtremity(message, true);
			Point end = SequenceUtil.getAbsoluteEdgeExtremity(message, false);
			Rectangle bounds = new Rectangle(start, end);
			if(message.getSource() instanceof GateEditPart || message.getTarget() instanceof GateEditPart) {
				bounds.expand(0, Math.round((GateEditPart.DEFAULT_SIZE.height - bounds.height) / 2.0));
			}
			if(bounds.height < EXECUTION_VERTICAL_MARGIN) {
				bounds.height = EXECUTION_VERTICAL_MARGIN;
			}
			return bounds;
		}

		public ConnectionNodeEditPart getMessageChild() {
			return (ConnectionNodeEditPart)(children.isEmpty() ? null : children.get(0));
		}

	}

	private static abstract class OperandBlock {

		protected List<EditPart> children = new ArrayList<EditPart>();

		public boolean contains(EditPart child) {
			return children.contains(child);
		}

		public Rectangle getBounds() {
			return computeBounds();
		}

		public List<EditPart> getChildren() {
			return new ArrayList<EditPart>(children);
		}

		protected abstract Rectangle computeBounds();
	}

	private static class OperandBlockLayout {

		private Map<OperandBlock, Rectangle> constraints = new HashMap<OperandBoundsComputeHelper.OperandBlock, Rectangle>();

		private List<OperandBlock> fBlocks = new ArrayList<OperandBoundsComputeHelper.OperandBlock>();

		private List<Rectangle> validBlocks = new ArrayList<Rectangle>();

		/**
		 * Constructor.
		 * 
		 */
		public OperandBlockLayout(List<OperandBlock> blocks) {
			if(blocks != null) {
				for(OperandBlock blk : blocks) {
					if(blk.getBounds() != null) {
						fBlocks.add(blk);
					}
				}
			}
		}

		/**
		 * Sort in y location.
		 */
		private void sortBlocks() {
			Collections.sort(fBlocks, new Comparator<OperandBlock>() {

				public int compare(OperandBlock o1, OperandBlock o2) {
					Rectangle r1 = o1.getBounds();
					Rectangle r2 = o2.getBounds();
					if(r1.y < r2.y) {
						return -1;
					} else if(r1.y > r2.y) {
						return 1;
					}
					return 0;
				}
			});
		}

		public void layout(Rectangle newArea, boolean moveDown) {
			constraints.clear();
			validBlocks.clear();
			sortBlocks();
			if(!moveDown) {
				Collections.reverse(fBlocks);
			}
			doLayout(newArea, fBlocks, moveDown);
		}

		public int getMoveDelta(OperandBlock block) {
			Rectangle rect = constraints.get(block);
			if(rect == null) {
				return 0;
			}
			Rectangle bounds = block.getBounds();
			return rect.y - bounds.y;
		}

		private Rectangle getConstraint(OperandBlock blk) {
			Rectangle rect = constraints.get(blk);
			if(rect == null) {
				rect = blk.getBounds();
			}
			return rect;
		}

		private boolean doLayout(Rectangle area, List<OperandBlock> blocks, boolean moveDown) {
			if(blocks.isEmpty()) {
				return false;
			}
			OperandBlock invalidBlock = blocks.get(0);
			if(isValidBlock(area, invalidBlock)) {
				return false;
			}
			if(invalidBlock == null) {
				return false;
			}
			//layout...
			//1. Near the full area.
			Rectangle rect = invalidBlock.getBounds();
			Rectangle newRect = new Rectangle(rect);
			if(moveDown) {
				int start = rect.y > area.y ? rect.y : area.y;
				for(int y = start; y < area.bottom() - rect.height; y++) {
					newRect.setY(y);
					if(isValidBlock(area, newRect.getExpanded(0, EXECUTION_VERTICAL_MARGIN))) {
						break;
					}
				}
			} else {
				int start = rect.bottom() < area.bottom() ? rect.y : area.bottom() - rect.height;
				for(int y = start; y > area.y; y--) {
					newRect.setY(y);
					if(isValidBlock(area, newRect.getExpanded(0, EXECUTION_VERTICAL_MARGIN))) {
						break;
					}
				}
			}
			constraints.put(invalidBlock, newRect);
			validBlocks.add(newRect);

			List<OperandBlock> remainBlocks = new ArrayList<OperandBoundsComputeHelper.OperandBlock>(blocks);
			remainBlocks.remove(invalidBlock);
			return doLayout(area, remainBlocks, moveDown);
		}

		private boolean isValidBlock(Rectangle area, OperandBlock blk) {
			Rectangle rect = getConstraint(blk);
			return isValidBlock(area, rect);
		}

		private boolean isValidBlock(Rectangle area, Rectangle block) {
			if(area.y > block.y || area.bottom() < block.bottom()) {
				return false;
			}
			for(Rectangle validRect : validBlocks) {
				if(block.intersects(validRect)) {
					return false;
				}
			}
			return true;
		}

	}

	private static class MoveOperandBlockCommand extends AbstractTransactionalCommand {

		private Map<OperandBlock, Integer> blockToMove;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 * @param label
		 * @param affectedFiles
		 */
		public MoveOperandBlockCommand(TransactionalEditingDomain domain, Map<OperandBlock, Integer> blockToMove) {
			super(domain, "move operand blocks", null);
			this.blockToMove = blockToMove;
		}

		/**
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 * @param info
		 * @return
		 * @throws ExecutionException
		 */

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			List<OperandBlock> blocks = new ArrayList<OperandBoundsComputeHelper.OperandBlock>(blockToMove.keySet());
			Collections.sort(blocks, new Comparator<OperandBlock>() {

				public int compare(OperandBlock o1, OperandBlock o2) {
					int m1 = Math.abs(blockToMove.get(o1).intValue());
					int m2 = Math.abs(blockToMove.get(o2).intValue());
					if(m1 < m2) {
						return -1;
					} else if(m1 > m2) {
						return 1;
					} else if(m1 == m2) {
						if(m1 > 0) {
							int y1 = o1.getBounds().y;
							int y2 = o2.getBounds().y;
							if(y1 > y2) {
								return -1;
							} else if(y1 < y2) {
								return 1;
							}
						}
					}
					return 0;
				}
			});
			for(int i = 0; i < blocks.size(); i++) {
				OperandBlock block = blocks.get(i);
				int moveDelta = blockToMove.get(block);
				Command command = getMoveOperandBlockCommand(block, moveDelta);
				if(command != null && command.canExecute()) {
					command.execute();
				}
			}
			blockToMove = null;
			return CommandResult.newOKCommandResult();
		}

		private Command getMoveOperandBlockCommand(OperandBlock block, int moveDelta) {
			if(block == null || moveDelta == 0) {
				return null;
			}
			CompoundCommand commands = new CompoundCommand();
			if(block instanceof ExecutionOperandBlock) {
				List<ShapeNodeEditPart> children = ((ExecutionOperandBlock)block).getShapeNodeChildren();
				for(ShapeNodeEditPart child : children) {
					Bounds bounds = getInteractionOperandEPBounds(child);
					Rectangle newBounds = fillRectangle(bounds);
					newBounds.y += moveDelta;
					CompoundCommand moveCommand = new CompoundCommand();
					SetBoundsCommand cmd = new SetBoundsCommand(getEditingDomain(), getLabel(), child, newBounds);
					moveCommand.add(new ICommandProxy(cmd));
					moveCommand = OccurrenceSpecificationMoveHelper.completeMoveExecutionSpecificationCommand(moveCommand, child, newBounds, new ChangeBoundsRequest());
					List targetConnections = child.getTargetConnections();
					for(Object object : targetConnections) {
						if(!(object instanceof AbstractMessageEditPart)) {
							continue;
						}
						AbstractMessageEditPart conn = (AbstractMessageEditPart)object;
						EditPart source = conn.getSource();
						if(!(source instanceof AbstractExecutionSpecificationEditPart)) {
							Edge edge = (Edge)conn.getNotationView();
							Connection connectionFigure = conn.getConnectionFigure();
							ConnectionAnchor sourceAnchor = connectionFigure.getSourceAnchor();
							Rectangle figureBounds = sourceAnchor.getOwner().getBounds();
							Anchor gmfTargetAnchor = edge.getSourceAnchor();
							if(gmfTargetAnchor instanceof IdentityAnchor) {
								ICommand moveAnchorCommand = getMoveAnchorCommand(moveDelta, figureBounds, (IdentityAnchor)gmfTargetAnchor);
								if(moveAnchorCommand != null && moveAnchorCommand.canExecute()) {
									commands.add(new ICommandProxy(moveAnchorCommand));
								}
							}
						}
					}
					List sourceConnections = child.getSourceConnections();
					for(Object object : sourceConnections) {
						if(!(object instanceof AbstractMessageEditPart)) {
							continue;
						}
						AbstractMessageEditPart conn = (AbstractMessageEditPart)object;
						EditPart target = conn.getTarget();
						if(!(target instanceof AbstractExecutionSpecificationEditPart)) {
							Edge edge = (Edge)conn.getNotationView();
							Connection connectionFigure = conn.getConnectionFigure();
							ConnectionAnchor targetAnchor = connectionFigure.getTargetAnchor();
							Rectangle figureBounds = targetAnchor.getOwner().getBounds();
							Anchor gmfTargetAnchor = edge.getTargetAnchor();
							if(gmfTargetAnchor instanceof IdentityAnchor) {
								ICommand moveAnchorCommand = getMoveAnchorCommand(moveDelta, figureBounds, (IdentityAnchor)gmfTargetAnchor);
								if(moveAnchorCommand != null && moveAnchorCommand.canExecute()) {
									commands.add(new ICommandProxy(moveAnchorCommand));
								}
							}
						}
					}
					commands.add(moveCommand);
				}
			} else if(block instanceof MessageOperandBlock) {
				ConnectionNodeEditPart message = ((MessageOperandBlock)block).getMessageChild();
				if(message != null) {
					Edge edge = (Edge)message.getModel();
					Connection msgFigure = message.getConnectionFigure();
					if(message.getSource() instanceof GateEditPart) {
						GateEditPart gate = (GateEditPart)message.getSource();
						Location layout = (Location)((Shape)gate.getNotationView()).getLayoutConstraint();
						Point location = new Point(layout.getX(), layout.getY());
						location.y += moveDelta;
						SetBoundsCommand command = new SetBoundsCommand(getEditingDomain(), "", gate, location);
						commands.add(new ICommandProxy(command));
					} else {
						ConnectionAnchor sourceAnchor = msgFigure.getSourceAnchor();
						IdentityAnchor gmfSourceAnchor = (IdentityAnchor)edge.getSourceAnchor();
						Rectangle figureBounds = sourceAnchor.getOwner().getBounds();
						if(gmfSourceAnchor != null) {
							commands.add(new ICommandProxy(getMoveAnchorCommand(moveDelta, figureBounds, gmfSourceAnchor)));
						}
					}
					if(message.getTarget() instanceof GateEditPart) {
						GateEditPart gate = (GateEditPart)message.getTarget();
						Location layout = (Location)((Shape)gate.getNotationView()).getLayoutConstraint();
						Point location = new Point(layout.getX(), layout.getY());
						location.y += moveDelta;
						SetBoundsCommand command = new SetBoundsCommand(getEditingDomain(), "", gate, location);
						commands.add(new ICommandProxy(command));
					} else {
						IdentityAnchor gmfTargetAnchor = (IdentityAnchor)edge.getTargetAnchor();
						ConnectionAnchor targetAnchor = msgFigure.getTargetAnchor();
						Rectangle figureBounds = targetAnchor.getOwner().getBounds();
						if(gmfTargetAnchor != null) {
							commands.add(new ICommandProxy(getMoveAnchorCommand(moveDelta, figureBounds, gmfTargetAnchor)));
						}
					}
				}
			}
			return commands.unwrap();
		}
	}
}
