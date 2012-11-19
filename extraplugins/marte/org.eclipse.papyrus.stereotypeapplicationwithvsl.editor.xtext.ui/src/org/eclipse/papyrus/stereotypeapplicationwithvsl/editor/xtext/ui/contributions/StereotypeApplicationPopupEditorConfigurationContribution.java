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
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.marte.vsl.extensions.VSLSerializationUtil;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.VSLProposalUtils;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.internal.StereotypeApplicationWithVSLActivator;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation.SemanticValidator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 * 
 * 
 */
public class StereotypeApplicationPopupEditorConfigurationContribution extends PopupEditorConfiguration {

	private Element stereotypedElement = null;

	private StereotypeApplicationsRule stereotypeApplicationsObject = null;

	private Injector injector = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#createPopupEditorHelper(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */

	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {

		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;

		if(!(graphicalEditPart.resolveSemanticElement() instanceof Element))
			return null;
		stereotypedElement = (Element)graphicalEditPart.resolveSemanticElement();

		// initializes VSL editor
		VSLJavaValidator.init(stereotypedElement);

		// retrieves the XText injector
		injector = StereotypeApplicationWithVSLActivator.getInstance().getInjector("org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSL");
		//VSLJavaValidator.eInstance = injector.getInstance(VSLJavaValidator.class) ;

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".StereotypeApplicationWithVSL";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a TransitionRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Element))
					return;
				while(xtextObject != null && !(xtextObject instanceof StereotypeApplicationsRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null)
					return;
				stereotypeApplicationsObject = (StereotypeApplicationsRule)xtextObject;

				// Creates and executes the update command
				UpdateStereotypeApplicationsCommand updateCommand = new UpdateStereotypeApplicationsCommand(stereotypedElement);

				try {
					OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
				}
				catch (ExecutionException e) {
					org.eclipse.papyrus.infra.core.Activator.log.error(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart,
			injector,
			reconciler,
			textToEdit,
			fileExtension,
			new SemanticValidator());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */

	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Element) {
			Element stereotypedElement = (Element)editedObject;
			String textToEdit = "";

			for(Stereotype stereotype : stereotypedElement.getAppliedStereotypes()) {
				textToEdit += "<<" + stereotype.getName() + ">>";
				boolean first = true;
				for(Property p : stereotype.getAllAttributes()) {
					if(!(p.getName().startsWith("base_") || p.isDerived())) {
						Object value = stereotypedElement.getValue(stereotype, p.getName());
						if(value instanceof EnumerationLiteral) {
							if(p.getType() instanceof Stereotype || p.getType() instanceof org.eclipse.uml2.uml.Class) {
								value = VSLProposalUtils.getNameLabel((NamedElement)value);
							} else {
								value = ((NamedElement)value).getName();
							}
						} else if(value instanceof NamedElement) {
							value = VSLProposalUtils.getNameLabel((NamedElement)value);
						} else if(value instanceof EObject) {
							Element stereoElement = UMLUtil.getBaseElement((EObject)value);
							if(stereoElement != null && stereoElement instanceof NamedElement) {
								value = VSLProposalUtils.getNameLabel(((NamedElement)stereoElement));
							} else {
								// TODO ... Compute a label in case of Element without Name
								value = "/* The referenced element is not a named element. You should edit this stereotype with the property view */";
							}
						} else if(value instanceof String) {
							if((p.getType() instanceof PrimitiveType) && (p.getType().getName().equals("String"))) {
								// quote strings
								value = "\"" + value + "\"";
							}
						}

						if(value != null && value instanceof List) {
							List listOfValues = (List)value;
							if(!listOfValues.isEmpty()) {
								String collString = "{";
								boolean nestedFirst = true;
								for(Object o : listOfValues) {
									if(!nestedFirst) {
										collString += ", ";
									} else {
										nestedFirst = false;
									}
									if(o instanceof EnumerationLiteral)
										if(p.getType() instanceof Stereotype || p.getType() instanceof org.eclipse.uml2.uml.Class)
											value = VSLProposalUtils.getNameLabel((NamedElement)value);
										else
											value = ((NamedElement)value).getName();
									else if(o instanceof NamedElement)
										collString += VSLProposalUtils.getNameLabel((NamedElement)o);
									//else if (o instanceof DynamicEObjectImpl) {
									//DynamicEObjectImpl stereotypeApplication = (DynamicEObjectImpl)o ;
									// TODO ... Retrieve the element that the stereotypeApplication is refering to
									//collString += o ;
									//}
									else if(o instanceof EObject) {
										Element stereoElement = UMLUtil.getBaseElement((EObject)o);
										if(stereoElement != null && stereoElement instanceof NamedElement)
											collString += VSLProposalUtils.getNameLabel((NamedElement)stereoElement);
										else {
											// TODO ... Compute a label in case of Element without Name
											collString += "/* The referenced element is not a named element. You should edit this stereotype with the property view */";
										}
									}

									else
										// o is a string
										collString += o;
								}
								collString += "}";
								if(first) {
									textToEdit += "\n";
									first = false;
								} else {
									textToEdit += ",\n";
								}
								textToEdit += p.getName() + " = " + collString;
							}
						} else if(value != null) {
							if(first) {
								textToEdit += "\n";
								first = false;
							} else {
								textToEdit += ",\n";
							}
							textToEdit += p.getName() + " = " + value;
						}
					}
				}
				textToEdit += "\n\n";
			}

			return textToEdit;
		}

		return "// not an Element";
	}

	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class UpdateStereotypeApplicationsCommand extends AbstractTransactionalCommand {

		private Element stereotypedElement;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */

		protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
			IAdaptable arg1) throws ExecutionException {

			////////////////////////////////////////////////////////////
			// First delete any stereotype application associated with the stereotyped element
			////////////////////////////////////////////////////////////
			List<Stereotype> appliedStereotypes = stereotypedElement.getAppliedStereotypes();
			for(Stereotype s : appliedStereotypes) {
				stereotypedElement.unapplyStereotype(s);
			}


			//////////////////////////////////////////////////////////////////////////////////////////////////
			// Then extract any relevant information from the StereotypeApplicationRules object, and update the stereotypedElement
			//////////////////////////////////////////////////////////////////////////////////////////////////
			for(StereotypeApplicationRule sApp : stereotypeApplicationsObject.getStereotypeApplications()) {
				Stereotype stereotype = sApp.getStereotype();
				stereotypedElement.applyStereotype(stereotype);
				for(TagSpecificationRule tag : sApp.getTagSpecification()) {
					Property property = tag.getProperty();
					Type type = property.getType();
					ExpressionValueRule value = tag.getValue();
					Object valueRepresentation = null;

					// TODO shouldStoreObjectsAndNotStrings is not enough. Should have a specific boolean for the case of stereotype applications
					boolean shouldStoreObjectsAndNotStrings =
						(type instanceof Stereotype || type instanceof org.eclipse.uml2.uml.Class);
					boolean propertyIsACollection =
						VSLJavaValidator.isACollection(((ExpressionValueRule)value).getExpression()) != null;

					if(!propertyIsACollection) {
						if(!shouldStoreObjectsAndNotStrings) {
							valueRepresentation = VSLSerializationUtil.printExpression(((ExpressionValueRule)value).getExpression());
							if((type instanceof PrimitiveType) && (type.getName().equals("String")) && (valueRepresentation instanceof String)) {
								// unquote Strings, remove 1st and last character
								String stringValue = (String)valueRepresentation;
								if(stringValue.length() > 2) {
									valueRepresentation = stringValue.substring(1, stringValue.length() - 1);
								} else {
									valueRepresentation = "";
								}
							}
						} else {
							NameOrChoiceOrBehaviorCall nameRule = VSLSerializationUtil.extractNameReference(((ExpressionValueRule)value).getExpression());
							if(nameRule != null) {
								if(!(property.getType() instanceof Stereotype)) {
									valueRepresentation = nameRule.getId();
								} else {
									valueRepresentation = nameRule.getId().getStereotypeApplication(((Stereotype)property.getType()));
								}
							}
							// TODO: specific case of stereotype applications
						}
					} else {
						// the property has an upper bound > 1
						if(!shouldStoreObjectsAndNotStrings) {
							List<String> listOfValues = new ArrayList<String>();
							CollectionOrTuple collection = VSLJavaValidator.isACollection(((ExpressionValueRule)value).getExpression());
							for(Expression e : collection.getListOfValues().getValues()) {
								listOfValues.add(VSLSerializationUtil.printExpression(e));
							}
							valueRepresentation = listOfValues;
						} else {
							List<Object> listOfValues = new ArrayList<Object>();
							CollectionOrTuple collection = VSLJavaValidator.isACollection(((ExpressionValueRule)value).getExpression());
							for(Expression e : collection.getListOfValues().getValues()) {
								NameOrChoiceOrBehaviorCall nameRule = VSLSerializationUtil.extractNameReference(e);
								if(nameRule != null) {
									if(!(property.getType() instanceof Stereotype))
										listOfValues.add(nameRule.getId());
									else
										listOfValues.add(nameRule.getId().getStereotypeApplication(((Stereotype)property.getType())));
								}
								// TODO: specific case of stereotype applications
							}
							valueRepresentation = listOfValues;
						}
					}

					stereotypedElement.setValue(stereotype, property.getName(), valueRepresentation);

				}
			}

			return CommandResult.newOKCommandResult(stereotypedElement);
		}

		public UpdateStereotypeApplicationsCommand(Element stereotypedElement) {
			super(EditorUtils.getTransactionalEditingDomain(),
				"Stereotype Applications Update",
				getWorkspaceFiles(stereotypedElement));
			this.stereotypedElement = stereotypedElement;
		}
	}
}
