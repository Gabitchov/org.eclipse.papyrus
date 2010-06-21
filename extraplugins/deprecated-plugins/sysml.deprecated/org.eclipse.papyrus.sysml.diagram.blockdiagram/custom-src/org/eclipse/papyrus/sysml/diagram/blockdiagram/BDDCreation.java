/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.sysml.diagram.blockdiagram;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlDiagramEditorPlugin;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;


public class BDDCreation extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/**
	 * Name of the Diagram
	 */
	protected static final String CSD_DEFAULT_NAME = "BDD"; //$NON-NLS-1$

	public static final String MODEL_ID = "BDD"; //$NON-NLS-1$

	public BDDCreation() {
	}

	/**
	 * {@inheritDoc}
	 */
	protected String getDefaultDiagramName() {
		return openDiagramNameDialog(CSD_DEFAULT_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	protected String getDiagramNotationID() {
		return MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	protected PreferencesHint getPreferenceHint() {
		return SysmlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * {@inheritDoc}
	 */
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * Overrides to add the SysML profile to the nearest containing package if it is not yet applied {@inheritDoc}
	 */
	@Override
	protected void initializeModel(EObject owner) {
		if(owner instanceof Element) {
			Element element = (Element)owner;
			Package pack = element.getNearestPackage();

			if((pack.getAppliedProfile("SysML::Blocks", true) == null) || (pack.getAppliedProfile("SysML::PortAndFlows", true) == null)) {
				// Retrieve SysML profile and apply with sub-profiles
				Profile sysml = (Profile)PackageUtil.loadPackage(URI.createURI(SysmlResource.SYSML_PROFILE_URI), pack.eResource().getResourceSet());
				PackageUtil.applyProfile(pack, sysml, true);
			}
		}
		super.initializeModel(owner);
	}

}
