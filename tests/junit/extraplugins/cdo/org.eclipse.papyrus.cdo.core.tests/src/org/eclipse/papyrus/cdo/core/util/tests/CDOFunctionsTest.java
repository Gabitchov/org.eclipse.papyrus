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

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.eresource.CDOTextResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
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

	@Test
	public void testRootFunction() {
		CDOTransaction transaction = createTransaction();

		Resource res = transaction.createResource(getResourcePath("/folder1/foo.uml"));
		Package package1 = UMLFactory.eINSTANCE.createPackage();
		res.getContents().add(package1);
		Model model1 = UMLFactory.eINSTANCE.createModel();
		res.getContents().add(model1);

		assertThat(CDOFunctions.getRoot(Model.class).apply(res), sameInstance(model1));
		assertThat(CDOFunctions.getRoot(Interface.class).apply(res), nullValue());
	}

	@Test
	public void testRootFunction_equals() {
		Function<Resource, Model> func1 = CDOFunctions.getRoot(Model.class);
		Function<Resource, Package> func2 = CDOFunctions.getRoot(Package.class);
		Function<Resource, Package> func3 = CDOFunctions.getRoot(Package.class);

		assertThat((Object)func1, not(equalTo((Object)func2)));
		assertThat((Object)func2, not(equalTo((Object)func1)));
		assertThat(func2 == func3, is(false));
		assertThat(func2, equalTo(func3));
		assertThat(func3, equalTo(func2));
	}

	@Test
	public void testRootFunction_hashCode() {
		Function<Resource, Model> func1 = CDOFunctions.getRoot(Model.class);
		Function<Resource, Package> func2 = CDOFunctions.getRoot(Package.class);
		Function<Resource, Package> func3 = CDOFunctions.getRoot(Package.class);

		assertThat(func1.hashCode() == func2.hashCode(), is(Model.class.hashCode() == Package.class.hashCode()));
		assertThat(func2.hashCode(), is(func3.hashCode()));
	}

	@Test
	public void testRootFunction_toString() {
		Function<Resource, Model> func = CDOFunctions.getRoot(Model.class);

		assertThat(func.toString(), containsString("getRoot("));
	}

	@Test
	public void testFolderContentsFunction_folder() {
		CDOTransaction transaction = createTransaction();

		CDOResourceFolder folder = transaction.createResourceFolder(getResourcePath("/folder1"));
		CDOResourceNode text = transaction.createTextResource(getResourcePath("/folder1/foo.properties"));
		CDOResource res = transaction.createResource(getResourcePath("/folder1/foo.uml"));

		assertThat(CDOFunctions.getFolderContents().apply(folder), both(AbstractPapyrusCDOTest.<CDOResourceNode> hasSize(2)).and(hasItems(text, res)));
		assertThat(CDOFunctions.getFolderContents(CDOResource.class).apply(folder), both(AbstractPapyrusCDOTest.<CDOResource> hasSize(1)).and(hasItem(res)));
	}

	@Test
	public void testFolderContentsFunction_rootResource() {
		CDOTransaction transaction = createTransaction();

		CDOResourceFolder folder = transaction.createResourceFolder(getResourcePath("/folder1"));
		CDOResourceNode root = transaction.getRootResource();

		assertThat(CDOFunctions.getFolderContents(CDOResourceFolder.class).apply(root), both(AbstractPapyrusCDOTest.<CDOResourceFolder> hasSize(1)).and(hasItem(folder.getFolder().getFolder())));
	}

	@Test
	public void testFolderContentsFunction_equals() {
		Function<CDOResourceNode, Iterable<CDOResourceNode>> func1 = CDOFunctions.getFolderContents();
		Function<CDOResourceNode, Iterable<CDOTextResource>> func2 = CDOFunctions.getFolderContents(CDOTextResource.class);
		Function<CDOResourceNode, Iterable<CDOTextResource>> func3 = CDOFunctions.getFolderContents(CDOTextResource.class);

		assertThat((Object)func1, not(equalTo((Object)func2)));
		assertThat((Object)func2, not(equalTo((Object)func1)));
		assertThat(func2 == func3, is(false));
		assertThat(func2, equalTo(func3));
		assertThat(func3, equalTo(func2));
	}

	@Test
	public void testFolderContentsFunction_hashCode() {
		Function<CDOResourceNode, Iterable<CDOResourceNode>> func1 = CDOFunctions.getFolderContents();
		Function<CDOResourceNode, Iterable<CDOTextResource>> func2 = CDOFunctions.getFolderContents(CDOTextResource.class);
		Function<CDOResourceNode, Iterable<CDOTextResource>> func3 = CDOFunctions.getFolderContents(CDOTextResource.class);

		assertThat(func1.hashCode() == func2.hashCode(), is(CDOResourceNode.class.hashCode() == CDOTextResource.class.hashCode()));
		assertThat(func2.hashCode(), is(func3.hashCode()));
	}

	@Test
	public void testFolderContentsFunction_toString() {
		Function<CDOResourceNode, Iterable<CDOResource>> func = CDOFunctions.getFolderContents(CDOResource.class);

		assertThat(func.toString(), containsString("getFolderContents("));
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
