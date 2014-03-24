/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperatorDescriptor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Top Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TopLayerOperatorDescriptorTest extends LayerOperatorDescriptorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TopLayerOperatorDescriptorTest.class);
	}

	/**
	 * Constructs a new Top Layer Operator Descriptor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLayerOperatorDescriptorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Top Layer Operator Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TopLayerOperatorDescriptor getFixture() {
		return (TopLayerOperatorDescriptor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createTopLayerOperatorDescriptor());
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

} //TopLayerOperatorDescriptorTest
