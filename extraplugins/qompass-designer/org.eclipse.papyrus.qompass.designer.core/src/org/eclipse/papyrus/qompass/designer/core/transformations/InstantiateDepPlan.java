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
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterRuleApplication;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterStateMachines;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FilterTemplate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;

/**
 * This class executes all transformations during the instantiation of a
 * deployment plan, i.e. 1. The reification of connectors (including template
 * instantiation). This transformation targets a new model 2. Adding
 * get_p/connect_q operations to a class (transformation within same model) 3.
 * Remove all component types 4. distribute to nodes
 * 
 * @author ansgar
 * 
 */
public class InstantiateDepPlan {

	/**
	 * The location of the temporary model (relative to current project). TODO:
	 * make configurable?
	 */
	public static final String TEMP_MODEL_FOLDER = "tmpModel"; //$NON-NLS-1$

	/**
	 * Postfix of the temporary model (prefix = name of top-level package).
	 * TODO: make configurable?
	 */
	public static final String TEMP_MODEL_POSTFIX = "Tmp.uml"; //$NON-NLS-1$

	/**
	 * Progress monitor of Eclipse.
	 */
	protected IProgressMonitor monitor = null;

	protected int generationOptions;

	protected boolean generateCode;

	protected boolean generateCACOnly;

	protected Package srcModelComponentDeploymentPlan = null;

	protected Configuration configuration = null;

	protected IProject project;

	protected boolean modelIsObjectOriented = true;

	public void instantiate(Configuration configuration,
			IProgressMonitor monitor, IProject project, int genOptions) {
		this.configuration = configuration;
		srcModelComponentDeploymentPlan = configuration
				.getDeploymentPlan().getBase_Package();
		//
		if (srcModelComponentDeploymentPlan == null) {
			String message = String
					.format(Messages.InstantiateDepPlan_DepPlanStereotypeNotInitialized,
							configuration.getBase_Class().getName());
			displayError(Messages.InstantiateDepPlan_TransformationException,
					message);
		}

		this.project = project;
		if (project == null) {
			String projectName = configuration.getBase_Class().eResource()
					.getURI().toString();
			this.project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
		}
		//
		instantiate(monitor, genOptions);
	}

	public void instantiate(Package pkg, IProgressMonitor monitor,
			IProject project, int genOptions) {
		configuration = null;
		srcModelComponentDeploymentPlan = pkg;
		//
		this.project = project;
		if (project == null) {
			String projectName = pkg.eResource().getURI().toString();
			this.project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
		}

		//
		instantiate(monitor, genOptions);
	}

	/**
	 * Instantiate a deployment plan, i.e. generate an intermediate model via a
	 * sequence of transformations
	 * 
	 * @param umlElement
	 *            a deployment plan (UML package) or a configuration (UML class)
	 * @param monitor
	 *            a progress monitor.
	 * 
	 * @param project
	 *            the current project. This information is used to store the
	 *            intermediate model in a subfolder (tmpModel) of the current
	 *            project
	 * @param genOptions
	 *            select whether to produce an intermediate model only, also
	 *            code, ... @see GenerationOptions
	 */
	private void instantiate(IProgressMonitor monitor, int genOptions) {
		try {
			initialize(monitor, genOptions);
			AcceleoDriver.clearErrors();
			executeTransformation();
		} catch (AcceleoException e) {
			displayError(Messages.InstantiateDepPlan_AcceleoErrors,
					Messages.InstantiateDepPlan_AcceleoErrorsCheckLog);
		} catch (final TransformationException e) {
			printAndDisplayErrorMessage(e,
					Messages.InstantiateDepPlan_TransformationException, false);
		} catch (final Exception e) {
			printAndDisplayErrorMessage(e,
					Messages.InstantiateDepPlan_ErrorsDuringTransformation,
					true);
		}
	}

	private void initialize(IProgressMonitor monitor, int genOptions)
			throws TransformationException {
		this.monitor = monitor;
		this.generationOptions = genOptions;
		this.generateCode = (genOptions & GenerationOptions.MODEL_ONLY) == 0;
		this.generateCACOnly = (genOptions & GenerationOptions.CAC_ONLY) != 0;

		RuleManagement.setConfiguration(configuration);
	}

