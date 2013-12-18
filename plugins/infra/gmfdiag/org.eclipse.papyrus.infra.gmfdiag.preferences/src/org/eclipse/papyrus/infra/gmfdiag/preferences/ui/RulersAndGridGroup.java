/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import java.text.ParseException;
import java.text.ParsePosition;

import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.common.ui.preferences.ComboFieldEditor;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.LineStyleLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.UnitsConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.UnitsConverterUtils;
import org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.ibm.icu.text.NumberFormat;

/**
 * 
 * This group provides the elements to manage the grid of a diagram
 * Adapter code from the Preference Page Rulers And Grid
 */
@SuppressWarnings("restriction")
public class RulersAndGridGroup extends AbstractGroup {

	private int oldUnits = -1;

	private String RULER_GROUP_LABEL = DiagramUIMessages.GridRulerPreferencePage_rulerGroup_label;

	private String SHOW_RULERS_LABEL = DiagramUIMessages.GridRulerPreferencePage_showRulers_label;

	private String RULER_UNITS_LABEL = DiagramUIMessages.GridRulerPreferencePage_rulerUnits_label;

	private String RULER_UNITS_IN_LABEL = DiagramUIMessages.GridRulerPreferencePage_rulerUnits_inch_label;

	private String RULER_UNITS_CM_LABEL = DiagramUIMessages.GridRulerPreferencePage_rulerUnits_cm_label;

	private String RULER_UNITS_PIXEL_LABEL = DiagramUIMessages.GridRulerPreferencePage_rulerUnits_pixel_label;

	private String GRID_GROUP_LABEL = DiagramUIMessages.GridRulerPreferencePage_gridGroup_label;

	private String SHOW_GRID_LABEL = DiagramUIMessages.GridRulerPreferencePage_showGrid_label;

	private String SNAP_TO_GRID_LABEL = DiagramUIMessages.GridRulerPreferencePage_snapToGrid_label;

	private String SNAP_TO_GEOMETRY_LABEL = DiagramUIMessages.GridRulerPreferencePage_snapToGeometry_label;

	private String GRID_SPACING_LABEL_INCHES = DiagramUIMessages.GridRulerPreferencePage_gridSpacing_label_inches;

	private String GRID_SPACING_LABEL_CM = DiagramUIMessages.GridRulerPreferencePage_gridSpacing_label_cm;

	private String GRID_SPACING_LABEL_PIXELS = DiagramUIMessages.GridRulerPreferencePage_gridSpacing_label_pixels;

	protected String getPreferenceConstant(int preferenceType) {
		return PreferencesConstantsHelper.getElementConstant(getKey(), preferenceType);
	}

	// Ruler Field Editors
	private BooleanFieldEditor showRulers = null;

	private ComboFieldEditor rulerUnits;

	// Grid Field Editors
	private BooleanFieldEditor showGrid = null;

	private BooleanFieldEditor snapToGrid = null;

	private BooleanFieldEditor snapToGeometry = null;

	private DoubleFieldEditor gridSpacing = null;

	private BooleanFieldEditor gridInFront = null;

	private ComboFieldEditor gridStyle = null;

	private Composite dblGroup = null;

	private ColorFieldEditor gridColorEditor = null;

