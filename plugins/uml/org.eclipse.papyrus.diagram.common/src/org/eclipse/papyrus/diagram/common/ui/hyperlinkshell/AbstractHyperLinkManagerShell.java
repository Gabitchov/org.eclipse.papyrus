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
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The Class AbstractHyperLinkManagerShell. This Class has been generated from VisualEditor. Do not
 * modify it manually by adding behavior! you will lose the capacity to open with VE. So this class
 * is abstract and it contains set of getter in order to connect behavior in subclasses
 */
public abstract class AbstractHyperLinkManagerShell {

	/** The hyper link shell. */
	protected Shell hyperLinkShell = null; // @jve:decl-index=0:visual-constraint="-2,74"

	/** The c tab folder. */
	private CTabFolder cTabFolder = null;

	/** The document composite. */
	private Composite documentComposite = null;

	/** The diagram composite. */
	private Composite diagramComposite = null;

	/** The up document button. */
	private Button upDocumentButton = null;

	/** The down document button. */
	private Button downDocumentButton = null;

	/** The Hyperlink composite. */
	private Composite HyperlinkComposite = null;

	/** The diagram listtable. */
	private Table diagramListtable = null;

	/** The up diagram button. */
	private Button upDiagramButton = null;

	/** The down diagram button. */
	private Button downDiagramButton = null;

	/** The Diagram list label. */
	private CLabel DiagramListLabel = null;

	/** The new diagrambutton. */
	private Button newDiagrambutton = null;

	/** The remove diagram button. */
	private Button removeDiagramButton = null;

	/** The document table. */
	private Table documentTable = null;

	/** The new document button. */
	private Button newDocumentButton = null;

	/** The remove document button. */
	private Button removeDocumentButton = null;

	/** The document list label. */
	private Label documentListLabel = null;

