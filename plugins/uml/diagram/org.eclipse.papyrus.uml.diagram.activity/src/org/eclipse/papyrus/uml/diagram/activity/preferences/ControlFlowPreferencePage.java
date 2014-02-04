/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.preferences;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.util.StringComparator;
import org.eclipse.swt.widgets.Composite;

/**
 * @generated
 */
public class ControlFlowPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public ControlFlowPreferencePage() {
		super();
		setPreferenceKey(ActivityDiagramEditPart.MODEL_ID + "_ControlFlow");
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
		String key = ActivityDiagramEditPart.MODEL_ID + "_ControlFlow";
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
		map.put("Name", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/label_role/name.png");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Weight", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Guard", "");//$NON-NLS-1$ //$NON-NLS-2$
		map.put("Stereotype", "platform:/plugin/org.eclipse.papyrus.uml.diagram.common/icons/stereotype.gif");//$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/**
	 * @generated
	 */
	private static TreeMap<String, Boolean> getStaticLabelVisibilityPreferences() {
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>();
		map.put("Name", Boolean.FALSE);//$NON-NLS-1$
		map.put("Weight", Boolean.FALSE);//$NON-NLS-1$
		map.put("Guard", Boolean.TRUE);
		map.put("Stereotype", Boolean.TRUE);
		return map;
	}

	/**
	 * @generated
	 */
	protected TreeMap<String, String> getLabelRole() {
		return getStaticLabelRole();
	}

	/**
	 * Create preference page content concerning object flows
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage#createPageContents(org.eclipse.swt.widgets.Composite)
	 * @param parent
	 *        parent composite
	 * @generated NOT
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		// label visibility
		ActivityEdgeLabelVisibilityGroup connectionGroupComposite = new ActivityEdgeLabelVisibilityGroup(parent, getTitle(), this);
		addAbstractGroup(connectionGroupComposite);
	}
}
