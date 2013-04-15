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
package org.eclipse.papyrus.moka.debug;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.debug.core.model.ITerminate;

/**
 * An IProcess is an abstraction of a running program (in our case, the actual execution engine). 
 * The Eclipse debug plugin provides a default implementation for java.lang.Process. 
 * Such a Process can then be started by running a command line. In the case where the target 
 * program is itself implemented as an Eclipse plug-in, providing the appropriate command line 
 * is complex, especially regarding the appropriate class path. 
 * In order to simplify this, Moka provides MokaProcess, an implementation of IProcess 
 * simulating a process with a job. The job is provided as a parameter of the constructor, 
 * and encapsulates execution of an IExecutionEngine. When the constructor is called, 
 * a MokaJobChangeListener is added to the given Job, so that when the Job terminates 
 * (which means that Job.done() is called), the MokaProcess is notified of the termination 
 * and terminates itself (i.e., MokaJobChangeListener.done() calls MokaProcess.terminated()).
 * 
 */
public class MokaProcess extends PlatformObject implements IProcess {

	private static final int MAX_WAIT_FOR_DEATH_ATTEMPTS = 10;
	private static final int TIME_TO_WAIT_FOR_THREAD_DEATH = 500; // ms

	/**
	 * The launch this process is contained in
	 */
	protected ILaunch launch;

	/**
	 * The Job used to run the execution engine
	 */
	protected Job job;

	/**
	 * This Job's exit value
	 */
	protected int exitValue;

	/**
	 * The label of the process
	 */
	protected String label;

	/**
	 * Whether this process is terminated
	 */
	protected boolean isTerminated = false ;

	/**
	 * Table of client defined attributes
	 */
	protected Map<String, String> attributes;


	/**
	 * Constructs a MokaRuntimeProcess on the given job, adding this process to the given launch.
	 * 
	 * @param launch the parent launch of this process
	 * @param process underlying system process
	 * @param label the label used for this process
	 * @param attributes map of attributes used to initialize the attributes of this process, or null if none
	 */
	public MokaProcess(ILaunch launch, Job job, String label, Map<String, String> attributes) {
		this.launch = launch;
		initializeAttributes(attributes);
		this.job = job ;
		this.job.addJobChangeListener(new MokaJobChangeListener(this)) ;
		this.label = label;
		isTerminated= false ;
		launch.addProcess(this);
		fireCreationEvent();
	}
	
	/**
	 * Initialize the attributes of this process to those in the given map.
	 * 
	 * @param attributes attribute map or <code>null</code> if none
	 */
	protected void initializeAttributes(Map<String, String> attributes) {
		if (attributes != null) {
			Iterator<String> keys = attributes.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String)keys.next();
				setAttribute(key, (String)attributes.get(key));
			}	
		}
	}

	/**
	 * @see ITerminate#canTerminate()
	 */
	public synchronized boolean canTerminate() {
		return !isTerminated;
	}

	/**
	 * @see IProcess#getLabel()
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @see IProcess#getLaunch()
	 */
	public ILaunch getLaunch() {
		return launch;
	}

	/**
	 * @see ITerminate#isTerminated()
	 */
	public synchronized boolean isTerminated() {
		return isTerminated;
	}

	/**
	 * @see ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		if (!isTerminated()) {			
			//Job job = getExecutionEngineJob();
			if (this.job != null) {
				this.job.cancel();
			}
			int attempts = 0;
			while (attempts < MAX_WAIT_FOR_DEATH_ATTEMPTS) {
				try {
					if (this.job != null) {
						IStatus result = this.job.getResult() ;
						if (result == null) // No result available. It means that cancellation is not yet effective.
							throw new IllegalThreadStateException() ;
						else
							this.exitValue = this.job.getResult().getCode() ;
					}
					return;
				} catch (IllegalThreadStateException ie) {
					ie.printStackTrace() ;
				}
				try {
					Thread.sleep(TIME_TO_WAIT_FOR_THREAD_DEATH);
				} catch (InterruptedException e) {
				}
				attempts++;
			}
			IStatus status = new Status(IStatus.ERROR, DebugPlugin.getUniqueIdentifier(), DebugException.TARGET_REQUEST_FAILED, "Terminate failed", null);		 
			throw new DebugException(status);
		}
	}

	/**
	 * Notification that the system process associated with this process
	 * has terminated.
	 */
	public void terminated() {
		int exitValue = -1;
		boolean running = false;
		try {
			exitValue = this.job.getResult().getCode();
		} catch (IllegalThreadStateException ie) {
			running = true;
		}

		synchronized (this) {
			isTerminated= true;
			if (!running) {
				this.exitValue = exitValue;
			}
			this.job= null;
		}
		this.fireTerminateEvent();
	}

	/**
	 * @see IProcess#getStreamsProxy()
	 */
	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	/**
	 * Fires a creation event.
	 */
	protected void fireCreationEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
	}

	/**
	 * Fires the given debug event.
	 * 
	 * @param event debug event to fire
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin manager= DebugPlugin.getDefault();
		if (manager != null) {
			manager.fireDebugEventSet(new DebugEvent[]{event});
		}
	}

	/**
	 * Fires a terminate event.
	 */
	protected void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	/**
	 * Fires a change event.
	 */	
	protected void fireChangeEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CHANGE));
	}

	/**
	 * @see IProcess#setAttribute(String, String)
	 */
	public void setAttribute(String key, String value) {
		if (attributes == null) {
			attributes = new HashMap<String,String>();
		}
		Object origVal = attributes.get(key);
		if (origVal != null && origVal.equals(value)) {
			return; //nothing changed.
		}

		attributes.put(key, value);
		fireChangeEvent();
	}

	/**
	 * @see IProcess#getAttribute(String)
	 */
	public String getAttribute(String key) {
		if (attributes == null) {
			return null;
		}
		return (String)attributes.get(key);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter.equals(IProcess.class)) {
			return this;
		}
		if (adapter.equals(IDebugTarget.class)) {
			ILaunch launch = getLaunch();
			IDebugTarget[] targets = launch.getDebugTargets();
			for (int i = 0; i < targets.length; i++) {
				if (this.equals(targets[i].getProcess())) {
					return targets[i];
				}
			}
			return null;
		}
		if (adapter.equals(ILaunch.class)) {
			return getLaunch();
		}
		//CONTEXTLAUNCHING
		if(adapter.equals(ILaunchConfiguration.class)) {
			return getLaunch().getLaunchConfiguration();
		}
		return super.getAdapter(adapter);
	}
	/**
	 * @see IProcess#getExitValue()
	 */
	public synchronized int getExitValue() throws DebugException {
		if (isTerminated()) {
			return exitValue;
		} 
		throw new DebugException(new Status(IStatus.ERROR, DebugPlugin.getUniqueIdentifier(), DebugException.TARGET_REQUEST_FAILED, "Exit value not available until process terminates.", null)); 
	}

}
