/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.preferences;

/**
 * Defines specific preference constants for the UML activity diagram.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IActivityPreferenceConstants {

	/**
	 * the preference for opening the confirmation popup when an attribute property or a parameter
	 * is modified. This popup warns the user that invoking actions will be updated with a pin
	 * reorganization.
	 */
	public static final String PREF_CONFIRM_PIN_SYNC_FROM_PARAMETER = "org.eclipse.papyrus.diagram.activity.confirmPinSyncFromParameter"; //$NON-NLS-1$

	/**
	 * the preference for opening the confirmation popup when a parameter is removed. This popup
	 * warns the user that associated activity parameter nodes will be removed too.
	 */
	public static final String PREF_CONFIRM_ACTIVITY_PARAMETER_SYNC_FROM_PARAMETER = "org.eclipse.papyrus.diagram.activity.confirmActivityParameterSyncFromParameter"; //$NON-NLS-1$
}
