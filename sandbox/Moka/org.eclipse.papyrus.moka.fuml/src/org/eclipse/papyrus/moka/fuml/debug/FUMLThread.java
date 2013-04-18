package org.eclipse.papyrus.moka.fuml.debug;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;

public class FUMLThread extends MokaThread implements IPresentation {

	protected boolean isTerminated = false ;

	protected int reasonForSuspending = -1 ;

	protected int reasonForResuming = DebugEvent.CLIENT_REQUEST ;

	public FUMLThread(MokaDebugTarget debugTarget) {
		super(debugTarget);
	}

	public String getLabel() {
		String label = "" ;
		try {
			label = this.getName() + " [";
			if (this.isTerminated()) {
				label += "TERMINATED]" ;
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

	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTerminated() {
		return this.isTerminated ;
	}

	public void setIsTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated ;
	}

	public int getReasonForSuspending() {
		return reasonForSuspending;
	}

	public void setReasonForSuspending(int reasonForSuspending) {
		this.reasonForSuspending = reasonForSuspending;
	}

	public int getReasonForResuming() {
		return reasonForResuming;
	}

	public void setReasonForResuming(int reasonForResuming) {
		this.reasonForResuming = reasonForResuming;
	}

}
