/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Factory
 * @model kind="package"
 * @generated
 */
public interface Di2Package extends EPackage {

	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "di2";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/di2";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "di2";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Di2Package eINSTANCE = org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl
	 * <em>Diagram Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDiagramElement()
	 * @generated
	 */
	int DIAGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__IS_VISIBLE = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__FONT_FAMILY = 4;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__FONT_SIZE = 5;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__LINE_STYLE = 6;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__LINE_THICKNESS = 7;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__FONT_COLOR = 8;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__FOREGROUND_COLOR = 9;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__BACKGROUND_COLOR = 10;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__BORDER_COLOR = 11;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__TRANSLUCENT = 12;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__SEMANTIC_PARENT = 13;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__SEMANTIC_CHILD = 14;

	/**
	 * The number of structural features of the '<em>Diagram Element</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphElementImpl <em>Graph Element</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.GraphElementImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphElement()
	 * @generated
	 */
	int GRAPH_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__PROPERTY = DIAGRAM_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__IS_VISIBLE = DIAGRAM_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__REFERENCE = DIAGRAM_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__CONTAINER = DIAGRAM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__FONT_FAMILY = DIAGRAM_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__FONT_SIZE = DIAGRAM_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__LINE_STYLE = DIAGRAM_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__LINE_THICKNESS = DIAGRAM_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__FONT_COLOR = DIAGRAM_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__FOREGROUND_COLOR = DIAGRAM_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__BACKGROUND_COLOR = DIAGRAM_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__BORDER_COLOR = DIAGRAM_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__TRANSLUCENT = DIAGRAM_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__SEMANTIC_PARENT = DIAGRAM_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__SEMANTIC_CHILD = DIAGRAM_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__CONTAINED = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__LINK = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__SEMANTIC_MODEL = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__POSITION = DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Anchorage</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT__ANCHORAGE = DIAGRAM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Graph Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_ELEMENT_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.ReferenceImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__PROPERTY = DIAGRAM_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_VISIBLE = DIAGRAM_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__REFERENCE = DIAGRAM_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CONTAINER = DIAGRAM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__FONT_FAMILY = DIAGRAM_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__FONT_SIZE = DIAGRAM_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LINE_STYLE = DIAGRAM_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LINE_THICKNESS = DIAGRAM_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__FONT_COLOR = DIAGRAM_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__FOREGROUND_COLOR = DIAGRAM_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__BACKGROUND_COLOR = DIAGRAM_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__BORDER_COLOR = DIAGRAM_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TRANSLUCENT = DIAGRAM_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__SEMANTIC_PARENT = DIAGRAM_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__SEMANTIC_CHILD = DIAGRAM_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Is Individual Representation</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_INDIVIDUAL_REPRESENTATION = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE__REFERENCED = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.conversion.di2.impl.PropertyImpl
	 * <em>Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.PropertyImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphEdgeImpl <em>Graph Edge</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.GraphEdgeImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphEdge()
	 * @generated
	 */
	int GRAPH_EDGE = 4;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__PROPERTY = GRAPH_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__IS_VISIBLE = GRAPH_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__REFERENCE = GRAPH_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__CONTAINER = GRAPH_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__FONT_FAMILY = GRAPH_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__FONT_SIZE = GRAPH_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__LINE_STYLE = GRAPH_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__LINE_THICKNESS = GRAPH_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__FONT_COLOR = GRAPH_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__FOREGROUND_COLOR = GRAPH_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__BACKGROUND_COLOR = GRAPH_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__BORDER_COLOR = GRAPH_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__TRANSLUCENT = GRAPH_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__SEMANTIC_PARENT = GRAPH_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__SEMANTIC_CHILD = GRAPH_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__CONTAINED = GRAPH_ELEMENT__CONTAINED;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__LINK = GRAPH_ELEMENT__LINK;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__SEMANTIC_MODEL = GRAPH_ELEMENT__SEMANTIC_MODEL;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__POSITION = GRAPH_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Anchorage</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__ANCHORAGE = GRAPH_ELEMENT__ANCHORAGE;

	/**
	 * The feature id for the '<em><b>Anchor</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__ANCHOR = GRAPH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Waypoints</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE__WAYPOINTS = GRAPH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Graph Edge</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl
	 * <em>Graph Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphConnector()
	 * @generated
	 */
	int GRAPH_CONNECTOR = 5;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTOR__POSITION = 0;

	/**
	 * The feature id for the '<em><b>Graph Edge</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTOR__GRAPH_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Graph Element</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTOR__GRAPH_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Graph Connector</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_CONNECTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphNodeImpl <em>Graph Node</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.GraphNodeImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphNode()
	 * @generated
	 */
	int GRAPH_NODE = 6;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__PROPERTY = GRAPH_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__IS_VISIBLE = GRAPH_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__REFERENCE = GRAPH_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__CONTAINER = GRAPH_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__FONT_FAMILY = GRAPH_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__FONT_SIZE = GRAPH_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__LINE_STYLE = GRAPH_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__LINE_THICKNESS = GRAPH_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__FONT_COLOR = GRAPH_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__FOREGROUND_COLOR = GRAPH_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__BACKGROUND_COLOR = GRAPH_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__BORDER_COLOR = GRAPH_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__TRANSLUCENT = GRAPH_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__SEMANTIC_PARENT = GRAPH_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__SEMANTIC_CHILD = GRAPH_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__CONTAINED = GRAPH_ELEMENT__CONTAINED;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__LINK = GRAPH_ELEMENT__LINK;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__SEMANTIC_MODEL = GRAPH_ELEMENT__SEMANTIC_MODEL;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__POSITION = GRAPH_ELEMENT__POSITION;

