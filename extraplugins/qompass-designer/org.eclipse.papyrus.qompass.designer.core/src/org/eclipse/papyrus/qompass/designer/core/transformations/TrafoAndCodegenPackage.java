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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.ContainerRuleKind;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.acceleo.AcceleoDriver;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.ModelManagement;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.EnumService;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.extensions.LanguageSupport;
import org.eclipse.papyrus.qompass.designer.core.generate.GenerateCode;
import org.eclipse.papyrus.qompass.designer.core.templates.InstantiateCppIncludeWOB;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterComments;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterTemplate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;

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
public class TrafoAndCodegenPackage {

	/**
	 * Iterate over source model and apply transformation
	 * @param copy
	 * @param pkg
	 * @throws TransformationException
	 */
	public static void applyTrafo(Copy copy, Package pkg) throws TransformationException {
		EList<PackageableElement> peList = new BasicEList<PackageableElement>();
		peList.addAll(pkg.getPackagedElements());
		for(PackageableElement element : peList) {
			if(element instanceof Package) {
				applyTrafo(copy, (Package)element);
			}
			else if(element instanceof Class) {
			
				Class smImplementation = (Class)element;
				Class tmImplementation = copy.getCopy(smImplementation);
				
				// get container trafo instance, if already existing
				AbstractContainerTrafo containerTrafo = ContainerTrafo.get(tmImplementation);

				// we may not apply the transformation to the boot-loader itself, in particular it would transform
				// singletons into pointers.
				EList<ContainerRule> rules = FCMUtil.getAllContainerRules(smImplementation);
				for(ContainerRule rule : rules) {
					// if(RuleManagement.isRuleActive(rule)) {
						// at least one active rule => create container (or get previously instantiated))
						if(rule.getKind() == ContainerRuleKind.LIGHT_WEIGHT_OO_RULE) {
							if (containerTrafo == null) {
								// container does not exist yet, create
								containerTrafo = new LWContainerTrafo(copy, null);
								containerTrafo.createContainer(smImplementation, tmImplementation);
							}
							containerTrafo.applyRule(rule, smImplementation, tmImplementation);
						}
					}
				// }
			}
		}
	}
	
	/**
	 * Instantiate a deployment plan, i.e. generate an intermediate model via a sequence of transformations
	 * 
	 * @param cdpOrConfig a deployment plan (UML package) or a configuration (UML class)
	 * @param monitor  a progress monitor.
	
	 * @param project the current project. This information is used to store the intermediate model in
	 * 	a subfolder (tmpModel) of the current project
	 * @param genOptions select whether to produce an intermediate model only, also code, ... @see GenerationOptions
	 */
	public static void instantiate(Element cdpOrConfig, IProgressMonitor monitor, IProject project) {
		if(project == null) {
			String projectName = cdpOrConfig.eResource().getURI().toString();
			project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		}
		Model tmpModel = null;
		ModelManagement tmpMM = null;

		AcceleoDriver.clearErrors();
		Package selectedPkg;
		if(cdpOrConfig instanceof Package) {
			selectedPkg = (Package)cdpOrConfig;
			RuleManagement.setConfiguration(null);
		}
		else {
			return;
		}

		try {
			EnumService.init();
			// Package copyCDP = dt.getCopyCDT (selectedCDP);

			// -- calc # of steps for progress monitor
			// 1 (tmpModel creation) + 1 (reification) + 1 (tmpModel save)
			// 5x on each deployed node (see below)
			// problem? Connector reification is a single, relatively long step
			int steps = 3;

			monitor.beginTask(Messages.InstantiateDepPlan_InfoGeneratingModel, steps);
			if(monitor.isCanceled()) {
				return;
			}

			// 1a: create a new model (and applies same profiles / imports)
			Model existingModel = selectedPkg.getModel();
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
			
			ContainerTrafo.init();
			monitor.worked(1);

			// create recursive copy of selectedPackage
			tmpCopy.getCopy(selectedPkg);
			
			// apply container transformation
			applyTrafo(tmpCopy, selectedPkg);
			
			// 1c: late bindings
			// LateEval.bindLateOperations();
			// 3: distribute to nodes

			String tmpPath = tmpMM.getPath(project, InstantiateDepPlan.TEMP_MODEL_FOLDER, tmpModel.getName() + InstantiateDepPlan.TEMP_MODEL_POSTFIX);
			tmpMM.saveModel(tmpPath);

			String targetLanguage = DepUtils.getLanguageFromPackage(selectedPkg);
			if (targetLanguage == null) {
				targetLanguage = "C++"; //$NON-NLS-1$
			}
			// genProject = project
			ModelManagement genMM = tmpMM;
			IProject genProject = project;
			ILangSupport langSupport = LanguageSupport.getLangSupport(targetLanguage);
			langSupport.resetConfigurationData();
			
			langSupport.setProject(genProject);
	
			GenerateCode codeGen = new GenerateCode(genProject, langSupport, genMM, monitor);
			codeGen.generate(null, targetLanguage, false);

			genMM.dispose();

			if(monitor.isCanceled()) {
				return;
			}
			monitor.worked(1);

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
