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
package org.eclipse.papyrus.infra.gmfdiag.css.dom;

import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations.CSS_ANNOTATION;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations.CSS_DIAGRAM_STYLESHEETS_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations.CSS_GMF_CLASS_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations.CSS_GMF_ID_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations.CSS_GMF_STYLE_KEY;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.e4.ui.css.core.dom.ElementAdapter;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringListValueStyle;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.listener.CustomStyleListener;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.SemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("restriction")
public class GMFElementAdapter extends ElementAdapter implements NodeList, IChangeListener {

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
	 * The Semantic Model Element associated to the current styled element
	 * Might also be a GMF Diagram
	 */
	private EObject semanticElement;

	/**
	 * The current GMF Element
	 */
	private View notationElement;

	/**
	 * The namespace URI of the semanticElement
	 */
	private String namespaceURI;

	/**
	 * The unqualified name of the semantic Element
	 */
	private String localName;

	/**
	 * The list of child nodes for this element
	 */
	private Node[] children;

	/**
	 * The parent node of this element
	 */
	private Node parentNode;

	private Adapter styleListener;

	private CustomStyleListener cssStyleListener;

	public static String getCSSID(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_ID_KEY);
	}

	public static String getCSSClass(EObject sourceElement) {
		List<String> allClasses = getCSSValues(sourceElement, CSS_GMF_CLASS_KEY);
		return ListHelper.deepToString(allClasses, " "); //$NON-NLS-1$
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
		StringValueStyle style = (StringValueStyle)findStyle(sourceElement, key, NotationPackage.eINSTANCE.getStringValueStyle());
		if(style == null) {
			return null;
		}

		return style.getStringValue();
	}

	private static List<String> getCSSValues(EObject sourceElement, String key) {
		StringListValueStyle style = (StringListValueStyle)findStyle(sourceElement, key, NotationPackage.eINSTANCE.getStringListValueStyle());
		if(style == null) {
			return Collections.emptyList();
		}

		return style.getStringListValue();
	}

	private static NamedStyle findStyle(EObject sourceElement, String key, EClass type) {
		View view = findView(sourceElement);
		if(view == null) {
			return null;
		}

		return view.getNamedStyle(type, key);
	}

	private static View findView(EObject sourceElement) {
		if(sourceElement == null) {
			return null;
		}

		if(sourceElement instanceof View) {
			return (View)sourceElement;
		}

		return findView(sourceElement.eContainer());
	}

	public GMFElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);
		notationElement = view;
		listenNotationElement();
	}

	public EObject getSemanticElement() {
		if(semanticElement == null) {
			semanticElement = SemanticElementHelper.findSemanticElement(notationElement);
			listenSemanticElement();
		}
		return semanticElement;
	}

	private Adapter getStyleListener() {
		if(styleListener == null) {
			styleListener = new StyleListener(this);
		}
		return styleListener;
	}

	private void listenNotationElement() {
		notationElement.eAdapters().add(getStyleListener());

		Collection<String> cssStyles = Arrays.asList(new String[]{ CSS_GMF_CLASS_KEY, CSS_GMF_ID_KEY, CSS_GMF_STYLE_KEY, CSS_DIAGRAM_STYLESHEETS_KEY });

		notationElement.eAdapters().add(cssStyleListener = new CustomStyleListener(notationElement, this, cssStyles));
	}

	private ExtendedCSSEngine getEngine() {
		return (ExtendedCSSEngine)engine;
	}

	private void listenSemanticElement() {
		//FIXME: The semantic hierarchy is never refresh (children & parentNode)
		if(semanticElement != null) {
			semanticElement.eAdapters().add(getStyleListener());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the first parent Notation Element representing a different semantic object
	 * than self.
	 */
	public Node getParentNode() {
		if(parentNode == null) {
			View gmfElement = notationElement;
			while(gmfElement != null) {
				EObject semanticElement = SemanticElementHelper.findSemanticElement(gmfElement);

				if(semanticElement != this.getSemanticElement()) {
					break;
				}

				if(gmfElement == gmfElement.eContainer()) {
					gmfElement = null;
					break;
				}

				gmfElement = (View)gmfElement.eContainer();
			}

			parentNode = engine.getElement(gmfElement);
		}

		return parentNode;
	}

	public NodeList getChildNodes() {
		return this;
	}

	public String getNamespaceURI() {
		if(namespaceURI == null) {
			namespaceURI = EMFHelper.getQualifiedName(getSemanticElement().eClass().getEPackage(), ".");
		}
		return namespaceURI;
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
		if(localName == null) {
			if(getSemanticElement() instanceof Diagram) {
				Diagram diagram = (Diagram)getSemanticElement();
				String type = diagram.getType();
				if(diagramNameMappings.containsKey(type)) {
					localName = diagramNameMappings.get(type);
				} else {
					localName = type;
				}
			} else {
				localName = getSemanticElement().eClass().getName();
			}
		}

		return localName;
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
			children = computeChildren(notationElement, engine);
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
	private static Node[] computeChildren(View notationElement, CSSEngine engine) {
		EObject semanticElement = SemanticElementHelper.findSemanticElement(notationElement);
		List<Node> childList = new LinkedList<Node>();
		for(EObject child : notationElement.eContents()) {
			if(child instanceof View) {
				View notationChild = (View)child;
				if(SemanticElementHelper.findSemanticElement(notationChild) != semanticElement) {
					childList.add(engine.getElement(notationChild));
				} else {
					childList.addAll(Arrays.asList(computeChildren(notationChild, engine)));
				}
			}
		}

		return childList.toArray(new Node[childList.size()]);
	}

	//////////////////////
	//	Handle events	//
	//////////////////////

	public EObject getNotationElement() {
		return notationElement;
	}

	public void semanticElementChanged() {
		if(semanticElement != null && semanticElement != notationElement) {
			semanticElement.eAdapters().remove(styleListener);
			semanticElement = null;
		}

		localName = null;
		parentNode = null;
		namespaceURI = null;
		children = null;
		getEngine().notifyChange(this);
	}

	//Change incoming from one of the cssCustomStyles (class, id, local style or diagram stylesheets)
	public void handleChange(ChangeEvent event) {
		if(notationElement instanceof CSSDiagram) {
			//TODO: Use a finer grained event (We should reset only when the 
			//change occurs on a DiagramStyleSheet)
			getEngine().reset();
		}

		//Notify the CSS Engine
		getEngine().notifyChange(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		notationElement.eAdapters().remove(cssStyleListener);
		cssStyleListener.dispose();

		notationElement.eAdapters().remove(styleListener);

		if(semanticElement != null) {
			semanticElement.eAdapters().remove(styleListener);
		}
	}

	public void notationPropertyChanged() {
		//Notify the CSSEngine
		getEngine().notifyChange(this);
	}

	public void semanticPropertyChanged() {
		//Notify the CSSEngine
		getEngine().notifyChange(this);
	}

	public void notationElementDisposed() {
		dispose();
		//Notify the CSSEngine
		getEngine().handleDispose(notationElement);
	}

}
