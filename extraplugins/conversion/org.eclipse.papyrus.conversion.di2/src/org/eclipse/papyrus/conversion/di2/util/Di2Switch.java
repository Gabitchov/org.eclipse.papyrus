/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2.util;


import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.conversion.di2.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package
 * @generated
 */
public class Di2Switch<T> {

	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static Di2Package modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Di2Switch() {
		if (modelPackage == null) {
			modelPackage = Di2Package.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case Di2Package.DIAGRAM_ELEMENT: {
			DiagramElement diagramElement = (DiagramElement) theEObject;
			T result = caseDiagramElement(diagramElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.GRAPH_ELEMENT: {
			GraphElement graphElement = (GraphElement) theEObject;
			T result = caseGraphElement(graphElement);
			if (result == null)
				result = caseDiagramElement(graphElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.REFERENCE: {
			Reference reference = (Reference) theEObject;
			T result = caseReference(reference);
			if (result == null)
				result = caseDiagramElement(reference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.PROPERTY: {
			Property property = (Property) theEObject;
			T result = caseProperty(property);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.GRAPH_EDGE: {
			GraphEdge graphEdge = (GraphEdge) theEObject;
			T result = caseGraphEdge(graphEdge);
			if (result == null)
				result = caseGraphElement(graphEdge);
			if (result == null)
				result = caseDiagramElement(graphEdge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.GRAPH_CONNECTOR: {
			GraphConnector graphConnector = (GraphConnector) theEObject;
			T result = caseGraphConnector(graphConnector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.GRAPH_NODE: {
			GraphNode graphNode = (GraphNode) theEObject;
			T result = caseGraphNode(graphNode);
			if (result == null)
				result = caseGraphElement(graphNode);
			if (result == null)
				result = caseDiagramElement(graphNode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.DIAGRAM_LINK: {
			DiagramLink diagramLink = (DiagramLink) theEObject;
			T result = caseDiagramLink(diagramLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.DIAGRAM: {
			Diagram diagram = (Diagram) theEObject;
			T result = caseDiagram(diagram);
			if (result == null)
				result = caseGraphNode(diagram);
			if (result == null)
				result = caseGraphElement(diagram);
			if (result == null)
				result = caseDiagramElement(diagram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.SEMANTIC_MODEL_BRIDGE: {
			SemanticModelBridge semanticModelBridge = (SemanticModelBridge) theEObject;
			T result = caseSemanticModelBridge(semanticModelBridge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.SIMPLE_SEMANTIC_MODEL_ELEMENT: {
			SimpleSemanticModelElement simpleSemanticModelElement = (SimpleSemanticModelElement) theEObject;
			T result = caseSimpleSemanticModelElement(simpleSemanticModelElement);
			if (result == null)
				result = caseSemanticModelBridge(simpleSemanticModelElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.UML1_SEMANTIC_MODEL_BRIDGE: {
			Uml1SemanticModelBridge uml1SemanticModelBridge = (Uml1SemanticModelBridge) theEObject;
			T result = caseUml1SemanticModelBridge(uml1SemanticModelBridge);
			if (result == null)
				result = caseSemanticModelBridge(uml1SemanticModelBridge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.CORE_SEMANTIC_MODEL_BRIDGE: {
			CoreSemanticModelBridge coreSemanticModelBridge = (CoreSemanticModelBridge) theEObject;
			T result = caseCoreSemanticModelBridge(coreSemanticModelBridge);
			if (result == null)
				result = caseSemanticModelBridge(coreSemanticModelBridge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.LEAF_ELEMENT: {
			LeafElement leafElement = (LeafElement) theEObject;
			T result = caseLeafElement(leafElement);
			if (result == null)
				result = caseDiagramElement(leafElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.TEXT_ELEMENT: {
			TextElement textElement = (TextElement) theEObject;
			T result = caseTextElement(textElement);
			if (result == null)
				result = caseLeafElement(textElement);
			if (result == null)
				result = caseDiagramElement(textElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.IMAGE: {
			Image image = (Image) theEObject;
			T result = caseImage(image);
			if (result == null)
				result = caseLeafElement(image);
			if (result == null)
				result = caseDiagramElement(image);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.GRAPHIC_PRIMITIVE: {
			GraphicPrimitive graphicPrimitive = (GraphicPrimitive) theEObject;
			T result = caseGraphicPrimitive(graphicPrimitive);
			if (result == null)
				result = caseLeafElement(graphicPrimitive);
			if (result == null)
				result = caseDiagramElement(graphicPrimitive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.POLILYNE: {
			Polilyne polilyne = (Polilyne) theEObject;
			T result = casePolilyne(polilyne);
			if (result == null)
				result = caseGraphicPrimitive(polilyne);
			if (result == null)
				result = caseLeafElement(polilyne);
			if (result == null)
				result = caseDiagramElement(polilyne);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Di2Package.ELLIPSE: {
			Ellipse ellipse = (Ellipse) theEObject;
			T result = caseEllipse(ellipse);
			if (result == null)
				result = caseGraphicPrimitive(ellipse);
			if (result == null)
				result = caseLeafElement(ellipse);
			if (result == null)
				result = caseDiagramElement(ellipse);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramElement(DiagramElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Element</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphElement(GraphElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Edge</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphEdge(GraphEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Connector</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphConnector(GraphConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Node</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphNode(GraphNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Link</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramLink(DiagramLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Semantic Model Bridge</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Semantic Model Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticModelBridge(SemanticModelBridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Simple Semantic Model Element</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Simple Semantic Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleSemanticModelElement(SimpleSemanticModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Uml1 Semantic Model Bridge</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Uml1 Semantic Model Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUml1SemanticModelBridge(Uml1SemanticModelBridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Core Semantic Model Bridge</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Core Semantic Model Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoreSemanticModelBridge(CoreSemanticModelBridge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafElement(LeafElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextElement(TextElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphic Primitive</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphic Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphicPrimitive(GraphicPrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Polilyne</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Polilyne</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolilyne(Polilyne object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ellipse</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ellipse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEllipse(Ellipse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // Di2Switch
