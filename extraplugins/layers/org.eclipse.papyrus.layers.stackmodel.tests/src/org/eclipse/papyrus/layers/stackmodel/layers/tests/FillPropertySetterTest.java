/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.FillPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fill Property Setter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FillPropertySetterTest extends PropertySetterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FillPropertySetterTest.class);
	}

	/**
	 * Constructs a new Fill Property Setter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillPropertySetterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Fill Property Setter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FillPropertySetter getFixture() {
		return (FillPropertySetter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createFillPropertySetter());
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

} //FillPropertySetterTest
