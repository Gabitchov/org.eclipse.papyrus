/*****************************************************************************
 * Copyright (c) 2013 PROTEUS Project Consortium.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Sebastien BONNET (EFFIDENCE) - Initial API and implementation
 * Nicolas DU LAC (INTEMPORA) - Additional methods and a few updates.
 *
 *****************************************************************************/

package org.eclipse.papyrus.robotml.generators.common.mmqueries;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.RobotML.Allocate;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.RobotML.Platform;
import org.eclipse.papyrus.RobotML.RoboticMiddleware;
import org.eclipse.papyrus.RobotML.RoboticSimulator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

public class DeploymentQueries {
	/**
	 * Return the list of instance specifications in a model
	 * @param model
	 * @return A list of InstanceSpecification of all instance specifications
	 */
	static public List<InstanceSpecification> getInstanceSpecificationsInModel(Model model) {
		LinkedList<InstanceSpecification> found_elts = new LinkedList<InstanceSpecification>();
		for (Element ne : model.getOwnedElements()) {
			if (ne instanceof NamedElement) {
				if (ne instanceof org.eclipse.uml2.uml.InstanceSpecification) {
					found_elts.add((InstanceSpecification)ne);
					//System.out.println("Instance : "+((NamedElement) ne).getName());
				}else if(ne instanceof org.eclipse.uml2.uml.Package){
					found_elts.addAll(getInstanceSpecificationsInPackage((org.eclipse.uml2.uml.Package)ne));
				}	
			} else if (ne instanceof Model) {
				found_elts.addAll(getInstanceSpecificationsInModel((Model)ne));
			}
		}
//		if(found_elts.isEmpty()){
//			System.out.println("Instances list empty");
//		}
		return found_elts;
	}
	
	/**
	 * Return the list of instance specifications in a package
	 * @param pack
	 * @return A list of InstanceSpecification of all instance specifications
	 */
	static public List<InstanceSpecification> getInstanceSpecificationsInPackage(org.eclipse.uml2.uml.Package pack) {
		LinkedList<InstanceSpecification> found_elts = new LinkedList<InstanceSpecification>();
		for (Element ne : pack.getOwnedElements()) {
			if (ne instanceof NamedElement) {
				if (ne instanceof org.eclipse.uml2.uml.InstanceSpecification) {
					found_elts.add((InstanceSpecification)ne);
				} else if(ne instanceof org.eclipse.uml2.uml.Package){
					found_elts.addAll(getInstanceSpecificationsInPackage((org.eclipse.uml2.uml.Package)ne));
				}	
			} else if (ne instanceof Model) {
				found_elts.addAll(getInstanceSpecificationsInModel((Model)ne));
			}
		}
		return found_elts;
	}
	
	/**
	 * Return the list of instance specifications allocated to given platform
	 * @param model
	 * @param 
	 * @return A list of InstanceSpecification of all instance specifications
	 */
	static public List<InstanceSpecification> getInstanceSpecificationsForPlatform(org.eclipse.uml2.uml.Model model, java.lang.String pfn)
	{
		List<InstanceSpecification> found_elts = new LinkedList<InstanceSpecification>();
		for(InstanceSpecification instanceSpecification : getInstanceSpecificationsInModel(model)) {
			if(isAllocatedTo(instanceSpecification, pfn))
			{
				found_elts.add(instanceSpecification);
			}
		}
		return found_elts;
	}

	/**
	 * Return the list of instance specifications allocated to given platform. Should be equivalent to getInstanceSpecificationsForPlatform, but different implementation.
	 * @param model
	 * @param targetPlatformName Name of the requested target platform type.
	 * @return A list of InstanceSpecification of all instance specifications.
	 */
	static public List<InstanceSpecification> getInstanceSpecificationsForPlatform2(org.eclipse.uml2.uml.Model model, String targetPlatformName) { //org.eclipse.papyrus.RobotML.Platform targetPlatform) {
		//The list to return in the end.
		List<InstanceSpecification> found_elts = new LinkedList<InstanceSpecification>();
		for (org.eclipse.uml2.uml.Package dpPck : getDeploymentPlanPackagesInModel(model))  {
			found_elts.addAll(getDeploymentPlanInstanceSpecsForPlatform(dpPck,targetPlatformName));
		}
		return found_elts;
	}
	

