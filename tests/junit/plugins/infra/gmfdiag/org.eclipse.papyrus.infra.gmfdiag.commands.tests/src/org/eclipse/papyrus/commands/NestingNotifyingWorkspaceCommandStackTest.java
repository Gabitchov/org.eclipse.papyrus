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
 *   Christian W. Damus (CEA) - bug 323802
 *
 */
package org.eclipse.papyrus.commands;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.Callable;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomain;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.google.common.base.Objects;


/**
 * Test suite for the {@link NestingNotifyingWorkspaceCommandStack} class.
 */
public class NestingNotifyingWorkspaceCommandStackTest {

	@Rule
	public final TestName testName = new TestName();
	
	// No API signatures but the most basic are required for nesting
	private CommandStack fixture;

	private TransactionalEditingDomain domain;

	private ResourceSet rset;

	private EPackage testPackage;

	private EClass foo;

	public NestingNotifyingWorkspaceCommandStackTest() {
		super();
	}

	//
	// Test cases
	//

	@Test
	public void testCompleteUnnestedCommand() {
		Callable<EAttribute> createAttribute = createAttribute();

		int oldFeatureCount = foo.getEStructuralFeatures().size();

		// Create two attributes
		EAttribute attr1 = execute(createAttribute);
		EAttribute attr2 = execute(createAttribute);
		assertThat(foo.getEStructuralFeatures().size(), is(oldFeatureCount + 2));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr1));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr2));

		// Undo only undoes one of them
		Command undone = undo();
		assertThat(foo.getEStructuralFeatures().size(), is(oldFeatureCount + 1));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr1));
		assertThat(foo.getEStructuralFeatures(), not(hasItem(attr2)));

		// Redo is sane
		Command redone = redo();
		assertThat(redone, sameInstance(undone));
		assertThat(foo.getEStructuralFeatures().size(), is(oldFeatureCount + 2));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr1));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr2));
	}

	@Test
	public void testCancelUnnestedCommand() {
		Callable<EAttribute> createAttribute = createAttribute(2);

		int oldFeatureCount = foo.getEStructuralFeatures().size();

		// Try to create two attributes (second one cancels)
		EAttribute attr1 = execute(createAttribute);
		EAttribute attr2 = execute(createAttribute);
		assertThat(attr2, nullValue());
		assertThat(foo.getEStructuralFeatures().size(), is(oldFeatureCount + 1));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr1));
		assertThat(foo.getEStructuralFeature("attribute2"), nullValue()); //$NON-NLS-1$

		// Undo is sane
		Command undone = undo();
		assertThat(foo.getEStructuralFeatures().size(), is(oldFeatureCount));
		assertThat(foo.getEStructuralFeatures(), not(hasItem(attr1)));
		assertThat(foo.getEStructuralFeature("attribute2"), nullValue()); //$NON-NLS-1$

		// Redo is sane
		Command redone = redo();
		assertThat(redone, sameInstance(undone));
		assertThat(foo.getEStructuralFeatures().size(), is(oldFeatureCount + 1));
		assertThat(foo.getEStructuralFeatures(), hasItem(attr1));
		assertThat(foo.getEStructuralFeature("attribute2"), nullValue()); //$NON-NLS-1$
	}

	@Test
	public void testCompleteNestedCommand() {
		final int FEATURES = 2;
		Callable<EClass> createClass = createClass(FEATURES);

		int oldClassifierCount = testPackage.getEClassifiers().size();

		EClass clas = execute(createClass);
		assertThat(testPackage.getEClassifiers().size(), is(oldClassifierCount + 1));
		assertThat(testPackage.getEClassifiers(), hasItem(clas));
		assertThat(clas.getEStructuralFeatures().size(), is(FEATURES));
		assertThat(clas.getEStructuralFeature("attribute1"), notNullValue()); //$NON-NLS-1$
		assertThat(clas.getEStructuralFeature("attribute2"), notNullValue()); //$NON-NLS-1$

		// Undo is sane and there is only one command to undo
		Command undone = undo();
		assertThat(fixture.canUndo(), is(false));
		assertThat(testPackage.getEClassifiers().size(), is(oldClassifierCount));
		assertThat(testPackage.getEClassifiers(), not(hasItem(clas)));

		// Redo is sane
		Command redone = redo();
		assertThat(redone, sameInstance(undone));
		assertThat(testPackage.getEClassifiers().size(), is(oldClassifierCount + 1));
		assertThat(testPackage.getEClassifiers(), hasItem(clas));
		assertThat(clas.getEStructuralFeatures().size(), is(FEATURES));
		assertThat(clas.getEStructuralFeature("attribute1"), notNullValue()); //$NON-NLS-1$
		assertThat(clas.getEStructuralFeature("attribute2"), notNullValue()); //$NON-NLS-1$
	}

	@Test
	public void testCancelNestedCommand() {
		final int FEATURES = 2;
		Callable<EClass> createClass = createClass(FEATURES, 2, FEATURES);

		int oldClassifierCount = testPackage.getEClassifiers().size();

		// Try to create two classes (second one cancels)
		EClass class1 = execute(createClass);
		EClass class2 = execute(createClass);
		assertThat(class2, nullValue());
		assertThat(testPackage.getEClassifiers().size(), is(oldClassifierCount + 1));
		assertThat(testPackage.getEClassifiers(), hasItem(class1));
		assertThat(class1.getEStructuralFeatures().size(), is(FEATURES));
		assertThat(class1.getEStructuralFeature("attribute1"), notNullValue()); //$NON-NLS-1$
		assertThat(class1.getEStructuralFeature("attribute2"), notNullValue()); //$NON-NLS-1$

		// Undo is sane and there is only one command to undo
		Command undone = undo();
		assertThat(fixture.canUndo(), is(false));
		assertThat(testPackage.getEClassifiers().size(), is(oldClassifierCount));
		assertThat(testPackage.getEClassifiers(), not(hasItem(class1)));

		// Redo is sane
		Command redone = redo();
		assertThat(redone, sameInstance(undone));
		assertThat(testPackage.getEClassifiers().size(), is(oldClassifierCount + 1));
		assertThat(testPackage.getEClassifiers(), hasItem(class1));
		assertThat(class1.getEStructuralFeatures().size(), is(FEATURES));
		assertThat(class1.getEStructuralFeature("attribute1"), notNullValue()); //$NON-NLS-1$
		assertThat(class1.getEStructuralFeature("attribute2"), notNullValue()); //$NON-NLS-1$
	}

	@Test
	public void testCompleteTripleNestedCommand() {
		final int CLASSES = 2;
		final int FEATURES = 2;

		Callable<EPackage> createPackage = createPackage(CLASSES, FEATURES);

		int oldPackageCount = testPackage.getESubpackages().size();

		EPackage pkg = execute(createPackage);
		assertThat(testPackage.getESubpackages().size(), is(oldPackageCount + 1));
		assertThat(testPackage.getESubpackages(), hasItem(pkg));
		assertThat(pkg.getEClassifiers().size(), is(CLASSES));
		assertThat(pkg.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class1")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		assertThat(pkg.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class2")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		// Undo is sane and there is only one command to undo
		Command undone = undo();
		assertThat(fixture.canUndo(), is(false));
		assertThat(testPackage.getESubpackages().size(), is(oldPackageCount));
		assertThat(testPackage.getESubpackages(), not(hasItem(pkg)));
		assertThat(pkg.getName(), nullValue());
		assertThat(pkg.getEClassifiers().size(), is(0));
		assertThat(pkg.getEClassifiers().size(), is(0));

		// Redo is sane
		Command redone = redo();
		assertThat(redone, sameInstance(undone));
		assertThat(fixture.canRedo(), is(false));
		assertThat(testPackage.getESubpackages().size(), is(oldPackageCount + 1));
		assertThat(testPackage.getESubpackages(), hasItem(pkg));
		assertThat(pkg, named("package1")); //$NON-NLS-1$
		assertThat(pkg.getEClassifiers().size(), is(CLASSES));
		assertThat(pkg.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class1")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		assertThat(pkg.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class2")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Test
	public void testCancelTripleNestedCommand() {
		final int CLASSES = 2;
		final int FEATURES = 2;

		Callable<EPackage> createPackage = createPackage(CLASSES, FEATURES, 2, CLASSES, FEATURES);

		int oldPackageCount = testPackage.getESubpackages().size();

		// Try to create two packages (second one cancels)
		EPackage pkg1 = execute(createPackage);
		EPackage pkg2 = execute(createPackage);

		// the first package is complete
		assertThat(testPackage.getESubpackages().size(), is(oldPackageCount + 1));
		assertThat(testPackage.getESubpackages(), hasItem(pkg1));
		assertThat(pkg1, named("package1")); //$NON-NLS-1$
		assertThat(pkg1.getEClassifiers().size(), is(CLASSES));
		assertThat(pkg1.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class1")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		assertThat(pkg1.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class2")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		// there is no second package
		assertThat(pkg2, nullValue());

		// Undo is sane and there is only one command to undo
		Command undone = undo();
		assertThat(fixture.canUndo(), is(false));
		assertThat(testPackage.getESubpackages().size(), is(oldPackageCount));
		assertThat(testPackage.getESubpackages(), not(hasItem(pkg1)));
		assertThat(pkg1.getName(), nullValue());
		assertThat(pkg1.getEClassifiers().size(), is(0));

		// Redo is sane
		Command redone = redo();
		assertThat(fixture.canRedo(), is(false));
		assertThat(redone, sameInstance(undone));
		assertThat(testPackage.getESubpackages().size(), is(oldPackageCount + 1));
		assertThat(testPackage.getESubpackages(), hasItem(pkg1));
		assertThat(pkg1, named("package1")); //$NON-NLS-1$
		assertThat(pkg1.getEClassifiers().size(), is(CLASSES));
		assertThat(pkg1.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class1")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		assertThat(pkg1.getEClassifiers(), hasItem(both(featureCount(FEATURES)).and(named("Class2")).and(hasFeature("attribute1")).and(hasFeature("attribute2")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() {
		rset = new ResourceSetImpl();
		fixture = new NestingNotifyingWorkspaceCommandStack(CheckedOperationHistory.getInstance());
		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		domain = new PapyrusROTransactionalEditingDomain(adapterFactory, (TransactionalCommandStack)fixture, rset);

		URL testModelURL = getClass().getResource("bug402525.ecore"); //$NON-NLS-1$
		Resource testModel = rset.getResource(URI.createURI(testModelURL.toExternalForm(), true), true);
		testPackage = (EPackage)testModel.getContents().get(0);
		foo = (EClass)testPackage.getEClassifier("Foo"); //$NON-NLS-1$
		
		// tweak the URI so that we don't think this is a plug-in deployed resource that is unmodifiable (which triggers transaction rollback)
		testModel.setURI(URI.createPlatformResourceURI(String.format("%s/%s", testName.getMethodName(), testModel.getURI().lastSegment()), true));
	}

	@After
	public void destroyFixture() {
		// This disposes the command stack for us
		domain.dispose();
		domain = null;
		fixture = null;

		dispose(rset);
		rset = null;
	}

	void dispose(ResourceSet rset) {
		for(Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
	}

	<V> V execute(final Callable<V> operation) {
		class TestCommand extends RecordingCommand {

			V result;

			TestCommand() {
				super(domain);
			}

			@Override
			protected void doExecute() {
				try {
					result = operation.call();
				} catch (OperationCanceledException e) {
					// Pass it on
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					fail("Uncaught exception in operation: " + e.getLocalizedMessage()); //$NON-NLS-1$
				}
			}
		}

		TestCommand command = new TestCommand();
		fixture.execute(command);
		return command.result;
	}

	Command undo() {
		assertThat("Cannot undo", fixture.canUndo()); //$NON-NLS-1$
		Command result = fixture.getUndoCommand();
		fixture.undo();
		return result;
	}

	Command redo() {
		assertThat("Cannot redo", fixture.canRedo()); //$NON-NLS-1$
		Command result = fixture.getRedoCommand();
		fixture.redo();
		return result;
	}

	Callable<EAttribute> createAttribute() {
		return createAttribute(0);
	}

	Callable<EAttribute> createAttribute(int cancelOn) {
		return createAttribute(foo, cancelOn);
	}

	Callable<EAttribute> createAttribute(final EClass owner, final int cancelOn) {
		return new Callable<EAttribute>() {

			int i = 0;

			public EAttribute call() throws Exception {
				String name = nextName();

				EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
				owner.getEStructuralFeatures().add(attr);
				attr.setName(name);
				attr.setEType(EcorePackage.Literals.ESTRING);

				checkCancel();

				return attr;
			}

			private String nextName() {
				i = i + 1;
				return "attribute" + i; //$NON-NLS-1$
			}

			private void checkCancel() {
				if(i == cancelOn) {
					throw new OperationCanceledException();
				}
			}
		};
	}

	Callable<EClass> createClass(int attributes) {
		return createClass(attributes, 0, 0);
	}

	Callable<EClass> createClass(int attributes, int cancelOn, int cancelAttributesOn) {
		return createClass(testPackage, attributes, cancelOn, cancelAttributesOn);
	}

	Callable<EClass> createClass(final EPackage owner, final int attributes, final int cancelOn, final int cancelAttributesOn) {
		return new Callable<EClass>() {

			int i = 0;

			public EClass call() throws Exception {
				String name = nextName();

				EClass clas = EcoreFactory.eINSTANCE.createEClass();
				owner.getEClassifiers().add(clas);
				clas.setName(name);

				Callable<?> createAttribute = createAttribute(clas, checkCancelAttributes());
				for(int i = 0; i < attributes; i++) {
					// Nested command
					execute(createAttribute);
				}

				return clas;
			}

			private String nextName() {
				i = i + 1;
				return "Class" + i; //$NON-NLS-1$
			}

			private int checkCancelAttributes() {
				return (i == cancelOn) ? cancelAttributesOn : 0;
			}
		};
	}

	Callable<EPackage> createPackage(int classes, int attributes) {
		return createPackage(classes, attributes, 0, 0, 0);
	}

	Callable<EPackage> createPackage(final int classes, final int attributes, final int cancelOn, final int cancelClassesOn, final int cancelAttributesOn) {
		return new Callable<EPackage>() {

			int i = 0;

			public EPackage call() throws Exception {
				String name = nextName();

				EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
				testPackage.getESubpackages().add(pkg);
				pkg.setName(name);

				Callable<?> createClass = createClass(pkg, attributes, checkCancelClasses(), cancelAttributesOn);
				for(int i = 0; i < classes; i++) {
					// Nested command
					execute(createClass);
				}

				return pkg;
			}

			private String nextName() {
				i = i + 1;
				return "package" + i; //$NON-NLS-1$
			}

			private int checkCancelClasses() {
				return (i == cancelOn) ? cancelClassesOn : 0;
			}
		};
	}

	Matcher<ENamedElement> named(final String name) {
		return new BaseMatcher<ENamedElement>() {

			public void describeTo(Description desc) {
				desc.appendText("is named \"").appendValue(name).appendText("\""); //$NON-NLS-1$ //$NON-NLS-2$
			}

			public boolean matches(Object o) {
				return (o instanceof ENamedElement) && Objects.equal(((ENamedElement)o).getName(), name);
			}
		};
	}

	Matcher<EClass> featureCount(final int count) {
		return new BaseMatcher<EClass>() {

			public void describeTo(Description desc) {
				desc.appendText("has ").appendValue(count).appendText(" features"); //$NON-NLS-1$ //$NON-NLS-2$
			}

			public boolean matches(Object o) {
				return (o instanceof EClass) && (((EClass)o).getEStructuralFeatures().size() == count);
			}
		};
	}

	Matcher<EClass> hasFeature(final String name) {
		return new BaseMatcher<EClass>() {

			public void describeTo(Description desc) {
				desc.appendText("has a \"").appendValue(name).appendText("\" feature"); //$NON-NLS-1$ //$NON-NLS-2$
			}

			public boolean matches(Object o) {
				return (o instanceof EClass) && (((EClass)o).getEStructuralFeature(name) != null);
			}
		};
	}
}
