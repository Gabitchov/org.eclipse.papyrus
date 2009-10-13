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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;


/**
 * The Class AbstractEditHyperlinkDiagramShell.
 *  This Class has been generated from VisualEditor.
 * Do not modify it manually by adding behavior! you will lose the capacity to open with VE.
 * So this class is abstract and it contains set of getter in order to connect behavior in subclasses
 
 */
public class AbstractEditHyperlinkDiagramShell {

	/** The Constant OBJECT_LABEL. */
	protected static final String OBJECT_LABEL = "Diagram";
	
	/** The edit hyperlink shell. */
	private Shell editHyperlinkShell = null;  //  @jve:decl-index=0:visual-constraint="44,36"
	
	/** The Ok button. */
	private Button OkButton = null;
	
	/** The cancel button. */
	private Button cancelButton = null;
	
	/** The tooltip input text. */
	private Text tooltipInputText = null;
	
	/** The tooltip input label. */
	private CLabel tooltipInputLabel = null;
	
	/** The Object labeltext. */
	private Text ObjectLabeltext = null;
	
	/** The Objectc label. */
	private CLabel ObjectcLabel = null;
	
	/** The Diagram logolabel. */
	private Label DiagramLogolabel = null;
	
	/** The choose diagram button. */
	private Button chooseDiagramButton = null;
	
	/** The use defaultcheck box. */
	private Button useDefaultcheckBox = null;

	/**
	 * This method initializes editHyperlinkShell.
	 */
	protected void createEditHyperlinkShell() {
		GridData gridData51 = new GridData();
		gridData51.horizontalAlignment = GridData.FILL;
		gridData51.verticalAlignment = GridData.CENTER;
		GridData gridData37 = new GridData();
		gridData37.horizontalAlignment = GridData.BEGINNING;
		gridData37.verticalAlignment = GridData.CENTER;
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.verticalAlignment = GridData.CENTER;
		gridData3.horizontalAlignment = GridData.FILL;
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.verticalAlignment = GridData.CENTER;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.horizontalSpan = 4;
		gridData1.horizontalAlignment = GridData.FILL;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.horizontalSpan = 5;
		gridData.grabExcessHorizontalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		gridLayout.makeColumnsEqualWidth = true;
		//this line has to be commented in order to open with VISUAL EDITOR
		editHyperlinkShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell());
		
		//editHyperlinkShell = new Shell();
		editHyperlinkShell.setText("Edit Hyperlink");
		editHyperlinkShell.setToolTipText("Edition of a hyperlink");
		editHyperlinkShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		editHyperlinkShell.setLayout(gridLayout);
		editHyperlinkShell.setSize(new Point(625, 119));
		ObjectcLabel = new CLabel(editHyperlinkShell, SWT.NONE);
		ObjectcLabel.setText("Diagram:");
		ObjectcLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		ObjectLabeltext = new Text(getEditHyperlinkShell(), SWT.BORDER | SWT.READ_ONLY);
		ObjectLabeltext.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		ObjectLabeltext.setLayoutData(gridData1);
		DiagramLogolabel = new Label(getEditHyperlinkShell(), SWT.NONE);
		DiagramLogolabel.setText("Label");
		DiagramLogolabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		DiagramLogolabel.setLayoutData(gridData37);
		//DiagramLogolabel.setImage(new Image(Display.getCurrent(), "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/Clause.gif"));
		
		DiagramLogolabel.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/Clause.gif").createImage());
		chooseDiagramButton = new Button(getEditHyperlinkShell(), SWT.NONE);
		//chooseDiagramButton.setImage(new Image(Display.getCurrent(), "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.diagram.common/icons/obj16/insp_sbook.gif"));
		chooseDiagramButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/insp_sbook.gif").createImage());
		
		chooseDiagramButton.setLayoutData(gridData51);
		chooseDiagramButton.setText("");
		tooltipInputLabel = new CLabel(editHyperlinkShell, SWT.NONE);
		tooltipInputLabel.setText("Tooltip text:");
		tooltipInputLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tooltipInputLabel.setToolTipText("tooltip text");
		tooltipInputText = new Text(getEditHyperlinkShell(), SWT.BORDER);
		tooltipInputText.setLayoutData(gridData);
		useDefaultcheckBox = new Button(getEditHyperlinkShell(), SWT.CHECK);
		useDefaultcheckBox.setText("Use default");
		useDefaultcheckBox.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler1 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler938 = new Label(getEditHyperlinkShell(), SWT.NONE);
		Label filler6 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler2 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler7 = new Label(getEditHyperlinkShell(), SWT.NONE);
		OkButton = new Button(getEditHyperlinkShell(), SWT.NONE);
		OkButton.setText("Ok");
		OkButton.setLayoutData(gridData2);
		cancelButton = new Button(getEditHyperlinkShell(), SWT.NONE);
		cancelButton.setText("Cancel");
		cancelButton.setLayoutData(gridData3);
	}

	
	/**
	 * Gets the edit hyperlink shell.
	 * 
	 * @return the editHyperlinkShell
	 */
	protected Shell getEditHyperlinkShell() {
		return editHyperlinkShell;
	}

	
	/**
	 * Gets the ok button.
	 * 
	 * @return the okButton
	 */
	protected Button getOkButton() {
		return OkButton;
	}

	
	/**
	 * Gets the cancel button.
	 * 
	 * @return the cancelButton
	 */
	protected Button getCancelButton() {
		return cancelButton;
	}

	
	/**
	 * Gets the tooltip input text.
	 * 
	 * @return the tooltipInputText
	 */
	protected Text getTooltipInputText() {
		return tooltipInputText;
	}

	
	/**
	 * Gets the object labeltext.
	 * 
	 * @return the objectLabeltext
	 */
	protected Text getObjectLabeltext() {
		return ObjectLabeltext;
	}


	
	/**
	 * Gets the choose diagram button.
	 * 
	 * @return the chooseDiagramButton
	 */
	protected Button getChooseDiagramButton() {
		return chooseDiagramButton;
	}


	
	/**
	 * Gets the diagram logolabel.
	 * 
	 * @return the diagramLogolabel
	 */
	protected Label getDiagramLogolabel() {
		return DiagramLogolabel;
	}


	
	/**
	 * Gets the tooltip input label.
	 * 
	 * @return the tooltipInputLabel
	 */
	protected CLabel getTooltipInputLabel() {
		return tooltipInputLabel;
	}


	
	/**
	 * Gets the objectc label.
	 * 
	 * @return the objectcLabel
	 */
	protected CLabel getObjectcLabel() {
		return ObjectcLabel;
	}


	
	/**
	 * Gets the use default check box.
	 * 
	 * @return the useDefaultcheckBox
	 */
	protected Button getUseDefaultCheckBox() {
		return useDefaultcheckBox;
	}


	
	/**
	 * Sets the cancel button.
	 * 
	 * @param cancelButton the cancelButton to set
	 */
	protected void setCancelButton(Button cancelButton) {
		this.cancelButton = cancelButton;
	}

}
