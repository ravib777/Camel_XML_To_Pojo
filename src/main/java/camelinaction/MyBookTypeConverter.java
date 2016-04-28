package camelinaction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.FallbackConverter;
import org.apache.camel.TypeConverter;

@Converter
public class MyBookTypeConverter implements TypeConverter {

	@FallbackConverter
	public <T> T convertTo(Class<T> type, Object value) {

		
		Book book = (Book) value;
		return (T) book;
	}

	@Override
	public <T> T convertTo(final Class<T> type, final Exchange exchange, final Object value) {

		
		JAXBContext jaxbContext;
		Book book=null;
		try {
			jaxbContext = JAXBContext.newInstance(Book.class);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(new String((byte [])value));
		 book= (Book) unmarshaller.unmarshal(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) book;

	}

	@Override
	public <T> T mandatoryConvertTo(final Class<T> type, final Object value) {
		
		return convertTo(type, null, value);

	}

	@Override
	public <T> T tryConvertTo(Class<T> type, Exchange message, Object value) {
		
		return null;
	}

	@Override
	public <T> T tryConvertTo(Class<T> type, Object value) {
		Book book = (Book) value;
		
		return (T) book;
	}

	@Override
	public <T> T mandatoryConvertTo(final Class<T> type, final Exchange exchange, final Object value) {
		
		return convertTo(type, null, value);
	}

	public boolean allowNull() {
		return true;
	}

}
