package org.jvnet.ogc.gml.v_3_1_1.jts;

import jakarta.xml.bind.JAXBElement;

import org.jvnet.ogc.gml.v_3_1_1.ObjectFactoryInterface;
import org.locationtech.jts.geom.LinearRing;

import net.opengis.gml.v_3_1_1.AbstractRingPropertyType;
import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.LinearRingType;

public class JTSToGML311LinearRingConverter
    extends    AbstractJTSToGML311Converter<LinearRingType, AbstractRingPropertyType, LinearRing> {
  private final JTSToGML311CoordinateConverter coordinateConverter;

  public JTSToGML311LinearRingConverter(
      ObjectFactoryInterface objectFactory,
      JTSToGML311SRSReferenceGroupConverterInterface srsReferenceGroupConverter,
      JTSToGML311CoordinateConverter coordinateConverter) {
    super(objectFactory, srsReferenceGroupConverter);
    this.coordinateConverter = coordinateConverter;
  }

  @Override
  protected LinearRingType doCreateGeometryType(LinearRing linearRing) {
    final LinearRingType resultLinearRing = getObjectFactory().createLinearRingType();

    for (DirectPositionType directPosition : coordinateConverter.convertCoordinates(linearRing.getCoordinates())) {
      final JAXBElement<DirectPositionType> pos = getObjectFactory().createPos(directPosition);
      resultLinearRing.getPosOrPointPropertyOrPointRep().add(pos);
    }
    return resultLinearRing;
  }

  public AbstractRingPropertyType createPropertyType(final LinearRing ring) {
    final AbstractRingPropertyType abstractRingProperty = getObjectFactory().createAbstractRingPropertyType();
    abstractRingProperty.setRing(getObjectFactory().createLinearRing(createGeometryType(ring)));
    return abstractRingProperty;
  }

  public JAXBElement<LinearRingType> createElement(LinearRing linearRing) {
    return getObjectFactory().createLinearRing(createGeometryType(linearRing));
  }
}
