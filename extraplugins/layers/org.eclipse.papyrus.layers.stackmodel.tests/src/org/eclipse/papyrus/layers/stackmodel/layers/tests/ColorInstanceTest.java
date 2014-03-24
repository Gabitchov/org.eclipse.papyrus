/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.ColorInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Color Instance</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ColorInstanceTest extends TypeInstanceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ColorInstanceTest.class);
	}

	/**
	 * Constructs a new Color Instance test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorInstanceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Color Instance test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ColorInstance getFixture() {
		return (ColorInstance)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createColorInstance());
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

} //ColorInstanceTest
