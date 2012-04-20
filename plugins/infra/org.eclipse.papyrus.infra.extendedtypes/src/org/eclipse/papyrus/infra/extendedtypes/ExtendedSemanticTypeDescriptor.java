package org.eclipse.papyrus.infra.extendedtypes;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.types.ExtendedHintedTypeFactory;
import org.osgi.framework.Bundle;


/**
 * new descriptor implementation for on-the-fly added descriptor
 */
public class ExtendedSemanticTypeDescriptor implements ISpecializationTypeDescriptor {

	/** constant for specific semantic hint */
	public static final String EXTENDED_ELEMENTS = "ExtendedElements";

	/** configuration of this descriptor */
	private final ExtendedElementTypeConfiguration configuration;

	/** cache of the specialized types */
	private List<IElementType> specializedTypes = null;

	/**
	 * Constructor.
	 * 
	 * @param configuration
	 *        the configuration of this descriptor
	 */
	public ExtendedSemanticTypeDescriptor(ExtendedElementTypeConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Returns the configuration of the element type
	 * 
	 * @return the configuration of the element type
	 */
	public ExtendedElementTypeConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return configuration.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	public URL getIconURL() {
		IconEntry entry = configuration.getIconEntry();
		Bundle bundle = Platform.getBundle(entry.getBundleId());
		if(bundle == null) {
			return null;
		}
		URL result = bundle.getEntry(entry.getIconPath());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return configuration.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getKindName() {
		return configuration.getKindName();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getParamValue(String paramName) {
		if(ExtendedHintedTypeFactory.SEMANTIC_HINT_PARAM_NAME.equals(paramName)) {
			return configuration.getHint();
		}
		return EXTENDED_ELEMENTS;
	}

	/**
	 * {@inheritDoc}
	 */
	public IContainerDescriptor getContainerDescriptor() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IElementType[] getSpecializedTypes() {
		if(specializedTypes == null) {
			specializedTypes = new ArrayList<IElementType>();
			for(String specializedTypeId : configuration.getSpecializedTypesID()) {
				IElementType type = ElementTypeRegistry.getInstance().getType(specializedTypeId);
				if(type != null) {
					specializedTypes.add(type);
				} else {
					Activator.log.error("Impossible to find the type " + specializedTypeId, null);
				}
			}
		}
		return specializedTypes.toArray(new IElementType[specializedTypes.size()]);
	}

	/**
	 * {@inheritDoc}
	 */
	public IElementMatcher getMatcher() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IEditHelperAdvice getEditHelperAdvice() {
		return new ExtendedEditHelperAdvice();
	}

}
