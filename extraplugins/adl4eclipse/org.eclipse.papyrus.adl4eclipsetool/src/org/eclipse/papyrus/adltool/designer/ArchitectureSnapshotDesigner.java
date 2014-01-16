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
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
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
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.VersionRange;

/**
 * this purpose of this class is to provide mechanism to import bundle into model
 *
 */
@SuppressWarnings("restriction")
public abstract class ArchitectureSnapshotDesigner{
	protected HashMap<String, Object> bundlesIndex=null;
	protected HashMap<String, Component> createdFeatureIndex=null;
	protected HashMap<String, Object> featureIndex=null;
	protected BundleDesignerRegistry bundleDesignerRegistry=null;
	protected int dependenciesN=0;
	protected ArrayList<Object>bundleInitialList=null;
	protected int dependencyLevelMax=1; 



	/**
	 * The key used to designate the buddy loader associated with a given bundle.
	 */

	protected Package rootPackage;
	private Bundle systemBundle;

	private ArchitectureSnapshotDesigner (Package rootPackage) {
		this.rootPackage=rootPackage;
		bundleDesignerRegistry= new BundleDesignerRegistry();
		createdFeatureIndex= new HashMap<String, Component>();

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

	/**
	 * this method is used to launch the import of bundle into models
	 */
	public abstract void runImportBundles();
	/**
	 * 
	 * @return bundles loaded in the platform
	 */
	public static ArrayList<Bundle> getLoadedBundles() {
		ArrayList<Bundle> pluginList= new ArrayList<Bundle>();
		Bundle[] bundleArray=PDECore.getDefault().getBundleContext().getBundles();
		pluginList.addAll(Arrays.asList(bundleArray));
		return pluginList;
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
			modelBundle(pluginPackage, bundleProject,0);
		}
		System.out.println("created bundles numbers: "+createdFeatureIndex.keySet().size());
		System.out.println("dependencies: "+dependenciesN);

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


	protected void modelPseudoBundle(Package pluginPackage, String ID) {
		Component bundleComponent= UMLFactory.eINSTANCE.createComponent();
		System.out.println("PS-->"+ID);
		bundleComponent.setName(ID);
		pluginPackage.getPackagedElements().add(bundleComponent);
		createdFeatureIndex.put(ID, bundleComponent);
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
	protected void modelBundle(Package pluginPackage, Object bundleProject, int currentLevel) {

		if(bundleProject instanceof IFeatureModel){
			if(!(createdFeatureIndex.containsKey(bundleDesignerRegistry.getSymbolicName(bundleProject)))){
				Component bundleComponent= UMLFactory.eINSTANCE.createComponent();
				System.out.println("F-->"+bundleDesignerRegistry.getSymbolicName(bundleProject));
				bundleComponent.setName(bundleDesignerRegistry.getSymbolicName(bundleProject));
				pluginPackage.getPackagedElements().add(bundleComponent);
				Stereotype pluginStereotype=bundleComponent.getApplicableStereotype(IADL4ECLIPSE_Stereotype.FEATURE_STEREOTYPE);
				bundleComponent.applyStereotype(pluginStereotype);
				//add in the index of bundles
				if( bundleDesignerRegistry.getSymbolicName(bundleProject)!=null){
					createdFeatureIndex.put(bundleDesignerRegistry.getSymbolicName(bundleProject), bundleComponent);
				}
				else{
					System.err.println("bundle symbolic name is null");
				}
				fillRequiredBundle(bundleComponent, bundleProject, pluginPackage, currentLevel);
				fillReferencedPlugins(pluginPackage,(IFeatureModel) bundleProject, currentLevel, bundleComponent);

				//bundleDesignerRegistry.fillPluginProperties(bundleComponent, bundleProject);
				//bundleDesignerRegistry.fillExportedPackages(bundleComponent, bundleProject);
			}

		}else{

			if(!(createdFeatureIndex.containsKey(bundleDesignerRegistry.getSymbolicName(bundleProject)))){


				Component bundleComponent= UMLFactory.eINSTANCE.createComponent();

				System.out.println("P ("+currentLevel+")-->"+bundleDesignerRegistry.getSymbolicName(bundleProject));

				bundleComponent.setName(bundleDesignerRegistry.getSymbolicName(bundleProject));
				pluginPackage.getPackagedElements().add(bundleComponent);
				Stereotype pluginStereotype=bundleComponent.getApplicableStereotype(IADL4ECLIPSE_Stereotype.PLUGIN_STEREOTYPE);
				bundleComponent.applyStereotype(pluginStereotype);
				//add in the index of bundles
				if("org.eclipse.osgi".equals(bundleDesignerRegistry.getSymbolicName(bundleProject))){
					createdFeatureIndex.put(org.osgi.framework.Constants.SYSTEM_BUNDLE_SYMBOLICNAME, bundleComponent);
				}
				if( bundleDesignerRegistry.getSymbolicName(bundleProject)!=null){
					createdFeatureIndex.put(bundleDesignerRegistry.getSymbolicName(bundleProject), bundleComponent);
				}
				else{
					System.err.println("bundle symbolic name is null");
				}
				fillRequiredBundle(bundleComponent, bundleProject, pluginPackage,currentLevel );
				bundleDesignerRegistry.fillPluginProperties(bundleComponent, bundleProject);
				bundleDesignerRegistry.fillExportedPackages(bundleComponent, bundleProject);
				modelExtensions(bundleComponent,bundleProject, currentLevel);
			}
		}
	}
	protected void modelExtensions(Component bundleComponent,Object bundleProject, int currentLevel) {
		if(currentLevel>=dependencyLevelMax){
			return;
		}
		
		//list all extensions use and declaration
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtension[] extensions= extensionRegistry.getExtensions(bundleDesignerRegistry.getSymbolicName(bundleProject));
		System.out.println("nb extension "+extensions.length);
		
		
		for(int i = 0; i < extensions.length; i++) {
			//use or declaration create it!
			Port clientPort=bundleComponent.createOwnedPort(extensions[i].getExtensionPointUniqueIdentifier(), null);
			String ownerID=extensionRegistry.getExtensionPoint(extensions[i].getExtensionPointUniqueIdentifier()).getNamespaceIdentifier();
			System.out.println("---------> "+extensions[i].getExtensionPointUniqueIdentifier()+" FROM "+ownerID );
			
			//look for the plugin that declare the extension point
			Object foundBundle=getBundle(ownerID );
			if (foundBundle!=null){
				if(!(createdFeatureIndex.containsKey(ownerID)))	{
					modelBundle(bundleComponent.getNearestPackage(),foundBundle, currentLevel+1);
				}
			}
			else {
				modelPseudoBundle(bundleComponent.getNearestPackage(),ownerID);
			}

			Component componentOwner=createdFeatureIndex.get(ownerID);
			// if the declaration of the bundle is the same bundle , this is a declaration so no link to create
			if(!componentOwner.equals(bundleComponent)){
				Port supplierPort= componentOwner.getOwnedPort(extensions[i].getExtensionPointUniqueIdentifier(), null);
				if(supplierPort==null ){
					supplierPort=componentOwner.createOwnedPort(extensions[i].getExtensionPointUniqueIdentifier(), null);
				}
				modelRelationExtensionBased(bundleComponent, extensions[i], clientPort, supplierPort);
			}
		}
	}

	/**
	 * create a model element between 2 elements that represents relation between two extension point
	 * @param bundleComponent the component that use extension
	 * @param extension the extension point	
	 * @param clientPort the port that represent the use to the extension point
	 * @param supplierPort the port that represent the declaration of this extension point
	 */
	protected void modelRelationExtensionBased(Component bundleComponent, IExtension extension, Port clientPort, Port supplierPort) {
		Dependency dependency=UMLFactory.eINSTANCE.createDependency();
		dependency.setName(extension.getExtensionPointUniqueIdentifier());
		//bundleComponent.getNearestPackage().getPackagedElements().add(dependency);
		bundleComponent.getPackagedElements().add(dependency);
		dependency.getClients().add(clientPort);
		dependency.getSuppliers().add(supplierPort);
	}

	/**
	 * fill the list of referenced plug-ins of a feature. for each plug-in a property will be created
	 * @param pluginPackage the package that will contain plug-ins
	 * @param bundleProject the bundle project that represents a feature
	 * @param currentLevel the current level about dependency depth
	 * @param bundleComponent model in UML that correspond to the bundle project
	 */
	protected void fillReferencedPlugins(Package pluginPackage, IFeatureModel bundleProject, int currentLevel, Component bundleComponent) {
		IFeaturePlugin[] pluginsList=bundleProject.getFeature().getPlugins();
		for(int i = 0; i < pluginsList.length; i++) {
			System.out.println("+-> P from F ("+currentLevel+")" +pluginsList[i].getId() );
			Object foundBundle=getBundle(pluginsList[i].getId() );
			if( foundBundle==null){
				System.err.println("Cannot find the plugin : "+pluginsList[i].getId() );
				System.err.println("Memory\n"+ this);
			}
			else{
				modelBundle(pluginPackage, foundBundle, currentLevel);
				Component createdBundle=createdFeatureIndex.get(pluginsList[i].getId());
				bundleComponent.createOwnedAttribute(pluginsList[i].getId(), createdBundle);
			}
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

	protected Object getfeature(String name){
		if(featureIndex==null){
			featureIndex= new HashMap<String, Object>();
			IFeatureModel[] featureModels=PDECore.getDefault().getFeatureModelManager().getModels();
			for(int i = 0; i < featureModels.length; i++) {
				System.out.println("feature known: "+bundleDesignerRegistry.getSymbolicName(featureModels[i]));
				featureIndex.put(bundleDesignerRegistry.getSymbolicName(featureModels[i]), featureModels[i]);
			}
		}
		return featureIndex.get(name);
	}

	protected Object getBundle(String name){

		if(bundlesIndex==null){
			bundlesIndex= new HashMap<String, Object>();
			//loaded bundle
			BundleContext context = Activator.getDefault().getBundleContext();
			systemBundle = context.getBundle(0);
			bundlesIndex.put(org.osgi.framework.Constants.SYSTEM_BUNDLE_SYMBOLICNAME, systemBundle);
			bundlesIndex.put(bundleDesignerRegistry.getSymbolicName( systemBundle), systemBundle);
			System.out.println(bundleDesignerRegistry.getName( systemBundle)+ " "+bundleDesignerRegistry.getSymbolicName( systemBundle));
			org.osgi.framework.Bundle[] bundles = context.getBundles();

			for(int i = 0; i < bundles.length; i++) {
				if( bundleDesignerRegistry.getSymbolicName(bundles[i])!=null){
					bundlesIndex.put(bundleDesignerRegistry.getSymbolicName(bundles[i]), bundles[i]);
				}
				else{
					System.err.println("Bundle has a symbolic name null!");
				}
				if( bundleDesignerRegistry.getName(bundles[i])!=null){
					bundlesIndex.put(bundleDesignerRegistry.getName(bundles[i]), bundles[i]);
				}
				else{
					System.err.println("Bundle has a  name null!");
				}
			}
			IProject[] project=ResourcesPlugin.getWorkspace().getRoot().getProjects();
			//bundle Workspace
			ServiceReference<?> ref = context.getServiceReference(IBundleProjectService.class.getName());
			IBundleProjectService BundleProjectservice = (IBundleProjectService)context.getService(ref);
			for(int i = 0; i < project.length; i++) {
				try {
					if((project[i].getNature(IBundleProjectDescription.PLUGIN_NATURE))!=null){
						IBundleProjectDescription bundleDescription=BundleProjectservice.getDescription(project[i]); 
						bundlesIndex.put(bundleDesignerRegistry.getBundleValue(bundleDescription, org.osgi.framework.Constants.BUNDLE_NAME), bundleDescription);
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
	protected void fillRequiredBundle(Component bundleComponent,Object bundleProject,Package library, int currentLevel ) {
		ArrayList<ReferencedOSGIElement> requiredBundleNameList=bundleDesignerRegistry.getRequiredBundle(bundleComponent, bundleProject);
		Iterator<ReferencedOSGIElement> bundleNameIterator= requiredBundleNameList.iterator();
		if(currentLevel>=dependencyLevelMax){
			return;
		}
		while(bundleNameIterator.hasNext()) {
			dependenciesN++;
			ReferencedOSGIElement bundleRef = (ReferencedOSGIElement)bundleNameIterator.next();
			Component requiredComponent=null;
			Object foundBundle=getBundle(bundleRef.getSymbolicName() );

			if(bundleRef.isOptional()||foundBundle!=null){
				if (foundBundle!=null){
					if((!(createdFeatureIndex.containsKey(bundleRef.getSymbolicName())))&&(!(createdFeatureIndex.containsKey(bundleRef.getSymbolicName()))))	{
						if( isInitialPlugin(bundleRef.getSymbolicName())){
							modelBundle(library,foundBundle, currentLevel);
						}
						else{
						modelBundle(library,foundBundle, currentLevel+1);}
					}
				}
				else {
					modelPseudoBundle(library,bundleRef.getSymbolicName());
				}
				requiredComponent=createdFeatureIndex.get(bundleRef.getSymbolicName());
				Dependency dependency=UMLFactory.eINSTANCE.createDependency();
				dependency.setName(requiredComponent.getName());
				//bundleComponent.getNearestPackage().getPackagedElements().add(dependency);
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

			else if ((!bundleRef.isOptional())&&foundBundle==null){
				System.err.println("pb: impossible to find the get the bundle dependency "+ bundleRef.getSymbolicName()+ " for "+bundleDesignerRegistry.getSymbolicName(bundleProject));
				System.err.println("Memory\n"+ this);}
		}
	}

	@Override
	public String toString() {
		String out= "loaded bundles:\n";
		for(Iterator<String> iterator = bundlesIndex.keySet().iterator(); iterator.hasNext();) {
			String id = (String)iterator.next();
			out=out+"\n"+id;
		}
		out=out+ "\ncreated bundles:\n";
		for(Iterator<String> iterator = createdFeatureIndex.keySet().iterator(); iterator.hasNext();) {
			String id = (String)iterator.next();
			out=out+"\n"+id;
		}
		return out;
	}
	protected boolean isInitialPlugin(String name) {
		Iterator<Object> bundleProjectsIterator= bundleInitialList.iterator();
		while(bundleProjectsIterator.hasNext()) {
			Object bundleProject = (Object)bundleProjectsIterator.next();
			if(name.equals(bundleDesignerRegistry.getSymbolicName(bundleProject))){
				return true;
			}
		}
		return false;
	}

}
