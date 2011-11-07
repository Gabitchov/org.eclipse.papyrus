/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import java.net.URL;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class DocViewPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.documentation.view"; //$NON-NLS-1$

	// The shared instance
	private static DocViewPlugin plugin;
	
	/**
	 * The constructor
	 */
	public DocViewPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// load images in the registry
		getImageRegistry().put("EDIT", imageDescriptorFromPlugin(PLUGIN_ID, "icons/edit.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("EXTERNAL_RESOURCE", imageDescriptorFromPlugin(PLUGIN_ID, "icons/externalResource.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("HTML_EDITOR", imageDescriptorFromPlugin(PLUGIN_ID, "icons/htmlEditor.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("MODEL_LINK", imageDescriptorFromPlugin(PLUGIN_ID, "icons/application_link.png")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("TEXT_COLOR", imageDescriptorFromPlugin(PLUGIN_ID, "icons/TextColor.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("TEXT_HIGHLIGHT", imageDescriptorFromPlugin(PLUGIN_ID, "icons/TextHighlight.gif")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("INSERT_ROW", imageDescriptorFromPlugin(PLUGIN_ID, "icons/InsertTableRow.png")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("DELETE_ROW", imageDescriptorFromPlugin(PLUGIN_ID, "icons/DeleteTableRow.png")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("INSERT_COLUMN", imageDescriptorFromPlugin(PLUGIN_ID, "icons/InsertTableCol.png")); //$NON-NLS-1$ //$NON-NLS-2$
		getImageRegistry().put("DELETE_COLUMN", imageDescriptorFromPlugin(PLUGIN_ID, "icons/DeleteTableCol.png")); //$NON-NLS-1$ //$NON-NLS-2$
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
	public static DocViewPlugin getDefault() {
		return plugin;
	}
	
    /**
     * Returns the active workbench shell
     * 
     * @return the active workbench shell
     */
    public static Shell getActiveWorkbenchShell()
    {
        IWorkbenchWindow workBenchWindow = getActiveWorkbenchWindow();
        if (workBenchWindow == null)
        {
            return null;
        }
        return workBenchWindow.getShell();
    }

    /**
     * Returns the active workbench page or <code>null</code> if none.
     * 
     * @return the active workbench page
     */
    public static IWorkbenchPage getActivePage()
    {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window != null)
        {
            return window.getActivePage();
        }
        return null;
    }

    /**
     * Returns the active workbench window
     * 
     * @return the active workbench window
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow()
    {
        if (getDefault() == null)
        {
            return null;
        }
        IWorkbench workBench = getDefault().getWorkbench();
        if (workBench == null)
        {
            return null;
        }
        return workBench.getActiveWorkbenchWindow();
    }

    /**
     * Returns the workspace instance.
     * 
     * @return the current workspace
     */
    public static IWorkspace getWorkspace()
    {
        return ResourcesPlugin.getWorkspace();
    }

    public static IEditorPart getActiveEditor() {
    	IWorkbenchPage page = getActivePage();
    	if (page != null) {
    		return page.getActiveEditor();
    	}
    	return null;
    }

    /**
     * Open an url with the configured web browser in the preferences pages.
     * 
     * @param url the url to open
     */
    public static void openURL(URL url)
    {
        try
        {
            IWorkbenchBrowserSupport support = getDefault().getWorkbench().getBrowserSupport();
            IWebBrowser browser = support.createBrowser(IWorkbenchBrowserSupport.LOCATION_BAR
                    | IWorkbenchBrowserSupport.LOCATION_BAR | IWorkbenchBrowserSupport.STATUS, url.toString(), null,
                    null);
            browser.openURL(url);
        }
        catch (PartInitException pie)
        {

        }
    }

}
