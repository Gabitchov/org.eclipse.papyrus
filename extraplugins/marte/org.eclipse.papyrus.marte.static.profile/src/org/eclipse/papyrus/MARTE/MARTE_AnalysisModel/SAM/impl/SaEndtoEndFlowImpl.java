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
package org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaTimedObs;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sa Endto End Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl#getIsSched <em>Is Sched</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl#getSchSlack <em>Sch Slack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl#getEnd2EndT <em>End2 End T</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl#getEnd2EndD <em>End2 End D</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl#getTiming <em>Timing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.impl.SaEndtoEndFlowImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaEndtoEndFlowImpl extends EObjectImpl implements SaEndtoEndFlow {
	/**
	 * The default value of the '{@link #getIsSched() <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSched()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_SCHED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsSched() <em>Is Sched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSched()
	 * @generated
	 * @ordered
	 */
	protected String isSched = IS_SCHED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchSlack() <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchSlack()
	 * @generated
	 * @ordered
	 */
	protected static final String SCH_SLACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchSlack() <em>Sch Slack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchSlack()
	 * @generated
	 * @ordered
	 */
	protected String schSlack = SCH_SLACK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnd2EndT() <em>End2 End T</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2EndT()
	 * @generated
	 * @ordered
	 */
	protected EList<String> end2EndT;

	/**
	 * The cached value of the '{@link #getEnd2EndD() <em>End2 End D</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2EndD()
	 * @generated
	 * @ordered
	 */
	protected EList<String> end2EndD;

	/**
	 * The cached value of the '{@link #getTiming() <em>Timing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiming()
	 * @generated
	 * @ordered
	 */
	protected EList<GaTimedObs> timing;

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaEndtoEndFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SAMPackage.Literals.SA_ENDTO_END_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsSched() {
		return isSched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSched(String newIsSched) {
		String oldIsSched = isSched;
		isSched = newIsSched;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_ENDTO_END_FLOW__IS_SCHED, oldIsSched, isSched));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchSlack() {
		return schSlack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchSlack(String newSchSlack) {
		String oldSchSlack = schSlack;
		schSlack = newSchSlack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_ENDTO_END_FLOW__SCH_SLACK, oldSchSlack, schSlack));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEnd2EndT() {
		if (end2EndT == null) {
			end2EndT = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_ENDTO_END_FLOW__END2_END_T);
		}
		return end2EndT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEnd2EndD() {
		if (end2EndD == null) {
			end2EndD = new EDataTypeUniqueEList<String>(String.class, this, SAMPackage.SA_ENDTO_END_FLOW__END2_END_D);
		}
		return end2EndD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GaTimedObs> getTiming() {
		if (timing == null) {
			timing = new EObjectResolvingEList<GaTimedObs>(GaTimedObs.class, this, SAMPackage.SA_ENDTO_END_FLOW__TIMING);
		}
		return timing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if (base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if (base_NamedElement != oldBase_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SAMPackage.SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SAMPackage.SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SAMPackage.SA_ENDTO_END_FLOW__IS_SCHED:
				return getIsSched();
			case SAMPackage.SA_ENDTO_END_FLOW__SCH_SLACK:
				return getSchSlack();
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_T:
				return getEnd2EndT();
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_D:
				return getEnd2EndD();
			case SAMPackage.SA_ENDTO_END_FLOW__TIMING:
				return getTiming();
			case SAMPackage.SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SAMPackage.SA_ENDTO_END_FLOW__IS_SCHED:
				setIsSched((String)newValue);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__SCH_SLACK:
				setSchSlack((String)newValue);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_T:
				getEnd2EndT().clear();
				getEnd2EndT().addAll((Collection<? extends String>)newValue);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_D:
				getEnd2EndD().clear();
				getEnd2EndD().addAll((Collection<? extends String>)newValue);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__TIMING:
				getTiming().clear();
				getTiming().addAll((Collection<? extends GaTimedObs>)newValue);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SAMPackage.SA_ENDTO_END_FLOW__IS_SCHED:
				setIsSched(IS_SCHED_EDEFAULT);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__SCH_SLACK:
				setSchSlack(SCH_SLACK_EDEFAULT);
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_T:
				getEnd2EndT().clear();
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_D:
				getEnd2EndD().clear();
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__TIMING:
				getTiming().clear();
				return;
			case SAMPackage.SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SAMPackage.SA_ENDTO_END_FLOW__IS_SCHED:
				return IS_SCHED_EDEFAULT == null ? isSched != null : !IS_SCHED_EDEFAULT.equals(isSched);
			case SAMPackage.SA_ENDTO_END_FLOW__SCH_SLACK:
				return SCH_SLACK_EDEFAULT == null ? schSlack != null : !SCH_SLACK_EDEFAULT.equals(schSlack);
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_T:
				return end2EndT != null && !end2EndT.isEmpty();
			case SAMPackage.SA_ENDTO_END_FLOW__END2_END_D:
				return end2EndD != null && !end2EndD.isEmpty();
			case SAMPackage.SA_ENDTO_END_FLOW__TIMING:
				return timing != null && !timing.isEmpty();
			case SAMPackage.SA_ENDTO_END_FLOW__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isSched: ");
		result.append(isSched);
		result.append(", schSlack: ");
		result.append(schSlack);
		result.append(", end2EndT: ");
		result.append(end2EndT);
		result.append(", end2EndD: ");
		result.append(end2EndD);
		result.append(')');
		return result.toString();
	}

} //SaEndtoEndFlowImpl
