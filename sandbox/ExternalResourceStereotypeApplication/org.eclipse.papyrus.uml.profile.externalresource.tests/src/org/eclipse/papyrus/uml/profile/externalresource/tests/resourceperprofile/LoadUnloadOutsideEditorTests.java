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
package org.eclipse.papyrus.uml.profile.externalresource.tests.resourceperprofile;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.profile.externalresource.helper.ExternalResourceProfileUtils;
import org.eclipse.papyrus.uml.profile.externalresource.helper.OneResourceOnlyStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.PapyrusStereotypeApplicationHelper;
import org.eclipse.papyrus.uml.profile.externalresource.helper.StrategyRegistry;
import org.eclipse.papyrus.uml.profile.externalresource.tests.AbstractExternalResourcesTest;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for load/unload
 */
public class LoadUnloadOutsideEditorTests extends AbstractExternalResourcesTest {

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

	@Test
	public void moveStereotypeApplicationOutsidePapyrusEditor() {
		UmlModel umlModel = null;
		// get The model. try to see applied stereotypes
		try {
			umlModel = (UmlModel)modelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Model rootModel = (Model)umlModel.getResource().getContents().get(0);
		Assert.assertNotNull("Root model impossible to find", rootModel);
		
		ICommand command = ExternalResourceProfileUtils.createUpdateStereotypeApplicationsLocationCommand(rootModel, PapyrusStereotypeApplicationHelper.getCurrentLocationStrategy(rootModel),  StrategyRegistry.getInstance().getStrategy(OneResourceOnlyStrategy.ID));
		Assert.assertNotNull("Impossible to create update command", command);
		Assert.assertTrue("Command should be executable", command.canExecute());
		IStatus status = null;
		try {
			status = OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e1) {
			fail(e1.getMessage());
		}
		
		if(!status.isOK()) {
			fail(status.getMessage());
		}
		
		URI tmpURI = URI.createPlatformResourceURI("/org.eclipse.papyrus.uml.profile.externalresource.tests/resources/OneResourcePerProfile/tmp.di", true);
		try {
			getModelSet(getURI()).saveAs(tmpURI);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		checkModel(rootModel);
		// check current model still have right stereotypes/values
		tearDownRegistry();
		// try to load and read profiles in the tmp file
		ModelSet tmpModelSet = getModelSet(tmpURI);
		Assert.assertNotNull("TMP Model set should not be null", tmpModelSet);
		UmlModel tmpUmlModel = null;
		// get The tmp model. try to see applied stereotypes
		try {
			tmpUmlModel = (UmlModel)tmpModelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Assert.assertNotNull(tmpUmlModel);
		Resource tmpResource = tmpUmlModel.getResource();
		Assert.assertNotNull(tmpResource);
		Model tmpRootModel = (Model)tmpResource.getContents().get(0);
		Assert.assertNotNull(tmpRootModel);
		checkModel(tmpRootModel);
		// additionnal checks : strategy, location of the stereotype application, etc.
		// test some stereotype applications
		// Model::class1 should have <<classStereotype>> Applied (verify root level stererotype)
		Class class1_ = (Class)tmpRootModel.getPackagedElement(MODEL_CLASS1, true, UMLPackage.eINSTANCE.getClass_(), false);
		EObject application = class1_.getStereotypeApplication(class1_.getAppliedStereotype(CLASS_STEREOTYPE_QN));
		Assert.assertNotNull("No stereotype applied on "+ MODEL_CLASS1, application);
		Assert.assertNotNull(application.eResource());
		URI stereotypeApplicationURI = application.eResource().getURI();
		Assert.assertEquals("Stereotype is not in expected resource", tmpURI.trimFileExtension().appendFileExtension(OneResourceOnlyStrategy.PROFILE_DEFAULT_EXTENSION), stereotypeApplicationURI);
		// check undo, check redo...
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public URI getURI() {
		return URI.createPlatformResourceURI("/org.eclipse.papyrus.uml.profile.externalresource.tests/resources/OneResourcePerProfile/oneProfileApplied.di", true);
	}
}
