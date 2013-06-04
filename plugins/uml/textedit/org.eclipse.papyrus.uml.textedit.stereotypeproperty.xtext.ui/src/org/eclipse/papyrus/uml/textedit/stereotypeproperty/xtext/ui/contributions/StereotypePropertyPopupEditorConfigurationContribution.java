/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.INTEGER_LITERAL;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.alf.STRING_LITERAL;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypePropertyEditorUtil;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.internal.AppliedStereotypePropertyActivator;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation.AppliedStereotypePropertyJavaValidator;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation.SemanticValidator;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;

import com.google.inject.Injector;
//import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFUtils;
//import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.TransactionUtil;


/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for properties of UML classifiers.
 * 
 */
public class StereotypePropertyPopupEditorConfigurationContribution extends PopupEditorConfiguration {


	protected IGraphicalEditPart graphicalEditPart;

	/**
	 * Default implementation of the constructor for this class
	 */
	public StereotypePropertyPopupEditorConfigurationContribution() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#createPopupEditorHelper(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(editPart instanceof IAdaptable) {
			final AppliedStereotypeProperty appliedStereotypeProperty = (AppliedStereotypeProperty)((IAdaptable)editPart).getAdapter(AppliedStereotypeProperty.class);
			
			//this pop up for the moment cannot manage Datatype
			if((!(appliedStereotypeProperty.getStereotypeProperty().getType() instanceof PrimitiveType))&& 
				(!(appliedStereotypeProperty.getStereotypeProperty().getType() instanceof Enumeration))&&
				(appliedStereotypeProperty.getStereotypeProperty().getType() instanceof DataType)){
				return null;
			}
			
			AppliedStereotypePropertyJavaValidator.init(appliedStereotypeProperty);
			// retrieves the XText injector
			Injector injector = AppliedStereotypePropertyActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypeProperty");
			// builds the text content and extension for a temporary file, to be edited by the xtext editor
			String textToEdit = "" + this.getTextToEdit(appliedStereotypeProperty);
			String fileExtension = "" + ".stereotypeproperty";
			// builds a new IXtextEMFReconciler.
			// Its purpose is to extract any relevant information from the textual specification,
			// and then merge it in the context UML model if necessary
			IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

				public void reconcile(EObject modelObject, EObject xtextObject) {

					Object[] result = AppliedStereotypePropertyEditorUtil.getPossibleElements(appliedStereotypeProperty);
					//ref element stereotype application
					if(appliedStereotypeProperty.getStereotypeProperty().getType().eClass().getName().equals("Stereotype")) {
						reconcileRefToStereotypeApp(appliedStereotypeProperty, xtextObject, result);
						return;
					}

					//int
					if(appliedStereotypeProperty.getStereotypeProperty().getType().getName().equals("Integer")) {
						reconcileInteger(appliedStereotypeProperty, xtextObject);
						return;
					}
					//boolean
					if(appliedStereotypeProperty.getStereotypeProperty().getType().getName().equals("Boolean")) {
						reconcileBoolean(appliedStereotypeProperty, xtextObject);
						return;
					}
					//string
					if(appliedStereotypeProperty.getStereotypeProperty().getType().getName().equals("String")) {
						reconcileString(appliedStereotypeProperty, xtextObject);
						return;
					}
					//dataType
					if(appliedStereotypeProperty.getStereotypeProperty().getType().eClass().getName().equals("DataType")) {
						reconcileString(appliedStereotypeProperty, xtextObject);
						return;
					}
					//primitiveType
					if(appliedStereotypeProperty.getStereotypeProperty().getType().eClass().getName().equals("PrimitiveType")) {
						reconcileString(appliedStereotypeProperty, xtextObject);
						return;
					}
					if(appliedStereotypeProperty.getStereotypeProperty().getType() instanceof Enumeration) {
						reconcileEnumerationLiteral(appliedStereotypeProperty, xtextObject, result);
						return;
					}
					//ref element
					if(appliedStereotypeProperty.getStereotypeProperty().getType() instanceof Element) {
						reconcileRefToElement(appliedStereotypeProperty, xtextObject, result);
						return;


					}
				}

