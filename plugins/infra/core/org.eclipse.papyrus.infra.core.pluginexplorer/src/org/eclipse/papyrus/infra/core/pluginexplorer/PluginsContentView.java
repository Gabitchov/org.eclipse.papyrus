/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.pluginexplorer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import org.eclipse.jface.action.AbstractAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.SegmentEvent;
import org.eclipse.swt.events.SegmentListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

/**
 * This represents an Eclipse View displaying reflective information about the loaded Eclipse plugins
 * @author Laurent Wouters
 */
public class PluginsContentView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.infra.core.pluginexplorer.PluginReflectorView";

	private Plugin[] plugins;
	private TreeViewer tree;
	private Text field;
	
	/**
	 * Initializes this view
	 */
	public PluginsContentView() {
		this.plugins = Plugin.getLoadedPlugins();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        parent.setLayout(gridLayout);
        
        field = new Text(parent, SWT.SINGLE | SWT.BORDER);
		field.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		field.addSegmentListener(new SegmentListener(){
			public void getSegments(SegmentEvent event) {
				if (tree != null)
					tree.setContentProvider(new PluginsContentProvider(plugins, field.getText()));
			}
		});
        
        Composite inner = new Composite(parent, SWT.NONE);
        inner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL));
        inner.setLayout(new FillLayout());
        
        tree = new TreeViewer(inner, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        tree.setLabelProvider(new PluginsContentLabelProvider());
        tree.setSorter(getViewerSorter());
        tree.setContentProvider(new PluginsContentProvider(plugins, null));
        tree.setInput(PluginsContentProvider.treeRoot);
        tree.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					Object obj = selection.getFirstElement();
					
					MenuManager menuMgr = new MenuManager();
					Menu menu = menuMgr.createContextMenu(tree.getControl());
					tree.getControl().setMenu(menu);
					getSite().registerContextMenu(menuMgr, tree);
					
					if (obj instanceof PluginEntry)
						fillMenuFor((PluginEntry)obj, menuMgr);
				}
			}
        });
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		field.setFocus();
	}
	
	/**
	 * Gets the viewer sorter for this dialog
	 * @return A viewer sorter
	 */
	private ViewerSorter getViewerSorter() {
		return new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof Bundle) {
					Bundle b1 = (Bundle)e1;
					Bundle b2 = (Bundle)e2;
					return b1.getSymbolicName().compareTo(b2.getSymbolicName());
				} else if (e1 instanceof File) {
					File f1 = (File)e1;
					File f2 = (File)e2;
					return (f1.getName().compareTo(f2.getName()));
				}
				return super.compare(viewer, e1, e2);
			}
		};
	}
	
	private void fillMenuFor(final PluginEntry entry, MenuManager menu) {
		menu.add(new org.eclipse.jface.action.Action("Copy URI to clipboard") {
			@Override
			public void run() {
				StringSelection transferable = new StringSelection(entry.getLogicalPath());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(transferable, null);
			}
		});
	}
}