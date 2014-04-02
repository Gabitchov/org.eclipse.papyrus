/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperatorDescriptor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Stacked Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StackedLayerOperatorDescriptorTest extends LayerOperatorDescriptorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StackedLayerOperatorDescriptorTest.class);
	}

	/**
	 * Constructs a new Stacked Layer Operator Descriptor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackedLayerOperatorDescriptorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stacked Layer Operator Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StackedLayerOperatorDescriptor getFixture() {
		return (StackedLayerOperatorDescriptor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createStackedLayerOperatorDescriptor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //StackedLayerOperatorDescriptorTest
