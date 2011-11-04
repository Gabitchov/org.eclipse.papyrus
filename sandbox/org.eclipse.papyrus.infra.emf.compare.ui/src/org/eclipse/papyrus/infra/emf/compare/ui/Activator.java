package org.eclipse.papyrus.infra.emf.compare.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.emf.compare.ui"; //$NON-NLS-1$

	/**the activator*/
	private static Activator plugin;

	/**the part listeners*/
	private static IPartListener2 partListener;

	/**
	 * a map to register a {@link CustomizationManager} for each CompareEditor which uses a Papyrus compare viewer
	 * key : hashcode of the editor
	 * value : the associated CustomizationManager
	 */
	private Map<IEditorPart, CustomizationManager> editorAndCustomization;
	

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
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		addPartListener();
	}

	/*
	 * (non-Javadoc)
	 * 
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

	public CustomizationManager getCustomizationManager(IEditorPart currentEditor) {
		CustomizationManager manager;
		//TODO verify that the hashcode of editors is a good thing!
		if(editorAndCustomization == null) {
			//TODO test Map with Integer as key
			editorAndCustomization = new HashMap<IEditorPart, CustomizationManager>();
		}
		if(editorAndCustomization.containsKey(currentEditor)) {
			manager = editorAndCustomization.get(currentEditor);
		} else {
			manager = new CustomizationManager();
			editorAndCustomization.put(currentEditor, manager);
			//TODO load some customization?!
		}
		return manager;
	}

	/**
	 * add a part listener
	 */
	private void addPartListener() {
		partListener = new IPartListener2() {

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partVisible(IWorkbenchPartReference partRef) {
				//nothing to do
			}

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partOpened(IWorkbenchPartReference partRef) {
				//nothing to do
			}

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partInputChanged(IWorkbenchPartReference partRef) {
				//nothing to do
			}

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partHidden(IWorkbenchPartReference partRef) {
				//nothing to do
			}

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partDeactivated(IWorkbenchPartReference partRef) {
				//nothing to do
			}

			/**
			 * Remove the closed editor from the map {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partClosed(IWorkbenchPartReference partRef) {
				IWorkbenchPart part = partRef.getPart(false);
				if(editorAndCustomization.containsKey(part)) {
					editorAndCustomization.remove(part);
				}
			}

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partBroughtToTop(IWorkbenchPartReference partRef) {
				//nothing to do
			}

			/**
			 * 
			 * {@inheritDoc}
			 * 
			 * @param partRef
			 */
			public void partActivated(IWorkbenchPartReference partRef) {
				//nothing to do
			}
		};
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().addPartListener(this.partListener);
	}

	/**
	 * Removes the part listener
	 */
	private void removePartListener() {
		if(this.partListener != null) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().removePartListener(this.partListener);
		}
	}


}
