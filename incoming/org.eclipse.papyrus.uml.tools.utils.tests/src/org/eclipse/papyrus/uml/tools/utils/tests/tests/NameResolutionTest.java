/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.tools.utils.tests.tests;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.tests.Activator;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class NameResolutionTest {

	private static Model root;

	private static Model model2;

	private static Model model2_1;

	private static Model model2_2;

	private static Model model1;

	public static final String MODEL = "Model"; //$NON-NLS-1$

	public static final String MODEL1 = "Model1"; //$NON-NLS-1$

	public static final String MODEL2 = "Model2"; //$NON-NLS-1$

	public static final String MODEL2_1 = "Model2_1"; //$NON-NLS-1$

	public static final String MODEL2_2 = "Model2_2"; //$NON-NLS-1$

	public static final String CLASS1 = "Class1"; //$NON-NLS-1$

	public static final String CLASS1_QN = MODEL + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + CLASS1;

	public static final String CLASS2 = "Class2"; //$NON-NLS-1$

	public static final String CLASS2_QN = MODEL + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + MODEL1 + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + CLASS2;

	public static final String CLASS3 = "Class3"; //$NON-NLS-1$

	public static final String CLASS3_QN = MODEL + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + CLASS3;

	public static final String CLASS4 = "Class4"; //$NON-NLS-1$

	public static final String CLASS4_QN_DEPTH_1 = MODEL2_2 + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + CLASS4;

	public static final String CLASS4_QN_DEPTH_2 = MODEL2_1 + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + CLASS4_QN_DEPTH_1;

	public static final String CLASS4_QN_DEPTH_3 = MODEL2 + NamedElementUtil.QUALIFIED_NAME_SEPARATOR + CLASS4_QN_DEPTH_2;

	public static final String INTEGER = "Integer"; //$NON-NLS-1$

	@BeforeClass
	public static void init() {
		try {
			root = (Model)EMFHelper.loadEMFModel(new ResourceSetImpl(), URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/model/model0.uml", true)); //$NON-NLS-1$
		} catch (IOException e) {
			Activator.log.error(e);
		}
		model1 = (Model)root.getPackagedElement(MODEL1);
		model2 = (Model)root.getPackagedElement(MODEL2);
		model2_1 = (Model)model2.getPackagedElement(MODEL2_1);
		model2_2 = (Model)model2_1.getPackagedElement(MODEL2_2);
	}

	@Test
	public void findClass1() {
		final List<NamedElement> res1 = getResults(root, CLASS1, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size()); //the class Model::Model1::Class1 should not be found
		for(final NamedElement current : res1) {
			Assert.assertSame(root, current.eContainer());
		}
	}

	@Test
	public void findClass1FromSubPackage() {
		final List<NamedElement> res1 = getResults(model1, CLASS1, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size()); //we should not find the Class1 owned by Model
		Assert.assertSame(model1, res1.get(0).eContainer());
	}


	@Test
	public void findClass1WithQualifiedNameFromRoot() {
		final List<NamedElement> res1 = getResults(root, CLASS1_QN, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
		for(final NamedElement current : res1) {
			Assert.assertSame(root, current.eContainer());
		}
	}

	@Test
	public void findClass1WithQualifiedNameFromSubPackage() {
		final List<NamedElement> res1 = getResults(model1, CLASS1_QN, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(0, res1.size()); //FIXME : 0 and not 1?
	}

	@Test
	public void findIntegerFromRoot() {
		final List<NamedElement> res1 = getResults(root, INTEGER, UMLPackage.eINSTANCE.getType());
		Assert.assertEquals(1, res1.size());
	}

	@Test
	public void findIntegerFromSubPackage() {
		final List<NamedElement> res1 = getResults(model1, INTEGER, UMLPackage.eINSTANCE.getType());
		Assert.assertEquals(1, res1.size());
	}

	@Test
	public void findClass2FromRoot() {
		final List<NamedElement> res1 = getResults(root, CLASS2, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass2FromRootWithQualifiedName() {
		final List<NamedElement> res1 = getResults(root, CLASS2_QN, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass2FromSubPackage() {
		final List<NamedElement> res1 = getResults(model1, CLASS2, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass2FromSubPackageWithQualifiedName() {
		final List<NamedElement> res1 = getResults(model1, CLASS2_QN, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass3FromRoot() {
		final List<NamedElement> res1 = getResults(root, CLASS3, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass3FromRootWithQualifiedName() {
		final List<NamedElement> res1 = getResults(root, CLASS3_QN, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass3FromSubPackage() {
		final List<NamedElement> res1 = getResults(model1, CLASS3, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass3FromSubPackageWithQualifiedName() {
		final List<NamedElement> res1 = getResults(model1, CLASS3_QN, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromRoot_V1() {
		final List<NamedElement> res1 = getResults(root, CLASS4_QN_DEPTH_1, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromRoot_V2() {
		final List<NamedElement> res1 = getResults(root, CLASS4_QN_DEPTH_2, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromRoot_V3() {
		final List<NamedElement> res1 = getResults(root, CLASS4_QN_DEPTH_3, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(2, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromFirstLevel_V1() {
		final List<NamedElement> res1 = getResults(model2, CLASS4_QN_DEPTH_1, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromFirstLevel_V2() {
		final List<NamedElement> res1 = getResults(model2, CLASS4_QN_DEPTH_2, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromFirstLevel_V3() {
		final List<NamedElement> res1 = getResults(model2, CLASS4_QN_DEPTH_3, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());

	}

	@Test
	public void findClass4WithPartialQualifiedNameFromSecondLevel_V1() {
		final List<NamedElement> res1 = getResults(model2_1, CLASS4_QN_DEPTH_1, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());
	}

	@Test
	public void findClass4WithPartialQualifiedNameFromSecondLevel_V2() {
		final List<NamedElement> res1 = getResults(model2_1, CLASS4_QN_DEPTH_2, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());

	}

	@Test
	public void findClass4WithPartialQualifiedNameFromSecondLevel_V3() {
		final List<NamedElement> res1 = getResults(model2_1, CLASS4_QN_DEPTH_3, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());

	}

	@Test
	public void findClass4WithPartialQualifiedNameFromThirdLevel_V1() {
		final List<NamedElement> res1 = getResults(model2_2, CLASS4_QN_DEPTH_1, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());

	}

	@Test
	public void findClass4WithPartialQualifiedNameFromThirdLevel_V2() {
		final List<NamedElement> res1 = getResults(model2_2, CLASS4_QN_DEPTH_2, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());

	}

	@Test
	public void findClass4WithPartialQualifiedNameFromThirdLevel_V3() {
		final List<NamedElement> res1 = getResults(model2_2, CLASS4_QN_DEPTH_3, UMLPackage.eINSTANCE.getClass_());
		Assert.assertEquals(1, res1.size());
	}


	//FIXME bug with template signature, see with Patrick Tessier
	@Test
	public void findTemplateSignaturePropertyFromRoot() {
		final List<NamedElement> res1 = getResults(root, "toto", UMLPackage.eINSTANCE.getProperty());
		Assert.assertEquals(1, res1.size());

	}

	//FIXME bug with template signature, see with Patrick Tessier
	@Test
	public void findTemplateSignaturePropertyFromFirstLevel() {
		final List<NamedElement> res1 = getResults((Namespace)root.getPackagedElement("Package1"), "toto", UMLPackage.eINSTANCE.getProperty());
		Assert.assertEquals(1, res1.size());
	}

	/**
	 * Returns the list of the elements that we are looking for AND verify that the 2 classes {@link NameResolutionHelper} and
	 * {@link NameResolutionUtils} find the same result
	 * 
	 * @param namespace
	 *        the namespace where we look for the element
	 * @param name
	 *        the name (can be qualified, partially-qualified or not qualified) of the element
	 * @param wantedEClass
	 *        the wanted eclass
	 * @return
	 *         the found elements
	 */
	public List<NamedElement> getResults(final Namespace namespace, final String name, final EClass wantedEClass) {
		NameResolutionHelper helper = new NameResolutionHelper(namespace, wantedEClass);
		List<NamedElement> result1 = helper.getNamedElements(name);
		List<NamedElement> result2 = NameResolutionUtils.getNamedElements(name, namespace, wantedEClass);
		Assert.assertEquals("The 2 results are not equals", result1, result2); //$NON-NLS-1$
		return result1;
	}

	@AfterClass
	public static void endOfTests() {

	}
}
