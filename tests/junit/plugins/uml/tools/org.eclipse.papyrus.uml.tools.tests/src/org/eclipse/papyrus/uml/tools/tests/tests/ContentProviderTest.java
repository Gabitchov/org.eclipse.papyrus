/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.tests.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.uml.tools.tests.Activator;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

//TODO : Test TreeToFlatContentProvider (Number of elements displayed, isValid...)
public class ContentProviderTest extends AbstractPapyrusTest {

	private EObject testModel;

	private EClass Class1, Class2, Class3, Class4;

	private final int maxLoops = 20; //Avoid infinite recursion on infinite trees

	private EStructuralFeature singleValuedProperty, multiValuedProperty, enumProperty;

	@Before
	public void init() {
		try {
			testModel = EMFHelper.loadEMFModel(new ResourceSetImpl(), URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/emf/TestModel.xmi", true));
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		assertNotNull("Cannot load the EMF Tests model", testModel);

		Class1 = getEClass("Class1");
		Class2 = getEClass("Class2");
		Class3 = getEClass("Class3");
		Class4 = getEClass("Class4");

		singleValuedProperty = getFeature("Class1", "singleValuedProperty");
		multiValuedProperty = getFeature("Class1", "multiValuedProperty");
		enumProperty = getFeature("Class2", "enum");

		assertNotNull(Class1);
		assertNotNull(Class2);
		assertNotNull(Class3);
		assertNotNull(Class4);

		assertNotNull(singleValuedProperty);
		assertNotNull(multiValuedProperty);
		assertNotNull(enumProperty);
	}

	@After
	public void dispose() {
		testModel = null;
	}

	@Test
	public void singleValuePropertyTest() {
		//The semantic content provider should return the whole model as a Tree
		SemanticEMFContentProvider provider = new SemanticEMFContentProvider(testModel, singleValuedProperty, new EObject[]{ testModel });
		Object[] roots = provider.getElements();
		assertNotNull(roots);
		assertEquals(1, roots.length);

		testTree(roots[0], provider, provider, maxLoops);
	}

	@Test
	public void singleValuePropertyGraphicalTest() {
		//The graphical content provider should only return the valid values for the selected feature
		EMFContentProvider provider = new EMFContentProvider(testModel, singleValuedProperty);

		//The semantic roots contain both the model and the metamodel, but the metamodel doesn't contain any valid value. It should not be displayed.
		Object[] roots = provider.getElements();
		assertNotNull(roots);
		assertEquals(1, roots.length);

		testTree(roots[0], provider, provider, maxLoops);

		//TODO : Test filters
	}

	@Test
	public void enumPropertyTest() {
		EMFContentProvider provider = new EMFContentProvider(testModel, enumProperty);
		Object[] elements = provider.getElements();
		assertNotNull(elements);
		assertEquals(3, elements.length); //It should only return the 3 valid enum literals

		//TODO Improve this test. Currently, the only implementation provides a flat provider, but a tree
		//provider might also be valid
	}

	private void testTree(Object current, IHierarchicContentProvider hierarchicProvider, IAdaptableContentProvider adaptableProvider, int maxLoops) {
		if(maxLoops <= 0) {
			//This is not necessarily an error. ContentProviders can be infinite
			//assertTrue("Infinite recursion", false);
			return;
		}
		maxLoops--;

		testElement(current, hierarchicProvider, adaptableProvider);

		for(Object containerElement : hierarchicProvider.getChildren(current)) {
			testTree(containerElement, hierarchicProvider, adaptableProvider, maxLoops);
		}
	}

	private boolean testElement(Object current, IHierarchicContentProvider hierarchicProvider, IAdaptableContentProvider adaptableProvider) {
		//current is an EMFFacet wrapper. Test the adapted value

		Object adaptedValue = adaptableProvider.getAdaptedValue(current);
		assertNotNull(adaptedValue);
		assertTrue(adaptedValue instanceof EObject);
		EObject eObject = (EObject)adaptedValue;

		boolean isValid = hierarchicProvider.isValidValue(current);

		//Only Class2 and Class4 elements are valid for this property
		assertEquals(isValid, eObject.eClass() == Class2 || eObject.eClass() == Class4);

		return isValid;
	}

	@Ignore("Not implemented yet")
	@Test
	public void multipleValuePropertyTest() {
		throw new UnsupportedOperationException("Not implemtend yet");
	}

	private EStructuralFeature getFeature(String className, String featureName) {
		EClass eClass = getEClass(className);
		return eClass.getEStructuralFeature(featureName);
	}

	private EPackage getEPackage() {
		return testModel.eClass().getEPackage();
	}

	private EClass getEClass(String className) {
		return (EClass)getEPackage().getEClassifier(className);
	}
}
