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
package org.eclipse.papyrus.preferences.pages;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.PapyrusPreferenceStore;
import org.eclipse.papyrus.preferences.pages.internal.VisiblePageSingleton;
import org.eclipse.papyrus.preferences.ui.AbstractGroup;
import org.eclipse.papyrus.preferences.ui.BackgroundColor;
import org.eclipse.papyrus.preferences.ui.ConnectionGroup;
import org.eclipse.papyrus.preferences.ui.DecorationGroup;
import org.eclipse.papyrus.preferences.ui.DimensionGroup;
import org.eclipse.papyrus.preferences.ui.FontGroup;
import org.eclipse.papyrus.preferences.ui.LinkColorGroup;
import org.eclipse.papyrus.preferences.ui.NodeColorGroup;
import org.eclipse.papyrus.preferences.ui.editor.EditorBackgroundColor;
import org.eclipse.papyrus.preferences.ui.editor.EditorConnectionGroup;
import org.eclipse.papyrus.preferences.ui.editor.EditorDecorationGroup;
import org.eclipse.papyrus.preferences.ui.editor.EditorDimensionGroup;
import org.eclipse.papyrus.preferences.ui.editor.EditorFontGroup;
import org.eclipse.papyrus.preferences.ui.editor.EditorLinkColorGroup;
import org.eclipse.papyrus.preferences.ui.editor.EditorNodeColorGroup;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
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
	}

	
	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}

	/**
	 * use to init default preferences at the papyrus level
	 * @param store the preference store
	 */
	public static void initDefaults(IPreferenceStore store) {
		
		//Nodes
		PreferenceConverter.setDefault(store, PreferenceConstantHelper.getPapyrusEditorConstant( PreferenceConstantHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(0, 0, 0));

		// Set the default for the gradient
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.GRADIENT_POLICY), false);
		GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(new org.eclipse.swt.graphics.RGB(255, 255, 255), new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());

		// Links
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.SMOOTHNESS), Smoothness.NONE);
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.JUMPLINK_STATUS), JumpLinkStatus.NONE);
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.JUMPLINK_TYPE), JumpLinkStatus.NONE);
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.JUMPLINK_REVERSE),false );

		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.ROUTING_STYLE), Routing.MANUAL );
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.ROUTING_POLICY_OBSTRUCTION), false);
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.ROUTING_POLICY_DISTANCE), false);
	
		//decoration
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.SHADOW), false );
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.ELEMENTICON), false);
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.QUALIFIEDNAME), false);
	//dimension
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.WIDTH), 100 );
		store.setDefault(PreferenceConstantHelper.getPapyrusEditorConstant(  PreferenceConstantHelper.HEIGHT), 100);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void storeAllPreferences() {
		super.storeAllPreferences();
		((PapyrusPreferenceStore)getPreferenceStore()).deleteAllSubPreference(PreferenceConstantHelper.PAPYRUS_EDITOR_PREFERENCE_PREFIX);

	}
}
