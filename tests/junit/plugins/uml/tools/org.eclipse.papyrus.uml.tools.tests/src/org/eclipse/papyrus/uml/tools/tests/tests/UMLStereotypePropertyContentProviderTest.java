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
package org.eclipse.papyrus.uml.tools.tests.tests;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.providers.UMLStereotypePropertyContentProvider;
import org.eclipse.papyrus.uml.tools.tests.Activator;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the class UMLStereotypePropertyContentProvider.
 * <ul>
 * <li>tests the returned children according to the boolean baseProperty</li>
 * <li>verifies that the returned children don't contains the inherited properties</li>
 * </ul>
 * 
 * @author vl222926
 * 
 */
public class UMLStereotypePropertyContentProviderTest {

	/** the root profile of the tested model */
	private Profile rootProfile;

	/** the two subprofile */
	private Profile subProfile1;

	private Profile subProfile2;

	/** the stereotypes owned by these subprofiles */
	private Stereotype ste1;

	private Stereotype ste2;

	/** the properties owned by these stereotypes */
	private Property prop1;

	private Property prop2;

	/** the base properties of these stereotypes */
	private Property basePropSte1;

	private Property basePropSte2;

	/**
	 * Inits the fields of this class
	 */
	@Before
	public void init() {
		try {
			EObject testModel = EMFHelper.loadEMFModel(new ResourceSetImpl(), URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/uml/profileTest.profile.uml", true)); //$NON-NLS-1$
			Assert.assertTrue(testModel instanceof Profile);
			rootProfile = (Profile)testModel;
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
		assertNotNull("Cannot load the EMF Tests model", rootProfile); //$NON-NLS-1$

		subProfile1 = (Profile)rootProfile.getPackagedElement("Profile1"); //$NON-NLS-1$
		subProfile2 = (Profile)rootProfile.getPackagedElement("Profile2"); //$NON-NLS-1$

		Assert.assertNotNull(subProfile1);
		Assert.assertNotNull(subProfile2);

		ste1 = (Stereotype)subProfile1.getMember("Stereotype1"); //$NON-NLS-1$
		ste2 = (Stereotype)subProfile2.getMember("Stereotype2"); //$NON-NLS-1$

		Assert.assertNotNull(ste1);
		Assert.assertNotNull(ste2);

		prop1 = (Property)ste1.getMember("prop1"); //$NON-NLS-1$
		prop2 = (Property)ste2.getMember("prop2"); //$NON-NLS-1$

		Assert.assertNotNull(prop1);
		Assert.assertNotNull(prop2);

		basePropSte1 = (Property)ste1.getMember("base_Activity"); //$NON-NLS-1$
		basePropSte2 = (Property)ste2.getMember("base_Class"); //$NON-NLS-1$

		Assert.assertNotNull(basePropSte1);
		Assert.assertNotNull(basePropSte2);

	}

	/**
	 * We test the children of the rootProfile.
	 * In this test,
	 * <ul>
	 * <li>we don't want the properties base_ExtendedClass</li>
	 * <li>we don't want the inheritedProperties</li>
	 * </ul>
	 */
	@Test
	public void testProfileContentWithoutBaseClassPropertyWithoutInheritedProperties() {
		UMLStereotypePropertyContentProvider provider = new UMLStereotypePropertyContentProvider();
		provider.setIgnoreBaseProperty(true);
		provider.setIgnoreInheritedElements(true);
		provider.setProfiles(Collections.singletonList(rootProfile));
		//we test the root
		Object[] elements = provider.getElements();
		Assert.assertEquals(1, elements.length);
		Assert.assertEquals(elements[0], rootProfile);

		//we test the first level of children
		Assert.assertEquals(true, provider.hasChildren(rootProfile));
		List<?> children = Arrays.asList(provider.getChildren(rootProfile));

		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(subProfile1));
		Assert.assertTrue(children.contains(subProfile2));


		//we test the children of the first subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile1));
		children = Arrays.asList(provider.getChildren(subProfile1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste1));

		//we test the children of the ste1
		Assert.assertEquals(true, provider.hasChildren(ste1));
		children = Arrays.asList(provider.getChildren(ste1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop1));

		//we test the children of the prop1
		Assert.assertEquals(false, provider.hasChildren(prop1));


		//we test the children of the 2nd subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile2));
		children = Arrays.asList(provider.getChildren(subProfile2));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste2));

