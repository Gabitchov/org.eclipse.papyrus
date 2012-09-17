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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.compatibility.DiagramVersioningUtils;
import org.eclipse.papyrus.gmf.diagram.common.compatibility.IDiagramVersionUpdater;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * Diagram version updater for the Internal Block Diagram.
 */
public class DiagramVersionUpdater implements IDiagramVersionUpdater {

	public static final String VERSION_0_9_1 = "0.9.1";
	
	public final static String VERSION_0_8_1 = "0.8.1";
	
	/** Constructor */
	public DiagramVersionUpdater() {
	}

	public int update(Diagram diagram, String oldVersion, String newVersion) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);

		if(DiagramVersioningUtils.UNDEFINED_VERSION.equals(oldVersion)) {
			if(VERSION_0_8_1.equals(newVersion)) {
				try {
					editingDomain.getCommandStack().execute(getUpdateCommandFromUndefinedTo_081(diagram));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(VERSION_0_9_1.equals(newVersion)) {
				try {
					CompoundCommand cc = new CompoundCommand("Update Diagram");
					cc.append(getUpdateCommandFromUndefinedTo_081(diagram));
					cc.append(getUpdateCommandFrom081To_091(diagram));
					editingDomain.getCommandStack().execute(cc);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}

		if(VERSION_0_8_1.equals(oldVersion) && (VERSION_0_9_1.equals(newVersion))) {
			try {
				editingDomain.getCommandStack().execute(getUpdateCommandFrom081To_091(diagram));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	private Command getUpdateCommandFromUndefinedTo_081(final Diagram diagram) throws Exception {

		Command command = new RecordingCommand(TransactionUtil.getEditingDomain(diagram), "Diagram version updater (from undefined to 0.8.1)") {

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
				while(it.hasNext()) {
					EObject currentEObject = it.next();
					if(currentEObject instanceof View) {
						View currentView = (View)currentEObject;

						if(conversionMapping.containsKey(currentView.getType())) {
							if(currentView.getType().equals(OldElementTypes.CLASS.getSemanticHint())) {
								blockViews.add(currentView);
							}

							currentView.setType(conversionMapping.get(currentView.getType()));
						}

						// Port require specific conversion
						if(currentView.getType().equals(OldElementTypes.PORT_CN.getSemanticHint()) || currentView.getType().equals(OldElementTypes.PORT_CN_LABEL_NAME_HINT)) {
							portViews.add(currentView);
						}
					}
				}

				// Specific conversion cases
				for(View portView : portViews) {
					EObject eObject = portView.getElement();

					if(((ISpecializationType)SysMLElementTypes.FLOW_PORT).getMatcher().matches(eObject)) {

						if(portView.getType().equals(OldElementTypes.PORT_CN.getSemanticHint())) {
							portView.setType(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID);
						}

						if(portView.getType().equals(OldElementTypes.PORT_CN_LABEL_NAME_HINT)) {
							portView.setType(SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID);
						}

					} else { // if (eObject instanceof Port)

						if(portView.getType().equals(OldElementTypes.PORT_CN.getSemanticHint())) {
							portView.setType(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID);
						}

						if(portView.getType().equals(OldElementTypes.PORT_CN_LABEL_NAME_HINT)) {
							portView.setType(UMLGraphicalTypes.AFFIXEDLABEL_UML_PORT_LABEL_ID);
						}
					}
				}

				// Update settings
				for(View blockView : blockViews) {
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
	
	private Command getUpdateCommandFrom081To_091(final Diagram diagram) throws Exception {

		Command command = new RecordingCommand(TransactionUtil.getEditingDomain(diagram), "Diagram version updater (from 0.8.1 to 0.9.1)") {

			private Map<String, String> conversionMapping = new HashMap<String, String>();

			private List<IStatus> results = new ArrayList<IStatus>();
			
			private void initializeMappings() {

				conversionMapping.put(OldElementTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID);

			}

			@Override
			protected void doExecute() {
				initializeMappings();
				ViewServiceUtil.forceLoad();
				List<View> nestedPropertyViews = new ArrayList<View>();
				List<View> failedPropertyUpdates = new ArrayList<View>();

				// Update diagram compatibility version
				//DiagramVersioningUtils.setCompatibilityVersion(diagram, "0.8.1");

				// Update view types
				Iterator<EObject> it = diagram.eAllContents();
				while(it.hasNext()) {
					EObject currentEObject = it.next();
					if(currentEObject instanceof View) {
						View currentView = (View)currentEObject;
						String currentViewType = currentView.getType();
						if(conversionMapping.containsKey(currentViewType)) {
							
							// update nested properties
							if(OldElementTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID.equals(currentViewType)) {
								currentView.setType(conversionMapping.get(currentView.getType()));
								nestedPropertyViews.add(currentView);
								// need to create child structure compartment, enven not visible
								
								Node compartment = ViewService.createNode(currentView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID, PreferencesHint.USE_DEFAULTS);
								if(compartment ==null) {
									failedPropertyUpdates.add(currentView);
								}
							}
						}
					}
				}
				
				if(!failedPropertyUpdates.isEmpty()) {
					org.eclipse.papyrus.sysml.diagram.internalblock.Activator.log.warn("Impossible to create a compartment for the properties: "+failedPropertyUpdates);
				}

			}

			@Override
			public boolean canUndo() {
				return false;
			}
			
			public java.util.Collection<IStatus> getResult() {
				return results;
			};
		};

		return command;
	}
}