	protected void executeTransformation() throws Exception {
		modelIsObjectOriented = true;
		ModelManagement intermediateModelManagement = null;
		
		InstanceSpecification mainInstance = DepUtils
				.getMainInstance(srcModelComponentDeploymentPlan);
		EList<InstanceSpecification> nodes = AllocUtils
				.getAllNodes(mainInstance);

		initiateProgressMonitor(generateCode, nodes);

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		// 1a: create a new model (and applies same profiles / imports)
		Model existingModel = srcModelComponentDeploymentPlan.getModel();
		TransformationContext.sourceRoot = existingModel;

		intermediateModelManagement = createTargetModel(existingModel,
				existingModel.getName(), true);

		// Declare that the new model is a derivedElement (kind of hack,
		// since the source element (attribute of derive element) remains
		// undefined). This is used to deactivate automatic transformations
		// that should not be applied to the generated model.

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		// get the temporary model
		Model intermediateModel = intermediateModelManagement.getModel();
		
		// create a package for global enumerations that are used by Acceleo code
		EnumService.createEnumPackage(intermediateModel);
		
		// create a lazy copier towards the intermediate model
		LazyCopier intermediateModelCopier = new LazyCopier(existingModel, intermediateModel, false, true);
		// add pre-copy and post-copy listeners to the copier
		intermediateModelCopier.preCopyListeners.add(FilterTemplate.getInstance());

		// 1b: reify the connectors "into" the new model
		monitor.subTask(Messages.InstantiateDepPlan_InfoExpandingConnectors);

		// obtain the component deployment plan in target model
		Package intermediateModelComponentDeploymentPlan = (Package) intermediateModelCopier
				.shallowCopy(srcModelComponentDeploymentPlan);
		intermediateModelCopier.createShallowContainer(srcModelComponentDeploymentPlan);
		
		ContainerTrafo.init();
		InstanceConfigurator.onNodeModel = false;
		MainModelTrafo mainModelTrafo = new MainModelTrafo(intermediateModelCopier,
				intermediateModelComponentDeploymentPlan);
		InstanceSpecification newMainInstance = mainModelTrafo
				.transformInstance(mainInstance, null);

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		TransformationUtil.applyInstanceConfigurators(newMainInstance);

		FlattenInteractionComponents.getInstance().flattenAssembly(
				newMainInstance, null);

		TransformationUtil.propagateAllocation(newMainInstance);

		intermediateModelManagement.saveModel(project, TEMP_MODEL_FOLDER,
				TEMP_MODEL_POSTFIX);

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		if (!generateCACOnly) {
			deployOnNodes(mainInstance, existingModel, intermediateModel,
					newMainInstance);
		}

		intermediateModelManagement.dispose();

		if (AcceleoDriver.hasErrors()) {
			throw new AcceleoException();
		}

	}

	private void deployOnNodes(InstanceSpecification mainInstance,
			Model existingModel, Model tmpModel, InstanceSpecification newRootIS)
			throws TransformationException, InterruptedException {

		// not deploy on each node
		DepCreation.initAutoValues(newRootIS);

		EList<InstanceSpecification> nodes = AllocUtils.getAllNodes(newRootIS);
		if (nodes.size() > 0) {
			InstanceConfigurator.onNodeModel = true;
			for (int nodeIndex = 0; nodeIndex < nodes.size(); nodeIndex++) {
				InstanceSpecification node = nodes.get(nodeIndex);

				deployNode(mainInstance, existingModel, tmpModel, newRootIS,
						nodes, nodeIndex, node);
			}
		} else {
			throw new TransformationException(
					Messages.InstantiateDepPlan_InfoNoneAllocated);
		}
	}

	private void deployNode(InstanceSpecification mainInstance,
			Model existingModel, Model tmpModel,
			InstanceSpecification newRootIS,
			EList<InstanceSpecification> nodes, int nodeIndex,
			InstanceSpecification node) throws TransformationException,
			InterruptedException {
		ModelManagement genModelManagement = createTargetModel(existingModel,
				MapUtil.rootModelName, false);
		Model generatedModel = genModelManagement.getModel();

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		// new model has name "root" and contains a package with the
		// existing model
		// Package originalRoot = genModel.createNestedPackage
		// (existingModel.getName ());
		LazyCopier targetCopy = new LazyCopier(tmpModel, generatedModel, true, true);
		// TODO: distribution to nodes is currently not done. How
		// can it be realized with a copy filter ?
		targetCopy.preCopyListeners.add(FilterStateMachines.getInstance());
		targetCopy.preCopyListeners.add(FilterRuleApplication.getInstance());

		monitor.setTaskName(String.format(
				Messages.InstantiateDepPlan_InfoDeployingForNode,
				node.getName()));

		ILangSupport langSupport = configureLanguageSupport(mainInstance,
				existingModel, node);

		Deploy deployment = new Deploy(targetCopy, langSupport, node,
				nodeIndex, nodes.size());
		InstanceSpecification nodeRootIS = deployment
				.distributeToNode(newRootIS);
		TransformationUtil.updateDerivedInterfaces(nodeRootIS);

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		removeDerivedInterfacesInRoot(generatedModel);

		CompImplTrafos.transform(
				deployment.getBootloader(), targetCopy, generatedModel,
				modelIsObjectOriented);

		// --------------------------------------------------------------------
		checkProgressStatus();
		// --------------------------------------------------------------------

		destroyDeploymentPlanFolder(generatedModel);

		if (generateCode) {
			GenerateCode codeGenerator = new GenerateCode(
					langSupport.getProject(), langSupport, genModelManagement,
					monitor);
			boolean option = (generationOptions & GenerationOptions.ONLY_CHANGED) != 0;
			codeGenerator.generate(node, getTargetLanguage(mainInstance),
					option);
		}

		genModelManagement.dispose();
	}