	/**
	 * 
	 * @param store
	 *        the preference store to initialize
	 */
	public static void initDefaults(IPreferenceStore store) {
		//rulers and grid
		//		String defaultCountry = Locale.getDefault().getCountry();
		//		if(defaultCountry == null || defaultCountry.equals(Locale.US.getCountry()) || defaultCountry.equals(Locale.CANADA.getCountry())) {
		//			store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.RULER_UNITS), RulerProvider.UNIT_INCHES);
		//		} else {
		//			store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.RULER_UNITS), RulerProvider.UNIT_CENTIMETERS);
		//		}
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.RULER_UNITS), RulerProvider.UNIT_PIXELS);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.VIEW_RULER), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.VIEW_GRID), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SNAP_TO_GRID), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SNAP_TO_GEOMETRY), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_LINE_STYLE), Graphics.LINE_CUSTOM);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_ORDER), false);
		//to force the refresh of the value
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_LINE_COLOR), new org.eclipse.swt.graphics.RGB(250, 0, 0));
		final int rgbValue = 50;
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_LINE_COLOR), new org.eclipse.swt.graphics.RGB(rgbValue, rgbValue, rgbValue));

		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_SPACING), 20);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param key
	 * @param dialogPage
	 */
	public RulersAndGridGroup(final Composite parent, final String key, final DialogPage dialogPage) {
		super(parent, key, dialogPage);
		createContents(parent);
	}

	/**
	 * 
	 * @param parent
	 */
	public void createContents(final Composite parent) {
		addRulerFields(parent);
		addGridFields(parent);
	}


	private void addRulerFields(Composite parent) {

		// Create a Group to hold the ruler fields
		Group group = new Group(parent, SWT.NONE);
		group.setText(RULER_GROUP_LABEL);

		GridLayout gridLayout = new GridLayout(1, false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 1;

		// Add the fields to the group
		showRulers = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.VIEW_RULER), SHOW_RULERS_LABEL, group);
		addFieldEditor(showRulers);

		rulerUnits = new ComboFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.RULER_UNITS), RULER_UNITS_LABEL, group, ComboFieldEditor.INT_TYPE_INDEXED, false, 0, 0, true);
		addFieldEditor(rulerUnits);
		rulerUnits.addIndexedItemToCombo(RULER_UNITS_IN_LABEL, RulerProvider.UNIT_INCHES);
		rulerUnits.addIndexedItemToCombo(RULER_UNITS_CM_LABEL, RulerProvider.UNIT_CENTIMETERS);
		rulerUnits.addIndexedItemToCombo(RULER_UNITS_PIXEL_LABEL, RulerProvider.UNIT_PIXELS);
		final Combo rulerUnitsCombo = rulerUnits.getComboControl();
		rulerUnitsCombo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				//do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				updateUnits();
			}
		});
		group.setLayout(gridLayout);
		group.setLayoutData(gridData);

	}

	private void addGridFields(Composite parent) {

		// Create a Group to hold the grid fields
		Group group = new Group(parent, SWT.NONE);
		group.setText(GRID_GROUP_LABEL);

		GridLayout gridLayout = new GridLayout(2, true);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 1;

		showGrid = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.VIEW_GRID), SHOW_GRID_LABEL, group);
		addFieldEditor(showGrid);

		snapToGrid = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.SNAP_TO_GRID), SNAP_TO_GRID_LABEL, group);
		addFieldEditor(snapToGrid);

		snapToGeometry = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.SNAP_TO_GEOMETRY), SNAP_TO_GEOMETRY_LABEL, group);
		addFieldEditor(snapToGeometry);

		gridInFront = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.GRID_ORDER), Messages.RulersAndGridGroup_GridInFront, group);
		addFieldEditor(gridInFront);

		addGridStyle(group);

		addGridColor(group);

		addGridSpacing(group);

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
	}

	private void addGridStyle(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, true));
		this.gridStyle = new ComboFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.GRID_LINE_STYLE), Messages.RulersAndGridGroup_GridStyle, composite, ComboFieldEditor.INT_TYPE_INDEXED, false, 0, 0, true);
		this.gridStyle.addIndexedItemToCombo(LineStyleLabelProvider.LINE_STYLE_SOLID_STRING, Graphics.LINE_SOLID);
		this.gridStyle.addIndexedItemToCombo(LineStyleLabelProvider.LINE_STYLE_DASH_STRING, Graphics.LINE_DASH);
		this.gridStyle.addIndexedItemToCombo(LineStyleLabelProvider.LINE_STYLE_DOT_STRING, Graphics.LINE_DOT);
		this.gridStyle.addIndexedItemToCombo(LineStyleLabelProvider.LINE_STYLE_DASH_DOT_STRING, Graphics.LINE_DASHDOT);
		this.gridStyle.addIndexedItemToCombo(LineStyleLabelProvider.LINE_STYLE_DASH_DOT_DOT_STRING, Graphics.LINE_DASHDOTDOT);
		this.gridStyle.addIndexedItemToCombo(LineStyleLabelProvider.LINE_STYLE_CUSTOM, Graphics.LINE_CUSTOM);
		addFieldEditor(gridStyle);
	}

	private void addGridColor(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		Label label = new Label(composite, SWT.NONE);

		label.setText(Messages.RulersAndGridGroup_GridColor);
		gridColorEditor = new ColorFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.GRID_LINE_COLOR), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_LINE_COLOR), composite);
		addFieldEditor(gridColorEditor);
		composite.setLayout(new GridLayout(2, true));
	}



	private void addGridSpacing(Composite parent) {

		dblGroup = new Composite(parent, SWT.NONE);

		GridLayout gridLayout = new GridLayout(2, false);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;

		gridSpacing = new DoubleFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.GRID_SPACING), GRID_SPACING_LABEL_INCHES, dblGroup);
		gridSpacing.setTextLimit(10);
		addFieldEditor(gridSpacing);

		updateUnits();

		dblGroup.setLayoutData(gridData);
		dblGroup.setLayout(gridLayout);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.preferences.AbstractPreferencePage#initHelp()
	 */
	protected void initHelp() {
		// TODO: Implement to support context help
	}

	/**
	 * The NumberFormatter.parse() could return a Long or Double
	 * We are storing all values related to the page setup as doubles
	 * so we call this function when ever we are getting values from
	 * the dialog.
	 * 
	 * @param number
	 * @return
	 */
	private Double forceDouble(Number number) {
		if(!(number instanceof Double))
			return new Double(number.doubleValue());
		return (Double)number;
	}

	private void updateUnits() {

		int units = getUnits();

		switch(units) {
		case RulerProvider.UNIT_INCHES:
			gridSpacing.setLabelText(GRID_SPACING_LABEL_INCHES);
			break;

		case RulerProvider.UNIT_CENTIMETERS:
			gridSpacing.setLabelText(GRID_SPACING_LABEL_CM);
			break;

		case RulerProvider.UNIT_PIXELS:
			gridSpacing.setLabelText(GRID_SPACING_LABEL_PIXELS);
			break;
		}

		gridSpacing.setStringValue(UnitsConverterUtils.convertUnits(oldUnits, units, gridSpacing.getStringValue()));
		oldUnits = units;

		dblGroup.layout();

	}

	private int getUnits() {
		int units = rulerUnits.getComboControl().getSelectionIndex();

		// IF no selection has been made
		if(units == -1) {
			// Read the preference store
			units = 1;//FIXME;
			oldUnits = units;
		}
		return units;
	}

	//	private String convertUnits(int fromUnits, int toUnits) {
	//		String valueStr = gridSpacing.getStringValue();
	//		if(fromUnits == toUnits) {
	//			return valueStr;
	//		}
	//
	//		//Double value = Double.valueOf( valueStr );
	//		NumberFormat numberFormatter = NumberFormat.getInstance();
	//		Double value = new Double(0.125);
	//		try {
	//			value = forceDouble(numberFormatter.parse(valueStr));
	//		} catch (ParseException e) {
	//			// Use the default
	//		}
	//		double pixelValue = 0;
	//
	//		Display display = getDisplay();
	//
	//		switch(fromUnits) {
	//		case RulerProvider.UNIT_INCHES:
	//			pixelValue = value.doubleValue() * display.getDPI().x;
	//			break;
	//		case RulerProvider.UNIT_CENTIMETERS:
	//			pixelValue = value.doubleValue() * display.getDPI().x / UnitsUtils.INCH2CM;
	//			break;
	//		case RulerProvider.UNIT_PIXELS:
	//			pixelValue = value.intValue();
	//		}
	//
	//		double returnValue = 0;
	//
	//		switch(toUnits) {
	//		case RulerProvider.UNIT_INCHES:
	//			returnValue = pixelValue / display.getDPI().x;
	//			break;
	//		case RulerProvider.UNIT_CENTIMETERS:
	//			returnValue = pixelValue * UnitsUtils.INCH2CM / display.getDPI().x;
	//			break;
	//		case RulerProvider.UNIT_PIXELS:
	//			returnValue = pixelValue;
	//		}
	//
	//		return numberFormatter.format(returnValue);
	//	}


	/**
	 * 
	 * converts the current units used to a base unit value to be used (e.g. in validation)
	 * 
	 * @param number
	 *        Units to be converted to the base unit
	 * @return
	 */
	private double convertToBase(double number) {

		double returnValue = 0;
		switch(getUnits()) {
		case RulerProvider.UNIT_INCHES:
			returnValue = number;
			break;
		case RulerProvider.UNIT_CENTIMETERS:
			returnValue = number / UnitsConstants.INCH2CM;
			break;
		case RulerProvider.UNIT_PIXELS:
			returnValue = number / getDisplay().getDPI().x;
		}
		return returnValue;
	}

	private class DoubleFieldEditor extends StringFieldEditor {

		private double minValidValue = 00.009;

		private double maxValidValue = 99.999;

		public DoubleFieldEditor(String pref, String label, Composite parent) {
			super(pref, label, parent);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.preference.StringFieldEditor#doCheckState()
		 */
		protected boolean doCheckState() {
			Text text = getTextControl();

			if(text == null)
				return false;

			try {
				NumberFormat numberFormatter = NumberFormat.getInstance();
				ParsePosition parsePosition = new ParsePosition(0);
				Number parsedNumber = numberFormatter.parse(text.getText(), parsePosition);

				if(parsedNumber == null) {
					showErrorMessage();
					return false;
				}

				Double pageHeight = forceDouble(parsedNumber);
				double number = pageHeight.doubleValue();
				number = convertToBase(number);
				if(number >= minValidValue && number <= maxValidValue && parsePosition.getIndex() == text.getText().length()) {
					clearErrorMessage();
					return true;
				} else {
					showErrorMessage();
					return false;
				}
			} catch (NumberFormatException e1) {
				showErrorMessage();
			}

			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.preference.StringFieldEditor#doLoadDefault()
		 */
		protected void doLoadDefault() {
			Text text = getTextControl();
			if(text != null) {
				double value = getPreferenceStore().getDefaultDouble(getPreferenceName());
				NumberFormat numberFormatter = NumberFormat.getNumberInstance();
				text.setText(numberFormatter.format(value));
			}
			valueChanged();
		}

		/*
		 * (non-Javadoc)
		 * Method declared on FieldEditor.
		 */
		protected void doLoad() {
			Text text = getTextControl();
			if(text != null) {
				double value = getPreferenceStore().getDouble(getPreferenceName());
				NumberFormat numberFormatter = NumberFormat.getNumberInstance();
				text.setText(numberFormatter.format(value));
			}
		}

		protected void doStore() {
			NumberFormat numberFormatter = NumberFormat.getInstance();
			Double gridWidth;
			try {
				gridWidth = forceDouble(numberFormatter.parse(getTextControl().getText()));
				getPreferenceStore().setValue(getPreferenceName(), gridWidth.doubleValue());
			} catch (ParseException e) {
				showErrorMessage();
			}

		}
	}

}
