package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.TargetRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.internal.tools.ConnectionHandleTool;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

public final class CustomConnectionHandleEditPolicy extends ConnectionHandleEditPolicy {

	@Override
	protected List getHandleFigures() {
		List list = new ArrayList(2);

		String tooltip;
		tooltip = buildTooltip(ConnectionHandle.HandleDirection.INCOMING);
		if(tooltip != null) {
			list.add(new ConnectionHandle((IGraphicalEditPart)getHost(), ConnectionHandle.HandleDirection.INCOMING, tooltip));
		}

		tooltip = buildTooltip(ConnectionHandle.HandleDirection.OUTGOING);
		if(tooltip != null) {
			ConnectionHandle connectionHandle = new ConnectionHandle((IGraphicalEditPart)getHost(), ConnectionHandle.HandleDirection.OUTGOING, tooltip);
			connectionHandle.setDragTracker(new ConnectionHandleTool(connectionHandle) {

				@Override
				protected String getCommandName() {
					if(isInState(STATE_CONNECTION_STARTED | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
						return SequenceUtil.OBSERVATION_LINK_REQUEST_END;
					} else {
						return SequenceUtil.OBSERVATION_LINK_REQUEST_START;
					}
				}

				// see also UMLPaletteFactory.createObservationLinkCreationTool()
				@Override
				protected boolean updateTargetUnderMouse() {
					if(!isTargetLocked()) {
						EditPart editPart = getCurrentViewer().findObjectAtExcluding(getLocation(), getExclusionSet(), getTargetingConditional());
						if(editPart != null) {
							editPart = editPart.getTargetEditPart(getTargetRequest());
						}
						// fix observation link moving over ExecutionSpecificationEditPart
						if(getTargetRequest() instanceof TargetRequest) {
							((TargetRequest)getTargetRequest()).setTargetEditPart(editPart);
						}
						boolean changed = getTargetEditPart() != editPart;
						setTargetEditPart(editPart);
						return changed;
					} else {
						return false;
					}
				}
			});
			list.add(connectionHandle);
		}

		return list;
	}
}
