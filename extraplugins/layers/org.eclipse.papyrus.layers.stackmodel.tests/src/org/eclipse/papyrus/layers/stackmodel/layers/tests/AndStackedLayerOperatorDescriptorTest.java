/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.AndStackedLayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>And Stacked Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AndStackedLayerOperatorDescriptorTest extends StackedLayerOperatorDescriptorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AndStackedLayerOperatorDescriptorTest.class);
	}

	/**
	 * Constructs a new And Stacked Layer Operator Descriptor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndStackedLayerOperatorDescriptorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this And Stacked Layer Operator Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AndStackedLayerOperatorDescriptor getFixture() {
		return (AndStackedLayerOperatorDescriptor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createAndStackedLayerOperatorDescriptor());
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

} //AndStackedLayerOperatorDescriptorTest
