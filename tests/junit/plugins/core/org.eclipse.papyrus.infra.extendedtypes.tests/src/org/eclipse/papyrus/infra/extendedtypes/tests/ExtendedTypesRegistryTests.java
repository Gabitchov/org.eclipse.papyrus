/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (fix test to prevent Model Repair dialog on unrecognized profile schema)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSetRegistry;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedTypeRegistryService;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.osgi.framework.Bundle;


/**
 * Tests for {@link ExtendedTypesRegistry}
 */
public class ExtendedTypesRegistryTests implements ITestConstants {

	private static IProject createProject;

	private static IFile copyPapyrusModel;

	private static IMultiDiagramEditor openPapyrusEditor;

	private static ModelSet modelset;

	private static UmlModel umlIModel;

	private static Model rootModel;

	private static Activity testActivity;

	private static TransactionalEditingDomain transactionalEditingDomain;

	private static Class testClass;

	private static Activity testActivityWithNode;

	/**
	 * Init test class
	 */
	@BeforeClass
	public static void initCreateElementTest() {

		// create Project
		try {
			createProject = ProjectUtils.createProject("ExtendedTypes");
		} catch (CoreException e) {
			fail(e.getMessage());
		}

		// import test model and profile
		try {
			Bundle bundle = Platform.getBundle("org.eclipse.papyrus.infra.extendedtypes.tests");
			copyPapyrusModel = PapyrusProjectUtils.copyPapyrusModel(createProject, bundle, "/model/", "model");
			PapyrusProjectUtils.copyPapyrusModel(createProject, bundle, "/model/", "ExtendedTypesTestsProfile.profile");
		} catch (CoreException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}

		// open project
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					openPapyrusEditor = EditorUtils.openPapyrusEditor(copyPapyrusModel);
				} catch (PartInitException e) {
					fail(e.getMessage());
				}
			}
		});

		transactionalEditingDomain = (TransactionalEditingDomain)openPapyrusEditor.getAdapter(TransactionalEditingDomain.class);
		assertTrue("Impossible to init editing domain", transactionalEditingDomain instanceof TransactionalEditingDomain);

		// retrieve UML model from this editor
		try {
			modelset = ModelUtils.getModelSetChecked(openPapyrusEditor.getServicesRegistry());
			umlIModel = UmlUtils.getUmlModel(modelset);
			rootModel = (Model)umlIModel.lookupRoot();
			
			Assert.assertNotNull("root model should not be null", rootModel);
			
		} catch (ServiceException e) {
			fail(e.getMessage());
		} catch (NotFoundException e) {
			fail(e.getMessage());
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
		try {
			initExistingElements();
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
	
	/**
	 * Init fields corresponding to element in the test model
	 */
	private static void initExistingElements() throws Exception {
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ExtendedElementTypeSetRegistry#getInstance()}
	 */
	@Test
	@Ignore
	public final void testGetInstance() {
		ExtendedTypeRegistryService service = null;
		try {
			service = openPapyrusEditor.getServicesRegistry().getService(ExtendedTypeRegistryService.class);
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
		Assert.assertNotNull("Extended type service should not be null", service);
		
		// retrieve registry from this service
		Assert.assertNotNull("Extended type registry singleton should not be null", service.getExtendedElementTypeSetRegistry());
	}

	
	/**
	 * Test method for {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedTypesRegistry#createResourceSet()}.
	 */
	@Test
	@Ignore
	public final void testGetTypeRegisteredInplugin() {
		// check standard class
		IElementType classType = ElementTypeRegistry.getInstance().getType("org.eclipse.papyrus.uml.Class");
		Assert.assertNotNull("Element type should be registered", classType);
		
		IElementType restrictedClassType = ElementTypeRegistry.getInstance().getType(CLASS_ONLY_IN_MODEL_ID);
		Assert.assertNotNull("Element type should be registered", restrictedClassType);
	}

//	/**
//	 * Test method for {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedTypesRegistry#getExtendedElementTypeSet(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public final void testGetExtendedElementTypeSet() {
//		ExtendedElementTypeSet set = ExtendedTypesRegistry.getInstance().getExtendedElementTypeSet(TEST1_CONFIGURATION_SET_ID, TEST1_MODEL_PATH, Activator.PLUGIN_ID);
//		assertNotNull("Element type model file set should be  found", set);
//
//		ExtendedElementTypeSet set2 = ExtendedTypesRegistry.getInstance().getExtendedElementTypeSet("null", NO_FILE, Activator.PLUGIN_ID);
//		assertNull("Element type model file set should not be found", set2);
//	}
//
//	/**
//	 * Test method for {@link org.eclipse.papyrus.infra.extendedtypes.tests.ExtendedTypesRegistry#getType(java.lang.String)}.
//	 */
//	@Test
//	public final void testGetType() {
//		IElementType classType = ExtendedTypesRegistry.getInstance().getType(UMLElementTypes.CLASS.getId());
//		assertNotNull("element Type for class should be found", classType);
//
//		IElementType extendedClassType = ExtendedTypesRegistry.getInstance().getType(CLASS1_TEST_TYPE_ID);
//		assertNotNull("element Type for class should be found", extendedClassType);
//
//		IElementType noType = ExtendedTypesRegistry.getInstance().getType(NO_TYPE);
//		assertNull("element Type for class should not be found", noType);
//	}
}
