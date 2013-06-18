/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.tests.tests;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test tests the class UMLRestrictedContentProvider, and its result according to its boolean value isRestricted and the contents of the table
 * <ul>
 * <li>the returned values according to isRestricted</li>
 * <li>the returned values according to the stereotype applied on the elements referenced by the table</li>
 * </ul>
 * 
 * The tested model :
 * <ul>
 * <li>Model
 * <ul>
 * <li>Class1</li>
 * <li>Model1 (with the profile SysML::Blocks applied)</li>
 * <ul>
 * <li><< Block >> Block1</li>
 * <li>emptyTable2</li>
 * <li>notEmptyTable2 (contains Block1)</li>
 * </ul>
 * <li>emptyTable1</li>
 * <li>notEmptyTable1 (contains Class1)</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * @author vl222926
 * 
 */
public class UMLRestrictedContentProviderTest {

	/** the root of the model */
	private Model modelRoot;

	/** the sub model on which we apply the profile Blocks */
	private Model subModel;

	/** the first empty table, owned by modelRoot */
	private Table emptyTable1;

	/** the second empty table, owned by submodel */
	private Table emptyTable2;

	/** the first not empty table, which contains a Class without stereotype. this table is owned by modelRoot */
	private Table notEmptyTable1;

	/** the second not empty table which contains a Class stereotyped block. This table is owned by subModel */
	private Table notEmptyTable2;

	/** the resource set used to load the model */
	private ResourceSet resourceSet;


	@Before
	public void init() {
		try {
			resourceSet = new ResourceSetImpl();
			EMFHelper.loadEMFModel(resourceSet, URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model.di", true)); //$NON-NLS-1$
			Resource umlModel = resourceSet.getResource(URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model.uml", true), true); //$NON-NLS-1$

			//we inits the field of this class
			modelRoot = (Model)umlModel.getContents().get(0);
			subModel = (Model)modelRoot.getMember("Model1"); //$NON-NLS-1$
			Resource notation = resourceSet.getResource(URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/model.notation", true), true); //$NON-NLS-1$
			for(final EObject current : notation.getContents()) {
				if(current instanceof Table) {
					if(((Table)current).getContext() == modelRoot) {
						if(((Table)current).getName().equals("emptyTable1")) { //$NON-NLS-1$
							emptyTable1 = (Table)current;
						} else if(((Table)current).getName().equals("notEmptyTable1")) { //$NON-NLS-1$
							notEmptyTable1 = (Table)current;
						}
					} else if(((Table)current).getContext() == subModel) {
						if(((Table)current).getName().equals("emptyTable2")) { //$NON-NLS-1$
							emptyTable2 = (Table)current;
						} else if(((Table)current).getName().equals("notEmptyTable2")) { //$NON-NLS-1$
							notEmptyTable2 = (Table)current;
						}
					}
				}
			}

		} catch (IOException ex) {
			Activator.log.error(ex);
		}
		Assert.assertNotNull(modelRoot);
		Assert.assertNotNull(subModel);
		Assert.assertNotNull(emptyTable1);
		Assert.assertNotNull(emptyTable2);
		Assert.assertNotNull(notEmptyTable1);
		Assert.assertNotNull(notEmptyTable2);
	}

	/**
	 * tests the children for an empty table, with restriction -> the content provider must return an empty array
	 */
	@Test
	public void testEmptyTableWithRestriction() {
		NattableModelManager modelManager = new NattableModelManager(emptyTable1);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(true);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(0, elements.length);
	}

	/**
	 * tests the children for an empty table, without restriction -> the content provider must return an array referencing UMLPackage and
	 * SysML::Blocks
	 */
	@Test
	public void testEmptyTableWithoutRestriction() {
		NattableModelManager modelManager = new NattableModelManager(emptyTable1);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(false);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);

		Profile sysmlBlockProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current instanceof org.eclipse.uml2.uml.Package) {
				sysmlBlockProfile = (Profile)current;
			}
		}

		//we test the roots
		Assert.assertNotNull(umlPackage);
		Assert.assertEquals("Blocks", sysmlBlockProfile.getName()); //$NON-NLS-1$
		elements = columnContentProvider.getChildren(sysmlBlockProfile);
		Assert.assertEquals(6, elements.length);//we display all the children of the sysmlProfile block
	}

	/**
	 * Test the contents provider on notEmptytable1 which contains only Class1 -> the SysML profile must not be visible
	 * The content provider must return an array referencing only UMLPackage
	 */
	@Test
	public void testNotEmptyTableWithRestriction() {
		NattableModelManager modelManager = new NattableModelManager(notEmptyTable1);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(true);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(1, elements.length);
		Assert.assertEquals(elements[0], UMLPackage.eINSTANCE);
	}

	/**
	 * the contents provider must returns an array referencing UMLPackage ans SysML::Blocks
	 */
	@Test
	public void testNotEmptyTableWithoutProfileWithoutRestriction() {
		NattableModelManager modelManager = new NattableModelManager(notEmptyTable1);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(false);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);

		Profile sysmlBlockProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current instanceof org.eclipse.uml2.uml.Package) {
				sysmlBlockProfile = (Profile)current;
			}
		}

		//we test the roots
		Assert.assertNotNull(umlPackage);
		Assert.assertEquals("Blocks", sysmlBlockProfile.getName()); //$NON-NLS-1$
		elements = columnContentProvider.getChildren(sysmlBlockProfile);
		Assert.assertEquals(6, elements.length);//we display all the children of the sysmlProfile block
	}

	/**
	 * the content provider must returns an array with UMLPackage and SysML::Blocks.
	 * SysMLBlocks must have only 1 child : SysML::Blocks::Block
	 */
	@Test
	public void testNotEmptyTableWithProfileWithRestriction() {
		NattableModelManager modelManager = new NattableModelManager(notEmptyTable2);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(true);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);

		Profile sysmlBlockProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current instanceof org.eclipse.uml2.uml.Package) {
				sysmlBlockProfile = (Profile)current;
			}
		}

		//we test the roots
		//the contents provider returns them, but they won't be displayed in the treeviewer because they don't have accepted children
		Assert.assertNotNull(umlPackage);
		Assert.assertEquals("Blocks", sysmlBlockProfile.getName()); //$NON-NLS-1$

		Assert.assertEquals(1, columnContentProvider.getChildren(sysmlBlockProfile).length);
		Assert.assertTrue(columnContentProvider.getChildren(umlPackage).length > 0);
	}
	
	
	
	
	
	
	
}
