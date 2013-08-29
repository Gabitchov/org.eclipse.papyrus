/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceInitializerService;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.profile.externalresource.helper.ExternalResourceProfileUtils;
import org.eclipse.papyrus.uml.profile.externalresource.helper.OneResourceOnlyStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.PapyrusStereotypeApplicationHelper;
import org.eclipse.papyrus.uml.profile.externalresource.helper.StrategyRegistry;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Abstract class for all tests in this plugin
 */
public abstract class AbstractExternalResourcesTest {

	/** services registry for the model under test */
	protected ServicesRegistry servicesRegistry;

	/** model set that contains the model under test */
	protected ModelSet modelSet;

	/** The papyrus editor. */
	protected IMultiDiagramEditor papyrusEditor;

	public static boolean isInitialized = false;

	public static IEditorPart editor = null;

	public static String editorID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	public static final String EXTERNAL_RESOURCES_TEST_PROFILE = "ExternalResourcesTestProfile";

	public static final String EXTERNAL_RESOURCES_TEST_PROFILE_SUB_PROFILE = EXTERNAL_RESOURCES_TEST_PROFILE + NamedElement.SEPARATOR + "SubProfile";

	public static final String MODEL_CLASS1 = "Class1";

	public static final String CLASS_STEREOTYPE_NAME = "ClassStereotype";

	public static final String CLASS_STEREOTYPE_QN = EXTERNAL_RESOURCES_TEST_PROFILE + "::" + CLASS_STEREOTYPE_NAME;

	public static final String MODEL_CLASS2 = "Class2";

	public static final String ELEMENT_STEREOTYPE_NAME = "ElementStereotype";

	public static final String ELEMENT_STEREOTYPE_QN = EXTERNAL_RESOURCES_TEST_PROFILE_SUB_PROFILE + NamedElement.SEPARATOR + ELEMENT_STEREOTYPE_NAME;
	
	public static final String ONE_PROFILE_MODEL_FILENAME = "oneProfileApplied";

	public final static String DI_FILE =  ONE_PROFILE_MODEL_FILENAME+"."+DiModel.DI_FILE_EXTENSION;
	
	public final static String UML_FILE =  ONE_PROFILE_MODEL_FILENAME+"."+UmlModel.UML_FILE_EXTENSION;
	
	public final static String NOTATION_FILE =  ONE_PROFILE_MODEL_FILENAME+"."+NotationModel.NOTATION_FILE_EXTENSION;
	
	public final static String ALL_PROFILES_FILE = ONE_PROFILE_MODEL_FILENAME+"."+OneResourceOnlyStrategy.PROFILE_DEFAULT_EXTENSION;
	
	public final static String EXTERNAL_RESOURCES_TEST_PROFILE_EXTENSION_FILE = ONE_PROFILE_MODEL_FILENAME+"."+EXTERNAL_RESOURCES_TEST_PROFILE+"Profile";
	
	public static final String STANDARD_STRATEGY_FOLDER = "StandardResource";
	
	public static final String ONE_RESOURCE_FOR_ALL_PROFILES_FOLDER = "OneResourceForAllProfiles";
	
