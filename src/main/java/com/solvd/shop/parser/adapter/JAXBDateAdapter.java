package com.solvd.shop.parser.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class JAXBDateAdapter extends XmlAdapter<String, Date> {
    private static final ThreadLocal<DateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    @Override
    public Date unmarshal(String v) throws ParseException {
        java.util.Date utilDate = dateFormat.get().parse(v);
        return new Date(utilDate.getTime());
    }

    @Override
    public String marshal(Date v) {
        java.util.Date utilDate = new java.util.Date(v.getTime());
        return dateFormat.get().format(utilDate);
    }
}
