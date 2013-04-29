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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.AbstractConnectionCreationTool;
import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.gef.tools.TargetingTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class DurationCreationTool extends AspectUnspecifiedTypeCreationTool {

	static private Cursor CURSOR_TARGET_MENU = new Cursor(Display.getDefault(), SWT.CURSOR_HAND);

	/**
	 * The state which indicates that the duration creation has begun. This means that the
	 * source of the duration has been identified, and the user is still to determine the
	 * target.
	 */
	protected static final int STATE_CONNECTION_STARTED = TargetingTool.MAX_STATE << 1;

	/**
	 * The flag which indicates that feedback figure must be shown
	 */
	private static final int FLAG_SOURCE_FEEDBACK = TargetingTool.MAX_FLAG << 1;

	/**
	 * The max state.
	 */
	protected static final int MAX_STATE = STATE_CONNECTION_STARTED;

	/**
	 * The max flag.
	 */
	protected static final int MAX_FLAG = FLAG_SOURCE_FEEDBACK;

	/**
	 * The first element constrained by the duration constraint
	 */
	private EditPart connectionSource;

	/**
	 * The viewer
	 */
	private EditPartViewer viewer;

	/**
	 * Listener for the edit part deactivation
	 */
	private EditPartListener.Stub deactivationListener = new EditPartListener.Stub() {

		@Override
		public void partDeactivated(EditPart editpart) {
			handleSourceDeactivated();
		}
	};

	/**
	 * Constructor of the creation tool.
	 * 
	 * @param elementTypes
	 *        element types the tool can create
	 */
	public DurationCreationTool(List<IElementType> elementTypes) {
		super(elementTypes);
		setDefaultCursor(SharedCursors.CURSOR_PLUG);
		setDisabledCursor(SharedCursors.NO);
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#handleDrag()
	 */
	@Override
	protected boolean handleDrag() {
		if(isInState(STATE_CONNECTION_STARTED)) {
			return handleMove();
		}
		return false;
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#handleDragInProgress()
	 */
	@Override
	protected boolean handleDragInProgress() {
		if(isInState(STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			return handleMove();
		}
		return false;
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#getDebugNameForState(int)
	 */
	@Override
	protected String getDebugNameForState(int s) {
		if(s == STATE_CONNECTION_STARTED || s == STATE_ACCESSIBLE_DRAG_IN_PROGRESS) {
			return "Connection Started";//$NON-NLS-1$
		}
		return super.getDebugNameForState(s);
	}

	/**
	 * Sets the location of the request.
	 * 
	 * @see org.eclipse.gef.tools.TargetingTool#updateTargetRequest()
	 */
	@Override
	protected void updateTargetRequest() {
		CreateRequest req = getCreateRequest();
		req.setLocation(getLocation());
	}

	/**
	 * Sets the target request. This method is typically not called; subclasses normally override {@link #createTargetRequest()}.
	 * 
	 * @see org.eclipse.gef.tools.TargetingTool#setTargetRequest(org.eclipse.gef.Request)
	 * @param req
	 *        the target request
	 */
	@Override
	protected void setTargetRequest(Request req) {
		if(req == null && connectionSource != null) {
			// do not erase the request when target changes (behavior inherited from CreationTool)
			return;
		}
		super.setTargetRequest(req);
	}

	/**
	 * Called if the source editpart is deactivated for some reason during the creation
	 * process. For example, the user performs an Undo while in the middle of creating a
	 * connection, which undoes a prior command which created the source.
	 */
	protected void handleSourceDeactivated() {
		setState(STATE_INVALID);
		handleInvalidInput();
		handleFinished();
	}

	/**
	 * Method that is called when the gesture to create the connection has been received.
	 * Subclasses may extend or override this method to do additional creation setup, such as
	 * prompting the user to choose an option about the connection being created. Returns <code>true</code> to indicate that the connection creation
	 * succeeded.
	 * 
	 * @return <code>true</code> if the connection creation was performed
	 */
	protected boolean handleCreateConnection() {
		eraseSourceFeedback();
		Command endCommand = getCommand();
		setCurrentCommand(endCommand);
		executeCurrentCommand();
		return true;
	}

	/**
	 * @see org.eclipse.gef.tools.TargetingTool#handleInvalidInput()
	 */
	@Override
	protected boolean handleInvalidInput() {
		eraseSourceFeedback();
		setConnectionSource(null);
		return super.handleInvalidInput();
	}

	/**
	 * When the button is first pressed, the source node and its command contribution are
	 * determined and locked in. After that time, the tool will be looking for the target
	 * node to complete the connection
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#handleButtonDown(int)
	 * @param button
	 *        which button is pressed
	 * @return <code>true</code> if the button down was processed
	 */
	@Override
	protected boolean handleButtonDown(int button) {
		if(button == 1 && stateTransition(STATE_CONNECTION_STARTED, STATE_TERMINAL)) {
			return handleCreateConnection();
		}
		if(isInState(STATE_INITIAL) && button == 1) {
			updateTargetRequest();
			updateTargetUnderMouse();
			setConnectionSource(getTargetEditPart());
			Command command = getCommand();
			Request request = getTargetRequest();
			//target elements of request have been set
			if(command != null) {
				setState(STATE_CONNECTION_STARTED);
				setCurrentCommand(command);
				viewer = getCurrentViewer();
				// update request : initialize required extended data
				Map extendedData = request.getExtendedData();
				extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2, null);
				extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2, null);
			}
		}
		if(isInState(STATE_INITIAL) && button != 1) {
			setState(STATE_INVALID);
			handleInvalidInput();
		}
		if(isInState(STATE_CONNECTION_STARTED)) {
			//Fake a drag to cause feedback to be displayed immediately on mouse down.
			handleDrag();
		}
		return true;
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#handleMove()
	 */
	@Override
	protected boolean handleMove() {
		if(isInState(STATE_CONNECTION_STARTED) && viewer != getCurrentViewer()) {
			return false;
		}
		if(isInState(STATE_CONNECTION_STARTED | STATE_INITIAL | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			updateTargetRequest();
			updateTargetUnderMouse();
			showSourceFeedback();
			showTargetFeedback();
			setCurrentCommand(getCommand());
		}
		if(isInState(STATE_CONNECTION_STARTED)) {
			// Expose the diagram as the user scrolls in the area handled by the
			// autoexpose helper.
			updateAutoexposeHelper();
		}
		return true;
	}

	/**
	 * Sets the source editpart for the creation
	 * 
	 * @param source
	 *        the source editpart node
	 */
	protected void setConnectionSource(EditPart source) {
		if(connectionSource != null) {
			connectionSource.removeEditPartListener(deactivationListener);
		}
		connectionSource = source;
		if(connectionSource != null) {
			connectionSource.addEditPartListener(deactivationListener);
		}
	}

	/**
	 * Returns <code>true</code> if feedback is being shown.
	 * 
	 * @return <code>true</code> if showing source feedback
	 */
	protected boolean isShowingSourceFeedback() {
		return getFlag(FLAG_SOURCE_FEEDBACK);
	}

	/**
	 * Asks the source editpart to erase connection creation feedback.
	 */
	protected void eraseSourceFeedback() {
		if(!isShowingSourceFeedback()) {
			return;
		}
		setFlag(FLAG_SOURCE_FEEDBACK, false);
		if(connectionSource != null) {
			connectionSource.eraseSourceFeedback(getSourceRequest());
		}
	}

	/**
	 * Scrolling can happen either in the {@link AbstractTool#STATE_INITIAL initial} state or
	 * once the source of the connection has been {@link AbstractConnectionCreationTool#STATE_CONNECTION_STARTED identified}.
	 * 
	 * @see org.eclipse.gef.Tool#mouseWheelScrolled(org.eclipse.swt.widgets.Event, org.eclipse.gef.EditPartViewer)
	 */
	@Override
	public void mouseWheelScrolled(Event event, EditPartViewer viewer) {
		if(isInState(STATE_INITIAL | STATE_CONNECTION_STARTED)) {
			performViewerMouseWheel(event, viewer);
		}
	}

	/**
	 * Returns the request sent to the source node. The source node receives the same request
	 * that is used with the target node. The only difference is that at that time the
	 * request will be typed as {@link RequestConstants#REQ_CONNECTION_START}.
	 * 
	 * @return the request used with the source node editpart
	 */
	protected Request getSourceRequest() {
		return getTargetRequest();
	}

	/**
	 * Sends a show feedback request to the source editpart and sets the feedback flag.
	 */
	protected void showSourceFeedback() {
		if(connectionSource != null) {
			connectionSource.showSourceFeedback(getSourceRequest());
		}
		setFlag(FLAG_SOURCE_FEEDBACK, true);
	}

	/**
	 * Unloads or resets the tool if the state is in the terminal or invalid state.
	 * 
	 * @see org.eclipse.gef.tools.AbstractTool#handleButtonUp(int)
	 */
	@Override
	protected boolean handleButtonUp(int button) {
		if(isInState(STATE_CONNECTION_STARTED)) {
			handleCreateConnection();
		}
		setState(STATE_TERMINAL);
		if(isInState(STATE_TERMINAL | STATE_INVALID)) {
			handleFinished();
		}
		return true;
	}

	/**
	 * @see org.eclipse.gef.tools.AbstractTool#handleCommandStackChanged()
	 */
	@Override
	protected boolean handleCommandStackChanged() {
		if(!isInState(STATE_INITIAL)) {
			if(getCurrentInput().isMouseButtonDown(1)) {
				setState(STATE_INVALID);
			} else {
				setState(STATE_INITIAL);
			}
			handleInvalidInput();
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.gef.Tool#deactivate()
	 */
	@Override
	public void deactivate() {
		eraseSourceFeedback();
		setConnectionSource(null);
		super.deactivate();
		setState(STATE_TERMINAL);
		viewer = null;
	}

	/**
	 * Calculate the cursor to display
	 * 
	 * @see org.eclipse.gef.tools.AbstractConnectionCreationTool#calculateCursor()
	 */
	@Override
	protected Cursor calculateCursor() {
		if(isInState(STATE_CONNECTION_STARTED)) {
			// Give some feedback so the user knows the area where autoscrolling
			// will occur.
			if(getAutoexposeHelper() != null) {
				return SharedCursors.HAND;
			} else {
				// Give some feedback so the user knows that they can't drag
				// outside the viewport.
				if(getCurrentViewer() != null) {
					Control control = getCurrentViewer().getControl();
					if(control instanceof FigureCanvas) {
						Viewport viewport = ((FigureCanvas)control).getViewport();
						Rectangle rect = Rectangle.SINGLETON;
						viewport.getClientArea(rect);
						viewport.translateToParent(rect);
						viewport.translateToAbsolute(rect);
						if(!rect.contains(getLocation())) {
							return getDisabledCursor();
						}
					}
				}
			}
		}
		Command command = getCurrentCommand();
		if(command != null && command.canExecute()) {
			EditPart ep = getTargetEditPart();
			if(ep instanceof DiagramEditPart || ep instanceof CompartmentEditPart) {
				return CURSOR_TARGET_MENU;
			}
		}
		return super.calculateCursor();
	}

	/**
	 * Get the command to execute
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool#getCommand()
	 * 
	 * @return the command
	 */
	@Override
	protected Command getCommand() {
		if(!antiScroll) {
			EditPart targetPart = getTargetEditPart();
			if(targetPart == null) {
				return null;
			}
			Request req = getTargetRequest();
			/*if(targetPart instanceof ConnectionNodeEditPart) {
				// a message part is targeted. Instead, we must take the nearby lifeline part.
				// redirect to the message part will be performed later in case we really want to draw a duration on a message
				ConnectionNodeEditPart conn = (ConnectionNodeEditPart)targetPart;
				EditPart source = ((ConnectionNodeEditPart)targetPart).getSource();
				EditPart target = ((ConnectionNodeEditPart)targetPart).getTarget();
				if(source instanceof NodeEditPart && target instanceof NodeEditPart) {
					ConnectionAnchor sourceAnch = ((NodeEditPart)source).getSourceConnectionAnchor(conn);
					ConnectionAnchor targetAnch = ((NodeEditPart)target).getSourceConnectionAnchor(conn);
					double sourceDist = getLocation().getDistance(sourceAnch.getReferencePoint());
					double targetDist = getLocation().getDistance(targetAnch.getReferencePoint());
					if(sourceDist > targetDist) {
						targetPart = target;
					} else {
						targetPart = source;
					}
				}
			}
			LifelineEditPart lifelinePart = SequenceUtil.getParentLifelinePart(targetPart);
			if(lifelinePart instanceof LifelineEditPart) {
				Object paramOcc1 = req.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
				List<OccurrenceSpecification> occ1List = SequenceUtil.getAsOccSpecList(paramOcc1);
				Object paramOcc2 = req.getExtendedData().get(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
				List<OccurrenceSpecification> occ2List = SequenceUtil.getAsOccSpecList(paramOcc2);
				if(!occ1List.isEmpty() && !occ2List.isEmpty() && Collections.disjoint(occ1List, occ2List)) {
					OccurrenceSpecification[] pair = SequenceUtil.getPairOfCorrespondingOccSpec(occ1List, occ2List);
					if(pair != null && pair.length > 1) {
						OccurrenceSpecification occ1 = pair[0];
						OccurrenceSpecification occ2 = pair[1];
						if(DurationConstraintHelper.endsOfSameMessage(occ1, occ2)) {
							// call request on the link
							EditPart part = SequenceUtil.getLinkedEditPart(lifelinePart, occ2);
							if(part != null) {
								return part.getCommand(req);
							}
						}
					}
				}
			}*/
			if(targetPart instanceof InteractionInteractionCompartmentEditPart || targetPart instanceof ConnectionNodeEditPart) 
				return targetPart.getCommand(req);
			targetPart = getInteractionEditPart(targetPart);
			if(targetPart != null){
				return targetPart.getCommand(req);
			}
		}
		return null;
	}
	
	private EditPart getInteractionEditPart(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		if(editPart instanceof InteractionInteractionCompartmentEditPart) {
			return editPart;
		}
		return getInteractionEditPart(editPart.getParent());
	}
}
