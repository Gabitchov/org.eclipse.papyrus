/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * @author cedric dumoulin
 *
 */
public class Activator implements BundleActivator {

	/** Logging helper */
	public static LogHelper log = new LogHelper();

	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 *
	 * @param context
	 * @throws Exception
	 */
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 *
	 * @param context
	 * @throws Exception
	 */
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
