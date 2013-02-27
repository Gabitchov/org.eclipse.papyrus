/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.widget;

import org.eclipse.nebula.widgets.nattable.style.IStyle;
import org.eclipse.nebula.widgets.nattable.widget.NatCombo;
import org.eclipse.papyrus.infra.nattable.celleditor.ButtonConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * This widget provides a Combo with a button
 * 
 */
public class NatComboButton extends NatCombo {

	/**
	 * the configuration of the button
	 */
	private ButtonConfiguration buttonConfiguration;

	/**
	 * the button
	 */
	private Button button;

	/**
	 * 
	 * Constructor.
	 * 
	 * @see NatCombo#NatCombo(Composite, IStyle, int)
	 * @param parent
	 * @param cellStyle
	 * @param style
	 * @param buttonConfiguration
	 *        the configuration of the button
	 */
	public NatComboButton(Composite parent, IStyle cellStyle, int style, ButtonConfiguration buttonConfiguration) {
		super(parent, cellStyle, style);
		this.buttonConfiguration = buttonConfiguration;
		configureButton();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @see NatCombo#NatCombo(Composite, IStyle, int, int)
	 * @param parent
	 * @param cellStyle
	 * @param maxVisibleItems
	 * @param style
	 * @param buttonConfiguration
	 *        the configuration of the button
	 */
	public NatComboButton(Composite parent, IStyle cellStyle, int maxVisibleItems, int style, ButtonConfiguration buttonConfiguration) {
		super(parent, cellStyle, maxVisibleItems, style);
		this.buttonConfiguration = buttonConfiguration;
		configureButton();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @see NatCombo#NatCombo(Composite, IStyle, int, boolean, int)
	 * @param parent
	 * @param cellStyle
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param style
	 * @param buttonConfiguration
	 *        the configuration of the button
	 */
	public NatComboButton(Composite parent, IStyle cellStyle, int maxVisibleItems, boolean freeEdit, int style, ButtonConfiguration buttonConfiguration) {
		super(parent, cellStyle, maxVisibleItems, freeEdit, style);
		this.buttonConfiguration = buttonConfiguration;
		configureButton();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @see NatCombo#NatCombo(Composite, IStyle, int, boolean, boolean, int)
	 * @param parent
	 * @param cellStyle
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param multiselect
	 * @param style
	 * @param buttonConfiguration
	 *        the configuration of the button
	 */
	public NatComboButton(Composite parent, IStyle cellStyle, int maxVisibleItems, boolean freeEdit, boolean multiselect, int style, ButtonConfiguration buttonConfiguration) {
		super(parent, cellStyle, maxVisibleItems, freeEdit, multiselect, style);
		this.buttonConfiguration = buttonConfiguration;
		configureButton();
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @see NatCombo#NatCombo(Composite, IStyle, int, boolean, boolean, int, Image)
	 * @param parent
	 * @param cellStyle
	 * @param maxVisibleItems
	 * @param freeEdit
	 * @param multiselect
	 * @param style
	 * @param iconImage
	 * @param buttonConfiguration
	 *        the configuration of the button
	 */
	public NatComboButton(Composite parent, IStyle cellStyle, int maxVisibleItems, boolean freeEdit, boolean multiselect, int style, Image iconImage, ButtonConfiguration buttonConfiguration) {
		super(parent, cellStyle, maxVisibleItems, freeEdit, multiselect, style, iconImage);
		this.buttonConfiguration = buttonConfiguration;
		configureButton();
	}

	/**
	 * Configure the created button
	 */
	protected void configureButton() {
		final String txt = buttonConfiguration.getText();
		if(txt != null) {
			button.setText(txt);
		}
		final String toolTip = buttonConfiguration.getTooltipText();
		if(toolTip != null) {
			button.setToolTipText(toolTip);
		}

		final Image img = buttonConfiguration.getImage();
		if(img != null) {
			button.setImage(img);
		}
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.widget.NatCombo#createTextControl(int)
	 * 
	 * @param style
	 */
	@Override
	protected void createTextControl(int style) {
		super.createTextControl(style);
		createButton();
		//we change the layout because there is 3 elements now!
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);
	}

	protected void createButton() {
		button = new Button(this, SWT.NONE);


		GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, true);
		button.setLayoutData(gridData);
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				runAction();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

	}

	/**
	 * execute the action done by the button
	 */
	protected void runAction() {
		buttonConfiguration.getAction().run();
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.widget.NatCombo#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		buttonConfiguration = null;
		button = null;
	}


}
