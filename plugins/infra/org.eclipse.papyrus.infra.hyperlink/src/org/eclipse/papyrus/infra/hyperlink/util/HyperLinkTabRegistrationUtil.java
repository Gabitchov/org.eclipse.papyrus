package org.eclipse.papyrus.infra.hyperlink.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.ui.AbstractHyperLinkTab;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkTab;


public class HyperLinkTabRegistrationUtil {

	private static final String HYPERLINK_TAB_REGISTRATION_ID = "org.eclipse.papyrus.infra.hyperlink.tab.registration";

	public static final HyperLinkTabRegistrationUtil INSTANCE = new HyperLinkTabRegistrationUtil();

	private static  Map<Integer, AbstractHyperLinkTab> allTabs;

	private HyperLinkTabRegistrationUtil() {
		//nothing to do
	}

	public Collection<AbstractHyperLinkTab> getAllHyperLinkTab() {
//		if(allTabs == null) {
			allTabs = new TreeMap<Integer, AbstractHyperLinkTab>();
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(HYPERLINK_TAB_REGISTRATION_ID);
			for(IConfigurationElement e : config) {
				AbstractHyperLinkTab tab = null;
				try {
					final Object h = e.createExecutableExtension("tab");
					if(h instanceof AbstractHyperLinkTab) {
						tab = (AbstractHyperLinkTab)h;
						String o = e.getAttribute("position", null);
						Integer position = Integer.valueOf(o);
						String tabId = e.getAttribute("tabId", null);
						tab.setTabId(tabId);
						allTabs.put(position,tab);
					} else {
						Activator.log.info(NLS.bind("{0} is not an instanceof {1}", new Object[]{ h, AbstractHyperLinkTab.class }));
					}
				}catch (NumberFormatException ex){
					Activator.log.error(NLS.bind("The tab {0} will be ignored because I can't read its position", tab), ex);
				} catch (CoreException ex) {
					Activator.log.error("I can't create the class for a tab", ex);
				}
			}
			
			//we create the tab for the helpers
			Map<Integer,AbstractHyperLinkHelper> helpers = HyperLinkRegistration.INSTANCE.getHelperWithPosition();
			Iterator<Integer> iter = helpers.keySet().iterator();
			while(iter.hasNext()){
				Integer position = iter.next();
				AbstractHyperLinkHelper helper = helpers.get(position);
				allTabs.put(position, new HyperLinkTab(helper.getTabId(), helper));
			}
//		}
		return allTabs.values();
	}
}
