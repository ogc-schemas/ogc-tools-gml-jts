package org.jvnet.ogc.gml.v_3_1_1.jts;

import java.util.Map;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import org.jvnet.ogc.gml.v_3_1_1.ObjectFactoryInterface;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import net.opengis.gml.v_3_1_1.AbstractGeometryType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;

public class JAXBContextFactory {

  private static final String PROPERTY_NAME_SRID_CONVERTER =
      GML311ToJTSSRIDConverterInterface.class.getName();
  private static final String PROPERTY_NAME_SRS_REFERENCE_GROUP_CONVERTER =
      JTSToGML311SRSReferenceGroupConverterInterface.class.getName();
  public static final String PROPERTY_NAME_OBJECT_FACTORY =
      ObjectFactoryInterface.class.getName();
  public static final String PROPERTY_NAME_GEOMETRY_FACTORY =
      GeometryFactory.class.getName();

  public static final String PROPERTY_NAME_CONTEXT_PATH =
      JAXBContextFactory.class.getName() + ".CONTEXT_PATH";

  public static final String DEFAULT_CONTEXT_PATH =
      net.opengis.gml.v_3_1_1.ObjectFactory.class.getPackage().getName();

  public static JAXBContext createContext(String contextPath, ClassLoader classLoader, Map<String, Object> properties)
      throws JAXBException {
    final String innerContextPath;

    if (properties.containsKey(PROPERTY_NAME_CONTEXT_PATH)) {
      innerContextPath = (String) properties.get(DEFAULT_CONTEXT_PATH);
    } else {
      innerContextPath = DEFAULT_CONTEXT_PATH;
    }
    final JAXBContext context = JAXBContext.newInstance(innerContextPath, classLoader, properties);

    final ObjectFactoryInterface objectFactory;
    if (properties.containsKey(PROPERTY_NAME_OBJECT_FACTORY)) {
      objectFactory = (ObjectFactoryInterface) properties.get(PROPERTY_NAME_OBJECT_FACTORY);
    } else {
      objectFactory = JTSToGML311Constants.DEFAULT_OBJECT_FACTORY;
    }

    final JTSToGML311SRSReferenceGroupConverterInterface srsReferenceGroupConverter;

    if (properties.containsKey(PROPERTY_NAME_SRS_REFERENCE_GROUP_CONVERTER)) {
      srsReferenceGroupConverter =
          (JTSToGML311SRSReferenceGroupConverterInterface) properties.get(PROPERTY_NAME_SRS_REFERENCE_GROUP_CONVERTER);
    } else {
      srsReferenceGroupConverter = JTSToGML311Constants.DEFAULT_SRS_REFERENCE_GROUP_CONVERTER;
    }
    final JTSToGML311ConverterInterface<AbstractGeometryType, GeometryPropertyType, Geometry> marshallerConverter =
        new JTSToGML311GeometryConverter(objectFactory, srsReferenceGroupConverter);

    final GeometryFactory geometryFactory;
    if (properties.containsKey(PROPERTY_NAME_GEOMETRY_FACTORY)) {
      geometryFactory = (GeometryFactory) properties.get(PROPERTY_NAME_GEOMETRY_FACTORY);
    } else {
      geometryFactory = GML311ToJTSConstants.DEFAULT_GEOMETRY_FACTORY;
    }

    final GML311ToJTSSRIDConverterInterface sridConverter;
    if (properties.containsKey(PROPERTY_NAME_SRID_CONVERTER)) {
      sridConverter = (GML311ToJTSSRIDConverterInterface) properties.get(PROPERTY_NAME_SRID_CONVERTER);

    } else {
      sridConverter = GML311ToJTSConstants.DEFAULT_SRID_CONVERTER;
    }
    final GML311ToJTSConverterInterface<AbstractGeometryType, Object, Geometry> unmarshallerConverter =
        new GML311ToJTSGeometryConverter(geometryFactory, sridConverter);
    return new JAXBContextImpl(context, marshallerConverter, unmarshallerConverter);
  }
}