	/**
	 * The feature id for the '<em><b>Anchorage</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__ANCHORAGE = GRAPH_ELEMENT__ANCHORAGE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE__SIZE = GRAPH_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Graph Node</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE_FEATURE_COUNT = GRAPH_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl <em>Diagram Link</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDiagramLink()
	 * @generated
	 */
	int DIAGRAM_LINK = 7;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK__DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Zoom</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK__ZOOM = 1;

	/**
	 * The feature id for the '<em><b>Viewport</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK__VIEWPORT = 2;

	/**
	 * The feature id for the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK__GRAPH_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Diagram Link</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LINK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.conversion.di2.impl.DiagramImpl
	 * <em>Diagram</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.DiagramImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 8;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__PROPERTY = GRAPH_NODE__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__IS_VISIBLE = GRAPH_NODE__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__REFERENCE = GRAPH_NODE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__CONTAINER = GRAPH_NODE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__FONT_FAMILY = GRAPH_NODE__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__FONT_SIZE = GRAPH_NODE__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__LINE_STYLE = GRAPH_NODE__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__LINE_THICKNESS = GRAPH_NODE__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__FONT_COLOR = GRAPH_NODE__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__FOREGROUND_COLOR = GRAPH_NODE__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__BACKGROUND_COLOR = GRAPH_NODE__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__BORDER_COLOR = GRAPH_NODE__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__TRANSLUCENT = GRAPH_NODE__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__SEMANTIC_PARENT = GRAPH_NODE__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__SEMANTIC_CHILD = GRAPH_NODE__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Contained</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__CONTAINED = GRAPH_NODE__CONTAINED;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__LINK = GRAPH_NODE__LINK;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__SEMANTIC_MODEL = GRAPH_NODE__SEMANTIC_MODEL;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__POSITION = GRAPH_NODE__POSITION;

	/**
	 * The feature id for the '<em><b>Anchorage</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__ANCHORAGE = GRAPH_NODE__ANCHORAGE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__SIZE = GRAPH_NODE__SIZE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__OWNER = GRAPH_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__NAME = GRAPH_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Zoom</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__ZOOM = GRAPH_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Viewport</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__VIEWPORT = GRAPH_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Diagram Link</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__DIAGRAM_LINK = GRAPH_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__TYPE = GRAPH_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = GRAPH_NODE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.SemanticModelBridgeImpl
	 * <em>Semantic Model Bridge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.SemanticModelBridgeImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getSemanticModelBridge()
	 * @generated
	 */
	int SEMANTIC_MODEL_BRIDGE = 9;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_MODEL_BRIDGE__PRESENTATION = 0;

	/**
	 * The feature id for the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Semantic Model Bridge</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.SimpleSemanticModelElementImpl
	 * <em>Simple Semantic Model Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.SimpleSemanticModelElementImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getSimpleSemanticModelElement()
	 * @generated
	 */
	int SIMPLE_SEMANTIC_MODEL_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEMANTIC_MODEL_ELEMENT__PRESENTATION = SEMANTIC_MODEL_BRIDGE__PRESENTATION;

	/**
	 * The feature id for the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEMANTIC_MODEL_ELEMENT__GRAPH_ELEMENT = SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT;

	/**
	 * The feature id for the '<em><b>Typeinfo</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Semantic Model Element</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEMANTIC_MODEL_ELEMENT_FEATURE_COUNT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.Uml1SemanticModelBridgeImpl
	 * <em>Uml1 Semantic Model Bridge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.Uml1SemanticModelBridgeImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getUml1SemanticModelBridge()
	 * @generated
	 */
	int UML1_SEMANTIC_MODEL_BRIDGE = 11;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML1_SEMANTIC_MODEL_BRIDGE__PRESENTATION = SEMANTIC_MODEL_BRIDGE__PRESENTATION;

	/**
	 * The feature id for the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML1_SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML1_SEMANTIC_MODEL_BRIDGE__ELEMENT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Uml1 Semantic Model Bridge</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UML1_SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.CoreSemanticModelBridgeImpl
	 * <em>Core Semantic Model Bridge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.CoreSemanticModelBridgeImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getCoreSemanticModelBridge()
	 * @generated
	 */
	int CORE_SEMANTIC_MODEL_BRIDGE = 12;

