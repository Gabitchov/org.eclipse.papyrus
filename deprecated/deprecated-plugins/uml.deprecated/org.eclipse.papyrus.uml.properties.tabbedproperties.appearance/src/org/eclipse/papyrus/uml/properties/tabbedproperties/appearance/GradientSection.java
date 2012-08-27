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
 ****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractNotationPropertiesSection;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.IWorkbenchPart;

/**
 * A section that manages the Gradient.
 */
public class GradientSection extends AbstractNotationPropertiesSection {

	private Button policyButton;

	private Composite styleCompo;

	private Spinner transparencyValueSpinner;

	private Button verticalStyle;

	private Button horizontalStyle;

	private Button colorButton;

	private GradientData gradientData = GradientData.getDefaultGradientData();

	private int transparency = -1;

	private boolean isGradientUsed = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractNotationPropertiesSection#
	 * initializeControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void initializeControls(Composite parent) {
		super.initializeControls(parent);
		GridLayout layout = new GridLayout(2, false);
		Group gradientGroup = getWidgetFactory().createGroup(composite, Messages.GradientSection_Group_Gradient);
		gradientGroup.setLayout(layout);

		createGradientPolicy(gradientGroup);
		createColorGroup(gradientGroup);
		createStyleGroup(gradientGroup);
		createTransparencyGroup(gradientGroup);
	}

