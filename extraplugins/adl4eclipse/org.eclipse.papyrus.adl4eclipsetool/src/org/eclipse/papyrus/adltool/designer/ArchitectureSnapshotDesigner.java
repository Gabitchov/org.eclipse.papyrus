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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.Activator;
import org.eclipse.papyrus.adltool.designer.bundle.BundleDesignerRegistry;
import org.eclipse.papyrus.adltool.designer.bundle.ReferencedOSGIElement;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.VersionRange;
//CreateFeatureProjectOperation
//PDECore.getDefault().getFeatureModelManager()

/**
 * this purpose of this class is to provide mechanism to import bundle into model
 *
 */
public abstract class ArchitectureSnapshotDesigner{
	protected HashMap<String, Component> createdBundleIndex=null;
	protected HashMap<String, Object> bundlesIndex=null;
	protected HashMap<String, Object> featureIndex=null;
	protected BundleDesignerRegistry bundleDesignerRegistry=null;
	protected int dependenciesN=0;
	protected ArrayList<Object>bundleInitialList=null;



	/**
	 * The key used to designate the buddy loader associated with a given bundle.
	 */

	protected Package rootPackage;

	private ArchitectureSnapshotDesigner (Package rootPackage) {
		this.rootPackage=rootPackage;
		createdBundleIndex= new HashMap<String, Component>();
		featureIndex= new HashMap<String, Object>();
		bundleDesignerRegistry= new BundleDesignerRegistry();

	}
	/**
	 * 
	 * Constructor.
	 *
	 * @param rootPackage
	 * @param bundleInitialList must not be null
	 */
	public ArchitectureSnapshotDesigner (Package rootPackage, ArrayList<Object>bundleInitialList) {
		this(rootPackage);
		assert(bundleInitialList!=null);
		this.bundleInitialList=bundleInitialList;

	}


	public abstract void runImportBundles();
	/**
	 * 
	 * @return bundles loaded in the platform
	 */
	public static ArrayList<Bundle> getLoadedBundles() {
		final ArrayList<Bundle> bundlesList = new ArrayList<Bundle>();
		BundleContext context = Activator.getDefault().getBundleContext();
		org.osgi.framework.Bundle[] bundles = context.getBundles();
		for(int i = 0; i < bundles.length; i++) {
			bundlesList.add(bundles[i]);
		}

		return bundlesList;
	}

