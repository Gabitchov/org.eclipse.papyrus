/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IViewPart;

/**
 * Implementation class for AddSemanticElementTypeInGenericTopNode action
 */
public class AddSemanticElementTypeInGenericTopNode extends Action {

	/** prefix for Metamodel type identifier */
	private static final String ORG_ECLIPSE_PAPYRUS_UML = "org.eclipse.papyrus.uml.";

	public static final String GEN_CLASS_RT_CLASS = "Node"; //$NON-NLS-1$

	public static final String GEN_CLASS_FACET_META_FEATURE = "NamedElement"; //$NON-NLS-1$

	public static final String GEN_FEATURE_FACET_META_FEATURE = "name"; //$NON-NLS-1$

	public static final String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	public static final String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// NO OP
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {

		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof GenDiagram) {

				GenDiagram genDiagram = (GenDiagram)eObject;
				ResourceSet resourceSet = genDiagram.eResource().getResourceSet();
				int updated = 0;
				int created = 0;
				
				// create and set values for top node and sub children
				List<GenClass> concreteUMLMetaclasses = getAllUMLConcreteClasses(resourceSet);
				for(GenClass currentGenClass : concreteUMLMetaclasses) {
					boolean needsCreation = false;
					
					String metaclassName = currentGenClass.getEcoreClass().getName();
					GenTopLevelNode node = findTopLevelNode(genDiagram, currentGenClass);
					if(node == null)  {
						needsCreation = true;
						node = createNewTopNode(genDiagram, metaclassName);
						created++;
					}
					updateToplevelNode(node, resourceSet, currentGenClass);
					
					if(needsCreation) {
						genDiagram.getTopLevelNodes().add(node);
					}
					updated++;
				}
				
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Generation", created+ " nodes were created.\n "+updated+" nodes were updated");
			}
		}
	}
	
	
	
	/**
	 * Returns all the UML {@link GenClass} that are related to UML constructs which are not abstract  
	 * @param resourceSet
	 * @return
	 */
	protected List<GenClass> getAllUMLConcreteClasses(ResourceSet resourceSet) {
		Resource umlResource = resourceSet.getResource( URI.createPlatformPluginURI(URI_UML_GENMODEL, false), true);
		List<GenClass> classes = new ArrayList<GenClass>();
		Iterator<EObject> it =  umlResource.getAllContents();
		while(it.hasNext()) {
			EObject next = it.next();
			if(next instanceof GenClass) {
				GenClass genClass = (GenClass)next;
				EClass umlEClass = genClass.getEcoreClass();
				if(umlEClass !=null && !umlEClass.isAbstract() && !umlEClass.isInterface()) {
					classes.add(genClass);
				}
			}
		}
		return classes;
	}

	/**
	 * Returns the top level node that corresponds to this metaclass
	 * @param metaclassName name of the metaclass for which element type has to be defined
	 * @return the top level node found or <code>null</code>;
	 */
	protected GenTopLevelNode findTopLevelNode(GenDiagram genDiagram, GenClass genClass) {
		for(GenTopLevelNode topNode : genDiagram.getTopLevelNodes()) {
			TypeModelFacet facet = topNode.getModelFacet();
			if(facet !=null) {
				if(genClass.equals(facet.getMetaClass())) {
					return topNode;
				};
			}
		}
		return null;
	}

	protected void updateToplevelNode(GenTopLevelNode topLevelNode, ResourceSet resourceSet, GenClass genClass) {
		String metaclassName = genClass.getEcoreClass().getName();
		topLevelNode.setDiagramRunTimeClass(getNodeViewClass(resourceSet));
		
		TypeModelFacet typeModelFacet = topLevelNode.getModelFacet();
		if(typeModelFacet == null) {
			typeModelFacet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
			topLevelNode.setModelFacet(typeModelFacet);
		}
		
		typeModelFacet.setMetaClass(genClass);
		
		ElementType type = topLevelNode.getElementType();
		if(type == null) {
			type = GMFGenFactory.eINSTANCE.createMetamodelType();
			topLevelNode.setElementType(type);
		}
		type.setDefinedExternally(true);
		type.setDisplayName(metaclassName+"_Semantic");
		type.setUniqueIdentifier(ORG_ECLIPSE_PAPYRUS_UML+metaclassName);
	}
	
	public GenTopLevelNode createNewTopNode(GenDiagram genDiagram, String metaclassName) {
		GenTopLevelNode topLevelNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		return topLevelNode;
	}
 
	
	protected GenClass getNodeViewClass(ResourceSet resourceSet) {
		URI uri_notation = URI.createPlatformPluginURI(URI_NOTATION_GENMODEL, false);
		Resource notation = resourceSet.getResource(uri_notation, true);
		return findGenClass(notation, GEN_CLASS_RT_CLASS);
	}

	protected GenClass getMetaclassGenClass(ResourceSet resourceSet, String metaclassName) {
		URI uri_uml = URI.createPlatformPluginURI(URI_UML_GENMODEL, false);
		Resource umlResource = resourceSet.getResource(uri_uml, true);
		return findGenClass(umlResource, metaclassName);
	}

}
