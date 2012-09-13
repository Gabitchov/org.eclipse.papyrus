/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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

import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;


/**
 * The Class AbstractLookForDiagramShell. This Class has been generated from
 * VisualEditor. Do not modify it manually by adding behavior! you will lose the
 * capacity to open with VE. So this class is abstract and it contains set of
 * getter in order to connect behavior in subclasses
 */
public class AbstractLookForEditorShell {

	/** The lookfor shell. */
	private Shell lookforShell = null; // @jve:decl-index=0:visual-constraint="108,60"

	/** The c tab folder. */
	private CTabFolder cTabFolder = null;

	/** The diagram listcomposite. */
	private Composite diagramListcomposite = null;

	/** The tree viewcomposite. */
	private Composite treeViewcomposite = null;

	/** The modeltree. */
	private final Tree modeltree = null;

	/** The new diagrambutton. */
	private Button newDiagrambutton = null;

	/** The remove diagrambutton. */
	private Button removeDiagrambutton = null;

	/** The O kbutton. */
	private Button OKbutton = null;

	/** The cancelbutton. */
	private Button cancelbutton = null;

	/** The diagram listtree. */
	private final Tree diagramListtree = null;

	/** The diagramfiltered tree. */
	private FilteredTree diagramfilteredTree = null;

	/** The mode filtered tree. */
	private FilteredTree modeFilteredTree = null;

	/** The c label. */
	private CLabel cLabel = null;

	/**
	 * This method initializes lookforShell.
	 */
	protected void createLookforShell() {
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = false;
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.verticalAlignment = GridData.CENTER;
		gridData1.grabExcessVerticalSpace = false;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 5;
		gridLayout1.makeColumnsEqualWidth = true;
		// this line has to be commented in order to open with VISUAL EDITOR
		lookforShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.DIALOG_TRIM | SWT.RESIZE);

