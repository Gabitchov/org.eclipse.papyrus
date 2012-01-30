/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.dom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.e4.ui.css.core.dom.ElementAdapter;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class GMFCSSAdapter extends ElementAdapter implements NodeList {

	//TODO : Use an extension point for this map, or find another way to map Diagram ID to CSS Element name
	public static final Map<String, String> diagramNameMappings = new HashMap<String, String>();

	static {
		//UML
		diagramNameMappings.put("CompositeStructure", "CompositeDiagram");
		diagramNameMappings.put("Package", "PackageDiagram");
		diagramNameMappings.put("PapyrusUMLActivityDiagram", "ActivityDiagram");
		diagramNameMappings.put("PapyrusUMLClassDiagram", "ClassDiagram");
		diagramNameMappings.put("PapyrusUMLCommunicationDiagram", "CommunicationDiagram");
		diagramNameMappings.put("PapyrusUMLComponentDiagram", "ComponentDiagram");
		diagramNameMappings.put("PapyrusUMLDeploymentDiagram", "DeploymentDiagram");
		diagramNameMappings.put("PapyrusUMLProfileDiagram", "ProfileDiagram");
		diagramNameMappings.put("PapyrusUMLSequenceDiagram", "SequenceDiagram");
		diagramNameMappings.put("PapyrusUMLStateMachineDiagram", "StateMachineDiagram");
		diagramNameMappings.put("UseCase", "UseCaseDiagram");

		//SysML
		diagramNameMappings.put("BlockDefinition", "BlockDiagram");
		diagramNameMappings.put("InternalBlock", "InternalBlockDiagram");
		diagramNameMappings.put("PapyrusSysMLRequirement", "RequirementDiagram");
		diagramNameMappings.put("Parametric", "ParametricDiagram");
	}

	/**
	 * The UML Element associated to the current styled element
	 * Might also be a GMF Diagram
	 */
	private EObject semanticElement;

	/**
	 * The current GMF Element
	 */
	private EObject notationElement;

	private String namespaceURI;

	private String localName;

	private Node[] children;

	private Node parentNode;

	/**
	 * The css id property
	 */
	public static final String CSS_GMF_ID_KEY = "cssId";

	/**
	 * The css class property
	 */
	public static final String CSS_GMF_CLASS_KEY = "cssClass";

	/**
	 * The css style property
	 */
	public static final String CSS_GMF_STYLE_KEY = "cssStyle";

	/**
	 * The name of the EAnnotation containing css informations
	 * 
	 * @see CSS_GMF_ID_KEY
	 * @see CSS_GMF_CLASS_KEY
	 * @see CSS_GMF_STYLE_KEY
	 */
	public static final String CSS_ANNOTATION = "PapyrusCSSStyle";

	public static String getCSSID(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_ID_KEY);
	}

	public static String getCSSClass(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_CLASS_KEY);
	}

	public static String getCSSStyle(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_STYLE_KEY);
	}

	public static EAnnotation getStyleAnnotation(EModelElement modelElement) {
		if(modelElement == null) {
			return null;
		}

		return modelElement.getEAnnotation(CSS_ANNOTATION);
	}

	private static String getCSSValue(EObject sourceElement, String key) {
		EModelElement modelElement = findModelElement(sourceElement);
		EAnnotation annotation = getStyleAnnotation(modelElement);
		if(annotation == null) {
			return null;
		}

		return annotation.getDetails().get(key);
	}

	private static EModelElement findModelElement(EObject sourceElement) {
		if(sourceElement == null) {
			return null;
		}

		if(sourceElement instanceof EModelElement) {
			return (EModelElement)sourceElement;
		}

		return findModelElement(sourceElement.eContainer());
	}

	public GMFCSSAdapter(EObject eObject, CSSEngine engine) {
		super(eObject, engine);

		notationElement = eObject;
	}

	private EObject getSemanticElement() {
		if(semanticElement == null) {
			semanticElement = findSemanticElement(notationElement);
		}
		return semanticElement;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the first parent Notation Element representing a different semantic object
	 * than self.
	 */
	public Node getParentNode() {
		if(parentNode == null) {
			EObject gmfElement = notationElement;
			while(gmfElement != null) {
				EObject semanticElement = findSemanticElement(gmfElement);

				if(semanticElement != this.getSemanticElement()) {
					break;
				}

				if(gmfElement == gmfElement.eContainer()) {
					gmfElement = null;
					break;
				}

				gmfElement = gmfElement.eContainer();
			}

			if(gmfElement instanceof Node) {
				parentNode = (Node)gmfElement;
			}
		}

		return parentNode;
	}

	public NodeList getChildNodes() {
		return this;
	}

	public String getNamespaceURI() {
		return EMFHelper.getQualifiedName(getSemanticElement().eClass().getEPackage(), ".");
	}

	public String getCSSId() {
		return getCSSID(notationElement);
	}

	public String getCSSClass() {
		return getCSSClass(notationElement);
	}

	public String getCSSStyle() {
		return getCSSStyle(notationElement);
	}

	@Override
	public String getLocalName() {
		if(getSemanticElement() instanceof Diagram) {
			Diagram diagram = (Diagram)getSemanticElement();
			String type = diagram.getType();
			if(diagramNameMappings.containsKey(type)) {
				return diagramNameMappings.get(type);
			}
			return type;
		}

		return getSemanticElement().eClass().getName();
	}

	@Override
	public String getAttribute(String attr) {
		EStructuralFeature feature = semanticElement.eClass().getEStructuralFeature(attr);
		if(feature != null) {
			Object value = semanticElement.eGet(feature);
			if(value != null) {
				return value.toString();
			}
		}

		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the GMF EObject handled by this adapter
	 */
	@Override
	public EObject getNativeWidget() {
		return notationElement;
	}



	/////////////
	//Node List//
	/////////////



	public Node item(int index) {
		return getChildren()[index];
	}

	public int getLength() {
		return getChildren().length;
	}

	private Node[] getChildren() {
		if(children == null) {
			children = computeChildren(notationElement);
		}

		return children;
	}

	/**
	 * Returns the list of notation child elements attached to semantic
	 * elements different than self's semantic element.
	 * 
	 * If a notation child element represents the same semantic element
	 * than self, returns its own children (Recursively).
	 */
	private static Node[] computeChildren(EObject notationElement) {
		EObject semanticElement = findSemanticElement(notationElement);
		List<Node> childList = new LinkedList<Node>();
		for(EObject child : notationElement.eContents()) {
			if(child instanceof View) {
				View notationChild = (View)child;
				if(findSemanticElement(notationChild) != semanticElement) {
					childList.add((Node)notationChild);
				} else {
					childList.addAll(Arrays.asList(computeChildren(notationChild)));
				}
			}
		}

		return childList.toArray(new Node[childList.size()]);
	}

	/**
	 * Returns the semantic element attached to the given notation element
	 * 
	 * The result element can also be a Diagram
	 */
	private static EObject findSemanticElement(EObject notationElement) {
		if(notationElement instanceof Diagram) {
			return notationElement;
		}

		EObject currentElement = notationElement;

		do {
			if(currentElement instanceof View) {
				View view = (View)currentElement;
				return view.getElement();
			}
			currentElement = currentElement.eContainer();
		} while(currentElement != null);

		Activator.log.warn("Cannot find a valid source for " + notationElement);
		return notationElement;
	}

}
