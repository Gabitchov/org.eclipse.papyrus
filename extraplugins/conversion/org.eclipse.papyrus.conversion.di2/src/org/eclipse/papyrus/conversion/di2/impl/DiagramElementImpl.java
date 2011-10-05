/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.conversion.di2.Di2Package;
import org.eclipse.papyrus.conversion.di2.DiagramElement;
import org.eclipse.papyrus.conversion.di2.GraphElement;
import org.eclipse.papyrus.conversion.di2.Property;
import org.eclipse.papyrus.conversion.di2.Reference;
import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getProperty <em>
 * Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#isIsVisible <em>Is
 * Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getReference <em>
 * Reference</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getContainer <em>
 * Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getFontFamily <em>Font
 * Family</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getFontSize <em>Font
 * Size</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getLineStyle <em>Line
 * Style</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getLineThickness <em>
 * Line Thickness</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getFontColor <em>Font
 * Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getForegroundColor
 * <em>Foreground Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getBackgroundColor
 * <em>Background Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getBorderColor <em>
 * Border Color</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#isTranslucent <em>
 * Translucent</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getSemanticParent <em>
 * Semantic Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl#getSemanticChild <em>
 * Semantic Child</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DiagramElementImpl extends EObjectImpl implements DiagramElement {

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> property;

	/**
	 * The default value of the '{@link #isIsVisible() <em>Is Visible</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsVisible() <em>Is Visible</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean isVisible = IS_VISIBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> reference;

	/**
	 * The default value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_FAMILY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFontFamily() <em>Font Family</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontFamily()
	 * @generated
	 * @ordered
	 */
	protected String fontFamily = FONT_FAMILY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontSize() <em>Font Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected static final int FONT_SIZE_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getFontSize() <em>Font Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontSize()
	 * @generated
	 * @ordered
	 */
	protected int fontSize = FONT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLineStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String LINE_STYLE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLineStyle()
	 * @generated
	 * @ordered
	 */
	protected String lineStyle = LINE_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineThickness() <em>Line Thickness</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLineThickness()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_THICKNESS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getLineThickness() <em>Line Thickness</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLineThickness()
	 * @generated
	 * @ordered
	 */
	protected int lineThickness = LINE_THICKNESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontColor() <em>Font Color</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected static final RGB FONT_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFontColor() <em>Font Color</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFontColor()
	 * @generated
	 * @ordered
	 */
	protected RGB fontColor = FONT_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected static final RGB FOREGROUND_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected RGB foregroundColor = FOREGROUND_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected static final RGB BACKGROUND_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected RGB backgroundColor = BACKGROUND_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected static final RGB BORDER_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected RGB borderColor = BORDER_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isTranslucent() <em>Translucent</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isTranslucent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSLUCENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTranslucent() <em>Translucent</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isTranslucent()
	 * @generated
	 * @ordered
	 */
	protected boolean translucent = TRANSLUCENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSemanticParent() <em>Semantic Parent</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSemanticParent()
	 * @generated
	 * @ordered
	 */
	protected DiagramElement semanticParent;

	/**
	 * The cached value of the '{@link #getSemanticChild() <em>Semantic Child</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSemanticChild()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramElement> semanticChild;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiagramElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Di2Package.Literals.DIAGRAM_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Property> getProperty() {
		if (property == null) {
			property = new EObjectContainmentEList<Property>(Property.class, this, Di2Package.DIAGRAM_ELEMENT__PROPERTY);
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsVisible() {
		return isVisible;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsVisible(boolean newIsVisible) {
		boolean oldIsVisible = isVisible;
		isVisible = newIsVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__IS_VISIBLE, oldIsVisible,
					isVisible));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Reference> getReference() {
		if (reference == null) {
			reference = new EObjectResolvingEList<Reference>(Reference.class, this,
					Di2Package.DIAGRAM_ELEMENT__REFERENCE);
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement getContainer() {
		if (eContainerFeatureID != Di2Package.DIAGRAM_ELEMENT__CONTAINER)
			return null;
		return (GraphElement) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContainer(GraphElement newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainer, Di2Package.DIAGRAM_ELEMENT__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainer(GraphElement newContainer) {
		if (newContainer != eInternalContainer()
				|| (eContainerFeatureID != Di2Package.DIAGRAM_ELEMENT__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject) newContainer).eInverseAdd(this, Di2Package.GRAPH_ELEMENT__CONTAINED,
						GraphElement.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__CONTAINER, newContainer,
					newContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFontFamily() {
		return fontFamily;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFontFamily(String newFontFamily) {
		String oldFontFamily = fontFamily;
		fontFamily = newFontFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__FONT_FAMILY,
					oldFontFamily, fontFamily));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFontSize(int newFontSize) {
		int oldFontSize = fontSize;
		fontSize = newFontSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__FONT_SIZE, oldFontSize,
					fontSize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLineStyle() {
		return lineStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLineStyle(String newLineStyle) {
		String oldLineStyle = lineStyle;
		lineStyle = newLineStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__LINE_STYLE, oldLineStyle,
					lineStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getLineThickness() {
		return lineThickness;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLineThickness(int newLineThickness) {
		int oldLineThickness = lineThickness;
		lineThickness = newLineThickness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__LINE_THICKNESS,
					oldLineThickness, lineThickness));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RGB getFontColor() {
		return fontColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFontColor(RGB newFontColor) {
		RGB oldFontColor = fontColor;
		fontColor = newFontColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__FONT_COLOR, oldFontColor,
					fontColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RGB getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setForegroundColor(RGB newForegroundColor) {
		RGB oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__FOREGROUND_COLOR,
					oldForegroundColor, foregroundColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RGB getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBackgroundColor(RGB newBackgroundColor) {
		RGB oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__BACKGROUND_COLOR,
					oldBackgroundColor, backgroundColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RGB getBorderColor() {
		return borderColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBorderColor(RGB newBorderColor) {
		RGB oldBorderColor = borderColor;
		borderColor = newBorderColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__BORDER_COLOR,
					oldBorderColor, borderColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isTranslucent() {
		return translucent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTranslucent(boolean newTranslucent) {
		boolean oldTranslucent = translucent;
		translucent = newTranslucent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__TRANSLUCENT,
					oldTranslucent, translucent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement getSemanticParent() {
		if (semanticParent != null && semanticParent.eIsProxy()) {
			InternalEObject oldSemanticParent = (InternalEObject) semanticParent;
			semanticParent = (DiagramElement) eResolveProxy(oldSemanticParent);
			if (semanticParent != oldSemanticParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT, oldSemanticParent, semanticParent));
			}
		}
		return semanticParent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement basicGetSemanticParent() {
		return semanticParent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSemanticParent(DiagramElement newSemanticParent, NotificationChain msgs) {
		DiagramElement oldSemanticParent = semanticParent;
		semanticParent = newSemanticParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT, oldSemanticParent, newSemanticParent);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSemanticParent(DiagramElement newSemanticParent) {
		if (newSemanticParent != semanticParent) {
			NotificationChain msgs = null;
			if (semanticParent != null)
				msgs = ((InternalEObject) semanticParent).eInverseRemove(this,
						Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD, DiagramElement.class, msgs);
			if (newSemanticParent != null)
				msgs = ((InternalEObject) newSemanticParent).eInverseAdd(this,
						Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD, DiagramElement.class, msgs);
			msgs = basicSetSemanticParent(newSemanticParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT,
					newSemanticParent, newSemanticParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<DiagramElement> getSemanticChild() {
		if (semanticChild == null) {
			semanticChild = new EObjectWithInverseResolvingEList<DiagramElement>(DiagramElement.class, this,
					Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD, Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT);
		}
		return semanticChild;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property getProperty(String key) {
		java.util.Iterator it = getProperty().iterator();
		while (it.hasNext()) {
			Property element = (Property) it.next();
			if (key.equals(element.getKey())) {
				return element;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPropertyValue(String key) {
		if (this.getProperty(key) != null) {
			return this.getProperty(key).getValue();
		}
		return null;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getEditpartName() {
		return this.getPropertyValue(org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration.PAPYRUSEDITPART
				.getLiteral());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainer((GraphElement) otherEnd, msgs);
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT:
			if (semanticParent != null)
				msgs = ((InternalEObject) semanticParent).eInverseRemove(this,
						Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD, DiagramElement.class, msgs);
			return basicSetSemanticParent((DiagramElement) otherEnd, msgs);
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSemanticChild()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Di2Package.DIAGRAM_ELEMENT__PROPERTY:
			return ((InternalEList<?>) getProperty()).basicRemove(otherEnd, msgs);
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			return basicSetContainer(null, msgs);
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT:
			return basicSetSemanticParent(null, msgs);
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD:
			return ((InternalEList<?>) getSemanticChild()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			return eInternalContainer().eInverseRemove(this, Di2Package.GRAPH_ELEMENT__CONTAINED, GraphElement.class,
					msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Di2Package.DIAGRAM_ELEMENT__PROPERTY:
			return getProperty();
		case Di2Package.DIAGRAM_ELEMENT__IS_VISIBLE:
			return isIsVisible() ? Boolean.TRUE : Boolean.FALSE;
		case Di2Package.DIAGRAM_ELEMENT__REFERENCE:
			return getReference();
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			return getContainer();
		case Di2Package.DIAGRAM_ELEMENT__FONT_FAMILY:
			return getFontFamily();
		case Di2Package.DIAGRAM_ELEMENT__FONT_SIZE:
			return new Integer(getFontSize());
		case Di2Package.DIAGRAM_ELEMENT__LINE_STYLE:
			return getLineStyle();
		case Di2Package.DIAGRAM_ELEMENT__LINE_THICKNESS:
			return new Integer(getLineThickness());
		case Di2Package.DIAGRAM_ELEMENT__FONT_COLOR:
			return getFontColor();
		case Di2Package.DIAGRAM_ELEMENT__FOREGROUND_COLOR:
			return getForegroundColor();
		case Di2Package.DIAGRAM_ELEMENT__BACKGROUND_COLOR:
			return getBackgroundColor();
		case Di2Package.DIAGRAM_ELEMENT__BORDER_COLOR:
			return getBorderColor();
		case Di2Package.DIAGRAM_ELEMENT__TRANSLUCENT:
			return isTranslucent() ? Boolean.TRUE : Boolean.FALSE;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT:
			if (resolve)
				return getSemanticParent();
			return basicGetSemanticParent();
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD:
			return getSemanticChild();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Di2Package.DIAGRAM_ELEMENT__PROPERTY:
			getProperty().clear();
			getProperty().addAll((Collection<? extends Property>) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__IS_VISIBLE:
			setIsVisible(((Boolean) newValue).booleanValue());
			return;
		case Di2Package.DIAGRAM_ELEMENT__REFERENCE:
			getReference().clear();
			getReference().addAll((Collection<? extends Reference>) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			setContainer((GraphElement) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FONT_FAMILY:
			setFontFamily((String) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FONT_SIZE:
			setFontSize(((Integer) newValue).intValue());
			return;
		case Di2Package.DIAGRAM_ELEMENT__LINE_STYLE:
			setLineStyle((String) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__LINE_THICKNESS:
			setLineThickness(((Integer) newValue).intValue());
			return;
		case Di2Package.DIAGRAM_ELEMENT__FONT_COLOR:
			setFontColor((RGB) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FOREGROUND_COLOR:
			setForegroundColor((RGB) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__BACKGROUND_COLOR:
			setBackgroundColor((RGB) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__BORDER_COLOR:
			setBorderColor((RGB) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__TRANSLUCENT:
			setTranslucent(((Boolean) newValue).booleanValue());
			return;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT:
			setSemanticParent((DiagramElement) newValue);
			return;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD:
			getSemanticChild().clear();
			getSemanticChild().addAll((Collection<? extends DiagramElement>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Di2Package.DIAGRAM_ELEMENT__PROPERTY:
			getProperty().clear();
			return;
		case Di2Package.DIAGRAM_ELEMENT__IS_VISIBLE:
			setIsVisible(IS_VISIBLE_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__REFERENCE:
			getReference().clear();
			return;
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			setContainer((GraphElement) null);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FONT_FAMILY:
			setFontFamily(FONT_FAMILY_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FONT_SIZE:
			setFontSize(FONT_SIZE_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__LINE_STYLE:
			setLineStyle(LINE_STYLE_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__LINE_THICKNESS:
			setLineThickness(LINE_THICKNESS_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FONT_COLOR:
			setFontColor(FONT_COLOR_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__FOREGROUND_COLOR:
			setForegroundColor(FOREGROUND_COLOR_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__BACKGROUND_COLOR:
			setBackgroundColor(BACKGROUND_COLOR_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__BORDER_COLOR:
			setBorderColor(BORDER_COLOR_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__TRANSLUCENT:
			setTranslucent(TRANSLUCENT_EDEFAULT);
			return;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT:
			setSemanticParent((DiagramElement) null);
			return;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD:
			getSemanticChild().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Di2Package.DIAGRAM_ELEMENT__PROPERTY:
			return property != null && !property.isEmpty();
		case Di2Package.DIAGRAM_ELEMENT__IS_VISIBLE:
			return isVisible != IS_VISIBLE_EDEFAULT;
		case Di2Package.DIAGRAM_ELEMENT__REFERENCE:
			return reference != null && !reference.isEmpty();
		case Di2Package.DIAGRAM_ELEMENT__CONTAINER:
			return getContainer() != null;
		case Di2Package.DIAGRAM_ELEMENT__FONT_FAMILY:
			return FONT_FAMILY_EDEFAULT == null ? fontFamily != null : !FONT_FAMILY_EDEFAULT.equals(fontFamily);
		case Di2Package.DIAGRAM_ELEMENT__FONT_SIZE:
			return fontSize != FONT_SIZE_EDEFAULT;
		case Di2Package.DIAGRAM_ELEMENT__LINE_STYLE:
			return LINE_STYLE_EDEFAULT == null ? lineStyle != null : !LINE_STYLE_EDEFAULT.equals(lineStyle);
		case Di2Package.DIAGRAM_ELEMENT__LINE_THICKNESS:
			return lineThickness != LINE_THICKNESS_EDEFAULT;
		case Di2Package.DIAGRAM_ELEMENT__FONT_COLOR:
			return FONT_COLOR_EDEFAULT == null ? fontColor != null : !FONT_COLOR_EDEFAULT.equals(fontColor);
		case Di2Package.DIAGRAM_ELEMENT__FOREGROUND_COLOR:
			return FOREGROUND_COLOR_EDEFAULT == null ? foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT
					.equals(foregroundColor);
		case Di2Package.DIAGRAM_ELEMENT__BACKGROUND_COLOR:
			return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT
					.equals(backgroundColor);
		case Di2Package.DIAGRAM_ELEMENT__BORDER_COLOR:
			return BORDER_COLOR_EDEFAULT == null ? borderColor != null : !BORDER_COLOR_EDEFAULT.equals(borderColor);
		case Di2Package.DIAGRAM_ELEMENT__TRANSLUCENT:
			return translucent != TRANSLUCENT_EDEFAULT;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_PARENT:
			return semanticParent != null;
		case Di2Package.DIAGRAM_ELEMENT__SEMANTIC_CHILD:
			return semanticChild != null && !semanticChild.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isVisible: ");
		result.append(isVisible);
		result.append(", fontFamily: ");
		result.append(fontFamily);
		result.append(", fontSize: ");
		result.append(fontSize);
		result.append(", lineStyle: ");
		result.append(lineStyle);
		result.append(", lineThickness: ");
		result.append(lineThickness);
		result.append(", fontColor: ");
		result.append(fontColor);
		result.append(", foregroundColor: ");
		result.append(foregroundColor);
		result.append(", backgroundColor: ");
		result.append(backgroundColor);
		result.append(", borderColor: ");
		result.append(borderColor);
		result.append(", translucent: ");
		result.append(translucent);
		result.append(')');
		return result.toString();
	}

} // DiagramElementImpl
