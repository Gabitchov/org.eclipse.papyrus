package org.eclipse.papyrus.sysml.diagram.common;

import java.util.ArrayList;

import org.eclipse.draw2d.PositionConstants;
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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.osgi.framework.BundleContext;
//import org.eclipse.papyrus.sysml.activities.provider.ActivitiesItemProviderAdapterFactory;
//import org.eclipse.papyrus.sysml.allocations.provider.AllocationsItemProviderAdapterFactory;
//import org.eclipse.papyrus.sysml.blocks.provider.BlocksItemProviderAdapterFactory;
//import org.eclipse.papyrus.sysml.constraints.provider.ConstraintsItemProviderAdapterFactory;
//import org.eclipse.papyrus.sysml.modelelements.provider.ModelelementsItemProviderAdapterFactory;
//import org.eclipse.papyrus.sysml.portandflows.provider.PortandflowsItemProviderAdapterFactory;
//import org.eclipse.papyrus.sysml.requirements.provider.RequirementsItemProviderAdapterFactory;

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

	/** generic label provider based on EMF facet */
	private UMLLabelProvider labelProvider;

	/** Default constructor */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
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
	@Override
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		if(labelProvider != null) {
			labelProvider.dispose();
			labelProvider = null;
		}
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
		IPreferenceStore store = org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();
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
	 * <pre>
	 * Provide a FlowPort image for border edit part that take the border item position
	 * into account.
	 * 
	 * The image is not rotated, but predefined.
	 * 
	 * The side of the image (relatively to the parent figure) can be:
	 *         <ul>
	 *         <li>{@linkplain PositionConstants#NORTH}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH}</li>
	 *         <li> {@linkplain PositionConstants#EAST}</li>
	 *         <li> {@linkplain PositionConstants#WEST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_WEST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_WEST}</li>
	 *         </ul>
	 * 
	 * </pre>
	 */
	public Image getFlowPortImage(FlowPort flowport, int side) {

		// Prepare the image key
		String imageKey = "FlowPort_";
		if(flowport.isAtomic()) {
			if(flowport.getDirection() == FlowDirection.IN) {
				imageKey = imageKey + "IN_";
			} else if(flowport.getDirection() == FlowDirection.OUT) {
				imageKey = imageKey + "OUT_";
			} else if(flowport.getDirection() == FlowDirection.INOUT) {
				imageKey = imageKey + "INOUT_";
			}

			imageKey = imageKey + "A_";
		} else {
			imageKey = imageKey + "NA_";
		}

		if(side == PositionConstants.WEST) {
			imageKey = imageKey + "WEST";
		} else if(side == PositionConstants.NORTH) {
			imageKey = imageKey + "NORTH";
		} else if(side == PositionConstants.SOUTH) {
			imageKey = imageKey + "SOUTH";
		} else if(side == PositionConstants.EAST) {
			imageKey = imageKey + "EAST";
		} else if(side == PositionConstants.NORTH_WEST) {
			imageKey = imageKey + "NORTH_WEST";
		} else if(side == PositionConstants.NORTH_EAST) {
			imageKey = imageKey + "NORTH_EAST";
		} else if(side == PositionConstants.SOUTH_EAST) {
			imageKey = imageKey + "SOUTH_EAST";
		} else if(side == PositionConstants.SOUTH_WEST) {
			imageKey = imageKey + "SOUTH_WEST";
		}

		// Retrieve image from registry or add it in the registry
		Image image = getImageRegistry().get(imageKey);
		if(image == null) {

			ImageDescriptor imageDescriptor = imageDescriptorFromPlugin(PLUGIN_ID, "/icons/flowports/" + imageKey + ".gif");

			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(imageKey, imageDescriptor);
			image = getImageRegistry().get(imageKey);
		}

		return image;
	}

	/**
	 * Returns a label provider supported by EMF Facet
	 * 
	 * @return a label provider supported by EMF Facet
	 */
	public ILabelProvider getLabelProvider() {
		if(labelProvider == null) {
			// add a generic label provider for sysml elements
			labelProvider = new UMLLabelProvider();
		}
		return labelProvider;
	}

	/**
	 * Create a new Composed adapter factory for this plug-in.
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();

		// Add SysML adapters
//		factories.add(new ActivitiesItemProviderAdapterFactory());
//		factories.add(new AllocationsItemProviderAdapterFactory());
//		factories.add(new BlocksItemProviderAdapterFactory());
//		factories.add(new ConstraintsItemProviderAdapterFactory());
//		factories.add(new ModelelementsItemProviderAdapterFactory());
//		factories.add(new PortandflowsItemProviderAdapterFactory());
//		factories.add(new RequirementsItemProviderAdapterFactory());
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
