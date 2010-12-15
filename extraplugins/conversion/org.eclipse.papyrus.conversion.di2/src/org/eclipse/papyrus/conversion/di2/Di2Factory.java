/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package
 * @generated
 */
public interface Di2Factory extends EFactory {

	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	Di2Factory eINSTANCE = org.eclipse.papyrus.conversion.di2.impl.Di2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Diagram Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Diagram Element</em>'.
	 * @generated
	 */
	DiagramElement createDiagramElement();

	/**
	 * Returns a new object of class '<em>Graph Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Graph Element</em>'.
	 * @generated
	 */
	GraphElement createGraphElement();

	/**
	 * Returns a new object of class '<em>Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Reference</em>'.
	 * @generated
	 */
	Reference createReference();

	/**
	 * Returns a new object of class '<em>Property</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Graph Edge</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Graph Edge</em>'.
	 * @generated
	 */
	GraphEdge createGraphEdge();

	/**
	 * Returns a new object of class '<em>Graph Connector</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Graph Connector</em>'.
	 * @generated
	 */
	GraphConnector createGraphConnector();

	/**
	 * Returns a new object of class '<em>Graph Node</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Graph Node</em>'.
	 * @generated
	 */
	GraphNode createGraphNode();

	/**
	 * Returns a new object of class '<em>Diagram Link</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Diagram Link</em>'.
	 * @generated
	 */
	DiagramLink createDiagramLink();

	/**
	 * Returns a new object of class '<em>Diagram</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Diagram</em>'.
	 * @generated
	 */
	Diagram createDiagram();

	/**
	 * Returns a new object of class '<em>Semantic Model Bridge</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Semantic Model Bridge</em>'.
	 * @generated
	 */
	SemanticModelBridge createSemanticModelBridge();

	/**
	 * Returns a new object of class '<em>Simple Semantic Model Element</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Simple Semantic Model Element</em>'.
	 * @generated
	 */
	SimpleSemanticModelElement createSimpleSemanticModelElement();

	/**
	 * Returns a new object of class '<em>Uml1 Semantic Model Bridge</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Uml1 Semantic Model Bridge</em>'.
	 * @generated
	 */
	Uml1SemanticModelBridge createUml1SemanticModelBridge();

	/**
	 * Returns a new object of class '<em>Core Semantic Model Bridge</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Core Semantic Model Bridge</em>'.
	 * @generated
	 */
	CoreSemanticModelBridge createCoreSemanticModelBridge();

	/**
	 * Returns a new object of class '<em>Leaf Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Leaf Element</em>'.
	 * @generated
	 */
	LeafElement createLeafElement();

	/**
	 * Returns a new object of class '<em>Text Element</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Text Element</em>'.
	 * @generated
	 */
	TextElement createTextElement();

	/**
	 * Returns a new object of class '<em>Image</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Image</em>'.
	 * @generated
	 */
	Image createImage();

	/**
	 * Returns a new object of class '<em>Graphic Primitive</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Graphic Primitive</em>'.
	 * @generated
	 */
	GraphicPrimitive createGraphicPrimitive();

	/**
	 * Returns a new object of class '<em>Polilyne</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Polilyne</em>'.
	 * @generated
	 */
	Polilyne createPolilyne();

	/**
	 * Returns a new object of class '<em>Ellipse</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Ellipse</em>'.
	 * @generated
	 */
	Ellipse createEllipse();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	Di2Package getDi2Package();

} // Di2Factory
