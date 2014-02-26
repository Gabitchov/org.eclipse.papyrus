/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.readonly;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;

import java.util.Collections;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.core.resource.EditingDomainServiceFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor.ServiceTypeKind;
import org.eclipse.papyrus.infra.core.services.ServiceStartKind;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceInitializerService;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeManager;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;


/**
 * Test suite for the {@link ReferencedModelReadOnlyHandler} class.
 */
public class ReferencedModelReadOnlyHandlerTest {

	@Rule
	public final TestName testName = new TestName();

	private ServicesRegistry services;

	private TransactionalEditingDomain domain;

	private ReferencedModelReadOnlyHandler fixture;

	private IProject project;

	private Model model;

	private Package core;

	private Class person;

	public ReferencedModelReadOnlyHandlerTest() {
		super();
	}

	/**
	 * Test that cross-referenced workspace model resources are read-only by default.
	 */
	@Test
	public void testCrossReferencedWorkspaceModelElementsAreReadOnly() {
		Property ssn = person.getAttribute("ssn", null);
		assertReadOnly(ssn.getType());
	}

	/**
	 * Test that cross-referenced plug-in model resources are not handled by this read-only handler.
	 */
	@Test
	public void testCrossReferencedPluginModelElementsAreUnhandled() {
		Property lastName = person.getAttribute("lastName", null);
		assertNotReadOnly(lastName.getType());
	}

	/**
	 * Test that the main model resources are not considered as read-only by this read-only handler.
	 */
	@Test
	public void testMainModelElementsAreUnhandled() {
		Property ssn = person.getAttribute("ssn", null);
		assertNotReadOnly(ssn);
		assertLocalViewsNotReadOnly(ssn.getType());
	}

	/**
	 * Test that we can make cross-referenced workspace model resources writable.
	 */
	@Test
	public void testCrossReferencedWorkspaceModelElementsMadeWritable() {
		Property ssn = person.getAttribute("ssn", null);
		assumeReadOnly(ssn.getType());
		assertThat(fixture.canMakeWritable(ssn.getType()).or(false), is(true));
		assertThat(fixture.makeWritable(ssn.getType()).or(false), is(true));
		assertNotReadOnly(ssn.getType());
		assertNotReadOnly(person.getAttribute("registered", null).getType());
	}

	/**
	 * Test that the sub-model units of the main model resources are not considered as read-only by this read-only handler.
	 */
	@Test
	public void testSubModelElementsAreUnhandled() {
		control(core);

		Property ssn = person.getAttribute("ssn", null);
		assertNotReadOnly(ssn);
		assertLocalViewsNotReadOnly(ssn.getType());
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		createProject();
		createServiceRegistry();

		domain = services.getService(TransactionalEditingDomain.class);
		fixture = new ReferencedModelReadOnlyHandler(domain);
		fixture.setInteractive(false);

		Resource res = importModel();
		saveModels();

		model = (Model)res.getContents().get(0);
		core = model.getNestedPackage("core");
		person = (Class)core.getOwnedType("Person");
	}

	protected void createProject() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(testName.getMethodName());
		if(!project.exists()) {
			project.create(null);
		}
		if(!project.isOpen()) {
			project.open(null);
		}
	}

	protected void createServiceRegistry() throws Exception {
		services = new ServicesRegistry();
		services.add(ModelSet.class, 10, new ModelSet());
		services.add(ServiceUtilsForResourceInitializerService.class, 10, new ServiceUtilsForResourceInitializerService());

		ServiceDescriptor desc = new ServiceDescriptor(TransactionalEditingDomain.class, EditingDomainServiceFactory.class.getName(), ServiceStartKind.STARTUP, 10, Collections.singletonList(ModelSet.class.getName()));
		desc.setServiceTypeKind(ServiceTypeKind.serviceFactory);
		desc.setClassBundleID(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		services.add(desc);

		services.startRegistry();
	}

	@After
	public void destroyFixture() throws Exception {
		try {
			project.delete(true, true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResourceSet rset = domain.getResourceSet();

		model = null;
		core = null;
		person = null;

		domain.dispose();
		domain = null;
		fixture = null;

		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();

		services.disposeRegistry();
	}

	Resource importModel() throws Exception {
		ModelSet rset = services.getService(ModelSet.class);

		importModel(rset, "referencing");
		importModel(rset, "referenced");

		// Set the ModelSet's main URI and initialize it
		URI mainURI = URI.createPlatformResourceURI(String.format("%s/%s", project.getName(), "referencing"), true);
		new ModelsReader().readModel(rset);
		rset.loadModels(mainURI);

		return rset.getResource(mainURI.appendFileExtension("uml"), false);
	}

	void importModel(ModelSet rset, String name) throws Exception {
		URI source = URI.createPlatformPluginURI("org.eclipse.papyrus.infra.emf.readonly.tests/resources/" + name, true);
		URI destination = URI.createPlatformResourceURI(project.getName(), true);

		for(String component : ImmutableList.of("uml", "notation", "di")) {
			Resource res = rset.getResource(source.appendFileExtension(component), true);
			EcoreUtil.resolveAll(res);
			res.setURI(destination.appendSegment(res.getURI().lastSegment()));
		}
	}

	void saveModels() throws Exception {
		for(Resource next : services.getService(ModelSet.class).getResources()) {
			if(next.getURI().isPlatformResource()) {
				next.save(null);
			}
		}
	}

	void control(NamedElement element) {
		URI unit = element.eResource().getURI().trimSegments(1).appendSegment("units").appendSegment(URI.encodeSegment(element.getName() + ".uml", true));
		execute(ControlModeManager.getInstance().getControlCommand(new ControlModeRequest(domain, element, unit)));

		assertThat("Controlling the unit failed", ((InternalEObject)element).eDirectResource(), notNullValue());

		try {
			saveModels();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to save sub-model units: " + e.getLocalizedMessage());
		}
	}

	void execute(ICommand command) {
		IOperationHistory history = ((IWorkspaceCommandStack)domain.getCommandStack()).getOperationHistory();

		try {
			history.execute(command, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to execute command: " + e.getLocalizedMessage());
		}
	}

	void assertReadOnly(EObject object) {
		Optional<Boolean> status = fixture.isReadOnly(object);
		assertThat("Not read-only", status.or(false), is(true));
	}

	void assertNotReadOnly(EObject object) {
		Optional<Boolean> status = fixture.isReadOnly(object);
		assertThat("Should not be either read-only or definitely writable", status.isPresent(), is(false));
	}

	void assumeReadOnly(EObject object) {
		Optional<Boolean> status = fixture.isReadOnly(object);
		assumeThat("Not read-only", status.or(false), is(true));
	}

	void assertLocalViewsNotReadOnly(EObject object) {
		boolean foundSomeLocalViews = false;

		for(EStructuralFeature.Setting setting : CacheAdapter.getCacheAdapter(object).getNonNavigableInverseReferences(object)) {
			if(setting.getEStructuralFeature() == NotationPackage.Literals.VIEW__ELEMENT) {
				EObject view = setting.getEObject();
				URI uri = ControlledResourceTracker.getInstance(domain).getRootResourceURI(view.eResource().getURI());
				if(uri.trimFileExtension().lastSegment().equals("referencing")) {
					foundSomeLocalViews = true;
					assertNotReadOnly(view);
				}
			}
		}

		assertThat("No local views of the object found", foundSomeLocalViews, is(true));
	}
}