	/**
	 * The feature id for the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORE_SEMANTIC_MODEL_BRIDGE__PRESENTATION = SEMANTIC_MODEL_BRIDGE__PRESENTATION;

	/**
	 * The feature id for the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORE_SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT;

	/**
	 * The number of structural features of the '<em>Core Semantic Model Bridge</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CORE_SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT = SEMANTIC_MODEL_BRIDGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.LeafElementImpl <em>Leaf Element</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.LeafElementImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getLeafElement()
	 * @generated
	 */
	int LEAF_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__PROPERTY = DIAGRAM_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__IS_VISIBLE = DIAGRAM_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__REFERENCE = DIAGRAM_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__CONTAINER = DIAGRAM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__FONT_FAMILY = DIAGRAM_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__FONT_SIZE = DIAGRAM_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__LINE_STYLE = DIAGRAM_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__LINE_THICKNESS = DIAGRAM_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__FONT_COLOR = DIAGRAM_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__FOREGROUND_COLOR = DIAGRAM_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__BACKGROUND_COLOR = DIAGRAM_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__BORDER_COLOR = DIAGRAM_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__TRANSLUCENT = DIAGRAM_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__SEMANTIC_PARENT = DIAGRAM_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT__SEMANTIC_CHILD = DIAGRAM_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The number of structural features of the '<em>Leaf Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LEAF_ELEMENT_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.TextElementImpl <em>Text Element</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.TextElementImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getTextElement()
	 * @generated
	 */
	int TEXT_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__PROPERTY = LEAF_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__IS_VISIBLE = LEAF_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__REFERENCE = LEAF_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__CONTAINER = LEAF_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__FONT_FAMILY = LEAF_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__FONT_SIZE = LEAF_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__LINE_STYLE = LEAF_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__LINE_THICKNESS = LEAF_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__FONT_COLOR = LEAF_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__FOREGROUND_COLOR = LEAF_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__BACKGROUND_COLOR = LEAF_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__BORDER_COLOR = LEAF_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__TRANSLUCENT = LEAF_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__SEMANTIC_PARENT = LEAF_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__SEMANTIC_CHILD = LEAF_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT__TEXT = LEAF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEXT_ELEMENT_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.conversion.di2.impl.ImageImpl
	 * <em>Image</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.ImageImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 15;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__PROPERTY = LEAF_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__IS_VISIBLE = LEAF_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__REFERENCE = LEAF_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__CONTAINER = LEAF_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__FONT_FAMILY = LEAF_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__FONT_SIZE = LEAF_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__LINE_STYLE = LEAF_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__LINE_THICKNESS = LEAF_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__FONT_COLOR = LEAF_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__FOREGROUND_COLOR = LEAF_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__BACKGROUND_COLOR = LEAF_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__BORDER_COLOR = LEAF_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__TRANSLUCENT = LEAF_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__SEMANTIC_PARENT = LEAF_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__SEMANTIC_CHILD = LEAF_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__URI = LEAF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mime Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE__MIME_TYPE = LEAF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphicPrimitiveImpl
	 * <em>Graphic Primitive</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.GraphicPrimitiveImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphicPrimitive()
	 * @generated
	 */
	int GRAPHIC_PRIMITIVE = 16;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__PROPERTY = LEAF_ELEMENT__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__IS_VISIBLE = LEAF_ELEMENT__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__REFERENCE = LEAF_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__CONTAINER = LEAF_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__FONT_FAMILY = LEAF_ELEMENT__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__FONT_SIZE = LEAF_ELEMENT__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__LINE_STYLE = LEAF_ELEMENT__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__LINE_THICKNESS = LEAF_ELEMENT__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__FONT_COLOR = LEAF_ELEMENT__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__FOREGROUND_COLOR = LEAF_ELEMENT__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__BACKGROUND_COLOR = LEAF_ELEMENT__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__BORDER_COLOR = LEAF_ELEMENT__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__TRANSLUCENT = LEAF_ELEMENT__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__SEMANTIC_PARENT = LEAF_ELEMENT__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE__SEMANTIC_CHILD = LEAF_ELEMENT__SEMANTIC_CHILD;

	/**
	 * The number of structural features of the '<em>Graphic Primitive</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GRAPHIC_PRIMITIVE_FEATURE_COUNT = LEAF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.conversion.di2.impl.PolilyneImpl
	 * <em>Polilyne</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.PolilyneImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getPolilyne()
	 * @generated
	 */
	int POLILYNE = 17;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__PROPERTY = GRAPHIC_PRIMITIVE__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__IS_VISIBLE = GRAPHIC_PRIMITIVE__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__REFERENCE = GRAPHIC_PRIMITIVE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__CONTAINER = GRAPHIC_PRIMITIVE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__FONT_FAMILY = GRAPHIC_PRIMITIVE__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__FONT_SIZE = GRAPHIC_PRIMITIVE__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__LINE_STYLE = GRAPHIC_PRIMITIVE__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__LINE_THICKNESS = GRAPHIC_PRIMITIVE__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__FONT_COLOR = GRAPHIC_PRIMITIVE__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__FOREGROUND_COLOR = GRAPHIC_PRIMITIVE__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__BACKGROUND_COLOR = GRAPHIC_PRIMITIVE__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__BORDER_COLOR = GRAPHIC_PRIMITIVE__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__TRANSLUCENT = GRAPHIC_PRIMITIVE__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__SEMANTIC_PARENT = GRAPHIC_PRIMITIVE__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__SEMANTIC_CHILD = GRAPHIC_PRIMITIVE__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Waypoints</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__WAYPOINTS = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Closed</b></em>' attribute list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE__CLOSED = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Polilyne</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int POLILYNE_FEATURE_COUNT = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.conversion.di2.impl.EllipseImpl
	 * <em>Ellipse</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.EllipseImpl
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getEllipse()
	 * @generated
	 */
	int ELLIPSE = 18;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__PROPERTY = GRAPHIC_PRIMITIVE__PROPERTY;

