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

import java.io.IOException;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IPackageExportDescription;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.Constants;

/**
 * class used to obtain information about bundle that is a project in the workspace
 */

public class WorkspaceBundleDescriptionDesigner extends AbstractBundleDescriptionDesigner {

	/**
	 * 
	 * @see org.eclipse.papyrus.adltool.designer.bundle.AbstractBundleDescriptionDesigner#getBundleValue(java.lang.Object, java.lang.String)
	 *
	 * @param bundleProject
	 * @param key
	 * @return the value that corresponds to the key
	 */
	public String  getBundleValue(Object bundleProject, String key){
		String valueFromDescription=null;
		if(bundleProject instanceof IBundleProjectDescription){
			PropertyResourceBundle propertyResourceBundle=getNLSFilesFor((IBundleProjectDescription)bundleProject);
			valueFromDescription=((IBundleProjectDescription)bundleProject).getHeader(key);
			if( propertyResourceBundle!=null&&valueFromDescription!=null ){
				if (valueFromDescription.startsWith("%") && (valueFromDescription.length() > 1)) { //$NON-NLS-1$
					String propertiesKey = valueFromDescription.substring(1);
					valueFromDescription =  propertyResourceBundle.getString(propertiesKey);
				}
			}
		}
		return valueFromDescription;
	}

	/**
	 * get properties files
	 * @param bundle the bundle description
	 * @return the bundle properties if it exist form Bundle description
	 */
	protected  static PropertyResourceBundle getNLSFilesFor(IBundleProjectDescription bundle) {
		PropertyResourceBundle bundleproperties=null;
		// get the base localization path from the target
		String localization = (String) bundle.getHeader(Constants.BUNDLE_LOCALIZATION);
		if (localization != null){
			// we do a simple check to make sure the default nls path exists in the target; 
			// this is for performance reasons, but I'm not sure it is valid because a target could ship without the default nls properties file but this seems very unlikely
			IFile file=bundle.getProject().getFile(localization + ".properties");
			if( file!=null){
				try {
					bundleproperties= new PropertyResourceBundle(file.getContents());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return bundleproperties;
	}
	/**
	 * create package from exported Packages
	 * @param bundleComponent the description of the bundle
	 * @param bundleProject
	 */
	public void fillExportedPackages(Component bundleComponent, Object bundleProject ) {
		if(bundleProject instanceof IBundleProjectDescription){
			IPackageExportDescription[] packageExportDescription=((IBundleProjectDescription)bundleProject).getPackageExports();
			if(packageExportDescription!=null){
				ArrayList<EObject> exportedPackages= new ArrayList<EObject>();
				for(int i = 0; i < packageExportDescription.length; i++) {
					Package UMLPackage=UMLFactory.eINSTANCE.createPackage();
					UMLPackage.setName(packageExportDescription[i].getName());
					bundleComponent.getPackagedElements().add(UMLPackage);
					Stereotype exportedPackageStereotype=UMLPackage.getApplicableStereotype(IADL4ECLIPSE_Stereotype.ECLIPSEEXPORTEDPACKAGE_STEREOTYPE);
					UMLPackage.applyStereotype(exportedPackageStereotype);
					UMLPackage.setValue(exportedPackageStereotype, IADL4ECLIPSE_Stereotype.ECLIPSEEXPORTEDPACKAGE_ISINTERNAL_ATT, !packageExportDescription[i].isApi());
					if(packageExportDescription[i].getVersion()!=null){
						UMLPackage.setValue(exportedPackageStereotype, IOSGIStereotype.VERSIONRANGE_ATLEAST_ATT, packageExportDescription[i].getVersion().toString());
					}
					exportedPackages.add(UMLPackage.getStereotypeApplication(exportedPackageStereotype));
				}
				Stereotype pluginStereotype=bundleComponent.getAppliedStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);
				bundleComponent.setValue(pluginStereotype, IOSGIStereotype.BUNDLE_EXPORTPACKAGE_ATT, exportedPackages);
			}
		}
	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject) {
		ArrayList<ReferencedOSGIElement> bundleRefList=new ArrayList<ReferencedOSGIElement>();
		if(bundleProject instanceof IBundleProjectDescription){
			IRequiredBundleDescription[] requiredBundleDescriptions=((IBundleProjectDescription)bundleProject).getRequiredBundles();
			if(requiredBundleDescriptions==null){
				return bundleRefList;
			}
			for(int i = 0; i < requiredBundleDescriptions.length; i++) {
				ReferencedOSGIElement newrefElement= new ReferencedOSGIElement(null,requiredBundleDescriptions[i].getName());
				bundleRefList.add(newrefElement);
			}
		}
		return bundleRefList;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getSymbolicName(Object bundleProject) {
		if(bundleProject instanceof IBundleProjectDescription){
			return ((IBundleProjectDescription) bundleProject).getSymbolicName();
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getName(Object bundleProject) {
		return this.getBundleValue(bundleProject, org.osgi.framework.Constants.BUNDLE_NAME);
	}


}
