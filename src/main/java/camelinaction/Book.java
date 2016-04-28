package camelinaction;

import  javax.xml.bind.annotation.*;
@XmlRootElement
public class Book{


String title;

float price;

String lang;
@XmlElement()
public void setTitle(String title)
{
this.title=title;
}

public void setLang(String lang)
{
this.lang=lang;
}

public void setPrice(float price)
{
this.price=price;
}

public String getTitle()
{
return title;
}

@XmlAttribute()
public String getLang()
{
return lang;
}

public float getPrice()
{
return price;
}

@Override
public String toString() {
	return "Book [title=" + title + ", price=" + price + ", lang=" + lang + "]";
}


}
