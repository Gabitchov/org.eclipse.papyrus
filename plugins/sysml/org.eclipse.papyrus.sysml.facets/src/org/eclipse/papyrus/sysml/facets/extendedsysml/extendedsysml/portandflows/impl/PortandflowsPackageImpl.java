/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection;
import org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.PortandflowsFactory;
import org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.PortandflowsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class PortandflowsPackageImpl extends EPackageImpl implements PortandflowsPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum naFlowPortDirectionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.PortandflowsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PortandflowsPackageImpl() {
		super(eNS_URI, PortandflowsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link PortandflowsPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PortandflowsPackage init() {
		if(isInited)
			return (PortandflowsPackage)EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI);

		// Obtain or create and register package
		PortandflowsPackageImpl thePortandflowsPackage = (PortandflowsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PortandflowsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PortandflowsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePortandflowsPackage.createPackageContents();

		// Initialize created meta-data
		thePortandflowsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePortandflowsPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PortandflowsPackage.eNS_URI, thePortandflowsPackage);
		return thePortandflowsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getNAFlowPortDirection() {
		return naFlowPortDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PortandflowsFactory getPortandflowsFactory() {
		return (PortandflowsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create enums
		naFlowPortDirectionEEnum = createEEnum(NA_FLOW_PORT_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize enums and add enum literals
		initEEnum(naFlowPortDirectionEEnum, NAFlowPortDirection.class, "NAFlowPortDirection");
		addEEnumLiteral(naFlowPortDirectionEEnum, NAFlowPortDirection.NA);

		// Create resource
		createResource(eNS_URI);
	}

} //PortandflowsPackageImpl