	/**
	 * Create the GradientPolicy Group. It contained a SWT.CHECK button to specify if the gradient
	 * is used or not and a label.
	 * 
	 * @param parent
	 *        the parent
	 */
	protected void createGradientPolicy(Composite parent) {

		// Create a label
		getWidgetFactory().createCLabel(parent, Messages.GradientSection_Button_ActivateGradient);

		// Create the check button
		policyButton = getWidgetFactory().createButton(parent, "", SWT.CHECK); //$NON-NLS-1$

		policyButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if(!policyButton.getSelection()) {
					isGradientUsed = false;
					gradientData = null;
					// Set transparency to 100 to have the background color correct.
					transparency = 100;
				} else {
					isGradientUsed = true;
					gradientData = new GradientData((GradientData)getSingleInput().getPreferredValue(
							NotationPackage.eINSTANCE.getFillStyle_Gradient()));
					transparency = (Integer)getSingleInput().getPreferredValue(
							NotationPackage.eINSTANCE.getFillStyle_Transparency());
				}
				updateGradient();
				updateTransparency();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Do nothing
			}
		});
	}

	/**
	 * Create the transparency. It contained a label and a spinner to select a value for the
	 * transparency. The transparency value must be contained in [0;100]
	 * 
	 * @param parent
	 *        the composite containing the widgets
	 */
	protected void createTransparencyGroup(Composite parent) {

		// Create the label
		getWidgetFactory().createCLabel(parent, Messages.GradientSection_Label_Transparency);

		// Create the Spinner
		transparencyValueSpinner = new Spinner(parent, SWT.BORDER);
		transparencyValueSpinner.setMinimum(0);
		transparencyValueSpinner.setMaximum(100);
		transparencyValueSpinner.setIncrement(1);

		transparencyValueSpinner.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				transparency = transparencyValueSpinner.getSelection();
				updateTransparency();
			}
		});

	}

	/**
	 * Create the color. It is in charge of selecting the color used by the gradient. It contained a
	 * label and the color button
	 * 
	 * @param parent
	 *        the parent composite
	 */
	protected void createColorGroup(Composite parent) {

		// Create the label
		getWidgetFactory().createCLabel(parent, Messages.GradientSection_Label_FirstColor);

		// Create the color button
		colorButton = getWidgetFactory().createButton(parent, "", SWT.PUSH); //$NON-NLS-1$ 
		colorButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				RGB color1 = changeColor(colorButton);
				if(color1 != null) {
					gradientData.setGradientColor1(FigureUtilities.RGBToInteger(color1));
					updateGradient();
				}
			}
		});
	}

	/**
	 * Create the style. It contained the component in charge of the style of the gradient. Values
	 * available are GradientStyle.VERTICAL and GradientStyle.HORIZONTAL.
	 * 
	 * @param parent
	 *        the parent composite
	 */
	protected void createStyleGroup(Composite parent) {

		// Create the label
		getWidgetFactory().createCLabel(parent, Messages.GradientSection_Label_Style);

		// Create the style composite
		styleCompo = getWidgetFactory().createComposite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(1, true);
		layout.marginWidth = 0;
		styleCompo.setLayout(layout);
		verticalStyle = getWidgetFactory().createButton(styleCompo, Messages.GradientSection_Style_Vertical, SWT.RADIO);
		horizontalStyle = getWidgetFactory().createButton(styleCompo, Messages.GradientSection_Style_Horizontal,
				SWT.RADIO);

		SelectionListener selectionListener = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!((Button)e.widget).getSelection()) {
					// don't react on de-selection
					return;
				}
				if(verticalStyle.getSelection()) {
					gradientData.setGradientStyle(GradientStyle.VERTICAL);
				} else {
					gradientData.setGradientStyle(GradientStyle.HORIZONTAL);
				}
				updateGradient();
			}
		};
		verticalStyle.addSelectionListener(selectionListener);
		horizontalStyle.addSelectionListener(selectionListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#dispose
	 * ()
	 */
	@Override
	public void dispose() {
		disposeButtonImage(colorButton);
		super.dispose();
	}

	/**
	 * Dispose the image associated with the given button
	 * 
	 * @param btn
	 *        the button that contains the image
	 */
	protected void disposeButtonImage(Button btn) {
		if(btn != null && !btn.isDisposed()) {
			Image imageColor1 = btn.getImage();
			if(imageColor1 != null && !imageColor1.isDisposed()) {
				imageColor1.dispose();
			}
		}
	}

	/**
	 * Sets the image for a color button (square filled with the color that button represents)
	 */
	protected void setButtonImage(Button btn, int intColor) {
		// First, dispose the current image, if any
		Image image = btn.getImage();
		if(image != null) {
			image.dispose();
		}

		Display display = btn.getParent().getShell().getDisplay();
		RGB rgbColor = FigureUtilities.integerToRGB(intColor);
		// Now set the new image based on rgbColor
		Color color1 = new Color(display, rgbColor);
		image = new Image(display, 16, 16);
		GC gc = new GC(image);
		gc.setBackground(color1);
		Rectangle rect = image.getBounds();
		gc.fillRectangle(rect);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.drawRectangle(rect.x, rect.y, rect.width - 1, rect.height - 1);
		gc.dispose();
		color1.dispose();
		btn.setImage(image);
	}

	/**
	 * Allow user to change the color of the given button.
	 * 
	 * @param button
	 *        the button
	 * @return the selected color or null
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup
	 */
	private RGB changeColor(Button button) {
		ColorPalettePopup popup = new ColorPalettePopup(button.getParent().getShell(),
				IDialogConstants.BUTTON_BAR_HEIGHT);
		Rectangle r = button.getBounds();
		Point location = button.getParent().toDisplay(r.x, r.y);
		popup.open(new Point(location.x, location.y + r.height));
		if(popup.getSelectedColor() == null && !popup.useDefaultColor()) {
			return null;
		}
		return popup.getSelectedColor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		refreshComponent();
	}

	/**
	 * Refresh the components and enable/disable them according to the isGradientUsed attribute
	 */
	protected void refreshComponent() {

		if(gradientData != null) {
			if(transparency != transparencyValueSpinner.getSelection()) {
				transparencyValueSpinner.setSelection(transparency);
			}

			setButtonImage(colorButton, gradientData.getGradientColor1());

			if(horizontalStyle.getSelection() != (gradientData.getGradientStyle() == GradientStyle.HORIZONTAL)) {
				horizontalStyle.setSelection(gradientData.getGradientStyle() == GradientStyle.HORIZONTAL);
			}
			if(verticalStyle.getSelection() != (gradientData.getGradientStyle() == GradientStyle.VERTICAL)) {
				verticalStyle.setSelection(gradientData.getGradientStyle() == GradientStyle.VERTICAL);
			}
		}

		policyButton.setSelection(isGradientUsed);
		// Groups
		styleCompo.setEnabled(isGradientUsed);

		// Others
		transparencyValueSpinner.setEnabled(isGradientUsed);
		verticalStyle.setEnabled(isGradientUsed);
		horizontalStyle.setEnabled(isGradientUsed);
		colorButton.setEnabled(isGradientUsed);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse. ui.IWorkbenchPart,
	 * org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		executeAsReadAction(new Runnable() {

			public void run() {
				IGraphicalEditPart ep = getSingleInput();
				if(ep != null) {
					gradientData = new GradientData((GradientData)getSingleInput().getStructuralFeatureValue(
							NotationPackage.eINSTANCE.getFillStyle_Gradient()));
					transparency = (Integer)getSingleInput().getStructuralFeatureValue(
							NotationPackage.eINSTANCE.getFillStyle_Transparency());
				}
			}
		});
		isGradientUsed = !gradientData.equals(GradientData.getDefaultGradientData());
	}

	/**
	 * Update the value of the given feature
	 * 
	 * @param feature
	 *        the feature to update
	 * @param value
	 *        the new value
	 * @param commandName
	 *        the name of the command
	 */
	protected void updateFeature(final EStructuralFeature feature, final Object value, String commandName) {
		List inputs = getInput();
		List<ICommand> commands = new ArrayList<ICommand>();
		for(Object input : inputs) {
			if(input instanceof IGraphicalEditPart) {
				final IGraphicalEditPart gep = (IGraphicalEditPart)input;
				if(!(input instanceof ConnectionNodeEditPart)) {
					commands.add(createCommand(commandName, ((View)gep.getModel()).eResource(), new Runnable() {

						public void run() {
							gep.setStructuralFeatureValue(feature, value);
						}
					}));
				}
			}
		}
		executeAsCompositeCommand(commandName, commands);
	}

	/**
	 * Update transparency feature
	 */
	protected void updateTransparency() {
		updateFeature(NotationPackage.eINSTANCE.getFillStyle_Transparency(), new Integer(transparency), "Change Transparency command");//$NON-NLS-1$
	}

	/**
	 * Update Gradient feature
	 */
	protected void updateGradient() {
		Object value = null;
		if(gradientData != null) {
			value = new GradientData(gradientData);
		}
		updateFeature(NotationPackage.eINSTANCE.getFillStyle_Gradient(), value, "Change Gradient command"); //$NON-NLS-1$
	}
}