	/**
	 * The feature id for the '<em><b>Is Visible</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__IS_VISIBLE = GRAPHIC_PRIMITIVE__IS_VISIBLE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__REFERENCE = GRAPHIC_PRIMITIVE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__CONTAINER = GRAPHIC_PRIMITIVE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Font Family</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__FONT_FAMILY = GRAPHIC_PRIMITIVE__FONT_FAMILY;

	/**
	 * The feature id for the '<em><b>Font Size</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__FONT_SIZE = GRAPHIC_PRIMITIVE__FONT_SIZE;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__LINE_STYLE = GRAPHIC_PRIMITIVE__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Thickness</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__LINE_THICKNESS = GRAPHIC_PRIMITIVE__LINE_THICKNESS;

	/**
	 * The feature id for the '<em><b>Font Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__FONT_COLOR = GRAPHIC_PRIMITIVE__FONT_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__FOREGROUND_COLOR = GRAPHIC_PRIMITIVE__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__BACKGROUND_COLOR = GRAPHIC_PRIMITIVE__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__BORDER_COLOR = GRAPHIC_PRIMITIVE__BORDER_COLOR;

	/**
	 * The feature id for the '<em><b>Translucent</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__TRANSLUCENT = GRAPHIC_PRIMITIVE__TRANSLUCENT;

	/**
	 * The feature id for the '<em><b>Semantic Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__SEMANTIC_PARENT = GRAPHIC_PRIMITIVE__SEMANTIC_PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Child</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__SEMANTIC_CHILD = GRAPHIC_PRIMITIVE__SEMANTIC_CHILD;

	/**
	 * The feature id for the '<em><b>Center</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__CENTER = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Radius X</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__RADIUS_X = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Radius Y</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__RADIUS_Y = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__ROTATION = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start Angle</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__START_ANGLE = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End Angle</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__END_ANGLE = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Ellipse</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELLIPSE_FEATURE_COUNT = GRAPHIC_PRIMITIVE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration
	 * <em>Papyrus Key Enumeration</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getPapyrusKeyEnumeration()
	 * @generated
	 */
	int PAPYRUS_KEY_ENUMERATION = 19;

	/**
	 * The meta object id for the '<em>Point</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.draw2d.geometry.Point
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 20;

	/**
	 * The meta object id for the '<em>Dimension</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.draw2d.geometry.Dimension
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 21;

	/**
	 * The meta object id for the '<em>Double</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDouble()
	 * @generated
	 */
	int DOUBLE = 22;

	/**
	 * The meta object id for the '<em>RGB</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.graphics.RGB
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getRGB()
	 * @generated
	 */
	int RGB = 23;

