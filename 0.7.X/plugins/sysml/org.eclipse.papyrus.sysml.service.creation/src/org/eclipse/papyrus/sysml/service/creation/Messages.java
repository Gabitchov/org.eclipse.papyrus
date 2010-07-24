package org.eclipse.papyrus.sysml.service.creation;

import org.eclipse.osgi.util.NLS;

/**
 * this class contains all messages for this creation service
 *
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.sysml.service.creation.messages"; //$NON-NLS-1$

	/**
	 * the message to explain a mistake about profile
	 */
	public static String ERROR_MESSAGE_PROFILE_BEGIN;

	/**
	 * the message to explain a mistake about profile
	 */
	public static String ERROR_MESSAGE_PROFILE_END;

	/**
	 * the message to explain that the owner is not a block
	 */
	public static String TheOwnerIsNotABlock;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
