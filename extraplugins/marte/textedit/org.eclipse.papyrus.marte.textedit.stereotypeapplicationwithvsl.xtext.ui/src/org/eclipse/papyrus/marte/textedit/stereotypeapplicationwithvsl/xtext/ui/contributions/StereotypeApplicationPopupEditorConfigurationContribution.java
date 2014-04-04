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
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.ExpressionValueRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui.internal.StereotypeApplicationWithVSLActivator;
import org.eclipse.papyrus.marte.vsl.extensions.VSLSerializationUtil;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.VSLProposalUtils;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 *
 *
 */
public class StereotypeApplicationPopupEditorConfigurationContribution extends DefaultXtextDirectEditorConfiguration implements ICustomDirectEditorConfiguration {


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */

	@Override
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
									if(o instanceof EnumerationLiteral) {
										if(p.getType() instanceof Stereotype || p.getType() instanceof org.eclipse.uml2.uml.Class) {
											value = VSLProposalUtils.getNameLabel((NamedElement)value);
										} else {
											value = ((NamedElement)value).getName();
										}
									} else if(o instanceof NamedElement) {
										collString += VSLProposalUtils.getNameLabel((NamedElement)o);
									} else if(o instanceof EObject) {
										Element stereoElement = UMLUtil.getBaseElement((EObject)o);
										if(stereoElement != null && stereoElement instanceof NamedElement) {
											collString += VSLProposalUtils.getNameLabel((NamedElement)stereoElement);
										} else {
											// TODO ... Compute a label in case of Element without Name
											collString += "/* The referenced element is not a named element. You should edit this stereotype with the property view */";
										}
									} else {
										// o is a string
										collString += o;
									}
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

		private StereotypeApplicationsRule stereotypeApplicationsObject;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

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
					boolean shouldStoreObjectsAndNotStrings = (type instanceof Stereotype || type instanceof org.eclipse.uml2.uml.Class);
					boolean propertyIsACollection = VSLJavaValidator.isACollection(value.getExpression()) != null;

					if(!propertyIsACollection) {
						if(!shouldStoreObjectsAndNotStrings) {
							valueRepresentation = VSLSerializationUtil.printExpression(value.getExpression());
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
							NameOrChoiceOrBehaviorCall nameRule = VSLSerializationUtil.extractNameReference(value.getExpression());
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
							CollectionOrTuple collection = VSLJavaValidator.isACollection(value.getExpression());
							for(Expression e : collection.getListOfValues().getValues()) {
								listOfValues.add(VSLSerializationUtil.printExpression(e));
							}
							valueRepresentation = listOfValues;
						} else {
							List<Object> listOfValues = new ArrayList<Object>();
							CollectionOrTuple collection = VSLJavaValidator.isACollection(value.getExpression());
							for(Expression e : collection.getListOfValues().getValues()) {
								NameOrChoiceOrBehaviorCall nameRule = VSLSerializationUtil.extractNameReference(e);
								if(nameRule != null) {
									if(!(property.getType() instanceof Stereotype)) {
										listOfValues.add(nameRule.getId());
									} else {
										listOfValues.add(nameRule.getId().getStereotypeApplication(((Stereotype)property.getType())));
									}
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

		public UpdateStereotypeApplicationsCommand(Element stereotypedElement, StereotypeApplicationsRule stereotypeApplicationsObject) {
			super((TransactionalEditingDomain)EMFHelper.resolveEditingDomain(stereotypedElement), "Stereotype Applications Update", getWorkspaceFiles(stereotypedElement));
			this.stereotypedElement = stereotypedElement;
			this.stereotypeApplicationsObject = stereotypeApplicationsObject;
		}
	}

	@Override
	public Injector getInjector() {
		return StereotypeApplicationWithVSLActivator.getInstance().getInjector(StereotypeApplicationWithVSLActivator.ORG_ECLIPSE_PAPYRUS_MARTE_TEXTEDIT_STEREOTYPEAPPLICATIONWITHVSL_XTEXT_STEREOTYPEAPPLICATIONWITHVSL);
	}

	@Override
	protected ICommand getParseCommand(EObject modelObject, EObject xtextObject) {
		// first: retrieves / determines if the xtextObject is a TransitionRule object
		EObject modifiedObject = xtextObject;
		if(!(modelObject instanceof Element)) {
			return UnexecutableCommand.INSTANCE;
		}
		while(xtextObject != null && !(xtextObject instanceof StereotypeApplicationsRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if(modifiedObject == null) {
			return UnexecutableCommand.INSTANCE;
		}

		Element stereotypedElement = (Element)modelObject;
		StereotypeApplicationsRule stereotypeApplicationsObject = (StereotypeApplicationsRule)xtextObject;

		// Creates and executes the update command
		UpdateStereotypeApplicationsCommand updateCommand = new UpdateStereotypeApplicationsCommand(stereotypedElement, stereotypeApplicationsObject);
		return updateCommand;
	}
}
