/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.resource;

import java.util.EventObject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;


/**
 * This is the ReadOnlyEvent type. Enjoy.
 */
public class ReadOnlyEvent extends EventObject {

	public static final int RESOURCE_READ_ONLY_STATE_CHANGED = 0;

	public static final int OBJECT_READ_ONLY_STATE_CHANGED = 1;

	private static final long serialVersionUID = 1L;

	private final int eventType;

	private final ReadOnlyAxis axis;
	
	private final URI resourceURI;

	private final EObject object;

	private final boolean readOnly;

	private ReadOnlyEvent(IReadOnlyHandler2 source, int eventType, ReadOnlyAxis axis, URI resourceURI, EObject object, boolean readOnly) {
		super(source);

		this.eventType = eventType;
		this.axis = axis;
		this.resourceURI = resourceURI;
		this.object = object;
		this.readOnly = readOnly;
	}

	public ReadOnlyEvent(IReadOnlyHandler2 source, ReadOnlyAxis axis, URI resourceURI, boolean readOnly) {
		this(source, RESOURCE_READ_ONLY_STATE_CHANGED, axis, resourceURI, null, readOnly);
	}

	public ReadOnlyEvent(IReadOnlyHandler2 source, ReadOnlyAxis axis, EObject object, boolean readOnly) {
		this(source, RESOURCE_READ_ONLY_STATE_CHANGED, axis, null, object, readOnly);
	}

	public IReadOnlyHandler2 getHandler() {
		return (IReadOnlyHandler2)getSource();
	}

	public int getEventType() {
		return eventType;
	}
	
	public ReadOnlyAxis getAxis() {
		return axis;
	}

	public URI getResourceURI() {
		return resourceURI;
	}

	public EObject getObject() {
		return object;
	}

	public boolean isReadOnly() {
		return readOnly;
	}
}
