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
package org.eclipse.papyrus.uml.modelrepair.validation;

import org.eclipse.core.runtime.IStatus;


/**
 * A pluggable validation check that runs before the profile switch operation is performed.
 */
public interface IProfileSwitchPrecondition {

	/**
	 * Validates the profile switch operation described by the given context. This method is invoked on a background thread, so any UI
	 * interaction performed by the pre-condition check needs to take that into account.
	 * 
	 * @param ctx
	 *        the profile-switch context
	 * 
	 * @return a status describing the readiness of the context for a profile switch. An error status will prevent the profile switch from proceeding.
	 *         A warning status will be reported to the user and require confirmation before proceeding with the profile switch. An informational
	 *         status may be displayed to the user but needs not be acknowledged
	 */
	IStatus validateProfileSwitch(ProfileSwitchContext ctx);
}
