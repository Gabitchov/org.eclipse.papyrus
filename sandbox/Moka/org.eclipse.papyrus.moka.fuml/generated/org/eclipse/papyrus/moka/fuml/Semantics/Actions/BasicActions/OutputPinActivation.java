/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions;

import java.util.List;

import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.Token;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.debug.StackFrameManager;
import org.eclipse.papyrus.moka.fuml.presentation.FUMLPresentationUtils;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.uml2.uml.ActivityNode;

public class OutputPinActivation extends PinActivation {

	/** 
	 * Overriding introduced to connect with the debug API
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ObjectNodeActivation#sendOffers(java.util.List)
	 */
	@Override
	public void sendOffers(List<Token> tokens) {
		// Connection with the debug api
		Locus locus = this.getActivityExecution().locus ;
		if (locus.isInDebugMode) {
			this.incomingTokens_DEBUG = tokens ;
			if (locus.engine.isTerminated())
				return ;
			boolean animationMarkerNeedsToBeRemoved = false ;
			long date = 0 ;
			if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
				date = System.currentTimeMillis() ;
				AnimationUtils.getInstance().addAnimationMarker(node) ;
				animationMarkerNeedsToBeRemoved = true ;
			}
			MokaStackFrame stackFrame = FUMLPresentationUtils.getMokaStackFrame(this) ;
			stackFrame.setThread(locus.mainThread) ;
			StackFrameManager.getInstance().setStackFrame(this.getActivityExecution(), stackFrame) ;
			//locus.stackFrames = new MokaStackFrame[]{stackFrame} ;
			int reasonForSuspending = FUMLExecutionEngine.controlDelegate.shallSuspend(this.getActivityExecution(), this) ;
			if (reasonForSuspending != -1) {
				locus.mainThread.setSuspended(true) ;
				locus.mainThread.setStackFrames(null) ;
				locus.stackFrames = StackFrameManager.getInstance().getStackFrames() ;
				Suspend_Event breakpointEvent = new Suspend_Event(locus.mainThread, reasonForSuspending, new MokaThread[]{locus.mainThread}) ;
				locus.engine.sendEvent(breakpointEvent) ;
				try {
					FUMLExecutionEngine.controlDelegate.suspend(this.getActivityExecution()) ;
				} catch (InterruptedException e) {
					Activator.log.error(e); 
				}
				locus.mainThread.setSuspended(false) ;
			}
			if (animationMarkerNeedsToBeRemoved) {
				try {
					long ellapsed = System.currentTimeMillis() - date ;
					long delay = Math.max(1,MokaConstants.MOKA_ANIMATION_DELAY - ellapsed) ;
					Thread.sleep(delay) ;
				} catch (InterruptedException e1) {
					Activator.log.error(e1);
				}	
				AnimationUtils.getInstance().removeAnimationMarker(node) ;
			}
			if (locus.engine.isTerminated())
				return ;
		}
		// End: Connection with the debug api
		super.sendOffers(tokens);
	}



}