	/**
	 * Return the parent name of an instance
	 * @param inst
	 * @return Parent name of an instance
	 */
	static public java.lang.String getParentName(InstanceSpecification inst)
	{
		String name = inst.getName();
				
		Integer idx = name.lastIndexOf('.'); 
		if(idx!=-1)
		{
			return name.substring(0, idx);
		}else{
			return null;
		}
	}
	
	
	/**
	 * Get real instance from InstanceSpecification object
	 * @param model
	 * @param instanceSpecification
	 * @return the instance if found, or else null 
	 */
	static public Property getInstance(Model model, InstanceSpecification instanceSpecification)
	{	
		List<org.eclipse.uml2.uml.Property> l = ArchitectureQueries.getAllSubComponentsInClass(ArchitectureQueries.getRootClassForModel(model)); 
		
		for(Property p : l)
		{
			String[] str = instanceSpecification.getName().split("\\.");
			
			if(str.length > 0 && p.getName().equals(str[str.length-1]))
			{
				return p;
			}
		}
		
		return null;
	}
	
	
	/**
	 * Function to know if the instance must be generated by the platform or not. 
	 * @param instanceSpecification
	 * @param platformName
	 * @return true if the instance is allocated to the platform which name is given in parameter 
	 */
	static public boolean isAllocatedTo(InstanceSpecification instSpec, String platformName ) {
		if (instSpec == null || platformName == null)
			return false;
		for (Dependency dep : instSpec.getClientDependencies()) {
			Allocate alloc = UMLUtil.getStereotypeApplication((Element)dep, Allocate.class);
			if (alloc == null)
					continue;
			for (NamedElement nelt : dep.getSuppliers()) {
				if (isPlatformInstanceSpecificationFromPlatform(nelt,platformName)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Retrieves the deployment plans defined in a given model.
	 * @param model
	 * @return A list of DeploymentPlans defined in the model.
	 */
	static public List<DeploymentPlan> getDeploymentPlansInModel(org.eclipse.uml2.uml.Model model) 
	{
		List<DeploymentPlan> dep_plans = new LinkedList<DeploymentPlan>();
		for (Element elt : model.getOwnedElements()) {
			if (elt instanceof org.eclipse.uml2.uml.Package) {
				DeploymentPlan dp = UMLUtil.getStereotypeApplication(elt, DeploymentPlan.class);
				if (dp != null)
					dep_plans.add(dp);
				else
					dep_plans.addAll(getDeploymentPlansInPackage((org.eclipse.uml2.uml.Package)elt));
			}
		}
		return dep_plans;
	}
	
	/**
	 * Retrieves the deployment plans defined in a given package.
	 * @param pck
	 * @return
	 */
	static protected List<DeploymentPlan> getDeploymentPlansInPackage(org.eclipse.uml2.uml.Package pck) {
		List<DeploymentPlan> dep_plans = new LinkedList<DeploymentPlan>();
		for (Element elt : pck.getOwnedElements()) {
			if (elt instanceof org.eclipse.uml2.uml.Package) {
				DeploymentPlan dp = UMLUtil.getStereotypeApplication(elt, DeploymentPlan.class);
				if (dp != null)
					dep_plans.add(dp);
				else
					dep_plans.addAll(getDeploymentPlansInPackage((org.eclipse.uml2.uml.Package)elt));
			}
		}
		return dep_plans;
	}

	/**
	 * Retrieves the Packages in which Deployment plans are defined in the model.
	 * @param model
	 * @return
	 */
	static public List<org.eclipse.uml2.uml.Package> getDeploymentPlanPackagesInModel(Model model) {
		List<DeploymentPlan> dps = getDeploymentPlansInModel(model);
		LinkedList<org.eclipse.uml2.uml.Package> pcks = new LinkedList<org.eclipse.uml2.uml.Package>();
		for (DeploymentPlan dp : dps) {
			pcks.add(dp.getBase_Package());
		}
		return pcks;
	}

	/**
	 * Retrieves the InstanceSpecficiations allocated to a given Platform within a given DeploymentPlan.
	 * @param deploymentPlan
	 * @param targetPlatformName
	 * @return
	 */
	static public List<InstanceSpecification> getDeploymentPlanInstanceSpecsForPlatform(org.eclipse.uml2.uml.Package deploymentPlan, String targetPlatformName)
	{
		//The list to return in the end.
		List<InstanceSpecification> found_elts = new LinkedList<InstanceSpecification>();
		
		//Is the first argument really a Deployment plan ? (a Package with a DeploymentPlan StereoType) 
		DeploymentPlan dp = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(deploymentPlan, org.eclipse.papyrus.RobotML.DeploymentPlan.class);
		if (dp == null)
			return found_elts;
		
		//Let's get all the Allocate elements in the DeploymentPlan, and check if the supplier (the target platform) corresponds to the second argument.
		for (Element elt : deploymentPlan.getOwnedElements()) {
			if (elt instanceof Dependency) {
				//Is it a Dependency with an "Allocate" stereotype ?
				Dependency dep = (Dependency) elt;
				Allocate  alloc = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(elt, org.eclipse.papyrus.RobotML.Allocate.class);
				if (alloc == null)
					continue;
				
				//Let's store the potential client (the component instance) of the Allocate.
				//for future addition to the list to return.
				InstanceSpecification client_instance_spec = null;
				for (NamedElement client_elt : dep.getClients()) {
					if (false == (client_elt instanceof InstanceSpecification)) {
						continue;
					}
					client_instance_spec = (InstanceSpecification)client_elt;
					break;
				}
				if (client_instance_spec == null)
					continue;
				
				//Is it allocated to the platform provided as argument ?
				for (NamedElement nelt : dep.getSuppliers()) {
					if (isPlatformInstanceSpecificationFromPlatform(nelt,targetPlatformName)) {
						found_elts.add(client_instance_spec);
					}
				}
			}
		}
		return found_elts;
	}
	
	/**
	 * Function to know the content of allocation string. 
	 * @param instanceSpecification
	 * @return the allocation string 
	 */
	static public String getAllocationName(InstanceSpecification instanceSpecification)
	{
		if(instanceSpecification.getClientDependencies().size() == 0)
			return new String();
		
		//il n'y a toujours qu'un element
		Dependency d = instanceSpecification.getClientDependencies().get(0);
		
		return d.getName();
	}
	
	/**
	 * Function to know which class must be generated by the platform or not. 
	 * @param model
	 * @param platformName
	 * @return all classes that are instanciated for the platform "pfn"
	 */
	static public List<org.eclipse.uml2.uml.Class> getDefinedComponentsForPlatform(Model model, String platformName)
	{
		//System.out.println("getDefinedComponentsForPlatform");
		LinkedList<org.eclipse.uml2.uml.Class> found_classes = new LinkedList<org.eclipse.uml2.uml.Class>();
		
		List<InstanceSpecification> instances = getInstanceSpecificationsForPlatform(model, platformName);
		for(InstanceSpecification instanceSpecification : instances)
		{
			//System.out.println("instance : " + instanceSpecification.getName()); 
			
			for(org.eclipse.uml2.uml.Classifier classifier : instanceSpecification.getClassifiers())
			{
				found_classes.add(GeneralQueries.findClassInModel(model, classifier.getName()));

				//org.eclipse.uml2.uml.Class theClass = GeneralQueries.findClassInModel(model, classifier.getName());
				//System.out.println("\tclass : " + theClass.getName());
			}
		}
		return found_classes;
	}
	
	/**
	 * Function to know which class must be generated by the platform or not. Should be equivalent to getDefinedComponentsForPlatform but with a different implementation.
	 * @param model
	 * @param platformName
	 * @return all classes that are instanciated for the platform "pfn"
	 */
	static public List<org.eclipse.uml2.uml.Class> getDefinedComponentsForPlatform2(Model model, String platformName) //Platform platform)
	{
		LinkedList<org.eclipse.uml2.uml.Class> found_classes = new LinkedList<org.eclipse.uml2.uml.Class>();
		List<InstanceSpecification> inst_specs = getInstanceSpecificationsForPlatform2(model,platformName);
		for (InstanceSpecification inst_spec : inst_specs) {
			for(org.eclipse.uml2.uml.Classifier classifier : inst_spec.getClassifiers())
			{
				found_classes.add(GeneralQueries.findClassInModel(model, classifier.getName()));
			}
		}
		
		//remove duplicates
		Set<org.eclipse.uml2.uml.Class> new_set = new HashSet<org.eclipse.uml2.uml.Class>(found_classes);
		List<org.eclipse.uml2.uml.Class> found_classes_2 = new LinkedList<org.eclipse.uml2.uml.Class>(new_set);
		
		return found_classes_2;
	}
	
	/**
	 * Checks whether or not a Platform instance specification has a given platform type.
	 * @param platformInstanceSpecification
	 * @param expectedPlatformName
	 * @return
	 */
	protected static boolean isPlatformInstanceSpecificationFromPlatform(NamedElement platformInstanceSpecification, String expectedPlatformName) //Platform expectedPlatform)
	{
		if (platformInstanceSpecification instanceof InstanceSpecification) {
			InstanceSpecification platformInstance = (InstanceSpecification) platformInstanceSpecification;
			for (Classifier classifier : platformInstance.getClassifiers()) {
				if (classifier.getName().toLowerCase().compareTo(expectedPlatformName)==0)
					return true;
				/*
				RoboticMiddleware mdw = UMLUtil.getStereotypeApplication(classifier, org.eclipse.papyrus.RobotML.RoboticMiddleware.class);
				RoboticSimulator sim = UMLUtil.getStereotypeApplication(classifier, org.eclipse.papyrus.RobotML.RoboticSimulator.class);
				if (mdw != null) {
					//The target platform seems to be a middleware.
					//Middlewares are identified by their "kind".
					if (expectedPlatform instanceof RoboticMiddleware) {
						if (mdw.getKind() == ((RoboticMiddleware)expectedPlatform).getKind()) {
							//YEEEEHAAAA !!!
							return true;
						}
					}
				}
				if (sim != null && expectedPlatform instanceof RoboticSimulator) {
					//The target platform seems to be a simulator.
					//Simulators are just derived classes.
					if (sim.getClass().getName().compareTo(((RoboticSimulator)expectedPlatform).getClass().getName()) == 0) {
						//YEEEEEHAAAAAA !!!
						return true;
					}
				}*/
			}
		}
		return false;
	}
}
