/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayerApplicationFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Layer Application Factory</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayerApplicationFactoryTest extends TestCase {

	/**
	 * The fixture for this Layer Application Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerApplicationFactory fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LayerApplicationFactoryTest.class);
	}

	/**
	 * Constructs a new Layer Application Factory test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerApplicationFactoryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Layer Application Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LayerApplicationFactory fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Layer Application Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerApplicationFactory getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createLayerApplicationFactory());
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

} //LayerApplicationFactoryTest
