/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 408491
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.tests.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.resource.DependencyManagementHelper;
import org.eclipse.papyrus.infra.emf.resource.DependencyManager;
import org.eclipse.papyrus.junit.utils.ModelUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.eclipse.papyrus.uml.tools.tests.Activator;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Test case for DependencyManagementHelper
 *
 * @author Camille Letavernier
 *
 */
public class DependencyManagementTest extends AbstractEditorTest {

	public final static String SOURCE_PATH = "resources/dependencyManagement/";

	// Switch from a library to a copy
	@Test
	public void testSimpleSwitch() throws Exception {
		// Create the project will 2 libraries and a client
		IProject project = ProjectUtils.createProject("dependencyManagement.simpleSwitch");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "model");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "library");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "copy-of-library");

		// Retrieve the URIs of each model
		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/model.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/model.uml", true);
		final URI sourceLibraryURI = URI.createPlatformResourceURI(project.getName() + "/library.uml", true);
		final URI targetLibraryURI = URI.createPlatformResourceURI(project.getName() + "/copy-of-library.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);

		// The modelset doesn't have any reference to the target library
		Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetLibraryURI, false));

		domain.getCommandStack().execute(new RecordingCommand(domain, "Edit model dependencies") {

			@Override
			protected void doExecute() {
				DependencyManagementHelper.updateDependencies(sourceLibraryURI, targetLibraryURI, modelSet, domain);
			}
		});

		EcoreUtil.resolveAll(modelSet);
		// The modelset now has some references to the target library
		Assert.assertNotNull("The modelset should have references to the target library", modelSet.getResource(targetLibraryURI, false));

		modelSet.save(new NullProgressMonitor());

		//
		// Reload
		//
		ModelSet reloadedModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

		// The reloaded modelset must have some references to the target library
		Resource clientModelResource = reloadedModelSet.getResource(clientModelURI, false);
		Assert.assertNotNull("The modelset should have references to the target library", clientModelResource);

		// The reloaded modelset doesn't have any reference to the source library
		Assert.assertNull("The modelset should not have references to the source library", reloadedModelSet.getResource(sourceLibraryURI, false));

		domain.dispose();
		modelSet.unload();

		ModelUtils.getEditingDomain(reloadedModelSet).dispose();
		reloadedModelSet.unload();

		project.delete(true, null);
	}

	// Switch from a registered library to a local one
	@Test
	public void testSwitchFromRegistererdToLocal() throws Exception {
		// Create the project will 2 libraries and a client
		IProject project = ProjectUtils.createProject("dependencyManagement.SwitchFromRegistererdToLocal");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "model-with-registered");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "library");

		// Retrieve the URIs of each model
		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/model-with-registered.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/model-with-registered.uml", true);
		final URI sourceLibraryURI = URI.createURI("pathmap://UML_TEST_LIBRARIES/registered-library.uml", true);
		final URI targetLibraryURI = URI.createPlatformResourceURI(project.getName() + "/library.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);

		// The modelset doesn't have any reference to the target library
		Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetLibraryURI, false));

		domain.getCommandStack().execute(new RecordingCommand(domain, "Edit model dependencies") {

			@Override
			protected void doExecute() {
				DependencyManagementHelper.updateDependencies(sourceLibraryURI, targetLibraryURI, modelSet, domain);
			}
		});


		EcoreUtil.resolveAll(modelSet);
		// The modelset now has some references to the target library
		Assert.assertNotNull("The modelset should have references to the target library", modelSet.getResource(targetLibraryURI, false));


		modelSet.save(new NullProgressMonitor());

		//
		// Reload
		//
		ModelSet reloadedModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

		// The reloaded modelset must have some references to the target library
		Resource clientModelResource = reloadedModelSet.getResource(clientModelURI, false);
		Assert.assertNotNull("The modelset should have references to the target library", clientModelResource);

		// The reloaded modelset doesn't have any reference to the source library
		Assert.assertNull("The modelset should not have references to the source library", reloadedModelSet.getResource(sourceLibraryURI, false));

		domain.dispose();
		modelSet.unload();

		ModelUtils.getEditingDomain(reloadedModelSet).dispose();
		reloadedModelSet.unload();

		project.delete(true, null);
	}

	// Switch from a registered library to a local one
	@Test
	public void testSwitchFromLocalToRegistered() throws Exception {
		// Create the project will 2 libraries and a client
		IProject project = ProjectUtils.createProject("dependencyManagement.simpleSwitch");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "model");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "library");

		// Retrieve the URIs of each model
		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/model.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/model.uml", true);
		final URI sourceLibraryURI = URI.createPlatformResourceURI(project.getName() + "/library.uml", true);
		final URI targetLibraryURI = URI.createPlatformResourceURI("pathmap://UML_TEST_LIBRARIES/registered-library.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);

		// The modelset doesn't have any reference to the target library
		Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetLibraryURI, false));

		domain.getCommandStack().execute(new RecordingCommand(domain, "Edit model dependencies") {

			@Override
			protected void doExecute() {
				DependencyManagementHelper.updateDependencies(sourceLibraryURI, targetLibraryURI, modelSet, domain);
			}
		});


		EcoreUtil.resolveAll(modelSet);
		// The modelset now has some references to the target library
		Assert.assertNotNull("The modelset should have references to the target library", modelSet.getResource(targetLibraryURI, false));


		modelSet.save(new NullProgressMonitor());


		//
		// Reload
		//

		ModelSet reloadedModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

		// The reloaded modelset must have some references to the target library
		Resource clientModelResource = reloadedModelSet.getResource(clientModelURI, false);
		Assert.assertNotNull("The modelset should have references to the target library", clientModelResource);

		// The reloaded modelset doesn't have any reference to the source library
		Assert.assertNull("The modelset should not have references to the source library", reloadedModelSet.getResource(sourceLibraryURI, false));

		domain.dispose();
		modelSet.unload();

		ModelUtils.getEditingDomain(reloadedModelSet).dispose();
		reloadedModelSet.unload();

		project.delete(true, null);
	}



	// Switch from two different versions of a profile
	@Test
	public void testSwitchProfilesWithStereotypes() throws Exception {
		IProject project = ProjectUtils.createProject("dependencyManagement.switchProfiles");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/model");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p1/profile1.profile");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p2/profile2.profile");

		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model.uml", true);
		final URI sourceProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p1/profile1.profile.uml", true);
		final URI targetProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p2/profile2.profile.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);
		ModelSet newModelSet = null;

		try {
			// The modelset doesn't have any reference to the target profile
			Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetProfileURI, false));

			Model rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// Before the transformation, stereotypes from the source profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, sourceProfileURI);

			// Execute the transformation
			domain.getCommandStack().execute(new RecordingCommand(domain, "Edit profile applications") {

				@Override
				protected void doExecute() {
					new DependencyManager(domain).updateDependencies(sourceProfileURI, targetProfileURI, null, null);
				}

			});

			// After the transformation, stereotypes from the target profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, targetProfileURI);

			// Save, reload, and check again
			modelSet.save(new NullProgressMonitor());

			newModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

			Assert.assertNull("The modelset should not have references to the source library", newModelSet.getResource(sourceProfileURI, false));

			rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// After the transformation + reload, stereotypes from the target profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, targetProfileURI);
		} finally {
			// Cleanup
			domain.dispose();
			modelSet.unload();

			if (newModelSet != null) {
				ModelUtils.getEditingDomain(newModelSet).dispose();
				newModelSet.unload();
			}

			project.delete(true, null);
		}
	}

	private void checkAppliedProfileAndStereotypes(ModelSet modelSet, Model rootModel, URI expectedProfileURI) throws Exception {
		Profile expectedProfile = UMLUtil.load(modelSet, expectedProfileURI, UMLPackage.eINSTANCE.getProfile());

		Assert.assertEquals(expectedProfile, rootModel.getAppliedProfiles().get(0));

		NamedElement class1 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class1").iterator().next();
		NamedElement class2 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class2").iterator().next();
		NamedElement class3 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class3").iterator().next();

		NamedElement stereotype1 = UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype1").iterator().next();
		NamedElement stereotype2 = UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype2").iterator().next();
		NamedElement stereotype3 = UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype3").iterator().next();

		Assert.assertEquals(stereotype1, class1.getAppliedStereotype("Profile::Stereotype1"));
		Assert.assertEquals(stereotype2, class2.getAppliedStereotype("Profile::Stereotype2"));
		Assert.assertEquals(stereotype3, class3.getAppliedStereotype("Profile::Stereotype3"));
	}

	// Switch from two different versions of a profile, verifying properties
	@Test
	public void testSwitchProfilesWithStereotypeProperties() throws Exception {
		IProject project = ProjectUtils.createProject("dependencyManagement.switchProfiles");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/model2");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p3/profile3.profile");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p4/profile4.profile");

		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.uml", true);
		final URI sourceProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p3/profile3.profile.uml", true);
		final URI targetProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p4/profile4.profile.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);
		ModelSet newModelSet = null;

		try {
			// The modelset doesn't have any reference to the target profile
			Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetProfileURI, false));

			Model rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// Before the transformation, stereotypes from the source profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, sourceProfileURI);

			// Execute the transformation
			domain.getCommandStack().execute(new RecordingCommand(domain, "Edit profile applications") {

				@Override
				protected void doExecute() {
					new DependencyManager(domain).updateDependencies(sourceProfileURI, targetProfileURI, null, null);
				}

			});

			// After the transformation, stereotypes from the target profile must be applied
			checkAppliedProfileAndStereotypeProperties(modelSet, rootModel, targetProfileURI);

			// Save, reload, and check again
			modelSet.save(new NullProgressMonitor());

			newModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

			Assert.assertNull("The modelset should not have references to the source library", newModelSet.getResource(sourceProfileURI, false));

			rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// After the transformation + reload, stereotypes from the target profile must be applied
			checkAppliedProfileAndStereotypeProperties(modelSet, rootModel, targetProfileURI);
		} finally {
			// Cleanup
			domain.dispose();
			modelSet.unload();

			if (newModelSet != null) {
				ModelUtils.getEditingDomain(newModelSet).dispose();
				newModelSet.unload();
			}

			project.delete(true, null);
		}
	}

	// Verify that stereotype applications that can be retargeted to the new profile retain their identities
	@Test
	public void testSwitchProfilesStereotypeIdentities() throws Exception {
		IProject project = ProjectUtils.createProject("dependencyManagement.switchProfiles");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/model2");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p3/profile3.profile");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p4/profile4.profile");

		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.uml", true);
		final URI sourceProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p3/profile3.profile.uml", true);
		final URI targetProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p4/profile4.profile.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);
		ModelSet newModelSet = null;

		try {
			// The modelset doesn't have any reference to the target profile
			Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetProfileURI, false));

			Model rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// Gather the identities of stereotype instances
			Map<String, EObject> idsToStereotypeInstances = new HashMap<String, EObject>();
			XMLResource xml = (XMLResource)rootModel.eResource();
			for(TreeIterator<EObject> iter = xml.getAllContents(); iter.hasNext();) {
				EObject next = iter.next();
				if(!(next instanceof Element)) {
					iter.prune();
				} else {
					for(EObject stereo : ((Element)next).getStereotypeApplications()) {
						idsToStereotypeInstances.put(xml.getID(stereo), stereo);
					}
				}
			}
			
			// Before the transformation, stereotypes from the source profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, sourceProfileURI);

			// Execute the transformation
			domain.getCommandStack().execute(new RecordingCommand(domain, "Edit profile applications") {

				@Override
				protected void doExecute() {
					new DependencyManager(domain).updateDependencies(sourceProfileURI, targetProfileURI, null, null);
				}

			});

			// Save, reload, and check IDs
			modelSet.save(new NullProgressMonitor());

			newModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

			rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());
			
			// All of the stereotype instances must have existed before
			xml = (XMLResource)rootModel.eResource();
			for(TreeIterator<EObject> iter = xml.getAllContents(); iter.hasNext();) {
				EObject next = iter.next();
				if(!(next instanceof Element)) {
					iter.prune();
				} else {
					Element element = (Element)next;
					for(Stereotype stereo : element.getAppliedStereotypes()) {
						// The required stereotypes were added in the new profile definition, so they couldn't have been applied before
						if(!element.isStereotypeRequired(stereo)) {
							EObject application = element.getStereotypeApplication(stereo);
							EObject original = idsToStereotypeInstances.remove(xml.getID(application));
							Assert.assertNotNull("Stereotype instance has a new identity", original);
							Assert.assertEquals("Stereotype instance has wrong identity", UML2Util.getQualifiedName(original.eClass(), "::"), UML2Util.getQualifiedName(application.eClass(), "::"));
						}
					}
				}
			}

		} finally {
			// Cleanup
			domain.dispose();
			modelSet.unload();

			if (newModelSet != null) {
				ModelUtils.getEditingDomain(newModelSet).dispose();
				newModelSet.unload();
			}

			project.delete(true, null);
		}
	}

	private void checkAppliedProfileAndStereotypeProperties(ModelSet modelSet, Model rootModel, URI expectedProfileURI) throws Exception {
		Profile expectedProfile = UMLUtil.load(modelSet, expectedProfileURI, UMLPackage.eINSTANCE.getProfile());

		Assert.assertEquals(expectedProfile, rootModel.getAppliedProfiles().get(0));

		NamedElement class1 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class1").iterator().next();
		NamedElement class2 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class2").iterator().next();

		Stereotype stereotype1 = (Stereotype) UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype1").iterator().next();
		Stereotype stereotype2 = (Stereotype) UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype2").iterator().next();

		EnumerationLiteral attribute1 = (EnumerationLiteral) class1.getValue(stereotype1, "Attribute1");
		Assert.assertNotNull(attribute1);
		Assert.assertEquals("EnumerationLiteral3", attribute1.getName());

		Operation operation = (Operation) class2.getValue(stereotype2, "operation");
		Assert.assertNotNull(operation);
		Assert.assertEquals("Operation1", operation.getName());
		Assert.assertSame(class2, operation.getNamespace());
	}

	// Switch from two different versions of a profile, verifying that new required stereotypes are applied
	@Test
	public void testSwitchProfilesWithRequiredStereotypes() throws Exception {
		IProject project = ProjectUtils.createProject("dependencyManagement.switchProfiles");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/model2");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p3/profile3.profile");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p4/profile4.profile");

		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.uml", true);
		final URI sourceProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p3/profile3.profile.uml", true);
		final URI targetProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p4/profile4.profile.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);
		ModelSet newModelSet = null;

		try {
			// The modelset doesn't have any reference to the target profile
			Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetProfileURI, false));

			Model rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// Before the transformation, stereotypes from the source profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, sourceProfileURI);

			// Execute the transformation
			domain.getCommandStack().execute(new RecordingCommand(domain, "Edit profile applications") {

				@Override
				protected void doExecute() {
					new DependencyManager(domain).updateDependencies(sourceProfileURI, targetProfileURI, null, null);
				}

			});

			// After the transformation, stereotypes from the target profile must be applied
			checkAppliedProfileAndRequiredStereotypes(modelSet, rootModel, targetProfileURI);

			// Save, reload, and check again
			modelSet.save(new NullProgressMonitor());

			newModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

			Assert.assertNull("The modelset should not have references to the source library", newModelSet.getResource(sourceProfileURI, false));

			rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// After the transformation + reload, stereotypes from the target profile must be applied
			checkAppliedProfileAndStereotypeProperties(modelSet, rootModel, targetProfileURI);
		} finally {
			// Cleanup
			domain.dispose();
			modelSet.unload();

			if (newModelSet != null) {
				ModelUtils.getEditingDomain(newModelSet).dispose();
				newModelSet.unload();
			}

			project.delete(true, null);
		}
	}

	private void checkAppliedProfileAndRequiredStereotypes(ModelSet modelSet, Model rootModel, URI expectedProfileURI) throws Exception {
		Profile expectedProfile = UMLUtil.load(modelSet, expectedProfileURI, UMLPackage.eINSTANCE.getProfile());

		Assert.assertEquals(expectedProfile, rootModel.getAppliedProfiles().get(0));

		NamedElement class1 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class1").iterator().next();
		NamedElement class2 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class2").iterator().next();
		NamedElement class3 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class3").iterator().next();

		Stereotype stereotype4 = (Stereotype) UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype4").iterator().next();

		Assert.assertTrue(class1.isStereotypeApplied(stereotype4));
		Assert.assertTrue(class2.isStereotypeApplied(stereotype4));
		Assert.assertTrue(class3.isStereotypeApplied(stereotype4));
	}

	// Switch from two different versions of a profile, verifying that missing definitions are handled correctly
	@Test
	public void testSwitchProfilesWithMissingDefinitions() throws Exception {
		IProject project = ProjectUtils.createProject("dependencyManagement.switchProfiles");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/model2");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p3/profile3.profile");
		PapyrusProjectUtils.copyPapyrusModel(project, getBundle(), getSourcePath(), "profiles/p5/profile5.profile");

		final URI clientModelDiURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.di", true);
		final URI clientModelURI = URI.createPlatformResourceURI(project.getName() + "/profiles/model2.uml", true);
		final URI sourceProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p3/profile3.profile.uml", true);
		final URI targetProfileURI = URI.createPlatformResourceURI(project.getName() + "/profiles/p5/profile5.profile.uml", true);

		final ModelSet modelSet = ModelUtils.loadModelSet(clientModelDiURI, true);
		final TransactionalEditingDomain domain = ModelUtils.getEditingDomain(modelSet);
		ModelSet newModelSet = null;

		try {
			// The modelset doesn't have any reference to the target profile
			Assert.assertNull("The modelset should not have references to the target library", modelSet.getResource(targetProfileURI, false));

			Model rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// Before the transformation, stereotypes from the source profile must be applied
			checkAppliedProfileAndStereotypes(modelSet, rootModel, sourceProfileURI);

			final BasicDiagnostic diagnostics = new BasicDiagnostic();

			// Execute the transformation
			domain.getCommandStack().execute(new RecordingCommand(domain, "Edit profile applications") {

				@Override
				protected void doExecute() {
					new DependencyManager(domain).updateDependencies(sourceProfileURI, targetProfileURI, diagnostics, null);
				}

			});

			// After the transformation, stereotypes from the target profile must be applied
			checkAppliedProfileAndMissingDefinitions(modelSet, rootModel, targetProfileURI, diagnostics);

			// Save, reload, and check again
			modelSet.save(new NullProgressMonitor());

			newModelSet = ModelUtils.loadModelSet(clientModelDiURI, true);

			Assert.assertNull("The modelset should not have references to the source library", newModelSet.getResource(sourceProfileURI, false));

			rootModel = UMLUtil.load(modelSet, clientModelURI, UMLPackage.eINSTANCE.getModel());

			// After the transformation + reload, stereotypes from the target profile must be applied
			checkAppliedProfileAndMissingDefinitions(modelSet, rootModel, targetProfileURI, diagnostics);
		} finally {
			// Cleanup
			domain.dispose();
			modelSet.unload();

			if (newModelSet != null) {
				ModelUtils.getEditingDomain(newModelSet).dispose();
				newModelSet.unload();
			}

			project.delete(true, null);
		}
	}

	private void checkAppliedProfileAndMissingDefinitions(ModelSet modelSet, Model rootModel, URI expectedProfileURI, Diagnostic diagnostics) throws Exception {
		Profile expectedProfile = UMLUtil.load(modelSet, expectedProfileURI, UMLPackage.eINSTANCE.getProfile());

		Assert.assertEquals(expectedProfile, rootModel.getAppliedProfiles().get(0));

		// We have reported problems
		Assert.assertNotNull(diagnostics.getChildren());
		Assert.assertNotEquals(0, diagnostics.getChildren().size());

		// The resource has no unrecognized schema content
		Assert.assertTrue(((XMLResource) rootModel.eResource()).getEObjectToExtensionMap().isEmpty());

		NamedElement class1 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class1").iterator().next();
		NamedElement class2 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class2").iterator().next();
		NamedElement class3 = UMLUtil.findNamedElements(rootModel.eResource(), "model::Class3").iterator().next();

		Stereotype stereotype1 = (Stereotype) UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype1").iterator().next();
		Stereotype stereotype2 = (Stereotype) UMLUtil.findNamedElements(expectedProfile.eResource(), "Profile::Stereotype2").iterator().next();

		Assert.assertTrue(class1.isStereotypeApplied(stereotype1));
		EObject application = class1.getStereotypeApplication(stereotype1);
		Assert.assertNull(application.eClass().getEStructuralFeature("Attribute1"));

		Assert.assertTrue(class2.isStereotypeApplied(stereotype2));
		application = class2.getStereotypeApplication(stereotype2);
		Assert.assertNull(application.eClass().getEStructuralFeature("operation"));

		Assert.assertTrue(class3.getAppliedStereotypes().isEmpty());
	}

	// Switch from a library to an un-existing resource
	@Ignore("Todo")
	@Test
	public void testSwitchToProxy() throws Exception {
		// TODO
	}

	// Switch from a proxy to a library
	@Ignore("Todo")
	@Test
	public void testSwitchFromProxy() throws Exception {
		// TODO
	}

	// Switch from a library to a modified copy of this library
	@Ignore("Todo")
	@Test
	public void testSwitchToDifferentVersion() throws Exception {
		// TODO
	}

	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}
}