	private ILangSupport configureLanguageSupport(
			InstanceSpecification mainInstance, Model existingModel,
			InstanceSpecification node) throws TransformationException {
		ILangSupport langSupport = LanguageSupport
				.getLangSupport(getTargetLanguage(mainInstance));
		langSupport.resetConfigurationData();

		String modelName = getModelName(existingModel, node);
		IProject genProject = ProjectManagement.getNamedProject(modelName);
		if ((genProject == null) || !genProject.exists()) {
			genProject = langSupport.createProject(modelName, node);
		} else {
			langSupport.setProject(genProject);
			if ((generationOptions & GenerationOptions.REWRITE_SETTINGS) != 0) {
				langSupport.setSettings(node);
			}
		}
		return langSupport;
	}

	private void destroyDeploymentPlanFolder(Model generatedModel) {
		PackageableElement deploymentPlanFolder = generatedModel
				.getPackagedElement(DeployConstants.depPlanFolderHw);
		if (deploymentPlanFolder != null) {
			deploymentPlanFolder.destroy();
		}
	}

	private void removeDerivedInterfacesInRoot(Model generatedModel) {
		// 2b: remove derived interfaces in root: derived interfaces
		// that can not be placed in the same package as the port type (e.g.
		// since read-only type from system library), are put in a top-level
		// package called "derivedInterfaces". Due to the copying of imports,
		// the top-level package has changed which implies that new derived
		// interfaces are put into a different package and the derivedInterfaces
		// package in the original root becomes obsolete. Delete this obsolete
		// package, if existing.
		for (PackageableElement packagedElement : generatedModel
				.getPackagedElements()) {
			if (packagedElement instanceof Package) {
				NamedElement derivedInterfaces = ((Package) packagedElement)
						.getPackagedElement("derivedInterfaces"); //$NON-NLS-1$
				if (derivedInterfaces instanceof Package) {
					derivedInterfaces.destroy();
				}
			}
		}
	}

	private String getModelName(Model existingModel, InstanceSpecification node) {
		String modelName = existingModel.getName() + "_" + node.getName(); //$NON-NLS-1$
		if (configuration != null) {
			modelName += "_" + configuration.getBase_Class().getName(); //$NON-NLS-1$
		} else {
			modelName += "_" + srcModelComponentDeploymentPlan.getName(); //$NON-NLS-1$
		}
		return modelName;
	}

	private String getTargetLanguage(InstanceSpecification mainInstance) {
		Classifier cl = DepUtils.getClassifier(mainInstance);
		String targetLanguage = DepUtils.getLanguageFromPackage(cl
				.getNearestPackage());
		if (targetLanguage == null) {
			targetLanguage = "C++"; //$NON-NLS-1$
		}
		return targetLanguage;
	}

	private void initiateProgressMonitor(boolean generateCode,
			EList<InstanceSpecification> nodes) {
		// -- calc # of steps for progress monitor
		// 1 (tmpModel creation) + 1 (reification) + 1 (tmpModel save)
		// 5x on each deployed node (see below)
		// problem? Connector reification is a single, relatively long step
		int steps = 3;
		steps += 5 * nodes.size();
		if (generateCode) {
			steps += nodes.size();
		}
		monitor.beginTask(Messages.InstantiateDepPlan_InfoGeneratingModel,
				steps);
	}

