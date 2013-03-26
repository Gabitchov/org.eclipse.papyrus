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
package org.eclipse.papyrus.cdo.core.util.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.eresource.CDOTextResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.util.CDOPredicates;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


/**
 * This is the CDOPredicatesTest type. Enjoy.
 */
public class CDOPredicatesTest extends AbstractPapyrusCDOTest {

	@Test
	public void testAdaptsTo_instanceOf() {
		Predicate<Object> pred = CDOPredicates.adaptsTo(CDOResourceNode.class);
		CDOTransaction transaction = createTransaction();

		CDOResource res = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		assertThat(pred.apply(res), is(true));

		CDOResourceFolder folder = res.getFolder();
		assertThat(pred.apply(folder), is(true));

		assertThat(pred.apply(transaction.getRootResource()), is(true));

		assertThat(pred.apply(transaction), is(false));
	}

	@Test
	public void testAdaptsTo_adapter() {
		Predicate<Object> pred = CDOPredicates.adaptsTo(String.class);
		CDOTransaction transaction = createTransaction();

		CDOResource res = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		assertThat(pred.apply(res), is(false));

		StringAdapter adapter = new StringAdapter(res);
		assertThat(pred.apply(adapter), is(true));
	}

	@Test
	public void testHasExtension() {
		Predicate<CDOResourceNode> hasUML = CDOPredicates.hasExtension("uml");
		Predicate<CDOResourceNode> hasNone = CDOPredicates.hasExtension(null);
		CDOTransaction transaction = createTransaction();

		CDOResource res1 = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		CDOResource res2 = transaction.createResource(getResourcePath("/folder1/foo.notation"));
		assertThat(hasUML.apply(res1), is(true));
		assertThat(hasNone.apply(res1), is(false));
		assertThat(hasUML.apply(res2), is(false));
		assertThat(hasNone.apply(res2), is(false));

		CDOResourceFolder folder = res1.getFolder();
		assertThat(hasUML.apply(folder), is(false));
		assertThat(hasNone.apply(folder), is(true));
		assertThat(hasUML.apply(transaction.getRootResource()), is(false));
		assertThat(hasNone.apply(transaction.getRootResource()), is(true));
	}

	@Test
	public void testHasExtension_equals() {
		Set<Predicate<CDOResourceNode>> set1 = ImmutableSet.of( //
		CDOPredicates.hasExtension("uml"), //
			CDOPredicates.hasExtension("notation"), //
			CDOPredicates.hasExtension(null));
		Set<Predicate<CDOResourceNode>> set2 = ImmutableSet.of( //
		CDOPredicates.hasExtension("uml"), //
			CDOPredicates.hasExtension("notation"), //
			CDOPredicates.hasExtension(null));

		@SuppressWarnings("unchecked")
		Set<List<Predicate<CDOResourceNode>>> product = Sets.cartesianProduct(set1, set2);

		int equalPairs = 0;
		for(List<Predicate<CDOResourceNode>> next : product) {
			if(next.get(0).equals(next.get(1))) {
				equalPairs++;
			}
		}

		assertThat(equalPairs, is(3));
	}

	@Test
	public void testHasExtension_hashCode() {
		Set<String> set1 = ImmutableSet.of("uml", "notation", "");
		Set<String> set2 = ImmutableSet.of("uml", "notation", "");

		@SuppressWarnings("unchecked")
		Set<List<String>> product = Sets.cartesianProduct(set1, set2);

		for(List<String> next : product) {
			String ext1 = Strings.emptyToNull(next.get(0));
			String ext2 = Strings.emptyToNull(next.get(1));

			assertThat(CDOPredicates.hasExtension(ext1).hashCode() == CDOPredicates.hasExtension(ext2).hashCode(), //
				is(Objects.hashCode(ext1) == Objects.hashCode(ext2)));
		}
	}

	@Test
	public void testHasExtension_toString() {
		assertThat(CDOPredicates.hasExtension("uml").toString(), containsString("hasExtension("));
		assertThat(CDOPredicates.hasExtension(null).toString(), containsString("hasNoExtension("));
	}

	@Test
	public void testHasURIPrefix() {
		CDOTransaction transaction = createTransaction();
		CDOResourceFolder folder = transaction.createResourceFolder(getResourcePath("/folder1"));
		CDOResource res1 = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		CDOTextResource res2 = transaction.createTextResource(getResourcePath("/folder2/foo.properties"));

		URI prefix = folder.getURI();
		if(!prefix.hasTrailingPathSeparator()) {
			prefix = prefix.appendSegment("");
		}

		Predicate<CDOResourceNode> pred = CDOPredicates.hasURIPrefix(prefix);

		assertThat(pred.apply(folder), is(false));
		assertThat(pred.apply(res1), is(true));
		assertThat(pred.apply(res2), is(false));
	}

	@Test
	public void testHasURIPrefix_equals() {
		Set<Predicate<CDOResourceNode>> set1 = ImmutableSet.of( //
		CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/folder1/")), //
			CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/folder2/")), //
			CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/")));
		Set<Predicate<CDOResourceNode>> set2 = ImmutableSet.of( //
		CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/folder1/")), //
			CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/folder2/")), //
			CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/")));

		@SuppressWarnings("unchecked")
		Set<List<Predicate<CDOResourceNode>>> product = Sets.cartesianProduct(set1, set2);

		int equalPairs = 0;
		for(List<Predicate<CDOResourceNode>> next : product) {
			if(next.get(0).equals(next.get(1))) {
				equalPairs++;
			}
		}

		assertThat(equalPairs, is(3));
	}

	@Test
	public void testHasURIPrefix_hashCode() {
		Set<String> set1 = ImmutableSet.of("cdo://repo1/folder1/", "cdo://repo1/folder2/", "cdo://repo1/");
		Set<String> set2 = ImmutableSet.of("cdo://repo1/folder1/", "cdo://repo1/folder2/", "cdo://repo1/");

		@SuppressWarnings("unchecked")
		Set<List<String>> product = Sets.cartesianProduct(set1, set2);

		for(List<String> next : product) {
			URI uri1 = URI.createURI(next.get(0));
			URI uri2 = URI.createURI(next.get(1));

			assertThat(CDOPredicates.hasURIPrefix(uri1).hashCode() == CDOPredicates.hasURIPrefix(uri2).hashCode(), //
				is(Objects.hashCode(uri1) == Objects.hashCode(uri2)));
		}
	}

	@Test
	public void testHasURIPrefix_toString() {
		assertThat(CDOPredicates.hasURIPrefix(URI.createURI("cdo://repo1/folder1/")).toString(), containsString("hasURIPrefix("));
	}

	//
	// Test framework
	//

	static class StringAdapter implements IAdaptable {

		private final CDOResourceNode node;

		StringAdapter(CDOResourceNode node) {
			this.node = node;
		}

		public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
			return (adapter == String.class) ? node.getPath() : null;
		}
	}
}
