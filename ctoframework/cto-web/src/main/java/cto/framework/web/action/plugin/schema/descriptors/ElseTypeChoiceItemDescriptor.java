/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.web.action.plugin.schema.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import cto.framework.web.action.plugin.schema.ElseTypeChoiceItem;

/**
 * Class ElseTypeChoiceItemDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ElseTypeChoiceItemDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

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

    public ElseTypeChoiceItemDescriptor() {
        super();
        _nsURI = "http://www.w3school.com.cn";
        _elementDefinition = false;

        //-- set grouping compositor
        setCompositorAsChoice();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _ifElseIfGroupList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.IfElseIfGroup.class, "_ifElseIfGroupList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getIfElseIfGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.addIfElseIfGroup( (cto.framework.web.action.plugin.schema.IfElseIfGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.removeAllIfElseIfGroup();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.IfElseIfGroup();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.web.action.plugin.schema.IfElseIfGroup");
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new cto.framework.web.action.plugin.schema.descriptors.IfElseIfGroupDescriptor());
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _ifElseIfGroupList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _tryCatchFinallyGroupList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.TryCatchFinallyGroup.class, "_tryCatchFinallyGroupList", "-error-if-this-is-used-", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getTryCatchFinallyGroup();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.addTryCatchFinallyGroup( (cto.framework.web.action.plugin.schema.TryCatchFinallyGroup) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.removeAllTryCatchFinallyGroup();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.TryCatchFinallyGroup();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("cto.framework.web.action.plugin.schema.TryCatchFinallyGroup");
        desc.setHandler(handler);
        desc.setContainer(true);
        desc.setClassDescriptor(new cto.framework.web.action.plugin.schema.descriptors.TryCatchFinallyGroupDescriptor());
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _tryCatchFinallyGroupList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _log
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.Log.class, "_log", "Log", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getLog();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setLog( (cto.framework.web.action.plugin.schema.Log) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.Log();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.Log");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _log
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _for
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.For.class, "_for", "For", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getFor();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setFor( (cto.framework.web.action.plugin.schema.For) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.For();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.For");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _for
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _return
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.Return.class, "_return", "Return", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getReturn();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setReturn( (cto.framework.web.action.plugin.schema.Return) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.Return();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.Return");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _return
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _setValue
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.SetValue.class, "_setValue", "SetValue", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getSetValue();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setSetValue( (cto.framework.web.action.plugin.schema.SetValue) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.SetValue();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.SetValue");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _setValue
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _out
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.Out.class, "_out", "Out", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getOut();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setOut( (cto.framework.web.action.plugin.schema.Out) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.Out();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.Out");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _out
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _call
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.Call.class, "_call", "Call", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getCall();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setCall( (cto.framework.web.action.plugin.schema.Call) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.Call();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.Call");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _call
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _httpClient
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.HttpClient.class, "_httpClient", "HttpClient", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getHttpClient();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setHttpClient( (cto.framework.web.action.plugin.schema.HttpClient) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.HttpClient();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.HttpClient");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _httpClient
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _bean
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.Bean.class, "_bean", "Bean", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getBean();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setBean( (cto.framework.web.action.plugin.schema.Bean) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.Bean();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.Bean");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _bean
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _invoke
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.Invoke.class, "_invoke", "Invoke", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getInvoke();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setInvoke( (cto.framework.web.action.plugin.schema.Invoke) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.Invoke();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.Invoke");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _invoke
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _setRequest
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.SetRequest.class, "_setRequest", "SetRequest", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getSetRequest();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setSetRequest( (cto.framework.web.action.plugin.schema.SetRequest) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.SetRequest();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.SetRequest");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _setRequest
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _setSession
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.SetSession.class, "_setSession", "SetSession", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getSetSession();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setSetSession( (cto.framework.web.action.plugin.schema.SetSession) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.SetSession();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.SetSession");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _setSession
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _setApplication
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.SetApplication.class, "_setApplication", "SetApplication", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getSetApplication();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setSetApplication( (cto.framework.web.action.plugin.schema.SetApplication) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.SetApplication();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.SetApplication");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _setApplication
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _outResponse
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.OutResponse.class, "_outResponse", "OutResponse", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getOutResponse();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setOutResponse( (cto.framework.web.action.plugin.schema.OutResponse) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.OutResponse();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.OutResponse");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _outResponse
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _hadoopUtil
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(cto.framework.web.action.plugin.schema.HadoopUtil.class, "_hadoopUtil", "HadoopUtil", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                return target.getHadoopUtil();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ElseTypeChoiceItem target = (ElseTypeChoiceItem) object;
                    target.setHadoopUtil( (cto.framework.web.action.plugin.schema.HadoopUtil) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new cto.framework.web.action.plugin.schema.HadoopUtil();
            }
        };
        desc.setSchemaType("cto.framework.web.action.plugin.schema.HadoopUtil");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.w3school.com.cn");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _hadoopUtil
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
        return cto.framework.web.action.plugin.schema.ElseTypeChoiceItem.class;
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
