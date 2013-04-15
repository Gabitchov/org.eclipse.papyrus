package org.eclipse.papyrus.moka.fuml.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;

public class FumlThread extends MokaThread {

	public FumlThread(MokaDebugTarget debugTarget) {
		super(debugTarget);
	}

	@Override
	public boolean canStepInto() {
		boolean canStepInto = super.canStepInto() ;
		if (canStepInto) {
			try {
				MokaStackFrame topStackFrame = (MokaStackFrame)this.getTopStackFrame() ;
				EObject modelElement = topStackFrame.getModelElement() ;
				if (modelElement instanceof CallOperationAction) {
					CallOperationAction action = (CallOperationAction)modelElement ;
					canStepInto = action.getOperation().getMethods().get(0) instanceof Activity ;
				}
				else if (modelElement instanceof CallBehaviorAction) {
					CallBehaviorAction action = (CallBehaviorAction)modelElement ;
					canStepInto = action.getBehavior() instanceof Activity ;
				}
				else {
					canStepInto = false ;
				}
			} catch (DebugException e) {
				canStepInto = false ;
			} catch (NullPointerException e) {
				canStepInto = false ;
			}
		}
		return canStepInto ;
	}
	
}
