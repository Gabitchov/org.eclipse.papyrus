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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.ModelManagement;
import org.eclipse.papyrus.qompass.designer.core.ProjectManagement;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.EnumService;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.Deploy;
import org.eclipse.papyrus.qompass.designer.core.deployment.DeployConstants;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.extensions.LanguageSupport;
import org.eclipse.papyrus.qompass.designer.core.generate.GenerateCode;
import org.eclipse.papyrus.qompass.designer.core.generate.GenerationOptions;
import org.eclipse.papyrus.qompass.designer.core.templates.InstantiateCppIncludeWOB;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterComments;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterRuleApplication;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterStateMachines;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterTemplate;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This class executes all transformations during the instantiation of a
 * deployment plan, i.e.
 * 1. The reification of connectors (including template instantiation). This transformation targets a new model
 * 2. Adding get_p/connect_q operations to a class (transformation within same model)
 * 3. Remove all component types
 * 4. distribute to nodes
 * 
 * @author ansgar
 * 
 */
public class InstantiateDepPlan {

	/**
	 * The location of the temporary model (relative to current project).
	 * TODO: make configurable?
	 */
	public static final String TEMP_MODEL_FOLDER = "tmpModel"; //$NON-NLS-1$
	
	/**
	 * Postfix of the temporary model (prefix = name of top-level package).
	 * TODO: make configurable?
	 */
	public static final String TEMP_MODEL_POSTFIX = "Tmp.uml"; //$NON-NLS-1$
	
	
	/**
	 * Instantiate a deployment plan, i.e. generate an intermediate model via a sequence of transformations
	 * 
	 * @param cdpOrConfig a deployment plan (UML package) or a configuration (UML class)
	 * @param monitor  a progress monitor.
	
	 * @param project the current project. This information is used to store the intermediate model in
	 * 	a subfolder (tmpModel) of the current project
	 * @param genOptions select whether to produce an intermediate model only, also code, ... @see GenerationOptions
	 */
	public static void instantiate(Element cdpOrConfig, IProgressMonitor monitor, IProject project, int genOptions) {
		boolean OOmodel = true;
		if(project == null) {
			String projectName = cdpOrConfig.eResource().getURI().toString();
			project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		}
		Model tmpModel = null;
		ModelManagement tmpMM = null;

		boolean generateCode = (genOptions & GenerationOptions.MODEL_ONLY) == 0;
		boolean generateCACOnly = (genOptions & GenerationOptions.CAC_ONLY) != 0;

		AcceleoDriver.clearErrors();
		Package smCDP;
		Configuration configuration = null;
		if(cdpOrConfig instanceof Package) {
			smCDP = (Package)cdpOrConfig;
			RuleManagement.setConfiguration(null);
		}
		else if(StereotypeUtil.isApplied(cdpOrConfig, Configuration.class)) {
			configuration = UMLUtil.getStereotypeApplication(cdpOrConfig, Configuration.class);
			DeploymentPlan fcmCDP = configuration.getDeploymentPlan();
			if(fcmCDP == null) {
				final NamedElement config = (NamedElement)cdpOrConfig;
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						Shell shell = new Shell();
						MessageDialog.openError(shell, Messages.InstantiateDepPlan_CannotGenModel,
								String.format(Messages.InstantiateDepPlan_DepPlanStereotypeNotInitialized, config.getName()));
					}
				});
				return;
			}
			smCDP = fcmCDP.getBase_Package();
			RuleManagement.setConfiguration(configuration);
		} else {
			return;
		}

		try {
			EnumService.init();
			InstanceSpecification rootIS = DepUtils.getMainInstance(smCDP);
			// Package copyCDP = dt.getCopyCDT (selectedCDP);

			EList<InstanceSpecification> nodes = AllocUtils.getAllNodes(rootIS);

			// -- calc # of steps for progress monitor
			// 1 (tmpModel creation) + 1 (reification) + 1 (tmpModel save)
			// 5x on each deployed node (see below)
			// problem? Connector reification is a single, relatively long step
			int steps = 3;
			steps += 5 * nodes.size();
			if(generateCode) {
				steps += nodes.size();
			}
			monitor.beginTask(Messages.InstantiateDepPlan_InfoGeneratingModel, steps);
			if(monitor.isCanceled()) {
				return;
			}

			// 1a: create a new model (and applies same profiles / imports)
			Model existingModel = smCDP.getModel();
			TransformationContext.sourceRoot = existingModel;
			tmpMM = createTargetModel(existingModel, monitor, existingModel.getName(), true);
			tmpModel = tmpMM.getModel();
			// Declare that the new model is a derivedElement (kind of hack, since the source
			// element (attribute of derive element) remains undefined). This is used to
			// de-activate automatic transformations that should not be applied to the generated
			// model.
			monitor.worked(1);
			if(monitor.isCanceled()) {
				return;
			}

			// LateEval.clear();

			EnumService.createEnumPackage(tmpModel);

			Copy tmpCopy = new Copy(existingModel, tmpModel, false);
			tmpCopy.preCopyListeners.add(FilterTemplate.getInstance());
			tmpCopy.preCopyListeners.add(FilterComments.getInstance());
			tmpCopy.postCopyListeners.add(InstantiateCppIncludeWOB.getInstance());

			Copy.copyID(existingModel, tmpModel);

			// 1b: reify the connectors "into" the new model
			monitor.subTask(Messages.InstantiateDepPlan_InfoExpandingConnectors);

			// obtain reference to CDP in target model
			// 
			tmpCopy.createShallowContainer(rootIS);
			Package tmCDP = (Package)tmpCopy.get(smCDP);

			ContainerTrafo.init();
			InstanceConfigurator.onNodeModel = false;
			MainModelTrafo mainModelTrafo = new MainModelTrafo(tmpCopy, tmCDP);
			InstanceSpecification newRootIS = mainModelTrafo.transformInstance(rootIS, null);
			monitor.worked(1);

			// 1c: late bindings
			// LateEval.bindLateOperations();
			// 3: distribute to nodes

			// UpdateDerivedInterfaces.updateIntfs(newRootIS);
			
			ApplyInstanceConfigurators.applyInstanceConfigurators(newRootIS);

			FlattenInteractionComponents.getInstance().flattenAssembly(newRootIS, null);
	
			PropagateAllocationToSharedInstances.propagateAllocation(newRootIS);
			
			String tmpPath = tmpMM.getPath(project, TEMP_MODEL_FOLDER, tmpModel.getName() + TEMP_MODEL_POSTFIX);
			tmpMM.saveModel(tmpPath);

			if(monitor.isCanceled()) {
				return;
			}
			monitor.worked(1);

			if(!generateCACOnly) {
				// not deploy on each node
				DepCreation.initAutoValues(newRootIS);

				nodes = AllocUtils.getAllNodes(newRootIS);
				if(nodes.size() == 0) {
					throw new TransformationException(Messages.InstantiateDepPlan_InfoNoneAllocated);
				}
				int nodeIndex = 0;
				Classifier cl = DepUtils.getClassifier(rootIS);
				String targetLanguage = DepUtils.getLanguageFromPackage(cl.getNearestPackage());
				if (targetLanguage == null) {
					targetLanguage = "C++"; //$NON-NLS-1$
				}
	
				InstanceConfigurator.onNodeModel = true;
				for(InstanceSpecification node : nodes) {
					String modelName = existingModel.getName() + "_" + node.getName(); //$NON-NLS-1$
					if(configuration != null) {
						modelName += "_" + configuration.getBase_Class().getName(); //$NON-NLS-1$
					} else {
						modelName += "_" + smCDP.getName(); //$NON-NLS-1$
					}
					ModelManagement genMM = createTargetModel(existingModel, monitor, MapUtil.rootModelName, false);
					Model genModel = genMM.getModel();

					if(monitor.isCanceled()) {
						return;
					}
					monitor.worked(1);
					// new model has name "root" and contains a package with the
					// existing model
					// Package originalRoot = genModel.createNestedPackage
					// (existingModel.getName ());
					Copy targetCopy = new Copy(tmpModel, genModel, true);
					// TODO: distribution to nodes is currently not done. How can it be realized with a copy filter ?
					targetCopy.preCopyListeners.add(FilterStateMachines.getInstance());
					targetCopy.preCopyListeners.add(FilterRuleApplication.getInstance());
					targetCopy.postCopyListeners.add(InstantiateCppIncludeWOB.getInstance());

					monitor.setTaskName(String.format(Messages.InstantiateDepPlan_InfoDeployingForNode, node.getName()));
					ILangSupport langSupport = LanguageSupport.getLangSupport(targetLanguage);
					langSupport.resetConfigurationData();

					Deploy deploy = new Deploy(targetCopy, langSupport, node, nodeIndex, nodes.size());
					InstanceSpecification nodeRootIS = deploy.distributeToNode(newRootIS);
					UpdateDerivedInterfaces.updateIntfs(nodeRootIS);

					if(monitor.isCanceled()) {
						return;
					}
					monitor.worked(1);
					// 2b: remove derived interfaces in root: derived interfaces that can
					//     not be placed in the same package as the port type (e.g. since read-only
					//     type from system library), are put in a top-level package called "derivedInterfaces".
					//     Due to the copying of imports, the top-level package has changed which implies that new
					//     derived interfaces are put into a different package and the derivedInterfaces package in
					//     the original root becomes obsolete. Delete this obsolete package, if existing.
					for (PackageableElement pe : genModel.getPackagedElements()) {
						if (pe instanceof Package) {
							NamedElement derivedInterfaces = ((Package) pe).getPackagedElement("derivedInterfaces"); //$NON-NLS-1$
							if(derivedInterfaces instanceof Package) {
								derivedInterfaces.destroy();
							}
						}
					}
					// 2c: add get_p/connect_q operations
					// caveat: may modify imported classes
					CompImplTrafos.bootloader = deploy.getBootloader();
					CompImplTrafos.addPortOperations(targetCopy, genModel);

					if(OOmodel) {
						// 3: component -> OO transformations related to ports:
						//    complete port access operations
						//    (get<PortName>/connect<PortName> and
						//    remove the ports afterwards
						CompTypeTrafos.completeAccessOps(genModel);
						CompTypeTrafos.removePorts(genModel);
					}

					// 4: remove connectors from implementations, since their endpoint's roles
					//     have disappeared during step 4b (targeted ports have been
					//     deleted together with the types).
					CompImplTrafos.deleteConnectors(genModel);
					if(monitor.isCanceled()) {
						return;
					}
					monitor.worked(1);

					PackageableElement depPlanFolder = genModel.getPackagedElement(DeployConstants.depPlanFolderHw);
					if (depPlanFolder != null) {
						depPlanFolder.destroy();
					}
					IProject genProject = ProjectManagement.getNamedProject(modelName);
					if((genProject == null) || !genProject.exists()) {
						genProject = langSupport.createProject(modelName, node);
					}
					else {
						langSupport.setProject(genProject);
						if((genOptions & GenerationOptions.REWRITE_SETTINGS) != 0) {
							langSupport.setSettings(node);
						}
					}

					
					if(generateCode) {
						GenerateCode codeGen = new GenerateCode(genProject, langSupport, genMM, monitor);
						codeGen.generate(node, targetLanguage, (genOptions & GenerationOptions.ONLY_CHANGED) != 0);
					}

					nodeIndex++;
					genMM.dispose();
				}
			}
		} catch (TransformationException te) {
			// Get UI thread to show dialog
			final TransformationException teFinal = te;
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					Shell shell = new Shell();
					MessageDialog.openError(shell, Messages.InstantiateDepPlan_TransformationException, teFinal.getMessage());
				}
			});
			Log.log(Status.ERROR, Log.DEPLOYMENT, "", teFinal);   //$NON-NLS-1$
		} catch (Exception e) {
			final Exception eFinal = e;
			e.printStackTrace();
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					Shell shell = new Shell();
					String msg = eFinal.toString() + "\n\n" +   //$NON-NLS-1$
						Messages.InstantiateDepPlan_ConsultConsole; 
					MessageDialog.openError(shell, Messages.InstantiateDepPlan_ErrorsDuringTransformation, msg);
				}
			});
			Log.log(Status.ERROR, Log.DEPLOYMENT, "", e);  //$NON-NLS-1$
		}
		if(tmpMM != null) {
			tmpMM.dispose();
		}
		if (AcceleoDriver.hasErrors()) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, Messages.InstantiateDepPlan_AcceleoErrors,
						Messages.InstantiateDepPlan_AcceleoErrorsCheckLog);
				}
			});
		}

	}


	/**
	 * Create a new empty model from an existing model that applies the same
	 * profiles and has the same imports
	 * 
	 * @param existingModel
	 * @return
	 */
	public static ModelManagement createTargetModel(Model existingModel, IProgressMonitor monitor, String name, boolean copyImports) throws TransformationException {
		ModelManagement mm = new ModelManagement();
		Model newModel = mm.getModel();
		newModel.setName(name);

		try {
			// copy profile application
			for(Profile profile : existingModel.getAppliedProfiles()) {
				// reload profile in resource of new model
				monitor.subTask(Messages.InstantiateDepPlan_InfoApplyProfile + profile.getQualifiedName());

				if(profile.eResource() == null) {
					String profileName = profile.getQualifiedName();
					if(profileName == null) {
						if(profile instanceof MinimalEObjectImpl.Container) {
							URI uri = ((MinimalEObjectImpl.Container)profile).eProxyURI();
							if(uri != null) {
								throw new TransformationException(String.format(Messages.InstantiateDepPlan_CheckInputModelProfileNoRes, uri));
							}
						}
						throw new TransformationException(Messages.InstantiateDepPlan_CheckInputModelProfileNoResNoName);
					}
					throw new TransformationException(String.format(Messages.InstantiateDepPlan_CheckInputModelProfile3, profileName));
				}

				Resource profileResource = null;
				try {
					profileResource = ModelManagement.getResourceSet().getResource(profile.eResource().getURI(), true);
				} catch (WrappedException e) {
					// read 2nd time (some diagnostic errors are raised only once)
					Log.log(Status.WARNING, Log.DEPLOYMENT, "Warning: exception in profile.eResource() " + e.getMessage()); //$NON-NLS-1$
					profileResource = ModelManagement.getResourceSet().getResource(profile.eResource().getURI(), true);
				}
				Profile newProfileTop = (Profile)profileResource.getContents().get(0);
				Profile newProfile;
				String qname = profile.getQualifiedName();
				if((qname != null) && qname.contains("::")) { //$NON-NLS-1$
					// profile is a sub-profile within same resource
					// TODO: should Copy class copy profile applications?
					// Should be handled in shallowContainer class.
					// if we put profile/newProfile pair into copy map, copy would find (and copy profile
					// applications in sub-folders
					qname = qname.substring(qname.indexOf("::") + 2); //$NON-NLS-1$
					newProfile = (Profile)Utils.getQualifiedElement(newProfileTop, qname);
				}
				else {
					newProfile = newProfileTop;
				}
				newProfile.getMember("dummy"); // force profile loading //$NON-NLS-1$
				newModel.applyProfile(newProfile);
			}
		} catch (IllegalArgumentException e) {
			throw new TransformationException(Messages.InstantiateDepPlan_IllegalArgumentDuringCopy + e.toString());
		}

		// copy imports (and load resources associated - TODO: might not be necessary)
		// While this is useful in general, it implies that code for imported models
		// has been generated and compiled (for the right target) into a library. This may be
		// quite tedious, unless automatically managed.
		// Therefore we do not activate this option in a first pass of the model transformations.
		if(copyImports) {
			for(Package importedPackage : existingModel.getImportedPackages()) {
				if(importedPackage == null) {
					throw new TransformationException(Messages.InstantiateDepPlan_CheckInputImportPkg);
				}
				if(importedPackage.eResource() == null) {
					String errorMsg = Messages.InstantiateDepPlan_CheckInputImportPkgNoRes;
					if(importedPackage instanceof MinimalEObjectImpl.Container) {
						URI uri = ((MinimalEObjectImpl.Container)importedPackage).eProxyURI();
						if(uri != null) {
							errorMsg += " - URI: " + uri.devicePath(); //$NON-NLS-1$
						}
					}
					throw new TransformationException(errorMsg);
				}
				newModel.createPackageImport(importedPackage);
				monitor.subTask(String.format(Messages.InstantiateDepPlan_InfoImportPackage, importedPackage.getName()));

				try {
					importedPackage.eResource().load(null);
					newModel.getMember("dummy"); // force loading of model //$NON-NLS-1$
				} catch (IOException e) {
					throw new TransformationException(e.getMessage());
				}

			}
		}

		StUtils.copyStereotypes(existingModel, newModel);

		return mm;
	}
}
