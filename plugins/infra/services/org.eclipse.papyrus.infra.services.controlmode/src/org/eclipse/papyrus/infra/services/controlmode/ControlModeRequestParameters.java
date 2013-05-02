/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.controlmode;


/**
 * This interface will hold all specific parameter used to {@link ControlModeRequest}
 * 
 * @author adaussy
 * 
 */
public interface ControlModeRequestParameters {

	/**
	 * Parameter used to indicated that the action has been launch from UI
	 */
	public static String IS_UI_ACTION = "org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters.IsUIAction";////$NON-NLS-0$

	/**
	 * Base key for referencing a target resource into the request
	 */
	public static String TARGET_RESOURCE = "org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters.TargetResource";////$NON-NLS-0$

	/**
	 * Base key for referencing a source resource into the request
	 */
	public static String SOURCE_RESOURCE = "org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters.SourceResource";////$NON-NLS-0$

	/**
	 * Key used to store moved diagrams into the request
	 */
	public static String MOVED_OPENABLES = "org.eclipse.papyrus.infra.services.controlmode.ControlModeRequestParameters.MovedOpenables";////$NON-NLS-0$

}
