package org.jvnet.ogc.gml.v_3_1_1.jts;

import jakarta.xml.bind.JAXBElement;

import org.jvnet.ogc.gml.v_3_1_1.ObjectFactoryInterface;
import org.locationtech.jts.geom.Point;

import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.PointPropertyType;
import net.opengis.gml.v_3_1_1.PointType;

public class JTSToGML311PointConverter extends AbstractJTSToGML311Converter<PointType, PointPropertyType, Point> {
  private final JTSToGML311CoordinateConverter coordinateConverter;

  public JTSToGML311PointConverter(
      ObjectFactoryInterface objectFactory,
      JTSToGML311SRSReferenceGroupConverterInterface srsReferenceGroupConverter,
      JTSToGML311CoordinateConverter coordinateConverter) {
    super(objectFactory, srsReferenceGroupConverter);
    this.coordinateConverter = coordinateConverter;
  }

  @Override
  protected PointType doCreateGeometryType(Point point) {

    final PointType resultPoint = getObjectFactory().createPointType();

    if (!point.isEmpty()) {
      final DirectPositionType directPosition = coordinateConverter.convertCoordinate(point.getCoordinate());
      resultPoint.setPos(directPosition);
    }
    return resultPoint;
  }

  public PointPropertyType createPropertyType(Point point) {
    final PointPropertyType pointPropertyType = getObjectFactory().createPointPropertyType();
    pointPropertyType.setPoint(createGeometryType(point));
    return pointPropertyType;
  }

  public JAXBElement<PointType> createElement(Point point) {
    return getObjectFactory().createPoint(createGeometryType(point));
  }
}
