/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.util.StringComparator;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractionPreferencePage.
 * 
 * @generated
 */
public class AbstractionPreferencePage extends
		AbstractPapyrusLinkPreferencePage {

	/**
	 * Instantiates a new abstraction preference page.
	 * 
	 * @generated
	 */
	public AbstractionPreferencePage() {
		super();
		setPreferenceKey(ComponentDiagramEditPart.MODEL_ID + "_Abstraction");
	}

	/**
	 * Gets the bundle id.
	 * 
	 * @return the bundle id
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}

	/**
	 * Inits the defaults.
	 * 
	 * @param store
	 *            the store
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

		String key = ComponentDiagramEditPart.MODEL_ID + "_Abstraction";
		Map<String, Boolean> map = getStaticLabelVisibilityPreferences();
		for (String role : map.keySet()) {
			String preferenceName = PreferenceConstantHelper
					.getLabelElementConstant(key, role,
							PreferenceConstantHelper.LABEL_VISIBILITY);
			store.setDefault(preferenceName, map.get(role));
		}

	}

	/**
	 * Gets the static label role.
	 * 
	 * @return the static label role
	 * @generated
	 */
	private static TreeMap<String, String> getStaticLabelRole() {
		TreeMap<String, String> map = new TreeMap<String, String>(
				new StringComparator());
		map.put("Name", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Stereotype", "");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * Gets the static label visibility preferences.
	 * 
	 * @return the static label visibility preferences
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("Name", Boolean.TRUE);

		map.put("Stereotype", Boolean.TRUE);

		return map;
	}

	/**
	 * Gets the label role.
	 * 
	 * @return the label role
	 * @generated
	 */
	@Override
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}
}