				/**
				 * this method is used to reconcile Enumeration literal with application of the stereotype
				 * 
				 * @param appliedStereotypeProperty
				 *        the application of stereotype
				 * @param xtextObject
				 *        the AST of the grammar
				 * @param possibleElement
				 *        list of possible elements that can be used
				 */
				protected void reconcileEnumerationLiteral(final AppliedStereotypeProperty appliedStereotypeProperty, EObject xtextObject, Object[] possibleElement) {
					ArrayList<NameExpression> eObjects = getAllElementRef(xtextObject);


					//cardinality 1
					if(appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
						if(eObjects.size() == 0) {
							updateProperties(appliedStereotypeProperty, null);
							return;
						} else {
							NameExpression nameExpression = eObjects.get(0);
							String id = nameExpression.getId();
							//EObject foundStereotypeApplication=AppliedStereotypePropertyEditorUtil.getNamedElementFor(nameExpression, result);
							EObject foundStereotypeApplication = null;
							//look for object
							for(int i = 0; i < possibleElement.length; i++) {
								if(possibleElement[i] instanceof EEnumLiteral && ((EEnumLiteral)possibleElement[i]).getName().equals(id)) {
									foundStereotypeApplication = (EEnumLiteral)possibleElement[i];
								}
								if(possibleElement[i] instanceof Enumerator && ((Enumerator)possibleElement[i]).getName().equals(id)) {
									updateProperties(appliedStereotypeProperty, possibleElement[i]);
								}
							}
							if(foundStereotypeApplication != null) {
								updateProperties(appliedStereotypeProperty, foundStereotypeApplication);
							}
						}
					}
					//cardinality *
					else {
						if(eObjects.size() == 0) {
							updateProperties(appliedStereotypeProperty, new ArrayList());
							return;
						} else {
							//iterate on NameExpression
							ArrayList<Object> stereotypeApplicationList = new ArrayList<Object>();
							Iterator<NameExpression> iterator = eObjects.iterator();
							while(iterator.hasNext()) {
								NameExpression nameExpression = iterator.next();
								String id = nameExpression.getId();
								Object foundStereotypeApplication = null;
								//look for object
								for(int i = 0; i < possibleElement.length; i++) {
									if(possibleElement[i] instanceof EEnumLiteral && ((EEnumLiteral)possibleElement[i]).getName().equals(id)) {
										foundStereotypeApplication = (EEnumLiteral)possibleElement[i];
									}
									if(possibleElement[i] instanceof Enumerator && ((Enumerator)possibleElement[i]).getName().equals(id)) {
										foundStereotypeApplication = (Enumerator)possibleElement[i];
									}
								}
								
								if(foundStereotypeApplication != null) {
									stereotypeApplicationList.add(foundStereotypeApplication);
								}
							}
							updateProperties(appliedStereotypeProperty, stereotypeApplicationList);
							return;
						}


					}
				}

				/**
				 * this method is used to reconcile references to Stereotype Application with the current application of the stereotype
				 * 
				 * @param appliedStereotypeProperty
				 *        the application of stereotype
				 * @param xtextObject
				 *        the AST of the grammar
				 * @param possibleElement
				 *        list of possible elements that can be used
				 */
				@SuppressWarnings("rawtypes")
				protected void reconcileRefToStereotypeApp(final AppliedStereotypeProperty appliedStereotypeProperty, EObject xtextObject, Object[] result) {
					ArrayList<NameExpression> eObjects = getAllElementRef(xtextObject);

					//cardinality 1
					if(appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
						if(eObjects.size() == 0) {
							updateProperties(appliedStereotypeProperty, null);
							return;
						} else {
							NameExpression nameExpression = eObjects.get(0);
							EObject foundStereotypeApplication = AppliedStereotypePropertyEditorUtil.getApplicationStereotypeFor(nameExpression, result);
							updateProperties(appliedStereotypeProperty, foundStereotypeApplication);
							return;
						}



					}
					//cardinality *
					else {
						if(eObjects.size() == 0) {
							updateProperties(appliedStereotypeProperty, new ArrayList());
							return;
						} else {
							//iterate on NameExpression
							ArrayList<EObject> stereotypeApplicationList = new ArrayList<EObject>();
							Iterator<NameExpression> iterator = eObjects.iterator();
							while(iterator.hasNext()) {
								NameExpression nameExpression = iterator.next();
								EObject foundStereotypeApplication = AppliedStereotypePropertyEditorUtil.getApplicationStereotypeFor(nameExpression, result);
								if(foundStereotypeApplication != null) {
									stereotypeApplicationList.add(foundStereotypeApplication);
								}
							}
							updateProperties(appliedStereotypeProperty, stereotypeApplicationList);
							return;
						}


					}
				}

