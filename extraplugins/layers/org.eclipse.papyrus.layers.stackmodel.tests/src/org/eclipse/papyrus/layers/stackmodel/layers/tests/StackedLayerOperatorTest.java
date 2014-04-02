/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Stacked Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StackedLayerOperatorTest extends AbstractLayerOperatorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StackedLayerOperatorTest.class);
	}

	/**
	 * Constructs a new Stacked Layer Operator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackedLayerOperatorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Stacked Layer Operator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StackedLayerOperator getFixture() {
		return (StackedLayerOperator)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createStackedLayerOperator());
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

} //StackedLayerOperatorTest
