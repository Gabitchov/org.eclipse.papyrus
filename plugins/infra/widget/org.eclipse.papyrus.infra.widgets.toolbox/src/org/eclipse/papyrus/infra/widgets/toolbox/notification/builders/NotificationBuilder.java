/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.toolbox.notification.builders;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.IBuilder;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.INotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.PapyrusToolkit;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * A class creating a notification,
 * the run method launch the message according to the value of the attributes
 * 
 * @author tristan faure
 * 
 */
public class NotificationBuilder {

	private FormToolkit toolkit = PapyrusToolkit.INSTANCE;

	/** The parameters of the notification with the corresponding values */
	protected Map<String, Object> parameters = new HashMap<String, Object>();



	/** The builders creating the notification */
	protected static Map<Class<? extends IBuilder>, IBuilder> builders = getBuilders();

	/** asynchronous, determines if the message needs or not to be synchronous with the notification */
	static String ASYNCHRONOUS = "asynchronous";

	/** a message displayed in the notification */
	static String MESSAGE = "message";

	/** a composite creator for the element */
	static String COMPOSITE = "composite";

	/** a default action in the notification */
	static String ACTION = "default_action";

	/** a delay to display if it is a temporary notification */
	static String DELAY = "delay";

	/** determines if the notification is temporary */
	static String TEMPORARY = "temporary";

	/** a title displayed in the notification */
	static String TITLE = "title";

	/** determines if there is html content in the notification */
	static String HTML = "html";

	/** determines the type according to {@link Type} */
	static String TYPE = "type";

	/** an image displayed generally at the left of the notification */
	static String IMAGE = "image";

	/**
	 * Determine a specific builder class, if it is filled, it is forced to it
	 */
	protected Class<? extends IBuilder> builderClass;


	/**
	 * Returns the ibuilders able to create notifications
	 * 
	 * @return the list of {@link IBuilder}
	 */
	private static Map<Class<? extends IBuilder>, IBuilder> getBuilders() {
		Map<Class<? extends IBuilder>, IBuilder> result = new HashMap<Class<? extends IBuilder>, IBuilder>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.widgets.toolbox.papyrusNotificationBuilder");
		for(IConfigurationElement e : elements) {
			IBuilder instance;
			try {
				instance = (IBuilder)e.createExecutableExtension("builder");
				result.put(instance.getClass(), instance);
			} catch (CoreException e1) {
			}
		}
		return result;
	}

	/**
	 * Set a message for the notification
	 * 
	 * @param message
	 *        , the message to display
	 * @return this
	 */
	public NotificationBuilder setMessage(String message) {
		parameters.put(MESSAGE, message);
		return this;
	}

	/**
	 * Determines if the notification is asynchronous (don't force the user to read the notification immediately)
	 * 
	 * @param asynchronous
	 *        , true if it asynchronous
	 * @return this
	 */
	public NotificationBuilder setAsynchronous(boolean asynchronous) {
		parameters.put(ASYNCHRONOUS, asynchronous);
		return this;
	}

	/**
	 * Set a default action for the notification
	 * 
	 * @param runnable
	 *        , a runnable triggered when default action of the notification is selected
	 *        The first action added is the default One
	 * @return this
	 */
	@SuppressWarnings("unchecked")
	public NotificationBuilder addAction(NotificationRunnable runnable) {
		Collection<NotificationRunnable> runnables = (Collection<NotificationRunnable>)parameters.get(ACTION);
		if(runnables == null) {
			runnables = new LinkedList<NotificationRunnable>();
			parameters.put(ACTION, runnables);
		}
		runnables.add(runnable);
		return this;
	}

	/**
	 * Set a composite creator, able to fill a notification
	 * 
	 * @param creator
	 *        , the composite creator
	 * @return this
	 */
	public NotificationBuilder setComposite(ICompositeCreator creator) {
		parameters.put(COMPOSITE, creator);
		return this;
	}

	/**
	 * Set a delay if the notification is temporary
	 * 
	 * @param delayMs
	 *        , the delay in ms for visibility
	 * @return this
	 */
	public NotificationBuilder setDelay(long delayMs) {
		parameters.put(DELAY, delayMs);
		return this;
	}

	/**
	 * Set true if the notification is temporary
	 * 
	 * @param temporary
	 * @return this
	 */
	public NotificationBuilder setTemporary(boolean temporary) {
		parameters.put(TEMPORARY, temporary);
		return this;
	}

