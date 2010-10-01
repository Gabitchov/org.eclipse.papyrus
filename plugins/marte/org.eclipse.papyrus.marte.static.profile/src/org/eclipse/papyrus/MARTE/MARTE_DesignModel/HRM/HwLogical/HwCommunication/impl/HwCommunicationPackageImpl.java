/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.MARTE.MARTEPackage;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.impl.GQAMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.PAMPackage;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.PAM.impl.PAMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;

import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SAMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.RSMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.DataTypesPackage;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.DataTypes.impl.DataTypesPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.VariablesPackage;

import org.eclipse.papyrus.MARTE.MARTE_Annexes.VSL.Variables.impl.VariablesPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.HLAMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwGeneralPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwArbiter;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBridge;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwBus;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationFactory;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwEndPoint;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwMedia;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl.HwComputingPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.HwDevicePackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwDevice.impl.HwDevicePackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.HwMemoryPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwMemory.impl.HwMemoryPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.HwStorageManagerPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwStorage.HwStorageManager.impl.HwStorageManagerPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.HwTimingPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwTiming.impl.HwTimingPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.HwLayoutPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.impl.HwLayoutPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SW_ResourceCorePackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl.SW_ResourceCorePackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.CoreElementsPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.CoreElements.impl.CoreElementsPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.impl.NFPsPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl;

import org.eclipse.papyrus.MARTE.impl.MARTEPackageImpl;

import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.BasicNFP_TypesPackage;

import org.eclipse.papyrus.MARTE_Library.BasicNFP_Types.impl.BasicNFP_TypesPackageImpl;

import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.GRM_BasicTypesPackage;

import org.eclipse.papyrus.MARTE_Library.GRM_BasicTypes.impl.GRM_BasicTypesPackageImpl;

import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.MARTE_DataTypesPackage;

import org.eclipse.papyrus.MARTE_Library.MARTE_DataTypes.impl.MARTE_DataTypesPackageImpl;

import org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.MARTE_PrimitivesTypesPackage;

import org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.impl.MARTE_PrimitivesTypesPackageImpl;

import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.MeasurementUnitsPackage;

import org.eclipse.papyrus.MARTE_Library.MeasurementUnits.impl.MeasurementUnitsPackageImpl;

import org.eclipse.papyrus.MARTE_Library.RS_Library.RS_LibraryPackage;

import org.eclipse.papyrus.MARTE_Library.RS_Library.impl.RS_LibraryPackageImpl;

import org.eclipse.papyrus.MARTE_Library.TimeLibrary.TimeLibraryPackage;

import org.eclipse.papyrus.MARTE_Library.TimeLibrary.impl.TimeLibraryPackageImpl;

import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryPackage;

