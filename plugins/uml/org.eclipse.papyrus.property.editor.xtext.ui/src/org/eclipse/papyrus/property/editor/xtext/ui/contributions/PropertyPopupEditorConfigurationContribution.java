/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.property.editor.xtext.ui.contributions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.property.editor.xtext.ui.internal.UmlPropertyActivator;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification;
import org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;


/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for properties of UML classifiers.
 * 
 */
public class PropertyPopupEditorConfigurationContribution extends PopupEditorConfiguration {

	private Property property;

	private boolean newIsDerived;

	private boolean newIsReadOnly;

	private boolean newIsUnique;

	private boolean newIsUnion;

	private boolean newIsOrdered;

	private int newLowerBound;

	private int newUpperBound;

	private String newName;

	private Classifier newType;

	private org.eclipse.uml2.uml.VisibilityKind newVisibility;

	/**
	 * Default implementation of the constructor for this class
	 */
	public PropertyPopupEditorConfigurationContribution() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#createPopupEditorHelper(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {

		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(!(graphicalEditPart.resolveSemanticElement() instanceof Property))
			return null;
		property = (Property)graphicalEditPart.resolveSemanticElement();

		// retrieves the XText injector
		Injector injector = UmlPropertyActivator.getInstance().getInjector("org.eclipse.papyrus.property.editor.xtext.UmlProperty");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".umlproperty";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a PropertyRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Property))
					return;
				while(xtextObject != null && !(xtextObject instanceof PropertyRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null)
					return;
				PropertyRule propertyRuleObject = (PropertyRule)xtextObject;

				// Retrieves the information to be populated in modelObject
				newIsDerived = propertyRuleObject.getIsDerived() != null && propertyRuleObject.getIsDerived().equals("/");
				newIsReadOnly = false;
				newIsUnique = false;
				newIsUnion = false;
				newIsOrdered = false;
				if(propertyRuleObject.getModifiers() != null) {
					for(ModifierSpecification modifier : propertyRuleObject.getModifiers().getValues()) {
						switch(modifier.getValue()) {
						case ORDERED:
							newIsOrdered = true;
							break;
						case READ_ONLY:
							newIsReadOnly = true;
							break;
						case UNION:
							newIsUnion = true;
							break;
						case UNIQUE:
							newIsUnique = true;
							break;
						default:
							break;
						}
					}
				}
				newLowerBound = 1;
				newUpperBound = 1;
				if(propertyRuleObject.getMultiplicity() != null) {
					if(propertyRuleObject.getMultiplicity().getBounds().size() == 1) {
						String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
						if(tempBound.equals("*")) {
							newLowerBound = 0;
							newUpperBound = -1;
						} else {
							newLowerBound = new Integer(tempBound).intValue();
							newUpperBound = new Integer(tempBound).intValue();
						}
					} else { //size == 2
						String tempBound = propertyRuleObject.getMultiplicity().getBounds().get(0).getValue();
						newLowerBound = new Integer(tempBound).intValue();
						tempBound = propertyRuleObject.getMultiplicity().getBounds().get(1).getValue();
						if(tempBound.equals("*")) {
							newUpperBound = -1;
						} else {
							newUpperBound = new Integer(tempBound).intValue();
						}
					}
				}

				newName = "" + propertyRuleObject.getName();

				newType = propertyRuleObject.getType();

				newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;

				switch(propertyRuleObject.getVisibility()) {
				case PUBLIC:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL;
					break;
				case PACKAGE:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL;
					break;
				case PRIVATE:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL;
					break;
				case PROTECTED:
					newVisibility = org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL;
					break;
				default:
					break;
				}

				UpdateUMLPropertyCommand updateCommand = new UpdateUMLPropertyCommand(property);

				try {
					OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					org.eclipse.papyrus.properties.runtime.Activator.log.error(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Property) {
			return PropertyUtil.getLabel((Property)editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "not a Property";
	}



	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class UpdateUMLPropertyCommand extends AbstractTransactionalCommand {

		private Property property;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			this.property.setIsDerived(newIsDerived);
			this.property.setIsReadOnly(newIsReadOnly);
			this.property.setIsUnique(newIsUnique);
			this.property.setIsDerivedUnion(newIsUnion);
			this.property.setIsOrdered(newIsOrdered);
			this.property.setLower(newLowerBound);
			this.property.setUpper(newUpperBound);
			this.property.setName(newName);
			this.property.setType(newType);
			this.property.setVisibility(newVisibility);
			return CommandResult.newOKCommandResult(property);
		}

		public UpdateUMLPropertyCommand(Property property) {
			super(EditorUtils.getTransactionalEditingDomain(), "Property Update", getWorkspaceFiles(property));
			this.property = property;
		}

	}

}
