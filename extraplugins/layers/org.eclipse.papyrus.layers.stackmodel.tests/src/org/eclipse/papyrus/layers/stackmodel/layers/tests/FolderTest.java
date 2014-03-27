/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.layers.stackmodel.layers.Folder;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FolderTest extends FolderElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FolderTest.class);
	}

	/**
	 * Constructs a new Folder test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FolderTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Folder test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Folder getFixture() {
		return (Folder)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayersFactory.eINSTANCE.createFolder());
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

} //FolderTest