				/**
				 * this method is used to reconcile integer with the current application of the stereotype
				 * 
				 * @param appliedStereotypeProperty
				 *        the application of stereotype
				 * @param xtextObject
				 *        the AST of the grammar
				 */
				@SuppressWarnings({ "rawtypes", "unchecked" })
				protected void reconcileInteger(final AppliedStereotypeProperty appliedStereotypeProperty, EObject xtextObject) {
					ArrayList<INTEGER_LITERAL> intList = AppliedStereotypePropertyEditorUtil.get_INTEGER(xtextObject);
					//cardinality 1
					if(appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
						if(intList.size() == 0) {
							updateProperties(appliedStereotypeProperty, null);
							return;
						} else {
							INTEGER_LITERAL theint = intList.get(0);
							Integer value = new Integer(theint.getValue());
							updateProperties(appliedStereotypeProperty, value.intValue());
							return;
						}
					}
					//cardinality *
					else {
						if(intList.size() == 0) {
							updateProperties(appliedStereotypeProperty, new ArrayList());
							return;
						} else {
							//iterate on NameExpression
							ArrayList resultList = new ArrayList();
							Iterator<INTEGER_LITERAL> iterator = intList.iterator();
							while(iterator.hasNext()) {
								INTEGER_LITERAL theint = iterator.next();
								Integer value = new Integer(theint.getValue());
								resultList.add(value.intValue());
							}
							updateProperties(appliedStereotypeProperty, resultList);
							return;
						}
					}
				}

				/**
				 * this method is used to reconcile boolean with the current application of the stereotype
				 * 
				 * @param appliedStereotypeProperty
				 *        the application of stereotype
				 * @param xtextObject
				 *        the AST of the grammar
				 */

				@SuppressWarnings("rawtypes")
				protected void reconcileBoolean(final AppliedStereotypeProperty appliedStereotypeProperty, EObject xtextObject) {
					ArrayList<BOOLEAN_LITERAL> booleanList = AppliedStereotypePropertyEditorUtil.get_BOOLEAN(xtextObject);
					//cardinality 1
					if(appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
						if(booleanList.size() == 0) {
							updateProperties(appliedStereotypeProperty, null);
							return;
						} else {
							BOOLEAN_LITERAL theboolean = booleanList.get(0);
							Boolean value = new Boolean(theboolean.getValue().toString());
							updateProperties(appliedStereotypeProperty, value.booleanValue());
							return;
						}
					} 
					//cardinality *
					else {
						if(booleanList.size() == 0) {
							updateProperties(appliedStereotypeProperty, new ArrayList());
							return;
						} else {
							//iterate on NameExpression
							ArrayList<Boolean> resultList = new ArrayList<Boolean>();
							Iterator<BOOLEAN_LITERAL> iterator = booleanList.iterator();
							while(iterator.hasNext()) {
								BOOLEAN_LITERAL theboolean = iterator.next();
								Boolean value = new Boolean(theboolean.getValue().toString());
								resultList.add(value.booleanValue());
							}
							updateProperties(appliedStereotypeProperty, resultList);
							return;
						}
					}
				}

