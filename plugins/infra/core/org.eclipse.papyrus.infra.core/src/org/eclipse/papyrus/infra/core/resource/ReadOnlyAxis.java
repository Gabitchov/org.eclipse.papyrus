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

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import com.google.common.collect.Sets;


/**
 * The "read-only-ness" of resources can be partitioned according to a number of othogonal concerns, or <em>axes</em>.
 * Being orthogonal, these concerns are independent, although any particular resource may be considered as read-only
 * according to more than one of these simultaneously (or one or none at all).
 */
public enum ReadOnlyAxis {
	/**
	 * The most basic and obvious axis is the permission, or access control, concern. This typically maps to
	 * permissions in the storage layer (file system, database, network, etc.).
	 */
	PERMISSION,

	/**
	 * Some resources may be considered as read-only for discretionary reasons: there is no obstacle of {@linkplain #PERMISSION permissions}, but
	 * merely that the user is discouraged from making modifications
	 * to such a resource or its contents as a matter of policy.
	 */
	DISCRETION;

	private static final Set<ReadOnlyAxis> ANY_AXIS = Sets.immutableEnumSet(EnumSet.allOf(ReadOnlyAxis.class));

	private static final Set<ReadOnlyAxis> PERMISSION_AXES = Collections.singleton(PERMISSION);

	private static final Set<ReadOnlyAxis> DISCRETION_AXES = Collections.singleton(DISCRETION);

	/**
	 * The set of axes for queries pertaining to any axis. That is to say, the complete set of all axes.
	 */
	public static Set<ReadOnlyAxis> anyAxis() {
		return ANY_AXIS;
	}

	/**
	 * The set of axes for queries pertaining to permission. That is to say, the singleton containing {@link #PERMISSION}.
	 */
	public static Set<ReadOnlyAxis> permissionAxes() {
		return PERMISSION_AXES;
	}

	/**
	 * The set of axes for queries pertaining to discretion. That is to say, the singleton containing {@link #DISCRETION}.
	 */
	public static Set<ReadOnlyAxis> discretionAxes() {
		return DISCRETION_AXES;
	}
}
