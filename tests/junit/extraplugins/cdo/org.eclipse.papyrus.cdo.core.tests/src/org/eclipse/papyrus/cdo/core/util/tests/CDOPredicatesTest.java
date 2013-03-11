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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.util.CDOPredicates;
import org.junit.Test;

import com.google.common.base.Predicate;


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
