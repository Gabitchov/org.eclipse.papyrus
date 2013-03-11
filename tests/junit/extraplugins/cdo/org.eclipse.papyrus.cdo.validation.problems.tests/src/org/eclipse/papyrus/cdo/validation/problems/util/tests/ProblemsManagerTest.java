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
package org.eclipse.papyrus.cdo.validation.problems.util.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.ESeverity;
import org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsManager;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLValidator;
import org.junit.After;
import org.junit.Test;

/**
 * Tests suite for the {@link ProblemsManager} API.
 */
public class ProblemsManagerTest
		extends AbstractPapyrusCDOTest {

	private Set<ProblemsManager> managers = new java.util.HashSet<ProblemsManager>();

	@Test
	public void getProblemsAdapter() {
		CDOTransaction transaction = createTransaction();

		ProblemsManager mgr = getProblemsManager(transaction);

		// doesn't create a new instance
		assertThat(mgr,
			sameInstance(ProblemsManager.getProblemsManager(transaction
				.getResourceSet())));
	}

	@Test
	public void allProblems() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		Collection<EProblem> allProblems = collect(mgr.getAllProblems());
		assertThat(allProblems.size(), equalTo(3));
		assertIndistinguishableMembersProblem(resource, allProblems);
		assertGeneralCompatibilityProblem(resource, allProblems);
		assertUnownedElementProblem(resource, allProblems);
	}

	@Test
	public void allProblems_EObject_noCrossReferencer() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		Collection<EProblem> problems = collect(mgr
			.getAllProblems(getClass2(resource)));
		assertThat(problems.size(), equalTo(2));
		assertIndistinguishableMembersProblem(resource, problems);
		assertGeneralCompatibilityProblem(resource, problems);
	}

	@Test
	public void allProblems_EObject_crossReferencer() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		// attach a cross-reference adapter
		transaction.getResourceSet().eAdapters()
			.add(new ECrossReferenceAdapter());

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		Collection<EProblem> problems = collect(mgr
			.getAllProblems(getClass2(resource)));
		assertThat(problems.size(), equalTo(2));
		assertIndistinguishableMembersProblem(resource, problems);
		assertGeneralCompatibilityProblem(resource, problems);
	}

	@Test
	public void purgeAll_noCrossReferencer() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		mgr.purgeAllProblems();

		assertThat(mgr.getAllProblems().hasNext(), is(false));
	}

	@Test
	public void purgeAll_crossReferencer() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		// attach a cross-reference adapter
		transaction.getResourceSet().eAdapters()
			.add(new ECrossReferenceAdapter());

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		mgr.purgeAllProblems();

		assertThat(mgr.getAllProblems().hasNext(), is(false));
	}

	@Test
	public void purge_noCrossReferencer() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		mgr.purgeProblems(getClass3(resource));

		Collection<EProblem> problems = collect(mgr.getAllProblems());
		assertThat(problems.size(), equalTo(2));
		assertIndistinguishableMembersProblem(resource, problems);
		assertGeneralCompatibilityProblem(resource, problems);
	}

	@Test
	public void purge_crossReferencer() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		// attach a cross-reference adapter
		transaction.getResourceSet().eAdapters()
			.add(new ECrossReferenceAdapter());

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		mgr.purgeProblems(getClass3(resource));

		Collection<EProblem> problems = collect(mgr.getAllProblems());
		assertThat(problems.size(), equalTo(2));
		assertIndistinguishableMembersProblem(resource, problems);
		assertGeneralCompatibilityProblem(resource, problems);
	}

	@Test
	public void disposeProblemsManager()
			throws Exception {

		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		// attach a cross-reference adapter
		ECrossReferenceAdapter xrefs = new ECrossReferenceAdapter();
		transaction.getResourceSet().eAdapters().add(xrefs);

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		// gather weak references to the problems
		ReferenceQueue<EProblem> queue = new ReferenceQueue<EProblem>();
		List<Reference<EProblem>> references = new java.util.ArrayList<Reference<EProblem>>(
			3);
		for (Iterator<EProblem> iter = mgr.getAllProblems(); iter.hasNext();) {
			references.add(new WeakReference<EProblem>(iter.next(), queue));
		}

		mgr.dispose();

		// try to force GC
		for (int i = 0; i < 10; i++) {
			System.gc();
		}

		// assert that the problems are unreachable
		for (int i = 0; i < 3; i++) {
			Reference<? extends EProblem> ref = queue.remove(1000);
			assertThat(ref, notNullValue());
		}
	}

	@Test
	public void dispose_crossReferencerAddedAfter()
			throws Exception {

		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		createTestModel(resource);

		ProblemsManager mgr = getProblemsManager(transaction);
		mgr.addDiagnostic(validate(resource));

		// attach a cross-reference adapter *after* adding problems
		ECrossReferenceAdapter xrefs = new ECrossReferenceAdapter();
		transaction.getResourceSet().eAdapters().add(xrefs);

		// gather weak references to the problems
		ReferenceQueue<EProblem> queue = new ReferenceQueue<EProblem>();
		List<Reference<EProblem>> references = new java.util.ArrayList<Reference<EProblem>>(
			3);
		for (Iterator<EProblem> iter = mgr.getAllProblems(); iter.hasNext();) {
			references.add(new WeakReference<EProblem>(iter.next(), queue));
		}

		mgr.dispose();

		// try to force GC
		for (int i = 0; i < 10; i++) {
			System.gc();
		}

		// assert that the problems are unreachable
		for (int i = 0; i < 3; i++) {
			Reference<? extends EProblem> ref = queue.remove(1000);
			assertThat(ref, notNullValue());
		}
	}

	@Test
	public void customProblemClass() {
		CDOTransaction transaction = createTransaction();
		CDOResource resource = transaction
			.createResource(getResourcePath("/resource1"));

		createTestModel(resource);

		// not actually a different class, but a different way of creating it
		ProblemsManager mgr = ProblemsManager.createProblemsManager(
			transaction.getResourceSet(), ProblemsPackage.Literals.EPROBLEM);
		managers.add(mgr);
		mgr.addDiagnostic(validate(resource));

		Collection<EProblem> allProblems = collect(mgr.getAllProblems());
		assertThat(allProblems.size(), equalTo(3));
		assertIndistinguishableMembersProblem(resource, allProblems);
		assertGeneralCompatibilityProblem(resource, allProblems);
		assertUnownedElementProblem(resource, allProblems);
	}

	//
	// Test framework
	//

	@After
	public void disposeProblemManagers()
			throws Exception {

		for (ProblemsManager next : managers) {
			next.dispose();
		}
	}

	void createTestModel(Resource res) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("testmodel");
		res.getContents().add(model);

		Class class1 = model.createOwnedClass("Class1", false);

		Interface interface1 = model.createOwnedInterface("Interface1");

		Class class2 = model.createOwnedClass("Class2", false);
		class2.createGeneralization(interface1); // invalid generalization
		class2.createOwnedAttribute("attr1", class1);
		class2.createOwnedAttribute("attr1", class1); // indistinguishable

		Class class3 = UMLFactory.eINSTANCE.createClass();
		class3.setName("Class3");
		res.getContents().add(class3); // not owned
	}

	Model getModel(Resource resource) {
		return (Model) EcoreUtil.getObjectByType(resource.getContents(),
			UMLPackage.Literals.MODEL);
	}

	Class getClass1(Resource resource) {
		return (Class) getModel(resource).getOwnedType("Class1");
	}

	Class getClass2(Resource resource) {
		return (Class) getModel(resource).getOwnedType("Class2");
	}

	Class getClass3(Resource resource) {
		return (Class) EcoreUtil.getObjectByType(resource.getContents(),
			UMLPackage.Literals.CLASS);
	}

	Interface getInterface1(Resource resource) {
		return (Interface) getModel(resource).getOwnedType("Interface1");
	}

	ProblemsManager getProblemsManager(CDOView view) {
		return getProblemsManager(view.getResourceSet());
	}

	ProblemsManager getProblemsManager(ResourceSet resourceSet) {
		ProblemsManager result = ProblemsManager
			.getProblemsManager(resourceSet);
		managers.add(result);
		return result;
	}

	Diagnostic validate(Resource resource) {
		EValidator.Registry registry = new EValidatorRegistryImpl(
			EValidator.Registry.INSTANCE);
		registry.put(UMLPackage.eINSTANCE, new UMLValidator());

		BasicDiagnostic result = new BasicDiagnostic();
		Diagnostician diagnostician = new Diagnostician(registry);

		for (EObject next : resource.getContents()) {
			diagnostician.validate(next, result);
		}

		return result;
	}

	Collection<EProblem> collect(Iterator<? extends EProblem> problems) {
		Collection<EProblem> result = new java.util.ArrayList<EProblem>();

		while (problems.hasNext()) {
			result.add(problems.next());
		}

		return result;
	}

	void assertProblem(Collection<EProblem> problems, ESeverity severity,
			String source, int code, String messagePattern, EObject element,
			EObject... related) {

		final List<EObject> relatedList = Arrays.asList(related);
		final Pattern pattern = Pattern.compile(messagePattern);

		EProblem found = null;
		for (EProblem problem : problems) {
			if (problem.getElement() == element //
				&& problem.getRelated().equals(relatedList) //
				&& problem.getSeverity() == severity //
				&& pattern.matcher(problem.getMessage()).find() //
				&& source.equals(problem.getSource()) //
				&& problem.getCode() == code) {
				found = problem;
				break;
			}
		}

		assertThat(found, notNullValue());
	}

	void assertIndistinguishableMembersProblem(Resource resource,
			Collection<EProblem> problems) {

		Class class2 = getClass2(resource);

		assertProblem(problems, ESeverity.WARNING,
			UMLValidator.DIAGNOSTIC_SOURCE,
			UMLValidator.NAMESPACE__MEMBERS_DISTINGUISHABLE, "disting", class2);
	}

	void assertGeneralCompatibilityProblem(Resource resource,
			Collection<EProblem> problems) {

		Class class2 = getClass2(resource);
		Interface interface1 = getInterface1(resource);

		assertProblem(problems, ESeverity.WARNING,
			UMLValidator.DIAGNOSTIC_SOURCE,
			UMLValidator.CLASSIFIER__SPECIALIZE_TYPE, "special", class2,
			interface1);
	}

	void assertUnownedElementProblem(Resource resource,
			Collection<EProblem> problems) {

		Class class3 = getClass3(resource);

		assertProblem(problems, ESeverity.WARNING,
			UMLValidator.DIAGNOSTIC_SOURCE, UMLValidator.ELEMENT__HAS_OWNER,
			"owned", class3);
	}
}
