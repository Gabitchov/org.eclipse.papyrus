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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.impl;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.HwCommunicationPackage;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwCommunication.impl.HwCommunicationPackageImpl;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwASIC;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwBranchPredictor;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingFactory;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingResource;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwISA;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwPLD;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwProcessor;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.ISA_Type;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Class;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.PLD_Technology;

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
public class HwComputingPackageImpl extends EPackageImpl implements HwComputingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwComputingResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwISAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwBranchPredictorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwASICEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwPLDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum isA_TypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum plD_TechnologyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum plD_ClassEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType plD_OrganizationEDataType = null;

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
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwLogical.HwComputing.HwComputingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HwComputingPackageImpl() {
		super(eNS_URI, HwComputingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HwComputingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HwComputingPackage init() {
		if (isInited) return (HwComputingPackage)EPackage.Registry.INSTANCE.getEPackage(HwComputingPackage.eNS_URI);

		// Obtain or create and register package
		HwComputingPackageImpl theHwComputingPackage = (HwComputingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HwComputingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HwComputingPackageImpl());

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
		HwCommunicationPackageImpl theHwCommunicationPackage = (HwCommunicationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HwCommunicationPackage.eNS_URI) instanceof HwCommunicationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HwCommunicationPackage.eNS_URI) : HwCommunicationPackage.eINSTANCE);
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
		theHwComputingPackage.createPackageContents();
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
		theHwCommunicationPackage.createPackageContents();
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
		theHwComputingPackage.initializePackageContents();
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
		theHwCommunicationPackage.initializePackageContents();
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
		theHwComputingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HwComputingPackage.eNS_URI, theHwComputingPackage);
		return theHwComputingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwProcessor() {
		return hwProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_Architecture() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_Mips() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_Ipc() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_NbCores() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_NbPipelines() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_NbStages() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_NbALUs() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwProcessor_NbFPUs() {
		return (EAttribute)hwProcessorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwProcessor_OwnedISAs() {
		return (EReference)hwProcessorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwProcessor_Predictors() {
		return (EReference)hwProcessorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwProcessor_Caches() {
		return (EReference)hwProcessorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwProcessor_OwnedMMUs() {
		return (EReference)hwProcessorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwComputingResource() {
		return hwComputingResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwComputingResource_Op_Frequencies() {
		return (EAttribute)hwComputingResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwISA() {
		return hwISAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwISA_Family() {
		return (EAttribute)hwISAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwISA_Inst_Width() {
		return (EAttribute)hwISAEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwISA_Type() {
		return (EAttribute)hwISAEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwBranchPredictor() {
		return hwBranchPredictorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwASIC() {
		return hwASICEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHwPLD() {
		return hwPLDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwPLD_Technology() {
		return (EAttribute)hwPLDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwPLD_Organization() {
		return (EAttribute)hwPLDEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwPLD_NbLUTs() {
		return (EAttribute)hwPLDEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwPLD_NdLUT_Inputs() {
		return (EAttribute)hwPLDEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHwPLD_NbFlipFlops() {
		return (EAttribute)hwPLDEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwPLD_BlocksRAM() {
		return (EReference)hwPLDEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHwPLD_BlocksComputing() {
		return (EReference)hwPLDEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getISA_Type() {
		return isA_TypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPLD_Technology() {
		return plD_TechnologyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPLD_Class() {
		return plD_ClassEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPLD_Organization() {
		return plD_OrganizationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwComputingFactory getHwComputingFactory() {
		return (HwComputingFactory)getEFactoryInstance();
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
		hwProcessorEClass = createEClass(HW_PROCESSOR);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__ARCHITECTURE);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__MIPS);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__IPC);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__NB_CORES);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__NB_PIPELINES);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__NB_STAGES);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__NB_AL_US);
		createEAttribute(hwProcessorEClass, HW_PROCESSOR__NB_FP_US);
		createEReference(hwProcessorEClass, HW_PROCESSOR__OWNED_IS_AS);
		createEReference(hwProcessorEClass, HW_PROCESSOR__PREDICTORS);
		createEReference(hwProcessorEClass, HW_PROCESSOR__CACHES);
		createEReference(hwProcessorEClass, HW_PROCESSOR__OWNED_MM_US);

		hwComputingResourceEClass = createEClass(HW_COMPUTING_RESOURCE);
		createEAttribute(hwComputingResourceEClass, HW_COMPUTING_RESOURCE__OP_FREQUENCIES);

		hwISAEClass = createEClass(HW_ISA);
		createEAttribute(hwISAEClass, HW_ISA__FAMILY);
		createEAttribute(hwISAEClass, HW_ISA__INST_WIDTH);
		createEAttribute(hwISAEClass, HW_ISA__TYPE);

		hwBranchPredictorEClass = createEClass(HW_BRANCH_PREDICTOR);

		hwASICEClass = createEClass(HW_ASIC);

		hwPLDEClass = createEClass(HW_PLD);
		createEAttribute(hwPLDEClass, HW_PLD__TECHNOLOGY);
		createEAttribute(hwPLDEClass, HW_PLD__ORGANIZATION);
		createEAttribute(hwPLDEClass, HW_PLD__NB_LU_TS);
		createEAttribute(hwPLDEClass, HW_PLD__ND_LUT_INPUTS);
		createEAttribute(hwPLDEClass, HW_PLD__NB_FLIP_FLOPS);
		createEReference(hwPLDEClass, HW_PLD__BLOCKS_RAM);
		createEReference(hwPLDEClass, HW_PLD__BLOCKS_COMPUTING);

		// Create enums
		isA_TypeEEnum = createEEnum(ISA_TYPE);
		plD_TechnologyEEnum = createEEnum(PLD_TECHNOLOGY);
		plD_ClassEEnum = createEEnum(PLD_CLASS);

		// Create data types
		plD_OrganizationEDataType = createEDataType(PLD_ORGANIZATION);
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
		BasicNFP_TypesPackage theBasicNFP_TypesPackage = (BasicNFP_TypesPackage)EPackage.Registry.INSTANCE.getEPackage(BasicNFP_TypesPackage.eNS_URI);
		HwMemoryPackage theHwMemoryPackage = (HwMemoryPackage)EPackage.Registry.INSTANCE.getEPackage(HwMemoryPackage.eNS_URI);
		HwStorageManagerPackage theHwStorageManagerPackage = (HwStorageManagerPackage)EPackage.Registry.INSTANCE.getEPackage(HwStorageManagerPackage.eNS_URI);
		HwGeneralPackage theHwGeneralPackage = (HwGeneralPackage)EPackage.Registry.INSTANCE.getEPackage(HwGeneralPackage.eNS_URI);
		GRMPackage theGRMPackage = (GRMPackage)EPackage.Registry.INSTANCE.getEPackage(GRMPackage.eNS_URI);
		MARTE_DataTypesPackage theMARTE_DataTypesPackage = (MARTE_DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(MARTE_DataTypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		hwProcessorEClass.getESuperTypes().add(this.getHwComputingResource());
		hwComputingResourceEClass.getESuperTypes().add(theHwGeneralPackage.getHwResource());
		hwComputingResourceEClass.getESuperTypes().add(theGRMPackage.getComputingResource());
		hwISAEClass.getESuperTypes().add(theHwGeneralPackage.getHwResource());
		hwBranchPredictorEClass.getESuperTypes().add(theHwGeneralPackage.getHwResource());
		hwASICEClass.getESuperTypes().add(this.getHwComputingResource());
		hwPLDEClass.getESuperTypes().add(this.getHwComputingResource());

		// Initialize classes and features; add operations and parameters
		initEClass(hwProcessorEClass, HwProcessor.class, "HwProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHwProcessor_Architecture(), theBasicNFP_TypesPackage.getNFP_DataSize(), "architecture", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_Mips(), theBasicNFP_TypesPackage.getNFP_Natural(), "mips", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_Ipc(), theBasicNFP_TypesPackage.getNFP_Real(), "ipc", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_NbCores(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbCores", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_NbPipelines(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbPipelines", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_NbStages(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbStages", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_NbALUs(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbALUs", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwProcessor_NbFPUs(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbFPUs", null, 0, 1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwProcessor_OwnedISAs(), this.getHwISA(), null, "ownedISAs", null, 0, -1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwProcessor_Predictors(), this.getHwBranchPredictor(), null, "predictors", null, 0, -1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwProcessor_Caches(), theHwMemoryPackage.getHwCache(), null, "caches", null, 0, -1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwProcessor_OwnedMMUs(), theHwStorageManagerPackage.getHwMMU(), null, "ownedMMUs", null, 0, -1, HwProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwComputingResourceEClass, HwComputingResource.class, "HwComputingResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHwComputingResource_Op_Frequencies(), theMARTE_DataTypesPackage.getNFP_FrequencyInterval(), "op_Frequencies", null, 0, 1, HwComputingResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwISAEClass, HwISA.class, "HwISA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHwISA_Family(), theBasicNFP_TypesPackage.getNFP_String(), "family", null, 0, 1, HwISA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwISA_Inst_Width(), theBasicNFP_TypesPackage.getNFP_DataSize(), "inst_Width", null, 0, 1, HwISA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwISA_Type(), this.getISA_Type(), "type", null, 0, 1, HwISA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hwBranchPredictorEClass, HwBranchPredictor.class, "HwBranchPredictor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwASICEClass, HwASIC.class, "HwASIC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwPLDEClass, HwPLD.class, "HwPLD", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHwPLD_Technology(), this.getPLD_Technology(), "technology", null, 0, 1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwPLD_Organization(), this.getPLD_Organization(), "organization", null, 0, 1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwPLD_NbLUTs(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbLUTs", null, 0, 1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwPLD_NdLUT_Inputs(), theBasicNFP_TypesPackage.getNFP_Natural(), "ndLUT_Inputs", null, 0, 1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getHwPLD_NbFlipFlops(), theBasicNFP_TypesPackage.getNFP_Natural(), "nbFlipFlops", null, 0, 1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwPLD_BlocksRAM(), theHwMemoryPackage.getHwRAM(), null, "blocksRAM", null, 0, -1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getHwPLD_BlocksComputing(), this.getHwComputingResource(), null, "blocksComputing", null, 0, -1, HwPLD.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(isA_TypeEEnum, ISA_Type.class, "ISA_Type");
		addEEnumLiteral(isA_TypeEEnum, ISA_Type.RISC);
		addEEnumLiteral(isA_TypeEEnum, ISA_Type.CISC);
		addEEnumLiteral(isA_TypeEEnum, ISA_Type.VLIW);
		addEEnumLiteral(isA_TypeEEnum, ISA_Type.SIMD);
		addEEnumLiteral(isA_TypeEEnum, ISA_Type.OTHER);
		addEEnumLiteral(isA_TypeEEnum, ISA_Type.UNDEF);

		initEEnum(plD_TechnologyEEnum, PLD_Technology.class, "PLD_Technology");
		addEEnumLiteral(plD_TechnologyEEnum, PLD_Technology.SRAM);
		addEEnumLiteral(plD_TechnologyEEnum, PLD_Technology.ANTIFUSE);
		addEEnumLiteral(plD_TechnologyEEnum, PLD_Technology.FLASH);
		addEEnumLiteral(plD_TechnologyEEnum, PLD_Technology.OTHER);
		addEEnumLiteral(plD_TechnologyEEnum, PLD_Technology.UNDEF);

		initEEnum(plD_ClassEEnum, PLD_Class.class, "PLD_Class");
		addEEnumLiteral(plD_ClassEEnum, PLD_Class.SYMETRICAL_ARRAY);
		addEEnumLiteral(plD_ClassEEnum, PLD_Class.ROW_BASED);
		addEEnumLiteral(plD_ClassEEnum, PLD_Class.SEA_OF_GATES);
		addEEnumLiteral(plD_ClassEEnum, PLD_Class.HIERARCHICAL_PLD);
		addEEnumLiteral(plD_ClassEEnum, PLD_Class.OTHER);
		addEEnumLiteral(plD_ClassEEnum, PLD_Class.UNDEF);

		// Initialize data types
		initEDataType(plD_OrganizationEDataType, String.class, "PLD_Organization", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// subsets
		createSubsetsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>subsets</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSubsetsAnnotations() {
		String source = "subsets";		
		addAnnotation
		  (getHwProcessor_OwnedISAs(), 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(MARTEPackage.eNS_URI).appendFragment("//MARTE_DesignModel/HRM/HwGeneral/HwResource/ownedHW")
		   });		
		addAnnotation
		  (getHwProcessor_Predictors(), 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(MARTEPackage.eNS_URI).appendFragment("//MARTE_DesignModel/HRM/HwGeneral/HwResource/ownedHW")
		   });		
		addAnnotation
		  (getHwProcessor_Caches(), 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(MARTEPackage.eNS_URI).appendFragment("//MARTE_DesignModel/HRM/HwGeneral/HwResource/ownedHW")
		   });		
		addAnnotation
		  (getHwProcessor_OwnedMMUs(), 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(MARTEPackage.eNS_URI).appendFragment("//MARTE_DesignModel/HRM/HwGeneral/HwResource/ownedHW")
		   });		
		addAnnotation
		  (getHwPLD_BlocksRAM(), 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(MARTEPackage.eNS_URI).appendFragment("//MARTE_DesignModel/HRM/HwGeneral/HwResource/ownedHW")
		   });		
		addAnnotation
		  (getHwPLD_BlocksComputing(), 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(MARTEPackage.eNS_URI).appendFragment("//MARTE_DesignModel/HRM/HwGeneral/HwResource/ownedHW")
		   });
	}

} //HwComputingPackageImpl
