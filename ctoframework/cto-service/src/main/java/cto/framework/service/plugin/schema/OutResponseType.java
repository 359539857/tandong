/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3-RC1</a>, using an
 * XML Schema.
 * $Id$
 */

package cto.framework.service.plugin.schema;

/**
 * Class OutResponseType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutResponseType implements java.io.Serializable {

    /**
     * Field _contentType.
     */
    private java.lang.String _contentType;

    /**
     * Field _characterEncoding.
     */
    private java.lang.String _characterEncoding;

    /**
     * Field _status.
     */
    private int _status;

    /**
     * keeps track of state for field: _status
     */
    private boolean _has_status;

    /**
     * Field _contentLength.
     */
    private int _contentLength;

    /**
     * keeps track of state for field: _contentLength
     */
    private boolean _has_contentLength;

    /**
     * Field _bufferSize.
     */
    private int _bufferSize;

    /**
     * keeps track of state for field: _bufferSize
     */
    private boolean _has_bufferSize;

    /**
     * Field _outputId.
     */
    private java.lang.String _outputId;

    /**
     * Field _headerList.
     */
    private java.util.List<cto.framework.service.plugin.schema.Header> _headerList;

    public OutResponseType() {
        super();
        this._headerList = new java.util.ArrayList<cto.framework.service.plugin.schema.Header>();
    }

    /**
     * 
     * 
     * @param vHeader
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHeader(final cto.framework.service.plugin.schema.Header vHeader) throws java.lang.IndexOutOfBoundsException {
        this._headerList.add(vHeader);
    }

    /**
     * 
     * 
     * @param index
     * @param vHeader
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHeader(final int index,final cto.framework.service.plugin.schema.Header vHeader) throws java.lang.IndexOutOfBoundsException {
        this._headerList.add(index, vHeader);
    }

    /**
     */
    public void deleteBufferSize() {
        this._has_bufferSize= false;
    }

    /**
     */
    public void deleteContentLength() {
        this._has_contentLength= false;
    }

    /**
     */
    public void deleteStatus() {
        this._has_status= false;
    }

    /**
     * Method enumerateHeader.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends cto.framework.service.plugin.schema.Header> enumerateHeader() {
        return java.util.Collections.enumeration(this._headerList);
    }

    /**
     * Returns the value of field 'bufferSize'.
     * 
     * @return the value of field 'BufferSize'.
     */
    public int getBufferSize() {
        return this._bufferSize;
    }

    /**
     * Returns the value of field 'characterEncoding'.
     * 
     * @return the value of field 'CharacterEncoding'.
     */
    public java.lang.String getCharacterEncoding() {
        return this._characterEncoding;
    }

    /**
     * Returns the value of field 'contentLength'.
     * 
     * @return the value of field 'ContentLength'.
     */
    public int getContentLength() {
        return this._contentLength;
    }

    /**
     * Returns the value of field 'contentType'.
     * 
     * @return the value of field 'ContentType'.
     */
    public java.lang.String getContentType() {
        return this._contentType;
    }

    /**
     * Method getHeader.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * cto.framework.service.plugin.schema.Header at the given index
     */
    public cto.framework.service.plugin.schema.Header getHeader(final int index) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._headerList.size()) {
            throw new IndexOutOfBoundsException("getHeader: Index value '" + index + "' not in range [0.." + (this._headerList.size() - 1) + "]");
        }

        return _headerList.get(index);
    }

    /**
     * Method getHeader.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public cto.framework.service.plugin.schema.Header[] getHeader() {
        cto.framework.service.plugin.schema.Header[] array = new cto.framework.service.plugin.schema.Header[0];
        return this._headerList.toArray(array);
    }

    /**
     * Method getHeaderCount.
     * 
     * @return the size of this collection
     */
    public int getHeaderCount() {
        return this._headerList.size();
    }

    /**
     * Returns the value of field 'outputId'.
     * 
     * @return the value of field 'OutputId'.
     */
    public java.lang.String getOutputId() {
        return this._outputId;
    }

    /**
     * Returns the value of field 'status'.
     * 
     * @return the value of field 'Status'.
     */
    public int getStatus() {
        return this._status;
    }

    /**
     * Method hasBufferSize.
     * 
     * @return true if at least one BufferSize has been added
     */
    public boolean hasBufferSize() {
        return this._has_bufferSize;
    }

    /**
     * Method hasContentLength.
     * 
     * @return true if at least one ContentLength has been added
     */
    public boolean hasContentLength() {
        return this._has_contentLength;
    }

    /**
     * Method hasStatus.
     * 
     * @return true if at least one Status has been added
     */
    public boolean hasStatus() {
        return this._has_status;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid() {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Method iterateHeader.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends cto.framework.service.plugin.schema.Header> iterateHeader() {
        return this._headerList.iterator();
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(final java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(final org.xml.sax.ContentHandler handler) throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllHeader() {
        this._headerList.clear();
    }

    /**
     * Method removeHeader.
     * 
     * @param vHeader
     * @return true if the object was removed from the collection.
     */
    public boolean removeHeader(final cto.framework.service.plugin.schema.Header vHeader) {
        boolean removed = _headerList.remove(vHeader);
        return removed;
    }

    /**
     * Method removeHeaderAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public cto.framework.service.plugin.schema.Header removeHeaderAt(final int index) {
        java.lang.Object obj = this._headerList.remove(index);
        return (cto.framework.service.plugin.schema.Header) obj;
    }

    /**
     * Sets the value of field 'bufferSize'.
     * 
     * @param bufferSize the value of field 'bufferSize'.
     */
    public void setBufferSize(final int bufferSize) {
        this._bufferSize = bufferSize;
        this._has_bufferSize = true;
    }

    /**
     * Sets the value of field 'characterEncoding'.
     * 
     * @param characterEncoding the value of field
     * 'characterEncoding'.
     */
    public void setCharacterEncoding(final java.lang.String characterEncoding) {
        this._characterEncoding = characterEncoding;
    }

    /**
     * Sets the value of field 'contentLength'.
     * 
     * @param contentLength the value of field 'contentLength'.
     */
    public void setContentLength(final int contentLength) {
        this._contentLength = contentLength;
        this._has_contentLength = true;
    }

    /**
     * Sets the value of field 'contentType'.
     * 
     * @param contentType the value of field 'contentType'.
     */
    public void setContentType(final java.lang.String contentType) {
        this._contentType = contentType;
    }

    /**
     * 
     * 
     * @param index
     * @param vHeader
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHeader(final int index,final cto.framework.service.plugin.schema.Header vHeader) throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._headerList.size()) {
            throw new IndexOutOfBoundsException("setHeader: Index value '" + index + "' not in range [0.." + (this._headerList.size() - 1) + "]");
        }

        this._headerList.set(index, vHeader);
    }

    /**
     * 
     * 
     * @param vHeaderArray
     */
    public void setHeader(final cto.framework.service.plugin.schema.Header[] vHeaderArray) {
        //-- copy array
        _headerList.clear();

        for (int i = 0; i < vHeaderArray.length; i++) {
                this._headerList.add(vHeaderArray[i]);
        }
    }

    /**
     * Sets the value of field 'outputId'.
     * 
     * @param outputId the value of field 'outputId'.
     */
    public void setOutputId(final java.lang.String outputId) {
        this._outputId = outputId;
    }

    /**
     * Sets the value of field 'status'.
     * 
     * @param status the value of field 'status'.
     */
    public void setStatus(final int status) {
        this._status = status;
        this._has_status = true;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * cto.framework.service.plugin.schema.OutResponseType
     */
    public static cto.framework.service.plugin.schema.OutResponseType unmarshal(final java.io.Reader reader) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (cto.framework.service.plugin.schema.OutResponseType) org.exolab.castor.xml.Unmarshaller.unmarshal(cto.framework.service.plugin.schema.OutResponseType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate() throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