	/**
	 * 
	 * @return the list of bundle description contained in the workspace
	 */
	public static ArrayList<IBundleProjectDescription>getWorkspaceBundle(){
		ArrayList<IBundleProjectDescription> bundleProjectList=new ArrayList<IBundleProjectDescription>();
		IProject[] project=ResourcesPlugin.getWorkspace().getRoot().getProjects();
		BundleContext context = Activator.getDefault().getBundleContext();
		ServiceReference<?> ref = context.getServiceReference(IBundleProjectService.class.getName());
		IBundleProjectService BundleProjectservice = (IBundleProjectService)context.getService(ref);
		for(int i = 0; i < project.length; i++) {
			try {
				if((project[i].getNature(IBundleProjectDescription.PLUGIN_NATURE))!=null){
					IBundleProjectDescription bundleDescription=BundleProjectservice.getDescription(project[i]); 
					bundleProjectList.add(bundleDescription);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return bundleProjectList;
	}

	/**
	 * 
	 * @return the list of bundle description contained in the workspace
	 */
	public static ArrayList<Object>getWorkspaceFeature(){
		ArrayList<Object> featureList= new ArrayList<Object>();
		IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getWorkspaceModels();
		featureList.addAll(Arrays.asList(featureModels));
		return featureList;
	}

	/**
	 * 
	 * @return the list of bundle description contained in the workspace
	 */
	public static ArrayList<Object>getFeature(){
		ArrayList<Object> featureList= new ArrayList<Object>();
		IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getModels();
		featureList.addAll(Arrays.asList(featureModels));
		return featureList;
	}


	/**
	 * model all bundle contained in the workspaces
	 * @param pluginPackage the name of UML package that represent the plugin
	 */
	protected void modelBundles(Package pluginPackage){
		ArrayList<Object> bundleProjects= new ArrayList<Object>();
		bundleProjects.addAll(bundleInitialList);
		Iterator<Object> bundleProjectsIterator= bundleProjects.iterator();
		while(bundleProjectsIterator.hasNext()) {
			Object bundleProject = (Object)bundleProjectsIterator.next();
			modelBundle(pluginPackage, bundleProject);
		}
		System.out.println("created bundles numbers: "+createdBundleIndex.keySet().size());
		System.out.println("dependenciess: "+dependenciesN);

	}

//	protected void modelWorkspaceFeatures(Package pluginPackage, boolean createAll){
//		//	IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getModels();
//		IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getWorkspaceModels();
//		for(int i = 0; i < featureModels.length; i++) {
//			modelAFeature(pluginPackage,featureModels[i], createAll);
//		}
//
//	}

//	protected void modelPlatformFeatures(Package pluginPackage, boolean createAll){
//		//	IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getModels();
//		IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getModels();
//		for(int i = 0; i < featureModels.length; i++) {
//			modelAFeature(pluginPackage,featureModels[i], createAll);
//		}
//
//	}
//	protected void modelAFeature(Package pluginPackage, IFeatureModel featureModel, boolean createAll){
//
//		Component bundleComponent= UMLFactory.eINSTANCE.createComponent();
//		bundleComponent.setName(featureModel.getFeature().getId());
//		pluginPackage.getPackagedElements().add(bundleComponent);
//		Stereotype featureStereotype=bundleComponent.getApplicableStereotype(IADL4ECLIPSE_Stereotype.FEATURE_STEREOTYPE);
//		bundleComponent.applyStereotype(featureStereotype);
//		bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_ID_ATT,featureModel.getFeature().getId());
//		bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_VERSION_ATT,featureModel.getFeature().getVersion());
//		//bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_COPYRIGHT_ATT,featureModel.getFeature().getVersion());
//		//bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_DESCRIPTION_ATT,featureModel.getFeature().get);
//		bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_IMAGE_ATT,featureModel.getFeature().getImageName());
//		bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_LABEL_ATT,featureModel.getFeature().getLabel());
//		bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_LICENSE_ATT,featureModel.getFeature().getLicenseFeatureID());
//		bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_PROVIDER_ATT,featureModel.getFeature().getProviderName());
//		//bundleComponent.setValue(featureStereotype, IADL4ECLIPSE_Stereotype.FEATURE_URL_ATT,featureModel.getFeature().getURL());
//
//	}



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
		Stereotype pluginStereotype=bundleComponent.getApplicableStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);
		bundleComponent.applyStereotype(pluginStereotype);
		//add in the index of bundles
		createdBundleIndex.put(bundleDesignerRegistry.getSymbolicName(bundleProject), bundleComponent);
		fillRequiredBundle(bundleComponent, bundleProject, pluginPackage);
		bundleDesignerRegistry.fillPluginProperties(bundleComponent, bundleProject);
		bundleDesignerRegistry.fillExportedPackages(bundleComponent, bundleProject);
	}
}

/**
 * Ensure that the profile ADL4 eclipse has been applied
 */
protected void initModel(){
	RegisteredProfile registeredProfile=RegisteredProfile.getRegisteredProfile("ADL4Eclipse");
	if(registeredProfile!=null){
		URI modelUri = registeredProfile.uri;
		final Resource modelResource = Util.getResourceSet(rootPackage).getResource(modelUri, true);
		Profile adl4eclipseprofile=(Profile) modelResource.getContents().get(0);
		PackageUtil.applyProfile(rootPackage, adl4eclipseprofile, false);
	}
}

protected Object getBundle(String name){
	if(bundlesIndex==null){
		bundlesIndex= new HashMap<String, Object>();
		//loaded bundle
		BundleContext context = Activator.getDefault().getBundleContext();
		org.osgi.framework.Bundle[] bundles = context.getBundles();
		for(int i = 0; i < bundles.length; i++) {
			bundlesIndex.put(bundleDesignerRegistry.getSymbolicName(bundles[i]), bundles[i]);
		}
		IProject[] project=ResourcesPlugin.getWorkspace().getRoot().getProjects();
		//bundle Workspace
		ServiceReference<?> ref = context.getServiceReference(IBundleProjectService.class.getName());
		IBundleProjectService BundleProjectservice = (IBundleProjectService)context.getService(ref);
		for(int i = 0; i < project.length; i++) {
			try {
				if((project[i].getNature(IBundleProjectDescription.PLUGIN_NATURE))!=null){
					IBundleProjectDescription bundleDescription=BundleProjectservice.getDescription(project[i]); 
					bundlesIndex.put(bundleDesignerRegistry.getSymbolicName(bundleDescription), bundleDescription);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

	}

	return bundlesIndex.get(name);

}
/**
 * Model the required bundle. if it not exist the bundle is modeling. 
 * It create a stereotyped dependency to the required element
 * @param bundleComponent the description of the bundle
 * @param bundleProject
 */
protected void fillRequiredBundle(Component bundleComponent,Object bundleProject,Package library ) {
	ArrayList<ReferencedOSGIElement> requiredBundleNameList=bundleDesignerRegistry.getRequiredBundle(bundleComponent, bundleProject);
	Iterator<ReferencedOSGIElement> bundleNameIterator= requiredBundleNameList.iterator();
	while(bundleNameIterator.hasNext()) {
		dependenciesN++;
		ReferencedOSGIElement bundleRef = (ReferencedOSGIElement)bundleNameIterator.next();
		if(!(createdBundleIndex.containsKey(bundleRef.getSymbolicName()))){
			modelBundle(library, getBundle(bundleRef.getSymbolicName()));
		}
		Component requiredComponent=createdBundleIndex.get(bundleRef.getSymbolicName());
		Dependency dependency=UMLFactory.eINSTANCE.createDependency();
		dependency.setName(requiredComponent.getName());
		bundleComponent.getPackagedElements().add(dependency);
		dependency.getClients().add(bundleComponent);
		dependency.getSuppliers().add(requiredComponent);
		Stereotype bRef_stereotype= dependency.getApplicableStereotype(IOSGIStereotype.BUNDLEREFERENCE_);
		dependency.applyStereotype(bRef_stereotype);
		VersionRange versionRange=bundleRef.getVersion();
		if( versionRange!=null){
			if( versionRange.getRight()==null){
				dependency.setValue(bRef_stereotype, IOSGIStereotype.VERSIONRANGE_ATLEAST_ATT, versionRange.getLeft().toString());
				System.out.println("  "+versionRange.getLeft());
			}	
			else{
				dependency.setValue(bRef_stereotype, IOSGIStereotype.VERSIONRANGE_FLOOR_ATT, versionRange.getLeft().toString());
				dependency.setValue(bRef_stereotype, IOSGIStereotype.VERSIONRANGE_CEILING_ATT, versionRange.getRight().toString());
				dependency.setValue(bRef_stereotype, IOSGIStereotype.VERSIONRANGE_INCLUDEFLOOR_ATT, versionRange.getRightType()==VersionRange.LEFT_OPEN);
				dependency.setValue(bRef_stereotype, IOSGIStereotype.VERSIONRANGE_INCLUDECEILING_ATT, versionRange.getRightType()==VersionRange.RIGHT_OPEN);
				System.out.println("  "+versionRange.getRight()+" "+versionRange.getLeft());
			}	
		}
	}
}


}
