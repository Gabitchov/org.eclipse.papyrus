/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors.richtext;

import java.util.Date;

import org.eclipse.epf.common.ui.AbstractPlugin;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichPlugin;
import org.osgi.framework.BundleContext;

/**
 * The Rich Text plug-in class.
 * 
 * @author Nguyen
 * 
 */
public class RichPlugin extends AbstractPlugin {

	/**
	 * The shared plug-in instance.
	 */
	private static RichPlugin plugin;

	/**
	 * The date and time when this plug-in was started.
	 */
	private Date startTime;

	/**
	 * Default constructor.
	 */
	public RichPlugin() {
		plugin = this;
	}

	/**
	 * @see AbstractPlugin#start(BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		this.startTime = new Date();
	}

	/**
	 * @see AbstractPlugin#stop(BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared plug-in instance.
	 */
	public static RichPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the date and time when this plug-in was started.
	 */
	public Date getStartTime() {
		return this.startTime;
	}
}
