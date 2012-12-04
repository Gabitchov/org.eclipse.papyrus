/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.uml.diagram.common.draw2d.anchors.LifelineAnchor;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RectangularShadowBorder;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ElementCreationWithMessageEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionCompartmentXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineAppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.locator.CenterLocator;
import org.eclipse.papyrus.uml.diagram.sequence.locator.TimeMarkElementPositionLocator;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineCoveredByUpdater;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineMessageCreateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineModelChildrenHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineResizeHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class LifelineEditPart extends NamedElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * True if the lifeline is in inline mode
	 */
	private boolean inlineMode;

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifier = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * Layout role for inline mode
	 */
	private LayoutEditPolicy inlineModeLayoutRole = createLayoutEditPolicy();;

	/**
	 * Layout role for normal mode
	 */
	private LayoutEditPolicy normalModeLayoutRole = new LifelineXYLayoutEditPolicy();

	/**
	 * Layout role for drag drop
	 */
	private DragDropEditPolicy dragDropEditPolicy = new DragDropEditPolicy();

	/**
	 * @generated
	 */
	public LifelineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {
			
			@Override
			protected Command getCreateElementAndViewCommand(
					CreateViewAndElementRequest request) {
				Command command = super.getCreateElementAndViewCommand(request);
				CompositeCommand compositeCommand = new CompositeCommand("");
				if (command instanceof ICommandProxy) {
					ICommandProxy proxy = (ICommandProxy) command;
					ICommand realCmd = proxy.getICommand();
					compositeCommand.add(realCmd);
				}
				
				return command;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LifelineItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new LifelineXYLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new LifelineCreationEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ElementCreationWithMessageEditPolicy());
		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new LifelineAppliedStereotypeNodeLabelDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		
		//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=364608
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LifelineSelectionEditPolicy());
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new LifelineMessageCreateHelper.ComponentEditPolicyEx());
		// custom label, fix bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=383722
		installEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY, new LifelineLabelEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case StateInvariantEditPart.VISUAL_ID:
				case TimeConstraintEditPart.VISUAL_ID:
				case TimeObservationEditPart.VISUAL_ID:
				case DurationConstraintEditPart.VISUAL_ID:
				case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:

					return new BorderItemResizableEditPolicy();

				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				if(request instanceof ChangeBoundsRequest)
					return getMoveResizeCommand((ChangeBoundsRequest)request);
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}

			public Command getCommand(Request request) {
				Command command = null;
				if(REQ_MOVE_CHILDREN.equals(request.getType()))
					command = getMoveChildrenCommand(request);
				if(REQ_RESIZE_CHILDREN.equals(request.getType()) && request instanceof ChangeBoundsRequest)
					command = getMoveResizeCommand((ChangeBoundsRequest)request);
				if(command != null)
					return command;

				return super.getCommand(request);
			}

			private Command getMoveResizeCommand(ChangeBoundsRequest request) {
				List changeEditParts = request.getEditParts();
				if (changeEditParts != null && changeEditParts.size() > 0) {
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
					CompositeTransactionalCommand composite = new CompositeTransactionalCommand(editingDomain, null);

					LifelineEditPart parent = (LifelineEditPart)this.getHost();
					LifelineDotLineCustomFigure parentFig = (LifelineDotLineCustomFigure)parent.getContentPane();
					Rectangle parentBounds = parentFig.getBounds();
					for (Object o : changeEditParts) {
						if (o instanceof LifelineEditPart) {
							LifelineEditPart child = (LifelineEditPart)o;
							IFigure childFig = child.getFigure();

							Rectangle newBounds = childFig.getBounds().getCopy();
							Rectangle childConstraint = (Rectangle)parentFig.getLayoutManager().getConstraint(childFig);
							newBounds.setLocation(childConstraint.getLocation().getCopy());
							
							newBounds.translate(request.getMoveDelta());
							if (!request.getType().equals(RequestConstants.REQ_MOVE_CHILDREN)) {
								newBounds.resize(request.getSizeDelta());
							}

							// do not excceed parent
							if (newBounds.x < 0) {
								newBounds.width += newBounds.x;
								newBounds.x = 0;
							}
							if (newBounds.x + newBounds.width > parentBounds.width) {
								newBounds.width = parentBounds.width - newBounds.x;
							}

							ICommand boundsCommand = new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter((View)child.getModel()), newBounds);
							composite.add(boundsCommand);
							composite.add(LifelineResizeHelper.createManualLabelSizeCommand((LifelineEditPart)child));
						}
					}
					return new ICommandProxy(composite.reduce());
				}
				return null;
			}

		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new LifelineFigure();
	}

	/**
	 * @generated
	 */
	public LifelineFigure getPrimaryShape() {
		return (LifelineFigure)primaryShape;
	}

	/**
	 * @generated NOT (update at each lifeline modification) update the locator with edit part reference
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof LifelineNameEditPart) {
			((LifelineNameEditPart)childEditPart).setLabel(getPrimaryShape().getFigureLifelineLabelFigure());
			return true;
		}

		//Papyrus Gencode :Affixed locator for Lifelines to place element with a time bar
		if(childEditPart instanceof TimeConstraintEditPart) {
			// update the locator with edit part reference
			TimeMarkElementPositionLocator locator = new TimeMarkElementPositionLocator(getMainFigure(), PositionConstants.NONE);
			locator.setEditPart(childEditPart);
			getBorderedFigure().getBorderItemContainer().add(((TimeConstraintEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed locator for Lifelines to place element with a time bar
		if(childEditPart instanceof TimeObservationEditPart) {
			// update the locator with edit part reference
			TimeMarkElementPositionLocator locator = new TimeMarkElementPositionLocator(getMainFigure(), PositionConstants.NONE);
			locator.setEditPart(childEditPart);
			getBorderedFigure().getBorderItemContainer().add(((TimeObservationEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Affixed locator for Lifelines to place element with a time bar
		if(childEditPart instanceof DurationConstraintEditPart) {
			// update the locator with edit part reference
			TimeMarkElementPositionLocator locator = new TimeMarkElementPositionLocator(getMainFigure(), PositionConstants.NONE);
			locator.setEditPart(childEditPart);
			getBorderedFigure().getBorderItemContainer().add(((DurationConstraintEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		//Papyrus Gencode :Specific locator for the destructionEvent
		if(childEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			IBorderItemLocator locator = new CenterLocator(getMainFigure(), PositionConstants.SOUTH);
			getBorderedFigure().getBorderItemContainer().add(((DestructionOccurrenceSpecificationEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		if(childEditPart instanceof StateInvariantEditPart) {
			IBorderItemLocator locator = new CenterLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((StateInvariantEditPart)childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof LifelineNameEditPart) {
			return true;
		}
		if(childEditPart instanceof StateInvariantEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((StateInvariantEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof TimeConstraintEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((TimeConstraintEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof TimeObservationEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((TimeObservationEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof DurationConstraintEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((DurationConstraintEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((DestructionOccurrenceSpecificationEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT Execution specification handling
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		// Execution specification handling
		if(editPart instanceof BehaviorExecutionSpecificationEditPart || editPart instanceof ActionExecutionSpecificationEditPart || editPart instanceof CombinedFragment2EditPart) {
			return getPrimaryShape().getFigureLifelineDotLineFigure();
		}
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * Overrides to disable the defaultAnchorArea. The edge is now more stuck with the middle of the
	 * figure.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new LifelineDotLineCustomFigure.DefaultSizeNodeFigureEx(100, 250) {

			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}
			
			public boolean containsPoint(int x, int y) {
				if (primaryShape != null) {
					return primaryShape.containsPoint(x, y);
				}
				return super.containsPoint(x, y);
			}
		};
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated NOT Execution specification handling
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}

		// Execution specification handling
		if(nodeShape instanceof LifelineFigure) {
			LifelineFigure lFigure = (LifelineFigure)nodeShape;
			return lFigure.getFigureLifelineDotLineFigure();
		}

		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineWidth(int width) {
		if(getPrimaryShape() instanceof NodeFigure){
			((NodeFigure)getPrimaryShape()).setLineWidth(width);
		}else if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(LifelineNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4003);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4004);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4005);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4006);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4007);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4008);
		}
		if(targetEditPart instanceof InteractionEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConsiderIgnoreFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragmentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionOperandEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof InteractionUseEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ContinuationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ActionExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof BehaviorExecutionSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof StateInvariantEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CombinedFragment2EditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DestructionOccurrenceSpecificationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationConstraintInMessageEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Message_4009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		}
		return types;
	}
	
	@Override
	protected List getModelChildren() {
		Object model = getModel();
		//Fixed bug about inverse order for ExecutionSpecifications.
		if (model instanceof View){
			return LifelineModelChildrenHelper.getModelChildren((View)model);
		}
		return super.getModelChildren();
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(9);
		types.add(UMLElementTypes.Message_4003);
		types.add(UMLElementTypes.Message_4004);
		types.add(UMLElementTypes.Message_4005);
		types.add(UMLElementTypes.Message_4006);
		types.add(UMLElementTypes.Message_4007);
		types.add(UMLElementTypes.Message_4008);
		types.add(UMLElementTypes.Message_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4010);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Message_4003) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4004) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4005) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4006) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4007) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4008) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.Message_4009) {
			types.add(UMLElementTypes.Interaction_2001);
			types.add(UMLElementTypes.ConsiderIgnoreFragment_3007);
			types.add(UMLElementTypes.CombinedFragment_3004);
			types.add(UMLElementTypes.InteractionOperand_3005);
			types.add(UMLElementTypes.InteractionUse_3002);
			types.add(UMLElementTypes.Continuation_3016);
			types.add(UMLElementTypes.Lifeline_3001);
			types.add(UMLElementTypes.ActionExecutionSpecification_3006);
			types.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
			types.add(UMLElementTypes.StateInvariant_3017);
			types.add(UMLElementTypes.CombinedFragment_3018);
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.TimeObservation_3020);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.DestructionOccurrenceSpecification_3022);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.Comment_3009);
			types.add(UMLElementTypes.DurationConstraint_3023);
			types.add(UMLElementTypes.DurationObservation_3024);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4010) {
			types.add(UMLElementTypes.Comment_3009);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4011) {
			types.add(UMLElementTypes.TimeConstraint_3019);
			types.add(UMLElementTypes.DurationConstraint_3021);
			types.add(UMLElementTypes.Constraint_3008);
			types.add(UMLElementTypes.DurationConstraint_3023);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class LifelineFigure extends LifelineDotLineCustomFigure.NodeNamedElementFigureEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLifelineLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureLifelineNameContainerFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureExecutionsContainerFigure;

		/**
		 * @generated
		 */
		private LifelineDotLineCustomFigure fFigureLifelineDotLineFigure;

		/**
		 * @generated NOT call super, remove createContents, moved overall configuration to createCompositeFigureStructure
		 */
		public LifelineFigure() {
			// call super
			super();

			// moved overall configuration to createCompositeFigureStructure
			//BorderLayout layoutThis = new BorderLayout();
			//this.setLayoutManager(layoutThis);
			//this.setMaximumSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(200)));
			// remove createContents
			//createContents();
		}

		public int getNameContainerPreferredHeight(int wHint) {
			return fFigureLifelineNameContainerFigure.getPreferredSize(wHint, -1).height;
		}

		/**
		 * Get the rectangle which contains all labels
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#getDefaultLabelsContainer()
		 * @return lifeline labels rectangle
		 */
		@Override
		protected IFigure getDefaultLabelsContainer() {
			return getFigureLifelineNameContainerFigure();
		}

		/**
		 * Create the composite structure.
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#createCompositeFigureStructure()
		 */
		@Override
		protected void createCompositeFigureStructure() {
			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(200)));
			createContents();
		}

		/**
		 * Paint the label rectangle as background instead of the whole figure
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#paintBackground(org.eclipse.draw2d.Graphics,
		 *      org.eclipse.draw2d.geometry.Rectangle)
		 * @param graphics
		 *        graphics tool
		 * @param rectangle
		 *        unused
		 */
		@Override
		protected void paintBackground(Graphics graphics, Rectangle rectangle) {
			super.paintBackground(graphics, getFigureLifelineNameContainerFigure().getBounds());
		}

		/**
		 * Get the figure on which the border must be drawn.
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#getBorderedFigure()
		 * @return the rectangle containing labels
		 */
		@Override
		protected IFigure getBorderedFigure() {
			return getFigureLifelineNameContainerFigure();
		}

		/**
		 * Construct the appropriate border
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#getDefaultBorder(org.eclipse.swt.graphics.Color)
		 * @param borderColor
		 *        the color of the border
		 * @return the border
		 */
		@Override
		protected Border getDefaultBorder(Color borderColor) {
			int margin = getMapMode().DPtoLP(7);
			MarginBorder defaultBorder = new MarginBorder(margin, margin, margin, margin);
			return defaultBorder;
		}

		/**
		 * Get layout to display content of properties compartment.
		 * 
		 * @return the layout
		 */
		protected LayoutManager getPropertiesCompartmentLayout() {
			ToolbarLayout layout = new ToolbarLayout(false);
			layout.setStretchMinorAxis(true);
			return layout;
		}

		/**
		 * Create the name label with width wrap
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#createNameLabel()
		 */
		@Override
		protected void createNameLabel() {
			super.createNameLabel();
			//nameLabel.setTextWrap(true);
		}

		/**
		 * @generated NOT remove label creation, change layout
		 */
		private void createContents() {

			fFigureLifelineNameContainerFigure = new RectangleFigure();
			// do not fill to enable gradient
			fFigureLifelineNameContainerFigure.setFill(false);

			fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));

			this.add(fFigureLifelineNameContainerFigure, BorderLayout.TOP);
			// change layout
			ToolbarLayout layout = new ToolbarLayout(false);
			layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			fFigureLifelineNameContainerFigure.setLayoutManager(layout);

			// remove label creation (created by parent figure)
			//			fFigureLifelineLabelFigure = new WrappingLabel();
			//
			//
			//
			//
			//			fFigureLifelineLabelFigure.setText("<...>");
			//
			//
			//
			//
			//			fFigureLifelineLabelFigure.setTextWrap(true);
			//
			//
			//
			//
			//			fFigureLifelineLabelFigure.setAlignment(PositionConstants.CENTER);
			//
			//
			//
			//			fFigureLifelineNameContainerFigure.add(fFigureLifelineLabelFigure);

			fFigureExecutionsContainerFigure = new RectangleFigure();
			fFigureExecutionsContainerFigure.setFill(false);
			fFigureExecutionsContainerFigure.setOutline(false);
			fFigureExecutionsContainerFigure.setLineWidth(1);

			this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);
			fFigureExecutionsContainerFigure.setLayoutManager(new StackLayout());

			fFigureLifelineDotLineFigure = new LifelineDotLineCustomFigure();

			fFigureExecutionsContainerFigure.add(fFigureLifelineDotLineFigure);

		}

		/**
		 * @generated NOT get label from super figure
		 */
		public WrappingLabel getFigureLifelineLabelFigure() {
			return getNameLabel();
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureLifelineNameContainerFigure() {
			return fFigureLifelineNameContainerFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureExecutionsContainerFigure() {
			return fFigureExecutionsContainerFigure;
		}

		/**
		 * @generated
		 */
		public LifelineDotLineCustomFigure getFigureLifelineDotLineFigure() {
			return fFigureLifelineDotLineFigure;
		}
		
		public boolean containsPoint(int x, int y) {
			boolean contains = super.containsPoint(x, y);
			if (!contains) {
				return false;
			}
			if (fFigureLifelineNameContainerFigure != null
					&& fFigureLifelineNameContainerFigure.containsPoint(x, y)) {
				return true;
			} else if (fFigureLifelineDotLineFigure != null) {
				Rectangle bounds = fFigureLifelineDotLineFigure
						.getDashLineRectangle().getBounds().getCopy();
				bounds.expand(4, 0);
				if (bounds.contains(x, y))
					return true;
			}

			return isChildLifelineSelected(x,y);
		}
		
		@Override
		public void setLineWidth(int w) {		
			if(w < 0)
				return;
			super.setLineWidth(w);
			fFigureLifelineNameContainerFigure.setLineWidth(w);
			fFigureLifelineDotLineFigure.setLineWidth(w);
		}
		
		@Override
		public void setShadow(boolean shadow) {
			if(!shadow)
				fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));
			else{
				RectangularShadowBorder b = new RectangularShadowBorder(3, getForegroundColor()){
					@Override
					public Insets getInsets(IFigure figure) {
						Insets insetsNew = new Insets(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7));
						insetsNew.bottom = MapModeUtil.getMapMode(figure).DPtoLP(insetsNew.bottom + 3);
						insetsNew.right = MapModeUtil.getMapMode(figure).DPtoLP(insetsNew.right + 3);
						return insetsNew;
					}
				};
				fFigureLifelineNameContainerFigure.setBorder(b);
			}
		}
	}

	private boolean isChildLifelineSelected(int x, int y){
		if (inlineMode) {
			List parts = getChildren();
			for(Object p : parts)
				if(p instanceof LifelineEditPart) {
					LifelineEditPart child = (LifelineEditPart)p;
					IFigure fig = child.getFigure();
					if(fig.containsPoint(x, y))
						return true;
				}
		}
		return false;
	}
	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;

		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Lifeline", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}

		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}

	/**
	 * This operation returns the ExecutionSpecification EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @return the list of ExecutionSpecification EditParts
	 */
	public List<ShapeNodeEditPart> getChildShapeNodeEditPart() {
		List<ShapeNodeEditPart> executionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		for(Object obj : getChildren()) {
			if(obj instanceof BehaviorExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			} else if(obj instanceof ActionExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			} else if(obj instanceof CombinedFragment2EditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			}
		}
		return executionSpecificationList;
	}

	/**
	 * This operation returns the InnerConnectableElement EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @return the list of InnerConnectableElement EditParts
	 */
	public List<LifelineEditPart> getInnerConnectableElementList() {
		List<LifelineEditPart> propertyList = new ArrayList<LifelineEditPart>();
		for(Object obj : getChildren()) {
			if(obj instanceof LifelineEditPart) {
				propertyList.add((LifelineEditPart)obj);
			}
		}
		return propertyList;
	}

	/**
	 * Handle lifeline covered by and destruction event
	 * 
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();

		if(UMLPackage.eINSTANCE.getLifeline_CoveredBy().equals(feature)) {
			// Handle coveredBy attribute
			Object newValue = notification.getNewValue();
			if(notification.getOldValue() instanceof MessageOccurrenceSpecification) {
				notifier.unlistenObject((Notifier)notification.getOldValue());
				if(newValue == null) {
					//updateCrossEnd();
				}
			}
			if(newValue instanceof MessageOccurrenceSpecification) {
				MessageOccurrenceSpecification newMessageOccurrenceSpecification = (MessageOccurrenceSpecification)newValue;
				notifier.listenObject(newMessageOccurrenceSpecification);
				//				if(newMessageOccurrenceSpecification.getEvent() instanceof DestructionEvent) {
				//					getPrimaryShape().getFigureLifelineDotLineFigure().setCrossAtEnd(true);
				//					getPrimaryShape().repaint();
				//				}
			}
		} else if(UMLPackage.eINSTANCE.getOccurrenceSpecification().equals(feature)) {
			//			// Handle destruction event
			//			Object newValue = notification.getNewValue();
			//			if(notification.getOldValue() instanceof DestructionEvent && newValue instanceof DestructionEvent == false) {
			//				//updateCrossEnd();
			//			}
			//			if(newValue instanceof DestructionEvent) {
			//				getPrimaryShape().getFigureLifelineDotLineFigure().setCrossAtEnd(true);
			//				getPrimaryShape().repaint();
			//			}
		}
		super.handleNotificationEvent(notification);
		// fixed bug (id=364711) when bounds changed update coveredBys with the
		// figure's bounds.
		if (notification.getNotifier() instanceof Bounds) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					LifelineCoveredByUpdater updater = new LifelineCoveredByUpdater(); 
					updater.update(LifelineEditPart.this);
				}
			});
		}
	}


	/**
	 * Update the rectangle bounds.
	 * In case of a creation, the lifeline width and height will be 0. Get the preferred size
	 * In case of a move, when the lifeline has not be resize, the width or height may be set to -1. Get the according figure bounds.
	 * 
	 * @param rect
	 *        the rectangle to update
	 */
	private void updateRectangleBounds(Rectangle rect) {

		// When moving the lifeline
		if(rect.width == -1) {
			rect.width = getFigure().getBounds().width;
		}
		if(rect.height == -1) {
			rect.height = getFigure().getBounds().height;
		}
		if(rect.x == -1) {
			rect.x = getFigure().getBounds().x;
		}
		if(rect.y == -1) {
			rect.y = getFigure().getBounds().y;
		}

		// When creating the lifeline
		if(rect.width == 0) {
			rect.width = getFigure().getPreferredSize().width;
		}
		if(rect.height == 0) {
			rect.height = getFigure().getPreferredSize().height;
		}
	}

	/**
	 * set the bounds of the lifeline.
	 * 
	 * @param rect
	 *        the rectangle corresponding to the bounds.
	 */
	public void updateLifelineBounds(final Rectangle rect) {

		final Bounds bounds = getBounds();
		if(bounds != null) {
			AbstractCommand cmd = new AbstractCommand() {

				/**
				 * {@inheritDoc}
				 */
				public boolean canExecute() {
					return true;
				}

				/**
				 * {@inheritDoc}
				 */
				public void execute() {
					bounds.setX(rect.x);
					bounds.setY(rect.y);
					bounds.setWidth(rect.width);
					bounds.setHeight(rect.height);
				}

				/**
				 * {@inheritDoc}
				 */
				public void redo() {
					execute();
				}

				/**
				 * This command is undoable.
				 */
				@Override
				public boolean canUndo() {
					return false;
				}
			};

			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), cmd, true);

		}
	}

	private Bounds getBounds() {
		if(getModel() instanceof Node) {
			Node node = (Node)getModel();
			if(node.getLayoutConstraint() instanceof Bounds) {
				return (Bounds)node.getLayoutConstraint();
			}
		}
		return null;
	}

	private int oldNameContainerHeight = 0;

	/**
	 * This method automatically moves a lifeline according to the change of the size of the name and stereotypes container.
	 * This avoids the move of the dash line and its ES.
	 */
	public void updateLifelinePosition() {
		Bounds bounds = getBounds();
		if(bounds != null) {
			Rectangle rect = new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());

			// retrieve the real bounds in updatedRect because we need the real width
			Rectangle updatedRect = rect.getCopy();
			updateRectangleBounds(updatedRect);

			/*
			// use the real width to compute the preferred height which will be used during the layout
			int newNameContainerHeight = getPrimaryShape().getNameContainerPreferredHeight(updatedRect.width); //fix width would cause height expand

			if(oldNameContainerHeight != newNameContainerHeight) {

				if(oldNameContainerHeight != 0) {
					int heightDiff = oldNameContainerHeight - newNameContainerHeight;

					if(rect.height != -1) {
						rect.height -= heightDiff;
					}
					//adjust height offset
					if(!(this.getParent() instanceof LifelineEditPart))
						rect.y += heightDiff;
					updateLifelineBounds(rect);
				}

				oldNameContainerHeight = newNameContainerHeight;
			}
			*/
			Dimension size = getPrimaryShape().getFigureLifelineNameContainerFigure().getPreferredSize(-1, oldNameContainerHeight);
			if(!LifelineResizeHelper.isManualSize(this)){
				if(size.width != rect.width){ 
					moveExecutionParts(new Dimension(size.width - rect.width, 0)); 
					rect.width = size.width;
					updateLifelineBounds(rect);
				}
			}					
		}
	}
	
	protected void moveExecutionParts(Dimension sizeDelta) {
		{
			Rectangle leftMostExecution = null;
			List<ShapeNodeEditPart> childShapeNodeEditPart = this.getChildShapeNodeEditPart();
			for(ShapeNodeEditPart executionSpecificationEP : childShapeNodeEditPart) {
				if(executionSpecificationEP.resolveSemanticElement() instanceof ExecutionSpecification) {
					Rectangle bounds = executionSpecificationEP.getFigure().getBounds();
					Point point = bounds.getLocation();
					if(leftMostExecution == null || leftMostExecution.x > point.x )
						leftMostExecution = bounds;
				}
			}
			if(leftMostExecution == null)
				return;
			
			Rectangle dotLineBounds = this.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();
			int targetX = (int) (dotLineBounds.x + Math.round((dotLineBounds.width - leftMostExecution.width) /2.0 ) );
			sizeDelta.width += (targetX - leftMostExecution.x); // adjust width to keep execution in center line
		}
		
		{ // move all executions
			ChangeBoundsRequest request = new ChangeBoundsRequest();
			request.setMoveDelta(new Point(0, 0));
			request.setSizeDelta(sizeDelta);
			request.setEditParts(this);
			Point loc = this.getFigure().getBounds().getTopRight().getCopy();
			this.getFigure().translateToAbsolute(loc);
			request.setLocation(loc);
			request.setType(RequestConstants.REQ_MOVE_CHILDREN);
			
			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Move or Resize");
			InteractionCompartmentXYLayoutEditPolicy.addLifelineResizeChildrenCommand(compoundCmd, request, (LifelineEditPart)this, 1);
			
			if(compoundCmd.canExecute())
				CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new GEFtoEMFCommandWrapper(compoundCmd.unwrap()), true);
		}
	}

	/**
	 * Overrides to return the DashLineFigure instead of this figure. This is necessary for the
	 * connections anchor.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getNodeFigure()
	 */
	@Override
	public NodeFigure getNodeFigure() {
		return getDashLineFigure();
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	public void setBackgroundColor(Color c) {
		getPrimaryShape().getFigureLifelineNameContainerFigure().setFill(true);
		super.setBackgroundColor(c);	
	}

	@Override
	protected void setGradient(GradientData gradient) {
		getPrimaryShape().getFigureLifelineNameContainerFigure().setFill(false);
		super.setGradient(gradient);
	}
	
	/**
	 * Create specific anchor to handle connection on top, on center and on bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof Message4EditPart) {
			// Create message
			return new LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
		}
		
		if(connEditPart instanceof Message2EditPart){
			String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, false);
			if(terminal.length() > 0){
				int start = terminal.indexOf("{") + 1;
				PrecisionPoint pt = SlidableAnchor.parseTerminalString(terminal);
				boolean rightHand = true;
				if(start > 0){
					if(terminal.charAt(start) == 'L')
						rightHand = false;
				}
				else{
					Connection c = (Connection)connEditPart.getFigure();
					PointList list = c.getPoints();
					if(list.getPoint(0).x > list.getPoint(1).x)
						rightHand = false;
				}
				return new AnchorHelper.SideAnchor(getNodeFigure(), pt, rightHand);	
			}
		}		
		return super.getTargetConnectionAnchor(connEditPart);
	}

	/**
	 * Create specific anchor to handle connection on top, on center and on bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(UMLElementTypes.Message_4006.equals(obj)) {
					return LifelineMessageCreateHelper.getCreateMessageAnchor(this, request, ((CreateUnspecifiedTypeConnectionRequest) request).getLocation().getCopy());
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof Message4EditPart) {
				return LifelineMessageCreateHelper.getCreateMessageAnchor(this, request, ((ReconnectRequest)request).getLocation().getCopy() );
			}
		}

		ConnectionAnchor anchor = super.getTargetConnectionAnchor(request);
		if(anchor instanceof SlidableAnchor) {
			return createSideAnchor(request, (SlidableAnchor)anchor);
		}
		return anchor;
	}

	protected ConnectionAnchor createSideAnchor(Request request, SlidableAnchor sa) {
		Point loc = AnchorHelper.getRequestLocation(request);
		PrecisionPoint pt = SlidableAnchor.parseTerminalString(	sa.getTerminal());
		if(loc == null || pt == null)
			return sa;
		
		IFigure fig = this.getDashLineFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);
		boolean rightHand = true;
		if(loc.x < bounds.getCenter().x)
			rightHand = false;
		return new AnchorHelper.SideAnchor(getNodeFigure(), pt, rightHand);
	}
	

	/**
	 * Create the dashLine figure
	 */
	private NodeFigure getDashLineFigure() {
		NodeFigure centerFigure = null;
		if(getContentPane() instanceof LifelineDotLineCustomFigure) {
			centerFigure = ((LifelineDotLineCustomFigure)getContentPane()).getDashLineRectangle();
		}
		return centerFigure;
	}

	public InteractionInteractionCompartmentEditPart getParentInteractionCompartmentEditPart(){
		EditPart part = this;
		do{
			part = part.getParent();
		}while(part != null && !(part instanceof InteractionInteractionCompartmentEditPart));
		return (InteractionInteractionCompartmentEditPart) part;
	}
	
	public boolean ignoreRequest(Request request) {  // moving editpart causing to add child
		if(request instanceof ChangeBoundsRequest && (request.getType().equals(RequestConstants.REQ_ADD) || request.getType().equals(RequestConstants.REQ_DROP))){
			List parts = ((ChangeBoundsRequest) request).getEditParts();
			if(parts != null){
				for(Object obj : parts)
					if(obj instanceof CommentEditPart || obj instanceof ConstraintEditPart || obj instanceof TimeObservationEditPart || obj instanceof CombinedFragmentEditPart){
						return true;
					}
			}
		}
		
		return false;
	}
	
	public void showTargetFeedback(Request request) {
		 if(ignoreRequest(request)) {
           return;
       }
	        
       super.showTargetFeedback(request);
	}
		
	/**
	 * Handle message creation for execution specification
	 */
	@Override
	public Command getCommand(Request request) {
		if(ignoreRequest(request))  
			return null;
		
		if(request instanceof DropObjectsRequest){  // drop from model explorer
			DropObjectsRequest dropRequest = (DropObjectsRequest) request;
			if (dropRequest.getObjects().size() > 0 ){
				Object obj = dropRequest.getObjects().get(0);
				if(obj instanceof Comment || obj instanceof Constraint || obj instanceof TimeObservation) {
					InteractionInteractionCompartmentEditPart part = getParentInteractionCompartmentEditPart();
					if(part != null)
						return part.getCommand(request);
				}
			}
		}
		
		if(request instanceof CreateConnectionRequest) {
			CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest)request;
			EditPart target = createConnectionRequest.getTargetEditPart();
			if(target instanceof LifelineEditPart) {
				LifelineEditPart lifelineEditPart = (LifelineEditPart)target;
				Rectangle lifelineBounds = lifelineEditPart.getContentPane().getBounds();
				for(ShapeNodeEditPart executionSpecificationEditPart : lifelineEditPart.getChildShapeNodeEditPart()) {
					IFigure executionSpecificationFigure = executionSpecificationEditPart.getFigure();
					Rectangle esBounds = executionSpecificationFigure.getBounds().getCopy();
					esBounds.x = lifelineBounds.x;
					esBounds.width = lifelineBounds.width;
					if(createConnectionRequest.getLocation() != null) {
						Point location = createConnectionRequest.getLocation().getCopy();
						executionSpecificationFigure.translateToRelative(location);
						if(esBounds.contains(location)) {
							createConnectionRequest.setTargetEditPart(executionSpecificationEditPart);
							return executionSpecificationEditPart.getCommand(request);
						}
					}
				}
			} else {
				return target.getCommand(request);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Activate listeners for Lifeline to handle notification in the message occurence specification
	 */
	@Override
	public void activate() {
		//updateCrossEnd();
		super.activate();
	}

	/**
	 * Desactivate listeners for Lifeline to handle notification in the message occurence
	 * specification
	 */
	@Override
	public void deactivate() {
		notifier.unlistenAll();
		super.deactivate();
	}

	/**
	 * Remove listeners for Lifeline to handle notification in the message occurence specification
	 */
	@Override
	public void removeNotify() {
		notifier.unlistenAll();
		super.removeNotify();
	}

	/**
	 * Configure inline mode
	 */
	@Override
	protected void refreshChildren() {
		super.refreshChildren();
		configure(isInlineMode(), true);
	}

	@Override
	public void refresh() {
		configure(isInlineMode(), false);
		super.refresh();
	}

	/**
	 * Determine inline capability
	 * 
	 * @return True if inline mode is possible
	 */
	public boolean isInlineCapability() {
		List<Property> properties = getAvailableProperties();
		if(properties != null && !properties.isEmpty()) {
			return inlineMode || getChildren().size() < 2;
		}

		return false;
	}

	/**
	 * Get the inline mode
	 * 
	 * @return True if the lifeline is in inline mode and if there are properties, else false
	 */
	public boolean isInlineMode() {
		//		for(Object o : getChildren()) {
		//			if(o instanceof LifelineEditPart) {
		//				return true;
		//			}
		//		}
		List models = getModelChildren();
		for (Object o : models)
			if(o instanceof View) {
				View view = (View) o;
				if (UMLVisualIDRegistry.getVisualID(view.getType()) == LifelineEditPart.VISUAL_ID && view.getElement() instanceof Lifeline)
					return true;
			}

		return false;
	}

	/**
	 * Configure the lifeline
	 * 
	 * @param inlineMode
	 *        True if the lifeline is in inline mode
	 */
	private void configure(boolean inlineMode, boolean refresh) {
		(getPrimaryShape().getFigureLifelineDotLineFigure()).configure(inlineMode, getInnerConnectableElementList().size());
		if (this.inlineMode != inlineMode) {
			this.inlineMode = inlineMode;
			if (inlineMode) {
				installEditPolicy(EditPolicy.LAYOUT_ROLE, inlineModeLayoutRole);
				removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);
			} else {
				installEditPolicy(EditPolicy.LAYOUT_ROLE, normalModeLayoutRole);
				installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, dragDropEditPolicy);
			}
			if (refresh)
				refreshVisuals();
		}
	}

	/**
	 * Return the inner ConnectableElements of the lifeline
	 * 
	 * @return inner ConnectableElements
	 */
	public List<Property> getProperties() {
		Lifeline lifeline = (Lifeline)resolveSemanticElement();
		return getProperties(lifeline);
	}

	/**
	 * Get available properties
	 * 
	 * @return Only not already used properties
	 */
	public List<Property> getAvailableProperties() {
		List<Property> properties = getProperties();
		if(properties != null) {
			for(EditPart editPart : (List<EditPart>)getChildren()) {
				if(editPart instanceof LifelineEditPart) {
					Lifeline lifeline = (Lifeline)((LifelineEditPart)editPart).resolveSemanticElement();
					ConnectableElement represents = lifeline.getRepresents();
					if(properties.contains(represents)) {
						properties.remove(represents);
					}
				}
			}
		}
		return properties;
	}

	/**
	 * Return the inner ConnectableElements of the lifeline
	 * 
	 * @param lifeline
	 *        The lifeline
	 * @return inner ConnectableElements
	 */
	// TODO Extract in a helper
	public static List<Property> getProperties(Lifeline lifeline) {
		if(lifeline != null) {
			ConnectableElement represents = lifeline.getRepresents();
			if(represents != null) {
				Type type = represents.getType();
				if(type instanceof StructuredClassifier) {
					StructuredClassifier structuredClassifier = (StructuredClassifier)type;

					if(!structuredClassifier.getAllAttributes().isEmpty()) {
						return new ArrayList<Property>(((StructuredClassifier)type).getAllAttributes());
					}
				}
			}
		}

		return null;
	}
	
	public static class PreserveAnchorsPositionCommandEx extends PreserveAnchorsPositionCommand{

		public PreserveAnchorsPositionCommandEx(ShapeNodeEditPart shapeEP, Dimension sizeDelta, int preserveAxis) {
			super(shapeEP, sizeDelta, preserveAxis);
		}

		public PreserveAnchorsPositionCommandEx(ShapeNodeEditPart shapeEP, Dimension sizeDelta, int preserveAxis, IFigure figure, int resizeDirection) {
			super(shapeEP, sizeDelta, preserveAxis, figure, resizeDirection);
		}

		@Override
		protected String getNewIdStr(IdentityAnchor anchor) {
			String res = super.getNewIdStr(anchor);
			String id = anchor.getId();
			int start = id.indexOf('{');
			if(start > 0)
				res = res + id.substring(start);
			
			return res;
		}
	}
}