		//we test the children of the ste2
		Assert.assertEquals(true, provider.hasChildren(ste2));
		children = Arrays.asList(provider.getChildren(ste2));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop2));

		//we test the children of the prop2
		Assert.assertEquals(false, provider.hasChildren(prop2));
	}

	/**
	 * We test the children of the rootProfile.
	 * In this test,
	 * <ul>
	 * <li>we want the properties base_ExtendedClass</li>
	 * <li>we don't want the inheritedProperties</li>
	 * </ul>
	 */
	@Test
	public void testProfileContentWithBaseClassPropertyWithoutInheritedProperties() {
		UMLStereotypePropertyContentProvider provider = new UMLStereotypePropertyContentProvider();
		provider.setIgnoreBaseProperty(false);
		provider.setIgnoreInheritedElements(true);
		provider.setProfiles(Collections.singletonList(rootProfile));
		//we test the root
		Object[] elements = provider.getElements();
		Assert.assertEquals(1, elements.length);
		Assert.assertEquals(elements[0], rootProfile);

		//we test the first level of children
		Assert.assertEquals(true, provider.hasChildren(rootProfile));
		List<?> children = Arrays.asList(provider.getChildren(rootProfile));

		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(subProfile1));
		Assert.assertTrue(children.contains(subProfile2));


		//we test the children of the first subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile1));
		children = Arrays.asList(provider.getChildren(subProfile1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste1));

		//we test the children of the ste1
		Assert.assertEquals(true, provider.hasChildren(ste1));
		children = Arrays.asList(provider.getChildren(ste1));
		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(prop1));
		Assert.assertTrue(children.contains(basePropSte1));

		//we test the children of the prop1
		Assert.assertEquals(false, provider.hasChildren(prop1));


		//we test the children of the 2nd subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile2));
		children = Arrays.asList(provider.getChildren(subProfile2));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste2));

		//we test the children of the ste2
		Assert.assertEquals(true, provider.hasChildren(ste2));
		children = Arrays.asList(provider.getChildren(ste2));
		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(prop2));
		Assert.assertTrue(children.contains(basePropSte2));

		//we test the children of the prop2
		Assert.assertEquals(false, provider.hasChildren(prop2));
	}


	/**
	 * We test the children of the rootProfile.
	 * In this test,
	 * <ul>
	 * <li>we don't want the properties base_ExtendedClass</li>
	 * <li>we want the inheritedProperties</li>
	 * </ul>
	 */
	@Test
	public void testProfileContentWithoutBaseClassPropertyWithInheritedProperties() {
		UMLStereotypePropertyContentProvider provider = new UMLStereotypePropertyContentProvider();
		provider.setIgnoreBaseProperty(true);
		provider.setIgnoreInheritedElements(false);
		provider.setProfiles(Collections.singletonList(rootProfile));
		//we test the root
		Object[] elements = provider.getElements();
		Assert.assertEquals(1, elements.length);
		Assert.assertEquals(elements[0], rootProfile);

		//we test the first level of children
		Assert.assertEquals(true, provider.hasChildren(rootProfile));
		List<?> children = Arrays.asList(provider.getChildren(rootProfile));

		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(subProfile1));
		Assert.assertTrue(children.contains(subProfile2));


		//we test the children of the first subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile1));
		children = Arrays.asList(provider.getChildren(subProfile1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste1));

		//we test the children of the ste1
		Assert.assertEquals(true, provider.hasChildren(ste1));
		children = Arrays.asList(provider.getChildren(ste1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop1));

		//we test the children of the prop1
		Assert.assertEquals(false, provider.hasChildren(prop1));


		//we test the children of the 2nd subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile2));
		children = Arrays.asList(provider.getChildren(subProfile2));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste2));

		//we test the children of the ste2
		Assert.assertEquals(true, provider.hasChildren(ste2));
		children = Arrays.asList(provider.getChildren(ste2));
		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(prop2));
		Assert.assertTrue(children.contains(prop1));

		//we test the children of the prop2
		Assert.assertEquals(false, provider.hasChildren(prop2));
	}

	/**
	 * We test the children of the rootProfile.
	 * In this test,
	 * <ul>
	 * <li>we want the properties base_ExtendedClass</li>
	 * <li>we want the inheritedProperties</li>
	 * </ul>
	 */
	@Test
	public void testProfileContentWithBaseClassPropertyWithInheritedProperties() {
		UMLStereotypePropertyContentProvider provider = new UMLStereotypePropertyContentProvider();
		provider.setIgnoreBaseProperty(false);
		provider.setIgnoreInheritedElements(false);
		provider.setProfiles(Collections.singletonList(rootProfile));
		//we test the root
		Object[] elements = provider.getElements();
		Assert.assertEquals(1, elements.length);
		Assert.assertEquals(elements[0], rootProfile);

		//we test the first level of children
		Assert.assertEquals(true, provider.hasChildren(rootProfile));
		List<?> children = Arrays.asList(provider.getChildren(rootProfile));

		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(subProfile1));
		Assert.assertTrue(children.contains(subProfile2));


		//we test the children of the first subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile1));
		children = Arrays.asList(provider.getChildren(subProfile1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste1));

		//we test the children of the ste1
		Assert.assertEquals(true, provider.hasChildren(ste1));
		children = Arrays.asList(provider.getChildren(ste1));
		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(prop1));
		Assert.assertTrue(children.contains(basePropSte1));

		//we test the children of the prop1
		Assert.assertEquals(false, provider.hasChildren(prop1));


		//we test the children of the 2nd subprofile
		Assert.assertEquals(true, provider.hasChildren(subProfile2));
		children = Arrays.asList(provider.getChildren(subProfile2));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(ste2));

		//we test the children of the ste2
		Assert.assertEquals(true, provider.hasChildren(ste2));
		children = Arrays.asList(provider.getChildren(ste2));
		Assert.assertEquals(4, children.size());
		Assert.assertTrue(children.contains(prop2));
		Assert.assertTrue(children.contains(basePropSte2));
		Assert.assertTrue(children.contains(basePropSte1));
		Assert.assertTrue(children.contains(prop1));

		//we test the children of the prop2
		Assert.assertEquals(false, provider.hasChildren(prop2));
	}


	/**
	 * 
	 */
	@After
	public void enfOfTests() {
		rootProfile = null;
		subProfile1 = null;
		ste1 = null;
		prop1 = null;
		basePropSte1 = null;
		subProfile2 = null;
		ste2 = null;
		prop2 = null;
		basePropSte2 = null;

	}

}
