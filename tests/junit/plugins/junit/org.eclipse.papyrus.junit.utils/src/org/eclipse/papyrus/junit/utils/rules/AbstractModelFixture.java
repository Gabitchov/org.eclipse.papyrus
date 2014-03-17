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
package org.eclipse.papyrus.junit.utils.rules;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.junit.utils.rules.ProjectFixture;
import org.eclipse.uml2.uml.Model;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;


/**
 * Abstract superclass for JUnit test fixture rules that provide:
 * <ul>
 * <li>an editing domain of some kind (subclasses must create it)</li>
 * <li>a test project in the workspace, exposed via a nested {@link ProjectFixture} rule</li>
 * <li>a test {@link Model} loaded from a resource in the plug-in and saved as <tt>model.uml</tt> in the test project. This model is specified using
 * an annotation on the test, as described below</li>
 * </ul>
 * The test model template to load into the editing domain and project must be specified by one of the following annotations:
 * <ul>
 * <li>{@link JavaResource @JavaResource}: specifies the path to a resource to be loaded from the test class's classpath, using the
 * {@link Class#getResource(String)} API</li>
 * <li>{@link PluginResource @PluginResource}: specifies a path relative to the root of the OSGi bundle containing the test class, to be loaded via
 * the {@link Bundle#getEntry(String)} API</li>
 * </ul>
 * The resource annotation may be specified either on the test method, in which case it applies to that test case, or on the test
 * class, in which case it applies to all test methods in the class that do not have a resource annotation of their own (method
 * annotations take precedence over the class annotation).
 */
public abstract class AbstractModelFixture<T extends EditingDomain> extends TestWatcher {

	private final ProjectFixture project = new ProjectFixture();

	private T domain;

	private Model model;

	public AbstractModelFixture() {
		super();
	}

	public Statement apply(Statement base, Description description) {
		// Wrap myself in the project rule so that the project exists when I start
		Statement result = super.apply(base, description);
		result = project.apply(result, description);
		return result;
	}

	/**
	 * Obtains the nested project fixture rule. If stored in a field of the test class, it must not be annotated as a {@link Rule @Rule} because that
	 * would result in double initialization of the rule.
	 * 
	 * @return the nested project fixture
	 */
	public ProjectFixture getProject() {
		return project;
	}

	public T getEditingDomain() {
		return domain;
	}

	/**
	 * Obtains the test model, which is resident in the <tt>model.uml</tt> file in the test project (as indicated by its
	 * {@linkplain #getModelResourceURI() URI}).
	 * 
	 * @return the test model
	 */
	public Model getModel() {
		return model;
	}

	public Resource getModelResource() {
		return getModel().eResource();
	}

	public URI getModelResourceURI() {
		return getModelResource().getURI();
	}

	public URI getModelURI() {
		return EcoreUtil.getURI(getModel());
	}

	protected abstract T createEditingDomain();

	@Override
	protected void starting(Description description) {
		domain = createEditingDomain();

		Resource res = domain.getResourceSet().createResource(project.getURI("model.uml"));

		try {
			InputStream input = getResourceURL(description).openStream();
			try {
				res.load(input, null);
			} finally {
				input.close();
			}
			res.save(null); // Make sure it exists
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to load test resource: " + e.getLocalizedMessage());
		}

		model = (Model)res.getContents().get(0);
	}

	@Override
	protected void finished(Description description) {
		ResourceSet rset = domain.getResourceSet();

		model = null;

		if(domain instanceof TransactionalEditingDomain) {
			((TransactionalEditingDomain)domain).dispose();
		}
		domain = null;

		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
	}

	protected URL getResourceURL(Description description) {
		URL result = null;

		Class<?> testClass = description.getTestClass();

		Method testMethod = null;
		try {
			testMethod = testClass.getDeclaredMethod(description.getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Could not access test method via JUnit framework.");
		}

		if(testMethod.isAnnotationPresent(JavaResource.class)) {
			result = testClass.getResource(testMethod.getAnnotation(JavaResource.class).value());
		} else if(testMethod.isAnnotationPresent(PluginResource.class)) {
			result = FrameworkUtil.getBundle(testClass).getEntry(testMethod.getAnnotation(PluginResource.class).value());
		} else {
			// The class must have an annotation
			if(testClass.isAnnotationPresent(JavaResource.class)) {
				result = testClass.getResource(testClass.getAnnotation(JavaResource.class).value());
			} else if(testClass.isAnnotationPresent(PluginResource.class)) {
				result = FrameworkUtil.getBundle(testClass).getEntry(testClass.getAnnotation(PluginResource.class).value());
			}
		}

		assertThat("No JavaResource or PluginResource annotation found on test.", result, notNullValue());

		return result;
	}
}
