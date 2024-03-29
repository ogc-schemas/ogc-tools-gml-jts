package org.jvnet.ogc.gml.v_3_1_1.jts;

import java.util.LinkedList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;

import org.jvnet.jaxb.locator.ObjectLocator;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;

import net.opengis.gml.v_3_1_1.CoordType;
import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.LinearRingPropertyType;
import net.opengis.gml.v_3_1_1.LinearRingType;
import net.opengis.gml.v_3_1_1.PointPropertyType;
import net.opengis.gml.v_3_1_1.PointType;

public class GML311ToJTSLinearRingConverter
    extends AbstractGML311ToJTSConverter<LinearRingType, LinearRingPropertyType, LinearRing> {

  // + LinearRing

  private final GML311ToJTSCoordinateConverter coordinateConverter;
  private final GML311ToJTSConverterInterface<PointType, PointPropertyType, Point> pointConverter;

  public GML311ToJTSLinearRingConverter(
      GeometryFactory geometryFactory,
      GML311ToJTSSRIDConverterInterface sridConverter,
      GML311ToJTSCoordinateConverter coordinateConverter,
      GML311ToJTSConverterInterface<PointType, PointPropertyType, Point> pointConverter) {
    super(geometryFactory, sridConverter);
    this.coordinateConverter = new GML311ToJTSCoordinateConverter();
    this.pointConverter = pointConverter;
  }

  @Override
  protected LinearRing doCreateGeometry(ObjectLocator locator,
                                        LinearRingType linearRingType) throws ConversionFailedException {
    if (linearRingType.isSetPosOrPointPropertyOrPointRep()) {
      final ObjectLocator fieldLocator = locator
          .property("posOrPointPropertyOrPointRep", linearRingType.getPosOrPointPropertyOrPointRep()); //$NON-NLS-1$

      final List<Coordinate> coordinates = new LinkedList<Coordinate>();
      for (int index = 0; index < linearRingType.getPosOrPointPropertyOrPointRep().size(); index++) {
        final JAXBElement<?> item = linearRingType.getPosOrPointPropertyOrPointRep().get(index);
        final ObjectLocator itemLocator = fieldLocator.item(index, item);
        final Object value = item.getValue();
        final ObjectLocator itemValueLocator = itemLocator.property("value", value); //$NON-NLS-1$

        if (value instanceof DirectPositionType) {
          coordinates.add(coordinateConverter.createCoordinate(itemValueLocator, (DirectPositionType) value));
        } else if (value instanceof PointType) {
          coordinates.add(pointConverter.createGeometry(itemValueLocator, (PointType) value).getCoordinate());
        } else if (value instanceof PointPropertyType) {
          coordinates.add(pointConverter.createGeometry(itemValueLocator, (PointPropertyType) value).getCoordinate());
        } else if (value instanceof CoordType) {
          coordinates.add(coordinateConverter.createCoordinate(itemValueLocator, (CoordType) value));
        } else {
          throw new ConversionFailedException(itemValueLocator, "Unexpected type."); //$NON-NLS-1$
        }
      }
      final Coordinate[] coordinatesArray = coordinates.toArray(new Coordinate[0]);
      return getGeometryFactory().createLinearRing(coordinatesArray);
    } else if (linearRingType.isSetPosList()) {
      final Coordinate[] coordinates = coordinateConverter
          .createCoordinates(
              locator.property("posList", linearRingType.getPosList()), linearRingType.getPosList()); //$NON-NLS-1$
      return getGeometryFactory().createLinearRing(coordinates);
    } else if (linearRingType.isSetCoordinates()) {
      final Coordinate[] coordinates = coordinateConverter.createCoordinates(
          locator.property("coordinates", linearRingType.getCoordinates()), linearRingType.getCoordinates()); //$NON-NLS-1$
      return getGeometryFactory().createLinearRing(coordinates);
    } else {
      throw new ConversionFailedException(locator);
    }
  }

  public LinearRing createGeometry(ObjectLocator locator, LinearRingPropertyType linearRingPropertyType)
      throws ConversionFailedException {
    if (linearRingPropertyType.isSetLinearRing()) {
      return createGeometry(
          locator.property("linearRing", linearRingPropertyType.getLinearRing()), linearRingPropertyType.getLinearRing()); //$NON-NLS-1$
    } else {
      throw new ConversionFailedException(locator, "Expected [LinearRing] element."); //$NON-NLS-1$
    }
  }
}
