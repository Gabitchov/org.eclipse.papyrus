/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Node;

/**
 * Generic class for actions modifying directly the models (graphic or semantic
 * model)
 */
public abstract class ModelPostAction implements IPostAction {

	/** factory used to create this action */
	protected IAspectActionProvider factory;

	/**
	 * @{inheritDoc
	 */
	public IStatus checkPostCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * @{inheritDoc
	 */
	public IStatus checkPreCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * @{inheritDoc
	 */
	public void init(Node configurationNode, IAspectActionProvider factory) {
		this.factory = factory;
	}

	/**
	 * @{inheritDoc
	 */
	public String getFactoryId() {
		return factory.getFactoryId();
	}

	/**
	 * @{inheritDoc
	 */
	public Image getImage() {
		return factory.getImage();
	}

	/**
	 * @{inheritDoc
	 */
	public String getLabel() {
		return factory.getName();
	}

	/**
	 * @{inheritDoc
	 */
	public abstract void run(EditPart editPart);

	/**
	 * Retrieves the valid type of an object given the structural feature for
	 * which it gives a value
	 * 
	 * @param feature
	 *        the valued feature
	 * @param value
	 *        value of the feature
	 * @return the same value, but correctly cast.
	 */
	protected Object getValue(EStructuralFeature feature, Object value) {
		EClassifier type = feature.getEType();
		if(type instanceof EDataType) {
			Class<?> iClass = type.getInstanceClass();
			if(Boolean.TYPE.equals(iClass)) {
				if(value instanceof Boolean) {
					// ok
				} else if(value instanceof String) {
					value = Boolean.valueOf((String)value);
				} else {
					Activator.log.error("impossible to parse value " + value, null);
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
					Activator.log.error("impossible to parse value " + value, null);
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
							Activator.log.error("impossible to parse value " + value, nfe);
						}
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
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
							Activator.log.error("impossible to parse value " + value, nfe);
						}
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
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
							Activator.log.error("impossible to parse value " + value, nfe);
						}
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
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
							Activator.log.error("impossible to parse value " + value, nfe);
						}
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
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
							Activator.log.error("impossible to parse value " + value, nfe);
						}
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
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
							Activator.log.error("impossible to parse value " + value, nfe);
						}
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
				}
			} else if(type instanceof EEnum) {
				if(value instanceof String) {
					EEnumLiteral literal = ((EEnum)type).getEEnumLiteralByLiteral((String)value);
					if(literal == null) {
						Activator.log.error("impossible to parse null value literal", null);
					} else {
						value = literal.getInstance();
					}
				} else {
					Activator.log.error("impossible to parse value " + value, null);
				}
			}
		}
		return value;
	}

}
