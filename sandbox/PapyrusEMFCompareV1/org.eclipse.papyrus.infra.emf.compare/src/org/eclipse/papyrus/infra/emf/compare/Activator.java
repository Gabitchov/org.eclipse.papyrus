/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.emf.compare.service.SaveEMFCompareListener;
import org.eclipse.papyrus.infra.emf.compare.utils.CompareEditorConfiguration;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf.compare"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/** listener on the command service to catch the save and saveAll action */
	private IExecutionListener commandServiceListener;

	/** this map contains the compare editor configuration */
	private static final Map<IEditorPart, CompareEditorConfiguration> configuration = new HashMap<IEditorPart, CompareEditorConfiguration>();

	public static LogHelper log;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		Activator.plugin = this;
		Activator.log = new LogHelper(this);
		//we add a listener on the command service
		this.commandServiceListener = new SaveEMFCompareListener();
		final ICommandService service = (ICommandService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		service.addExecutionListener(this.commandServiceListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.plugin = null;
		//we remove the listener on the command service
		final ICommandService service = (ICommandService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		service.removeExecutionListener(this.commandServiceListener);
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
	}

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the configuration mapped with this editor (can be <code>null</code>)
	 */
	public CompareEditorConfiguration getConfigurationFor(final IEditorPart editor) {
		return Activator.configuration.get(editor);
	}

	/**
	 * map an editor and a configuration
	 * 
	 * @param editor
	 *        an editor
	 * @param configuration
	 *        a configuration
	 */
	public void addConfiguration(final IEditorPart editor, final CompareEditorConfiguration configuration) {
		Activator.configuration.put(editor, configuration);
	}

	/**
	 * Remove the configuration
	 * 
	 * @param editor
	 *        a editor
	 */
	public void removeConfiguration(final IEditorPart editor) {
		Activator.configuration.remove(editor);
	}

}
