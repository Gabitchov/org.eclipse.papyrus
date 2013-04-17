/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.engine;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;

/**
 * A Job for hosting the execution of an engine
 *
 */
public class MokaExecutionEngineJob extends Job {

	/**
	 * The engine performing the execution
	 */
	protected IExecutionEngine engine ;
	
	protected MokaDebugTarget debugTarget ;

	public MokaExecutionEngineJob(String name, IExecutionEngine engine) {
		super(name) ;
		this.engine = engine ;
	}

	/** 
	 * Start the execution engine
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IStatus run(IProgressMonitor monitor) {
		try {
			this.engine.start() ;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, "org.eclipse.papyrus.moka", e.getMessage());
		}
		return new Status(IStatus.OK, "org.eclipse.papyrus.moka", "Execution was successfull");
	}
	
	public void setDebugTarget(MokaDebugTarget debugTarget) {
		this.debugTarget = debugTarget ;
	}
	
	public MokaDebugTarget getDebugTarget() {
		return this.debugTarget ;
	}

}
