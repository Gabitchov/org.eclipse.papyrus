package org.eclipse.papyrus.moka.fuml.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityExecution;

public class StackFrameManager {

	protected static StackFrameManager eInstance ;
	
	protected List<ActivityExecution> activityExecutions = new ArrayList<ActivityExecution>() ;
	protected Map<ActivityExecution, MokaStackFrame> activityExecutionsToStackFrame = new HashMap<ActivityExecution, MokaStackFrame>() ;
	
	private StackFrameManager() {
		
	}
	
	public static StackFrameManager getInstance() {
		if (eInstance == null)
			eInstance = new StackFrameManager() ;
		return eInstance ;
	}
	
	public void pushActivityExecution(ActivityExecution execution) {
		this.activityExecutions.add(execution) ;
		this.activityExecutionsToStackFrame.put(execution, null) ;
	}
	
	public ActivityExecution popActivityExecution() {
		ActivityExecution removed = this.activityExecutions.remove(activityExecutions.size() - 1) ;
		this.activityExecutionsToStackFrame.remove(removed) ;
		return removed ;
	}
	
	public void setStackFrame(ActivityExecution execution, MokaStackFrame stackFrame) {
		this.activityExecutionsToStackFrame.put(execution, stackFrame) ;
	}
	
	public ActivityExecution getTopActivityExecution() {
		return activityExecutions.get(activityExecutions.size() - 1) ;
	}
	
	public boolean isBefore(ActivityExecution execution1, ActivityExecution execution2) {
		int indexOfExecution2 = activityExecutions.indexOf(execution2) ;
		if (indexOfExecution2 < 0) // execution2 has already been removed from the list of executions, so execution1 was necessarily before
			return true ;
		int indexOfExecution1 = activityExecutions.indexOf(execution1) ;
		return indexOfExecution1 < indexOfExecution2 ;
	}
	
	public boolean contains(ActivityExecution execution) {
		return this.activityExecutions.contains(execution) ;
	}
	
	public MokaStackFrame[] getStackFrames() {
		MokaStackFrame[] stackFrames = new MokaStackFrame[this.activityExecutions.size()] ;
		int j = 0 ;
		for (int i = activityExecutions.size() - 1 ; i >=0 ; i--) {
			MokaStackFrame stackFrameElement = this.activityExecutionsToStackFrame.get(activityExecutions.get(i)) ;
			stackFrames[j] = stackFrameElement ;
			j++ ;
		}
		return stackFrames ;
	}
}
