package org.eclipse.papyrus.infra.emf.compare.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.compare.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private Map<Integer,CustomizationManager> editorAndCustomization;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
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

	public CustomizationManager getCustomizationManager(IEditorPart currentEditor){
		CustomizationManager manager;
		Integer hashcode = new Integer(currentEditor.hashCode());
		//TODO verify that the hashcode of editors is a good thing!
		if(editorAndCustomization==null){
			//TODO test Map with Integer as key
			editorAndCustomization = new HashMap<Integer, CustomizationManager>();
		}
		if(editorAndCustomization.containsKey(new Integer(hashcode))){
			manager= editorAndCustomization.get(hashcode);
		}else{
			manager = new CustomizationManager();
			//TODO load some customization?!
		}
		return manager;
	}
}
