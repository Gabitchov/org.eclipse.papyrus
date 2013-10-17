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
package org.eclipse.papyrus.adltool.designer.bundle;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.VersionRange;

/**
 * this class is an implementation for  Bundle element -JAVA object of loaded bundle in the platform
 *
 */
public class LoadedBundleDescriptionDesigner extends AbstractBundleDescriptionDesigner {

	/**
	 * 
	 * @see org.eclipse.papyrus.adltool.designer.bundle.AbstractBundleDescriptionDesigner#getBundleValue(java.lang.Object, java.lang.String)
	 *
	 * @param bundleProject
	 * @param key
	 * @return the value that correspond to the key
	 */
	public String getBundleValue(Object bundleProject, String key) {
		if(bundleProject instanceof Bundle){
			return ((Bundle)bundleProject).getHeaders().get(key);
		}
		return null;
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#fillExportedPackages(org.eclipse.uml2.uml.Component, java.lang.Object)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 */
	public void fillExportedPackages(Component bundleComponent, Object bundleProject ) {
		if(bundleProject instanceof Bundle){
			ArrayList<EObject> exportedPackages= new ArrayList<EObject>();
			String exportPackageString=getBundleValue( bundleProject, Constants.EXPORT_PACKAGE);
			try {
				ManifestElement[] manisfests=ManifestElement.parseHeader(Constants.EXPORT_PACKAGE, exportPackageString);
				if(manisfests!=null){
					for(int i = 0; i < manisfests.length; i++) {
						ReferencedOSGIElement newRefElement= new ReferencedOSGIElement(null,manisfests[i].getValue());
						Package UMLPackage=UMLFactory.eINSTANCE.createPackage();
						UMLPackage.setName(manisfests[i].getValue());
						bundleComponent.getPackagedElements().add(UMLPackage);

						Stereotype exportedPackageStereotype=UMLPackage.getApplicableStereotype(IADL4ECLIPSE_Stereotype.ECLIPSEEXPORTEDPACKAGE_STEREOTYPE);
						UMLPackage.applyStereotype(exportedPackageStereotype);	
						if((manisfests[i].getDirective("x-internal"))!=null){
							String booleanString=(manisfests[i].getDirective("x-internal"));
							boolean value=Boolean.parseBoolean(booleanString);
							UMLPackage.setValue(exportedPackageStereotype, IADL4ECLIPSE_Stereotype.ECLIPSEEXPORTEDPACKAGE_ISINTERNAL_ATT,value);
						}
						if((manisfests[i].getDirective("x-friends"))!=null){
							//TODO: xfriends
						}

						if( manisfests[i].getAttribute("version")!=null){
							VersionRange version= new VersionRange( manisfests[i].getAttribute("version"));
							newRefElement.setVersion(version);
							UMLPackage.setValue(exportedPackageStereotype, IOSGIStereotype.VERSIONRANGE_ATLEAST_ATT, version.toString());

						}
						exportedPackages.add(UMLPackage.getStereotypeApplication(exportedPackageStereotype));
					}
					Stereotype pluginStereotype=bundleComponent.getAppliedStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);
					bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_EXPORTPACKAGE_ATT, exportedPackages);
				}
			} catch (BundleException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getRequiredBundle(org.eclipse.uml2.uml.Component, java.lang.Object)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 * @return the list of required bundle
	 */
	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject) {
		ArrayList<ReferencedOSGIElement> bundleListName=new ArrayList<ReferencedOSGIElement>();
		String requiredbundleString=getBundleValue( bundleProject, Constants.REQUIRE_BUNDLE);
		try {
			ManifestElement[] manisfests=ManifestElement.parseHeader(Constants.REQUIRE_BUNDLE, requiredbundleString);
			if(manisfests!=null){
				for(int i = 0; i < manisfests.length; i++) {
					ReferencedOSGIElement newRefElement= new ReferencedOSGIElement(null,manisfests[i].getValue());
					if( manisfests[i].getAttribute(Constants.BUNDLE_VERSION.toLowerCase())!=null){
						VersionRange version= new VersionRange( manisfests[i].getAttribute(Constants.BUNDLE_VERSION.toLowerCase()));
						newRefElement.setVersion(version);
						if (manisfests[i].getDirective(Constants.RESOLUTION_DIRECTIVE)!=null){
							if( (manisfests[i].getDirective(Constants.RESOLUTION_DIRECTIVE).equals(Constants.RESOLUTION_OPTIONAL))){
								newRefElement.setOptional(true);
							}
						}
					}
					bundleListName.add(newRefElement);

				}
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}

		return bundleListName;
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getSymbolicName(java.lang.Object)
	 *
	 * @param bundleProject
	 * @return a string for the symbolic name
	 */
	public String getSymbolicName(Object bundleProject) {

		if(bundleProject instanceof Bundle){
			return ((Bundle)bundleProject).getSymbolicName();
		}
		return null;

	}
	public String getName(Object bundleProject) {
		return this.getBundleValue(bundleProject, org.osgi.framework.Constants.BUNDLE_NAME);
	}
}