	/**
	 * Set a title for the notification
	 * 
	 * @param title
	 *        , the title
	 * @return this
	 */
	public NotificationBuilder setTitle(String title) {
		parameters.put(TITLE, title);
		return this;
	}

	/**
	 * Set if the notification has to understand HTML
	 * 
	 * @param useHTML
	 * @return this
	 */
	public NotificationBuilder setHTML(boolean useHTML) {
		parameters.put(HTML, useHTML);
		return this;
	}

	/**
	 * Set the type of the notification according to {@link Type}
	 * 
	 * @param type
	 *        , the desired type
	 * @return this
	 */
	public NotificationBuilder setType(Type type) {
		parameters.put(TYPE, type);
		return this;
	}

	/**
	 * Set an image for the notification
	 * 
	 * @param image
	 *        , the desired image
	 * @return this
	 */
	public NotificationBuilder setImage(Image image) {
		parameters.put(IMAGE, image);
		return this;
	}

	/**
	 * Force a builder class
	 * 
	 * @param builderClass
	 *        , a class which inherits from {@link IBuilder}
	 * @return this
	 */
	public NotificationBuilder setBuilderClass(Class<? extends IBuilder> builderClass) {
		this.builderClass = builderClass;
		return this;
	}

	/**
	 * Allows the developer to use a specific parameter
	 * 
	 * @param name
	 *        , the key of the parameter
	 * @param value
	 *        , the value
	 * @return this
	 */
	public NotificationBuilder setParameter(String name, Object value) {
		parameters.put(name, value);
		return this;
	}