import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl.TimeTypesLibraryPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HwCommunicationPackageImpl extends EPackageImpl implements HwCommunicationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwCommunicationResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwArbiterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwMediaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwBusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwBridgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwEndPointEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HwCommunicationPackageImpl() {
		super(eNS_URI, HwCommunicationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link HwCommunicationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HwCommunicationPackage init() {
		if (isInited) return (HwCommunicationPackage)EPackage.Registry.INSTANCE.getEPackage(HwCommunicationPackage.eNS_URI);

		// Obtain or create and register package
		HwCommunicationPackageImpl theHwCommunicationPackage = (HwCommunicationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HwCommunicationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HwCommunicationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MARTEPackageImpl theMARTEPackage = (MARTEPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MARTEPackage.eNS_URI) instanceof MARTEPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MARTEPackage.eNS_URI) : MARTEPackage.eINSTANCE);
		NFPsPackageImpl theNFPsPackage = (NFPsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NFPsPackage.eNS_URI) instanceof NFPsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NFPsPackage.eNS_URI) : NFPsPackage.eINSTANCE);
		CoreElementsPackageImpl theCoreElementsPackage = (CoreElementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoreElementsPackage.eNS_URI) instanceof CoreElementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoreElementsPackage.eNS_URI) : CoreElementsPackage.eINSTANCE);
		AllocPackageImpl theAllocPackage = (AllocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocPackage.eNS_URI) instanceof AllocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocPackage.eNS_URI) : AllocPackage.eINSTANCE);
		TimePackageImpl theTimePackage = (TimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TimePackage.eNS_URI) instanceof TimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimePackage.eNS_URI) : TimePackage.eINSTANCE);
		GRMPackageImpl theGRMPackage = (GRMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GRMPackage.eNS_URI) instanceof GRMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GRMPackage.eNS_URI) : GRMPackage.eINSTANCE);
		RSMPackageImpl theRSMPackage = (RSMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RSMPackage.eNS_URI) instanceof RSMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RSMPackage.eNS_URI) : RSMPackage.eINSTANCE);
		VariablesPackageImpl theVariablesPackage = (VariablesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VariablesPackage.eNS_URI) instanceof VariablesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VariablesPackage.eNS_URI) : VariablesPackage.eINSTANCE);
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI) instanceof DataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI) : DataTypesPackage.eINSTANCE);
		HLAMPackageImpl theHLAMPackage = (HLAMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HLAMPackage.eNS_URI) instanceof HLAMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HLAMPackage.eNS_URI) : HLAMPackage.eINSTANCE);
		HwComputingPackageImpl theHwComputingPackage = (HwComputingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwComputingPackage.eNS_URI) instanceof HwComputingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwComputingPackage.eNS_URI) : HwComputingPackage.eINSTANCE);
		HwStorageManagerPackageImpl theHwStorageManagerPackage = (HwStorageManagerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwStorageManagerPackage.eNS_URI) instanceof HwStorageManagerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwStorageManagerPackage.eNS_URI) : HwStorageManagerPackage.eINSTANCE);
		HwMemoryPackageImpl theHwMemoryPackage = (HwMemoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwMemoryPackage.eNS_URI) instanceof HwMemoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwMemoryPackage.eNS_URI) : HwMemoryPackage.eINSTANCE);
		HwTimingPackageImpl theHwTimingPackage = (HwTimingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwTimingPackage.eNS_URI) instanceof HwTimingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwTimingPackage.eNS_URI) : HwTimingPackage.eINSTANCE);
		HwDevicePackageImpl theHwDevicePackage = (HwDevicePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwDevicePackage.eNS_URI) instanceof HwDevicePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwDevicePackage.eNS_URI) : HwDevicePackage.eINSTANCE);
		HwGeneralPackageImpl theHwGeneralPackage = (HwGeneralPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwGeneralPackage.eNS_URI) instanceof HwGeneralPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwGeneralPackage.eNS_URI) : HwGeneralPackage.eINSTANCE);
		HwLayoutPackageImpl theHwLayoutPackage = (HwLayoutPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwLayoutPackage.eNS_URI) instanceof HwLayoutPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwLayoutPackage.eNS_URI) : HwLayoutPackage.eINSTANCE);
		HwPowerPackageImpl theHwPowerPackage = (HwPowerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwPowerPackage.eNS_URI) instanceof HwPowerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwPowerPackage.eNS_URI) : HwPowerPackage.eINSTANCE);
		SW_ResourceCorePackageImpl theSW_ResourceCorePackage = (SW_ResourceCorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SW_ResourceCorePackage.eNS_URI) instanceof SW_ResourceCorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SW_ResourceCorePackage.eNS_URI) : SW_ResourceCorePackage.eINSTANCE);
		SW_ConcurrencyPackageImpl theSW_ConcurrencyPackage = (SW_ConcurrencyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SW_ConcurrencyPackage.eNS_URI) instanceof SW_ConcurrencyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SW_ConcurrencyPackage.eNS_URI) : SW_ConcurrencyPackage.eINSTANCE);
		SW_BrokeringPackageImpl theSW_BrokeringPackage = (SW_BrokeringPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SW_BrokeringPackage.eNS_URI) instanceof SW_BrokeringPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SW_BrokeringPackage.eNS_URI) : SW_BrokeringPackage.eINSTANCE);
		SW_InteractionPackageImpl theSW_InteractionPackage = (SW_InteractionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SW_InteractionPackage.eNS_URI) instanceof SW_InteractionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SW_InteractionPackage.eNS_URI) : SW_InteractionPackage.eINSTANCE);
		GCMPackageImpl theGCMPackage = (GCMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GCMPackage.eNS_URI) instanceof GCMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GCMPackage.eNS_URI) : GCMPackage.eINSTANCE);
		GQAMPackageImpl theGQAMPackage = (GQAMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GQAMPackage.eNS_URI) instanceof GQAMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GQAMPackage.eNS_URI) : GQAMPackage.eINSTANCE);
		SAMPackageImpl theSAMPackage = (SAMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SAMPackage.eNS_URI) instanceof SAMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SAMPackage.eNS_URI) : SAMPackage.eINSTANCE);
		PAMPackageImpl thePAMPackage = (PAMPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PAMPackage.eNS_URI) instanceof PAMPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PAMPackage.eNS_URI) : PAMPackage.eINSTANCE);
		MeasurementUnitsPackageImpl theMeasurementUnitsPackage = (MeasurementUnitsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementUnitsPackage.eNS_URI) instanceof MeasurementUnitsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementUnitsPackage.eNS_URI) : MeasurementUnitsPackage.eINSTANCE);
		GRM_BasicTypesPackageImpl theGRM_BasicTypesPackage = (GRM_BasicTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GRM_BasicTypesPackage.eNS_URI) instanceof GRM_BasicTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GRM_BasicTypesPackage.eNS_URI) : GRM_BasicTypesPackage.eINSTANCE);
		MARTE_DataTypesPackageImpl theMARTE_DataTypesPackage = (MARTE_DataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MARTE_DataTypesPackage.eNS_URI) instanceof MARTE_DataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MARTE_DataTypesPackage.eNS_URI) : MARTE_DataTypesPackage.eINSTANCE);
		BasicNFP_TypesPackageImpl theBasicNFP_TypesPackage = (BasicNFP_TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI) instanceof BasicNFP_TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI) : BasicNFP_TypesPackage.eINSTANCE);
		TimeTypesLibraryPackageImpl theTimeTypesLibraryPackage = (TimeTypesLibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TimeTypesLibraryPackage.eNS_URI) instanceof TimeTypesLibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimeTypesLibraryPackage.eNS_URI) : TimeTypesLibraryPackage.eINSTANCE);
		TimeLibraryPackageImpl theTimeLibraryPackage = (TimeLibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TimeLibraryPackage.eNS_URI) instanceof TimeLibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimeLibraryPackage.eNS_URI) : TimeLibraryPackage.eINSTANCE);
		RS_LibraryPackageImpl theRS_LibraryPackage = (RS_LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RS_LibraryPackage.eNS_URI) instanceof RS_LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RS_LibraryPackage.eNS_URI) : RS_LibraryPackage.eINSTANCE);
		MARTE_PrimitivesTypesPackageImpl theMARTE_PrimitivesTypesPackage = (MARTE_PrimitivesTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MARTE_PrimitivesTypesPackage.eNS_URI) instanceof MARTE_PrimitivesTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MARTE_PrimitivesTypesPackage.eNS_URI) : MARTE_PrimitivesTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theHwCommunicationPackage.createPackageContents();
		theMARTEPackage.createPackageContents();
		theNFPsPackage.createPackageContents();
		theCoreElementsPackage.createPackageContents();
		theAllocPackage.createPackageContents();
		theTimePackage.createPackageContents();
		theGRMPackage.createPackageContents();
		theRSMPackage.createPackageContents();
		theVariablesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theHLAMPackage.createPackageContents();
		theHwComputingPackage.createPackageContents();
		theHwStorageManagerPackage.createPackageContents();
		theHwMemoryPackage.createPackageContents();
		theHwTimingPackage.createPackageContents();
		theHwDevicePackage.createPackageContents();
		theHwGeneralPackage.createPackageContents();
		theHwLayoutPackage.createPackageContents();
		theHwPowerPackage.createPackageContents();
		theSW_ResourceCorePackage.createPackageContents();
		theSW_ConcurrencyPackage.createPackageContents();
		theSW_BrokeringPackage.createPackageContents();
		theSW_InteractionPackage.createPackageContents();
		theGCMPackage.createPackageContents();
		theGQAMPackage.createPackageContents();
		theSAMPackage.createPackageContents();
		thePAMPackage.createPackageContents();
		theMeasurementUnitsPackage.createPackageContents();
		theGRM_BasicTypesPackage.createPackageContents();
		theMARTE_DataTypesPackage.createPackageContents();
		theBasicNFP_TypesPackage.createPackageContents();
		theTimeTypesLibraryPackage.createPackageContents();
		theTimeLibraryPackage.createPackageContents();
		theRS_LibraryPackage.createPackageContents();
		theMARTE_PrimitivesTypesPackage.createPackageContents();

		// Initialize created meta-data
		theHwCommunicationPackage.initializePackageContents();
		theMARTEPackage.initializePackageContents();
		theNFPsPackage.initializePackageContents();
		theCoreElementsPackage.initializePackageContents();
		theAllocPackage.initializePackageContents();
		theTimePackage.initializePackageContents();
		theGRMPackage.initializePackageContents();
		theRSMPackage.initializePackageContents();
		theVariablesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theHLAMPackage.initializePackageContents();
		theHwComputingPackage.initializePackageContents();
		theHwStorageManagerPackage.initializePackageContents();
		theHwMemoryPackage.initializePackageContents();
		theHwTimingPackage.initializePackageContents();
		theHwDevicePackage.initializePackageContents();
		theHwGeneralPackage.initializePackageContents();
		theHwLayoutPackage.initializePackageContents();
		theHwPowerPackage.initializePackageContents();
		theSW_ResourceCorePackage.initializePackageContents();
		theSW_ConcurrencyPackage.initializePackageContents();
		theSW_BrokeringPackage.initializePackageContents();
		theSW_InteractionPackage.initializePackageContents();
		theGCMPackage.initializePackageContents();
		theGQAMPackage.initializePackageContents();
		theSAMPackage.initializePackageContents();
		thePAMPackage.initializePackageContents();
		theMeasurementUnitsPackage.initializePackageContents();
		theGRM_BasicTypesPackage.initializePackageContents();
		theMARTE_DataTypesPackage.initializePackageContents();
		theBasicNFP_TypesPackage.initializePackageContents();
		theTimeTypesLibraryPackage.initializePackageContents();
		theTimeLibraryPackage.initializePackageContents();
		theRS_LibraryPackage.initializePackageContents();
		theMARTE_PrimitivesTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHwCommunicationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HwCommunicationPackage.eNS_URI, theHwCommunicationPackage);
		return theHwCommunicationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwCommunicationResource() {
		return hwCommunicationResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwArbiter() {
		return hwArbiterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwArbiter_ControlledMedias() {
		return (EReference)hwArbiterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwMedia() {
		return hwMediaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwMedia_BandWidth() {
		return (EAttribute)hwMediaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwMedia_Arbiters() {
		return (EReference)hwMediaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwBus() {
		return hwBusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwBus_AdressWidth() {
		return (EAttribute)hwBusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwBus_WordWidth() {
		return (EAttribute)hwBusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwBus_IsSynchronous() {
		return (EAttribute)hwBusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwBus_IsSerial() {
		return (EAttribute)hwBusEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwBridge() {
		return hwBridgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwBridge_Sides() {
		return (EReference)hwBridgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwEndPoint() {
		return hwEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwEndPoint_ConnectedTo() {
		return (EReference)hwEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwCommunicationFactory getHwCommunicationFactory() {
		return (HwCommunicationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		hwCommunicationResourceEClass = createEClass(HW_COMMUNICATION_RESOURCE);

		hwArbiterEClass = createEClass(HW_ARBITER);
		createEReference(hwArbiterEClass, HW_ARBITER__CONTROLLED_MEDIAS);

		hwMediaEClass = createEClass(HW_MEDIA);
		createEAttribute(hwMediaEClass, HW_MEDIA__BAND_WIDTH);
		createEReference(hwMediaEClass, HW_MEDIA__ARBITERS);

		hwBusEClass = createEClass(HW_BUS);
		createEAttribute(hwBusEClass, HW_BUS__ADRESS_WIDTH);
		createEAttribute(hwBusEClass, HW_BUS__WORD_WIDTH);
		createEAttribute(hwBusEClass, HW_BUS__IS_SYNCHRONOUS);
		createEAttribute(hwBusEClass, HW_BUS__IS_SERIAL);

		hwBridgeEClass = createEClass(HW_BRIDGE);
		createEReference(hwBridgeEClass, HW_BRIDGE__SIDES);

		hwEndPointEClass = createEClass(HW_END_POINT);
		createEReference(hwEndPointEClass, HW_END_POINT__CONNECTED_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		HwGeneralPackage theHwGeneralPackage = (HwGeneralPackage)EPackage.Registry.INSTANCE.getEPackage(HwGeneralPackage.eNS_URI);
		GRMPackage theGRMPackage = (GRMPackage)EPackage.Registry.INSTANCE.getEPackage(GRMPackage.eNS_URI);
		BasicNFP_TypesPackage theBasicNFP_TypesPackage = (BasicNFP_TypesPackage)EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		hwCommunicationResourceEClass.getESuperTypes().add(theHwGeneralPackage.getHwResource());
		hwArbiterEClass.getESuperTypes().add(this.getHwCommunicationResource());
		hwMediaEClass.getESuperTypes().add(theGRMPackage.getCommunicationMedia());
		hwMediaEClass.getESuperTypes().add(this.getHwCommunicationResource());
		hwBusEClass.getESuperTypes().add(this.getHwMedia());
		hwBridgeEClass.getESuperTypes().add(this.getHwMedia());
		hwEndPointEClass.getESuperTypes().add(this.getHwCommunicationResource());
		hwEndPointEClass.getESuperTypes().add(theGRMPackage.getCommunicationEndPoint());

		// Initialize classes and features; add operations and parameters
		initEClass(hwCommunicationResourceEClass, HwCommunicationResource.class, "HwCommunicationResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwArbiterEClass, HwArbiter.class, "HwArbiter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHwArbiter_ControlledMedias(), this.getHwMedia(), this.getHwMedia_Arbiters(), "controlledMedias", null, 0, -1, HwArbiter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwMediaEClass, HwMedia.class, "HwMedia", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHwMedia_BandWidth(), theBasicNFP_TypesPackage.getNFP_DataTxRate(), "bandWidth", null, 0, 1, HwMedia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwMedia_Arbiters(), this.getHwArbiter(), this.getHwArbiter_ControlledMedias(), "arbiters", null, 0, -1, HwMedia.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwBusEClass, HwBus.class, "HwBus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHwBus_AdressWidth(), theBasicNFP_TypesPackage.getNFP_DataSize(), "adressWidth", null, 0, 1, HwBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwBus_WordWidth(), theBasicNFP_TypesPackage.getNFP_DataSize(), "wordWidth", null, 0, 1, HwBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwBus_IsSynchronous(), theBasicNFP_TypesPackage.getNFP_Boolean(), "isSynchronous", null, 0, 1, HwBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwBus_IsSerial(), theBasicNFP_TypesPackage.getNFP_Boolean(), "isSerial", null, 0, 1, HwBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwBridgeEClass, HwBridge.class, "HwBridge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHwBridge_Sides(), this.getHwMedia(), null, "sides", null, 0, -1, HwBridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwEndPointEClass, HwEndPoint.class, "HwEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHwEndPoint_ConnectedTo(), this.getHwMedia(), null, "connectedTo", null, 0, -1, HwEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //HwCommunicationPackageImpl
