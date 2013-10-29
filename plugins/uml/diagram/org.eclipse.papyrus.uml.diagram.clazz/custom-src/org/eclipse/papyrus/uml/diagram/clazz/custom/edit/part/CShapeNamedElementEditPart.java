/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import java.util.StringTokenizer;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Stereotype;
import org.w3c.dom.Document;


/**
 * it inherits from its parent to overload the nodeplate
 *
 */
public class CShapeNamedElementEditPart extends ShapeNamedElementEditPart {
/**
 * 
 * Constructor.
 *
 * @param view
 */
	public CShapeNamedElementEditPart(View view) {
		super(view);
	}
	
	protected NodeFigure createNodePlate() {

		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getModel());
		StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
		
		String prefElementId = "ShapeNamedElement";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);

		SVGNodePlateFigure svgNodePlateFigure=new SVGNodePlateFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		if(tokenizer.hasMoreTokens()) {
			String firstStereotypeName = tokenizer.nextToken();
			Stereotype stereotype = getUMLElement().getAppliedStereotype(firstStereotypeName);
			org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(getUMLElement(), stereotype, "shape");
			if(icon != null) {
				if(icon.getLocation() != "" && icon.getLocation() != null) {
					if(icon.getLocation().endsWith(".svg")){
						URI svgURI=URI.createURI(icon.getLocation());
						String parser = org.apache.batik.util.XMLResourceDescriptor.getXMLParserClassName();
						SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
						try {
							Document doc = f.createDocument(svgURI.toString());
							SVGOMDocument svgDocument=(SVGOMDocument)doc;
							svgNodePlateFigure.setSVGDocument(svgDocument);
							
						} catch (Exception e) {
							System.err.println(e);
						}
					}
				}
			}
		}


		return svgNodePlateFigure;
		
	}
}
