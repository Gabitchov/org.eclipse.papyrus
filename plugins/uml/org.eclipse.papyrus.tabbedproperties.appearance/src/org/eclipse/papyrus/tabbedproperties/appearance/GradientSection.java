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
package org.eclipse.papyrus.tabbedproperties.appearance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.swt.layout.GridData;
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

	private Group transparencyGroup;

	private Group colorGroup;

	private Group styleGroup;

	private Spinner transparencyValueSpinner;

	private Button verticalStyle;

	private Button horizontalStyle;

	private Button color1Button;

	private Button color2Button;

	private GradientData gradientData = GradientData.getDefaultGradientData();

	private int transparency = -1;

	private boolean isGradientUsed = false;

	private Map<Button, Integer> buttonColors = new HashMap<Button, Integer>();

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
		createTransparencyGroup(gradientGroup);
		createColorGroup(gradientGroup);
		createStyleGroup(gradientGroup);
	}

	/**
	 * Create the GradientPolicy Group. This group contained a SWT.CHECK button to specify if the
	 * gradient is used or not.
	 * 
	 * @param parent
	 *            the parent
	 */
	protected void createGradientPolicy(Composite parent) {
		Composite gradientPolicyCompo = getWidgetFactory().createComposite(parent);
		gradientPolicyCompo.setLayout(new GridLayout(1, false));
		GridData gd = new GridData();
		gradientPolicyCompo.setLayoutData(gd);
		policyButton = getWidgetFactory().createButton(gradientPolicyCompo,
				Messages.GradientSection_Button_IsGradientUsed, SWT.CHECK);

		policyButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (!policyButton.getSelection()) {
					isGradientUsed = false;
					gradientData = null;
					// Set transparency to 100 to have the background color correct.
					transparency = 100;
				} else {
					isGradientUsed = true;
					gradientData = new GradientData((GradientData) getSingleInput().getPreferredValue(
							NotationPackage.eINSTANCE.getFillStyle_Gradient()));
					transparency = (Integer) getSingleInput().getPreferredValue(
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
	 * Create the transparency group. This group contained a spinner to select a value for the
	 * transparency. The transparency value must be contained in [0;100]
	 * 
	 * @param parent
	 *            the composite containing the group
	 */
	protected void createTransparencyGroup(Composite parent) {
		transparencyGroup = getWidgetFactory().createGroup(parent, Messages.GradientSection_Group_Transparency);
		transparencyGroup.setLayout(new GridLayout(1, false));
		transparencyGroup.setLayoutData(new GridData(GridData.FILL_VERTICAL | GridData.GRAB_VERTICAL));

		transparencyValueSpinner = new Spinner(transparencyGroup, SWT.BORDER);
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
	 * Create the colors group. This group is in charge of selecting the two colors used by the
	 * gradient.
	 * 
	 * @param parent
	 *            the parent composite
	 */
	protected void createColorGroup(Composite parent) {
		colorGroup = getWidgetFactory().createGroup(parent, Messages.GradientSection_Group_Colors);
		colorGroup.setLayout(new GridLayout(2, false));
		colorGroup.setLayoutData(new GridData(GridData.FILL_VERTICAL | GridData.GRAB_VERTICAL));

		getWidgetFactory().createCLabel(colorGroup, Messages.GradientSection_GradientColor_FirstColor);

		// button for choosing gradientColor1
		color1Button = getWidgetFactory().createButton(colorGroup, "", SWT.PUSH); //$NON-NLS-1$ 
		color1Button.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				RGB color1 = changeColor(color1Button);
				if (color1 != null) {
					gradientData.setGradientColor1(FigureUtilities.RGBToInteger(color1));
					updateGradient();
				}
			}
		});

		getWidgetFactory().createCLabel(colorGroup, Messages.GradientSection_GradientColor_SecondColor);
		// button for choosing gradientColor2
		color2Button = getWidgetFactory().createButton(colorGroup, "", SWT.PUSH); //$NON-NLS-1$ 
		color2Button.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				RGB color2 = changeColor(color2Button);
				if (color2 != null) {
					gradientData.setGradientColor2(FigureUtilities.RGBToInteger(color2));
					updateGradient();
				}
			}
		});
	}

	/**
	 * Create the style group. This group contained the component in charge of the style of the
	 * gradient. Values available are GradientStyle.VERTICAL and GradientStyle.HORIZONTAL.
	 * 
	 * @param parent
	 *            the parent composite
	 */
	protected void createStyleGroup(Composite parent) {
		styleGroup = getWidgetFactory().createGroup(parent, Messages.GradientSection_Group_Style);
		GridLayout layout = new GridLayout(1, true);
		styleGroup.setLayout(layout);
		styleGroup.setLayoutData(new GridData(GridData.FILL_VERTICAL | GridData.GRAB_VERTICAL));

		verticalStyle = getWidgetFactory().createButton(styleGroup, Messages.GradientSection_Style_Vertical, SWT.RADIO);
		horizontalStyle = getWidgetFactory().createButton(styleGroup, Messages.GradientSection_Style_Horizontal,
				SWT.RADIO);

		SelectionListener selectionListener = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!((Button) e.widget).getSelection()) {
					// don't react on de-selection
					return;
				}
				if (verticalStyle.getSelection()) {
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
		disposeButtonImage(color1Button);
		disposeButtonImage(color2Button);

		super.dispose();
	}

	/**
	 * Dispose the image associated with the given button
	 * 
	 * @param btn
	 *            the button that contains the image
	 */
	protected void disposeButtonImage(Button btn) {
		if (btn != null && !btn.isDisposed()) {
			Image imageColor1 = btn.getImage();
			if (imageColor1 != null && !imageColor1.isDisposed()) {
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
		if (image != null) {
			image.dispose();
		}
		// Store the color and the button for the refresh mechanism
		buttonColors.put(btn, new Integer(intColor));

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
	 *            the button
	 * @return the selected color or null
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ColorPalettePopup
	 */
	private RGB changeColor(Button button) {
		ColorPalettePopup popup = new ColorPalettePopup(button.getParent().getShell(),
				IDialogConstants.BUTTON_BAR_HEIGHT);
		Rectangle r = button.getBounds();
		Point location = button.getParent().toDisplay(r.x, r.y);
		popup.open(new Point(location.x, location.y + r.height));
		if (popup.getSelectedColor() == null && !popup.useDefaultColor()) {
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

		if (gradientData != null) {
			if (transparency != transparencyValueSpinner.getSelection()) {
				transparencyValueSpinner.setSelection(transparency);
			}
			if (buttonColors.get(color1Button) == null
					|| !(buttonColors.get(color1Button).intValue() == gradientData.getGradientColor1())) {
				setButtonImage(color1Button, gradientData.getGradientColor1());
			}
			if (buttonColors.get(color2Button) == null
					|| !(buttonColors.get(color2Button).intValue() == gradientData.getGradientColor2())) {
				setButtonImage(color2Button, gradientData.getGradientColor2());
			}
			if (horizontalStyle.getSelection() != (gradientData.getGradientStyle() == GradientStyle.HORIZONTAL)) {
				horizontalStyle.setSelection(gradientData.getGradientStyle() == GradientStyle.HORIZONTAL);
			}
			if (verticalStyle.getSelection() != (gradientData.getGradientStyle() == GradientStyle.VERTICAL)) {
				verticalStyle.setSelection(gradientData.getGradientStyle() == GradientStyle.VERTICAL);
			}
		}

		policyButton.setSelection(isGradientUsed);
		// Groups
		transparencyGroup.setEnabled(isGradientUsed);
		styleGroup.setEnabled(isGradientUsed);
		colorGroup.setEnabled(isGradientUsed);

		// Others
		transparencyValueSpinner.setEnabled(isGradientUsed);
		verticalStyle.setEnabled(isGradientUsed);
		horizontalStyle.setEnabled(isGradientUsed);
		color1Button.setEnabled(isGradientUsed);
		color2Button.setEnabled(isGradientUsed);

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
				if (ep != null) {
					gradientData = new GradientData((GradientData) getSingleInput().getStructuralFeatureValue(
							NotationPackage.eINSTANCE.getFillStyle_Gradient()));
					transparency = (Integer) getSingleInput().getStructuralFeatureValue(
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
	 *            the feature to update
	 * @param value
	 *            the new value
	 * @param commandName
	 *            the name of the command
	 */
	protected void updateFeature(final EStructuralFeature feature, final Object value, String commandName) {
		List inputs = getInput();
		List<ICommand> commands = new ArrayList<ICommand>();
		for (Object input : inputs) {
			if (input instanceof IGraphicalEditPart) {
				final IGraphicalEditPart gep = (IGraphicalEditPart) input;
				if (!(input instanceof ConnectionNodeEditPart)) {
					commands.add(createCommand(commandName, ((View) gep.getModel()).eResource(), new Runnable() {

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
		updateFeature(NotationPackage.eINSTANCE.getFillStyle_Transparency(), new Integer(transparency),
				Messages.GradientSection_Command_Change_Transparency);
	}

	/**
	 * Update Gradient feature
	 */
	protected void updateGradient() {
		Object value = null;
		if (gradientData != null) {
			value = new GradientData(gradientData);
		}
		updateFeature(NotationPackage.eINSTANCE.getFillStyle_Gradient(), value,
				Messages.GradientSection_Command_Change_Gradient);
	}
}