	/** The hyperlink table. */
	private Table hyperlinkTable = null;

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
		createDocumentComposite();
		createDiagramComposite();
		createHyperlinkComposite();
		CTabItem cTabItem2 = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem2.setText("Diagram hyperlinks");
		cTabItem2.setControl(diagramComposite);
		CTabItem cTabItem1 = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem1.setControl(documentComposite);
		cTabItem1.setText("Document hyperlinks");
		CTabItem cTabItem11 = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem11.setControl(HyperlinkComposite);
		cTabItem11.setText("Web hyperlinks");

	}

	/**
	 * This method initializes diagramComposite.
	 */
	private void createDiagramComposite() {
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.verticalAlignment = GridData.CENTER;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.verticalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalSpan = 6;
		gridData1.horizontalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = false;
		diagramComposite = new Composite(cTabFolder, SWT.NONE);
		diagramComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		diagramComposite.setLayout(gridLayout);
		DiagramListLabel = new CLabel(diagramComposite, SWT.SHADOW_NONE);
		DiagramListLabel.setText("List of diagram hyperlinks:");
		DiagramListLabel.setEnabled(false);
		DiagramListLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler = new Label(diagramComposite, SWT.NONE);
		diagramListtable = new Table(diagramComposite, SWT.BORDER | SWT.MULTI);
		newDiagrambutton = new Button(diagramComposite, SWT.NONE);
		newDiagrambutton.setText("");
		// newDiagrambutton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Add_16x16.gif"));
		newDiagrambutton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Add_16x16.gif").createImage());
		newDiagrambutton.setLayoutData(gridData4);
		diagramListtable.setHeaderVisible(false);
		diagramListtable.setToolTipText("set of  diagram hyperlinks ");
		diagramListtable.setLayoutData(gridData1);
		diagramListtable.setLinesVisible(false);
		modifyDiagramButton = new Button(diagramComposite, SWT.NONE);
		// modifyDiagramButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Modify.gif"));
		modifyDiagramButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Modify.gif").createImage());

		removeDiagramButton = new Button(diagramComposite, SWT.NONE);
		removeDiagramButton.setText("");
		// removeDiagramButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Delete_16x16.gif"));
		removeDiagramButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Delete_16x16.gif").createImage());

		upDiagramButton = new Button(diagramComposite, SWT.NONE);
		// upDiagramButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/ArrowUp_16x16.gif"));
		upDiagramButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/ArrowUp_16x16.gif").createImage());

		upDiagramButton.setLayoutData(gridData2);
		downDiagramButton = new Button(diagramComposite, SWT.NONE);
		// downDiagramButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/ArrowDown_16x16.gif"));
		downDiagramButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/ArrowDown_16x16.gif").createImage());

		downDiagramButton.setLayoutData(gridData3);
	}

	/**
	 * This method initializes documentComposite.
	 */
	private void createDocumentComposite() {
		GridData gridData5 = new GridData();
		gridData5.verticalSpan = 6;
		gridData5.grabExcessVerticalSpace = true;
		gridData5.horizontalAlignment = GridData.FILL;
		gridData5.verticalAlignment = GridData.FILL;
		gridData5.grabExcessHorizontalSpace = true;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 3;
		documentComposite = new Composite(cTabFolder, SWT.NONE);
		documentComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		documentComposite.setLayout(gridLayout1);
		documentListLabel = new Label(documentComposite, SWT.NONE);
		documentListLabel.setText("List of document hyperlinks:");
		documentListLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler1 = new Label(documentComposite, SWT.NONE);
		Label filler4 = new Label(documentComposite, SWT.NONE);
		documentTable = new Table(documentComposite, SWT.BORDER | SWT.MULTI);
		documentTable.setToolTipText("set of  diagram hyperlinks ");
		documentTable.setLinesVisible(false);
		documentTable.setLayoutData(gridData5);
		documentTable.setHeaderVisible(false);
		newDocumentButton = new Button(documentComposite, SWT.NONE);
		Label filler2 = new Label(documentComposite, SWT.NONE);
		modifyDocumentButton1 = new Button(documentComposite, SWT.NONE);
		// modifyDocumentButton1.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Modify.gif"));
		modifyDocumentButton1.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Modify.gif").createImage());

		Label filler16 = new Label(documentComposite, SWT.NONE);
		removeDocumentButton = new Button(documentComposite, SWT.NONE);
		Label filler3 = new Label(documentComposite, SWT.NONE);
		// newDocumentButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Add_16x16.gif"));
		newDocumentButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Add_16x16.gif").createImage());
		newDocumentButton.setText("");

		// removeDocumentButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Delete_16x16.gif"));
		removeDocumentButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Delete_16x16.gif").createImage());

		removeDocumentButton.setText("");
		upDocumentButton = new Button(documentComposite, SWT.NONE);
		// upDocumentButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/ArrowUp_16x16.gif"));
		upDocumentButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/ArrowUp_16x16.gif").createImage());

		Label filler5 = new Label(documentComposite, SWT.NONE);
		downDocumentButton = new Button(documentComposite, SWT.NONE);
		// downDocumentButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/ArrowDown_16x16.gif"));
		downDocumentButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/ArrowDown_16x16.gif").createImage());

	}

	/**
	 * This method initializes HyperlinkComposite.
	 */
	private void createHyperlinkComposite() {
		GridData gridData7 = new GridData();
		gridData7.horizontalAlignment = GridData.FILL;
		gridData7.grabExcessHorizontalSpace = false;
		gridData7.grabExcessVerticalSpace = false;
		gridData7.verticalAlignment = GridData.CENTER;
		GridData gridData6 = new GridData();
		gridData6.verticalSpan = 6;
		gridData6.verticalAlignment = GridData.FILL;
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.grabExcessVerticalSpace = true;
		gridData6.horizontalSpan = 3;
		gridData6.horizontalAlignment = GridData.FILL;
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.numColumns = 5;
		HyperlinkComposite = new Composite(cTabFolder, SWT.NONE);
		HyperlinkComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		HyperlinkComposite.setLayout(gridLayout3);
		Label filler628 = new Label(HyperlinkComposite, SWT.NONE);
		hyperlinkListlabel = new Label(HyperlinkComposite, SWT.NONE);
		hyperlinkListlabel.setText("List of web hyperlinks:");
		hyperlinkListlabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler626 = new Label(HyperlinkComposite, SWT.NONE);
		Label filler632 = new Label(HyperlinkComposite, SWT.NONE);
		Label filler627 = new Label(HyperlinkComposite, SWT.NONE);
		hyperlinkTable = new Table(HyperlinkComposite, SWT.BORDER | SWT.MULTI);
		hyperlinkTable.setHeaderVisible(false);
		hyperlinkTable.setLayoutData(gridData6);
		hyperlinkTable.setLinesVisible(false);
		newhyperlinkButton = new Button(HyperlinkComposite, SWT.NONE);
		// newhyperlinkButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Add_16x16.gif"));
		newhyperlinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Add_16x16.gif").createImage());

		newhyperlinkButton.setText("");
		Label filler622 = new Label(HyperlinkComposite, SWT.NONE);
		modifyHyperlinkButton = new Button(HyperlinkComposite, SWT.NONE);
		// modifyHyperlinkButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Modify.gif"));
		modifyHyperlinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Modify.gif").createImage());

		Label filler15 = new Label(HyperlinkComposite, SWT.NONE);
		removeHyperLinkButton = new Button(HyperlinkComposite, SWT.NONE);
		// removeHyperLinkButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Delete_16x16.gif"));
		removeHyperLinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/Delete_16x16.gif").createImage());

		removeHyperLinkButton.setText("");
		Label filler621 = new Label(HyperlinkComposite, SWT.NONE);
		upHyperLinkWebButton = new Button(HyperlinkComposite, SWT.NONE);
		// upHyperLinkWebButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/ArrowUp_16x16.gif"));
		upHyperLinkWebButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
				"/icons/obj16/ArrowUp_16x16.gif").createImage());

		Label filler620 = new Label(HyperlinkComposite, SWT.NONE);
		downHyperLinkWebbutton = new Button(HyperlinkComposite, SWT.NONE);
		// downHyperLinkWebbutton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/ArrowDown_16x16.gif"));
		downHyperLinkWebbutton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin(
				"org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowDown_16x16.gif").createImage());

	}

	/**
	 * This method initializes hyperLinkShell.
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
		Label filler13 = new Label(hyperLinkShell, SWT.NONE);
		Label filler6 = new Label(hyperLinkShell, SWT.NONE);
		Label filler7 = new Label(hyperLinkShell, SWT.NONE);
		Label filler8 = new Label(hyperLinkShell, SWT.NONE);
		Label filler9 = new Label(hyperLinkShell, SWT.NONE);
		Label filler18 = new Label(hyperLinkShell, SWT.NONE);
		Label filler11 = new Label(hyperLinkShell, SWT.NONE);
		Label filler12 = new Label(hyperLinkShell, SWT.NONE);
		Label filler10 = new Label(hyperLinkShell, SWT.NONE);
		Label filler14 = new Label(hyperLinkShell, SWT.NONE);
		OkButton = new Button(hyperLinkShell, SWT.NONE);
		OkButton.setText("Ok");
		OkButton.setLayoutData(gridData9);
		cancelButton = new Button(hyperLinkShell, SWT.NONE);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(gridData8);
	}

	/**
	 * @return the downHyperLinkWebbutton
	 */
	public Button getDownHyperLinkWebbutton() {
		return downHyperLinkWebbutton;
	}

	/**
	 * @param downHyperLinkbutton
	 *            the downHyperLinkbutton to set
	 */
	// @unused
	public void setDownHyperLinkbutton(Button downHyperLinkbutton) {
		this.downHyperLinkWebbutton = downHyperLinkbutton;
	}

	/**
	 * @return the hyperlinkListlabel
	 */
	// @unused
	public Label getHyperlinkListlabel() {
		return hyperlinkListlabel;
	}

	/**
	 * @param hyperlinkListlabel
	 *            the hyperlinkListlabel to set
	 */
	// @unused
	public void setHyperlinkListlabel(Label hyperlinkListlabel) {
		this.hyperlinkListlabel = hyperlinkListlabel;
	}

	/**
	 * @return the hyperLinkShell
	 */
	public Shell getHyperLinkShell() {
		return hyperLinkShell;
	}

	/**
	 * @return the newhyperlinkButton
	 */
	public Button getNewhyperlinkButton() {
		return newhyperlinkButton;
	}

	/**
	 * @return the removeHyperLinkButton
	 */
	public Button getRemoveHyperLinkButton() {
		return removeHyperLinkButton;
	}

	/**
	 * @return the upHyperLinkWebButton
	 */
	public Button getUpHyperLinkWebButton() {
		return upHyperLinkWebButton;
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

	/**
	 * @return the modifyHyperlinkButton
	 */
	public Button getModifyHyperlinkButton() {
		return modifyHyperlinkButton;
	}

	/**
	 * @return the modifyDocumentButton1
	 */
	public Button getModifyDocumentButton1() {
		return modifyDocumentButton1;
	}

	/**
	 * @return the modifyDiagramButton
	 */
	public Button getModifyDiagramButton() {
		return modifyDiagramButton;
	}

	/**
	 * @return the diagramListtable
	 */
	public Table getDiagramListtable() {
		return diagramListtable;
	}

	/**
	 * @return the documentTable
	 */
	public Table getDocumentTable() {
		return documentTable;
	}

	/**
	 * @return the hyperlinkTable
	 */
	public Table getHyperlinkTable() {
		return hyperlinkTable;
	}

	/**
	 * @return the upDocumentButton
	 */
	protected Button getUpDocumentButton() {
		return upDocumentButton;
	}

	/**
	 * @return the downDocumentButton
	 */
	protected Button getDownDocumentButton() {
		return downDocumentButton;
	}

	/**
	 * @return the upDiagramButton
	 */
	protected Button getUpDiagramButton() {
		return upDiagramButton;
	}

	/**
	 * @return the downDiagramButton
	 */
	protected Button getDownDiagramButton() {
		return downDiagramButton;
	}

	/**
	 * @return the newDiagrambutton
	 */
	protected Button getNewDiagrambutton() {
		return newDiagrambutton;
	}

	/**
	 * @return the newDocumentButton
	 */
	protected Button getNewDocumentButton() {
		return newDocumentButton;
	}

	/**
	 * @return the removeDiagramButton
	 */
	protected Button getRemoveDiagramButton() {
		return removeDiagramButton;
	}

	/**
	 * @return the removeDocumentButton
	 */
	protected Button getRemoveDocumentButton() {
		return removeDocumentButton;
	}

}
