package org.eclipse.papyrus.moka.fuml.debug;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Pin;

public class ControlDelegate {

	/**
	 * 
	 */
	protected AbstractExecutionEngine engine ;

	protected List<MokaThread> threads ;

	protected boolean suspended = false ;

	protected String mode ;

	public ControlDelegate(AbstractExecutionEngine engine) {
		this.engine = engine ;
		this.mode = this.engine.getDebugTarget().getLaunch().getLaunchMode() ;
	}

	public void addBreakpoint(MokaBreakpoint breakpoint) {
		// TODO Auto-generated method stub
	}

	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		// TODO Auto-generated method stub
	}

	public void resume(Resume_Request request) {
		this.suspended = false ;
		this.getThreads()[0].setSuspended(false) ;
		synchronized (this) {
			notify() ;
			this.threads.get(0).setStackFrames(new IStackFrame[]{}) ;
		}
	}

	public IStackFrame[] getStackFrames(IThread thread) {
		// Never called in this implementation
		// When the debug is notified, threads are already constructed with appropriate stack frames.
		return null;
	}

	public void suspend(Suspend_Request request) {
		this.suspended = true ;
		this.getThreads()[0].setSuspended(true) ;
	}

	public MokaThread[] getThreads() {
		if (this.threads == null) {
			this.threads = new ArrayList<MokaThread>() ;
			if (this.engine.getDebugTarget().getLaunch().getLaunchMode().equals(ILaunchManager.DEBUG_MODE)) {
				MokaThread thread = new MokaThread(this.engine.getDebugTarget()) ;
				thread.setName("Main Thread") ;
				thread.setStackFrames(new IStackFrame[]{}) ;
				this.threads.add(thread) ;
			}
		}
		return threads.toArray(new MokaThread[threads.size()]) ;
	}

	/**
	 * Method that can be called by a particular execution engine to delegate control of execution flow. 
	 * 
	 * @param object An object from the execution flow from which control has to be delegated
	 * @return False if execution shall stop, True if execution shall continue
	 */
	public boolean control(Object object) {
		if (this.engine.isTerminated()) {
			return false ;
		}

		// Retrieves the semantic element
		EObject semanticElement = null ;
		if (object instanceof ActivityNodeActivation) {
			semanticElement = ((ActivityNodeActivation)object).node ;
		}
		else if (object instanceof ActivityEdgeInstance) {
			semanticElement = ((ActivityEdgeInstance)object).edge ;
		}
		else {
			Activator.log.error(new Exception("Unexpected element in ControlDelegate::control")) ;
		}

		// Manages animation
		if (object instanceof ActivityNodeActivation && semanticElement != null && MokaConstants.MOKA_AUTOMATIC_ANIMATION && this.mode.equals(ILaunchManager.DEBUG_MODE)) {
			this.animate((ActivityNodeActivation)object, (ActivityNode)semanticElement) ;
		}
		
		if (this.suspended) {
			try {
				synchronized (this) {
					this.getThreads() ; // To make sure that this.threads is not empty
					MokaThread mainThread = this.threads.get(0) ;
					MokaStackFrame stackFrame = new MokaStackFrame(this.engine.getDebugTarget()) ;
					stackFrame.setName(semanticElement.toString()) ;
					stackFrame.setModelElement(semanticElement) ;
					stackFrame.setVariables(new MokaVariable[]{}) ;
					stackFrame.setThread(mainThread) ;
					mainThread.setStackFrames(new IStackFrame[]{stackFrame}) ;
					Suspend_Event suspendEvent = new Suspend_Event(mainThread, DebugEvent.CLIENT_REQUEST, this.getThreads()) ;
					engine.sendEvent(suspendEvent) ;
					wait() ;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return !this.engine.isTerminated() ;
	}

	protected void animate(ActivityNodeActivation activation, ActivityNode node) {
		if (node instanceof Pin)
			return ;
		try {
			// Simulates, in the animation, instantaneous consumption 
			// on all input pins and production on all output pins

			// Retrieves all incoming edges for node and for its input pins
			List<ActivityEdge> allEdges = new ArrayList<ActivityEdge>() ;
			allEdges.addAll(node.getIncomings()) ;
			if (node instanceof Action) {
				for (InputPin input : ((Action)node).getInputs()) {
					allEdges.addAll(input.getIncomings()) ;
				}
			}

			// From all edges, retrieves all source output pins
			List<Pin> previousOutputs = new ArrayList<Pin>() ;
			for (ActivityEdge edge : allEdges) {
				ActivityNode source = edge.getSource() ;
				if (source instanceof Pin) {
					previousOutputs.add((Pin)source) ;
				}
			}

			// animate all previous outputs "simultaneously"
			for (Pin output : previousOutputs) {
				AnimationUtils.getInstance().addAnimationMarker(output) ;
			}
			if (! previousOutputs.isEmpty())
				Thread.sleep(MokaConstants.MOKA_ANIMATION_DELAY) ;
			for (Pin output : previousOutputs) {
				AnimationUtils.getInstance().removeAnimationMarker(output) ;
			}

			// animate all input edges simultaneously
//			for (ActivityEdge edge : allEdges) {
//				AnimationUtils.getInstance().addAnimationMarker(edge) ;
//			}
//			if (! allEdges.isEmpty())
//				Thread.sleep(MokaConstants.MOKA_ANIMATION_DELAY) ;
//			for (ActivityEdge edge : allEdges) {
//				AnimationUtils.getInstance().removeAnimationMarker(edge) ;
//			}

			// animate inputs
			if (node instanceof Action) {
				for (InputPin input : ((Action)node).getInputs()) {
					AnimationUtils.getInstance().addAnimationMarker(input) ;
				}
				if (!((Action)node).getInputs().isEmpty())
					Thread.sleep(MokaConstants.MOKA_ANIMATION_DELAY) ;
				for (InputPin input : ((Action)node).getInputs()) {
					AnimationUtils.getInstance().removeAnimationMarker(input) ;
				}
			}

			// animate node
			AnimationUtils.getInstance().addAnimationMarker(node) ;
			Thread.sleep(MokaConstants.MOKA_ANIMATION_DELAY) ;
			AnimationUtils.getInstance().removeAnimationMarker(node) ;

		} catch (InterruptedException e) {
			Activator.log.error(e) ;
		}
	}

	public void terminate(Terminate_Request request) {
		engine.setIsTerminated(true) ;
		synchronized (this) {
			notify() ;
		}
	}

}
