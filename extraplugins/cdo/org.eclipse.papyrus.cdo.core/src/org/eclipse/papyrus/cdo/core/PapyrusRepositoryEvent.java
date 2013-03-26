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
package org.eclipse.papyrus.cdo.core;

import java.util.EventObject;


/**
 * This is the PapyrusRepositoryEvent type. Enjoy.
 */
public class PapyrusRepositoryEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public static final int CONNECTED = 0;

	public static final int DISCONNECTED = 1;

	private final int eventType;

	public PapyrusRepositoryEvent(IPapyrusRepository source, int eventType) {
		super(source);

		this.eventType = eventType;
	}

	@Override
	public IPapyrusRepository getSource() {
		return (IPapyrusRepository)super.getSource();
	}

	public int getEventType() {
		return eventType;
	}
}