	public static final String ONE_RESOURCE_PER_PROFILE_FOLDER = "OneResourcePerProfile";
	
	
	@Before
	public void initializeRegistry() {
		ResourcesPlugin.getWorkspace().getDescription().setAutoBuilding(false);
		IProject project = null;
		try {
			project = ProjectUtils.createProject(getTestProjectName());
		} catch (CoreException e1) {
			fail(e1.getMessage());
		}
		Assert.assertNotNull("Impossible to create the project", project);
		// import model files.
		// retrieve the content of the source folder, and copy it into the destination folder
		for(String fileName : getModelFileNames()) {
			try {
				PapyrusProjectUtils.copyIFile("resources/"+getTestProjectName()+"/"+fileName, Platform.getBundle(Activator.PLUGIN_ID), project, fileName);
			} catch (CoreException e) {
				fail(e.getMessage());
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}		
		
		servicesRegistry = getServicesRegistry();
		modelSet = getModelSet(getURI());
		Assert.assertNotNull("Model set should not be null", modelSet);
	}

	/**
	 * {@inheritDoc}
	 */
	public URI getURI() {
		return URI.createPlatformResourceURI(getTestProjectName()+"/"+getModelFileNames().get(0), true);
	}
	
	/**
	 * Warning: main Model.di file must be put first!!!
	 * @return
	 */
	protected abstract List<String> getModelFileNames();

	/**
	 * @return
	 */
	protected abstract String getTestProjectName();

	@After
	public void tearDownRegistry() {
		if(modelSet != null) {
			modelSet.unload();
			modelSet = null;
		}
		if(servicesRegistry != null) {
			try {
				servicesRegistry.disposeRegistry();
				servicesRegistry = null;
			} catch (ServiceMultiException e) {
				Activator.log.error(e);
				org.junit.Assert.fail(e.getMessage());
			}
		}
	}
	
	@Test
	public void testLoadModelOutsidePapyrusEditor() {
		UmlModel umlModel = null;
		// get The model. try to see applied stereotypes
		try {
			umlModel = (UmlModel)modelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Model rootModel = (Model)umlModel.getResource().getContents().get(0);
		Assert.assertNotNull("Root model impossible to find", rootModel);
		// test applied profiles
		checkModel(rootModel);
	}
	
	/**
	 * @param rootModel
	 */
	protected void checkModel(Model rootModel) {
		Assert.assertEquals("Some profiles are missing", 2, rootModel.getAllAppliedProfiles().size());
		Assert.assertNotNull("ExternalResourcesTestProfile is missing", rootModel.getAppliedProfile(EXTERNAL_RESOURCES_TEST_PROFILE));
		Assert.assertNotNull("ExternalResourcesTestProfile::SubProfile is missing", rootModel.getAppliedProfile(EXTERNAL_RESOURCES_TEST_PROFILE_SUB_PROFILE));
		// test some stereotype applications
		// Model::class1 should have <<classStereotype>> Applied (verify root level stererotype)
		Class class1_ = (Class)rootModel.getPackagedElement(MODEL_CLASS1, true, UMLPackage.eINSTANCE.getClass_(), false);
		Assert.assertNotNull(MODEL_CLASS1 + " should not be null", class1_);
		Assert.assertNotNull(MODEL_CLASS1 + " should have stereotype " + CLASS_STEREOTYPE_NAME, class1_.getAppliedStereotype(CLASS_STEREOTYPE_QN));
		// Model::class1 should have <<classStereotype>> Applied (verify stereotype in subprofile)
		Class class2_ = (Class)rootModel.getPackagedElement(MODEL_CLASS2, true, UMLPackage.eINSTANCE.getClass_(), false);
		Assert.assertNotNull(MODEL_CLASS2 + " should not be null", class2_);
		Assert.assertNotNull(MODEL_CLASS2 + " should have stereotype " + ELEMENT_STEREOTYPE_NAME + ", but has only: " + class2_.getAppliedStereotypes(), class2_.getAppliedStereotype(ELEMENT_STEREOTYPE_QN));
	}

	public ModelSet createModelSet(URI uri) throws ModelMultiException {
		ModelSet modelSet = new ModelSet();
		ModelsReader reader = new ModelsReader();
		reader.readModel(modelSet);
		modelSet.loadModels(uri);
		return modelSet;
	}

	protected ServicesRegistry getUpdatedServiceRegistry() {
		if(papyrusEditor != null) {
			ServicesRegistry registry = (ServicesRegistry)papyrusEditor.getAdapter(ServicesRegistry.class);
			return registry;
		}
		return servicesRegistry;
	}

	protected Collection<IEditorPart> getEditors() {
		Collection<IEditorPart> results = new HashSet<IEditorPart>();
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for(IWorkbenchWindow iWorkbenchWindow : windows) {
			IWorkbenchPage[] pages = iWorkbenchWindow.getPages();
			for(IWorkbenchPage iWorkbenchPage : pages) {
				IEditorReference[] references = iWorkbenchPage.getEditorReferences();
				for(IEditorReference ref : references) {
					IEditorPart editor = ref.getEditor(true);
					results.add(editor);
				}
			}
		}
		return results;
	}

	public ServicesRegistry getServicesRegistry() {
		if(servicesRegistry == null) {
			//Try to find existing
			ServicesRegistry registry = getUpdatedServiceRegistry();
			if(registry != null) {
				servicesRegistry = registry;
			} else {
				servicesRegistry = createServicesRegistry();
			}
		}
		return servicesRegistry;
	}

	/**
	 * Starts a new Service registry
	 * 
	 * @return
	 */
	protected ServicesRegistry createServicesRegistry() {
		try {
			ServicesRegistry serviceRegistry = new ServicesRegistry();
			serviceRegistry.startRegistry();
			return serviceRegistry;
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	public ModelSet getModelSet(URI uri) {
		//If null, try to find one or create one
		if(modelSet == null) {
			try {
				modelSet = ServiceUtils.getInstance().getModelSet(getServicesRegistry());
			} catch (ServiceException e) {
				//Create one
				try {
					modelSet = createModelSet(uri);
					getServicesRegistry().add(ModelSet.class, 10, modelSet);
					getServicesRegistry().add(ServiceUtilsForResourceInitializerService.class, 10, new ServiceUtilsForResourceInitializerService());
					getServicesRegistry().startServicesByClassKeys(ModelSet.class, ServiceUtilsForResourceInitializerService.class);
					TransactionalEditingDomain domain = TransactionalEditingDomainManager.createTransactionalEditingDomain(modelSet);
					getServicesRegistry().add(TransactionalEditingDomain.class, 10, domain);
					getServicesRegistry().add(EditingDomain.class, 10, domain);
					
				} catch (ModelMultiException modelMultiException) {
					Activator.log.error(modelMultiException);
				} catch (ServiceMultiException e1) {
					Activator.log.error(e1);
				} catch (ServiceNotFoundException e1) {
					Activator.log.error(e1);
				}
			}
		}
		return modelSet;
	}
	

}
