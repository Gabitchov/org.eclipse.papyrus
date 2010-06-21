/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.diagram.common.layout.RoutingConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * 
 * This class provides actions to set links vertical or horizontal
 * 
 * This action is cloned from the GMF AlignAction
 * 
 * @see org.eclipse.gmf.runtime.diagram.ui.actions.AlignAction
 */
public class RouteAction extends DiagramAction {

	/** the id for this action */
	private String id;

	/** the routing type */
	private int routing;

	/** indicates if this action is an item of a toolbars */
	private boolean isToolbarItem;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 *        the workbenchPage
	 * @param id
	 *        the id for this action
	 * @param distrib
	 *        the distribution type
	 *        Possible values for distrib are :
	 *        <ul>
	 *        <li> {@linkplain RoutingConstants#DISTRIBUTE_H_CONTAINER_INT}</li>
	 *        <li>{@linkplain RoutingConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        <li>{@linkplain RoutingConstants#DISTRIBUTE_V_CONTAINER_INT}</li>
	 *        <li>{@linkplain RoutingConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        </ul>
	 */
	public RouteAction(IWorkbenchPage workbenchPage, String id, int distrib) {
		this(workbenchPage, id, distrib, true);
	}


	/**
	 * 
	 * Constructor.
	 * 
	 * @param workbenchPage
	 *        the workbenchPage
	 * @param id
	 *        the id for this action
	 * @param distrib
	 *        the distribution type
	 *        Possible values for distrib are :
	 *        <ul>
	 *        <li> {@linkplain RoutingConstants#DISTRIBUTE_H_CONTAINER_INT}</li>
	 *        <li>{@linkplain RoutingConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        <li>{@linkplain RoutingConstants#DISTRIBUTE_V_CONTAINER_INT}</li>
	 *        <li>{@linkplain RoutingConstants#DISTRIBUTE_V_NODES_INT}</li>
	 *        </ul>
	 * @param isToolbarItem
	 *        indicates if this action is an item of a toolbar
	 */
	public RouteAction(IWorkbenchPage workbenchPage, String id, int routing, boolean isToolbarItem) {
		super(workbenchPage);
		this.id = id;
		this.routing = routing;
		this.isToolbarItem = isToolbarItem;
		initUI();
	}

	/**
	 * Initializes the actions UI presentation.
	 * Two sets of each align action are required. One for the toolbar,
	 * and one for other menus. The toolbar action has explicit text,
	 * the other menus do not. For example: Align Left and Left.
	 * 
	 */
	protected void initUI() {

		setId(this.id);
		String text = null;
		String toolTipText = null;

		switch(this.routing) {
		case PositionConstants.LEFT:
		{
			if(isToolbarItem) {//diagram and tool bar
				text = RoutingConstants.RouteHorizontallyByLeft;
				toolTipText = RoutingConstants.RouteHorizontallyByLeftToolTipText;

			} else {//right click
				text = RoutingConstants.RouteHorizontallyByLeftAction;
				toolTipText = RoutingConstants.RouteHorizontallyByLeftToolTipText;
			}
			setImageDescriptor(Activator.getImageDescriptor(RoutingConstants.ICON_SET_HORIZONTAL_BY_LEFT));

			break;
		}
		case PositionConstants.RIGHT:
		{
			if(isToolbarItem) {
				text = RoutingConstants.RouteHorizontallyByRight;
				toolTipText = RoutingConstants.RouteHorizontallyByRightToolTipText;
			} else {
				text = RoutingConstants.RouteHorizontallyByRightAction;
				toolTipText = RoutingConstants.RouteHorizontallyByRightToolTipText;
			}
			setImageDescriptor(Activator.getImageDescriptor(RoutingConstants.ICON_SET_HORIZONTAL_BY_RIGHT));
			break;
		}
		case PositionConstants.TOP:
		{
			if(isToolbarItem) {
				text = RoutingConstants.RouteVerticallyByTop;
				toolTipText = RoutingConstants.RouteVerticallyByTopToolTipText;
			} else {
				text = RoutingConstants.RouteVerticallyByTopAction;
				toolTipText = RoutingConstants.RouteVerticallyByTopToolTipText;
			}
			setImageDescriptor(Activator.getImageDescriptor(RoutingConstants.ICON_SET_VERTICAL_BY_TOP));
			break;
		}
		case PositionConstants.BOTTOM:
		{
			if(isToolbarItem) {
				text = RoutingConstants.RouteVerticallyByBottom;
				toolTipText = RoutingConstants.RouteVerticallyByBottomToolTipText;
			} else {
				text = RoutingConstants.RouteVerticallyByBottomAction;
				toolTipText = RoutingConstants.RouteVerticallyByBottomToolTipText;
			}
			setImageDescriptor(Activator.getImageDescriptor(RoutingConstants.ICON_SET_VERTICAL_BY_BOTTOM));
			break;
		}

		}
		setText(text);
		setToolTipText(toolTipText);
		if(isToolbarItem) {
			setAccelerator();
		}
	}

	/**
	 * Adds the accelerators in the menu message {@link CustomAlignAction#setAccelerator()} seems doesn't work. keyBinding is done with the
	 * org.eclipse.ui.binding extension point
	 */
	protected void setAccelerator() {
		String text = getText();
		switch(this.routing) {
		case PositionConstants.LEFT:
			text += "\t Ctrl+Shift+Arrow Left"; //$NON-NLS-1$
			break;
		case PositionConstants.RIGHT:
			text += "\t Ctrl+Shift+Arrow Right"; //$NON-NLS-1$
			break;
		case PositionConstants.TOP:
			text += "\t Ctrl+Shift+Arrow Up"; //$NON-NLS-1$
			break;
		case PositionConstants.BOTTOM:
			text += "\t Ctrl+Shift+Arrow Down"; //$NON-NLS-1$
			break;
		}


		setText(text);
	}


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 * 
	 * @return
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#isOperationHistoryListener()
	 * 
	 * @return
	 */
	@Override
	protected boolean isOperationHistoryListener() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 * 
	 * @return
	 */
	@Override
	protected Request createTargetRequest() {
		return new ReconnectRequest(RequestConstants.REQ_RECONNECT_SOURCE);//source or target, for us, it's the same!
	}

	/**
	 * Gets a command to execute on the operation set based on a given request
	 * 
	 * @param request
	 *        request to use to get the command
	 * @return a command
	 */
	@Override
	protected Command getCommand(Request request) {
		List editparts = getOperationSet();//all the selected links and only them!
		List<InternalLinkRepresention> links = new ArrayList<RouteAction.InternalLinkRepresention>();
		CompoundCommand command = new CompoundCommand();
		for(Object obj : editparts) {
			InternalLinkRepresention link = new InternalLinkRepresention((ConnectionEditPart)obj);
			Command cmd = link.getCommand();
			if(cmd != UnexecutableCommand.INSTANCE) {
				command.add(cmd);
			}
		}
		return command.canExecute() ? command : UnexecutableCommand.INSTANCE;

	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createOperationSet()
	 * 
	 * @return
	 */
	@Override
	protected List createOperationSet() {
		List selection = getSelectedObjects();
		if(selection.isEmpty() || !(selection.get(0) instanceof IGraphicalEditPart))
			return Collections.EMPTY_LIST;
		Iterator selectedEPs = selection.iterator();
		List targetedEPs = new ArrayList();
		while(selectedEPs.hasNext()) {
			EditPart selectedEP = (EditPart)selectedEPs.next();
			if(selectedEP instanceof ConnectionEditPart) {
				targetedEPs.add(selectedEP);
			}
		}
		return targetedEPs.isEmpty() ? Collections.EMPTY_LIST : targetedEPs;
	}

	/**
	 * 
	 * This class is used to represent a link for this action
	 * 
	 */
	protected class InternalLinkRepresention {

		/** the represented link */
		private ConnectionEditPart link;

		/** the link figure */
		private PolylineConnectionEx linkFigure;

		/** the fixed anchor */
		private Point fixedAnchor;

		/** the editpart owning the fixed anchor */
		private EditPart fixedEP;

		/** the request type's for the fixed anchor */
		private String fixedType;

		/** the moved anchor */
		private Point movedAnchor;

		/** the editpart owning the moved anchor */
		private EditPart movedEP;

		/** the request type's for the moved anchor */
		private String movedType;


		/**
		 * 
		 * Constructor.
		 * 
		 * @param link
		 *        the represented link
		 */
		public InternalLinkRepresention(ConnectionEditPart link) {
			this.link = link;
			init();
		}

		/**
		 * This method initializes the following fields :
		 * <ul>
		 * <li> {@link #linkFigure}</li>
		 * <li> {@link #fixedAnchor}</li>
		 * <li> {@link #fixedEP}</li>
		 * <li> {@link #fixedType}</li>
		 * <li> {@link #movedAnchor}</li>
		 * <li> {@link #movedEP}</li>
		 * <li> {@link #movedType}</li>
		 * <li></li>
		 * 
		 * </ul>
		 */
		protected void init() {
			IFigure fig = ((AbstractConnectionEditPart)link).getFigure();
			Assert.isTrue(fig instanceof PolylineConnectionEx);
			linkFigure = (PolylineConnectionEx)fig;

			Point start = linkFigure.getStart();
			Point end = linkFigure.getEnd();
			linkFigure.translateToAbsolute(start);
			linkFigure.translateToAbsolute(end);

			//determines movedAnchor
			switch(routing) {
			case PositionConstants.LEFT: //the leftmost moves
				if(start.x < end.x) {
					this.movedAnchor = start;
				} else {
					this.movedAnchor = end;
				}
				break;
			case PositionConstants.RIGHT: //the rightmost moves
				if(start.x > end.x) {
					this.movedAnchor = start;
				} else {
					this.movedAnchor = end;
				}
				break;
			case PositionConstants.TOP: //the hightest moves
				if(start.y < end.y) {
					this.movedAnchor = start;
				} else {
					this.movedAnchor = end;
				}
				break;
			case PositionConstants.BOTTOM://the lowert moves
				if(start.y > end.y) {
					this.movedAnchor = start;
				} else {
					this.movedAnchor = end;
				}
				break;
			default:
				break;
			}

			//determines fixedAnchor
			this.fixedAnchor = ((this.movedAnchor == end) ? start : end);

			//detemines fixedEP and movedEP
			if(this.fixedAnchor == start) {
				this.fixedEP = link.getSource();
				this.movedEP = link.getTarget();
				this.movedType = GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET;
				this.fixedType = GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE;

			} else {
				this.fixedEP = link.getTarget();
				this.movedEP = link.getSource();
				this.movedType = GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE;
				this.fixedType = GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET;
			}
		}

		/**
		 * Calculates the shift between the source and the target following the direction of the action.
		 * 
		 * @return
		 *         the shift between the source and the target following the direction of the action.
		 */
		protected Point getDelta() {
			Point delta = new Point();
			if(routing == PositionConstants.LEFT || routing == PositionConstants.RIGHT) {
				delta.setLocation(0, this.fixedAnchor.y - this.movedAnchor.y);
			} else if(routing == PositionConstants.TOP || routing == PositionConstants.BOTTOM) {
				delta.setLocation(this.fixedAnchor.x - this.movedAnchor.x, 0);
			}
			return delta;
		}

		/**
		 * Returns the request to relocate the moved anchor.
		 * 
		 * @return
		 *         The request to locate the moved anchor.
		 */
		protected Request getRequestForMovedEditPart() {
			Point delta = getDelta();
			ReconnectRequest request = new ReconnectRequest(movedType);
			request.setConnectionEditPart(this.link);
			request.setTargetEditPart(this.movedEP);
			request.setLocation(movedAnchor.getTranslated(delta.x, delta.y));
			return request;
		}

		/**
		 * Returns the request to relocate the fixed anchor.
		 * 
		 * @return
		 *         The request to locate the fixed anchor.
		 */
		protected Request getRequestForFixedEditPart() {
			ReconnectRequest request = new ReconnectRequest(fixedType);
			request.setConnectionEditPart(this.link);
			request.setTargetEditPart(this.fixedEP);
			request.setLocation(fixedAnchor);
			return request;
		}


		/**
		 * Returns the command to set the line straight.
		 * 
		 * @return
		 *         The command to set the line straight.
		 */
		public Command getCommand() {
			if(onOppositeSides()) {
				CompoundCommand command = new CompoundCommand();
				command.add(movedEP.getCommand(getRequestForMovedEditPart()));
				command.add(fixedEP.getCommand(getRequestForFixedEditPart()));

				Request onlyTwoBendpoints = new SetAllBendpointRequest(RequestConstants.REQ_SET_ALL_BENDPOINT, new PointList(), null, null);//we want zero bendpoint, and keep the current source and target	
				command.add(link.getCommand(onlyTwoBendpoints));
				return command.canExecute() ? command : UnexecutableCommand.INSTANCE;
			}
			return UnexecutableCommand.INSTANCE;
		}

		/**
		 * Tests if the two anchor are opposite.
		 * 
		 * @return
		 *         <ul>
		 *         <li> {@code true}</li> is the two anchors are opposite.
		 *         <li> {@code false}</li> if not
		 *         </ul>
		 */
		public boolean onOppositeSides() {
			Point pt = this.linkFigure.getStart();
			linkFigure.translateToAbsolute(pt);
			int side1 = LayoutUtils.getAnchorPosition(this.link.getSource(), pt);

			pt = this.linkFigure.getEnd();
			linkFigure.translateToAbsolute(pt);
			int side2 = LayoutUtils.getAnchorPosition(this.link.getTarget(), pt);

			if(routing == PositionConstants.RIGHT || routing == PositionConstants.LEFT) {
				if(DistributionConstants.verticalValuesList.contains(side1) && DistributionConstants.verticalValuesList.contains(side2)) {
					return true;
				}
			} else if(routing == PositionConstants.TOP || routing == PositionConstants.BOTTOM) {
				if(DistributionConstants.horizontalValuesList.contains(side1) && DistributionConstants.horizontalValuesList.contains(side2)) {
					return true;
				}
			}
			return false;
		}





	}


}
