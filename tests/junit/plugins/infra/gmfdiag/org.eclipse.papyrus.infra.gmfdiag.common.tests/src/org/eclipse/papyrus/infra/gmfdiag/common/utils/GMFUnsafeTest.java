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
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

import junit.framework.AssertionFailedError;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.infra.core.resource.TransactionalEditingDomainManager;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


/**
 * Test suite for the {@link GMFUnsafe} class.
 */
public class GMFUnsafeTest extends AbstractPapyrusTest {

	@Rule
	public final TestName testName = new TestName();

	private TransactionalEditingDomain domain;

	private Model model;

	private Class classA;

	private boolean doIt;

	@Test
	public void testWrite_runnable() throws Exception {
		if(doIt()) {
			GMFUnsafe.write(domain, new Runnable() {

				public void run() {
					createAttribute();
				}
			});
		}
	}

	@Test
	public void testWrite_command() throws Exception {
		if(doIt()) {
			GMFUnsafe.write(domain, new AbstractCommand() {

				public void redo() {
					createAttribute();
				}

				public void execute() {
					createAttribute();
				}
			});
		}
	}

	@Test
	public void testWrite_gmfCommand() throws Exception {
		if(doIt()) {
			GMFUnsafe.write(domain, new AbstractTransactionalCommand(domain, "Test", Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					createAttribute();
					return CommandResult.newOKCommandResult();
				}
			});
		}
	}

	@Test
	public void testWrap() throws Exception {
		if(doIt()) {
			GMFUnsafe.wrap(domain, new AbstractCommand() {

				public void redo() {
					createAttribute();
				}

				public void execute() {
					createAttribute();
				}
			}).execute();
		}
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		ResourceSet rset = new ResourceSetImpl();
		domain = TransactionalEditingDomainManager.createTransactionalEditingDomain(rset);

		// This will be treated by the editing domain as a read-only resource (except that we run unprotected transactions)
		Resource res = rset.createResource(URI.createURI("bogus://test/model.uml"));

		InputStream input = getClass().getResourceAsStream("model.uml");
		try {
			res.load(input, null);
		} finally {
			input.close();
		}

		model = (Model)res.getContents().get(0);
		classA = (Class)model.getOwnedType("A");
	}

	@After
	public void destroyFixture() {
		ResourceSet rset = domain.getResourceSet();

		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
		rset.getResources().clear();
		rset.eAdapters().clear();

		domain.dispose();

		model = null;
		classA = null;
	}

	Property createAttribute() {
		return classA.createOwnedAttribute("related", classA);
	}

	void assertProperty() {
		Property related = classA.getOwnedAttribute("related", classA);
		assertThat(related, notNullValue());
	}

	boolean doIt() {
		if(!doIt) {
			try {
				domain.runExclusive(new Runnable() {

					public void run() {
						try {
							GMFUnsafe.write(domain, new Runnable() {

								public void run() {
									doIt = true;

									try {
										// Reflectively re-invoke the test method.  This will result in it execution of its body because
										// the re-entrant call to doIt() will return true this time
										try {
											Object test = GMFUnsafeTest.this;
											Method method = test.getClass().getDeclaredMethod(testName.getMethodName());
											method.invoke(test);
										} catch (Exception e) {
											if((e instanceof InvocationTargetException) && (((InvocationTargetException)e).getTargetException() instanceof AssertionFailedError)) {
												throw (AssertionFailedError)((InvocationTargetException)e).getTargetException();
											}
											e.printStackTrace();
											fail("Reflective invocation of test failed: " + e.getLocalizedMessage());
										}
									} finally {
										doIt = false;
									}
								}
							});
						} catch (Exception e) {
							e.printStackTrace();
							fail("Unsafe write failed: " + e.getLocalizedMessage());
						}

						assertProperty();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				fail("Read transaction failed: " + e.getLocalizedMessage());
			}
		}

		return doIt;
	}
}