		// lookforShell = new Shell();
		lookforShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createCTabFolder();
		lookforShell.setLayout(gridLayout1);
		lookforShell.setSize(new Point(501, 313));
		new Label(lookforShell, SWT.NONE);
		new Label(lookforShell, SWT.NONE);
		new Label(lookforShell, SWT.NONE);
		OKbutton = new Button(lookforShell, SWT.NONE);
		OKbutton.setText(Messages.AbstractLookForEditorShell_OK);
		OKbutton.setLayoutData(gridData1);
		OKbutton.setEnabled(false);
		cancelbutton = new Button(lookforShell, SWT.NONE);
		cancelbutton.setText(Messages.AbstractLookForEditorShell_Cancel);
		cancelbutton.setLayoutData(gridData2);
	}

	/**
	 * This method initializes cTabFolder.
	 */
	protected void createCTabFolder() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 5;
		gridData.verticalAlignment = GridData.FILL;
		cTabFolder = new CTabFolder(lookforShell, SWT.NONE);
		cTabFolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		cTabFolder.setLayoutData(gridData);
		createDiagramListcomposite();
		createTreeViewcomposite();
		CTabItem cTabItem = new CTabItem(cTabFolder, SWT.None);
		cTabItem.setControl(diagramListcomposite);
		cTabItem.setText(Messages.AbstractLookForEditorShell_EditorsList);//TODO change this name into Editor List
		CTabItem cTabItem1 = new CTabItem(cTabFolder, SWT.None);
		cTabItem1.setText(Messages.AbstractLookForEditorShell_TreeView);
		cTabItem1.setControl(treeViewcomposite);
	}

	/**
	 * This method initializes diagramListcomposite.
	 */
	private void createDiagramListcomposite() {
		GridLayout gridLayout2 = new GridLayout();
		diagramListcomposite = new Composite(cTabFolder, SWT.BORDER);
		diagramListcomposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createDiagramfilteredTree();
		diagramListcomposite.setLayout(gridLayout2);
	}

	/**
	 * This method initializes treeViewcomposite.
	 */
	private void createTreeViewcomposite() {
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment = GridData.FILL;
		gridData5.verticalAlignment = GridData.CENTER;
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		treeViewcomposite = new Composite(cTabFolder, SWT.NONE);
		treeViewcomposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createModelFilteredTree();
		treeViewcomposite.setLayout(gridLayout);
		newDiagrambutton = new Button(treeViewcomposite, SWT.NONE);
		newDiagrambutton.setText(Messages.AbstractLookForEditorShell_New);
		newDiagrambutton.setLayoutData(gridData4);
		removeDiagrambutton = new Button(treeViewcomposite, SWT.NONE);
		removeDiagrambutton.setText(Messages.AbstractLookForEditorShell_Remove);
		removeDiagrambutton.setLayoutData(gridData5);
		cLabel = new CLabel(treeViewcomposite, SWT.NONE);
		cLabel.setText("   "); //$NON-NLS-1$
		cLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	}

	/**
	 * Gets the modeltree.
	 * 
	 * @return the modeltree
	 */
	// @unused
	protected Tree getModeltree() {
		return modeltree;
	}

	/**
	 * Gets the new diagrambutton.
	 * 
	 * @return the newDiagrambutton
	 */
	protected Button getNewDiagrambutton() {
		return newDiagrambutton;
	}

	/**
	 * Sets the new diagrambutton.
	 * 
	 * @param newDiagrambutton
	 *        the newDiagrambutton to set
	 */
	// @unused
	protected void setNewDiagrambutton(Button newDiagrambutton) {
		this.newDiagrambutton = newDiagrambutton;
	}

	/**
	 * Gets the remove diagrambutton.
	 * 
	 * @return the removeDiagrambutton
	 */
	protected Button getRemoveDiagrambutton() {
		return removeDiagrambutton;
	}

	/**
	 * Sets the remove diagrambutton.
	 * 
	 * @param removeDiagrambutton
	 *        the removeDiagrambutton to set
	 */
	// @unused
	protected void setRemoveDiagrambutton(Button removeDiagrambutton) {
		this.removeDiagrambutton = removeDiagrambutton;
	}

	/**
	 * Gets the o kbutton.
	 * 
	 * @return the oKbutton
	 */
	protected Button getOKbutton() {
		return OKbutton;
	}

	/**
	 * Sets the o kbutton.
	 * 
	 * @param oKbutton
	 *        the oKbutton to set
	 */
	// @unused
	protected void setOKbutton(Button oKbutton) {
		OKbutton = oKbutton;
	}

	/**
	 * Gets the cancelbutton.
	 * 
	 * @return the cancelbutton
	 */
	protected Button getCancelbutton() {
		return cancelbutton;
	}

	/**
	 * Sets the cancelbutton.
	 * 
	 * @param cancelbutton
	 *        the cancelbutton to set
	 */
	// @unused
	protected void setCancelbutton(Button cancelbutton) {
		this.cancelbutton = cancelbutton;
	}

	/**
	 * Gets the diagram listtree.
	 * 
	 * @return the diagramListtree
	 */
	// @unused
	protected Tree getDiagramListtree() {
		return diagramListtree;
	}

	/**
	 * Gets the lookfor shell.
	 * 
	 * @return the lookforShell
	 */
	protected Shell getLookforShell() {
		return lookforShell;
	}

	/**
	 * Sets the lookfor shell.
	 * 
	 * @param lookforShell
	 *        the lookforShell to set
	 */
	// @unused
	protected void setLookforShell(Shell lookforShell) {
		this.lookforShell = lookforShell;
	}

	/**
	 * This method initializes diagramfilteredTree.
	 */
	private void createDiagramfilteredTree() {
		GridData gridData6 = new GridData();
		gridData6.horizontalAlignment = GridData.FILL;
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.grabExcessVerticalSpace = true;
		gridData6.verticalAlignment = GridData.FILL;
		diagramfilteredTree = new FilteredTree(diagramListcomposite, SWT.BORDER, new PatternFilter(), true);
		diagramfilteredTree.setLayoutData(gridData6);
	}

	/**
	 * This method initializes filteredTree.
	 */
	private void createModelFilteredTree() {
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.grabExcessVerticalSpace = true;
		gridData3.verticalSpan = 3;
		gridData3.verticalAlignment = GridData.FILL;
		modeFilteredTree = new FilteredTree(treeViewcomposite, SWT.BORDER, new PatternFilter(), true);
		modeFilteredTree.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		modeFilteredTree.setLayoutData(gridData3);
	}

	/**
	 * Gets the diagramfiltered tree.
	 * 
	 * @return the diagramfilteredTree
	 */
	protected FilteredTree getDiagramfilteredTree() {
		return diagramfilteredTree;
	}

	/**
	 * Gets the mode filtered tree.
	 * 
	 * @return the modeFilteredTree
	 */
	protected FilteredTree getModeFilteredTree() {
		return modeFilteredTree;
	}

}
