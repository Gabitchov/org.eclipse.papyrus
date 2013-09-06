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
package org.eclipse.papyrus.cdo.internal.core.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureListIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.junit.Test;


/**
 * Selected unit tests for the {@link CDOUtils} class.
 */
public class CDOUtilsTest {

	public CDOUtilsTest() {
		super();
	}

	@Test
	public void testIteratorScalarAttribute() throws Exception {
		FeatureListIterator<String> sIter = CDOUtils.iterator(EcorePackage.Literals.ECLASS, EcorePackage.Literals.ENAMED_ELEMENT__NAME, false);

		assertThat(sIter.hasNext(), is(true));
		assertThat(sIter.nextIndex(), is(-1));
		assertThat(sIter.next(), is(EcorePackage.Literals.ECLASS.getName()));

		assertThat(sIter.hasPrevious(), is(true));
		assertThat(sIter.previousIndex(), is(-1));
		assertThat(sIter.previous(), is(EcorePackage.Literals.ECLASS.getName()));
	}

	@Test
	public void testIteratorEmptyReference() throws Exception {
		FeatureListIterator<String> sIter = CDOUtils.iterator(EcorePackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ESUPER_PACKAGE, false);

		assertThat(sIter.hasNext(), is(false));
		assertThat(sIter.nextIndex(), is(-1));
		assertThat(sIter.hasPrevious(), is(false));
	}

	@Test
	public void testIteratorReferenceResolving() throws Exception {
		ResourceSet rset = new ResourceSetImpl();
		Resource a = rset.getResource(getTestResourceURI("A.ecore"), true);

		EClass a1 = (EClass)((EPackage)a.getContents().get(0)).getEClassifier("A1");
		FeatureListIterator<EClass> sIter = CDOUtils.iterator(a1, EcorePackage.Literals.ECLASS__ESUPER_TYPES, true);

		assertThat(sIter.hasNext(), is(true));
		assertThat(sIter.nextIndex(), is(0));
		assertThat(sIter.next().getName(), is("B1"));

		assertThat(sIter.hasNext(), is(true));
		assertThat(sIter.nextIndex(), is(1));
		assertThat(sIter.next().getName(), is("B2"));

		assertThat(sIter.hasNext(), is(false));
		assertThat(sIter.nextIndex(), is(2));

		assertThat(sIter.hasPrevious(), is(true));
		assertThat(sIter.previousIndex(), is(1));
		assertThat(sIter.previous().getName(), is("B2"));

		assertThat(sIter.hasPrevious(), is(true));
		assertThat(sIter.previousIndex(), is(0));
		assertThat(sIter.previous().getName(), is("B1"));

		assertThat(sIter.hasPrevious(), is(false));
	}

	@Test
	public void testIteratorReferenceNonesolving() throws Exception {
		ResourceSet rset = new ResourceSetImpl();
		Resource a = rset.getResource(getTestResourceURI("A.ecore"), true);

		EClass a1 = (EClass)((EPackage)a.getContents().get(0)).getEClassifier("A1");
		FeatureListIterator<EClass> sIter = CDOUtils.iterator(a1, EcorePackage.Literals.ECLASS__ESUPER_TYPES, false);

		assertThat(sIter.hasNext(), is(true));
		assertThat(sIter.nextIndex(), is(0));
		EClass next = sIter.next();
		assertThat(next.eIsProxy(), is(true));
		assertThat(EcoreUtil.getURI(next).fragment(), containsString("B1"));

		assertThat(sIter.hasNext(), is(true));
		next = sIter.next();
		assertThat(next.eIsProxy(), is(true));
		assertThat(EcoreUtil.getURI(next).fragment(), containsString("B2"));

		assertThat(sIter.hasNext(), is(false));
		assertThat(sIter.nextIndex(), is(2));

		assertThat(sIter.hasPrevious(), is(true));
		assertThat(sIter.previousIndex(), is(1));
		EClass previous = sIter.previous();
		assertThat(previous.eIsProxy(), is(true));
		assertThat(EcoreUtil.getURI(previous).fragment(), containsString("B2"));

		assertThat(sIter.hasPrevious(), is(true));
		assertThat(sIter.previousIndex(), is(0));
		previous = sIter.previous();
		assertThat(previous.eIsProxy(), is(true));
		assertThat(EcoreUtil.getURI(previous).fragment(), containsString("B1"));

		assertThat(sIter.hasPrevious(), is(false));
	}

	//
	// Test framework
	//

	URI getTestResourceURI(String name) {
		URL result = getClass().getClassLoader().getResource("resources/xmi/" + name);
		return URI.createURI(result.toExternalForm(), true);
	}
}
