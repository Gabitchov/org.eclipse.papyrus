/*
 * 
 */
package org.eclipse.papyrus.uml.modelexplorer;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.facet.infra.facet.validation.EValidatorAdapter;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.UMLPackage;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements org.eclipse.ui.IStartup {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.modelexplorer"; //$NON-NLS-1$

	/** The plug-in shared instance */
	private static Activator plugin;

	/** The log service */
	public static LogHelper log;

	/** Default constructor */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(plugin);
		// register EValidatorAdapter for selected elements
		// TODO: discouraged access
		EValidator.Registry.INSTANCE.put(UMLPackage.eINSTANCE, new EValidatorAdapter());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 * 
	 */
	public void earlyStartup() {

	}
}
