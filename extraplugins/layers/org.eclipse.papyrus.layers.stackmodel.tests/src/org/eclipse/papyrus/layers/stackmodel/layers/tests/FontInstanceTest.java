/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.FontInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Font Instance</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FontInstanceTest extends TypeInstanceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FontInstanceTest.class);
	}

	/**
	 * Constructs a new Font Instance test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontInstanceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Font Instance test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FontInstance getFixture() {
		return (FontInstance)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createFontInstance());
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

} //FontInstanceTest
