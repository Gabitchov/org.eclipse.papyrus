package aspects.xpt.plugin

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter
import org.eclipse.gmf.codegen.gmfgen.GenPlugin
import plugin.Activator
import xpt.Common
import xpt.editor.DocumentProvider
import xpt.providers.ElementInitializers
import xpt.expressions.getExpression

@Singleton class ActivatorImpl extends xpt.plugin.ActivatorImpl {
	@Inject extension Common;

	@Inject Activator xptActivator;
	@Inject DocumentProvider xptDocProvider;
	@Inject ElementInitializers xptElementInitializers;
	@Inject getExpression xptExpr;
	
	override ActivatorImpl(GenPlugin it) '''
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
			«getLogError(it)»
			«additions(it)»
		}
	'''

override attrs(GenPlugin it)'''
	«generatedMemberComment»
	public static final String ID = "«ID»"; //$NON-NLS-1$

	«generatedMemberComment»
	private org.eclipse.papyrus.infra.core.log.LogHelper myLogHelper;

	«generatedMemberComment»
	public static final org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint DIAGRAM_PREFERENCES_HINT =
			new org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint(ID);

	«generatedMemberComment»
	private static «xptActivator.className(it)» instance;

	«generatedMemberComment»
	private org.eclipse.emf.edit.provider.ComposedAdapterFactory adapterFactory;	

	«generatedMemberComment»
	private «xptDocProvider.qualifiedClassName(editorGen.diagram)» documentProvider;

	«IF editorGen.diagram.links.exists(l| !l.sansDomain)»
		«generatedMemberComment»
		private «editorGen.diagram.getLinkCreationConstraintsQualifiedClassName()» linkConstraints;
	«ENDIF»

	«generatedMemberComment»
	private «xptElementInitializers.qualifiedClassName(editorGen.diagram)» initializers;

	«IF it.editorGen.expressionProviders != null»
		«FOR p : it.editorGen.expressionProviders.providers.filter(typeof(GenExpressionInterpreter))»
			«generatedMemberComment»
			private «xptExpr.getExpressionInterpriterQualifiedClassName(p)» «p.language»Factory;
		«ENDFOR»
	«ENDIF»
'''

	override start(GenPlugin it) '''
		«generatedMemberComment»
		public void start(org.osgi.framework.BundleContext context) throws Exception {
			super.start(context);
			instance = this;
			myLogHelper = new org.eclipse.papyrus.infra.core.log.LogHelper(this);
			org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
			adapterFactory = createAdapterFactory();
			«it.editorGen.diagram.preferencesPackageName».DiagramPreferenceInitializer diagramPreferenceInitializer = new «it.
			editorGen.diagram.preferencesPackageName».DiagramPreferenceInitializer();
			diagramPreferenceInitializer.initializeDefaultPreferences();
			
		}
	'''

	def getPreferenceStore() '''
		«generatedMemberComment»
		 public org.eclipse.jface.preference.IPreferenceStore getPreferenceStore() {
		 	org.eclipse.jface.preference.IPreferenceStore store=org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();
		 	   return store;
		 	}
		
	'''

	override logError(GenPlugin it) '''
		«generatedMemberComment»
		public void logError(String error) {
			getLogHelper().warn(error);
		}
		
		«generatedMemberComment»
		public void logError(String error, Throwable throwable) {
			getLogHelper().error(error, throwable);
		}
	'''

	override logInfo(GenPlugin it) '''
		«generatedMemberComment»
		public void logInfo(String message) {
			getLogHelper().info(message);
		}
		
		«generatedMemberComment»
		public void logInfo(String message, Throwable throwable) {
			getLogHelper().error(message, throwable);
		}
	'''

	override getLogError(GenPlugin it) '''
		«generatedMemberComment»
		public org.eclipse.papyrus.infra.core.log.LogHelper getLogHelper() {
			return myLogHelper;
		}
	'''
}