	/**
	 * Creates a notification according to different parameters
	 */
	public INotification run() {
		Set<IBuilder> copy = null;
		if(builderClass != null) {
			copy = new HashSet<IBuilder>();
			try {
				copy.add(builderClass.newInstance());
			} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			}
		} else {
			copy = new HashSet<IBuilder>(builders.values());
		}
		for(Iterator<IBuilder> i = copy.iterator(); i.hasNext();) {
			IBuilder b = i.next();
			for(String string : parameters.keySet()) {
				if(!b.accept(string, parameters.get(string))) {
					i.remove();
					break;
				}
			}
		}
		INotification result = null;
		PropertyWrapper wrapper = new PropertyWrapper(parameters);
		if(copy.size() >= 1) {
			result = copy.iterator().next().build(wrapper, toolkit);
			// default case : the popup
		} else if(copy.isEmpty()) {
			result = builders.get(PopupBuilder.class).build(wrapper, toolkit);
		}
		return result;
	}

	/**
	 * Creates a notification builder already configured to display an information builder
	 * 
	 * @return a notification builder
	 */
	public static NotificationBuilder createInformationBuilder() {
		NotificationBuilder builder = new NotificationBuilder();
		return builder;
	}

	/**
	 * Creates a notification builder already configured to display an asynchronous popup
	 * 
	 * @param text
	 *        , the text to display
	 * @return a notification builder
	 */
	public static NotificationBuilder createAsyncPopup(String text) {
		return new NotificationBuilder().setAsynchronous(true).setTemporary(true).setMessage(text).setDelay(2000);
	}

	/**
	 * Creates a notification builder already configured to display an asynchronous popup with a specified title
	 * 
	 * @param text
	 *        , the text to display
	 * @param title
	 *        , the title of the popup
	 * @return a notification builder
	 */
	public static NotificationBuilder createAsyncPopup(String title, String text) {
		return new NotificationBuilder().setAsynchronous(true).setTemporary(true).setMessage(text).setTitle(title).setDelay(2000);
	}

	/**
	 * Creates a notification builder already configured to display an information popup
	 * 
	 * @param text
	 *        , the text to display
	 * @return a notification builder
	 */
	public static NotificationBuilder createInfoPopup(String text) {
		return new NotificationBuilder().setAsynchronous(false).setTemporary(false).setMessage(text).setType(Type.INFO);
	}

	/**
	 * Creates a notification builder already configured to display an warning popup
	 * 
	 * @param text
	 *        , the text to display
	 * @return a notification builder
	 */
	public static NotificationBuilder createWarningPopup(String text) {
		return new NotificationBuilder().setAsynchronous(false).setTemporary(false).setMessage(text).setType(Type.WARNING);
	}

	/**
	 * Creates a notification builder already configured to display a popup with question icon
	 * 
	 * @param text
	 *        , the text to display
	 * @return a notification builder
	 */
	public static NotificationBuilder createQuestionPopup(String text) {
		return new NotificationBuilder().setAsynchronous(false).setTemporary(false).setMessage(text).setType(Type.QUESTION);
	}

	/**
	 * Creates a notification builder already configured to display a popup with error icon
	 * 
	 * @param text
	 *        , the text to display
	 * @return a notification builder
	 */
	public static NotificationBuilder createErrorPopup(String text) {
		return new NotificationBuilder().setAsynchronous(false).setTemporary(false).setMessage(text).setType(Type.ERROR);
	}

	/**
	 * Creates a notification builder already configured to display a yes no question
	 * 
	 * @param yes
	 *        , the action to launch if yes is selected
	 * @param no
	 *        , the action to launch if no is selected
	 * @return a notification builder
	 */
	public static NotificationBuilder createYesNo(String message, final Runnable yes, final Runnable no) {
		return new NotificationBuilder().setType(Type.QUESTION).setAsynchronous(false).setTemporary(false).setMessage(message).addAction(new NotificationRunnable() {

			public void run(IContext context) {
				if(yes != null) {
					context.put(IContext.ACTION_ID, SWT.YES);
					yes.run();
				}
			}

			public String getLabel() {
				return "Yes";
			}
		}).addAction(new NotificationRunnable() {

			public void run(IContext context) {
				if(no != null) {
					context.put(IContext.ACTION_ID, SWT.NO);
					no.run();
				}
			}

			public String getLabel() {
				return "No";
			}
		});
	}

	/**
	 * Creates a notification builder already configured to display a yes no question, no runnables are necesary as the user just want the
	 * PopupNotification result
	 * This NotificationRunnable is not intended to be changed to an asynchronous notification for example
	 * When the run method is called use getRsult method in {@link PopupNotification} and test if the value is SWT.YES or SWT.NO
	 * @param message
	 *        , the message to display
	 * 
	 * @return a notification builder
	 */
	public static NotificationBuilder createYesNo(String message) {
		return new NotificationBuilder().setType(Type.QUESTION).setAsynchronous(false).setTemporary(false).setMessage(message).addAction(new NotificationRunnable() {

			public void run(IContext context) {
				context.put(IContext.ACTION_ID, SWT.YES);
			}

			public String getLabel() {
				return "Yes";
			}
		}).addAction(new NotificationRunnable() {

			public void run(IContext context) {
				context.put(IContext.ACTION_ID, SWT.NO);
			}

			public String getLabel() {
				return "No";
			}
		});
	}

	/**
	 * Creates a notification builder already configured to display a yes no question
	 * 
	 * @param yes
	 *        , the action to launch if yes is selected
	 * @param no
	 *        , the action to launch if no is selected
	 * @return a notification builder
	 */
	public static NotificationBuilder createYesNo(String message, final NotificationRunnable yes, final NotificationRunnable no) {
		return new NotificationBuilder().setType(Type.QUESTION).setAsynchronous(false).setTemporary(false).setMessage(message).addAction(new NotificationRunnable() {

			public void run(IContext context) {
				if(yes != null) {
					context.put(IContext.ACTION_ID, SWT.YES);
					yes.run(context);
				}
			}

			public String getLabel() {
				return "Yes";
			}
		}).addAction(new NotificationRunnable() {

			public void run(IContext context) {
				if(no != null) {
					context.put(IContext.ACTION_ID, SWT.NO);
					no.run(context);
				}
			}

			public String getLabel() {
				return "No";
			}
		});
	}

	/**
	 * Return the system image according to the imageID
	 * 
	 * @param imageID
	 * @param shell
	 * @return
	 */
	public static Image getSWTImage(final int imageID, Shell shell) {
		final Display display;
		if(shell == null || shell.isDisposed()) {
			display = Display.getCurrent();
			// The dialog should be always instantiated in UI thread.
			// However it was possible to instantiate it in other threads
			// (the code worked in most cases) so the assertion covers
			// only the failing scenario. See bug 107082 for details.
			Assert.isNotNull(display, "The dialog should be created in UI thread"); //$NON-NLS-1$
		} else {
			display = shell.getDisplay();
		}

		final Image[] image = new Image[1];
		display.syncExec(new Runnable() {

			public void run() {
				image[0] = display.getSystemImage(imageID);
			}
		});

		return image[0];
	}
}
