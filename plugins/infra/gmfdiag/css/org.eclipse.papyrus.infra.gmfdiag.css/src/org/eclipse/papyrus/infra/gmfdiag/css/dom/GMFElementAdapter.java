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

import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_CLASS_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_ID_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_STYLE_KEY;

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
import org.eclipse.emf.ecore.EClass;
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

/**
 * An Adapter for providing a CSS support to GMF Objects
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class GMFElementAdapter extends ElementAdapter implements NodeList, IChangeListener {

	/**
	 * The map of Papyrus Diagram ids to human-readable and consistent diagram IDs
	 * The later can be used as valid CSS Selectors
	 */
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
		diagramNameMappings.put("PapyrusUMLTimingDiagram", "TimingDiagram");

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

	/**
	 * A Listener for standard Style properties
	 */
	private Adapter styleListener;

	/**
	 * A Listener for custom Style properties
	 */
	private CustomStyleListener cssStyleListener;

	/**
	 * Returns the CSS ID of the selected element.
	 * 
	 * @param sourceElement
	 *        The source element must be a GMF notation object (View, Style, ...)
	 * @return
	 *         The CSS ID associated to the source element, or null if it cannot be found
	 */
	public static String getCSSID(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_ID_KEY);
	}

	/**
	 * Returns the CSS Class of the selected element. If more than one CSS
	 * class is associated to the source elements, returns a String containing
	 * all classes, separated with spaces.
	 * 
	 * @param sourceElement
	 *        The source element must be a GMF notation object (View, Style, ...)
	 * @return
	 *         The CSS Class associated to the source element, or null if it cannot be found
	 */
	public static String getCSSClass(EObject sourceElement) {
		List<String> allClasses = getCSSValues(sourceElement, CSS_GMF_CLASS_KEY);
		return ListHelper.deepToString(allClasses, " "); //$NON-NLS-1$
	}

	/**
	 * Returns the source element's local CSS style.
	 * 
	 * @param sourceElement
	 *        The source element must be a GMF notation object (View, Style, ...)
	 * @return
	 *         the source element's local CSS style.
	 */
	public static String getCSSStyle(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_STYLE_KEY);
	}

	private static String getCSSValue(EObject sourceElement, String key) {
		StringValueStyle style = (StringValueStyle)findStyle(sourceElement, key, NotationPackage.eINSTANCE.getStringValueStyle());
		if(style == null) {
			return null;
		}

		return style.getStringValue();
	}

	@SuppressWarnings("unchecked")
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

	/**
	 * Creates a new GMF Element Adapter for the requested view.
	 * 
	 * @param view
	 *        The view to be adapted
	 * @param engine
	 *        The associated CSS Engine
	 */
	public GMFElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);
		notationElement = view;
		listenNotationElement();
	}

	/**
	 * Returns the semantic element associated to this adapter. In case of a diagram,
	 * the diagram is itself the semantic element.
	 * 
	 * @return
	 *         The semantic element associated to this adapter
	 */
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

				EObject container = gmfElement.eContainer();

				if(gmfElement == container || !(container instanceof View)) {
					gmfElement = null;
					break;
				}

				gmfElement = (View)container;
			}

			parentNode = engine.getElement(gmfElement);
			if(parentNode == this) {
				return parentNode = null;
			}
		}

		return parentNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public NodeList getChildNodes() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNamespaceURI() {
		if(namespaceURI == null) {
			namespaceURI = EMFHelper.getQualifiedName(getSemanticElement().eClass().getEPackage(), ".");
		}
		return namespaceURI;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCSSId() {
		return getCSSID(notationElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCSSClass() {
		return getCSSClass(notationElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCSSStyle() {
		return getCSSStyle(notationElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The local name is either the diagram type (For a Diagram) or the name of the semantic
	 * element's metaclass
	 */
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

	/**
	 * {@inheritDoc}
	 * 
	 * The attributes are the semantic's element features
	 */
	@Override
	public String getAttribute(String attr) {
		EStructuralFeature feature = getSemanticElement().eClass().getEStructuralFeature(attr);
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



	/**
	 * {@inheritDoc}
	 */
	public Node item(int index) {
		return getChildren()[index];
	}

	/**
	 * {@inheritDoc}
	 */
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


	/**
	 * The GMF View element associated to this adapter
	 * 
	 * @return
	 *         The GMF View element associated to this adapter
	 */
	public View getNotationElement() {
		return notationElement;
	}

	/**
	 * Handles a notification for semantic element change.
	 * Source: styleListener
	 */
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

	/**
	 * Handles a notification for Custom style change.
	 * Source: cssStyleListener
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * Handles a notification for notation property change
	 * Source : styleListener
	 */
	public void notationPropertyChanged() {
		//Notify the CSSEngine
		getEngine().notifyChange(this);
	}

	/**
	 * Handles a notification for semantic property change
	 * Source : styleListener
	 */
	public void semanticPropertyChanged() {
		//Notify the CSSEngine
		getEngine().notifyChange(this);
	}

	/**
	 * Handles a notification for notation element disposed
	 * Source : styleListener
	 */
	public void notationElementDisposed() {
		dispose();
		//Notify the CSSEngine
		getEngine().handleDispose(notationElement);
	}

}
