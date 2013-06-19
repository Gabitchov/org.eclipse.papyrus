/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer;

import java.util.ArrayList;

import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * designer to construct the architecture of feature from the workspace and platform
 *
 */
public class CompleteFeatureArchitectureSnapshotDesigner extends ArchitectureSnapshotDesigner {

	public CompleteFeatureArchitectureSnapshotDesigner(Package rootPackage, ArrayList<Object> bundleInitialList) {
		super(rootPackage, bundleInitialList);
	}
	@Override
	public void runImportBundles() {
		initModel();
		modelBundles(rootPackage);
	}
	/**
	 * Model a bundle into the plugins packages:
	 * <UL>
	 * <LI> model the bundle as a stereotyped UML component
	 * <LI>add links to required bundle
	 * <LI> fill information about exported packages 
	 * </UL>
	 * 
	 *
	 * @param pluginPackage
	 * @param bundleProjectsIterator
	 */
	protected void modelBundle(Package pluginPackage, Object bundleProject) {

		if(!createdBundleIndex.containsKey(bundleDesignerRegistry.getSymbolicName(bundleProject))){
			Component bundleComponent= UMLFactory.eINSTANCE.createComponent();
			System.out.println("-->"+bundleDesignerRegistry.getSymbolicName(bundleProject));
			bundleComponent.setName(bundleDesignerRegistry.getSymbolicName(bundleProject));
			pluginPackage.getPackagedElements().add(bundleComponent);
			Stereotype pluginStereotype=bundleComponent.getApplicableStereotype(IADL4ECLIPSE_Stereotype.FEATURE_STEREOTYPE);
			bundleComponent.applyStereotype(pluginStereotype);
			//add in the index of bundles
			createdBundleIndex.put(bundleDesignerRegistry.getSymbolicName(bundleProject), bundleComponent);
			fillRequiredBundle(bundleComponent, bundleProject, pluginPackage);
			//bundleDesignerRegistry.fillPluginProperties(bundleComponent, bundleProject);
			//bundleDesignerRegistry.fillExportedPackages(bundleComponent, bundleProject);
		}
	}
}
