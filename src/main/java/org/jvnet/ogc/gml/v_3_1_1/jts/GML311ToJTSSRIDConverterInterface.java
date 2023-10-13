package org.jvnet.ogc.gml.v_3_1_1.jts;

import org.jvnet.jaxb.locator.ObjectLocator;
import org.locationtech.jts.geom.Geometry;

import net.opengis.gml.v_3_1_1.AbstractGeometryType;

public interface GML311ToJTSSRIDConverterInterface {

  void convert(ObjectLocator locator, AbstractGeometryType source, Geometry target) throws ConversionFailedException;

}
