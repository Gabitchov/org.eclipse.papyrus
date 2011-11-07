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
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.parsers;

import java.util.Arrays;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.component.part.Messages;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractParser.
 * 
 * @generated
 */
public abstract class AbstractParser implements IParser {

	/** The features. @generated */
	protected final EAttribute[] features;

	/** The editable features. @generated */
	protected final EAttribute[] editableFeatures;

	/** The view pattern. @generated */
	private String viewPattern;

	/** The editor pattern. @generated */
	private String editorPattern;

	/** The edit pattern. @generated */
	private String editPattern;

	/**
	 * Instantiates a new abstract parser.
	 * 
	 * @param features
	 *        the features
	 * @generated
	 */
	public AbstractParser(EAttribute[] features) {
		if(features == null || Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.editableFeatures = this.features = features;
	}

	/**
	 * Instantiates a new abstract parser.
	 * 
	 * @param features
	 *        the features
	 * @param editableFeatures
	 *        the editable features
	 * @generated
	 */
	public AbstractParser(EAttribute[] features, EAttribute[] editableFeatures) {
		if(features == null || Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.features = features;
		if(editableFeatures == null || Arrays.asList(editableFeatures).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.editableFeatures = editableFeatures;
	}

	/**
	 * Gets the view pattern.
	 * 
	 * @return the view pattern
	 * @generated
	 */
	public String getViewPattern() {
		return viewPattern;
	}

	/**
	 * Sets the view pattern.
	 * 
	 * @param viewPattern
	 *        the new view pattern
	 * @generated
	 */
	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
	}

	/**
	 * Gets the editor pattern.
	 * 
	 * @return the editor pattern
	 * @generated
	 */
	public String getEditorPattern() {
		return editorPattern;
	}

	/**
	 * Sets the editor pattern.
	 * 
	 * @param editorPattern
	 *        the new editor pattern
	 * @generated
	 */
	public void setEditorPattern(String editorPattern) {
		this.editorPattern = editorPattern;
	}

	/**
	 * Gets the edits the pattern.
	 * 
	 * @return the edits the pattern
	 * @generated
	 */
	public String getEditPattern() {
		return editPattern;
	}

	/**
	 * Sets the edits the pattern.
	 * 
	 * @param editPattern
	 *        the new edits the pattern
	 * @generated
	 */
	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
	}

	/**
	 * Checks if is affecting event.
	 * 
	 * @param event
	 *        the event
	 * @param flags
	 *        the flags
	 * @return true, if is affecting event
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if(event instanceof Notification) {
			return isAffectingFeature(((Notification)event).getFeature());
		}
		return false;
	}

	/**
	 * Checks if is affecting feature.
	 * 
	 * @param feature
	 *        the feature
	 * @return true, if is affecting feature
	 * @generated
	 */
	protected boolean isAffectingFeature(Object feature) {
		for(int i = 0; i < features.length; i++) {
			if(features[i] == feature) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the completion processor.
	 * 
	 * @param element
	 *        the element
	 * @return the completion processor
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * Gets the values.
	 * 
	 * @param element
	 *        the element
	 * @return the values
	 * @generated
	 */
	protected Object[] getValues(EObject element) {
		Object[] values = new Object[features.length];
		for(int i = 0; i < features.length; i++) {
			values[i] = getValue(element, features[i]);
		}
		return values;
	}

	/**
	 * Gets the editable values.
	 * 
	 * @param element
	 *        the element
	 * @return the editable values
	 * @generated
	 */
	protected Object[] getEditableValues(EObject element) {
		Object[] values = new Object[editableFeatures.length];
		for(int i = 0; i < editableFeatures.length; i++) {
			values[i] = getValue(element, editableFeatures[i]);
		}
		return values;
	}

	/**
	 * Gets the value.
	 * 
	 * @param element
	 *        the element
	 * @param feature
	 *        the feature
	 * @return the value
	 * @generated
	 */
	protected Object getValue(EObject element, EAttribute feature) {
		Object value = element.eGet(feature);
		Class iClass = feature.getEAttributeType().getInstanceClass();
		if(String.class.equals(iClass)) {
			if(value == null) {
				value = ""; //$NON-NLS-1$
			}
		}
		return value;
	}

	/**
	 * Gets the parses the command.
	 * 
	 * @param adapter
	 *        the adapter
	 * @param values
	 *        the values
	 * @param flags
	 *        the flags
	 * @return the parses the command
	 * @generated
	 */
	protected ICommand getParseCommand(IAdaptable adapter, Object[] values, int flags) {
		if(values == null || validateNewValues(values).getCode() != IParserEditStatus.EDITABLE) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		for(int i = 0; i < values.length; i++) {
			command.compose(getModificationCommand(element, editableFeatures[i], values[i]));
		}
		return command;
	}

	/**
	 * Gets the modification command.
	 * 
	 * @param element
	 *        the element
	 * @param feature
	 *        the feature
	 * @param value
	 *        the value
	 * @return the modification command
	 * @generated
	 */
	protected ICommand getModificationCommand(EObject element, EAttribute feature, Object value) {
		value = getValidNewValue(feature, value);
		if(value instanceof InvalidValue) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new SetRequest(element, feature, value);
		return new SetValueCommand(request);
	}

	/**
	 * Validate new values.
	 * 
	 * @param values
	 *        the values
	 * @return the i parser edit status
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(Object[] values) {
		if(values.length != editableFeatures.length) {
			return ParserEditStatus.UNEDITABLE_STATUS;
		}
		for(int i = 0; i < values.length; i++) {
			Object value = getValidNewValue(editableFeatures[i], values[i]);
			if(value instanceof InvalidValue) {
				return new ParserEditStatus(UMLDiagramEditorPlugin.ID, IParserEditStatus.UNEDITABLE, value.toString());
			}
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * Gets the valid new value.
	 * 
	 * @param feature
	 *        the feature
	 * @param value
	 *        the value
	 * @return the valid new value
	 * @generated
	 */
	protected Object getValidNewValue(EAttribute feature, Object value) {
		EClassifier type = feature.getEType();
		if(type instanceof EDataType) {
			Class iClass = type.getInstanceClass();
			if(Boolean.TYPE.equals(iClass)) {
				if(value instanceof Boolean) {
					// ok
				} else if(value instanceof String) {
					value = Boolean.valueOf((String)value);
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Character.TYPE.equals(iClass)) {
				if(value instanceof Character) {
					// ok
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						value = new Character(s.charAt(0));
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Byte.TYPE.equals(iClass)) {
				if(value instanceof Byte) {
					// ok
				} else if(value instanceof Number) {
					value = new Byte(((Number)value).byteValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Byte.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Short.TYPE.equals(iClass)) {
				if(value instanceof Short) {
					// ok
				} else if(value instanceof Number) {
					value = new Short(((Number)value).shortValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Short.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Integer.TYPE.equals(iClass)) {
				if(value instanceof Integer) {
					// ok
				} else if(value instanceof Number) {
					value = new Integer(((Number)value).intValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Integer.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Long.TYPE.equals(iClass)) {
				if(value instanceof Long) {
					// ok
				} else if(value instanceof Number) {
					value = new Long(((Number)value).longValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Long.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Float.TYPE.equals(iClass)) {
				if(value instanceof Float) {
					// ok
				} else if(value instanceof Number) {
					value = new Float(((Number)value).floatValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Float.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(Double.TYPE.equals(iClass)) {
				if(value instanceof Double) {
					// ok
				} else if(value instanceof Number) {
					value = new Double(((Number)value).doubleValue());
				} else if(value instanceof String) {
					String s = (String)value;
					if(s.length() == 0) {
						value = null;
					} else {
						try {
							value = Double.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(NLS.bind(Messages.AbstractParser_WrongStringConversion, iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, iClass.getName()));
				}
			} else if(type instanceof EEnum) {
				if(value instanceof String) {
					EEnumLiteral literal = ((EEnum)type).getEEnumLiteralByLiteral((String)value);
					if(literal == null) {
						value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnknownLiteral, value));
					} else {
						value = literal.getInstance();
					}
				} else {
					value = new InvalidValue(NLS.bind(Messages.AbstractParser_UnexpectedValueType, String.class.getName()));
				}
			}
		}
		return value;
	}

	/**
	 * The Class InvalidValue.
	 * 
	 * @generated
	 */
	protected class InvalidValue {

		/** The description. @generated */
		private String description;

		/**
		 * Instantiates a new invalid value.
		 * 
		 * @param description
		 *        the description
		 * @generated
		 */
		public InvalidValue(String description) {
			this.description = description;
		}

		/**
		 * To string.
		 * 
		 * @return the string
		 * @generated
		 */
		public String toString() {
			return description;
		}
	}
}