	/**
	 * The meta object id for the '<em>String</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.String
	 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getString()
	 * @generated
	 */
	int STRING = 24;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Diagram Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement
	 * @generated
	 */
	EClass getDiagramElement();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getProperty <em>Property</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getProperty()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_Property();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#isIsVisible
	 * <em>Is Visible</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Visible</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#isIsVisible()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_IsVisible();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getReference
	 * <em>Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getReference()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_Reference();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getContainer
	 * <em>Container</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getContainer()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_Container();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getFontFamily
	 * <em>Font Family</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Font Family</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getFontFamily()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_FontFamily();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getFontSize <em>Font Size</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Font Size</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getFontSize()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_FontSize();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getLineStyle
	 * <em>Line Style</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Line Style</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getLineStyle()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_LineStyle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getLineThickness
	 * <em>Line Thickness</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Line Thickness</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getLineThickness()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_LineThickness();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getFontColor
	 * <em>Font Color</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Font Color</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getFontColor()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_FontColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getForegroundColor
	 * <em>Foreground Color</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Foreground Color</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getForegroundColor()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_ForegroundColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getBackgroundColor
	 * <em>Background Color</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Background Color</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getBackgroundColor()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_BackgroundColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getBorderColor
	 * <em>Border Color</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Border Color</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getBorderColor()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_BorderColor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#isTranslucent
	 * <em>Translucent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Translucent</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#isTranslucent()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_Translucent();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getSemanticParent
	 * <em>Semantic Parent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Semantic Parent</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getSemanticParent()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_SemanticParent();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramElement#getSemanticChild
	 * <em>Semantic Child</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Semantic Child</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramElement#getSemanticChild()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_SemanticChild();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement <em>Graph Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Graph Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement
	 * @generated
	 */
	EClass getGraphElement();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getContained <em>Contained</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Contained</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement#getContained()
	 * @see #getGraphElement()
	 * @generated
	 */
	EReference getGraphElement_Contained();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getLink <em>Link</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement#getLink()
	 * @see #getGraphElement()
	 * @generated
	 */
	EReference getGraphElement_Link();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getSemanticModel
	 * <em>Semantic Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Semantic Model</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement#getSemanticModel()
	 * @see #getGraphElement()
	 * @generated
	 */
	EReference getGraphElement_SemanticModel();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement#getPosition()
	 * @see #getGraphElement()
	 * @generated
	 */
	EAttribute getGraphElement_Position();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphElement#getAnchorage <em>Anchorage</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Anchorage</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphElement#getAnchorage()
	 * @see #getGraphElement()
	 * @generated
	 */
	EReference getGraphElement_Anchorage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.Reference
	 * <em>Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Reference#isIsIndividualRepresentation
	 * <em>Is Individual Representation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Individual Representation</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Reference#isIsIndividualRepresentation()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_IsIndividualRepresentation();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.conversion.di2.Reference#getReferenced <em>Referenced</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referenced</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Reference#getReferenced()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Referenced();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.Property
	 * <em>Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Property#getKey <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Property#getKey()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Key();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Property#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.GraphEdge
	 * <em>Graph Edge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Graph Edge</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphEdge
	 * @generated
	 */
	EClass getGraphEdge();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphEdge#getAnchor <em>Anchor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Anchor</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphEdge#getAnchor()
	 * @see #getGraphEdge()
	 * @generated
	 */
	EReference getGraphEdge_Anchor();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphEdge#getWaypoints <em>Waypoints</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Waypoints</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphEdge#getWaypoints()
	 * @see #getGraphEdge()
	 * @generated
	 */
	EAttribute getGraphEdge_Waypoints();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector <em>Graph Connector</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Graph Connector</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphConnector
	 * @generated
	 */
	EClass getGraphConnector();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector#getPosition <em>Position</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphConnector#getPosition()
	 * @see #getGraphConnector()
	 * @generated
	 */
	EAttribute getGraphConnector_Position();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphEdge
	 * <em>Graph Edge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Graph Edge</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphEdge()
	 * @see #getGraphConnector()
	 * @generated
	 */
	EReference getGraphConnector_GraphEdge();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphElement
	 * <em>Graph Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Graph Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphConnector#getGraphElement()
	 * @see #getGraphConnector()
	 * @generated
	 */
	EReference getGraphConnector_GraphElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.GraphNode
	 * <em>Graph Node</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Graph Node</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphNode
	 * @generated
	 */
	EClass getGraphNode();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphNode#getSize <em>Size</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphNode#getSize()
	 * @see #getGraphNode()
	 * @generated
	 */
	EAttribute getGraphNode_Size();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink <em>Diagram Link</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Diagram Link</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramLink
	 * @generated
	 */
	EClass getDiagramLink();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Diagram</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramLink#getDiagram()
	 * @see #getDiagramLink()
	 * @generated
	 */
	EReference getDiagramLink_Diagram();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink#getZoom <em>Zoom</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Zoom</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramLink#getZoom()
	 * @see #getDiagramLink()
	 * @generated
	 */
	EAttribute getDiagramLink_Zoom();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink#getViewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Viewport</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramLink#getViewport()
	 * @see #getDiagramLink()
	 * @generated
	 */
	EAttribute getDiagramLink_Viewport();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.conversion.di2.DiagramLink#getGraphElement
	 * <em>Graph Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Graph Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.DiagramLink#getGraphElement()
	 * @see #getDiagramLink()
	 * @generated
	 */
	EReference getDiagramLink_GraphElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.Diagram
	 * <em>Diagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.conversion.di2.Diagram#getOwner <em>Owner</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram#getOwner()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Owner();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Diagram#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram#getName()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Diagram#getZoom <em>Zoom</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Zoom</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram#getZoom()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Zoom();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Diagram#getViewport <em>Viewport</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Viewport</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram#getViewport()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Viewport();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.conversion.di2.Diagram#getDiagramLink <em>Diagram Link</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Diagram Link</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram#getDiagramLink()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_DiagramLink();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Diagram#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Diagram#getType()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Type();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge
	 * <em>Semantic Model Bridge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Semantic Model Bridge</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.SemanticModelBridge
	 * @generated
	 */
	EClass getSemanticModelBridge();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getPresentation
	 * <em>Presentation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Presentation</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getPresentation()
	 * @see #getSemanticModelBridge()
	 * @generated
	 */
	EAttribute getSemanticModelBridge_Presentation();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getGraphElement
	 * <em>Graph Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Graph Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getGraphElement()
	 * @see #getSemanticModelBridge()
	 * @generated
	 */
	EReference getSemanticModelBridge_GraphElement();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.SimpleSemanticModelElement
	 * <em>Simple Semantic Model Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Simple Semantic Model Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.SimpleSemanticModelElement
	 * @generated
	 */
	EClass getSimpleSemanticModelElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.SimpleSemanticModelElement#getTypeinfo
	 * <em>Typeinfo</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Typeinfo</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.SimpleSemanticModelElement#getTypeinfo()
	 * @see #getSimpleSemanticModelElement()
	 * @generated
	 */
	EAttribute getSimpleSemanticModelElement_Typeinfo();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.Uml1SemanticModelBridge
	 * <em>Uml1 Semantic Model Bridge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Uml1 Semantic Model Bridge</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Uml1SemanticModelBridge
	 * @generated
	 */
	EClass getUml1SemanticModelBridge();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.conversion.di2.Uml1SemanticModelBridge#getElement
	 * <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Uml1SemanticModelBridge#getElement()
	 * @see #getUml1SemanticModelBridge()
	 * @generated
	 */
	EReference getUml1SemanticModelBridge_Element();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.CoreSemanticModelBridge
	 * <em>Core Semantic Model Bridge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Core Semantic Model Bridge</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.CoreSemanticModelBridge
	 * @generated
	 */
	EClass getCoreSemanticModelBridge();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.LeafElement <em>Leaf Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Leaf Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.LeafElement
	 * @generated
	 */
	EClass getLeafElement();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.TextElement <em>Text Element</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Text Element</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.TextElement
	 * @generated
	 */
	EClass getTextElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.TextElement#getText <em>Text</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.TextElement#getText()
	 * @see #getTextElement()
	 * @generated
	 */
	EAttribute getTextElement_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.Image
	 * <em>Image</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Image#getUri <em>Uri</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Image#getUri()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Uri();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Image#getMimeType <em>Mime Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Mime Type</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Image#getMimeType()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_MimeType();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.conversion.di2.GraphicPrimitive <em>Graphic Primitive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Graphic Primitive</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.GraphicPrimitive
	 * @generated
	 */
	EClass getGraphicPrimitive();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.Polilyne
	 * <em>Polilyne</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Polilyne</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Polilyne
	 * @generated
	 */
	EClass getPolilyne();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.papyrus.conversion.di2.Polilyne#getWaypoints <em>Waypoints</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Waypoints</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Polilyne#getWaypoints()
	 * @see #getPolilyne()
	 * @generated
	 */
	EAttribute getPolilyne_Waypoints();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.papyrus.conversion.di2.Polilyne#getClosed <em>Closed</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Closed</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Polilyne#getClosed()
	 * @see #getPolilyne()
	 * @generated
	 */
	EAttribute getPolilyne_Closed();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.conversion.di2.Ellipse
	 * <em>Ellipse</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ellipse</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse
	 * @generated
	 */
	EClass getEllipse();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Ellipse#getCenter <em>Center</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Center</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse#getCenter()
	 * @see #getEllipse()
	 * @generated
	 */
	EAttribute getEllipse_Center();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusX <em>Radius X</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Radius X</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusX()
	 * @see #getEllipse()
	 * @generated
	 */
	EAttribute getEllipse_RadiusX();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusY <em>Radius Y</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Radius Y</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse#getRadiusY()
	 * @see #getEllipse()
	 * @generated
	 */
	EAttribute getEllipse_RadiusY();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Ellipse#getRotation <em>Rotation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse#getRotation()
	 * @see #getEllipse()
	 * @generated
	 */
	EAttribute getEllipse_Rotation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Ellipse#getStartAngle <em>Start Angle</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Start Angle</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse#getStartAngle()
	 * @see #getEllipse()
	 * @generated
	 */
	EAttribute getEllipse_StartAngle();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.conversion.di2.Ellipse#getEndAngle <em>End Angle</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>End Angle</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.Ellipse#getEndAngle()
	 * @see #getEllipse()
	 * @generated
	 */
	EAttribute getEllipse_EndAngle();

