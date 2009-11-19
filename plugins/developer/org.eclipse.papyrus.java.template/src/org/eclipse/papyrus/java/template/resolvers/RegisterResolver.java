/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.java.template.resolvers;

import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.internal.corext.template.java.CompilationUnitContextType;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.papyrus.java.template.Activator;
import org.eclipse.ui.IStartup;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

/**
 * This class registers the resolver into the ContextTypeRegistry
 * @author tlandre
 *
 */
public class RegisterResolver implements IStartup {

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see IStartup#earlyStartup()
	 * 
	 */
	public void earlyStartup() {
		// check if plug-in org.eclipse.jdt.ui is already active
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		if (bundle != null && bundle.getState() == Bundle.ACTIVE) {
			// register resolvers
			registerResolvers();
		} else {
			// register listener to get informed, when plug-in becomes active
			final BundleContext bundleContext = Activator.getDefault().getBundle().getBundleContext();
			if(bundleContext != null){
				bundleContext.addBundleListener(new BundleListener() {
	
					/* (non-Javadoc)
					 * @see org.osgi.framework.BundleListener#bundleChanged(org.osgi.framework.BundleEvent)
					 */
					public void bundleChanged(final BundleEvent pEvent) {
						Bundle bundle = pEvent.getBundle();
						if (!Activator.PLUGIN_ID.equals(bundle.getSymbolicName())) {
							return;
						}
						if (bundle.getState() == Bundle.ACTIVE) {
							// register resolvers
							registerResolvers();
							bundleContext.removeBundleListener(this);
						}
					}
				});
			}
		}
	}

	/**
	 * 
	 * Internal method to register resolvers with all context types.
	 * 
	 */
	private void registerResolvers() {
		final ContextTypeRegistry codeTemplateContextRegistry = JavaPlugin.getDefault().getTemplateContextRegistry();
		final Iterator ctIter = codeTemplateContextRegistry.contextTypes();
		while (ctIter.hasNext()) {
			Object object = ctIter.next();
			if (object instanceof CompilationUnitContextType) {
				CompilationUnitContextType contextType = (CompilationUnitContextType) object;
				// Add the bundle activator resolver
				contextType.addResolver(new BundleActivatorResolver());
			}
		}
	}
}
