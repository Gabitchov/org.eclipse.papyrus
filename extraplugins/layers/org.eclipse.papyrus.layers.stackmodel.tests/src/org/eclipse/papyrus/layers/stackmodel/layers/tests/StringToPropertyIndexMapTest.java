/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyIndex;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String To Property Index Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringToPropertyIndexMapTest extends TestCase {

	/**
	 * The fixture for this String To Property Index Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, PropertyIndex> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringToPropertyIndexMapTest.class);
	}

	/**
	 * Constructs a new String To Property Index Map test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringToPropertyIndexMapTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this String To Property Index Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<String, PropertyIndex> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this String To Property Index Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, PropertyIndex> getFixture() {
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
		setFixture((Map.Entry<String, PropertyIndex>)LayersFactory.eINSTANCE.create(LayersPackage.Literals.STRING_TO_PROPERTY_INDEX_MAP));
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

} //StringToPropertyIndexMapTest
