/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import java.util.ArrayList;

import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * The Class AbstractHyperLinkManagerShell. This Class has been generated from VisualEditor. Do not
 * modify it manually by adding behavior! you will lose the capacity to open with VE. So this class
 * is abstract and it contains set of getter in order to connect behavior in subclasses
 */
public abstract class AbstractHyperLinkManagerShell {

	/** The hyper link shell. */
	protected Shell hyperLinkShell = null;


	public Shell getHyperLinkShell() {
		return hyperLinkShell;
	}

	/** The c tab folder. */
	private CTabFolder cTabFolder = null;


	public CTabFolder getcTabFolder() {
		return cTabFolder;
	}



	/** The Ok button. */
	protected Button OkButton = null;

	/** The cancel button. */
	protected Button cancelButton = null;



	protected ArrayList<AbstractHyperLinkTab> tabList = new ArrayList<AbstractHyperLinkTab>();

	/**
	 * This method initializes cTabFolder.
	 */
	private void createCTabFolder() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 14;
		gridData.verticalAlignment = GridData.FILL;
		cTabFolder = new CTabFolder(hyperLinkShell, SWT.NONE);
		cTabFolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		cTabFolder.setLayoutData(gridData);


	}



	/**
	 * This method initializes HyperlinkComposite.
	 */

	/**
	 * This method initializes hyperLinkShell.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createHyperLinkShell() {
		GridData gridData9 = new GridData();
		gridData9.grabExcessHorizontalSpace = true;
		gridData9.verticalAlignment = GridData.FILL;
		gridData9.horizontalSpan = 2;
		gridData9.horizontalAlignment = GridData.FILL;
		GridData gridData8 = new GridData();
		gridData8.horizontalAlignment = GridData.FILL;
		gridData8.grabExcessHorizontalSpace = true;
		gridData8.horizontalSpan = 2;
		gridData8.verticalAlignment = GridData.FILL;
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 14;
		gridLayout2.makeColumnsEqualWidth = true;

		// this line has to be commented in order to open with VISUAL EDITOR
		hyperLinkShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.DIALOG_TRIM | SWT.RESIZE);

		// hyperLinkShell = new Shell();
		hyperLinkShell.setText(Messages.AbstractHyperLinkManagerShell_HyperLink);
		hyperLinkShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createCTabFolder();
		hyperLinkShell.setLayout(gridLayout2);
		hyperLinkShell.setSize(new Point(687, 308));
		OkButton = new Button(hyperLinkShell, SWT.NONE);
		OkButton.setText(Messages.AbstractHyperLinkManagerShell_OK);
		OkButton.setLayoutData(gridData9);
		cancelButton = new Button(hyperLinkShell, SWT.NONE);
		cancelButton.setText(Messages.AbstractHyperLinkManagerShell_Cancel);
		cancelButton.setLayoutData(gridData8);

		getHyperLinkShell().pack();
	}

	/**
	 * @return the okButton
	 */
	public Button getOkButton() {
		return OkButton;
	}

	/**
	 * @return the cancelButton
	 */
	public Button getCancelButton() {
		return cancelButton;
	}

}
