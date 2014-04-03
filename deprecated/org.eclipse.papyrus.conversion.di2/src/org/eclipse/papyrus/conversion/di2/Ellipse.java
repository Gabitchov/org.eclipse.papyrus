/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.draw2d.geometry.Point;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ellipse</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Ellipse#getCenter <em>Center</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusX <em>Radius X</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusY <em>Radius Y</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Ellipse#getRotation <em>Rotation</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Ellipse#getStartAngle <em>Start Angle</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Ellipse#getEndAngle <em>End Angle</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse()
 * @model
 * @generated
 */
public interface Ellipse extends GraphicPrimitive {

	/**
	 * Returns the value of the '<em><b>Center</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Center</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Center</em>' attribute.
	 * @see #setCenter(Point)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse_Center()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Point"
	 * @generated
	 */
	Point getCenter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Ellipse#getCenter
	 * <em>Center</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Center</em>' attribute.
	 * @see #getCenter()
	 * @generated
	 */
	void setCenter(Point value);

	/**
	 * Returns the value of the '<em><b>Radius X</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius X</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Radius X</em>' attribute.
	 * @see #setRadiusX(double)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse_RadiusX()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getRadiusX();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusX
	 * <em>Radius X</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Radius X</em>' attribute.
	 * @see #getRadiusX()
	 * @generated
	 */
	void setRadiusX(double value);

	/**
	 * Returns the value of the '<em><b>Radius Y</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius Y</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Radius Y</em>' attribute.
	 * @see #setRadiusY(double)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse_RadiusY()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getRadiusY();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusY
	 * <em>Radius Y</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Radius Y</em>' attribute.
	 * @see #getRadiusY()
	 * @generated
	 */
	void setRadiusY(double value);

	/**
	 * Returns the value of the '<em><b>Rotation</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotation</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rotation</em>' attribute.
	 * @see #setRotation(double)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse_Rotation()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getRotation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Ellipse#getRotation
	 * <em>Rotation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(double value);

	/**
	 * Returns the value of the '<em><b>Start Angle</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Angle</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Start Angle</em>' attribute.
	 * @see #setStartAngle(double)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse_StartAngle()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getStartAngle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Ellipse#getStartAngle
	 * <em>Start Angle</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Start Angle</em>' attribute.
	 * @see #getStartAngle()
	 * @generated
	 */
	void setStartAngle(double value);

	/**
	 * Returns the value of the '<em><b>End Angle</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Angle</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>End Angle</em>' attribute.
	 * @see #setEndAngle(double)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getEllipse_EndAngle()
	 * @model dataType="com.cea.papyrus.diagraminterchange2.di2.Double"
	 * @generated
	 */
	double getEndAngle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Ellipse#getEndAngle
	 * <em>End Angle</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>End Angle</em>' attribute.
	 * @see #getEndAngle()
	 * @generated
	 */
	void setEndAngle(double value);

} // Ellipse
