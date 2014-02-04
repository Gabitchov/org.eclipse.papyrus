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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.util.StringComparator;

/**
 * @generated
 */
public class AssociationBranchLinkPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public AssociationBranchLinkPreferencePage() {
		super();
		setPreferenceKey(ModelEditPart.MODEL_ID + "_AssociationBranchLink");
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
		String key = ModelEditPart.MODEL_ID + "_AssociationBranchLink";
		Map<String, Boolean> map = getStaticLabelVisibilityPreferences();
		for(String role : map.keySet()) {
			String preferenceName = PreferencesConstantsHelper.getLabelElementConstant(key, role, PreferencesConstantsHelper.LABEL_VISIBILITY);
			store.setDefault(preferenceName, map.get(role));
		}
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, String> getStaticLabelRole() {
		TreeMap<String, String> map = new TreeMap<String, String>(new StringComparator());
		map.put("TargetRole", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/role.gif");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("TargetMultiplicity", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/MultiplicityHandler.gif");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("TargetRole", Boolean.TRUE);
		map.put("TargetMultiplicity", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	@Override
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}
}
