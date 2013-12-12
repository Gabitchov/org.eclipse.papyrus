/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>layers</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new LayersTests("layers Tests");
		suite.addTestSuite(LayersStackTest.class);
		suite.addTestSuite(LayersStackApplicationTest.class);
		suite.addTestSuite(PropertyRegistryTest.class);
		suite.addTestSuite(PropertyTest.class);
		suite.addTestSuite(MetamodelTest.class);
		suite.addTestSuite(PropertySetterRegistryTest.class);
		suite.addTestSuite(LayerOperatorDescriptorRegistryTest.class);
		suite.addTestSuite(LayerOperatorDescriptorTest.class);
		suite.addTestSuite(PropertyOperatorTest.class);
		suite.addTestSuite(DefaultPropertyOperatorTest.class);
		suite.addTestSuite(IntInstanceTest.class);
		suite.addTestSuite(BooleanInstanceTest.class);
		suite.addTestSuite(StringInstanceTest.class);
		suite.addTestSuite(IntTypeTest.class);
		suite.addTestSuite(BooleanTypeTest.class);
		suite.addTestSuite(StringTypeTest.class);
		suite.addTestSuite(CustomTypeTest.class);
		suite.addTestSuite(TopLayerOperatorTest.class);
		suite.addTestSuite(StackedLayerOperatorTest.class);
		suite.addTestSuite(CustomLayerOperatorTest.class);
		suite.addTestSuite(NullInstanceTest.class);
		suite.addTestSuite(RegExpLayerTest.class);
		suite.addTestSuite(LayerTest.class);
		suite.addTestSuite(ColorTest.class);
		suite.addTestSuite(ColorInstanceTest.class);
		suite.addTestSuite(FillInstanceTest.class);
		suite.addTestSuite(FillTest.class);
		suite.addTestSuite(FillPropertySetterTest.class);
		suite.addTestSuite(IsValidPropertySetterTest.class);
		suite.addTestSuite(NullPropertySetterTest.class);
		suite.addTestSuite(LineTypeTest.class);
		suite.addTestSuite(LineInstanceTest.class);
		suite.addTestSuite(LinePropertySetterTest.class);
		suite.addTestSuite(FontPropertySetterTest.class);
		suite.addTestSuite(FontInstanceTest.class);
		suite.addTestSuite(FontTypeTest.class);
		suite.addTestSuite(IsVisiblePropertySetterTest.class);
		suite.addTestSuite(TopLayerOperatorDescriptorTest.class);
		suite.addTestSuite(StackedLayerOperatorDescriptorTest.class);
		suite.addTestSuite(CustomPropertyOperatorTest.class);
		suite.addTestSuite(AndStackedLayerOperatorDescriptorTest.class);
		suite.addTestSuite(OrStackedLayerOperatorDescriptorTest.class);
		suite.addTestSuite(IsAbstractUmlSetterTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersTests(String name) {
		super(name);
	}

} //LayersTests
