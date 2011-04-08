/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

package org.eclipse.papyrus.diagram.common.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.diagram.common.commands.CreateHyperLinkDiagramCommand;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.EditorHyperlinkDiagramShell;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkDiagram;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkWeb;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.diagram.common.util.ServiceUtilsForGMF;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.uml2.uml.Package;

/**
 * this is an helper to manager hyperlink Diagram 
 */
public class DiagramHyperLinkHelper extends AbstractHyperLinkHelper {

	@Override
	public HyperlinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		if(eAnnotation.getSource().equals(VisualInformationPapyrusConstant.HYPERLINK_DIAGRAM)) {
			HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
			EList<EObject> list = eAnnotation.getReferences();
			if(list.size() > 0) {
				if(eAnnotation.getReferences().get(0).eResource() != null) {
					hyperLinkDiagram.setDiagram((Diagram)eAnnotation.getReferences().get(0));
					hyperLinkDiagram.setTooltipText(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT));
					if(eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION)!=null){
						String stringboolean=eAnnotation.getDetails().get(VisualInformationPapyrusConstant.HYPERLINK_IS_DEFAULT_NAVIGATION);
						boolean isDefaultNaviagation=Boolean.parseBoolean(stringboolean);
						hyperLinkDiagram.setIsDefault(isDefaultNaviagation);
					}
					else{
						hyperLinkDiagram.setIsDefault(false);
					}
					return hyperLinkDiagram;
				}
			}
		}
		return null;
	}
	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperlinkObject hyperlinkObject) {
		if( hyperlinkObject instanceof HyperLinkDiagram){
			HyperLinkDiagram hyperLinkDiagram= (HyperLinkDiagram)hyperlinkObject;
			return new CreateHyperLinkDiagramCommand(domain, object, hyperLinkDiagram.getTooltipText(), hyperLinkDiagram.getDiagram().getName(),  hyperLinkDiagram.getDiagram(),hyperLinkDiagram.getIsDefault());
		}
		else{return null;}
	}
	@Override
	public String getNameofManagedHyperLink() {
		return "Diagram";
	}
	@Override
	public void executeNewMousePressed(List<HyperlinkObject> list, Package amodel) {
		IPageIconsRegistry editorRegistry=null;
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EditorHyperlinkDiagramShell editor = new EditorHyperlinkDiagramShell(editorRegistry, amodel);
		editor.open();
		if(editor.getHyperLinkDiagram() != null) {
			list.add(editor.getHyperLinkDiagram());
		}

	}
	@Override
	public ArrayList<HyperlinkObject> getFilteredObject(List<HyperlinkObject> hyperlinkObjects) {
		ArrayList<HyperlinkObject> result= new ArrayList<HyperlinkObject>();
		Iterator<HyperlinkObject> iterator= hyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperlinkObject hyperlinkObject = (HyperlinkObject)iterator.next();
			if(hyperlinkObject instanceof HyperLinkDiagram){
				result.add(hyperlinkObject);
			}
		}
		return result;
	}

}
