/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editors.creation;

import java.util.Collection;

import org.eclipse.swt.widgets.Control;

/**
 * A Factory for instantiating new Objects (Typically, from an Editor, although it could be
 * used elsewhere)
 * The caller of this Factory is responsible for storing the objects. However, in some cases,
 * the objects must be created in a specific parent, which is different than the Source object
 * Typically, it may happen that we need to reference an object that hasn't been yet created. If this
 * reference is the container of the object, it isn't a problem, but sometime it is not it's container.
 * In this case, it's the responsibility of the Factory to create the object in its container. The
 * caller will then refer it from wherever it needs it.
 * 
 * @author Camille Letavernier
 */
public interface ReferenceValueFactory {

	/**
	 * Creates an Object of type T
	 * The widget Control can be used to display a dialog if additional
	 * information is needed to create the object (e.g. the users needs
	 * to input a name)
	 * This method is used to create objects that <b>won't necessarily</b> be attached
	 * to a parent (For example, the user can start creating an object, then cancel the operation :
	 * the Java Object will therefore be created, but won't be attached to anything, and then will
	 * be garbage collected). That's why this method should *not* attach the object to the given source.
	 * 
	 * @param widget
	 *        The widget calling this factory. It can be used for example to retrieve
	 *        the Display for opening a Dialog
	 * @return
	 *         The newly created object.
	 */
	public Object createObject(Control widget);

	/**
	 * The objects have been validated (For example, the user pressed "Ok")
	 * This method should attach the objects where they belong.
	 * Note however that the newly created objects will automatically be attached
	 * to their source. If the source is their container, then this method should probably
	 * not do anything. However, if the source is a simple reference, this method should
	 * attach these objects to their container.
	 * 
	 * @param objectsToValidate
	 *        The newly created objects that need to be validated
	 * @return
	 *         The validated objects
	 */
	public Collection<Object> validateObjects(Collection<Object> objectsToValidate);

	/**
	 * Indicates if this factory can edit an object
	 * 
	 * @return
	 *         True if the Factory can edit an object
	 */
	public boolean canEdit();

	/**
	 * Starts the edition of the given object
	 * 
	 * @param widget
	 *        The widget calling the factory. May be used for example to retrieve the shell for opening a Dialog.
	 * @param object
	 *        The object to edit
	 */
	public void edit(Control widget, Object object);
}
