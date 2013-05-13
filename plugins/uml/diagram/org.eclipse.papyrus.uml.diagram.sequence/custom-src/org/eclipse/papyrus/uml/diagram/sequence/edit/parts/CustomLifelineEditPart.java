/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.uml.diagram.common.draw2d.anchors.LifelineAnchor;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomStateInvariantEditPart.StateInvariantLocator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionCompartmentXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomLifelineItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.locator.TimeMarkElementPositionLocator;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineCoveredByUpdater;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineEditPartUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineMessageCreateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineModelChildrenHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineResizeHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomLifelineEditPart extends LifelineEditPart {

	public class CustomLifelineFigure extends LifelineFigure {

		/**
		 * Constructor.
		 * 
		 */
		public CustomLifelineFigure() {
		}

		@Override
		protected IMapMode getMapMode() {
			return CustomLifelineEditPart.this.getMapMode();
		}

		public boolean containsPoint(int x, int y) {
			boolean contains = super.containsPoint(x, y);
			if(!contains) {
				return false;
			}
			//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=395462
			//If is inline mode, just return true, otherwise the child lifeline cannot be moved.
			if(isInlineMode()) {
				return true;
			}
			if(fFigureLifelineNameContainerFigure != null && fFigureLifelineNameContainerFigure.containsPoint(x, y)) {
				return true;
			} else if(!isInlineMode() && fFigureLifelineDotLineFigure != null) {
				Rectangle bounds = fFigureLifelineDotLineFigure.getDashLineRectangle().getBounds().getCopy();
				bounds.expand(4, 0);
				if(bounds.contains(x, y))
					return true;
			}
			return containsChildFigure(this, x, y);
		}

		@Override
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			IFigure figure = super.findFigureAt(x, y, search);
			if(figure == null) {
				return null;
			}
			// 1. First check if the location is enter the Title.
			if(fFigureLifelineNameContainerFigure != null && fFigureLifelineNameContainerFigure.containsPoint(x, y)) {
				// Return label figure for supporting direct edit.
				EditPart editPart = (EditPart)getViewer().getVisualPartMap().get(figure);
				while(editPart == null) {
					figure = figure.getParent();
					if(figure == null) {
						break;
					}
					editPart = (EditPart)getViewer().getVisualPartMap().get(figure);
				}
				return figure == null ? this : figure;
			}
			//2. Check children, maybe contain the Label figure, but we process it before.
			IFigure child = findChildFigure(this, x, y);
			if(child != null) {
				return child;
			}
			//3. Finally check the line.
			if(!isInlineMode() && fFigureLifelineDotLineFigure != null) {
				Rectangle bounds = fFigureLifelineDotLineFigure.getDashLineRectangle().getBounds().getCopy();
				bounds.expand(4, 0);
				if(bounds.contains(x, y))
					return this;
			}
			return null;
		}

		@Override
		public Dimension getMinimumSize(int wHint, int hHint) {
			if(minSize != null && minSize.height < 0) {
				//Make sure Lifeline can be expanded vertically by itself.
				int height = minSize.height;
				if(getLayoutManager() != null) {
					Dimension d = getLayoutManager().getMinimumSize(this, wHint, hHint);
					if(d != null) {
						height = Math.max(height, d.height);
					}
				} else {
					Dimension d = getPreferredSize(wHint, hHint);
					if(d != null) {
						height = Math.max(height, d.height);
					}
				}
				return new Dimension(minSize.width, getMinimumHeight(height));
			}
			return super.getMinimumSize(wHint, hHint);
		}
	}

	public static class PreserveAnchorsPositionCommandEx extends PreserveAnchorsPositionCommand {

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

	/**
	 * True if the lifeline is in inline mode
	 */
	private boolean inlineMode;

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifier = null;

	/**
	 * Layout role for inline mode
	 */
	private LayoutEditPolicy inlineModeLayoutRole = createLayoutEditPolicy();

	/**
	 * Layout role for normal mode
	 */
	private LayoutEditPolicy normalModeLayoutRole = new LifelineXYLayoutEditPolicy();

	/**
	 * Layout role for drag drop
	 */
	private DragDropEditPolicy dragDropEditPolicy = new DragDropEditPolicy();

	private int oldNameContainerHeight = 0;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomLifelineEditPart(View view) {
		super(view);
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
	 * @Override (update at each lifeline modification) update the locator with edit part reference
	 */
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		//Affixed locator for Lifelines to place element with a time bar
		if(childEditPart instanceof TimeConstraintEditPart) {
			// update the locator with edit part reference
			TimeMarkElementPositionLocator locator = new TimeMarkElementPositionLocator(getMainFigure(), PositionConstants.NONE);
			locator.setEditPart(childEditPart);
			getBorderedFigure().getBorderItemContainer().add(((TimeConstraintEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		if(childEditPart instanceof TimeObservationEditPart) {
			// update the locator with edit part reference
			TimeMarkElementPositionLocator locator = new TimeMarkElementPositionLocator(getMainFigure(), PositionConstants.NONE);
			locator.setEditPart(childEditPart);
			getBorderedFigure().getBorderItemContainer().add(((TimeObservationEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		if(childEditPart instanceof DurationConstraintEditPart) {
			// update the locator with edit part reference
			TimeMarkElementPositionLocator locator = new TimeMarkElementPositionLocator(getMainFigure(), PositionConstants.NONE);
			locator.setEditPart(childEditPart);
			getBorderedFigure().getBorderItemContainer().add(((DurationConstraintEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		if(childEditPart instanceof StateInvariantEditPart) {
			IBorderItemLocator locator = new StateInvariantLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((StateInvariantEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	/**
	 * Configure the lifeline
	 * 
	 * @param inlineMode
	 *        True if the lifeline is in inline mode
	 */
	private void configure(boolean inlineMode, boolean refresh) {
		(getPrimaryShape().getFigureLifelineDotLineFigure()).configure(inlineMode, LifelineEditPartUtil.getInnerConnectableElementList(this).size());
		if(this.inlineMode != inlineMode) {
			this.inlineMode = inlineMode;
			if(inlineMode) {
				installEditPolicy(EditPolicy.LAYOUT_ROLE, inlineModeLayoutRole);
				removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);
			} else {
				installEditPolicy(EditPolicy.LAYOUT_ROLE, normalModeLayoutRole);
				installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, dragDropEditPolicy);
			}
			if(refresh) {
				refreshVisuals();
			}
		}
	}

	/**
	 * Check if the IFigure contains point, only check visible figures.
	 * 
	 * @param parent
	 * @param x
	 * @param y
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private boolean containsChildFigure(IFigure parent, int x, int y) {
		if(parent == null) {
			return false;
		}
		Map visualPartMap = getViewer().getVisualPartMap();
		List figures = parent.getChildren();
		Point pt = new Point(x, y);
		parent.translateFromParent(pt);
		IFigure child;
		for(int i = figures.size(); i > 0;) {
			i--;
			child = (IFigure)figures.get(i);
			if(!child.isVisible()) {
				continue;
			}
			if(containsChildFigure(child, pt.x, pt.y)) {
				return true;
			}
			if(visualPartMap.containsKey(child)) {
				if(child.containsPoint(pt)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomLifelineItemSemanticEditPolicy());
		//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=364608
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LifelineSelectionEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new LifelineMessageCreateHelper.ComponentEditPolicyEx());
		// custom label, fix bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=383722
		installEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY, new LifelineLabelEditPolicy());
	}

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

			@Override
			protected Command getOrphanChildrenCommand(Request request) {
				//Disable orphan children command.
				//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=395462
				return UnexecutableCommand.INSTANCE;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				if(request instanceof ChangeBoundsRequest)
					return getMoveResizeCommand((ChangeBoundsRequest)request);
				return null;
			}

			private Command getMoveResizeCommand(ChangeBoundsRequest request) {
				List changeEditParts = request.getEditParts();
				if(changeEditParts != null && changeEditParts.size() > 0) {
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
					CompositeTransactionalCommand composite = new CompositeTransactionalCommand(editingDomain, null);
					LifelineEditPart parent = (LifelineEditPart)this.getHost();
					LifelineDotLineCustomFigure parentFig = (LifelineDotLineCustomFigure)parent.getContentPane();
					Rectangle parentBounds = parentFig.getBounds();
					for(Object o : changeEditParts) {
						if(o instanceof LifelineEditPart) {
							LifelineEditPart child = (LifelineEditPart)o;
							IFigure childFig = child.getFigure();
							Rectangle newBounds = childFig.getBounds().getCopy();
							Rectangle childConstraint = (Rectangle)parentFig.getLayoutManager().getConstraint(childFig);
							newBounds.setLocation(childConstraint.getLocation().getCopy());
							newBounds.translate(request.getMoveDelta());
							if(!request.getType().equals(RequestConstants.REQ_MOVE_CHILDREN)) {
								newBounds.resize(request.getSizeDelta());
							}
							// do not excceed parent
							if(newBounds.x < 0) {
								newBounds.width += newBounds.x;
								newBounds.x = 0;
							}
							if(newBounds.x + newBounds.width > parentBounds.width) {
								newBounds.width = parentBounds.width - newBounds.x;
							}
							ICommand boundsCommand = new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter((View)child.getModel()), newBounds);
							composite.add(boundsCommand);
							composite.add(LifelineResizeHelper.createManualLabelSizeCommand((LifelineEditPart)child));
							//Move ExecutionSpecifications
							//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=395462
							if(!request.getType().equals(REQ_MOVE_CHILDREN)) {
								CompoundCommand resizeChildrenCommand = new CompoundCommand();
								InteractionCompartmentXYLayoutEditPolicy.addLifelineResizeChildrenCommand(resizeChildrenCommand, request, child, 1);
								//If no child, just ignore it. Fixed bug about Resizing child lifeline: 
								Command cmd = resizeChildrenCommand.isEmpty() ? null : resizeChildrenCommand.unwrap();
								if(cmd != null) {
									composite.add(new CommandProxy(cmd));
								}
							}
						}
					}
					return new ICommandProxy(composite.reduce());
				}
				return null;
			}
		};
		return lep;
	}

	@Override
	protected NodeFigure createNodeFigure() {
		return new BorderedNodeFigure(createMainFigure()) {

			@Override
			public boolean containsPoint(int x, int y) {
				if(getBounds().contains(x, y)) {
					return true;
				}
				return super.containsPoint(x, y);
			}

			/**
			 * Reverse the find order from super, otherwise the child executions would hard to select.
			 */
			@Override
			public IFigure findFigureAt(int x, int y, TreeSearch search) {
				if(search.prune(this)) {
					return null;
				}
				IFigure mainFigure = getMainFigure().findFigureAt(x, y, search);
				if(mainFigure != null) {
					return mainFigure;
				}
				return getBorderItemContainer().findFigureAt(x, y, search);
			}

			@Override
			public void setBackgroundColor(Color bg) {
				//				if (getPrimaryShape() != null) {
				//					NodeFigure dashLineRectangle = getPrimaryShape().getFigureLifelineDotLineFigure().getDashLineRectangle();
				//					dashLineRectangle.setBackgroundColor(bg);
				//				}
			}

			@Override
			public void setOpaque(boolean opaque) {
				if(getPrimaryShape() != null) {
					NodeFigure dashLineRectangle = getPrimaryShape().getFigureLifelineDotLineFigure().getDashLineRectangle();
					dashLineRectangle.setOpaque(opaque);
				}
			}
		};
	}

	/**
	 * Overrides to disable the defaultAnchorArea. The edge is now more stuck with the middle of the
	 * figure.
	 * 
	 * @Override
	 */
	@Override
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new LifelineDotLineCustomFigure.DefaultSizeNodeFigureEx(100, 250) {

			@Override
			public boolean containsPoint(int x, int y) {
				if(primaryShape != null) {
					return primaryShape.containsPoint(x, y);
				}
				return super.containsPoint(x, y);
			}

			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}
		};
		return result;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart#createNodeShape()
	 * 
	 * @return
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new CustomLifelineFigure();
	}

	protected ConnectionAnchor createSideAnchor(Request request, SlidableAnchor sa) {
		Point loc = AnchorHelper.getRequestLocation(request);
		PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(sa.getTerminal());
		if(loc == null || pt == null) {
			return sa;
		}
		IFigure fig = this.getDashLineFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);
		boolean rightHand = true;
		if(loc.x < bounds.getCenter().x) {
			rightHand = false;
		}
		return new AnchorHelper.SideAnchor(getNodeFigure(), pt, rightHand);
	}

	/**
	 * Desactivate listeners for Lifeline to handle notification in the message occurence
	 * specification
	 */
	@Override
	public void deactivate() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.deactivate();
	}

	/**
	 * Do NOT care the mode, we just want to check if there are children in
	 * given location.
	 */
	@SuppressWarnings("rawtypes")
	private IFigure findChildFigure(IFigure parent, int x, int y) {
		if(parent == null) {
			return null;
		}
		Map visualPartMap = getViewer().getVisualPartMap();
		List figures = parent.getChildren();
		Point pt = new Point(x, y);
		parent.translateFromParent(pt);
		IFigure child;
		for(int i = figures.size(); i > 0;) {
			i--;
			child = (IFigure)figures.get(i);
			if(!child.isVisible()) {
				continue;
			}
			IFigure fig = findChildFigure(child, pt.x, pt.y);
			if(fig != null) {
				return fig;
			}
			if(visualPartMap.containsKey(child)) {
				if(child.containsPoint(pt)) {
					return child;
				}
			}
		}
		return null;
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

	private Bounds getBounds() {
		if(getModel() instanceof Node) {
			Node node = (Node)getModel();
			if(node.getLayoutConstraint() instanceof Bounds) {
				return (Bounds)node.getLayoutConstraint();
			}
		}
		return null;
	}

	/**
	 * Handle message creation for execution specification
	 */
	public Command getCommand(Request request) {
		if(ignoreRequest(request)) {
			return null;
		}
		if(request instanceof DropObjectsRequest) { // drop from model explorer
			DropObjectsRequest dropRequest = (DropObjectsRequest)request;
			if(dropRequest.getObjects().size() > 0) {
				Object obj = dropRequest.getObjects().get(0);
				if(obj instanceof Comment || obj instanceof Constraint || obj instanceof TimeObservation) {
					InteractionInteractionCompartmentEditPart part = getParentInteractionCompartmentEditPart();
					if(part != null) {
						return part.getCommand(request);
					}
				}
			}
		}
		if(request instanceof CreateConnectionRequest) {
			CreateConnectionRequest createConnectionRequest = (CreateConnectionRequest)request;
			EditPart target = createConnectionRequest.getTargetEditPart();
			if(target instanceof CustomLifelineEditPart) {
				CustomLifelineEditPart lifelineEditPart = (CustomLifelineEditPart)target;
				Rectangle lifelineBounds = lifelineEditPart.getContentPane().getBounds();
				for(ShapeNodeEditPart executionSpecificationEditPart : LifelineEditPartUtil.getChildShapeNodeEditPart(lifelineEditPart)) {
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
	 * {@inheritDoc}
	 * 
	 * @Override Execution specification handling
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		// Execution specification handling
		if(editPart instanceof AbstractExecutionSpecificationEditPart || editPart instanceof CombinedFragment2EditPart) {
			return getPrimaryShape().getFigureLifelineDotLineFigure();
		}
		return super.getContentPaneFor(editPart);
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

	private int getMinimumHeight(int heightHint) {
		Rectangle rect = getFigure().getBounds().getCopy();
		getFigure().translateToAbsolute(rect);
		Lifeline lifeline = (Lifeline)resolveSemanticElement();
		EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
		int bottom = 0;
		for(InteractionFragment interactionFragment : coveredBys) {
			Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(interactionFragment);
			for(Setting ref : settings) {
				if(!NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
					continue;
				}
				View view = (View)ref.getEObject();
				EditPart part = DiagramEditPartsUtil.getEditPartFromView(view, this);
				if(!(part instanceof GraphicalEditPart)) {
					continue;
				}
				GraphicalEditPart ep = (GraphicalEditPart)part;
				Rectangle r = ep.getFigure().getBounds().getCopy();
				getFigure().translateToAbsolute(r);
				bottom = Math.max(bottom, r.bottom());
			}
		}
		return Math.max(heightHint, bottom - rect.y);
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
	 * Try to use the notifier from super class, if not exist, create new one.
	 */
	protected NotificationHelper getNotifier() {
		if(notifier == null) {
			try {
				Field f = LifelineEditPart.class.getDeclaredField("notifier");
				f.setAccessible(true);
				notifier = (NotificationHelper)f.get(this);
			} catch (Exception e) {
				notifier = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						handleNotificationEvent(msg);
					}
				});
			}
		}
		return notifier;
	}

	public InteractionInteractionCompartmentEditPart getParentInteractionCompartmentEditPart() {
		EditPart part = this;
		do {
			part = part.getParent();
		} while(part != null && !(part instanceof InteractionInteractionCompartmentEditPart));
		return (InteractionInteractionCompartmentEditPart)part;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart#getPrimaryShape()
	 * 
	 * @return
	 */
	@Override
	public CustomLifelineFigure getPrimaryShape() {
		return (CustomLifelineFigure)primaryShape;
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
	 * Create specific anchor to handle connection on top, on center and on bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof Message4EditPart) {
			// Create message
			return new LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
		}
		if(connEditPart instanceof Message2EditPart) {
			String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, false);
			if(terminal.length() > 0) {
				int start = terminal.indexOf("{") + 1;
				PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
				boolean rightHand = true;
				if(start > 0) {
					if(terminal.charAt(start) == 'L') {
						rightHand = false;
					}
				} else {
					Connection c = (Connection)connEditPart.getFigure();
					PointList list = c.getPoints();
					if(list.getPoint(0).x > list.getPoint(1).x) {
						rightHand = false;
					}
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
					return LifelineMessageCreateHelper.getCreateMessageAnchor(this, request, ((CreateUnspecifiedTypeConnectionRequest)request).getLocation().getCopy());
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof Message4EditPart) {
				return LifelineMessageCreateHelper.getCreateMessageAnchor(this, request, ((ReconnectRequest)request).getLocation().getCopy());
			}
		}
		ConnectionAnchor anchor = super.getTargetConnectionAnchor(request);
		if(anchor instanceof SlidableAnchor) {
			return createSideAnchor(request, (SlidableAnchor)anchor);
		}
		return anchor;
	}

	/**
	 * Handle lifeline covered by and destruction event
	 * 
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		final NotificationHelper notifier = getNotifier();
		Object feature = notification.getFeature();
		if(ElementIconUtil.isIconNotification(notification)) {
			updateLifelinePosition();
		}
		EObject element = resolveSemanticElement();
		TransactionalEditingDomain editingDomain = getEditingDomain();
		if(element instanceof Lifeline && !((Lifeline)element).getCoveredBys().isEmpty()) {
			Lifeline lifeline = (Lifeline)element;
			EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
			//if the coveredBy was removed from resource, then make sure them removed from lifeline model.
			if(Notification.REMOVE == notification.getEventType()) {
				Object oldValue = notification.getOldValue();
				if(coveredBys.contains(oldValue)) {
					CommandHelper.executeCommandWithoutHistory(editingDomain, RemoveCommand.create(editingDomain, lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), oldValue), true);
				}
			} else if(Notification.REMOVE_MANY == notification.getEventType()) {
				List oldValue = (List)notification.getOldValue();
				for(Object object : oldValue) {
					if(coveredBys.contains(object)) {
						CommandHelper.executeCommandWithoutHistory(editingDomain, RemoveCommand.create(editingDomain, lifeline, UMLPackage.eINSTANCE.getLifeline_CoveredBy(), object), true);
					}
				}
			}
		}
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
			// Handle removing the coveredBys. 
			if(newValue instanceof InteractionFragment) {
				EObject eContainer = ((InteractionFragment)newValue).eContainer();
				if(eContainer != null) {
					notifier.listenObject(eContainer);
				}
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
		if(notification.getNotifier() instanceof Bounds) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					LifelineCoveredByUpdater updater = new LifelineCoveredByUpdater();
					updater.update(CustomLifelineEditPart.this);
				}
			});
		}
	}

	public boolean ignoreRequest(Request request) { // moving editpart causing to add child
		if(request instanceof ChangeBoundsRequest && (request.getType().equals(org.eclipse.gef.RequestConstants.REQ_ADD) || request.getType().equals(RequestConstants.REQ_DROP))) {
			List parts = ((ChangeBoundsRequest)request).getEditParts();
			if(parts != null) {
				for(Object obj : parts) {
					if(obj instanceof CommentEditPart || obj instanceof ConstraintEditPart || obj instanceof TimeObservationEditPart || obj instanceof CombinedFragmentEditPart) {
						return true;
					}
				}
			}
		}
		return false;
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
		List models = super.getModelChildren();
		for(Object o : models) {
			if(o instanceof View) {
				View view = (View)o;
				if(UMLVisualIDRegistry.getVisualID(view.getType()) == LifelineEditPart.VISUAL_ID && view.getElement() instanceof Lifeline) {
					return true;
				}
			}
		}
		return false;
	}

	protected void moveExecutionParts(Dimension sizeDelta) {
		{
			Rectangle leftMostExecution = null;
			List<ShapeNodeEditPart> childShapeNodeEditPart = LifelineEditPartUtil.getChildShapeNodeEditPart(this);
			for(ShapeNodeEditPart executionSpecificationEP : childShapeNodeEditPart) {
				if(executionSpecificationEP.resolveSemanticElement() instanceof ExecutionSpecification) {
					Rectangle bounds = executionSpecificationEP.getFigure().getBounds();
					Point point = bounds.getLocation();
					if(leftMostExecution == null || leftMostExecution.x > point.x) {
						leftMostExecution = bounds;
					}
				}
			}
			if(leftMostExecution == null) {
				return;
			}
			Rectangle dotLineBounds = this.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();
			int targetX = (int)(dotLineBounds.x + Math.round((dotLineBounds.width - leftMostExecution.width) / 2.0));
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
			request.setType(org.eclipse.gef.RequestConstants.REQ_MOVE_CHILDREN);
			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Move or Resize");
			InteractionCompartmentXYLayoutEditPolicy.addLifelineResizeChildrenCommand(compoundCmd, request, this, 1);
			if(compoundCmd.canExecute()) {
				CommandHelper.executeCommandWithoutHistory(getEditingDomain(), new GEFtoEMFCommandWrapper(compoundCmd.unwrap()), true);
			}
		}
	}

	@Override
	public void refresh() {
		configure(isInlineMode(), false);
		super.refresh();
	}

	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		if(LifelineResizeHelper.isManualSize(this)) {
			LifelineFigure primaryShape = getPrimaryShape();
			//Once the minimum size is set, the main figure will not be expanded by itself.
			primaryShape.setMinimumSize(new Dimension(1, -1));
		}
	}

	/**
	 * Configure inline mode
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void refreshChildren() {
		super.refreshChildren();
		List modelChildren = LifelineModelChildrenHelper.getModelChildren(getPrimaryView());
		IFigure parent = getContentPane();
		List visualChildren = parent.getChildren();
		int index = 0;
		//Fixed bug about z-order of Execution Specifications: reorder figures if needed.
		Map editPartRegistry = getViewer().getEditPartRegistry();
		for(int i = 0; i < modelChildren.size(); i++) {
			Object child = editPartRegistry.get(modelChildren.get(i));
			if(!(child instanceof GraphicalEditPart)) {
				continue;
			}
			IFigure figure = ((GraphicalEditPart)child).getFigure();
			int currentIndex = visualChildren.indexOf(figure);
			if(currentIndex == -1) {
				continue;
			}
			if(currentIndex != index) {
				visualChildren.remove(figure);
				visualChildren.add(index, figure);
			}
			index++;
		}
		configure(isInlineMode(), true);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTransparency();
	}

	/**
	 * Remove listeners for Lifeline to handle notification in the message occurence specification
	 */
	@Override
	public void removeNotify() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.removeNotify();
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

	@Override
	protected void setLineWidth(int width) {
		if(getPrimaryShape() instanceof NodeFigure) {
			((NodeFigure)getPrimaryShape()).setLineWidth(width);
		}
		super.setLineWidth(width);
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @Override Execution specification handling
	 */
	@Override
	protected IFigure setupContentPane(IFigure nodeShape) {
		// Execution specification handling
		if(nodeShape instanceof LifelineFigure) {
			LifelineFigure lFigure = (LifelineFigure)nodeShape;
			return lFigure.getFigureLifelineDotLineFigure();
		}
		return setupContentPane(nodeShape);
	}

	public void showTargetFeedback(Request request) {
		if(ignoreRequest(request)) {
			return;
		}
		super.showTargetFeedback(request);
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
				@Override
				public boolean canExecute() {
					return true;
				}

				/**
				 * This command is undoable.
				 */
				@Override
				public boolean canUndo() {
					return false;
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
			};
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), cmd, true);
		}
	}

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
			 * // use the real width to compute the preferred height which will be used during the layout
			 * int newNameContainerHeight = getPrimaryShape().getNameContainerPreferredHeight(updatedRect.width); //fix width would cause height
			 * expand
			 * 
			 * if(oldNameContainerHeight != newNameContainerHeight) {
			 * 
			 * if(oldNameContainerHeight != 0) {
			 * int heightDiff = oldNameContainerHeight - newNameContainerHeight;
			 * 
			 * if(rect.height != -1) {
			 * rect.height -= heightDiff;
			 * }
			 * //adjust height offset
			 * if(!(this.getParent() instanceof LifelineEditPart))
			 * rect.y += heightDiff;
			 * updateLifelineBounds(rect);
			 * }
			 * 
			 * oldNameContainerHeight = newNameContainerHeight;
			 * }
			 */
			Dimension size = getPrimaryShape().getFigureLifelineNameContainerFigure().getPreferredSize(-1, oldNameContainerHeight);
			if(!LifelineResizeHelper.isManualSize(this)) {
				if(size.width != rect.width) {
					moveExecutionParts(new Dimension(size.width - rect.width, 0));
					rect.width = size.width;
					updateLifelineBounds(rect);
				}
			}
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
}
