package org.eclipse.papyrus.diagram.common.groups.core;



public class GroupNotificationFactory {

	public enum Mode {
		/**
		 * Create a notification for choosing children
		 */
		CHOOSE_CHILDREN,
		/**
		 * Create a notification for choosing parent
		 */
		CHOOSE_PARENT
	}

	public static void getNotificationConfigurator(Mode mode) {

		switch(mode) {
		case CHOOSE_CHILDREN:

			break;
		case CHOOSE_PARENT:

			break;
		default:

			break;
		}
	}

}
