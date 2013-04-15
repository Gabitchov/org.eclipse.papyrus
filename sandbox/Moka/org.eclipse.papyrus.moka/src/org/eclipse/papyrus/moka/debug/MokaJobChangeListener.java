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

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;

/**
 * See MokaProcess
 *
 */
public class MokaJobChangeListener implements IJobChangeListener {

	protected MokaProcess process;

	public MokaJobChangeListener(MokaProcess process) {
		this.process = process;
	}

	public void sleeping(IJobChangeEvent event) {
		// Not used
	}

	public void scheduled(IJobChangeEvent event) {
		// Not used
	}

	public void running(IJobChangeEvent event) {
		// Not used
	}

	public void done(IJobChangeEvent event) {
		process.terminated();
	}

	public void awake(IJobChangeEvent event) {
		// Not used
	}

	public void aboutToRun(IJobChangeEvent event) {
		// Not used
	}
}