	/**
	 * Returns the meta object for enum '
	 * {@link org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration
	 * <em>Papyrus Key Enumeration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Papyrus Key Enumeration</em>'.
	 * @see org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration
	 * @generated
	 */
	EEnum getPapyrusKeyEnumeration();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Point
	 * <em>Point</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Point</em>'.
	 * @see org.eclipse.draw2d.geometry.Point
	 * @model instanceClass="org.eclipse.draw2d.geometry.Point"
	 * @generated
	 */
	EDataType getPoint();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Dimension
	 * <em>Dimension</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Dimension</em>'.
	 * @see org.eclipse.draw2d.geometry.Dimension
	 * @model instanceClass="org.eclipse.draw2d.geometry.Dimension"
	 * @generated
	 */
	EDataType getDimension();

	/**
	 * Returns the meta object for data type '<em>Double</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Double</em>'.
	 * @model instanceClass="double"
	 * @generated
	 */
	EDataType getDouble();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.RGB <em>RGB</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>RGB</em>'.
	 * @see org.eclipse.swt.graphics.RGB
	 * @model instanceClass="org.eclipse.swt.graphics.RGB"
	 * @generated
	 */
	EDataType getRGB();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>String</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Di2Factory getDi2Factory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl
		 * <em>Diagram Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.DiagramElementImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDiagramElement()
		 * @generated
		 */
		EClass DIAGRAM_ELEMENT = eINSTANCE.getDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__PROPERTY = eINSTANCE.getDiagramElement_Property();

		/**
		 * The meta object literal for the '<em><b>Is Visible</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__IS_VISIBLE = eINSTANCE.getDiagramElement_IsVisible();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__REFERENCE = eINSTANCE.getDiagramElement_Reference();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__CONTAINER = eINSTANCE.getDiagramElement_Container();

		/**
		 * The meta object literal for the '<em><b>Font Family</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__FONT_FAMILY = eINSTANCE.getDiagramElement_FontFamily();

		/**
		 * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__FONT_SIZE = eINSTANCE.getDiagramElement_FontSize();

		/**
		 * The meta object literal for the '<em><b>Line Style</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__LINE_STYLE = eINSTANCE.getDiagramElement_LineStyle();

		/**
		 * The meta object literal for the '<em><b>Line Thickness</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__LINE_THICKNESS = eINSTANCE.getDiagramElement_LineThickness();

		/**
		 * The meta object literal for the '<em><b>Font Color</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__FONT_COLOR = eINSTANCE.getDiagramElement_FontColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__FOREGROUND_COLOR = eINSTANCE.getDiagramElement_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__BACKGROUND_COLOR = eINSTANCE.getDiagramElement_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Border Color</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__BORDER_COLOR = eINSTANCE.getDiagramElement_BorderColor();

		/**
		 * The meta object literal for the '<em><b>Translucent</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__TRANSLUCENT = eINSTANCE.getDiagramElement_Translucent();

		/**
		 * The meta object literal for the '<em><b>Semantic Parent</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__SEMANTIC_PARENT = eINSTANCE.getDiagramElement_SemanticParent();

		/**
		 * The meta object literal for the '<em><b>Semantic Child</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__SEMANTIC_CHILD = eINSTANCE.getDiagramElement_SemanticChild();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphElementImpl
		 * <em>Graph Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.GraphElementImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphElement()
		 * @generated
		 */
		EClass GRAPH_ELEMENT = eINSTANCE.getGraphElement();

