/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.environment;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.moka.MokaActivator;
import org.eclipse.papyrus.moka.ui.preferences.MokaPreferencePage;
import org.eclipse.uml2.uml.Behavior;

public class MokaEnvironment {

	public final static String ENGINE_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.engine"; //$NON-NLS-1$

	// Logging facility provided by Papyrus
	public static LogHelper log;

	// TODO 1. Connect this with preferences
	// TODO 2. It could be useful to relax the type of the parameter 
	// (e.g., could be an active class, where the engine would implicitly instantiate that
	// class and start its classifier behavior)
	public static void executeBehavior(Behavior behavior) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(ENGINE_EXTENSION_POINT_ID);
		try {
			IConfigurationElement e = null;
			String selectedExecutionEngine = "" + MokaActivator.getDefault().getPreferenceStore().getString(MokaPreferencePage.PREF_EXECUTION_ENGINE); //$NON-NLS-1$
			for(int i = 0; i < config.length; i++) {
				if(config[i].getNamespaceIdentifier().equals(selectedExecutionEngine))
					e = config[i];
			}
			final Object o = e.createExecutableExtension("class"); //$NON-NLS-1$
			executeExtension(o, behavior);
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	protected static void executeExtension(final Object o, final Behavior behavior) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				System.out.println("Exception in execution of the behavior"); //$NON-NLS-1$
			}

			public void run() throws Exception {
				((IExecutionEngine)o).start(behavior);
			}
		};
		SafeRunner.run(runnable);
	}
}