	private void checkProgressStatus() throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
		monitor.worked(1);
	}

	private void printAndDisplayErrorMessage(Exception e, final String title,
			final boolean consultConsole) {
		String message = e.toString(); //$NON-NLS-1$
		if (consultConsole) {
			message = message + "\n\n"
					+ Messages.InstantiateDepPlan_ConsultConsole;
		}

		printAndDisplayErrorMessage(e, title, message, consultConsole);
	}

	private void printAndDisplayErrorMessage(Exception e, final String title,
			final String message, final boolean consultConsole) {
		e.printStackTrace();
		displayError(title, message);
		Log.log(Status.ERROR, Log.DEPLOYMENT, "", e); //$NON-NLS-1$
	}

	private void displayError(final String title, final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, title, message);
			}
		});
	}

	/**
	 * Create a new empty model from an existing model that applies the same
	 * profiles and has the same imports
	 * 
	 * @param existingModel
	 * @return
	 */
	public ModelManagement createTargetModel(Model existingModel, String name,
			boolean copyImports) throws TransformationException {
		ModelManagement mm = new ModelManagement();
		Model newModel = mm.getModel();
		newModel.setName(name);

		try {
			// copy profile application
			for (Profile profile : existingModel.getAppliedProfiles()) {
				// reload profile in resource of new model
				monitor.subTask(Messages.InstantiateDepPlan_InfoApplyProfile
						+ profile.getQualifiedName());

				if (profile.eResource() == null) {
					String profileName = profile.getQualifiedName();
					if (profileName == null) {
						if (profile instanceof MinimalEObjectImpl.Container) {
							URI uri = ((MinimalEObjectImpl.Container) profile)
									.eProxyURI();
							if (uri != null) {
								throw new TransformationException(
										String.format(
												Messages.InstantiateDepPlan_CheckInputModelProfileNoRes,
												uri));
							}
						}
						throw new TransformationException(
								Messages.InstantiateDepPlan_CheckInputModelProfileNoResNoName);
					}
					throw new TransformationException(
							String.format(
									Messages.InstantiateDepPlan_CheckInputModelProfile3,
									profileName));
				}

				Resource profileResource = null;
				try {
					profileResource = ModelManagement.getResourceSet()
							.getResource(profile.eResource().getURI(), true);
				} catch (WrappedException e) {
					// read 2nd time (some diagnostic errors are raised only
					// once)
					Log.log(Status.WARNING,
							Log.DEPLOYMENT,
							"Warning: exception in profile.eResource() " + e.getMessage()); //$NON-NLS-1$
					profileResource = ModelManagement.getResourceSet()
							.getResource(profile.eResource().getURI(), true);
				}
				Profile newProfileTop = (Profile) profileResource.getContents()
						.get(0);
				Profile newProfile;
				String qname = profile.getQualifiedName();
				if ((qname != null) && qname.contains("::")) { //$NON-NLS-1$
					// profile is a sub-profile within same resource
					// TODO: should Copy class copy profile applications?
					// Should be handled in shallowContainer class.
					// if we put profile/newProfile pair into copy map, copy
					// would find (and copy profile
					// applications in sub-folders
					qname = qname.substring(qname.indexOf("::") + 2); //$NON-NLS-1$
					newProfile = (Profile) Utils.getQualifiedElement(
							newProfileTop, qname);
				} else {
					newProfile = newProfileTop;
				}
				newProfile.getMember("dummy"); // force profile loading //$NON-NLS-1$
				newModel.applyProfile(newProfile);
			}
		} catch (IllegalArgumentException e) {
			throw new TransformationException(
					Messages.InstantiateDepPlan_IllegalArgumentDuringCopy
							+ e.toString());
		}

		// copy imports (and load resources associated - TODO: might not be
		// necessary)
		// While this is useful in general, it implies that code for imported
		// models
		// has been generated and compiled (for the right target) into a
		// library. This may be
		// quite tedious, unless automatically managed.
		// Therefore we do not activate this option in a first pass of the model
		// transformations.
		if (copyImports) {
			for (Package importedPackage : existingModel.getImportedPackages()) {
				if (importedPackage == null) {
					throw new TransformationException(
							Messages.InstantiateDepPlan_CheckInputImportPkg);
				}
				if (importedPackage.eResource() == null) {
					String errorMsg = Messages.InstantiateDepPlan_CheckInputImportPkgNoRes;
					if (importedPackage instanceof MinimalEObjectImpl.Container) {
						URI uri = ((MinimalEObjectImpl.Container) importedPackage)
								.eProxyURI();
						if (uri != null) {
							errorMsg += " - URI: " + uri.devicePath(); //$NON-NLS-1$
						}
					}
					throw new TransformationException(errorMsg);
				}
				newModel.createPackageImport(importedPackage);
				monitor.subTask(String.format(
						Messages.InstantiateDepPlan_InfoImportPackage,
						importedPackage.getName()));

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
