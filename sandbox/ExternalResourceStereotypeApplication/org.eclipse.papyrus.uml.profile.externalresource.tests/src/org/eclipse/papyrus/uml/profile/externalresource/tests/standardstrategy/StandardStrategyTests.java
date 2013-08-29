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
package org.eclipse.papyrus.uml.profile.externalresource.tests.standardstrategy;

import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.uml.profile.externalresource.tests.AbstractChangeStrategyTests;
import org.eclipse.papyrus.uml.profile.externalresource.tests.AbstractExternalResourcesTest;

/**
 * Test class for load/unload
 */
public class StandardStrategyTests extends AbstractChangeStrategyTests {

	
	public static final List<String> FILE_NAMES = Arrays.asList(DI_FILE, UML_FILE, NOTATION_FILE); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getTestProjectName() {
		return STANDARD_STRATEGY_FOLDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<String> getModelFileNames() {
		return FILE_NAMES;
	}
	
//	@Test
//	public void moveStereotypeApplicationOutsidePapyrusEditor() {
//		UmlModel umlModel = null;
//		// get The model. try to see applied stereotypes
//		try {
//			umlModel = (UmlModel)modelSet.getModelChecked(UmlModel.MODEL_ID);
//		} catch (NotFoundException e) {
//			fail(e.getMessage());
//		}
//		Model rootModel = (Model)umlModel.getResource().getContents().get(0);
//		Assert.assertNotNull("Root model impossible to find", rootModel);
//		
//		ICommand command = ExternalResourceProfileUtils.createUpdateStereotypeApplicationsLocationCommand(rootModel, PapyrusStereotypeApplicationHelper.getCurrentLocationStrategy(rootModel),  StrategyRegistry.getInstance().getStrategy(OneResourceOnlyStrategy.ID));
//		Assert.assertNotNull("Impossible to create update command", command);
//		Assert.assertTrue("Command should be executable", command.canExecute());
//		IStatus status = null;
//		try {
//			status = OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
//		} catch (ExecutionException e1) {
//			fail(e1.getMessage());
//		}
//		
//		if(!status.isOK()) {
//			fail(status.getMessage());
//		}
//		
//		URI tmpURI = URI.createPlatformResourceURI(getTestProjectName()+"/tmp.di", true);
//		try {
//			getModelSet(getURI()).saveAs(tmpURI);
//		} catch (IOException e) {
//			fail(e.getMessage());
//		}
//		checkModel(rootModel);
//		// check current model still have right stereotypes/values
//		tearDownRegistry();
//		// try to load and read profiles in the tmp file
//		ModelSet tmpModelSet = getModelSet(tmpURI);
//		Assert.assertNotNull("TMP Model set should not be null", tmpModelSet);
//		UmlModel tmpUmlModel = null;
//		// get The tmp model. try to see applied stereotypes
//		try {
//			tmpUmlModel = (UmlModel)tmpModelSet.getModelChecked(UmlModel.MODEL_ID);
//		} catch (NotFoundException e) {
//			fail(e.getMessage());
//		}
//		Assert.assertNotNull(tmpUmlModel);
//		Resource tmpResource = tmpUmlModel.getResource();
//		Assert.assertNotNull(tmpResource);
//		Model tmpRootModel = (Model)tmpResource.getContents().get(0);
//		Assert.assertNotNull(tmpRootModel);
//		checkModel(tmpRootModel);
//		// additionnal checks : strategy, location of the stereotype application, etc.
//		// test some stereotype applications
//		// Model::class1 should have <<classStereotype>> Applied (verify root level stererotype)
//		Class class1_ = (Class)tmpRootModel.getPackagedElement(MODEL_CLASS1, true, UMLPackage.eINSTANCE.getClass_(), false);
//		EObject application = class1_.getStereotypeApplication(class1_.getAppliedStereotype(CLASS_STEREOTYPE_QN));
//		Assert.assertNotNull("No stereotype applied on "+ MODEL_CLASS1, application);
//		Assert.assertNotNull(application.eResource());
//		URI stereotypeApplicationURI = application.eResource().getURI();
//		Assert.assertEquals("Stereotype is not in expected resource", tmpURI.trimFileExtension().appendFileExtension(OneResourceOnlyStrategy.PROFILE_DEFAULT_EXTENSION), stereotypeApplicationURI);
//		// check undo, check redo...
//	}


}
