/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Manager for icons.
 * 
 * @author Remi SCHNEKENBURGER
 */
public class ImageManager {
	
	/**
	 * The Constant DEFAULT_IMAGE.
	 */
	private static final String DEFAULT_IMAGE = "resources/icons/default.gif";
	
	/**
	 * The Constant IMAGE_PATH.
	 */
	public  static final String IMAGE_PATH    = "resources/icons/";
	
	/**
	 * The Constant IMG_ADD.
	 */
	public static final Image IMG_ADD	 = getImage(IMAGE_PATH+"Add.gif");
	
	/**
	 * The Constant IMG_ADDREG.
	 */
	public static final Image IMG_ADDREG = getImage(IMAGE_PATH+"AddReg.gif");
	
	/**
	 * The Constant IMG_DELETE.
	 */
	public static final Image IMG_DELETE = getImage(IMAGE_PATH+"Delete.gif");
	
	/**
	 * The Constant IMG_UP.
	 */
	public static final Image IMG_UP	 = getImage(IMAGE_PATH+"ArrowUp.gif");
	
	/**
	 * The Constant IMG_DOWN.
	 */
	public static final Image IMG_DOWN	 = getImage(IMAGE_PATH+"ArrowDown.gif");
	
	/**
	 * The Constant IMG_LEFT.
	 */
	public static final Image IMG_LEFT	 = getImage(IMAGE_PATH+"ArrowLeft.gif");
	
	/**
	 * The Constant IMG_RIGHT.
	 */
	public static final Image IMG_RIGHT	 = getImage(IMAGE_PATH+"ArrowRight.gif");
		
	/**
	 * The Constant IMG_PROPERTY.
	 */
	public static final Image IMG_PROPERTY                = getImage(IMAGE_PATH+"Property.gif");
	
	/**
	 * The Constant IMG_STEREOTYPE.
	 */
	public static final Image IMG_STEREOTYPE              = getImage(IMAGE_PATH+"Stereotype.gif");
	
	/**
	 * The Constant IMG_LITERALBOOLEAN.
	 */
	public static final Image IMG_LITERALBOOLEAN          = getImage(IMAGE_PATH+"LiteralBoolean.gif");
	
	/**
	 * The Constant IMG_LITERALSTRING.
	 */
	public static final Image IMG_LITERALSTRING           = getImage(IMAGE_PATH+"LiteralString.gif");
	
	/**
	 * The Constant IMG_LITERALINTEGER.
	 */
	public static final Image IMG_LITERALINTEGER          = getImage(IMAGE_PATH+"LiteralInteger.gif");
	
	/**
	 * The Constant IMG_LITERALUNLIMITEDNATURAL.
	 */
	public static final Image IMG_LITERALUNLIMITEDNATURAL = getImage(IMAGE_PATH+"LiteralUnlimitedNatural.gif");
	
	/**
	 * The Constant IMG_ENUMERATION.
	 */
	public static final Image IMG_ENUMERATION             = getImage(IMAGE_PATH+"Enumeration.gif");

	/**
	 * The Constant IMG_DATATYPE.
	 */
	public static final Image IMG_DATATYPE             = getImage(IMAGE_PATH+"DataType.gif");

	
	/**
	 * The Constant IMG_STEREOTYPEPROPERTY.
	 */
	public static final Image IMG_STEREOTYPEPROPERTY      = getImage(IMAGE_PATH+"Substitution.gif");
	
	/**
	 * The Constant IMG_METACLASS.
	 */
	public static final Image IMG_METACLASS               = getImage(IMAGE_PATH+"Manifestation.gif");
	
	/**
	 * The Constant IMG_UNKNOWN.
	 */
	public static final Image IMG_UNKNOWN                 = getImage(IMAGE_PATH+"Clause.gif");

	/**
	 * The Constant IMG_PRIMITIVETYPE.
	 */
	public static final Image IMG_PRIMITIVETYPE           = getImage(IMAGE_PATH+"PrimitiveType.gif");
	
	/**
	 * The Constant IMG_PRIMITIVETYPE.
	 */
	public static final Image IMG_STEREOTYPEDISPLAYED     = getImage(IMAGE_PATH+"DisplayedStereotype_16x16.gif");


	/** The constant IMG_PACKAGE */
	public static final Image IMG_PACKAGE = getImage(IMAGE_PATH+"Package.gif");
	/** The constant IMG_PROFILE */
	public static final Image IMG_PROFILE = getImage(IMAGE_PATH+"Profile.gif");

	/** Image for Class */
	public static final Image IMG_CLASS = getImage(IMAGE_PATH+"Class.gif");

	/** Image for Instance Specification */
	public static final Image IMG_INSTANCESPEC = getImage(IMAGE_PATH+"InstanceSpecification.gif");

	/** Image for Association*/
	public static final Image IMG_ASSOCIATION = getImage(IMAGE_PATH+"Association.gif");;
	
	
	
	
	/**
	 * Returns an {@link org.eclipse.swt.graphics.Image} identified by its
	 * key.<BR>
	 * By default, it returns a default image. This image is the image placed
	 * in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key the key of the image
	 * 
	 * @return the Image
	 */
	public static Image getImage(String key) {
        ImageRegistry registry = Activator.getDefault().getImageRegistry();
        Image image = registry.get(key);
        if (image == null) {
            ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(
                    Activator.PLUGIN_ID, key);
            registry.put(key, desc);
            image = registry.get(key);
        }
        if((image == null) && !key.equals(DEFAULT_IMAGE)) {
            image = getImage(DEFAULT_IMAGE);
        }
        
        return image;
    }
}
