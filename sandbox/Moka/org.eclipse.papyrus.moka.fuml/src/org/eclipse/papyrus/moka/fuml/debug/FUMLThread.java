package org.eclipse.papyrus.moka.fuml.debug;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;

public class FUMLThread extends MokaThread implements IPresentation {

	/**
	 * Determines if this thread is terminated
	 */
	protected boolean isTerminated = false ;
	
	/**
	 * Determines if this thread is waiting
	 */
	protected boolean isWaiting = false ;

	/**
	 * The reason for suspending this thread,
	 * where -1 means that there is no reason to suspend this thread
	 */
	protected int reasonForSuspending = -1 ;

	/**
	 * The reason for resuming this thread
	 */
	protected int reasonForResuming = DebugEvent.CLIENT_REQUEST ;

	public FUMLThread(MokaDebugTarget debugTarget) {
		super(debugTarget);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.ui.presentation.IPresentation#getLabel()
	 */
	public String getLabel() {
		String label = "" ;
		try {
			label = this.getName() + " [";
			if (this.isTerminated()) {
				label += "TERMINATED]" ;
			}
			else if (this.isWaiting()) {
				label += "WAITING]" ;
			}
			else if (this.isStepping()) {
				label += "STEPPING]" ;
			}
			else if (this.isSuspended()) {
				label += "SUSPENDED]" ;
			}
			else {
				label += "RUNNING]" ;
			}
		} catch (DebugException e) {
			Activator.log.error(e);
			label += "Default" ;
		}
		return label ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.ui.presentation.IPresentation#getDetails()
	 */
	public String getDetails() {
		// Not applicable
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.ui.presentation.IPresentation#getImage()
	 */
	public Image getImage() {
		// By returning null, default images are used
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaThread#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return this.isTerminated ;
	}

	/**
	 * Returns true if is thread is in the Waiting state, false otherwise
	 * 
	 * @return true if is thread is in the Waiting state, false otherwise
	 */
	public boolean isWaiting() {
		return this.isWaiting ;
	}
	
	/**
	 * Convenience method for determining if this thread terminated
	 * 
	 * @param isTerminated
	 */
	public void setIsTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated ;
	}

	/**
	 * Returns any reason for suspending this thread (e.g., CLIENT_REQUEST, BREAKPOINT, etc.), 
	 * or -1 if no reason to suspend.
	 * 
	 * @return any reason for suspending this thread, or -1 if no reason to suspend
	 */
	public int getReasonForSuspending() {
		return reasonForSuspending;
	}

	/**
	 * Convenience method for setting a reason to suspend this thread
	 * 
	 * @param reasonForSuspending
	 */
	public void setReasonForSuspending(int reasonForSuspending) {
		this.reasonForSuspending = reasonForSuspending;
	}

	/**
	 * Returns the reason for resuming this thread
	 * 
	 * @return the reason for resuming this thread
	 */
	public int getReasonForResuming() {
		return reasonForResuming;
	}

	/**
	 * Convenience method for setting the reason to resume this thread
	 * 
	 * @param reasonForResuming
	 */
	public void setReasonForResuming(int reasonForResuming) {
		this.reasonForResuming = reasonForResuming;
	}

	/**
	 * Convenience method for determining if this thread is in the waiting state
	 * 
	 * @param isWaiting
	 */
	public void setIsWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting ;
	}
	
	/**
	 * Convenience method for determining if this thread is stepping
	 * 
	 * @param isStepping
	 */
	public void setIsStepping(boolean isStepping) {
		this.isStepping = isStepping ;
	}

	/** 
	 * Extended to account for the waiting state.
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaThread#canResume()
	 */
	@Override
	public boolean canResume() {
		if (this.isWaiting)
			return false ;
		return super.canResume();
	}

	/**
	 * Extended to account for the waiting state.
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaThread#canSuspend()
	 */
	@Override
	public boolean canSuspend() {
		if (this.isWaiting || this.isTerminated)
			return false ;
		return super.canSuspend();
	}

	/**
	 * Extended to account for the waiting state.
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaThread#canStepInto()
	 */
	@Override
	public boolean canStepInto() {
		if (this.isWaiting)
			return false ;
		return super.canStepInto();
	}

	/**
	 * Extended to account for the waiting state.
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaThread#canStepOver()
	 */
	@Override
	public boolean canStepOver() {
		if (this.isWaiting)
			return false ;
		return super.canStepOver();
	}

	/**
	 * Extended to account for the waiting state.
	 * 
	 *  (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.debug.MokaThread#canStepReturn()
	 */
	@Override
	public boolean canStepReturn() {
		if (this.isWaiting)
			return false ;
		return super.canStepReturn();
	}
	
	
	
}
