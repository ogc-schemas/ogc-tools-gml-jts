package org.jvnet.ogc.gml.v_3_1_1.jts;

import jakarta.xml.bind.JAXBElement;

import org.jvnet.ogc.gml.v_3_1_1.ObjectFactoryInterface;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import net.opengis.gml.v_3_1_1.AbstractRingPropertyType;
import net.opengis.gml.v_3_1_1.LinearRingType;
import net.opengis.gml.v_3_1_1.PolygonPropertyType;
import net.opengis.gml.v_3_1_1.PolygonType;

public class JTSToGML311PolygonConverter extends AbstractJTSToGML311Converter<PolygonType, PolygonPropertyType, Polygon> {
  private final JTSToGML311ConverterInterface<LinearRingType, AbstractRingPropertyType, LinearRing> linearRingConverter;

  public JTSToGML311PolygonConverter(
      ObjectFactoryInterface objectFactory,
      JTSToGML311SRSReferenceGroupConverterInterface srsReferenceGroupConverter,
      JTSToGML311ConverterInterface<LinearRingType, AbstractRingPropertyType, LinearRing> linearRingConverter) {
    super(objectFactory, srsReferenceGroupConverter);
    this.linearRingConverter = linearRingConverter;
  }

  @Override
  protected PolygonType doCreateGeometryType(Polygon polygon) {
    final PolygonType resultPolygon = getObjectFactory().createPolygonType();
    {
      final LinearRing exteriorRing = polygon.getExteriorRing();
      final AbstractRingPropertyType abstractRingProperty = linearRingConverter.createPropertyType(exteriorRing);
      resultPolygon.setExterior(getObjectFactory().createExterior(abstractRingProperty));
    }
    for (int index = 0; index < polygon.getNumInteriorRing(); index++) {
      final LinearRing interiorRing = polygon.getInteriorRingN(index);
      resultPolygon.getInterior().add(getObjectFactory().createInterior(linearRingConverter.createPropertyType(interiorRing)));
    }
    return resultPolygon;
  }

  public PolygonPropertyType createPropertyType(Polygon polygon) {
    final PolygonPropertyType polygonPropertyType = getObjectFactory().createPolygonPropertyType();
    polygonPropertyType.setPolygon(createGeometryType(polygon));
    return polygonPropertyType;
  }

  public JAXBElement<PolygonType> createElement(Polygon polygon) {
    return getObjectFactory().createPolygon(createGeometryType(polygon));
  }
}
