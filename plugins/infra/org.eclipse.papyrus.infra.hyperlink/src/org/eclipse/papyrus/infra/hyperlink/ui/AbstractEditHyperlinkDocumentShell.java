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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEditHyperlinkDocumentShell. This Class has been generated
 * from VisualEditor. Do not modify it manually by adding behavior! you will
 * lose the capacity to open with VE. So this class is abstract and it contains
 * set of getter in order to connect behavior in subclasses
 */
public class AbstractEditHyperlinkDocumentShell {

	/** The Constant OBJECT_LABEL. */
	// @unused
	protected static final String OBJECT_LABEL = Messages.AbstractEditHyperlinkDocumentShell_Diagram;

	/** The edit hyperlink shell. */
	private Shell editHyperlinkShell = null; // @jve:decl-index=0:visual-constraint="44,36"

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
		gridData1.horizontalSpan = 5;
		gridData1.horizontalAlignment = GridData.FILL;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.horizontalSpan = 5;
		gridData.grabExcessHorizontalSpace = true;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		gridLayout.makeColumnsEqualWidth = true;
		// this line has to be commented in order to open with VISUAL EDITOR
		editHyperlinkShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.DIALOG_TRIM | SWT.RESIZE);

		// editHyperlinkShell = new Shell();
		editHyperlinkShell.setText(Messages.AbstractEditHyperlinkDocumentShell_EditHyperlink);
		editHyperlinkShell.setToolTipText(Messages.AbstractEditHyperlinkDocumentShell_EditionOfAHyperLink);
		editHyperlinkShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		editHyperlinkShell.setLayout(gridLayout);
		//		editHyperlinkShell.setSize(new Point(625, 119));
		ObjectcLabel = new CLabel(editHyperlinkShell, SWT.NONE);
		ObjectcLabel.setText(Messages.AbstractEditHyperlinkDocumentShell_Document);
		ObjectcLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		ObjectLabeltext = new Text(getEditHyperlinkShell(), SWT.BORDER);
		ObjectLabeltext.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		ObjectLabeltext.setEditable(true);
		ObjectLabeltext.setLayoutData(gridData1);
		chooseDiagramButton = new Button(getEditHyperlinkShell(), SWT.NONE);
		// chooseDiagramButton.setImage(new Image(Display.getCurrent(),
		// "C:/Tessier/PROTOTYPE/papyrusII/DEVELOPMENT/GalileoM6/org.eclipse.papyrus.uml.diagram.common/icons/obj16/insp_sbook.gif"));
		chooseDiagramButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.uml.diagram.common", "/icons/obj16/insp_sbook.gif").createImage()); //$NON-NLS-1$ //$NON-NLS-2$
		chooseDiagramButton.setLayoutData(gridData51);
		chooseDiagramButton.setText(""); //$NON-NLS-1$
		tooltipInputLabel = new CLabel(editHyperlinkShell, SWT.NONE);
		tooltipInputLabel.setText(Messages.AbstractEditHyperlinkDocumentShell_TooltipText);
		tooltipInputLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tooltipInputLabel.setToolTipText(Messages.AbstractEditHyperlinkDocumentShell_ToolTipText);
		tooltipInputText = new Text(getEditHyperlinkShell(), SWT.BORDER);
		tooltipInputText.setLayoutData(gridData);
		useDefaultcheckBox = new Button(getEditHyperlinkShell(), SWT.CHECK);
		useDefaultcheckBox.setText(Messages.AbstractEditHyperlinkDocumentShell_UseDefault);
		useDefaultcheckBox.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler1 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler938 = new Label(getEditHyperlinkShell(), SWT.NONE);
		Label filler6 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler2 = new Label(editHyperlinkShell, SWT.NONE);
		Label filler7 = new Label(getEditHyperlinkShell(), SWT.NONE);
		OkButton = new Button(getEditHyperlinkShell(), SWT.NONE);
		OkButton.setText(Messages.AbstractEditHyperlinkDocumentShell_OK);
		OkButton.setLayoutData(gridData2);
		cancelButton = new Button(getEditHyperlinkShell(), SWT.NONE);
		cancelButton.setText(Messages.AbstractEditHyperlinkDocumentShell_Cancel);
		cancelButton.setLayoutData(gridData3);

		editHyperlinkShell.pack();
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
	 * Gets the tooltip input label.
	 * 
	 * @return the tooltipInputLabel
	 */
	// @unused
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
	 * @param cancelButton
	 *        the cancelButton to set
	 */
	// @unused
	protected void setCancelButton(Button cancelButton) {
		this.cancelButton = cancelButton;
	}

}
