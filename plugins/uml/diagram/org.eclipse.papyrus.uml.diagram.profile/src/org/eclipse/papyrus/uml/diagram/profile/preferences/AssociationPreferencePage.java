/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.profile.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.uml.diagram.common.util.StringComparator;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class AssociationPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public AssociationPreferencePage() {
		super();
		setPreferenceKey(ProfileDiagramEditPart.MODEL_ID + "_Association");
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
		String key = ProfileDiagramEditPart.MODEL_ID + "_Association";
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
		map.put("Stereotype", "platform:/plugin/org.eclipse.uml2.uml.edit/icons/full/obj16/Stereotype.gif");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Name", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/name.png");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("TargetRole", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/role.gif");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("SourceRole", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/role.gif");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("SourceMultiplicity", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/MultiplicityHandler.gif");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("TargetMultiplicity", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/MultiplicityHandler.gif");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("Stereotype", Boolean.FALSE);//$NON-NLS-1$
		map.put("Name", Boolean.FALSE);//$NON-NLS-1$
		map.put("TargetRole", Boolean.TRUE);
		map.put("SourceRole", Boolean.FALSE);//$NON-NLS-1$
		map.put("SourceMultiplicity", Boolean.FALSE);//$NON-NLS-1$
		map.put("TargetMultiplicity", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}
}
