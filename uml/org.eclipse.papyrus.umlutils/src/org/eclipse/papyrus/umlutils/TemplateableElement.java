/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * 
 */
public class TemplateableElement extends Element {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.TemplateableElement uml2TemplateableElement;

	/**
	 * 
	 * 
	 * @param uml2TemplateableElement
	 */
	public TemplateableElement(org.eclipse.uml2.uml.TemplateableElement uml2TemplateableElement) {
		super(uml2TemplateableElement);
		this.uml2TemplateableElement = uml2TemplateableElement;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2TemplateableElement.
	 */
	public org.eclipse.uml2.uml.TemplateableElement getUml2TemplateableElement() {
		return uml2TemplateableElement;
	}

	public Set<org.eclipse.uml2.uml.TemplateParameter> getUnboundFormalParameters() {
		Set<org.eclipse.uml2.uml.TemplateParameter> result = new HashSet<org.eclipse.uml2.uml.TemplateParameter>();
		// Navigates the set of template bindings related to this templateable elements.
		// Keeps the template parameters that are not actually bound that are not actually bound
		for (Iterator<TemplateBinding> i = uml2TemplateableElement.getTemplateBindings().iterator(); i.hasNext();) {
			TemplateBinding currentBinding = i.next();
			// builds the list of bound template parameters
			Set<org.eclipse.uml2.uml.TemplateParameter> boundParameters = new HashSet<org.eclipse.uml2.uml.TemplateParameter>();
			for (Iterator<TemplateParameterSubstitution> j = currentBinding.getParameterSubstitutions().iterator(); j.hasNext();) {
				TemplateParameterSubstitution currentParameterSubstitution = j.next();
				boundParameters.add(currentParameterSubstitution.getFormal());
			}
			// builds the list of unbound template parameters
			for (Iterator<org.eclipse.uml2.uml.TemplateParameter> j = currentBinding.getSignature().getParameters().iterator(); j.hasNext();) {
				org.eclipse.uml2.uml.TemplateParameter currentParameter = j.next();
				if (!boundParameters.contains(currentParameter))
					result.add(currentParameter);
			}

		}
		return result;
	}

	// public void synchronizeWithTemplate() {
	//    	
	// }

	public boolean isSynchronizedWithTemplates() {
		boolean result = true;
		TemplateSynchronizer synchronizer = new TemplateSynchronizer();
		for (Iterator<TemplateBinding> i = uml2TemplateableElement.getTemplateBindings().iterator(); i.hasNext() && result;) {
			TemplateBinding binding = i.next();
			org.eclipse.uml2.uml.TemplateableElement template = binding.getSignature().getTemplate();
			result = result && synchronizer.allFeaturesUpToDate(template).isEmpty();
		}
		return result;
	}

	public List<SynchronizationAction> getRequiredSynchronizationActions() {
		List<SynchronizationAction> synchronizationActionsToPerform = new ArrayList<SynchronizationAction>();
		TemplateSynchronizer synchronizer = new TemplateSynchronizer();
		for (Iterator<TemplateBinding> i = uml2TemplateableElement.getTemplateBindings().iterator(); i.hasNext();) {
			TemplateBinding binding = i.next();
			org.eclipse.uml2.uml.TemplateableElement template = binding.getSignature().getTemplate();
			synchronizationActionsToPerform.addAll(synchronizer.allFeaturesUpToDate(template));
		}
		// for (Iterator<SynchronizationAction> i = synchronizationActionsToPerform.iterator() ; i.hasNext() ; ) {
		// textOfActionsToPerform.add(i.next().getText()) ;
		// }
		return synchronizationActionsToPerform;
	}

	// private boolean isSynchronizedWithTemplate(org.eclipse.uml2.uml.TemplateableElement template) {
	// return true ;
	// }

	private class TemplateSynchronizer {

		private List<SynchronizationAction> actionsToBePerformed = null;

		/**
		 * 
		 * 
		 * @param template
		 * @return
		 */
		public List<SynchronizationAction> allFeaturesUpToDate(org.eclipse.uml2.uml.TemplateableElement template) {
			actionsToBePerformed = new ArrayList<SynchronizationAction>();
			if (template instanceof Classifier && uml2TemplateableElement instanceof Classifier) {
				Classifier templateClassifier = (Classifier) template;
				for (Iterator<Feature> i = templateClassifier.getFeatures().iterator(); i.hasNext();) {
					Feature feature = i.next();
					featureExists(feature);
				}
				return actionsToBePerformed;
			}
			return actionsToBePerformed;
		}

		/**
		 * checks that feature (of the source template) exists in the bound element
		 * 
		 * @param template
		 * @return
		 */
		private boolean featureExists(org.eclipse.uml2.uml.Feature templateFeature) {
			if (templateFeature instanceof Property) {
				Property boundElementProperty = propertyExists((Property) templateFeature);
				if (boundElementProperty != null)
					return propertyUpToDate(boundElementProperty, (Property) templateFeature);
				else {
					return false;
				}
			} else if (templateFeature instanceof Operation) {
				return operationExists((Operation) templateFeature) == null;
			}
			return true;
		}

		private org.eclipse.uml2.uml.Property propertyExists(org.eclipse.uml2.uml.Property property) {
			String propertyName = property.getName();
			Feature boundElementFeature = ((Classifier) uml2TemplateableElement).getFeature(property.getName());
			if (boundElementFeature == null) {
				boolean typeIsExposedAsAParameter = false;
				org.eclipse.uml2.uml.TemplateSignature signature = ((org.eclipse.uml2.uml.TemplateableElement) property.getOwner()).getOwnedTemplateSignature();
				// checks if the type of the template property is exposed as a parameter
				for (Iterator<org.eclipse.uml2.uml.TemplateParameter> i = signature.getParameters().iterator(); i.hasNext() && !typeIsExposedAsAParameter;) {
					org.eclipse.uml2.uml.TemplateParameter parameter = i.next();
					if (parameter.getParameteredElement() == property.getType())
						typeIsExposedAsAParameter = true;
				}
				if (typeIsExposedAsAParameter) {
					// the type of the template property is exposed as a parameter
					// As a consequence, the type of the bound element property must be updated according to parameter substitutions (if any)
					TemplateBinding binding = // the binding expressed between the bound element and the template
					uml2TemplateableElement.getTemplateBinding(signature);
					TemplateParameterSubstitution substitution = null;
					for (Iterator<TemplateParameterSubstitution> i = binding.getParameterSubstitutions().iterator(); i.hasNext() && substitution == null;) {
						TemplateParameterSubstitution current = i.next();
						if (current.getFormal().getParameteredElement() == property.getType())
							substitution = current;
					}
					if (substitution != null) { // one substitution has been defined for this parameter
						Map<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type> types = new HashMap<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type>();
						if (!substitution.getActuals().isEmpty()) {
							types.put(uml2TemplateableElement, (org.eclipse.uml2.uml.Type) substitution.getActuals().get(0));
							actionsToBePerformed.add(new SynchronizationAction(CREATE_Action_Kind, null, property, types));
						} else {
							actionsToBePerformed.add(new SynchronizationAction(CREATE_Action_Kind, null, property, null));
						}
					}
				} else
					actionsToBePerformed.add(new SynchronizationAction(CREATE_Action_Kind, null, property, null));
				return null;
			}
			return (Property) boundElementFeature;
		}

		private org.eclipse.uml2.uml.Operation operationExists(org.eclipse.uml2.uml.Operation operation) {
			return null;
		}

		private boolean featureUpToDate(Feature boundElementFeature, Feature templateFeature) {
			if (boundElementFeature instanceof Property && templateFeature instanceof Property)
				return propertyUpToDate((Property) boundElementFeature, (Property) templateFeature);
			// else if (feature instanceof org.eclipse.uml2.uml.Operation)
			// return operationUpToDate((Operation)feature) ;
			return true;
		}

		private boolean propertyUpToDate(Property boundElementProperty, Property templateProperty) {
			boolean typeIsExposedAsAParameter = false;
			org.eclipse.uml2.uml.TemplateSignature signature = ((org.eclipse.uml2.uml.TemplateableElement) templateProperty.getOwner()).getOwnedTemplateSignature();
			// checks if the type of the template property is exposed as a parameter
			for (Iterator<org.eclipse.uml2.uml.TemplateParameter> i = signature.getParameters().iterator(); i.hasNext() && !typeIsExposedAsAParameter;) {
				org.eclipse.uml2.uml.TemplateParameter parameter = i.next();
				if (parameter.getParameteredElement() == templateProperty.getType())
					typeIsExposedAsAParameter = true;
			}
			if (typeIsExposedAsAParameter) {
				// the type of the template property is exposed as a parameter
				// As a consequence, the type of the bound element property must be updated according to parameter substitutions (if any)
				TemplateBinding binding = // the binding expressed between the bound element and the template
				((org.eclipse.uml2.uml.TemplateableElement) (boundElementProperty.getOwner())).getTemplateBinding(signature);
				TemplateParameterSubstitution substitution = null;
				for (Iterator<TemplateParameterSubstitution> i = binding.getParameterSubstitutions().iterator(); i.hasNext() && substitution == null;) {
					TemplateParameterSubstitution current = i.next();
					if (current.getFormal().getParameteredElement() == templateProperty.getType())
						substitution = current;
				}
				if (substitution != null) { // one substitution has been defined for this parameter
					if (!substitution.getActuals().isEmpty() && substitution.getActuals().get(0) == boundElementProperty.getType())
						return true;
					else {
						Map<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type> types = new HashMap<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type>();
						if (!substitution.getActuals().isEmpty()) {
							types.put(boundElementProperty, (org.eclipse.uml2.uml.Type) substitution.getActuals().get(0));
						} else {
							if (boundElementProperty.getType() == null) {
								return true;
							} else {
								types.put(boundElementProperty, null);
							}
						}
						actionsToBePerformed.add(new SynchronizationAction(MODIFY_Action_Kind, boundElementProperty, templateProperty, types));
						return false;
					}
				} else {// no substitution has been defined
					if (templateProperty.getType() == boundElementProperty.getType())
						return true;
					else {
						Map<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type> types = new HashMap<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type>();
						types.put(boundElementProperty, templateProperty.getType());
						actionsToBePerformed.add(new SynchronizationAction(MODIFY_Action_Kind, boundElementProperty, templateProperty, types));
						return false;
					}
				}
			} else { // the type of template property is not exposed as a template parameter
				if (templateProperty.getType() == boundElementProperty.getType())
					return true;
				else {
					Map<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type> types = new HashMap<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type>();
					types.put(boundElementProperty, templateProperty.getType());
					actionsToBePerformed.add(new SynchronizationAction(MODIFY_Action_Kind, boundElementProperty, templateProperty, types));
					return false;
				}
			}
		}

		private boolean operationUpToDate(Operation operation) {
			return true;
		}
	}

	private final int NONE_Action_Kind = 0;

	private final int CREATE_Action_Kind = 1;

	private final int MODIFY_Action_Kind = 2;

	public class SynchronizationAction {

		protected int actionKind;

		protected Feature boundElementFeature;

		protected Feature templateFeature;

		protected Map<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type> boundTypes;

		// if boundElementFeature instanceof Property, contains the type that must be set to boundElementFeature
		// if boundElementFeature instanceof

		public SynchronizationAction(int actionKind, Feature boundElementFeature, Feature templateFeature, Map<org.eclipse.uml2.uml.Element, Type> boundTypes) {
			this.actionKind = actionKind;
			this.boundElementFeature = boundElementFeature;
			this.templateFeature = templateFeature;
			this.boundTypes = new java.util.HashMap<org.eclipse.uml2.uml.Element, org.eclipse.uml2.uml.Type>();
			if (boundTypes != null)
				this.boundTypes.putAll(boundTypes);
		}

		public String getActionKindText() {
			switch (actionKind) {
			case NONE_Action_Kind:
				return "NONE";
			case CREATE_Action_Kind:
				return "CREATE";
			case MODIFY_Action_Kind:
				return "MODIFY";
			default:
				break;
			}
			return "";
		}

		public String getOriginalFeatureText() {
			switch (actionKind) {
			case NONE_Action_Kind:
				return "";
			case CREATE_Action_Kind:
				return "<Undefined>";
			case MODIFY_Action_Kind:
				if (boundElementFeature instanceof Property) {
					String boundElementSourcePropertyTypeName = "";
					if (((Property) boundElementFeature).getType() != null)
						boundElementSourcePropertyTypeName = ((Property) boundElementFeature).getType().getName();
					else
						boundElementSourcePropertyTypeName = "<Undefined>";
					return ((Property) boundElementFeature).getName() + " : " + boundElementSourcePropertyTypeName;
				} else if (boundElementFeature instanceof Operation) {

				}
				return "";
			default:
				break;
			}
			return "";
		}

		public String getSynchronizedFeatureText() {
			if (templateFeature instanceof Property) {
				String synchronizedPropertyTypeName = "";
				String boundElementSourcePropertyTypeName = "";
				if (((Property) templateFeature).getType() != null)
					boundElementSourcePropertyTypeName = ((Property) boundElementFeature).getType().getName();
				else
					boundElementSourcePropertyTypeName = "<Undefined>";
				return ((Property) boundElementFeature).getName() + " : " + boundElementSourcePropertyTypeName;
			} else if (boundElementFeature instanceof Operation) {

			}
			return "";
		}

		public String getText() {
			String text = "";
			switch (actionKind) {
			case NONE_Action_Kind:
				text = text + "No synchronization need to be performed";
				break;
			case CREATE_Action_Kind:
				if (templateFeature instanceof Property) {
					text = text + "CREATION of property: ";
					if (boundTypes != null && boundTypes.get(uml2TemplateableElement) != null) {
						String visibility_text = "";
						if (templateFeature.getVisibility() == VisibilityKind.PUBLIC_LITERAL)
							visibility_text = "+";
						else if (templateFeature.getVisibility() == VisibilityKind.PRIVATE_LITERAL)
							visibility_text = "-";
						else if (templateFeature.getVisibility() == VisibilityKind.PROTECTED_LITERAL)
							visibility_text = "#";
						else
							visibility_text = "~";
						String upper_text = "";
						if (((Property) templateFeature).getUpper() == -1)
							upper_text = "*";
						else
							upper_text = "" + ((Property) templateFeature).getUpper();
						String multiplicity_text = "[" + ((Property) templateFeature).getLower() + ".." + upper_text + "]";
						text = text + visibility_text + " " + ((Property) templateFeature).getName() + ": " + boundTypes.get(uml2TemplateableElement).getName() + multiplicity_text;
					} else {
						text = text + new org.eclipse.papyrus.umlutils.Property((Property) templateFeature).getLabel();
					}
				} else if (templateFeature instanceof Operation) {
					text = text + "CREATION of operation: ";
					text = text + new org.eclipse.papyrus.umlutils.Operation((Operation) templateFeature).getLabel();
				}
				break;
			case MODIFY_Action_Kind:
				if (templateFeature instanceof Property) {
					text = text + "MODIFICATION of property " + boundElementFeature.getName() + "from: ";
					String boundElementSourcePropertyTypeName = "";
					if (((Property) boundElementFeature).getType() != null)
						boundElementSourcePropertyTypeName = ((Property) boundElementFeature).getType().getName();
					else
						boundElementSourcePropertyTypeName = "<Undefined>";
					String boundElementTargetPropertyTypeName = "";
					if (boundTypes.get(boundElementFeature) != null)
						boundElementTargetPropertyTypeName = boundTypes.get(boundElementFeature).getName();
					else
						boundElementTargetPropertyTypeName = "<Undefined>";
					text = text + boundElementFeature.getName() + " : " + boundElementSourcePropertyTypeName;
					text = text + ", to: ";
					text = text + boundElementFeature.getName() + " : " + boundElementTargetPropertyTypeName;
				} else if (templateFeature instanceof Operation) {

				}
				break;
			default:

				break;
			}
			return text;
		}

		// in case of modification action
		private org.eclipse.uml2.uml.Type initialType;

		public void execute() {
			switch (actionKind) {

			case CREATE_Action_Kind:
				if (this.templateFeature instanceof Property) {
					if (uml2TemplateableElement instanceof org.eclipse.uml2.uml.Class) {
						this.boundElementFeature = (new Class((org.eclipse.uml2.uml.Class) uml2TemplateableElement)).createOwnedAttributeFrom((Property) templateFeature).getUml2Property();
						((Property) this.boundElementFeature).setUpper(((Property) templateFeature).getUpper());
						((Property) this.boundElementFeature).setLower(((Property) templateFeature).getLower());
						((Property) this.boundElementFeature).setDefault(((Property) templateFeature).getDefault());
						if (boundTypes.get(uml2TemplateableElement) != null) {
							((Property) this.boundElementFeature).setType(boundTypes.get(uml2TemplateableElement));
						}
					} else if (uml2TemplateableElement instanceof org.eclipse.uml2.uml.DataType) {
						this.boundElementFeature = ((org.eclipse.uml2.uml.DataType) uml2TemplateableElement).createOwnedAttribute(((Property) templateFeature).getName(), ((Property) templateFeature)
								.getType(), ((Property) templateFeature).getLower(), ((Property) templateFeature).getUpper());
						if (boundTypes.get(uml2TemplateableElement) != null) {
							((Property) this.boundElementFeature).setType(boundTypes.get(uml2TemplateableElement));
						}
					}
				} else if (this.templateFeature instanceof Operation) {

				}
				break;

			case MODIFY_Action_Kind:
				if (this.templateFeature instanceof Property) {
					initialType = ((Property) this.boundElementFeature).getType();
					((Property) this.boundElementFeature).setType(boundTypes.get(boundElementFeature));
				} else if (this.templateFeature instanceof Operation) {

				}
				break;

			default:
				break;
			}
		}

		public void undo() {
			switch (actionKind) {
			case CREATE_Action_Kind:
				if (boundElementFeature instanceof Property) {
					if (uml2TemplateableElement instanceof org.eclipse.uml2.uml.Class) {
						((org.eclipse.uml2.uml.Class) uml2TemplateableElement).getOwnedAttributes().remove(boundElementFeature);
					} else if (uml2TemplateableElement instanceof Interface) {
						((Interface) uml2TemplateableElement).getOwnedAttributes().remove(boundElementFeature);
					} else if (uml2TemplateableElement instanceof DataType) {
						((DataType) uml2TemplateableElement).getOwnedAttributes().remove(boundElementFeature);
					} else if (uml2TemplateableElement instanceof Signal) {
						((Signal) uml2TemplateableElement).getOwnedAttributes().remove(boundElementFeature);
					} else if (uml2TemplateableElement instanceof Collaboration) {
						((Collaboration) uml2TemplateableElement).getCollaborationRoles().remove(boundElementFeature);
					}
				}
				break;

			case MODIFY_Action_Kind:
				if (boundElementFeature instanceof Property) {
					((Property) boundElementFeature).setType(initialType);
				}
				break;
			default:
				break;
			}
		}

		public void redo() {
			switch (actionKind) {
			case CREATE_Action_Kind:
				if (boundElementFeature instanceof Property) {
					if (uml2TemplateableElement instanceof org.eclipse.uml2.uml.Class) {
						((org.eclipse.uml2.uml.Class) uml2TemplateableElement).getOwnedAttributes().add((Property) boundElementFeature);
					} else if (uml2TemplateableElement instanceof Interface) {
						((Interface) uml2TemplateableElement).getOwnedAttributes().add((Property) boundElementFeature);
					} else if (uml2TemplateableElement instanceof DataType) {
						((DataType) uml2TemplateableElement).getOwnedAttributes().add((Property) boundElementFeature);
					} else if (uml2TemplateableElement instanceof Signal) {
						((Signal) uml2TemplateableElement).getOwnedAttributes().add((Property) boundElementFeature);
					} else if (uml2TemplateableElement instanceof Collaboration) {
						((Collaboration) uml2TemplateableElement).getCollaborationRoles().add((ConnectableElement) boundElementFeature);
					}
				}
				break;

			case MODIFY_Action_Kind:
				if (boundElementFeature instanceof Property) {
					((Property) boundElementFeature).setType(boundTypes.get(boundElementFeature));
				}
				break;
			default:
				break;
			}
		}
	}
}
