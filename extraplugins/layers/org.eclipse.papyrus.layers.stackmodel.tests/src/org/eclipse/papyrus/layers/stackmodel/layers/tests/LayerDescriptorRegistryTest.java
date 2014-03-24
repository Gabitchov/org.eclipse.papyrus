/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Layer Descriptor Registry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayerDescriptorRegistryTest extends TestCase {

	/**
	 * The fixture for this Layer Descriptor Registry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerDescriptorRegistry fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LayerDescriptorRegistryTest.class);
	}

	/**
	 * Constructs a new Layer Descriptor Registry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptorRegistryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Layer Descriptor Registry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LayerDescriptorRegistry fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Layer Descriptor Registry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerDescriptorRegistry getFixture() {
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
		setFixture(LayersFactory.eINSTANCE.createLayerDescriptorRegistry());
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

} //LayerDescriptorRegistryTest
