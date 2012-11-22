/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.schema.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import cto.framework.service.schema.ServiceBusConfigType;

/**
 * Class ServiceBusConfigTypeDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ServiceBusConfigTypeDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

    /**
     * Field _elementDefinition.
     */
    private boolean _elementDefinition;

    /**
     * Field _nsPrefix.
     */
    private java.lang.String _nsPrefix;

    /**
     * Field _nsURI.
     */
    private java.lang.String _nsURI;

    /**
     * Field _xmlName.
     */
    private java.lang.String _xmlName;

    /**
     * Field _identity.
     */
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;

    public ServiceBusConfigTypeDescriptor() {
        super();
        _nsURI = "http://www.w3school.com.cn";
        _xmlName = "ServiceBusConfigType";
        _elementDefinition = false;

        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- _defaultUseCacheGroup
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_defaultUseCacheGroup", "DefaultUseCacheGroup", org.exolab.castor.xml.NodeType.Attribute);
        desc.setImmutable(true);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getDefaultUseCacheGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.setDefaultUseCacheGroup( (java.lang.String) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("string");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _defaultUseCacheGroup
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
            org.exolab.castor.xml.validators.StringValidator typeValidator;
            typeValidator = new org.exolab.castor.xml.validators.StringValidator();
            fieldValidator.setValidator(typeValidator);
            typeValidator.setWhiteSpace("preserve");
        }
        desc.setValidator(fieldValidator);
        //-- _defaultUseHadoopGroup
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.String.class, "_defaultUseHadoopGroup", "DefaultUseHadoopGroup", org.exolab.castor.xml.NodeType.Attribute);
        desc.setImmutable(true);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getDefaultUseHadoopGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.setDefaultUseHadoopGroup( (java.lang.String) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("string");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _defaultUseHadoopGroup
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
            org.exolab.castor.xml.validators.StringValidator typeValidator;
            typeValidator = new org.exolab.castor.xml.validators.StringValidator();
            fieldValidator.setValidator(typeValidator);
            typeValidator.setWhiteSpace("preserve");
        }
        desc.setValidator(fieldValidator);
        //-- _serviceListenerIntervalTime
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(java.lang.Long.TYPE, "_serviceListenerIntervalTime", "ServiceListenerIntervalTime", org.exolab.castor.xml.NodeType.Attribute);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                if (!target.hasServiceListenerIntervalTime()) { return null; }
                return new java.lang.Long(target.getServiceListenerIntervalTime());
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    // if null, use delete method for optional primitives 
                    if (value == null) {
                        target.deleteServiceListenerIntervalTime();
                        return;
                    }
                    target.setServiceListenerIntervalTime( ((java.lang.Long) value).longValue());
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return null;
            }
        };
        desc.setSchemaType("long");
        desc.setHandler(handler);
        desc.setMultivalued(false);
        addFieldDescriptor(desc);

        //-- validation code for: _serviceListenerIntervalTime
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
            org.exolab.castor.xml.validators.LongValidator typeValidator;
            typeValidator = new org.exolab.castor.xml.validators.LongValidator();
            fieldValidator.setValidator(typeValidator);
            typeValidator.setMinInclusive(-9223372036854775808L);
            typeValidator.setMaxInclusive(9223372036854775807L);
        }
        desc.setValidator(fieldValidator);
        //-- initialize element descriptors

        //-- _importResourceList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.schema.ImportResource.class, "_importResourceList", "ImportResource", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getImportResource();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.addImportResource( (cto.framework.service.schema.ImportResource) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.removeAllImportResource();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.schema.ImportResource();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.service.schema.ImportResource");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _importResourceList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _parameterList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.schema.Parameter.class, "_parameterList", "Parameter", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getParameter();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.addParameter( (cto.framework.service.schema.Parameter) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.removeAllParameter();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.schema.Parameter();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.service.schema.Parameter");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _parameterList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _systemDataSourceGroup
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.schema.SystemDataSourceGroup.class, "_systemDataSourceGroup", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getSystemDataSourceGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.setSystemDataSourceGroup( (cto.framework.service.schema.SystemDataSourceGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.schema.SystemDataSourceGroup();
            }
        };
        desc.setSchemaType("cto.framework.service.schema.SystemDataSourceGroup");
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new cto.framework.service.schema.descriptors.SystemDataSourceGroupDescriptor());
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _systemDataSourceGroup
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _memCacheServerGroupList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.schema.MemCacheServerGroup.class, "_memCacheServerGroupList", "MemCacheServerGroup", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getMemCacheServerGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.addMemCacheServerGroup( (cto.framework.service.schema.MemCacheServerGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.removeAllMemCacheServerGroup();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.schema.MemCacheServerGroup();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.service.schema.MemCacheServerGroup");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _memCacheServerGroupList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _hadoopServerGroupList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.schema.HadoopServerGroup.class, "_hadoopServerGroupList", "HadoopServerGroup", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getHadoopServerGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.addHadoopServerGroup( (cto.framework.service.schema.HadoopServerGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.removeAllHadoopServerGroup();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.schema.HadoopServerGroup();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.service.schema.HadoopServerGroup");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _hadoopServerGroupList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _servicePluginConfig
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.service.schema.ServicePluginConfig.class, "_servicePluginConfig", "ServicePluginConfig", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ServiceBusConfigType target = (ServiceBusConfigType) object;
                return target.getServicePluginConfig();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ServiceBusConfigType target = (ServiceBusConfigType) object;
                    target.setServicePluginConfig( (cto.framework.service.schema.ServicePluginConfig) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.service.schema.ServicePluginConfig();
            }
        };
        desc.setSchemaType("cto.framework.service.schema.ServicePluginConfig");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _servicePluginConfig
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    }

    /**
     * Method getAccessMode.
     * 
     * @return the access mode specified for this class.
     */
    @Override()
    public org.exolab.castor.mapping.AccessMode getAccessMode() {
        return null;
    }

    /**
     * Method getIdentity.
     * 
     * @return the identity field, null if this class has no
     * identity.
     */
    @Override()
    public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
        return _identity;
    }

    /**
     * Method getJavaClass.
     * 
     * @return the Java class represented by this descriptor.
     */
    @Override()
    public java.lang.Class getJavaClass() {
        return cto.framework.service.schema.ServiceBusConfigType.class;
    }

    /**
     * Method getNameSpacePrefix.
     * 
     * @return the namespace prefix to use when marshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpacePrefix() {
        return _nsPrefix;
    }

    /**
     * Method getNameSpaceURI.
     * 
     * @return the namespace URI used when marshaling and
     * unmarshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpaceURI() {
        return _nsURI;
    }

    /**
     * Method getValidator.
     * 
     * @return a specific validator for the class described by this
     * ClassDescriptor.
     */
    @Override()
    public org.exolab.castor.xml.TypeValidator getValidator() {
        return this;
    }

    /**
     * Method getXMLName.
     * 
     * @return the XML Name for the Class being described.
     */
    @Override()
    public java.lang.String getXMLName() {
        return _xmlName;
    }

    /**
     * Method isElementDefinition.
     * 
     * @return true if XML schema definition of this Class is that
     * of a global
     * element or element with anonymous type definition.
     */
    public boolean isElementDefinition() {
        return _elementDefinition;
    }

}
