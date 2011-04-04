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
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
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

	/** The newhyperlink button. */
	protected Button newhyperlinkButton = null;

	/** The remove hyper link button. */
	protected Button removeHyperLinkButton = null;

	/** The up hyper link button. */
	protected Button upHyperLinkWebButton = null;

	/** The down hyper linkbutton. */
	protected Button downHyperLinkWebbutton = null;

	/** The hyperlink listlabel. */
	protected Label hyperlinkListlabel = null;

	/** The Ok button. */
	protected Button OkButton = null;

	/** The cancel button. */
	protected Button cancelButton = null;

	/** The modify hyperlink button. */
	protected Button modifyHyperlinkButton = null;

	/** The modify document button1. */
	protected Button modifyDocumentButton1 = null;

	/** The modify diagram button. */
	protected Button modifyDiagramButton = null;
	protected Table availableHyperLink;
	protected Table defaultHyperLink;

	protected CTabItem tbtmDefaultsHyperlinks;

	protected Button defaultHRight;

	protected Button defaultHleft;

	protected Button defaultHup;

	protected Button defaultHdown;

	protected ArrayList<HyperLinkTab>tabList=new ArrayList<HyperLinkTab>();
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

//	private void defaultHyperlinkComposite(){
//		tbtmDefaultsHyperlinks = new CTabItem(cTabFolder, SWT.NONE);
//		tbtmDefaultsHyperlinks.setText("Defaults HyperLinks");
//		Composite defaultHyperlinkComposite = new Composite(cTabFolder, SWT.NONE);
//		defaultHyperlinkComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
//		tbtmDefaultsHyperlinks.setControl(defaultHyperlinkComposite);
//		
//		Label lblHyperlinks = new Label(defaultHyperlinkComposite, SWT.NONE);
//		lblHyperlinks.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
//		lblHyperlinks.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
//		lblHyperlinks.setBounds(23, 10, 71, 13);
//		lblHyperlinks.setText("HyperLinks:");
//		
//		Label lblDefaultHyperlinksby = new Label(defaultHyperlinkComposite, SWT.NONE);
//		lblDefaultHyperlinksby.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
//		lblDefaultHyperlinksby.setBounds(366, 10, 186, 13);
//		lblDefaultHyperlinksby.setText("Default Hyperlinks (by double-click):");
//		
//		availableHyperLink = new Table(defaultHyperlinkComposite, SWT.BORDER | SWT.FULL_SELECTION);
//		availableHyperLink.setBounds(20, 29, 276, 177);
//		
//		defaultHyperLink = new Table(defaultHyperlinkComposite, SWT.BORDER | SWT.FULL_SELECTION);
//		defaultHyperLink.setBounds(366, 29, 276, 177);
//		
//		defaultHRight = new Button(defaultHyperlinkComposite, SWT.NONE);
//		defaultHRight.setBounds(309, 29, 34, 23);
//		
//		defaultHleft = new Button(defaultHyperlinkComposite, SWT.NONE);
//		defaultHleft.setBounds(309, 68, 34, 23);
//		
//		defaultHup = new Button(defaultHyperlinkComposite, SWT.NONE);
//		defaultHup.setBounds(309, 117, 34, 23);
//		
//		defaultHdown = new Button(defaultHyperlinkComposite, SWT.NONE);
//		defaultHdown.setBounds(309, 158, 34, 23);
//	}

	/**
	 * This method initializes HyperlinkComposite.
	 */

	/**
	 * This method initializes hyperLinkShell.
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
		hyperLinkShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell());

		// hyperLinkShell = new Shell();
		hyperLinkShell.setText("HyperLink");
		hyperLinkShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createCTabFolder();
		hyperLinkShell.setLayout(gridLayout2);
		hyperLinkShell.setSize(new Point(687, 308));
		OkButton = new Button(hyperLinkShell, SWT.NONE);
		OkButton.setText("Ok");
		OkButton.setLayoutData(gridData9);
		cancelButton = new Button(hyperLinkShell, SWT.NONE);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(gridData8);
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
