//------------------------------------------------------------------------------
// Copyright (c) 2005, 2007 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.papyrus.infra.widgets.editors.richtext.ui;

import java.util.Collection;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/**
 * Wraps a CCombo in a ContributionItem for use in a toolbar
 * 
 * Does not use a ComboViewer because of tabbing issues - see bug 78885
 * @author Jeff Hardy
 *
 */
public class ButtonContributionItem extends ContributionItem {

	protected Button button;
	
	protected String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	protected RGB colorValue;
	
	public RGB getColorValue() {
		return colorValue;
	}

	public void setColorValue(RGB colorValue) {
		this.colorValue = colorValue;
	}

	protected ColorSelector colorSelector; 

	public ColorSelector getColorSelector() {
		return colorSelector;
	}

	public void setColorSelector(ColorSelector colorSelector) {
		this.colorSelector = colorSelector;
	}

	protected ToolItem toolItem;

	protected CoolItem coolItem;
	
	protected int style;
	
	protected Collection<String> input;

	protected String toolTipText;

	/**
	 * Creates a new instance.
	 */
	public ButtonContributionItem(int style) {
		super();
		this.style = style;
	}

	/*
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.ToolBar,
	 *      int)
	 */
	public void fill(ToolBar parent, int index) {
		toolItem = new ToolItem(parent, SWT.SEPARATOR);
		Control box = createControl(parent);
		toolItem.setControl(box);
		Point preferredSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		toolItem.setWidth(preferredSize.x);
	}

	/*
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.CoolBar,
	 *      int)
	 */
	public void fill(CoolBar coolBar, int index) {
		Control box = createControl(coolBar);

		if (index >= 0) {
			coolItem = new CoolItem(coolBar, SWT.DROP_DOWN, index);
		} else {
			coolItem = new CoolItem(coolBar, SWT.DROP_DOWN);
		}

		// Set the back reference.
		coolItem.setData(this);

		// Add the toolbar to the CoolItem widget.
		coolItem.setControl(box);

		// If the toolbar item exists then adjust the size of the cool item.
		Point toolBarSize = box.computeSize(SWT.DEFAULT, SWT.DEFAULT);

		// Set the preferred size to the size of the toolbar plus trim.
		coolItem.setMinimumSize(toolBarSize);
		coolItem.setPreferredSize(toolBarSize);
		coolItem.setSize(toolBarSize);
	}

	/*
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.Composite)
	 */
	public void fill(Composite parent) {
		createControl(parent);
	}

	/**
	 * Creates the control.
	 */
	protected Control createControl(final Composite parent) {
		colorSelector = new ColorSelector(parent);
		button = colorSelector.getButton();
		button.setToolTipText(toolTipText);
		button.setEnabled(true);
		button.addDisposeListener(
				new DisposeListener() {
					public void widgetDisposed(DisposeEvent event) {
						dispose();
					}
				});

		
		button.addSelectionListener(new SelectionListener() {
	        public void widgetSelected(SelectionEvent e) {
	        	
	            StringBuilder stringBuilder = new StringBuilder();
	            stringBuilder.append("rgb(");
	            stringBuilder.append(colorSelector.getColorValue().red);
	            stringBuilder.append(",");
	            stringBuilder.append(colorSelector.getColorValue().green);
	            stringBuilder.append(",");
	            stringBuilder.append(colorSelector.getColorValue().blue);
	            stringBuilder.append(")");
	            color = stringBuilder.toString();
	            performSelectionChanged();
	            
	            
	            
	            

	        }
	      
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
		
	return button;	
	}			

			



	
	
	

	protected void performSelectionChanged() {
	}
	
	
	/*
	 * @see org.eclipse.jface.action.ContributionItem#dispose()
	 */
	public void dispose() {
		super.dispose();
	}

	public Button getButton() {
		return button;
	}

	public ToolItem getToolItem() {
		return toolItem;
	}

	public CoolItem getCoolItem() {
		return coolItem;
	}

	protected void performTyping() {
		// TODO Auto-generated method stub
		
	}
}
