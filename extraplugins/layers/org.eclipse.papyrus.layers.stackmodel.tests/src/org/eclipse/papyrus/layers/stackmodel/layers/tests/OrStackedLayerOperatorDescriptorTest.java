/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.OrStackedLayerOperatorDescriptor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Or Stacked Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrStackedLayerOperatorDescriptorTest extends StackedLayerOperatorDescriptorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OrStackedLayerOperatorDescriptorTest.class);
	}

	/**
	 * Constructs a new Or Stacked Layer Operator Descriptor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrStackedLayerOperatorDescriptorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Or Stacked Layer Operator Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OrStackedLayerOperatorDescriptor getFixture() {
		return (OrStackedLayerOperatorDescriptor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createOrStackedLayerOperatorDescriptor());
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

} //OrStackedLayerOperatorDescriptorTest
