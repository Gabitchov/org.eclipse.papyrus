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
package org.eclipse.papyrus.cdo.core.admin;

import java.util.EventObject;


/**
 * This is the PapyrusRepositoryAdminEvent type. Enjoy.
 */
public class PapyrusRepositoryAdminEvent extends EventObject {

	public static final int REPOSITORY_ADDED = 0;

	public static final int REPOSITORY_REMOVED = 1;

	private static final long serialVersionUID = 1L;

	private final int eventType;

	private final String url;

	private final String name;

	public PapyrusRepositoryAdminEvent(PapyrusRepositoryAdminManager source, int eventType, String url, String name) {
		super(source);

		this.eventType = eventType;
		this.url = url;
		this.name = name;
	}

	@Override
	public PapyrusRepositoryAdminManager getSource() {
		return (PapyrusRepositoryAdminManager)super.getSource();
	}

	public int getEventType() {
		return eventType;
	}

	public String getRepositoryURL() {
		return url;
	}

	public String getRepositoryName() {
		return name;
	}
}
