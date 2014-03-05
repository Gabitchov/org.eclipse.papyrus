/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.infra.core.sashwindows.di.*;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.Position;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.Size;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiFactoryImpl extends EFactoryImpl implements DiFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiFactory init() {
		try {
			DiFactory theDiFactory = (DiFactory)EPackage.Registry.INSTANCE.getEFactory(DiPackage.eNS_URI);
			if (theDiFactory != null) {
				return theDiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiPackage.SASH_MODEL: return createSashModel();
			case DiPackage.WINDOW: return createWindow();
			case DiPackage.POSITION: return createPosition();
			case DiPackage.SIZE: return createSize();
			case DiPackage.TAB_FOLDER: return createTabFolder();
			case DiPackage.PAGE_REF: return createPageRef();
			case DiPackage.SASH_PANEL: return createSashPanel();
			case DiPackage.ABSTRACT_PAGE: return createAbstractPage();
			case DiPackage.PAGE_LIST: return createPageList();
			case DiPackage.SASH_WINDOWS_MNGR: return createSashWindowsMngr();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DiPackage.INT:
				return createintFromString(eDataType, initialValue);
			case DiPackage.JAVA_OBJECT:
				return createJavaObjectFromString(eDataType, initialValue);
			case DiPackage.BOOLEAN:
				return createbooleanFromString(eDataType, initialValue);
			case DiPackage.FLOAT:
				return createFloatFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DiPackage.INT:
				return convertintToString(eDataType, instanceValue);
			case DiPackage.JAVA_OBJECT:
				return convertJavaObjectToString(eDataType, instanceValue);
			case DiPackage.BOOLEAN:
				return convertbooleanToString(eDataType, instanceValue);
			case DiPackage.FLOAT:
				return convertFloatToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SashModel createSashModel() {
		SashModelImpl sashModel = new SashModelImpl();
		return sashModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Window createWindow() {
		WindowImpl window = new WindowImpl();
		return window;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Position createPosition() {
		PositionImpl position = new PositionImpl();
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Size createSize() {
		SizeImpl size = new SizeImpl();
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TabFolder createTabFolder() {
		TabFolderImpl tabFolder = new TabFolderImpl();
		return tabFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageRef createPageRef() {
		PageRefImpl pageRef = new PageRefImpl();
		return pageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SashPanel createSashPanel() {
		SashPanelImpl sashPanel = new SashPanelImpl();
		return sashPanel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractPage createAbstractPage() {
		AbstractPageImpl abstractPage = new AbstractPageImpl();
		return abstractPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageList createPageList() {
		PageListImpl pageList = new PageListImpl();
		return pageList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SashWindowsMngr createSashWindowsMngr() {
		SashWindowsMngrImpl sashWindowsMngr = new SashWindowsMngrImpl();
		return sashWindowsMngr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createintFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertintToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float createFloatFromString(EDataType eDataType, String initialValue) {
		return (Float)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFloatToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean createbooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertbooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiPackage getDiPackage() {
		return (DiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiPackage getPackage() {
		return DiPackage.eINSTANCE;
	}

} //DiFactoryImpl