		/**
		 * The meta object literal for the '<em><b>Contained</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_ELEMENT__CONTAINED = eINSTANCE.getGraphElement_Contained();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_ELEMENT__LINK = eINSTANCE.getGraphElement_Link();

		/**
		 * The meta object literal for the '<em><b>Semantic Model</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_ELEMENT__SEMANTIC_MODEL = eINSTANCE.getGraphElement_SemanticModel();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRAPH_ELEMENT__POSITION = eINSTANCE.getGraphElement_Position();

		/**
		 * The meta object literal for the '<em><b>Anchorage</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_ELEMENT__ANCHORAGE = eINSTANCE.getGraphElement_Anchorage();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.ReferenceImpl <em>Reference</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.ReferenceImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Is Individual Representation</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE__IS_INDIVIDUAL_REPRESENTATION = eINSTANCE.getReference_IsIndividualRepresentation();

		/**
		 * The meta object literal for the '<em><b>Referenced</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REFERENCE__REFERENCED = eINSTANCE.getReference_Referenced();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.PropertyImpl <em>Property</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.PropertyImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__KEY = eINSTANCE.getProperty_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphEdgeImpl <em>Graph Edge</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.GraphEdgeImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphEdge()
		 * @generated
		 */
		EClass GRAPH_EDGE = eINSTANCE.getGraphEdge();

		/**
		 * The meta object literal for the '<em><b>Anchor</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_EDGE__ANCHOR = eINSTANCE.getGraphEdge_Anchor();

		/**
		 * The meta object literal for the '<em><b>Waypoints</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRAPH_EDGE__WAYPOINTS = eINSTANCE.getGraphEdge_Waypoints();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl
		 * <em>Graph Connector</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.GraphConnectorImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphConnector()
		 * @generated
		 */
		EClass GRAPH_CONNECTOR = eINSTANCE.getGraphConnector();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRAPH_CONNECTOR__POSITION = eINSTANCE.getGraphConnector_Position();

		/**
		 * The meta object literal for the '<em><b>Graph Edge</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_CONNECTOR__GRAPH_EDGE = eINSTANCE.getGraphConnector_GraphEdge();

		/**
		 * The meta object literal for the '<em><b>Graph Element</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GRAPH_CONNECTOR__GRAPH_ELEMENT = eINSTANCE.getGraphConnector_GraphElement();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphNodeImpl <em>Graph Node</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.GraphNodeImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphNode()
		 * @generated
		 */
		EClass GRAPH_NODE = eINSTANCE.getGraphNode();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GRAPH_NODE__SIZE = eINSTANCE.getGraphNode_Size();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl
		 * <em>Diagram Link</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.DiagramLinkImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDiagramLink()
		 * @generated
		 */
		EClass DIAGRAM_LINK = eINSTANCE.getDiagramLink();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_LINK__DIAGRAM = eINSTANCE.getDiagramLink_Diagram();

		/**
		 * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_LINK__ZOOM = eINSTANCE.getDiagramLink_Zoom();

		/**
		 * The meta object literal for the '<em><b>Viewport</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM_LINK__VIEWPORT = eINSTANCE.getDiagramLink_Viewport();

		/**
		 * The meta object literal for the '<em><b>Graph Element</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM_LINK__GRAPH_ELEMENT = eINSTANCE.getDiagramLink_GraphElement();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.DiagramImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM__OWNER = eINSTANCE.getDiagram_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM__NAME = eINSTANCE.getDiagram_Name();

		/**
		 * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM__ZOOM = eINSTANCE.getDiagram_Zoom();

		/**
		 * The meta object literal for the '<em><b>Viewport</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM__VIEWPORT = eINSTANCE.getDiagram_Viewport();

		/**
		 * The meta object literal for the '<em><b>Diagram Link</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIAGRAM__DIAGRAM_LINK = eINSTANCE.getDiagram_DiagramLink();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DIAGRAM__TYPE = eINSTANCE.getDiagram_Type();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.SemanticModelBridgeImpl
		 * <em>Semantic Model Bridge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.SemanticModelBridgeImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getSemanticModelBridge()
		 * @generated
		 */
		EClass SEMANTIC_MODEL_BRIDGE = eINSTANCE.getSemanticModelBridge();

