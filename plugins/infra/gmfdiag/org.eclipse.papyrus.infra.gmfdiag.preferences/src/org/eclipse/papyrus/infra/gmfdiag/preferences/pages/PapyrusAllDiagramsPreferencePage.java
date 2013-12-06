/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *		Patrick Tessier (CEA LIST)- modifications
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.pages;

import java.util.Locale;

import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;
import org.eclipse.papyrus.infra.gmfdiag.preferences.PapyrusPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.BackgroundColor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.ConnectionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.DecorationGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.DimensionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.FontGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.NodeColorGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.RulersAndGridGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorBackgroundColor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorConnectionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorDecorationGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorDimensionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorFontGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorNodeColorGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor.EditorRulersAndGridGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The default preference page all element of diagrams
 * 
 */
public class PapyrusAllDiagramsPreferencePage extends AbstractPapyrusPreferencePage {

	@Override
	protected void createPageContents(Composite parent) {
		Group contentGroup = new Group(parent, 2);
		contentGroup.setLayout(new GridLayout(4, false));

		//FontGroup
		FontGroup fontGroupComposite = new EditorFontGroup(contentGroup, getTitle(), this);
		addAbstractGroup(fontGroupComposite);
		//color
		NodeColorGroup colorGroupForNodeComposite = new EditorNodeColorGroup(contentGroup, getTitle(), this);
		addAbstractGroup(colorGroupForNodeComposite);


		// router for links
		ConnectionGroup connectionGroupComposite = new EditorConnectionGroup(contentGroup, getTitle(), this);
		addAbstractGroup(connectionGroupComposite);

		//background
		BackgroundColor backgroundColorGroup = new EditorBackgroundColor(contentGroup, getTitle(), this);
		addAbstractGroup(backgroundColorGroup);

		DecorationGroup decorationGroupComposite = new EditorDecorationGroup(contentGroup, getTitle(), this);
		addAbstractGroup(decorationGroupComposite);

		DimensionGroup dimensionGroup = new EditorDimensionGroup(contentGroup, getTitle(), this);
		addAbstractGroup(dimensionGroup);

		RulersAndGridGroup viewGroupComposite = new EditorRulersAndGridGroup(parent, getTitle(), this);
		addAbstractGroup(viewGroupComposite);
	}


	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}

	/**
	 * use to init default preferences at the papyrus level
	 * 
	 * @param store
	 *        the preference store
	 */
	public static void initDefaults(IPreferenceStore store) {

		//Nodes
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(0, 0, 0));

		// Set the default for the gradient
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRADIENT_POLICY), false);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(new org.eclipse.swt.graphics.RGB(255, 255, 255), new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());

		// Links
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SMOOTHNESS), Smoothness.NONE);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.JUMPLINK_STATUS), JumpLinkStatus.NONE);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.JUMPLINK_TYPE), JumpLinkStatus.NONE);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.JUMPLINK_REVERSE), false);

		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.ROUTING_STYLE), Routing.MANUAL);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.ROUTING_POLICY_OBSTRUCTION), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.ROUTING_POLICY_DISTANCE), false);

		//decoration
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SHADOW), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.ELEMENTICON), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.QUALIFIEDNAME), false);
		//dimension
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.WIDTH), 100);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.HEIGHT), 100);

		//rulers and grid
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SHOW_RULER), false);
		String defaultCountry = Locale.getDefault().getCountry();
		if(defaultCountry == null || defaultCountry.equals(Locale.US.getCountry()) || defaultCountry.equals(Locale.CANADA.getCountry())) {
			store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.RULER_UNITS), RulerProvider.UNIT_INCHES);
		} else {
			store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.RULER_UNITS), RulerProvider.UNIT_CENTIMETERS);
		}
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SHOW_GRID), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SNAP_TO_GRID), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.SNAP_TO_SHAPE), false);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_STYLE), Graphics.LINE_CUSTOM);
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_IN_FRONT), false);
		PreferenceConverter.setDefault(store, PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_STYLE), new org.eclipse.swt.graphics.RGB(100, 100, 100));
		store.setDefault(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.GRID_SPACING), 0.125);
	}

	/**
	 * {@inheritDoc}
	 */
	public void storeAllPreferences() {
		super.storeAllPreferences();
		((PapyrusPreferenceStore)getPreferenceStore()).deleteAllSubPreference(PreferencesConstantsHelper.PAPYRUS_EDITOR_PREFERENCE_PREFIX);

	}
}
