/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.compatibility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.compatibility.DiagramVersioningUtils;
import org.eclipse.papyrus.gmf.diagram.common.compatibility.IDiagramVersionUpdater;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * Diagram version updater for the Internal Block Diagram.
 */
public class DiagramVersionUpdater implements IDiagramVersionUpdater {

	/** Constructor */
	public DiagramVersionUpdater() {
	}
	
	public int update(Diagram diagram, String oldVersion, String newVersion) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		
		if (DiagramVersioningUtils.UNDEFINED_VERSION.equals(oldVersion) && ("0.8.1".equals(newVersion))) {
			try {
				editingDomain.getCommandStack().execute(getUpdateCommandFromUndefinedTo_081(diagram));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	private Command getUpdateCommandFromUndefinedTo_081 (final Diagram diagram) throws Exception {
				
		Command command = new RecordingCommand(TransactionUtil.getEditingDomain(diagram),"Diagram version updater (from undefined to 0.8.1)") {
			
			private Map<String, String> conversionMapping = new HashMap<String, String>();
			
			private void initializeMappings() {
				
				conversionMapping.put(OldElementTypes.CLASS.getSemanticHint(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
				conversionMapping.put(OldElementTypes.CLASS_LABEL_COMPOSITE_NAME_HINT, SysMLGraphicalTypes.LABEL_SYSML_BLOCK_NAME_ID);
				conversionMapping.put(OldElementTypes.CLASS_COMPARTMENT_STRUCTURE_HINT, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
				
				conversionMapping.put(OldElementTypes.PROPERTY_CN.getSemanticHint(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID);
				conversionMapping.put(OldElementTypes.PROPERTY_CN_LABEL_PART_NAME_HINT, UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID);
				conversionMapping.put(OldElementTypes.PROPERTY_CN_COMPARTMENT_STRUCTURE_HINT, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
				
				conversionMapping.put(OldElementTypes.PORT_CN_LABEL_APPLIED_STEREOTYPE_HINT, UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID);

				conversionMapping.put(OldElementTypes.CONNECTOR.getSemanticHint(), UMLGraphicalTypes.LINK_UML_CONNECTOR_ID);
				conversionMapping.put(OldElementTypes.CONNECTOR_LABEL_APPLIED_STEREOTYPE_HINT, UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID);
				conversionMapping.put(OldElementTypes.CONNECTOR_LABEL_NAME_HINT, UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_LABEL_ID);
				conversionMapping.put(OldElementTypes.CONNECTOR_LABEL_MULTIPLICITY_SOURCE_HINT, UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_SOURCE_MULTIPLICITY_ID);
				conversionMapping.put(OldElementTypes.CONNECTOR_LABEL_MULTIPLICITY_TARGET_HINT, UMLGraphicalTypes.LINKLABEL_UML_CONNECTOR_TARGET_MULTIPLICITY_ID);
				
			}
			
			@Override
			protected void doExecute() {
				initializeMappings();
				
				List<View> blockViews = new ArrayList<View>();
				List<View> portViews = new ArrayList<View>();

				// Update diagram compatibility version
				//DiagramVersioningUtils.setCompatibilityVersion(diagram, "0.8.1");
				
				// Update view types
				Iterator<EObject> it = diagram.eAllContents();
				while (it.hasNext()) {
					EObject currentEObject = it.next();
					if (currentEObject instanceof View) {
						View currentView = (View) currentEObject;

						if (conversionMapping.containsKey(currentView.getType())) {
							if (currentView.getType().equals(OldElementTypes.CLASS.getSemanticHint())) {
								blockViews.add(currentView);
							}

							currentView.setType(conversionMapping.get(currentView.getType()));
						}
						
						// Port require specific conversion
						if (currentView.getType().equals(OldElementTypes.PORT_CN.getSemanticHint()) || currentView.getType().equals(OldElementTypes.PORT_CN_LABEL_NAME_HINT)) {
							portViews.add(currentView);
						}
					}
				}
				
				// Specific conversion cases
				for (View portView : portViews) {
					EObject eObject = portView.getElement();
					
					if (((ISpecializationType)SysMLElementTypes.FLOW_PORT).getMatcher().matches(eObject)) {
						
						if (portView.getType().equals(OldElementTypes.PORT_CN.getSemanticHint())) {
							portView.setType(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID);
						}
						
						if (portView.getType().equals(OldElementTypes.PORT_CN_LABEL_NAME_HINT)) {
							portView.setType(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID);
						}
						
					} else { // if (eObject instanceof Port)
						
						if (portView.getType().equals(OldElementTypes.PORT_CN.getSemanticHint())) {
							portView.setType(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID);
						}
						
						if (portView.getType().equals(OldElementTypes.PORT_CN_LABEL_NAME_HINT)) {
							portView.setType(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID);
						}
					}
				}
				
				// Update settings
				for (View blockView : blockViews) {
					EAnnotation stereotypeAnnotation = blockView.getEAnnotation("Stereotype_Annotation");
					blockView.getEAnnotations().remove(stereotypeAnnotation);
				}
			}
			
			@Override
			public boolean canUndo() {
				return false;
			}
		};
	
		return command;
	}
}
