package org.jvnet.ogc.gml.v_3_1_1.jts;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.text.MessageFormat;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.JAXBIntrospector;
import jakarta.xml.bind.PropertyException;
import jakarta.xml.bind.UnmarshallerHandler;
import jakarta.xml.bind.ValidationEventHandler;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.attachment.AttachmentUnmarshaller;

import org.jvnet.jaxb.locator.DefaultRootObjectLocator;
import org.locationtech.jts.geom.Geometry;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import net.opengis.gml.v_3_1_1.AbstractGeometryType;

public class UnmarshallerImpl implements jakarta.xml.bind.Unmarshaller {

  private final jakarta.xml.bind.Unmarshaller unmarshaller;
  private final GML311ToJTSConverterInterface<AbstractGeometryType, Object, Geometry> converter;

  public UnmarshallerImpl(
      jakarta.xml.bind.Unmarshaller unmarshaller,
      GML311ToJTSConverterInterface<AbstractGeometryType, Object, Geometry> converter) {
    this.unmarshaller = unmarshaller;
    this.converter = converter;
  }

  public jakarta.xml.bind.Unmarshaller getUnmarshaller() {
    return unmarshaller;
  }

  public GML311ToJTSConverterInterface<AbstractGeometryType, Object, Geometry> getConverter() {
    return converter;
  }

  protected Geometry convert(Object element) throws JAXBException {

    Object value = JAXBIntrospector.getValue(element);

    try {
      return getConverter().createGeometry(new DefaultRootObjectLocator(value), value);
    } catch (ConversionFailedException cfex) {
      throw new JAXBException("Could not convert the geometry into a JAXB element.", cfex);
    }
  }

  protected <T> JAXBElement<T> convert(Object element, Class<T> declaredType) throws JAXBException {
    if (element == null) {
      return null;
    }
    if (element instanceof JAXBElement) {
      final Geometry geometry = convert(element);
      if (declaredType.isAssignableFrom(geometry.getClass())) {
        @SuppressWarnings("unchecked") final T value = (T) geometry;
        return new JAXBElement<T>(((JAXBElement<?>) element).getName(), declaredType, value);
      } else {
        throw new JAXBException(
            MessageFormat
                .format(
                    "Geometry class [{0}] does not match expected class [0].",
                    element.getClass().getName(),
                    JAXBElement.class.getName()));
      }
    } else {
      throw new JAXBException(
          MessageFormat.format(
              "Unmarshalled class [{0}] is not an instance of [{1}].",
              element.getClass().getName(),
              JAXBElement.class.getName()));
    }
  }

  public Object unmarshal(File f) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(f));
  }

  public Object unmarshal(InputStream is) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(is));
  }

  public Object unmarshal(Reader reader) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(reader));
  }

  public Object unmarshal(URL url) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(url));
  }

  public Object unmarshal(InputSource source) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(source));
  }

  public Object unmarshal(Node node) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(node));
  }

  public <T> JAXBElement<T> unmarshal(Node node, Class<T> declaredType) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(node), declaredType);
  }

  public Object unmarshal(Source source) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(source));
  }

  public <T> JAXBElement<T> unmarshal(Source source, Class<T> declaredType) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(source), declaredType);
  }

  public Object unmarshal(XMLStreamReader reader) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(reader));
  }

  public <T> JAXBElement<T> unmarshal(XMLStreamReader reader, Class<T> declaredType) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(reader), declaredType);
  }

  public Object unmarshal(XMLEventReader reader) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(reader));
  }

  public <T> JAXBElement<T> unmarshal(XMLEventReader reader, Class<T> declaredType) throws JAXBException {
    return convert(getUnmarshaller().unmarshal(reader), declaredType);
  }

  public UnmarshallerHandler getUnmarshallerHandler() {
    return getUnmarshaller().getUnmarshallerHandler();
  }

  @SuppressWarnings("deprecation")
  public void setValidating(boolean validating) throws JAXBException {
    getUnmarshaller().setValidating(validating);
  }

  @SuppressWarnings("deprecation")
  public boolean isValidating() throws JAXBException {
    return getUnmarshaller().isValidating();
  }

  public void setEventHandler(ValidationEventHandler handler) throws JAXBException {
    getUnmarshaller().setEventHandler(handler);
  }

  public ValidationEventHandler getEventHandler() throws JAXBException {
    return getUnmarshaller().getEventHandler();
  }

  public void setProperty(String name, Object value) throws PropertyException {
    getUnmarshaller().setProperty(name, value);
  }

  public Object getProperty(String name) throws PropertyException {
    return getUnmarshaller().getProperty(name);
  }

  public void setSchema(Schema schema) {
    getUnmarshaller().setSchema(schema);
  }

  public Schema getSchema() {
    return getUnmarshaller().getSchema();
  }

  public void setAdapter(@SuppressWarnings("rawtypes") XmlAdapter adapter) {
    getUnmarshaller().setAdapter(adapter);
  }

  @SuppressWarnings("rawtypes")
  public <A extends XmlAdapter> void setAdapter(Class<A> type, A adapter) {
    getUnmarshaller().setAdapter(type, adapter);
  }

  @SuppressWarnings("rawtypes")
  public <A extends XmlAdapter> A getAdapter(Class<A> type) {
    return getAdapter(type);
  }

  public void setAttachmentUnmarshaller(AttachmentUnmarshaller au) {
    getUnmarshaller().setAttachmentUnmarshaller(au);
  }

  public AttachmentUnmarshaller getAttachmentUnmarshaller() {
    return getUnmarshaller().getAttachmentUnmarshaller();
  }

  public void setListener(Listener listener) {
    getUnmarshaller().setListener(listener);
  }

  public Listener getListener() {
    return getUnmarshaller().getListener();
  }
}
