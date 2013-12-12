/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String To Type Instance Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringToTypeInstanceMapTest extends TestCase {

	/**
	 * The fixture for this String To Type Instance Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, TypeInstance> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringToTypeInstanceMapTest.class);
	}

	/**
	 * Constructs a new String To Type Instance Map test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringToTypeInstanceMapTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this String To Type Instance Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<String, TypeInstance> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this String To Type Instance Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, TypeInstance> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<String, TypeInstance>)LayersFactory.eINSTANCE.create(LayersPackage.Literals.STRING_TO_TYPE_INSTANCE_MAP));
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

} //StringToTypeInstanceMapTest
