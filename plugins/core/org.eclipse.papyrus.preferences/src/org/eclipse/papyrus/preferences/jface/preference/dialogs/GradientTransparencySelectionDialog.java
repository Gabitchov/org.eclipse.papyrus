/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.jface.preference.dialogs;

import org.eclipse.gmf.runtime.common.ui.dialogs.GradientSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

/**
 * Add a transparency group to the {@link GradientSelectionDialog} allow users to set the transparency too. 
 * @author tlandre
 */
public class GradientTransparencySelectionDialog extends
		GradientSelectionDialog {

	/**
	 * The spinner used to set the transparencyValue
	 */
	Spinner transparencyValueSpinner;
	
	/**
	 * Default Constructor
	 * @param parent the shell used
	 * @param style the style of the shell. 
	 * @param initColor1 the first color used for the gradient
	 * @param initColor2 the seconde color used for the gradient
	 * @param defaultGradientStyle initial Gradient style. The allowed values are GradientStyle.HORIZONTAL or GradientStyle.VERTICAL
	 * @param transparency the transparency of the gradient. It is ignored if not within [0, 100] range
	 */
	public GradientTransparencySelectionDialog(Shell parent, int style,
			RGB initColor1, RGB initColor2, int defaultGradientStyle,
			int transparency) {
		super(parent, style, initColor1, initColor2, defaultGradientStyle, transparency);
	}
	
	@Override
	protected void createClearButton(Composite okCancelComp, Shell parent) {
		//Remove Clear Button
	}

	/**
	 * Creates the controls of the dialog.
	 * 
	 * @param parent
	 *            Parent shell
	 */
	protected void createDialogControls(Shell parent) {
	    GridLayout layout = new GridLayout();
	    layout.numColumns = 4;	
	    layout.marginHeight = 0;
	    layout.marginWidth = 0;
	   	Composite topComposite = new Composite(parent, SWT.NONE);
	   	topComposite.setLayout(layout);
	   	
		createColorGroup(parent, topComposite);
		createStyleGroup(topComposite);
		createTransparencyGroup(parent, topComposite);
		createSample(parent, topComposite);
	
		createOkCancelClearButtons(parent, topComposite);
		
	}

	/**
	 * Create the transparency group
	 * @param parent the shell used
	 * @param topComposite the parent composite
	 */
	protected void createTransparencyGroup(Shell parent, Composite topComposite) {
		Group transparencyGroup = new Group(topComposite, SWT.NONE);
		transparencyGroup.setText("Transparency");
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		transparencyGroup.setLayout(layout);
		transparencyGroup.setLayoutData(gridData);
		
		transparencyValueSpinner = new Spinner(transparencyGroup, SWT.BORDER);
		transparencyValueSpinner.setSelection(getTransparency());
		transparencyValueSpinner.setMinimum(0);
		transparencyValueSpinner.setMaximum(100);
		transparencyValueSpinner.setIncrement(1);
		
		transparencyValueSpinner.addModifyListener(new ModifyListener(){
		
			public void modifyText(ModifyEvent arg0) {
				setTransparency(transparencyValueSpinner.getSelection());
				getSampleCanvas().redraw();		
			}
		});
		
	}
}
