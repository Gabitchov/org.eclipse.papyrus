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
package org.eclipse.papyrus.infra.services.markerlistener;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A protocol for markers that annotate elements in {@link Resource}s with
 * information, often used for problems. It is an analogue of the Eclipse
 * {@link IMarker} API for resources in the workspace.
 */
public interface IPapyrusMarker {

	/**
	 * Severity marker attribute.
	 * 
	 * @see #SEVERITY_ERROR
	 * @see #SEVERITY_WARNING
	 * @see #SEVERITY_INFO
	 * @see #getAttribute(String, int)
	 */
	String SEVERITY = IMarker.SEVERITY;

	/**
	 * Message marker attribute. A localized string describing the nature of the
	 * marke.
	 * 
	 * @see #getAttribute(String, String)
	 */
	String MESSAGE = IMarker.MESSAGE;

	/**
	 * Location marker attribute. The location is a human-readable (localized)
	 * string which can be used to distinguish between markers on a resource. As
	 * such it should be concise and aimed at users.
	 * 
	 * @see #getAttribute(String, String)
	 */
	String LOCATION = IMarker.LOCATION;

	/**
	 * Priority marker attribute.
	 * 
	 * @see #PRIORITY_HIGH
	 * @see #PRIORITY_NORMAL
	 * @see #PRIORITY_LOW
	 * @see #getAttribute(String, int)
	 */
	String PRIORITY = IMarker.PRIORITY;

	/**
	 * High priority constant (value 2).
	 * 
	 * @see #getAttribute(String, int)
	 */
	int PRIORITY_HIGH = IMarker.PRIORITY_HIGH;

	/**
	 * Normal priority constant (value 1).
	 * 
	 * @see #getAttribute(String, int)
	 */
	int PRIORITY_NORMAL = IMarker.PRIORITY_NORMAL;

	/**
	 * Low priority constant (value 0).
	 * 
	 * @see #getAttribute(String, int)
	 */
	int PRIORITY_LOW = IMarker.PRIORITY_LOW;

	/**
	 * Error severity constant (value 2) indicating an error state.
	 * 
	 * @see #getAttribute(String, int)
	 */
	int SEVERITY_ERROR = IMarker.SEVERITY_ERROR;

	/**
	 * Warning severity constant (value 1) indicating a warning.
	 * 
	 * @see #getAttribute(String, int)
	 */
	int SEVERITY_WARNING = IMarker.SEVERITY_WARNING;

	/**
	 * Info severity constant (value 0) indicating information only.
	 * 
	 * @see #getAttribute(String, int)
	 */
	int SEVERITY_INFO = IMarker.SEVERITY_INFO;

	Resource getResource();

	EObject getEObject();

	boolean exists();

	String getType()
			throws CoreException;

	String getTypeLabel()
			throws CoreException;

	void delete()
			throws CoreException;

	Object getAttribute(String name)
			throws CoreException;

	String getAttribute(String name, String defaultValue);

	boolean getAttribute(String name, boolean defaultValue);

	int getAttribute(String name, int defaultValue);

	Map<String, ?> getAttributes()
			throws CoreException;

	void setAttribute(String name, Object value)
			throws CoreException;

	void setAttribute(String name, String value)
			throws CoreException;

	void setAttribute(String name, boolean value)
			throws CoreException;

	void setAttribute(String name, int value)
			throws CoreException;

	void setAttributes(Map<String, ?> attributes)
			throws CoreException;

	/**
	 * Queries whether an {@code object} is an {@link IPapyrusMarker}
	 * representing the same marker on the same {@linkplain #getResource()
	 * resource} as me.
	 * 
	 * @param object
	 *            an object
	 * 
	 * @return if it is equal to me
	 */
	boolean equals(Object obj);

	int hashCode();

	/**
	 * Obtains a stable string representation of myself that may be used to
	 * identify me uniquely.
	 * 
	 * @return an identifying string representation of myself
	 */
	String toString();
}
