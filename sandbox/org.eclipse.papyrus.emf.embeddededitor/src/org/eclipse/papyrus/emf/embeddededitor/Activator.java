package org.eclipse.papyrus.emf.embeddededitor;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.papyrus.emf.embeddededitor.editor.EmbeddedEditor;
import org.eclipse.papyrus.log.LogHelper;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.editor.emf"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	public static LogHelper log;

	private CustomizationManager fCustomizationManager;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);

		//		if(true) {
		//			return;
		//		}

		Shell shell = new Shell(Display.getCurrent());
		shell.setLayout(new FillLayout());
		shell.setSize(400, 300);

		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResource(URI.createPlatformResourceURI("Test/seq_diagram2.uml", true), true);

			EmbeddedEditor editor = new EmbeddedEditor(resourceSet);
			editor.createWidget(shell);
		} catch (Exception ex) {
			log.error(ex);
		}

		shell.open();

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	 * @return the customization manager in charge to adapt element in modisco
	 */
	public CustomizationManager getCustomizationManager() {
		if(this.fCustomizationManager == null) {
			this.fCustomizationManager = new CustomizationManager();
			init(this.fCustomizationManager);
		}
		return this.fCustomizationManager;
	}

	private void init(final CustomizationManager customizationManager) {
		customizationManager.setShowContainer(false);
		customizationManager.setShowDerivedLinks(false);
		customizationManager.setShowEmptyLinks(false);

		try {
			List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
			for(MetamodelView metamodelView : registryDefaultCustomizations) {
				customizationManager.registerCustomization(metamodelView);
			}

			customizationManager.loadCustomizations();
		} catch (Throwable e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

}
