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
package org.eclipse.papyrus.views.properties.xwt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.views.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.views.properties.runtime.ViewConstraintEngine;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistryFactory;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * An implementation of ITabDescriptorProvider, which displays the Property view
 * from XWT files.
 * 
 * @author Camille Letavernier
 */
public class XWTTabDescriptorProvider implements ITabDescriptorProvider {

	private ITabDescriptor[] cachedResult;

	private ISelection previousSelection;

	private IWorkbenchPart previousPart;

	private final Map<IWorkbenchPart, DisplayEngine> displays = new HashMap<IWorkbenchPart, DisplayEngine>();

	private DisplayEngine getDisplay(final IWorkbenchPart part) {
		if(!displays.containsKey(part)) {
			displays.put(part, new DefaultDisplayEngine());
			part.getSite().getPage().addPartListener(new IPartListener() {

				public void partClosed(IWorkbenchPart part) {
					part.getSite().getPage().removePartListener(this);
					DisplayEngine display = displays.get(part);
					if(display != null) {
						display.dispose();
						displays.remove(part);
					}

					//We remove pointers to the cached IWorkbenchPart, to avoid Memory Leaks.
					//Even if the closed part is not the previousPart, both parts may share the same objects (e.g. ModelExplorer & DiagramEditor).
					//We'd better not retain the selection at all. In such a case, we won't receive a SelectionChangedEvent from the ModelExplorer.
					previousPart = null;
					previousSelection = null;
				}

				public void partActivated(IWorkbenchPart part) {
					//Nothing
				}

				public void partBroughtToTop(IWorkbenchPart part) {
					//Nothing
				}

				public void partDeactivated(IWorkbenchPart part) {
					//Nothing
				}

				public void partOpened(IWorkbenchPart part) {
					//Nothing
				}

			});
		}

		return displays.get(part);
	}

	public ITabDescriptor[] getTabDescriptors(final IWorkbenchPart part, final ISelection selection) {
		if(selection != this.previousSelection || part != previousPart) {
			this.previousSelection = selection;
			this.previousPart = part;

			ViewConstraintEngine constraintEngine = ConfigurationManager.getInstance().getConstraintEngine();

			List<ITabDescriptor> descriptors = new LinkedList<ITabDescriptor>();

			Set<View> views = constraintEngine.getViews(selection);
			if(!views.isEmpty()) {
				descriptors.addAll(getDisplay(part).getTabDescriptors(views));
			}

			//FIXME: In some cases (e.g. Selection in the Papyrus Tree outline), the IWorkbenchPart is not an ITabbedPropertySheetPageContributor
			//TODO: Investigate on this case and fix the issue (contributor == null in this case)
			ITabbedPropertySheetPageContributor contributor;
			if(part instanceof ITabbedPropertySheetPageContributor) {
				contributor = (ITabbedPropertySheetPageContributor)part;
			} else {
				contributor = (ITabbedPropertySheetPageContributor)(part.getAdapter(ITabbedPropertySheetPageContributor.class));
			}

			if(contributor != null) {
				// get all tab descriptors for the registered extension points
				//Memory leak here
				TabbedPropertyRegistry registry = TabbedPropertyRegistryFactory.getInstance().createRegistry(contributor);

				// invoke dynamically on the tab registry, as method is private
				// problem of implementation of tabbed properties tabbed registry. Either contribution using extension points, either a tabprovider
				// both contribution can not exist together, the only solution is to make a workaround.
				try {
					Method method = TabbedPropertyRegistry.class.getDeclaredMethod("getAllTabDescriptors"); //$NON-NLS-1$
					method.setAccessible(true);
					ITabDescriptor[] registeredTabDesriptors;

					registeredTabDesriptors = (ITabDescriptor[])method.invoke(registry);

					if(registeredTabDesriptors != null) {
						for(ITabDescriptor descriptor : registeredTabDesriptors) {
							if(descriptor.getSectionDescriptors().size() > 0) {
								descriptors.add(descriptor);
							}
						}
					}
				} catch (IllegalArgumentException e) {
					Activator.log.error(e);
				} catch (IllegalAccessException e) {
					Activator.log.error(e);
				} catch (InvocationTargetException e) {
					Activator.log.error(e);
				} catch (SecurityException e) {
					Activator.log.error(e);
				} catch (NoSuchMethodException e) {
					Activator.log.error(e);
				}
			}

			orderTabDescriptors(descriptors);

			cachedResult = descriptors.toArray(new ITabDescriptor[descriptors.size()]);

			//Workaround for memory leak
			TabbedPropertyRegistryFactory.getInstance().disposeRegistry((ITabbedPropertySheetPageContributor)part);
		}

		return cachedResult;
	}

	/**
	 * Order the tab descriptors in the given list, given the afterTab comparator
	 * 
	 * @param descriptors
	 *        tab descriptor list to order
	 */
	protected void orderTabDescriptors(final List<ITabDescriptor> descriptors) {

		Collections.sort(descriptors, new Comparator<ITabDescriptor>() {

			/**
			 * compares two tab descriptors each other
			 * 
			 * @param tabDescriptor1
			 *        first tab to compare
			 * @param tabDescriptor2
			 *        second tab to compare
			 * @return an integer lesser than -1 if the first tab should be placed before the second tab
			 */
			public int compare(ITabDescriptor tabDescriptor1, ITabDescriptor tabDescriptor2) {
				int priority1 = getPriority(tabDescriptor1);
				int priority2 = getPriority(tabDescriptor2);

				if(priority1 < priority2) {
					return -1;
				}

				if(priority1 > priority2) {
					return 1;
				}

				//p1 == p2

				priority1 = getXWTTabPriority(tabDescriptor1);
				priority2 = getXWTTabPriority(tabDescriptor2);

				if(priority1 < priority2) {
					return -1;
				}

				if(priority1 > priority2) {
					return 1;
				}

				//p1 == p2

				String label1 = tabDescriptor1.getLabel();
				String label2 = tabDescriptor2.getLabel();

				return Collator.getInstance().compare(label1, label2);
			}

			/**
			 * Returns the tab descriptor before tab
			 * 
			 * @param tab
			 *        the tab to test
			 * @return the tab descriptor before tab
			 */
			private ITabDescriptor getPreviousTab(ITabDescriptor tab) {
				String afterId = tab.getAfterTab();
				if(!(ITabDescriptor.TOP.equals(afterId))) {
					for(ITabDescriptor descriptor : descriptors) {
						String id = descriptor.getId();
						if(id != null && id.equals(afterId)) {
							return descriptor;
						}
					}

				}
				// not found. Return null
				return null;
			}

			private int getPriority(ITabDescriptor tab) {
				ITabDescriptor previousTab = getPreviousTab(tab);
				if(previousTab != null) {
					return getPriority(previousTab) + 1;
				}

				return getXWTTabPriority(tab);
			}

			private int getXWTTabPriority(ITabDescriptor tab) {
				if(tab instanceof XWTTabDescriptor) {
					XWTTabDescriptor xwtTab = (XWTTabDescriptor)tab;
					return xwtTab.getPriority();
				} else {
					return 100; //This tab is not handled by our framework
				}
			}

		});
	}
}
