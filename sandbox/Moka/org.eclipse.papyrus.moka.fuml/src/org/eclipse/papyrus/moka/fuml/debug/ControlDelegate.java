package org.eclipse.papyrus.moka.fuml.debug;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;

public class ControlDelegate {

	protected boolean suspendRequestedByCLient = false ;

	protected ActivityExecution lastSuspendedActivityExecution ;

	public synchronized void suspend(ActivityExecution execution) throws InterruptedException {
		this.lastSuspendedActivityExecution = execution ;
		wait();
	}

	protected int reasonForResume ;

	public synchronized void resume(Resume_Request request) {
		this.suspendRequestedByCLient = false ;
		this.reasonForResume = request.getResumeDetail() ;
		notify() ;
	}

	public int shallSuspend(ActivityExecution execution, Object activityNodeActiviationOrActivityEdgeInstance) {
		// first checks if a suspend request has been emitted from client
		if (this.suspendRequestedByCLient)
			return DebugEvent.CLIENT_REQUEST ;
		// then check if a breakpoint applies
		if (DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			if (activityNodeActiviationOrActivityEdgeInstance instanceof ActivityNodeActivation) {
				ActivityNodeActivation nodeActivation = (ActivityNodeActivation)activityNodeActiviationOrActivityEdgeInstance ;
				if (nodeActivation.node != null) {
					//String uri = EcoreUtil.getURI(nodeActivation.node).toString() ;
					if (this.urisOfObjectWithBreakpoints.contains(EcoreUtil.getURI(nodeActivation.node).toString()))
						return DebugEvent.BREAKPOINT ;
				}
			}
			if (activityNodeActiviationOrActivityEdgeInstance instanceof ActivityEdgeInstance) {
				ActivityEdgeInstance edgeInstance = (ActivityEdgeInstance)activityNodeActiviationOrActivityEdgeInstance ;
				if (edgeInstance.edge != null)
					if (this.urisOfObjectWithBreakpoints.contains(EcoreUtil.getURI(edgeInstance.edge).toString()))
						return DebugEvent.BREAKPOINT ;
			}
		}
		int shallSuspend = -1 ;
		switch (this.reasonForResume) {
		case DebugEvent.CLIENT_REQUEST :
			shallSuspend = -1 ;
			break;
		case DebugEvent.STEP_INTO :
			shallSuspend = DebugEvent.STEP_END ;
			break;
		case DebugEvent.STEP_OVER :
			if (! (StackFrameManager.getInstance().contains(execution) && StackFrameManager.getInstance().contains(lastSuspendedActivityExecution)))
				shallSuspend = DebugEvent.STEP_END ;
			else
				shallSuspend = (execution == lastSuspendedActivityExecution) ? DebugEvent.STEP_END : -1;
			break;
		case DebugEvent.STEP_RETURN :
			shallSuspend = StackFrameManager.getInstance().isBefore(execution, lastSuspendedActivityExecution) ? DebugEvent.STEP_END : -1;
			break;
		default:
			break;
		}
		return shallSuspend ;
	}

	public void handleSuspendRequest() {
		this.suspendRequestedByCLient = true ;
	}

	public synchronized void handleTerminateRequest() {
		notify() ;
	}

	protected List<String> urisOfObjectWithBreakpoints = new ArrayList<String>() ;

	public synchronized void addBreakpoint(MokaBreakpoint breakpoint) {
		//String eObjectURI = EcoreUtil.getURI(breakpoint.getModelElement()).toString() ;
		String eObjectURI = breakpoint.getMarker().getAttribute(EValidator.URI_ATTRIBUTE, (String)null) ;
		if (eObjectURI != null) {
			if (! urisOfObjectWithBreakpoints.contains(eObjectURI))
				urisOfObjectWithBreakpoints.add(eObjectURI) ;
		}
	}

	public synchronized void removeBreakpoint(MokaBreakpoint breakpoint) {
		//String eObjectURI = EcoreUtil.getURI(breakpoint.getModelElement()).toString() ;
		String eObjectURI = breakpoint.getMarker().getAttribute(EValidator.URI_ATTRIBUTE, (String)null) ;
		if (eObjectURI != null) {
			urisOfObjectWithBreakpoints.remove(eObjectURI) ;
		}
	}
}