				/**
				 * this method is used to reconcile references element with the current application of the stereotype
				 * 
				 * @param appliedStereotypeProperty
				 *        the application of stereotype
				 * @param xtextObject
				 *        the AST of the grammar
				 * @param possibleElement
				 *        list of possible elements that can be used
				 */
				@SuppressWarnings("rawtypes")
				protected void reconcileRefToElement(final AppliedStereotypeProperty appliedStereotypeProperty, EObject xtextObject, Object[] result) {
					ArrayList<NameExpression> eObjects = getAllElementRef(xtextObject);


					//cardinality 1
					if(appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
						if(eObjects.size() == 0) {
							updateProperties(appliedStereotypeProperty, null);
							return;
						} else {
							NameExpression nameExpression = eObjects.get(0);
							EObject foundStereotypeApplication = AppliedStereotypePropertyEditorUtil.getNamedElementFor(nameExpression, result);
							updateProperties(appliedStereotypeProperty, foundStereotypeApplication);
							return;
						}



					}
					//cardinality *
					else {
						if(eObjects.size() == 0) {
							updateProperties(appliedStereotypeProperty, new ArrayList());
							return;
						} else {
							//iterate on NameExpression
							ArrayList<EObject> stereotypeApplicationList = new ArrayList<EObject>();
							Iterator<NameExpression> iterator = eObjects.iterator();
							while(iterator.hasNext()) {
								NameExpression nameExpression = iterator.next();
								EObject foundStereotypeApplication = AppliedStereotypePropertyEditorUtil.getNamedElementFor(nameExpression, result);
								if(foundStereotypeApplication != null) {
									stereotypeApplicationList.add(foundStereotypeApplication);
								}
							}
							updateProperties(appliedStereotypeProperty, stereotypeApplicationList);
							return;


						}

					}
				}

				/**
				 * this method is used to reconcile Strings with the current application of the stereotype
				 * 
				 * @param appliedStereotypeProperty
				 *        the application of stereotype
				 * @param xtextObject
				 *        the AST of the grammar
				 */
				@SuppressWarnings("rawtypes")
				protected void reconcileString(final AppliedStereotypeProperty appliedStereotypeProperty, EObject xtextObject) {
					ArrayList<STRING_LITERAL> theStringList = AppliedStereotypePropertyEditorUtil.get_STRING(xtextObject);
					//cardinality 1
					if(appliedStereotypeProperty.getStereotypeProperty().getUpper() == 1) {
						if(theStringList.size() == 0) {
							updateProperties(appliedStereotypeProperty, null);
							return;
						} else {
							STRING_LITERAL theString = theStringList.get(0);
							updateProperties(appliedStereotypeProperty, theString.getValue());
							return;
						}
					} 
					
					//cardinality *
					else {
						if(theStringList.size() == 0) {
							updateProperties(appliedStereotypeProperty, new ArrayList());
							return;
						} else {
							//iterate on NameExpression
							ArrayList<String> resultList = new ArrayList<String>();
							Iterator<STRING_LITERAL> iterator = theStringList.iterator();
							while(iterator.hasNext()) {
								STRING_LITERAL theString = iterator.next();
								resultList.add(theString.getValue());
							}
							updateProperties(appliedStereotypeProperty, resultList);
							return;
						}
					}
				}

			};
			return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new SemanticValidator());
		} else {
			return null;
		}
	}

	/**
	 * this method create and execute a command to update the value of the property for the stereotype property
	 * 
	 * @param appliedStereotypeProperty
	 * @param value
	 *        the value that will be set
	 */
	protected void updateProperties(final AppliedStereotypeProperty appliedStereotypeProperty, final Object value) {
		TransactionalEditingDomain domain = graphicalEditPart.getEditingDomain();
		RecordingCommand command = new RecordingCommand(domain, "UpdateAppliedStereotypeProperty") {

			@Override
			protected void doExecute() {
				appliedStereotypeProperty.getBaseElement().setValue(appliedStereotypeProperty.getStereotype(), appliedStereotypeProperty.getStereotypeProperty().getName(), value);
			}
		};
		domain.getCommandStack().execute(command);

	}

	private ArrayList<NameExpression> getAllElementRef(EObject xtextObject) {
		ArrayList<NameExpression> result = new ArrayList<NameExpression>();
		TreeIterator<EObject> iterator = xtextObject.eAllContents();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			if(eObject instanceof NameExpression) {
				result.add((NameExpression)eObject);
			}
		}

		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof AppliedStereotypeProperty) {
			return AppliedStereotypePropertyEditorUtil.getLabel((AppliedStereotypeProperty)editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "<UNDEFINED>";
	}

}
