/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.validation.problems.util;

import java.util.EventObject;

import org.eclipse.papyrus.cdo.validation.problems.EProblem;

/**
 * This is the ProblemsEvent type. Enjoy.
 */
public class ProblemsEvent
		extends EventObject {

	private static final long serialVersionUID = 1L;

	public static final int ADDED = 0;

	public static final int REMOVED = 1;

	private final int eventType;

	private final EProblem problem;

	public ProblemsEvent(ProblemsManager source, int eventType, EProblem problem) {
		super(source);

		this.eventType = eventType;
		this.problem = problem;
	}

	public ProblemsManager getSource() {
		return (ProblemsManager) super.getSource();
	}

	public int getEventType() {
		return eventType;
	}

	public EProblem getProblem() {
		return problem;
	}
}
