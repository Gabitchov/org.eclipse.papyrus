/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.core;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.CompositeCreatorWithCommand;

/**
 * This class builds all the necessary notifications for the group framework.
 * It allows to recover configured, ready to run, notification builders.
 * 
 * @author vhemery
 */
public class GroupNotificationBuilderFactory {

	/**
	 * This class allow to recover a NotificationBuilder and a command defined by the notification execution.
	 */
	public static class NotificationBuilderAndResultingCommand {

		private NotificationBuilder builder;

		private CompositeCreatorWithCommand creator;

		public NotificationBuilderAndResultingCommand(NotificationBuilder notificationBuilder, CompositeCreatorWithCommand creatorWithCommand) {
			builder = notificationBuilder;
			creator = creatorWithCommand;
		}

		public NotificationBuilder getBuilder() {
			return builder;
		}

		public Command getResultingCommand() {
			return creator.getResultingCommand();
		}

		public CompositeCreatorWithCommand getCreator() {
			return creator;
		}
	}

	/**
	 * Create a simple notification builder from a label
	 * 
	 * @param label
	 *        Title of your notification
	 * @return a NotificationBuilder
	 */
	public static NotificationBuilder getQuestionBuilder(String label) {
		NotificationBuilder builder = NotificationBuilder.createInformationBuilder();
		builder.setType(Type.QUESTION);
		builder.setTemporary(true);
		builder.setAsynchronous(true);
		builder.setTitle(label);
		return builder;

	}

	/**
	 * Create a simple warning notification builder from a label
	 * 
	 * @param label
	 *        Title of your notification
	 * @return a NotificationBuilder
	 */
	public static NotificationBuilder getWarningBuilder(String label) {
		NotificationBuilder builder = NotificationBuilder.createInformationBuilder();
		builder.setType(Type.WARNING);
		builder.setTemporary(true);
		builder.setAsynchronous(true);
		builder.setTitle(label);
		return builder;

	}

}
