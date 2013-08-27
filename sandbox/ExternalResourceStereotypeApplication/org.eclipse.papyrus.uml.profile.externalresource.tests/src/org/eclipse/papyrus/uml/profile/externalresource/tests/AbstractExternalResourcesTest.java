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

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceInitializerService;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.ui.wizards.imports.PluginImportOperation;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

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

	@Before
	public void initializeRegistry() {
		// first of all, delete existing model
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(Activator.PLUGIN_ID);
		//at this point, no resources have been created
		if(project.exists()) {
			try {
				project.delete(true, true, new NullProgressMonitor());
			} catch (CoreException e) {
				Assert.fail(e.getMessage());
			}
		}
		// import model files.
		PluginImportOperation operation = new PluginImportOperation(new IPluginModelBase[]{ PDECore.getDefault().getModelManager().findModel(Activator.PLUGIN_ID) }, PluginImportOperation.IMPORT_WITH_SOURCE, false);
		IStatus status = operation.run(new NullProgressMonitor());
		if(IStatus.ERROR == status.getSeverity()) {
			Assert.fail(status.getMessage());
		}
		servicesRegistry = getServicesRegistry();
		modelSet = getModelSet(getURI());
		Assert.assertNotNull("Model set should not be null", modelSet);
	}

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

	/**
	 * @return the uri
	 */
	public abstract URI getURI();
}
