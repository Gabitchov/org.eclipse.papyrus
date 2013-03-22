/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Vincent Lorenzo - vincent.lorenzo@cea.fr - CEA - LIST
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusElementPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.BackgroundColor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.DecorationGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.LabelGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.NodeColorGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.preferences.CombinedFragmentPreferencePage.NodeCompartmentGroupEx;
import org.eclipse.swt.widgets.Composite;

/**
 * @generated
 */
public class ConsiderIgnoreFragmentPreferencePage extends AbstractPapyrusElementPreferencePage {

	/**
	 * @generated NOT
	 */
	public static final String compartments[] = { Messages.CombinedFragmentCombinedFragmentCompartmentEditPart_title };

	/** the list owning the compartment names for the Node */
	protected List<String> compartmentsList;

	/**
	 * @generated
	 */
	public ConsiderIgnoreFragmentPreferencePage() {
		super();
		setPreferenceKey(PackageEditPart.MODEL_ID + "_ConsiderIgnoreFragment");
		compartmentsList = new ArrayList<String>();
		initializeCompartmentsList();
	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * @generated NOT
	 */
	public static void initDefaults(IPreferenceStore store) {
		String key = PackageEditPart.MODEL_ID + "_ConsiderIgnoreFragment";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 40);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 40);
		for(String name : compartments) {
			String preferenceName = PreferenceConstantHelper.getCompartmentElementConstant(key, name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, true);
		}
		//org.eclipse.jface.preference.PreferenceConverter.setDefault(store, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_FILL), new org.eclipse.swt.graphics.RGB(255, 255, 255));
		//org.eclipse.jface.preference.PreferenceConverter.setDefault(store, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_LINE), new org.eclipse.swt.graphics.RGB(0, 0, 0));
		// Set the default for the gradient
		//store.setDefault(org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.GRADIENT_POLICY),false);
		//org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new  org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(
		//		new org.eclipse.swt.graphics.RGB(255, 255, 255),
		//		new org.eclipse.swt.graphics.RGB(0, 0, 0), 0, 0);
		//store.setDefault(org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper.COLOR_GRADIENT), gradientPreferenceConverter.getPreferenceValue());
	}

	protected TreeMap<String, Boolean> getCompartmentTitleVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		for(String name : compartments) {
			map.put(name, Boolean.FALSE);
		}
		return map;
	}

	protected void initializeCompartmentsList() {
		for(String name : compartments) {
			this.compartmentsList.add(name);
		}
	}

	protected TreeMap<String, String> getLabelRole() {
		return new TreeMap<String, String>();
	}

	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		NodeColorGroup colorGroupForNodeComposite = new NodeColorGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(colorGroupForNodeComposite);
		BackgroundColor backgroundColorGroup = new BackgroundColor(parent, getPreferenceKey(), this);
		addAbstractGroup(backgroundColorGroup);
		DecorationGroup decorationGroup = new DecorationGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(decorationGroup);
		if(!compartmentsList.isEmpty()) {
			NodeCompartmentGroupEx compartmentGroup = new NodeCompartmentGroupEx(parent, getPreferenceKey(), this, compartmentsList, getCompartmentTitleVisibilityPreferences().keySet(), getPreferenceStore());
			addAbstractGroup(compartmentGroup);
		}
		//Label role group
		if(!getLabelRole().isEmpty()) {
			LabelGroup compartmentGroup = new LabelGroup(parent, getPreferenceKey(), this, getLabelRole());
			addAbstractGroup(compartmentGroup);
		}
	}
}
