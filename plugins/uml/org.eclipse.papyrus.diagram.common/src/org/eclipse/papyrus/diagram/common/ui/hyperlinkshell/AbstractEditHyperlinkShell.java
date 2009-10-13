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


/**
 * The Class EditHyperlinkShell.
 *  This Class has been generated from VisualEditor.
 * Do not modify it manually by adding behavior! you will lose the capacity to open with VE.
 * So this class is abstract and it contains set of getter in order to connect behavior in subclasses
 
 */
public abstract class AbstractEditHyperlinkShell {

	/** The Constant OBJECT_LABEL. */
	protected static final String OBJECT_LABEL = "object";
	
	/** The edit hyperlink shell. */
	private Shell editHyperlinkShell = null;  //  @jve:decl-index=0:visual-constraint="12,45"
	
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

	private Button useDefaultCheckBox = null;

	/**
	 * This method initializes editHyperlinkShell.
	 */
	protected void createEditHyperlinkShell() {
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.verticalAlignment = GridData.CENTER;
		gridData3.horizontalAlignment = GridData.FILL;
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.horizontalSpan = 6;
		gridData1.verticalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.horizontalAlignment = GridData.FILL;
		GridData gridData = new GridData();
		gridData.horizontalSpan = 5;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessHorizontalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		gridLayout.makeColumnsEqualWidth = true;
		
		Display display = Display.getCurrent();
		//this line has to be commented in order to open with VISUAL EDITOR
		editHyperlinkShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell());
		
		//editHyperlinkShell = new Shell(display, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		
		//editHyperlinkShell = new Shell();
		editHyperlinkShell.setText("Edit Hyperlink");
		editHyperlinkShell.setToolTipText("Edition of a hyperlink");
		editHyperlinkShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		editHyperlinkShell.setLayout(gridLayout);
		editHyperlinkShell.setSize(new Point(601, 119));
		ObjectcLabel = new CLabel(editHyperlinkShell, SWT.NONE);
		ObjectcLabel.setText(OBJECT_LABEL);
		ObjectcLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		ObjectLabeltext = new Text(editHyperlinkShell, SWT.BORDER);
		ObjectLabeltext.setLayoutData(gridData1);
		tooltipInputLabel = new CLabel(editHyperlinkShell, SWT.NONE);
		tooltipInputLabel.setText("Tooltip text:");
		tooltipInputLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tooltipInputLabel.setToolTipText("tooltip text");
		tooltipInputText = new Text(editHyperlinkShell, SWT.BORDER);
		tooltipInputText.setLayoutData(gridData);
		useDefaultCheckBox = new Button(getEditHyperlinkShell(), SWT.CHECK);
		useDefaultCheckBox.setText("Use Default");
		useDefaultCheckBox.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler1 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler3 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler6 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler2 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler452 = new Label(getEditHyperlinkShell(), SWT.NONE);
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
	public Shell getEditHyperlinkShell() {
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
	 * @return the objectcLabel
	 */
	public CLabel getObjectcLabel() {
		return ObjectcLabel;
	}


	
	/**
	 * @return the useDefaultCheckBox
	 */
	protected Button getUseDefaultCheckBox() {
		return useDefaultCheckBox;
	}

}
