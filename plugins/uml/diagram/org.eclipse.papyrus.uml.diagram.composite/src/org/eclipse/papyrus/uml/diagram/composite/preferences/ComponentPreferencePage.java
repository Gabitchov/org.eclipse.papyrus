/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class ComponentPreferencePage extends AbstractPapyrusNodePreferencePage {

	/**
	 * @generated
	 */
	public static final String compartments[] = { "internal structure" };

	/**
	 * @generated
	 */
	public ComponentPreferencePage() {
		super();
		setPreferenceKey(CompositeStructureDiagramEditPart.MODEL_ID + "_Component");
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {
		String key = CompositeStructureDiagramEditPart.MODEL_ID + "_Component";
		store.setDefault(PreferencesConstantsHelper.getElementConstant(key, PreferencesConstantsHelper.WIDTH), 40);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(key, PreferencesConstantsHelper.HEIGHT), 40);
		Map<String, Boolean> map = getStaticCompartmentVisibilityPreferences();
		for(String name : map.keySet()) {
			String preferenceName = PreferencesConstantsHelper.getLabelElementConstant(key, name, PreferencesConstantsHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, map.get(name));
		}
		map = getStaticCompartmentTitleVisibilityPreferences();
		for(String name : map.keySet()) {
			String preferenceName = PreferencesConstantsHelper.getLabelElementConstant(key, name, PreferencesConstantsHelper.COMPARTMENT_NAME_VISIBILITY);
			store.setDefault(preferenceName, map.get(name));
		}
		//org.eclipse.jface.preference.PreferenceConverter.setDefault(store, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		//org.eclipse.jface.preference.PreferenceConverter.setDefault(store, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(0, 0, 0));
		// Set the default for the gradient
		//store.setDefault(org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.GRADIENT_POLICY),false);
		//org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new  org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(
		//		new org.eclipse.swt.graphics.RGB(255, 255, 255),
		//		new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		//store.setDefault(org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());
	}

	/**
	 * @generated
	 */
	@Override
	protected void initializeCompartmentsList() {
		for(String name : compartments) {
			this.compartmentsList.add(name);
		}
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticCompartmentVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("internal structure", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticCompartmentTitleVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("internal structure", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	protected TreeMap<String, Boolean> getCompartmentTitleVisibilityPreferences() {
		return getStaticCompartmentTitleVisibilityPreferences();
	}
}
