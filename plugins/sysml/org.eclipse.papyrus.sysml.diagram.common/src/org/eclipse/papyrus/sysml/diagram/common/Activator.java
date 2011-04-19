package org.eclipse.papyrus.sysml.diagram.common;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.log.LogHelper;
import org.eclipse.papyrus.sysml.activities.provider.ActivitiesItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.allocations.provider.AllocationsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.blocks.provider.BlocksItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.constraints.provider.ConstraintsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.modelelements.provider.ModelelementsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.portandflows.provider.PortandflowsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.requirements.provider.RequirementsItemProviderAdapterFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** The Constant ID. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.sysml.diagram.common"; //$NON-NLS-1$

	/** Shared instance of the plug-in (singleton pattern) */
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log;

	/** The composed adapter factory */
	private ComposedAdapterFactory adapterFactory;

	/** Default constructor */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// register the login helper
		log = new LogHelper(plugin);

		// prepare the composed adapter factory
		adapterFactory = createAdapterFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getInstance() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @generated
	 * @param path
	 *        the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
	 * 
	 * @return Shared Preference Store.
	 */
	@Override
	public IPreferenceStore getPreferenceStore() {
		IPreferenceStore store = org.eclipse.papyrus.preferences.Activator.getDefault().getPreferenceStore();
		return store;
	}

	/**
	 * Get the item provider adapter factory.
	 * 
	 * @return the adapter factory.
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * Get an image descriptor for current item.
	 * 
	 * @param item
	 *        the item for which an image descriptor searched.
	 * @return the image descriptor.
	 */
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider)adapterFactory.adapt(item, IItemLabelProvider.class);
		if(labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(item));
		}
		return null;
	}

	/**
	 * Get an image for a ENamedElement in plug-in image registry.
	 * 
	 * @param element
	 *        the element.
	 * @return the image.
	 */
	public Image getImage(ENamedElement element) {

		String imageKey = element.getName();

		Image image = getImageRegistry().get(imageKey);
		if(image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(imageKey, imageDescriptor);
			image = getImageRegistry().get(imageKey);
		}
		return image;
	}


	/**
	 * Create a new Composed adapter factory for this plug-in.
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();

		// Add SysML adapters
		factories.add(new ActivitiesItemProviderAdapterFactory());
		factories.add(new AllocationsItemProviderAdapterFactory());
		factories.add(new BlocksItemProviderAdapterFactory());
		factories.add(new ConstraintsItemProviderAdapterFactory());
		factories.add(new ModelelementsItemProviderAdapterFactory());
		factories.add(new PortandflowsItemProviderAdapterFactory());
		factories.add(new RequirementsItemProviderAdapterFactory());
		// Add UML adapter   
		factories.add(new UMLItemProviderAdapterFactory());

		// Other adapters
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}

	private ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature)element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass && !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			if(!eClass.isAbstract()) {
				return getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}


}
