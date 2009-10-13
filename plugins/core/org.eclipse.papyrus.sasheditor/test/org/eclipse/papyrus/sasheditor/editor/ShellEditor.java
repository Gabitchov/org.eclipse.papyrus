/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/**
 * A standalone application testing the Sash system.
 * @author dumoulin
 */
public class ShellEditor {

	protected SashWindowsContainer sashContainer;
	protected ISashWindowsContentProvider contentProvider;
	
	/**
	 * Constructor.
	 * @param parent
	 */
	public ShellEditor(Shell parent) {
		parent.setText(this.getClass().getSimpleName());
		init();
		createPartControl(parent);
		
		// add tabItem
		int count = 0;
		IPageModel tabItem = new MessagePartModel("msg" + count++);
		contentProvider.addPage(tabItem);
		tabItem = new MessagePartModel("msg" + count++);
		contentProvider.addPage(tabItem);
		
		sashContainer.refreshTabs();
	}

	/**
	 * init th class
	 */
	protected void init()
	{
		contentProvider = new SimpleSashWindowsContentProvider();
		sashContainer = new SashWindowsContainer();
		
		initContentProvider();
		sashContainer.setContentProvider(contentProvider);
		
	}
	
	/**
	 * Create some windows.
	 */
	protected void initContentProvider()
	{
		int count = 0;
		IPageModel tabItem = new MessagePartModel("msg" + count++);
		contentProvider.addPage(tabItem);
		
		tabItem = new MessagePartModel("msg0" + count++);
		contentProvider.addPage(tabItem);
	}
	/**
	 * Create SWT control of this class
	 * @param parent
	 */
	protected void createPartControl(Composite parent)
	{
//		Text newText = new Text(parent, SWT.BORDER & SWT.SCROLL_PAGE);
		
		sashContainer.createPartControl(parent);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new ShellEditor(shell);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}

}
