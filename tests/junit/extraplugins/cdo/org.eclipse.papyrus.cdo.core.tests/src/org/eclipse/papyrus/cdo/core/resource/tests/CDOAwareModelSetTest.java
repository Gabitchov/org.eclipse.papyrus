/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Collections;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.net4j.util.lifecycle.LifecycleException;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareTransactionalEditingDomain;
import org.eclipse.papyrus.cdo.core.resource.PapyrusCDOResourceFactory;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * This is the CDOAwareModelSetTest type. Enjoy.
 */
public class CDOAwareModelSetTest extends AbstractPapyrusCDOTest {

	private static final String MODEL_FILENAME = "model.uml";

	private ServicesRegistry services;

	private ModelSet fixture;

	public CDOAwareModelSetTest() {
		super();
	}

	@Test
	public void modelSetCreated() {
		Resource resource = fixture.getResource(getTestResourceURI(MODEL_FILENAME), false);
		assertThat(resource, notNullValue());

		CDOTransaction transaction = getTransaction(fixture);

		assertThat(transaction.isClosed(), is(false));
		assertThat(transaction.isDirty(), is(false));
	}

	@Test
	public void unloadModelSet() throws Exception {
		fixture.unload();

		assertThat(fixture.getResources(), equalTo(Collections.EMPTY_LIST));

		fixture.loadModels(getTestResourceURI(MODEL_FILENAME));

		CDOTransaction transaction = getTransaction(fixture);
		assertThat(transaction.isDirty(), is(false));

		Resource resource = fixture.getResource(getTestResourceURI(MODEL_FILENAME), false);
		assertThat(resource, notNullValue());
		assertThat(resource.isLoaded(), is(true));
	}

	@Test
	public void cdoResourceFactory() {
		CDOTransaction transaction = getTransaction(fixture);

		Resource resource = transaction.getOrCreateResource(getResourcePath(MODEL_FILENAME));
		assertThat(fixture.getResourceFactoryRegistry().getFactory(resource.getURI()), instanceOf(PapyrusCDOResourceFactory.class));
	}

	@Test
	public void editingDomain() {
		assertThat(fixture.getTransactionalEditingDomain(), instanceOf(CDOAwareTransactionalEditingDomain.class));
	}

	@Test
	public void cdoResourceNotReadOnly() {
		CDOTransaction transaction = getTransaction(fixture);

		Resource resource = transaction.getOrCreateResource(getResourcePath(MODEL_FILENAME));
		assertThat(fixture.getReadOnlyHandler().anyReadOnly(new URI[]{ resource.getURI() }), is(Optional.of(false)));
	}

	@Test
	public void getEObject() throws Exception {
		ResourceSet other = getPapyrusRepository().createTransaction(new ResourceSetImpl());

		Resource resource = getTransaction(other).getOrCreateResource(getResourcePath("other.uml"));

		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("test");
		resource.getContents().add(model);

		getPapyrusRepository().commit(other);

		// must get the URI *after* commit, because the fragment of a
		// persisted object is different than that of a transient object
		URI uri = EcoreUtil.getURI(model);

		getPapyrusRepository().close(other);

		EObject retrieved = fixture.getEObject(uri, true);
		model = cast(retrieved, Model.class);
		assertThat(model.getName(), equalTo("test"));
	}

	@Test
	public void resolveProxy() throws Exception {
		ResourceSet other = getPapyrusRepository().createTransaction(new ResourceSetImpl());

		Resource resource1 = getTransaction(other).getOrCreateResource(getResourcePath(MODEL_FILENAME));
		Model model1 = UMLFactory.eINSTANCE.createModel();
		model1.setName("model1");
		resource1.getContents().add(model1);

		Resource resource2 = getTransaction(other).getOrCreateResource(getResourcePath("other.uml"));
		Model model2 = UMLFactory.eINSTANCE.createModel();
		model2.setName("model2");
		resource2.getContents().add(model2);
		model2.createPackageImport(model1);

		URI uri = resource2.getURI();

		getPapyrusRepository().commit(other);
		getPapyrusRepository().close(other);

		Resource resource = fixture.getResource(uri, true);
		Model referencer = (Model)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
		assertThat(referencer.getImportedPackages(), CoreMatchers.<Package> hasItem(CoreMatchers.anything()));
		Package imported = referencer.getImportedPackages().get(0);
		assertThat(imported.eIsProxy(), is(false));
		assertThat(imported.getName(), equalTo("model1"));
	}

	//
	// Test framework
	//

	@Before
	public void createModelSet() throws Exception {
		services = new ExtensionServicesRegistry(Activator.PLUGIN_ID);

		try {
			// start the ModelSet and its dependencies
			services.startServicesByClassKeys(ModelSet.class);
		} catch (ServiceMultiException e) {
			for(ServiceNotFoundException next : Iterables.filter(e.getExceptions(), ServiceNotFoundException.class)) {
				assertThat(next.getLocalizedMessage(), not(containsString("ModelSet")));
			}
		}

		fixture = services.getService(ModelSet.class);

		assumeThat(fixture, instanceOf(CDOAwareModelSet.class));

		fixture.createModels(getTestResourceURI(MODEL_FILENAME));
		getPapyrusRepository().commit(fixture);
	}

	@After
	public void disposeModelSet() throws Exception {
		try {
			services.disposeRegistry();
		} catch (ServiceMultiException e) {
			if(Iterables.any(Iterables.transform(e.getExceptions(), new Function<Throwable, Throwable>() {

				public Throwable apply(Throwable input) {
					return input.getCause();
				}
			}), Predicates.instanceOf(LifecycleException.class))) {

				// known exception due to minimal CDOObject implementation
			} else {
				throw e;
			}
		} finally {
			services = null;
		}
	}
}
