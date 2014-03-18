package aspects.xpt.plugin

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import plugin.Activator
import xpt.Common

@Singleton class ActivatorImpl extends xpt.plugin.ActivatorImpl {
	@Inject extension Common;
	
	@Inject Activator xptActivator;

	
	override ActivatorImpl(GenPlugin it)'''
		«copyright(editorGen)»
		package «xptActivator.packageName(it)»;

		«generatedClassComment»
		public class «xptActivator.className(it)» extends org.eclipse.ui.plugin.AbstractUIPlugin {

		«attrs(it)»
		«constructor(it)»
		«start(it)»
		«stop(editorGen)»
		«getInstance(it)»
		
		«getPreferenceStore»

		«createAdapterFactory(editorGen.diagram)»
		«fillItemProviderFactories(editorGen)»
		«getItemProvidersAdaptorFactory(it)»
		«getItemImageDescriptor(it)»
		«getBundleDescriptorImage(it)»
		«findImageDescriptor(it)»
		«getBundleImage(it)»
		«getString(it)»
		«documentProviderGetter(editorGen.diagram)»
		«linkConstraint(editorGen.diagram)»
		«initializerGetter(editorGen.diagram)»
		«initializerSetter(editorGen.diagram)»
		«providersAccessMethods(it)»
		«logError(it)»
		«logInfo(it)»
		«debug(it)»
		«additions(it)»
	}
'''


override start(GenPlugin it)'''
	«generatedMemberComment»
	public void start(org.osgi.framework.BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
		adapterFactory = createAdapterFactory();
		«it.editorGen.diagram.preferencesPackageName».DiagramPreferenceInitializer diagramPreferenceInitializer = new «it.editorGen.diagram.preferencesPackageName».DiagramPreferenceInitializer();
		diagramPreferenceInitializer.initializeDefaultPreferences();
		
	}
'''


def getPreferenceStore()'''
	«generatedMemberComment»
	 public org.eclipse.jface.preference.IPreferenceStore getPreferenceStore() {
	 	org.eclipse.jface.preference.IPreferenceStore store=org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();
	     return store;
	    }

'''

}