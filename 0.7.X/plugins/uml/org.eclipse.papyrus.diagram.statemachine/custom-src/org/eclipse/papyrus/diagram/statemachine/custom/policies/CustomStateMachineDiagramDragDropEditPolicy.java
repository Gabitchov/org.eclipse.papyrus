package org.eclipse.papyrus.diagram.statemachine.custom.policies;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CreateViewCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomRegionCreateElementCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomRegionDeleteCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomStateMachineSetBoundsCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CustomStateMachineWithDefaultRegionCreateNodeCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.edit.part.CustomRegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.RegionFigure;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.StateMachineLinkMappingHelper;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.diagram.statemachine.custom.locators.CustomEntryExitPointPositionLocator;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;

public class CustomStateMachineDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	IFigure sizeOnDropFeedback = null;

	String dropLocation = Zone.RIGHT;

	boolean fromOutline = false;

	/**
	 * Instantiates a new state machine diagram drag drop edit policy with the
	 * right link mapping helper
	 */
	public CustomStateMachineDiagramDragDropEditPolicy() {
		super(StateMachineLinkMappingHelper.getInstance());
	}

	/**
	 * <pre>
	 * Returns the drop command for Affixed nodes (Pseudostate entry/exitPoint).
	 * </pre>
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param location
	 *        the location to drop the element
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropAffixedNode(DropObjectsRequest dropRequest, Element droppedElement, int nodeVISUALID) {

		// The dropped element must be a Pseudostate
		if(!(droppedElement instanceof Pseudostate)) {
			return UnexecutableCommand.INSTANCE;
		}

		Pseudostate ps = (Pseudostate)droppedElement;
		// The dropped element must be an entry or exitPoint
		PseudostateKind kind = ps.getKind();
		if(!(kind.equals(PseudostateKind.ENTRY_POINT_LITERAL) || kind.equals(PseudostateKind.EXIT_POINT_LITERAL))) {
			return UnexecutableCommand.INSTANCE;
		}
		// Manage Element drop in compartment
		Boolean isCompartmentTarget = false; // True if the target is a ShapeCompartmentEditPart
		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();

		// Default drop location
		Point dropLocation = dropRequest.getLocation().getCopy();

		// Detect if the drop target is a compartment
		if(graphicalParentEditPart instanceof RegionCompartmentEditPart) {
			isCompartmentTarget = true;

			// Replace compartment edit part by its ancestor StateMachineEditPart
			graphicalParentEditPart = (GraphicalEditPart)graphicalParentEditPart.getParent().getParent().getParent();

			// Translate Pseudostate expected location according to the compartment location
			Point targetLocation = graphicalParentEditPart.getContentPane().getBounds().getLocation();
			ShapeCompartmentFigure compartmentFigure = (ShapeCompartmentFigure)getHostFigure();

			compartmentFigure.translateToAbsolute(dropLocation);
		}
		// Manage Element drop in compartment

		// Create proposed creation bounds and use the locator to find the expected position
		Point parentLoc = graphicalParentEditPart.getFigure().getBounds().getLocation().getCopy();
		CustomEntryExitPointPositionLocator locator = new CustomEntryExitPointPositionLocator(graphicalParentEditPart.getFigure(), PositionConstants.NONE);

		Rectangle proposedBounds = new Rectangle(dropLocation, new Dimension(20, 20));
		if(!isCompartmentTarget)
			proposedBounds = proposedBounds.getTranslated(parentLoc);
		Rectangle preferredBounds = locator.getPreferredLocation(proposedBounds);

		// Convert the calculated preferred bounds as relative to parent location
		Rectangle creationBounds = preferredBounds.getTranslated(parentLoc.getNegated());
		dropLocation = creationBounds.getLocation();

		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		if((graphicalParentObject instanceof StateMachine) && (((StateMachine)graphicalParentObject).getConnectionPoints().contains(droppedElement))) {
			// Drop Pseudostate on StateMachine
			if(isCompartmentTarget) {
				return getDropAffixedNodeInCompartmentCommand(nodeVISUALID, dropLocation, droppedElement);
			}
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropLocation, droppedElement));

		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the drop command for StateMachine nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param location
	 *        the location to drop the element
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropRegion(DropObjectsRequest dropRequest, Region droppedElement, int nodeVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		if((graphicalParentObject instanceof Region) && (((Region)graphicalParentObject).getStateMachine().getRegions().contains(droppedElement)) && !graphicalParentObject.equals(droppedElement)) {
			CompositeCommand cc = new CompositeCommand("Drop");
			// get an adaptable for the dropped region
			IAdaptable adaptableForDroppedRegion = (IAdaptable)new SemanticAdapter(droppedElement, null);
			// get the existing region view
			View existingRegionView = (View)graphicalParentEditPart.getParent().getModel();
			// get and adaptable for it, to pass on to commands
			IAdaptable adaptableForExistingRegionView = (IAdaptable)new SemanticAdapter(null, existingRegionView);

			// check whether the dropped region is already shown in the state
			// machine
			View stateMachineCompartment = (View)existingRegionView.eContainer();
			View alreadyShown = null;
			Iterator<View> it = stateMachineCompartment.getChildren().iterator();
			while((alreadyShown == null) && it.hasNext()) {
				View current = it.next();
				if(current.getElement().equals(droppedElement)) {
					alreadyShown = current;
				}
			}
			if(alreadyShown != null) {
				if(fromOutline) {
					return UnexecutableCommand.INSTANCE;
				}
				// specific command to get rid of the already shown region
				CustomRegionDeleteCommand deleteAlreadyShown = new CustomRegionDeleteCommand(getEditingDomain(), alreadyShown);
				cc.compose(deleteAlreadyShown);
			}

			// do the whole job
			CustomRegionCreateElementCommand createNewRegion = new CustomRegionCreateElementCommand(adaptableForExistingRegionView, adaptableForDroppedRegion, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint(), getEditingDomain(), DiagramUIMessages.CreateCommand_Label, dropLocation);

			cc.compose(createNewRegion);

			return new ICommandProxy(cc.reduce());
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the drop command for StateMachine nodes.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param location
	 *        the location to drop the element
	 * @param droppedElement
	 *        the element to drop
	 * @param nodeVISUALID
	 *        the visual identifier of the EditPart of the dropped element
	 * @return the drop command
	 */
	protected Command dropStateMachine(DropObjectsRequest dropRequest, Point location, StateMachine droppedElement, int nodeVISUALID) {

		GraphicalEditPart graphicalParentEditPart = (GraphicalEditPart)getHost();
		EObject graphicalParentObject = graphicalParentEditPart.resolveSemanticElement();

		if((graphicalParentObject instanceof org.eclipse.uml2.uml.StateMachine)) {
			CompositeCommand cc = new CompositeCommand("Drop");
			IAdaptable elementAdapter = new EObjectAdapter(droppedElement);

			ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());

			CreateCommand createStateMachine = new CreateCommand(getEditingDomain(), descriptor, (View)(getHost().getModel()));

			CustomStateMachineWithDefaultRegionCreateNodeCommand createRegion = new CustomStateMachineWithDefaultRegionCreateNodeCommand((IAdaptable)createStateMachine.getCommandResult().getReturnValue(), ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint(), getEditingDomain(), DiagramUIMessages.CreateCommand_Label, createStateMachine.getAffectedFiles());

			CustomStateMachineSetBoundsCommand setBoundsCommand = new CustomStateMachineSetBoundsCommand(getEditingDomain(), null, descriptor, new Rectangle(location.x, location.y, -1, -1));

			cc.compose(createStateMachine);
			cc.compose(createRegion);
			cc.compose(setBoundsCommand);
			return new ICommandProxy(cc.reduce());
		}

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if(sizeOnDropFeedback != null) {
			removeFeedback(sizeOnDropFeedback);
			sizeOnDropFeedback = null;
		}
	}

	/**
	 * <pre>
	 * This method returns the drop command for AffixedNode (Pseudostate) 
	 * in case the node is dropped on a ShapeCompartmentEditPart.
	 * </pre>
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return a CompositeCommand for Drop
	 */
	protected CompoundCommand getDropAffixedNodeInCompartmentCommand(int nodeVISUALID, Point location, EObject droppedObject) {
		CompoundCommand cc = new CompoundCommand("Drop");
		IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		// Create the command targeting host parent (owner of the ShapeCompartmentEditPart) 
		CreateViewCommand createCommand = new CreateViewCommand(getEditingDomain(), descriptor, ((View)(getHost().getParent().getParent().getParent().getModel())));
		cc.add(new ICommandProxy(createCommand));

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), location);
		cc.add(new ICommandProxy(setBoundsCommand));

		return cc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualId = new HashSet<Integer>();
		droppableElementsVisualId.add(StateMachineEditPart.VISUAL_ID);
		droppableElementsVisualId.add(RegionEditPart.VISUAL_ID);
		droppableElementsVisualId.add(PseudostateEntryPointEditPart.VISUAL_ID);
		droppableElementsVisualId.add(PseudostateExitPointEditPart.VISUAL_ID);
		return droppableElementsVisualId;
	}

	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		if((domainElement instanceof Region) && (containerView.getElement() instanceof Region)) {
			return RegionEditPart.VISUAL_ID;
		}
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	protected IFigure getSizeOnDropFeedback() {
		if(sizeOnDropFeedback == null) {
			sizeOnDropFeedback = new RectangleFigure();
			FigureUtilities.makeGhostShape((Shape)sizeOnDropFeedback);
			((Shape)sizeOnDropFeedback).setLineStyle(Graphics.LINE_DASHDOT);
			sizeOnDropFeedback.setForegroundColor(ColorConstants.white);
			addFeedback(sizeOnDropFeedback);
		}
		return sizeOnDropFeedback;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {

		// Retrieve drop location
		Point location = dropRequest.getLocation().getCopy();

		switch(nodeVISUALID) {
		case StateMachineEditPart.VISUAL_ID:
			return dropStateMachine(dropRequest, location, (StateMachine)semanticElement, nodeVISUALID);
		case RegionEditPart.VISUAL_ID:
			return dropRegion(dropRequest, (Region)semanticElement, nodeVISUALID);
		case PseudostateEntryPointEditPart.VISUAL_ID:
		case PseudostateExitPointEditPart.VISUAL_ID:
			return dropAffixedNode(dropRequest, (Pseudostate)semanticElement, nodeVISUALID);

		default:
			return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
		}
	}

	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	@Override
	public void showTargetFeedback(Request request) {
		if((request instanceof ChangeBoundsRequest) && !REQ_RESIZE.equals(request.getType())) {
			fromOutline = false;
			ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest)request;
			for(Iterator iter = changeBoundsRequest.getEditParts().iterator(); iter.hasNext();) {
				GraphicalEditPart element = (GraphicalEditPart)iter.next();
				if(element instanceof RegionEditPart) {
					CustomRegionEditPart regionEditPart = (CustomRegionEditPart)element;

					View stateMachineCompartment = (View)((View)element.getModel()).eContainer();
					if(stateMachineCompartment.getChildren().size() == 1)
						return;

					CustomRegionDragTracker dragTracker = regionEditPart.getRegionDragTracker();
					RegionEditPart targetEP = dragTracker.getTargetRegionEditPart();
					if(targetEP != null) {
						RegionFigure targetFig = targetEP.getPrimaryShape();

						// make a local copy
						Rectangle targetFigBounds = targetFig.getBounds().getCopy();
						// transform the coordinates to absolute
						targetFig.translateToAbsolute(targetFigBounds);
						// retrieve mouse location
						Point mouseLocation = changeBoundsRequest.getLocation();

						// get the drop location, i.e. RIGHT, LEFT, TOP, BOTTOM
						dropLocation = Zone.getZoneFromLocationInRectangleWithAbsoluteCoordinates(mouseLocation, targetFigBounds);

						// perform corresponding change (scaling, translation)
						// on
						// targetFigBounds
						// and updates the graph node drop location property
						if(Zone.isTop(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(1.0, 0.5));
						} else if(Zone.isLeft(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(0.5, 1.0));
						} else if(Zone.isRight(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(0.5, 1.0));
							targetFigBounds.translate(targetFigBounds.width, 0);
						} else if(Zone.isBottom(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(1.0, 0.5));
							targetFigBounds.translate(0, targetFigBounds.height);
						}

						getSizeOnDropFeedback().setBounds(new PrecisionRectangle(targetFigBounds));
					} else {

						Rectangle targetFigBounds = dragTracker.getRegionFigureBounds();

						// retrieve mouse move
						Point mouseMove = changeBoundsRequest.getMoveDelta();

						targetFigBounds.translate(mouseMove);

						getSizeOnDropFeedback().setBounds(new PrecisionRectangle(targetFigBounds));
					}
				}
			}
		}
		if(request instanceof DropObjectsRequest) {
			fromOutline = true;
			DropObjectsRequest dropRequest = (DropObjectsRequest)request;
			for(Iterator iter = dropRequest.getObjects().iterator(); iter.hasNext();) {
				EObject element = (EObject)iter.next();
				if(element instanceof Region) {
					// check whether the dropped region is already shown in the
					// state machine
					View stateMachineCompartment = (View)((StateMachineCompartmentEditPart)getHost().getParent().getParent()).getModel();
					View alreadyShown = null;
					Iterator<View> it = stateMachineCompartment.getChildren().iterator();
					while((alreadyShown == null) && it.hasNext()) {
						View current = it.next();
						if(current.getElement().equals(element)) {
							alreadyShown = current;
						}
					}
					if(alreadyShown == null) {
						RegionFigure targetFig = ((RegionEditPart)getHost().getParent()).getPrimaryShape();

						// make a local copy
						Rectangle targetFigBounds = targetFig.getBounds().getCopy();
						// transform the coordinates to absolute
						targetFig.translateToAbsolute(targetFigBounds);
						// retrieve mouse location
						Point mouseLocation = dropRequest.getLocation().getCopy();

						// get the drop location, i.e. RIGHT, LEFT, TOP, BOTTOM
						dropLocation = Zone.getZoneFromLocationInRectangleWithAbsoluteCoordinates(mouseLocation, targetFigBounds);

						// perform corresponding change (scaling, translation)
						// on
						// targetFigBounds
						// and updates the graph node drop location property
						if(Zone.isTop(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(1.0, 0.5));
						} else if(Zone.isLeft(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(0.5, 1.0));
						} else if(Zone.isRight(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(0.5, 1.0));
							targetFigBounds.translate(targetFigBounds.width, 0);
						} else if(Zone.isBottom(dropLocation)) {
							targetFigBounds.setSize(targetFigBounds.getSize().scale(1.0, 0.5));
							targetFigBounds.translate(0, targetFigBounds.height);
						}

						getSizeOnDropFeedback().setBounds(new PrecisionRectangle(targetFigBounds));
					}
				}
			}
		}
	}


}
