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

import org.eclipse.core.runtime.SubProgressMonitor;
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
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UMLRestrictedContentProviderTestCustomProfile {

	/** the root of the model */
	private Model modelRoot;

	/** the sub model on which we apply the profile Blocks */
	private Class stereotypedClass;

	/** the tested table */
	private Table table;

	/**
	 * the base properties
	 */
	private Property basePropSte1;

	private Property basePropSte2;

	/**
	 * the packages and the profiles
	 */
	private Profile rootProfile;

	private Profile profile1;

	private Profile subProfile1;

	private Profile subProfile2;

	private Package package1;

	private Property prop1;

	private Property prop2;

	/**
	 * the stereotypes
	 */
	private Stereotype stereotype1;

	private Stereotype stereotype2;

	/** the resource set used to load the model */
	private ResourceSet resourceSet;

	private String resourcePath = "/resources/withCustomProfile/modelTest";

	@Before
	public void init() {
		try {
			resourceSet = new ResourceSetImpl();
			EMFHelper.loadEMFModel(resourceSet, URI.createPlatformPluginURI(Activator.PLUGIN_ID + resourcePath + ".di", true)); //$NON-NLS-1$
			Resource umlModel = resourceSet.getResource(URI.createPlatformPluginURI(Activator.PLUGIN_ID + resourcePath + ".uml", true), true); //$NON-NLS-1$

			//we inits the field of this class
			modelRoot = (Model)umlModel.getContents().get(0);
			stereotypedClass = (Class)modelRoot.getMember("Class1"); //$NON-NLS-1$
			Resource notation = resourceSet.getResource(URI.createPlatformPluginURI(Activator.PLUGIN_ID + resourcePath + ".notation", true), true); //$NON-NLS-1$
			for(final EObject current : notation.getContents()) {
				if(current instanceof Table) {
					if(((Table)current).getContext() == modelRoot) {
						if(((Table)current).getName().equals("GenericTable0")) { //$NON-NLS-1$
							table = (Table)current;
						}
					}
				}
			}

		} catch (IOException ex) {
			Activator.log.error(ex);
		}
		Assert.assertNotNull(modelRoot);
		Assert.assertNotNull(stereotypedClass);
		Assert.assertNotNull(table);


		stereotype1 = stereotypedClass.getAppliedStereotypes().get(0);
		Assert.assertEquals("Stereotype1", stereotype1.getName());
		stereotype2 = (Stereotype)stereotype1.getGeneral("Stereotype2");
		basePropSte2 = (Property)stereotype2.getMember("base_Class");

		prop1 = (Property)stereotype1.getMember("prop1");
		prop2 = (Property)stereotype2.getMember("prop2");

		subProfile1 = stereotype1.containingProfile();
		package1 = (Package)subProfile1.eContainer();
		subProfile2 = stereotype2.containingProfile();
		profile1 = (Profile)subProfile2.eContainer();
		rootProfile = (Profile)profile1.eContainer();



		//		Assert.assertNotNull(basePropSte1);
		Assert.assertNotNull(basePropSte2);
		Assert.assertNotNull(rootProfile);
		Assert.assertNotNull(subProfile1);
		Assert.assertNotNull(subProfile2);
		Assert.assertNotNull(package1);
		Assert.assertNotNull(stereotype1);
		Assert.assertNotNull(stereotype2);

		Assert.assertNotNull(prop1);
		Assert.assertNotNull(prop2);
		Assert.assertNotNull(profile1);

	}

	@Test
	public void testWithRestriction() {
		NattableModelManager modelManager = new NattableModelManager(table);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(true);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);
		Profile rootProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current == this.rootProfile) {
				rootProfile = (Profile)current;
			}
		}

		Assert.assertNotNull(umlPackage);
		Assert.assertNotNull(rootProfile);

		//test the children for umlPackage
		List<?> children = Arrays.asList(columnContentProvider.getChildren(umlPackage));
		Assert.assertEquals(13, children.size());//1 of them is not displayed in the dialog, because it doesn't have valid feature 
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getBehavioredClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getClass_()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getEncapsulatedClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getNamedElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getNamespace()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getPackageableElement()));//not displayed
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getParameterableElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getRedefinableElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getStructuredClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getTemplateableElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getType()));

		//test that we don't have the inherited properties
		children = Arrays.asList(columnContentProvider.getChildren(UMLPackage.eINSTANCE.getClassifier()));
		Assert.assertFalse(children.contains(UMLPackage.eINSTANCE.getNamedElement_Name()));

		//test the children for the rootProfile
		children = Arrays.asList(columnContentProvider.getChildren(rootProfile));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(package1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(subProfile1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(stereotype1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop1));

	}


	@Test
	public void testWithoutRestriction() {
		NattableModelManager modelManager = new NattableModelManager(table);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(false);
		columnContentProvider.setIgnoreInheritedElements(true);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);
		Profile rootProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current == this.rootProfile) {
				rootProfile = (Profile)current;
			}
		}

		Assert.assertNotNull(umlPackage);
		Assert.assertNotNull(rootProfile);

		//test the children for umlPackage
		List<?> children = Arrays.asList(columnContentProvider.getChildren(umlPackage));
		Assert.assertTrue(children.size() >= 242);//approximatly 242 metaclasses in UML

		//test that we don't have the inherited properties
		children = Arrays.asList(columnContentProvider.getChildren(UMLPackage.eINSTANCE.getClassifier()));
		Assert.assertFalse(children.contains(UMLPackage.eINSTANCE.getNamedElement_Name()));


		//test the children for the rootProfile
		children = Arrays.asList(columnContentProvider.getChildren(rootProfile));
		Assert.assertEquals(2, children.size());
		Profile profile1 = null;
		Package package1 = null;
		for(final Object current : children) {
			if(current instanceof Profile && ((Profile)current).getName().equals("Profile1")) {
				profile1 = (Profile)current;
			} else if(current instanceof Package && ((Package)current).getName().equals("Package1")) {
				package1 = (Package)current;
			}
		}

		Assert.assertNotNull(package1);
		Assert.assertNotNull(profile1);

		//test the children of package1
		children = Arrays.asList(columnContentProvider.getChildren(package1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(subProfile1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(stereotype1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop1));



		//test the children for profile1
		children = Arrays.asList(columnContentProvider.getChildren(profile1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(subProfile2));



		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(stereotype2));



		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop2));

	}

	@Test
	public void testWithRestrictionWithInheritedProperties() {
		NattableModelManager modelManager = new NattableModelManager(table);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(true);
		columnContentProvider.setIgnoreInheritedElements(false);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);
		Profile rootProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current == this.rootProfile) {
				rootProfile = (Profile)current;
			}
		}

		Assert.assertNotNull(umlPackage);
		Assert.assertNotNull(rootProfile);

		//test the children for umlPackage
		List<?> children = Arrays.asList(columnContentProvider.getChildren(umlPackage));
		Assert.assertEquals(13, children.size());//1 of them is not displayed in the dialog, because it doesn't have valid feature 
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getBehavioredClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getClass_()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getEncapsulatedClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getNamedElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getNamespace()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getPackageableElement()));//not displayed
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getParameterableElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getRedefinableElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getStructuredClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getTemplateableElement()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getType()));

		//test that we have the inherited properties
		children = Arrays.asList(columnContentProvider.getChildren(UMLPackage.eINSTANCE.getClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getNamedElement_Name()));


		//test the children for the rootProfile
		children = Arrays.asList(columnContentProvider.getChildren(rootProfile));
		Assert.assertEquals(1, children.size());

		Assert.assertTrue(children.contains(package1));


		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(subProfile1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(stereotype1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(2, children.size());

		Assert.assertTrue(children.contains(prop1));
		Assert.assertTrue(children.contains(prop2));

	}


	@Test
	public void testWithoutRestrictionWithInheritedProperties() {
		NattableModelManager modelManager = new NattableModelManager(table);
		IRestrictedContentProvider columnContentProvider = modelManager.getColumnAxisManager().createPossibleAxisContentProvider(false);
		columnContentProvider.setIgnoreInheritedElements(false);
		Object[] elements = columnContentProvider.getElements();
		Assert.assertEquals(2, elements.length);
		List<?> roots = Arrays.asList(elements);
		Profile rootProfile = null;
		EPackage umlPackage = null;

		for(final Object current : roots) {
			if(current == UMLPackage.eINSTANCE) {
				umlPackage = (EPackage)current;
			} else if(current == this.rootProfile) {
				rootProfile = (Profile)current;
			}
		}

		Assert.assertNotNull(umlPackage);
		Assert.assertNotNull(rootProfile);

		//test the children for umlPackage
		List<?> children = Arrays.asList(columnContentProvider.getChildren(umlPackage));
		Assert.assertTrue(children.size() >= 242);//approximatly 242 metaclasses in UML 

		//test that we have the inherited properties
		children = Arrays.asList(columnContentProvider.getChildren(UMLPackage.eINSTANCE.getClassifier()));
		Assert.assertTrue(children.contains(UMLPackage.eINSTANCE.getNamedElement_Name()));

		//test the children for the rootProfile
		children = Arrays.asList(columnContentProvider.getChildren(rootProfile));
		Assert.assertEquals(2, children.size());
		Profile profile1 = null;
		Package package1 = null;
		for(final Object current : children) {
			if(current instanceof Profile && ((Profile)current).getName().equals("Profile1")) {
				profile1 = (Profile)current;
			} else if(current instanceof Package && ((Package)current).getName().equals("Package1")) {
				package1 = (Package)current;
			}
		}

		Assert.assertNotNull(package1);
		Assert.assertNotNull(profile1);

		//test the children of package1
		children = Arrays.asList(columnContentProvider.getChildren(package1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(subProfile1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(stereotype1));

		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(2, children.size());
		Assert.assertTrue(children.contains(prop1));
		Assert.assertTrue(children.contains(prop2));


		//test the children for profile1
		children = Arrays.asList(columnContentProvider.getChildren(profile1));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(subProfile2));


		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(stereotype2));


		children = Arrays.asList(columnContentProvider.getChildren(children.get(0)));
		Assert.assertEquals(1, children.size());
		Assert.assertTrue(children.contains(prop2));

	}
}
