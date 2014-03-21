/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayerDescriptor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Reg Exp Layer Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegExpLayerDescriptorTest extends LayerDescriptorTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RegExpLayerDescriptorTest.class);
	}

	/**
	 * Constructs a new Reg Exp Layer Descriptor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegExpLayerDescriptorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Reg Exp Layer Descriptor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RegExpLayerDescriptor getFixture() {
		return (RegExpLayerDescriptor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createRegExpLayerDescriptor());
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

} //RegExpLayerDescriptorTest