		/**
		 * The meta object literal for the '<em><b>Presentation</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SEMANTIC_MODEL_BRIDGE__PRESENTATION = eINSTANCE.getSemanticModelBridge_Presentation();

		/**
		 * The meta object literal for the '<em><b>Graph Element</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SEMANTIC_MODEL_BRIDGE__GRAPH_ELEMENT = eINSTANCE.getSemanticModelBridge_GraphElement();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.SimpleSemanticModelElementImpl
		 * <em>Simple Semantic Model Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.SimpleSemanticModelElementImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getSimpleSemanticModelElement()
		 * @generated
		 */
		EClass SIMPLE_SEMANTIC_MODEL_ELEMENT = eINSTANCE.getSimpleSemanticModelElement();

		/**
		 * The meta object literal for the '<em><b>Typeinfo</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SIMPLE_SEMANTIC_MODEL_ELEMENT__TYPEINFO = eINSTANCE.getSimpleSemanticModelElement_Typeinfo();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.Uml1SemanticModelBridgeImpl
		 * <em>Uml1 Semantic Model Bridge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.Uml1SemanticModelBridgeImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getUml1SemanticModelBridge()
		 * @generated
		 */
		EClass UML1_SEMANTIC_MODEL_BRIDGE = eINSTANCE.getUml1SemanticModelBridge();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UML1_SEMANTIC_MODEL_BRIDGE__ELEMENT = eINSTANCE.getUml1SemanticModelBridge_Element();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.CoreSemanticModelBridgeImpl
		 * <em>Core Semantic Model Bridge</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.CoreSemanticModelBridgeImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getCoreSemanticModelBridge()
		 * @generated
		 */
		EClass CORE_SEMANTIC_MODEL_BRIDGE = eINSTANCE.getCoreSemanticModelBridge();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.LeafElementImpl
		 * <em>Leaf Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.LeafElementImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getLeafElement()
		 * @generated
		 */
		EClass LEAF_ELEMENT = eINSTANCE.getLeafElement();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.TextElementImpl
		 * <em>Text Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.TextElementImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getTextElement()
		 * @generated
		 */
		EClass TEXT_ELEMENT = eINSTANCE.getTextElement();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEXT_ELEMENT__TEXT = eINSTANCE.getTextElement_Text();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.ImageImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IMAGE__URI = eINSTANCE.getImage_Uri();

		/**
		 * The meta object literal for the '<em><b>Mime Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IMAGE__MIME_TYPE = eINSTANCE.getImage_MimeType();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.GraphicPrimitiveImpl
		 * <em>Graphic Primitive</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.GraphicPrimitiveImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getGraphicPrimitive()
		 * @generated
		 */
		EClass GRAPHIC_PRIMITIVE = eINSTANCE.getGraphicPrimitive();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.PolilyneImpl <em>Polilyne</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.PolilyneImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getPolilyne()
		 * @generated
		 */
		EClass POLILYNE = eINSTANCE.getPolilyne();

		/**
		 * The meta object literal for the '<em><b>Waypoints</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute POLILYNE__WAYPOINTS = eINSTANCE.getPolilyne_Waypoints();

		/**
		 * The meta object literal for the '<em><b>Closed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute POLILYNE__CLOSED = eINSTANCE.getPolilyne_Closed();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.impl.EllipseImpl <em>Ellipse</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.EllipseImpl
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getEllipse()
		 * @generated
		 */
		EClass ELLIPSE = eINSTANCE.getEllipse();

		/**
		 * The meta object literal for the '<em><b>Center</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELLIPSE__CENTER = eINSTANCE.getEllipse_Center();

		/**
		 * The meta object literal for the '<em><b>Radius X</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELLIPSE__RADIUS_X = eINSTANCE.getEllipse_RadiusX();

		/**
		 * The meta object literal for the '<em><b>Radius Y</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELLIPSE__RADIUS_Y = eINSTANCE.getEllipse_RadiusY();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELLIPSE__ROTATION = eINSTANCE.getEllipse_Rotation();

		/**
		 * The meta object literal for the '<em><b>Start Angle</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELLIPSE__START_ANGLE = eINSTANCE.getEllipse_StartAngle();

		/**
		 * The meta object literal for the '<em><b>End Angle</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELLIPSE__END_ANGLE = eINSTANCE.getEllipse_EndAngle();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration
		 * <em>Papyrus Key Enumeration</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.PapyrusKeyEnumeration
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getPapyrusKeyEnumeration()
		 * @generated
		 */
		EEnum PAPYRUS_KEY_ENUMERATION = eINSTANCE.getPapyrusKeyEnumeration();

		/**
		 * The meta object literal for the '<em>Point</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.draw2d.geometry.Point
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getPoint()
		 * @generated
		 */
		EDataType POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em>Dimension</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.draw2d.geometry.Dimension
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDimension()
		 * @generated
		 */
		EDataType DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em>Double</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getDouble()
		 * @generated
		 */
		EDataType DOUBLE = eINSTANCE.getDouble();

		/**
		 * The meta object literal for the '<em>RGB</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.graphics.RGB
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getRGB()
		 * @generated
		 */
		EDataType RGB = eINSTANCE.getRGB();

		/**
		 * The meta object literal for the '<em>String</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.lang.String
		 * @see org.eclipse.papyrus.conversion.di2.impl.Di2PackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

	}

} // Di2Package
