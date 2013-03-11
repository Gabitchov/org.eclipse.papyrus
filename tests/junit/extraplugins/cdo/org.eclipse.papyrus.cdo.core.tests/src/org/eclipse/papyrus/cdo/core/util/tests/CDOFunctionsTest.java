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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;
import org.junit.Test;

import com.google.common.base.Function;


/**
 * This is the CDOFunctionsTest type. Enjoy.
 */
public class CDOFunctionsTest extends AbstractPapyrusCDOTest {

	@Test
	public void testAdapt_instanceOf() {
		Function<Object, CDOResourceNode> func = CDOFunctions.adapt(CDOResourceNode.class);
		CDOTransaction transaction = createTransaction();

		CDOResourceNode res = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		assertThat(func.apply(res), sameInstance(res));

		CDOResourceNode folder = res.getFolder();
		assertThat(func.apply(folder), sameInstance(folder));

		assertThat(func.apply(transaction), nullValue());
	}

	@Test
	public void testAdapt_adapter() {
		Function<Object, String> func = CDOFunctions.adapt(String.class);
		CDOTransaction transaction = createTransaction();

		CDOResourceNode res = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		assertThat(func.apply(res), nullValue());

		StringAdapter adapter = new StringAdapter(res);
		assertThat(func.apply(adapter), is(res.getPath()));
	}

	@Test
	public void testAdaptFunction_equals() {
		Function<Object, String> func1 = CDOFunctions.adapt(String.class);
		Function<Object, CDOResourceNode> func2 = CDOFunctions.adapt(CDOResourceNode.class);
		Function<Object, CDOResourceNode> func3 = CDOFunctions.adapt(CDOResourceNode.class);

		assertThat(func1.equals(func2), is(false));
		assertThat(func2 == func3, is(false));
		assertThat(func2, equalTo(func3));
		assertThat(func3, equalTo(func2));
	}

	@Test
	public void testAdaptFunction_hashCode() {
		Function<Object, String> func1 = CDOFunctions.adapt(String.class);
		Function<Object, CDOResourceNode> func2 = CDOFunctions.adapt(CDOResourceNode.class);
		Function<Object, CDOResourceNode> func3 = CDOFunctions.adapt(CDOResourceNode.class);

		assertThat(func1.hashCode() == func2.hashCode(), is(String.class.hashCode() == CDOResourceNode.class.hashCode()));
		assertThat(func2.hashCode(), is(func3.hashCode()));
	}

	@Test
	public void testAdaptFunction_toString() {
		Function<Object, String> func = CDOFunctions.adapt(String.class);

		assertThat(func.toString(), containsString("adapt("));
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
