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
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.profile.externalresource.helper.ExternalResourceProfileUtils;
import org.eclipse.papyrus.uml.profile.externalresource.helper.IStereotypeApplicationLocationStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.OneResourceOnlyStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.PapyrusStereotypeApplicationHelper;
import org.eclipse.papyrus.uml.profile.externalresource.helper.ResourcePerProfileStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.StandardApplicationLocationStrategy;
import org.eclipse.papyrus.uml.profile.externalresource.helper.StrategyRegistry;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract class for all change strategy tests
 */
public abstract class AbstractChangeStrategyTests extends AbstractExternalResourcesTest {

	@Test
	public void testSaveAs() {
		UmlModel umlModel = null;
		// get The model. try to see applied stereotypes
		try {
			umlModel = (UmlModel)modelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Model rootModel = (Model)umlModel.getResource().getContents().get(0);
		Assert.assertNotNull("Root model impossible to find", rootModel);
		URI resultURI = getResultURI();
		try {
			getModelSet(getURI()).saveAs(resultURI);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		checkModel(rootModel);
		// check current model still have right stereotypes/values
		tearDownRegistry();
		// try to load and read profiles in the result file
		ModelSet resultModelSet = getModelSet(resultURI);
		Assert.assertNotNull("TMP Model set should not be null", resultModelSet);
		UmlModel resultUmlModel = null;
		// get The result model. try to see applied stereotypes
		try {
			resultUmlModel = (UmlModel)resultModelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Assert.assertNotNull(resultUmlModel);
		Resource resultResource = resultUmlModel.getResource();
		Assert.assertNotNull(resultResource);
		Model resultRootModel = (Model)resultResource.getContents().get(0);
		Assert.assertNotNull(resultRootModel);
		checkModel(resultRootModel);
	}
	
	@Test
	public void changeToOneFileOnlyStrategy() {
		changeToStrategy(StrategyRegistry.getInstance().getStrategy(OneResourceOnlyStrategy.ID));
		// additionnal checks : strategy, location of the stereotype application, etc.
		ModelSet resultModelSet = getModelSet(getResultURI());
		UmlModel resultUmlModel = null;
		// get The result model. try to see applied stereotypes
		try {
			resultUmlModel = (UmlModel)resultModelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Resource resultResource = resultUmlModel.getResource();
		Model resultRootModel = (Model)resultResource.getContents().get(0);
		// test some stereotype applications
		// Model::class1 should have <<classStereotype>> Applied (verify root level stererotype)
		Class class1_ = (Class)resultRootModel.getPackagedElement(MODEL_CLASS1, true, UMLPackage.eINSTANCE.getClass_(), false);
		EObject application = class1_.getStereotypeApplication(class1_.getAppliedStereotype(CLASS_STEREOTYPE_QN));
		Assert.assertNotNull("No stereotype applied on " + MODEL_CLASS1, application);
		Assert.assertNotNull(application.eResource());
		URI stereotypeApplicationURI = application.eResource().getURI();
		Assert.assertEquals("Stereotype is not in expected resource", getResultURI().trimFileExtension().appendFileExtension(OneResourceOnlyStrategy.PROFILE_DEFAULT_EXTENSION), stereotypeApplicationURI);
		// check undo, check redo...
	}

	@Test
	public void changeToOneFilePerProfileStrategy() {
		changeToStrategy(StrategyRegistry.getInstance().getStrategy(ResourcePerProfileStrategy.ID));
		// additionnal checks : strategy, location of the stereotype application, etc.
		ModelSet resultModelSet = getModelSet(getResultURI());
		UmlModel resultUmlModel = null;
		// get The result model. try to see applied stereotypes
		try {
			resultUmlModel = (UmlModel)resultModelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Resource resultResource = resultUmlModel.getResource();
		Model resultRootModel = (Model)resultResource.getContents().get(0);
		// test some stereotype applications
		// Model::class1 should have <<classStereotype>> Applied (verify root level stererotype)
		Class class1_ = (Class)resultRootModel.getPackagedElement(MODEL_CLASS1, true, UMLPackage.eINSTANCE.getClass_(), false);
		EObject application = class1_.getStereotypeApplication(class1_.getAppliedStereotype(CLASS_STEREOTYPE_QN));
		Assert.assertNotNull("No stereotype applied on " + MODEL_CLASS1, application);
		Assert.assertNotNull(application.eResource());
		URI stereotypeApplicationURI = application.eResource().getURI();
		Assert.assertEquals("Stereotype is not in expected resource", getResultURI().trimFileExtension().appendFileExtension(EXTERNAL_RESOURCES_TEST_PROFILE + "Profile"), stereotypeApplicationURI);
	}

	@Test
	public void changeToStandardStrategy() {
		changeToStrategy(StrategyRegistry.getInstance().getStrategy(StandardApplicationLocationStrategy.ID));
		// additionnal checks : strategy, location of the stereotype application, etc.
		ModelSet resultModelSet = getModelSet(getResultURI());
		UmlModel resultUmlModel = null;
		// get The result model. try to see applied stereotypes
		try {
			resultUmlModel = (UmlModel)resultModelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Resource resultResource = resultUmlModel.getResource();
		Model resultRootModel = (Model)resultResource.getContents().get(0);
		// test some stereotype applications
		// Model::class1 should have <<classStereotype>> Applied (verify root level stererotype)
		Class class1_ = (Class)resultRootModel.getPackagedElement(MODEL_CLASS1, true, UMLPackage.eINSTANCE.getClass_(), false);
		EObject application = class1_.getStereotypeApplication(class1_.getAppliedStereotype(CLASS_STEREOTYPE_QN));
		Assert.assertNotNull("No stereotype applied on " + MODEL_CLASS1, application);
		Assert.assertNotNull(application.eResource());
		URI stereotypeApplicationURI = application.eResource().getURI();
		Assert.assertEquals("Stereotype is not in expected resource", resultUmlModel.getResourceURI(), stereotypeApplicationURI);
		// check undo, check redo...
	}

	protected void changeToStrategy(IStereotypeApplicationLocationStrategy newStrategy) {
		UmlModel umlModel = null;
		// get The model. try to see applied stereotypes
		try {
			umlModel = (UmlModel)modelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Model rootModel = (Model)umlModel.getResource().getContents().get(0);
		Assert.assertNotNull("Root model impossible to find", rootModel);
		IStereotypeApplicationLocationStrategy oldStrategy = PapyrusStereotypeApplicationHelper.getCurrentLocationStrategy(rootModel);
		ICommand command = ExternalResourceProfileUtils.createUpdateStereotypeApplicationsLocationCommand(rootModel, oldStrategy, newStrategy);
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
//		URI resultURI = getResultURI();
//		try {
//			getModelSet(getURI()).saveAs(resultURI);
//		} catch (IOException e) {
//			fail(e.getMessage());
//		}
		
		try {
			getModelSet(getURI()).save(new NullProgressMonitor());
		} catch (IOException e1) {
			fail(e1.getMessage());
		}
		checkModel(rootModel);
		
		// check current model still have right stereotypes/values
		tearDownRegistry();
		
		// check result files
		checkFiles(getResultURI(), newStrategy);
		
		// try to load and read models
		ModelSet modelSet = getModelSet(getURI());
		Assert.assertNotNull("TMP Model set should not be null", modelSet);
		UmlModel resultUmlModel = null;
		// get The result model. try to see applied stereotypes
		try {
			resultUmlModel = (UmlModel)modelSet.getModelChecked(UmlModel.MODEL_ID);
		} catch (NotFoundException e) {
			fail(e.getMessage());
		}
		Assert.assertNotNull(resultUmlModel);
		Resource resultResource = resultUmlModel.getResource();
		Assert.assertNotNull(resultResource);
		Model resultRootModel = (Model)resultResource.getContents().get(0);
		Assert.assertNotNull(resultRootModel);
		checkModel(resultRootModel);
	}

	/**
	 * @param resultURI
	 * @param newStrategy
	 */
	public void checkFiles(URI resultURI, IStereotypeApplicationLocationStrategy newStrategy) {
		List<String> resultFileNames = STRATEGY_FILE_NAMES_MAPPING.get(newStrategy.getIdentifier());
		for(String fileName : resultFileNames) {
			URI fileURI = getResultFolderURI().appendSegment(fileName);
			IPath path = new Path(fileURI.toPlatformString(true));
			IFile file  = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if(file == null || !file.exists()) {
				fail(fileName + " does not exists. URI: " + fileURI);
			}
		}
	}

	public URI getResultFolderURI() {
		// return URI.createPlatformResourceURI(getTestProjectName() + "/result", true);
		return URI.createPlatformResourceURI(getTestProjectName(), true);
	}

	public URI getResultURI() {
		// getResultFolderURI().appendSegment("result.di");
		return getURI();
	}
}
