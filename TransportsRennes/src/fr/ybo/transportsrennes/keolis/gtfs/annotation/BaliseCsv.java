package fr.ybo.transportsrennes.keolis.gtfs.annotation;

import fr.ybo.transportsrennes.keolis.gtfs.moteur.adapter.AdapterCsv;
import fr.ybo.transportsrennes.keolis.gtfs.moteur.adapter.AdapterString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BaliseCsv {

	Class<? extends AdapterCsv<?>> adapter() default AdapterString.class;

	String value();
}